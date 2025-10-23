package org.example.Ejercicio01;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args){
        try {
            Empleado[] empleados = Parses.parseEmpleados();
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } catch (IOException e){
            System.err.println("Error: Fallo al leer el fichero XML");
        }catch (ParserConfigurationException e) {
            System.err.println("Error: Fallo en la configuración del parser XML");
        } catch (SAXException e) {
            System.err.println("Error: Fallo al parsear el fichero XML");
        }
    }
}
