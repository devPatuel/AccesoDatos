import java.time.LocalDate;

public class Alumno {
    private String nia, nombre, apellido1, apellido2;
    private LocalDate fechaNacimiento;

    public Alumno(String nia, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento){

        // Correciones: No hace falta los getters
        // HashCode y Equals , toString implementats.
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }
        // Getters
        public String getNia() {
            return nia;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido1() {
            return apellido1;
        }

        public String getApellido2() {
            return apellido2;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        // Setters
        public void setNia(String nia) {
            this.nia = nia;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
        }

        public void setApellido2(String apellido2) {
            this.apellido2 = apellido2;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }
}
