package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner lector = new Scanner(System.in);

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("-----------Menú principal-----------");
            System.out.println("----------Elige una opción----------");
            System.out.println("1. Listar equipos.");
            System.out.println("2. Ciclistas por equipos.");
            System.out.println("3. Listado de Etapas.");
            System.out.println("4. Velocidad media de un ciclista.");
            System.out.println("5. Clasificación de etapa.");
            System.out.println("6. Clasificación de la montaña.");
            System.out.println("7. Clasificación de la regularidad.");
            System.out.println("8. Clasificación general.");
            System.out.println("9. Clasificación por equipos.");
            System.out.println("0. Salir");
            opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Has elegido la opcion 0, salir");
                    break;
                case 1:
                    System.out.println("Has elegido 1.Listar equipos.");
                    System.out.println(Consultas.listarequipos());
                    break;
                case 2:
                    System.out.println("Has elegido 2. Ciclistas por equipos.");
                    System.out.println(Consultas.listarequipos());
                    System.out.println("¿De que equipo quieres ver los ciclistas? 0 Para ver todos");
                    int idEquipo = lector.nextInt();
                    System.out.println(Consultas.ciclistasEquipos(idEquipo));
                    break;
                case 3:
                    System.out.println("Has elegido 3. Listado de Etapas.");
                    System.out.println(Consultas.listarEtapas());
                    System.out.println(Consultas.totalEtapas());
                    break;
                case 4:
                    System.out.println("Has elegido 4. Velocidad media de un ciclista.");
                    System.out.println("¿De que equipo quieres ver los ciclistas? 0 Para ver todos");
                    System.out.println(Consultas.listarequipos());
                    int id = lector.nextInt();
                    System.out.println(Consultas.ciclistasEquipos(id));
                    System.out.println("¿Cual es el id del ciclista?");
                    int idCiclista = lector.nextInt();
                    System.out.println(Consultas.velocidadMedia(idCiclista));
                    break;
                case 5:
                    System.out.println("Has elegido 5. Clasificación de etapa.");
                    System.out.println(Consultas.listarEtapas());
                    System.out.println("Que etapa quieres ver?");
                    int idEtapa = lector.nextInt();
                    System.out.println(Consultas.clasificacionEtapa(idEtapa));
                    break;
                case 6:
                    System.out.println("Has elegido 6. Clasificación de la montaña.");
                    System.out.println(Consultas.clasificacionMontana());
                    break;
                case 7:
                    System.out.println("Has elegido 7. Clasificación de la regularidad.");
                    System.out.println(Consultas.clasificacionRegularidad());
                    break;
                case 8:
                    System.out.println("Has elegido 8. Clasificación general.");
                    System.out.println(Consultas.clasificacionGeneral());
                    break;
                case 9:
                    System.out.println("Has elegido 9. Clasificación por equipos");
                    System.out.println(Consultas.clasificacionEquipos());
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
        lector.close();
    }
}

