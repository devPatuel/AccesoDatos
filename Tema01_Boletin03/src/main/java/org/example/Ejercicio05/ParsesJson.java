package org.example.Ejercicio05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.example.Ejercicio07.Inventario;
import org.example.Ejercicio07.ProductoInventario;
import org.example.Ejercicio07.Ubicacion;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class ParsesJson {
    /**
     * Parsea el fichero JSON de alumnos y devuelve un array de objetos Alumno.
     * @return Lista de objetos Alumno.
     * @throws IOException Fallo al leer el fichero.
     */
    public static Alumno[] parsearAlumnos() throws IOException {
        Alumno[] alumnos = null;
        StringBuilder  sb = new StringBuilder();
        try (InputStream is = ParsesJson.class.getResourceAsStream("/Datasets/alumnos.json");
             BufferedReader br = new BufferedReader(new InputStreamReader(is,
                     StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONArray jsonArray = new JSONArray(tokener);
            alumnos = new Alumno[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String nombre = jsonObject.getString("nombre");
                boolean matriculado = jsonObject.getBoolean("matriculado");
                String fechaNacimiento = jsonObject.getString("fechaNacimiento");

                JSONArray notasArray = jsonObject.getJSONArray("notas");
                Asignatura[] asignaturas = new Asignatura[notasArray.length()];
                for (int j = 0; j < notasArray.length(); j++) {
                    JSONObject notaObject = notasArray.getJSONObject(j);
                    String asignatura = notaObject.getString("asignatura");
                    double nota = notaObject.getDouble("nota");
                    asignaturas[j] = new Asignatura(asignatura, nota);
                }
                alumnos[i] = new Alumno(id, nombre, matriculado, fechaNacimiento,asignaturas);
            }
        }
        return alumnos;
    }

    /**
     * Parsea el fichero JSON de inventario y devuelve un objeto Inventario.
     * @return Objeto Inventario.
     * @throws IOException Fallo al leer el fichero.
     */
    public static Inventario parsearInventario() throws IOException {
        Inventario inventario = null;
        StringBuilder  sb = new StringBuilder();
        try (InputStream is = ParsesJson.class.getResourceAsStream("/Datasets/inventario.json");
             BufferedReader br = new BufferedReader(new InputStreamReader(is,
                     StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONObject jsonObject = new JSONObject(tokener);
            // Almacen
            String almacen = jsonObject.getString("almacen");
            // Actualizado
            String actualizado = jsonObject.getString("actualizado");
            // Prodcutos
                JSONArray productosArray = jsonObject.getJSONArray("productos");
                ProductoInventario[] productoInventarios = new ProductoInventario[productosArray.length()];
                for (int i = 0; i < productosArray.length(); i++) {
                    JSONObject productosObject = productosArray.getJSONObject(i);
                    String id = productosObject.getString("id");
                    String nombre = productosObject.getString("nombre");
                    int stock = productosObject.getInt("stock");
                    double precio = productosObject.getDouble("precio");
                    JSONArray tagsArray = productosObject.getJSONArray("tags");
                    String[] tags = new String[tagsArray.length()];
                    // Tags
                    for (int j = 0; j < tagsArray.length(); j++) {
                        tags[j] = tagsArray.getString(j);
                        }
                    // Ubicacion
                    JSONObject ubicacionObject = productosObject.getJSONObject("ubicacion");
                    int pasillo = ubicacionObject.getInt("pasillo");
                    String estante = ubicacionObject.getString("estante");
                    Ubicacion ubicacion = new Ubicacion(pasillo, estante);
                    // Lista de productos
                    productoInventarios[i] = new ProductoInventario(id,nombre,stock,precio,tags, ubicacion);
                }
                // Creo el inventario
               inventario = new Inventario(almacen, actualizado, productoInventarios);
        }
        return inventario;
   }
}
