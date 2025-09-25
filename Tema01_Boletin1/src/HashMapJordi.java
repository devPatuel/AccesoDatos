import java.util.HashMap;

public class HashMapJordi {
    public static void main (String[] args){
        HashMap<String, String> hash = new HashMap<>();
        hash.put("Juan", "Perez");
        hash.put("Pedro", "Fernandez");
        hash.put("Maria", "Escriva");
        hash.put("Noe", "Conde");
        hash.put("Angel", "Cantero");
        hash.put("Alba", "Creus");
        hash.put("Alex", "Garcia");
        hash.put("Kevin", "Bataller");

        System.out.println(hash.get("Alba"));
        System.out.println(hash.get("Angel"));
        System.out.println(hash.get("Kevin"));


    }
}
