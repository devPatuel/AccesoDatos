package org.example;

public class CreandoTabla {
    public static void main(String[] args) {
        TextTable tabla = new TextTable(3,"Horas", "Lunes","Martes","Miercoles", "jueves", "Viernes", "Sabado", "Domingo", "Noe");
        tabla.setAlign("Horas", TextTable.Align.LEFT);
        tabla.addRow("(8:00 AM)", "GYM","GYM", "GYM","GYM", "GYM","GYM","a");
        System.out.println(tabla.toString());
    }

}
