package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *  * Clase que contiene métodos para realizar consultas a la base de datos y devolver los resultados en formato de tabla de texto.
 */
public class Consultas {
    private static final DataSource dataSource = new DataSource(DataSource.Driver.POSTGRESQL, "localhost", 5433, "ciclismo", "root", "test");
    private static final Scanner lector = new Scanner(System.in);

    // Actividad 1
    /**
     * Método que lista todos los equipos de la base de datos.
     * @return Tabla de texto con los equipos.
     */
    public static TextTable listarequipos() {
        TextTable tabla = new TextTable("id", "Nombre", "Pais");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM equipos")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("id_equipo"), rs.getString("nombre"), rs.getString("pais"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los equipos"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 2
    /**
     * Muestra los ciclistas de un equipo específico o de todos los equipos.
     * Pide al usuario que introduzca el ID de un equipo. Si el ID es 0, muestra todos los ciclistas.
     * @return TextTable con los ciclistas filtrados y ordenados.
     */
    public static TextTable ciclistasEquipos(int id) {
        TextTable tabla = new TextTable("id_ciclista", "Nombre", "id_Equipo");
        String sql;
        if (id == 0) {
            sql = "SELECT id_ciclista, nombre, id_equipo FROM ciclistas ORDER BY  id_equipo, nombre";
        } else {
            sql = "SELECT id_ciclista, nombre, id_equipo FROM ciclistas WHERE id_equipo = ?";
        }

        try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (id != 0) {
                stmt.setInt(1, id);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("id_ciclista"), rs.getString("nombre"), rs.getString("id_equipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las los ciclistas"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 3.1
    /**
     * Obtiene y muestra un listado de todas las etapas de la competición.
     * @return TextTable con la información de cada etapa.
     */
    public static TextTable listarEtapas() {
        TextTable tabla = new TextTable("id_etapa", "tipo", "fecha", "salida", "llegada", "distancia_km");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id_etapa, tipo, fecha, salida, llegada, distancia_km FROM etapas")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("id_etapa"),
                        rs.getString("tipo"),
                        rs.getString("fecha"),
                        rs.getString("salida"),
                        rs.getString("llegada"),
                        rs.getString("distancia_km"));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las etapas"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 3.2
    /**
     * Muestra un resumen del número de etapas y la suma de kilómetros por cada tipo de etapa.
     * @return TextTable con el resumen de las etapas.
     */
    public static TextTable totalEtapas() {
        TextTable tabla = new TextTable("tipo", "cantdad_etapas", "total_km");
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT tipo, COUNT(*) AS  cantidad_etapas, SUM(distancia_km) AS total_km FROM etapas GROUP BY tipo")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("tipo"),
                        rs.getString("cantidad_etapas"),
                        rs.getString("total_km"));
            }

        } catch (SQLException e) {
            System.out.println("Error al generar total etapas"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 4
    /**
     * Calcula la velocidad media de un ciclista específico.
     * Pide al usuario el ID del ciclista después de mostrar una lista.
     * La velocidad se calcula como la suma total de kilómetros de las etapas dividida por el tiempo total empleado.
     * @return TextTable con el ID, nombre y velocidad media del ciclista.
     */
    public static TextTable velocidadMedia(int idCiclista) {
        TextTable tabla = new TextTable("id_ciclista", "nombre", "velocidad_media_kmh");
        String sql = "SELECT \n" +
                "    c.id_ciclista,\n" +
                "    c.nombre,\n" +
                "    ROUND(\n" +
                "        SUM(e.distancia_km) / (SUM(EXTRACT(EPOCH FROM r.tiempo)) / 3600),\n" +
                "        2\n" +
                "    ) AS velocidad_media_kmh\n" +
                "FROM \n" +
                "    resultados_etapa r\n" +
                "JOIN \n" +
                "    etapas e ON r.id_etapa = e.id_etapa \n" +
                "JOIN \n" +
                "    ciclistas c ON r.id_ciclista = c.id_ciclista\n" +
                "WHERE \n" +
                "    r.id_ciclista = ?\n" +
                "GROUP BY \n" +
                "    c.id_ciclista, c.nombre";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCiclista);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("id_ciclista"), rs.getString("nombre"), rs.getString("velocidad_media_kmh"));
            }

        } catch (SQLException e) {
            System.out.println("Error al generar velocidad media"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 5
    /**
     * Muestra la clasificación de una etapa específica, ordenada por tiempo.
     * Pide al usuario que seleccione el ID de la etapa.
     * @return TextTable con la posición, nombre del ciclista, nombre del equipo y tiempo.
     */
    public static TextTable clasificacionEtapa(int idEtapa) {
        TextTable tabla = new TextTable("posicion", "nombre", "nombre_equipo", "tiempo");
        String sql = "SELECT re.posicion, ci.nombre AS nombre_ciclista, eq.nombre AS nombre_equipo, re.tiempo\n" +
                "FROM resultados_etapa re\n" +
                "JOIN ciclistas ci ON re.id_ciclista = ci.id_ciclista\n" +
                "JOIN equipos eq ON ci.id_equipo = eq.id_equipo\n" +
                "WHERE re.id_etapa = ?\n" +
                "ORDER BY re.tiempo ASC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEtapa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("posicion"),
                        rs.getString("nombre_ciclista"),
                        rs.getString("nombre_equipo"),
                        rs.getString("tiempo"));
            }

        } catch (SQLException e) {
            System.out.println("Error al generar clasificiacion de etapa"+ e.getMessage());
        }
        return tabla;
    }
    // Actividad 6
    /**
     * Calcula y muestra la clasificación de la montaña (maillot de lunares).
     * Suma los puntos obtenidos por cada ciclista en los puertos de montaña.
     * @return TextTable con la posición, nombre del ciclista, nombre del equipo y el total de puntos.
     */
    public static TextTable clasificacionMontana() {
        TextTable tabla = new TextTable("posicion", "nombre_ciclista", "nombre_equipo", "puntos_totales");
        String sql = "SELECT DENSE_RANK() OVER (ORDER BY SUM(rp.puntos) DESC) AS posicion,\n" +
                "       c.nombre  AS nombre_ciclista,\n" +
                "       e.nombre  AS nombre_equipo,\n" +
                "       SUM(rp.puntos) AS puntos_totales\n" +
                "FROM resultados_puerto rp\n" +
                "JOIN ciclistas c ON c.id_ciclista = rp.id_ciclista\n" +
                "JOIN equipos   e ON e.id_equipo   = c.id_equipo\n" +
                "GROUP BY c.id_ciclista, c.nombre, e.nombre\n" +
                "ORDER BY puntos_totales DESC, nombre_ciclista ASC";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("posicion"),
                        rs.getString("nombre_ciclista"),
                        rs.getString("nombre_equipo"),
                        rs.getString("puntos_totales"));
            }

        } catch (SQLException e) {
            System.out.println("Error al generar clasificacion montaña" + e.getMessage());
        }
        return tabla;
    }
    // Actividad 7
    /**
     * Calcula y muestra la clasificación por puntos (regularidad o maillot verde).
     * Suma los puntos obtenidos por cada ciclista en metas volantes y finales de etapa.
     * @return TextTable con la posición, nombre del ciclista, nombre del equipo y el total de puntos.
     */
    public static TextTable clasificacionRegularidad() {
        TextTable tabla = new TextTable("posicion", "nombre_ciclista", "nombre_equipo", "puntos_totales");
        String sql = "SELECT\n" +
                "  RANK() OVER (ORDER BY (COALESCE(pm.puntos_meta, 0) + COALESCE(rs.puntos_sprint, 0)) DESC) AS posicion,\n" +
                "  c.nombre AS nombre_ciclista,\n" +
                "  e.nombre AS nombre_equipo,\n" +
                "  (COALESCE(pm.puntos_meta, 0) + COALESCE(rs.puntos_sprint, 0)) AS puntos_totales\n" +
                "FROM ciclistas c\n" +
                "LEFT JOIN equipos e ON c.id_equipo = e.id_equipo\n" +
                "LEFT JOIN (\n" +
                "  SELECT id_ciclista, SUM(puntos) AS puntos_meta\n" +
                "  FROM puntos_meta\n" +
                "  GROUP BY id_ciclista\n" +
                ") pm ON c.id_ciclista = pm.id_ciclista\n" +
                "LEFT JOIN (\n" +
                "  SELECT id_ciclista, SUM(puntos) AS puntos_sprint\n" +
                "  FROM resultados_sprint\n" +
                "  GROUP BY id_ciclista\n" +
                ") rs ON c.id_ciclista = rs.id_ciclista\n" +
                "ORDER BY puntos_totales DESC;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("posicion"),
                        rs.getString("nombre_ciclista"),
                        rs.getString("nombre_equipo"),
                        rs.getString("puntos_totales"));
            }
        } catch (SQLException e) {
            System.out.println("Error al generar clasificacion de la regularidad" + e.getMessage());
        }
        return tabla;
    }
    // Actividad 8
    /**
     * Calcula y muestra la clasificación general individual por tiempo.
     * Suma los tiempos de cada ciclista en todas las etapas.
     * @return TextTable con la posición, nombre del ciclista, nombre del equipo y el tiempo total acumulado.
     */
    public static TextTable clasificacionGeneral() {
        TextTable tabla = new TextTable("posicion", "nombre_ciclista", "nombre_equipo", "tiempo_total");
        String sql = "SELECT\n" +
                "    RANK() OVER (ORDER BY SUM(r.tiempo)) AS posicion,\n" +
                "    c.nombre AS nombre_ciclista,\n" +
                "    e.nombre AS nombre_equipo,\n" +
                "    SUM(r.tiempo) AS tiempo_total\n" +
                "FROM resultados_etapa r\n" +
                "JOIN ciclistas c ON r.id_ciclista = c.id_ciclista\n" +
                "JOIN equipos e   ON c.id_equipo = e.id_equipo\n" +
                "GROUP BY  c.nombre, e.nombre\n" +
                "ORDER BY SUM(r.tiempo);\n" ;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("posicion"),
                        rs.getString("nombre_ciclista"),
                        rs.getString("nombre_equipo"),
                        rs.getString("tiempo_total"));
            }
        } catch (SQLException e) {
            System.out.println("Error al generar clasificacion de la regularidad" + e.getMessage());
        }
        return tabla;
    }
    // Actividad 9
    /**
     * Calcula y muestra la clasificación general por equipos.
     * Se basa en la suma de los tiempos de los tres mejores ciclistas de cada equipo en cada etapa.
     * @return TextTable con la posición, el nombre del equipo y el tiempo total acumulado.
     */
    public static TextTable clasificacionEquipos(){
        TextTable tabla = new TextTable("posicion", "nombre_equipo", "tiempo_total");
        String sql ="WITH ranked AS (\n" +
                "  SELECT\n" +
                "    e.id_equipo,\n" +
                "    e.nombre             AS nombre_equipo,\n" +
                "    r.id_etapa,\n" +
                "    r.id_ciclista,\n" +
                "    r.tiempo,\n" +
                "    ROW_NUMBER() OVER (\n" +
                "      PARTITION BY e.id_equipo , r.id_etapa\n" +
                "      ORDER BY r.tiempo ASC\n" +
                "    ) AS rn\n" +
                "  FROM resultados_etapa r\n" +
                "  JOIN ciclistas c ON r.id_ciclista  = c.id_ciclista\n" +
                "  JOIN equipos e   ON c.id_equipo = e.id_equipo\n" +
                "),\n" +
                "top3 AS (\n" +
                "  SELECT id_equipo, nombre_equipo , id_etapa, tiempo\n" +
                "  FROM ranked\n" +
                "  WHERE rn <= 3\n" +
                ")\n" +
                "SELECT\n" +
                "  ROW_NUMBER() OVER (ORDER BY SUM(tiempo) ASC) AS posicion,\n" +
                "  nombre_equipo,\n" +
                "  SUM(tiempo)    AS tiempo_total\n" +
                "FROM top3\n" +
                "GROUP BY id_equipo, nombre_equipo\n" +
                "ORDER BY tiempo_total ASC;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tabla.addRow(rs.getString("posicion"),
                        rs.getString("nombre_equipo"),
                        rs.getString("tiempo_total"));
            }
        } catch (SQLException e) {
            System.out.println("Error al generar clasificacion equipos"+ e.getMessage());
        }
        return tabla;
    }

}
