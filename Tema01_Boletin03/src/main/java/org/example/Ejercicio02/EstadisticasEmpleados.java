package org.example.Ejercicio02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.example.Ejercicio01.Empleado;
import org.example.Ejercicio01.Parses;
import org.xml.sax.SAXException;

/**
 * Clase para generar estadísticas de empleados.
 */
public class EstadisticasEmpleados{
    /**
     * Parsea el fichero XML de empleados y genera estadísticas por departamento.
     * @throws IOException Fallo al leer el fichero.
     * @throws ParserConfigurationException Fallo en la configuración del parser XML.
     * @throws SAXException Fallo al parsear el fichero XML.
     */
    public static void stats() throws IOException, ParserConfigurationException, SAXException {
        Empleado[] empleados = Parses.parseEmpleadosActividad2();
        Map<String, List<Double>> departamentos = new HashMap<>();
        for (Empleado empleado : empleados) {
            departamentos.computeIfAbsent(empleado.getDepartamento(), k -> new ArrayList<>()).add(empleado.getSalario());
        }
        System.out.println("Departamento | Nº Empleados | Salario Medio");
        for (Map.Entry<String, List<Double>> entry : departamentos.entrySet()) {
            String departamento = entry.getKey();
            List<Double> salarios = entry.getValue();
            double suma = 0;
            for (double s : salarios) {
                suma += s;
            }
            double salarioMedio = suma / salarios.size();
            System.out.printf("%-12s | %12d | %12.2f%n",departamento, salarios.size(), salarioMedio);
            }
        }
    }
