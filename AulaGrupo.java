import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray; 
import org.json.JSONObject;

        	
public class AulaGrupo {
    
        public static void main(String[] args) throws Exception {
            String line;
            String line2;
            try{
               for (int t=0 ; t < args.length; t++){
                    String [] partes = args[t].split ("\\.");
                    if (partes[1].equals("json")){
                        line = new String(Files.readAllBytes(Paths.get(args[t])));
                        JSONArray recs = new JSONArray(line);            
                        for(Object rec : recs) {
                            String name =((JSONObject) rec).getString("name");
                            String grupo = ((JSONObject) rec).getString("grupo");
                            int tutor =((JSONObject) rec).getInt("tutor");
                            ArrayList<String> materias = new ArrayList<String>();
                            if  (((JSONObject) rec).has("materias")) {          
                                JSONArray m = ((JSONObject) rec).getJSONArray("materias");          
                                for (int i=0; i<m.length(); i++) {
                                    materias.add( m.getString(i) );
                                }   
                            }
                            Aula clase = new Aula();
                            clase.setTutor(tutor);
                            clase.setGrupo(grupo);
                            clase.setName(name);
                            if (materias.size()>0) {
                                clase.setMaterias(materias);
                            }
                            if (clase.getMaterias()!=null) {
                                System.out.println("Nombre " + clase.getName() + " Grupo " + clase.getGrupo() + " Tutor " + clase.getTutor() + " Materias " + clase.getMaterias());
                            }
                            else {
                                System.out.println("Nombre " + clase.getName() + " Grupo " + clase.getGrupo() + " Tutor " + clase.getTutor());
                            }             
                        }
                    }
                    else{
                        BufferedReader linea = new BufferedReader(new FileReader(args[t]));
                        while ((line2 = linea.readLine()) != null){
                            Aula aula = new Aula ();
                            String[] parte1 = line2.split("\\:");
                            String nombre1 = new String();
                            nombre1 = parte1[0];
                            int tutor1 = Integer.parseInt(parte1[2]);
                            String grupo1 = new String ();
                            grupo1 = parte1[1];

                            aula.setName(nombre1);
                            aula.setTutor(tutor1);
                            aula.setGrupo(grupo1);
                            ArrayList <String> materia1 = new ArrayList <String>();
                            for (String b : materia1){
                                b = parte1[3];
                            }
                            if (materia1.size()>0){
                                    aula.setMaterias(materia1);
                            }
                            if (aula.getMaterias() != null){
                                System.out.println("Nombre " + aula.getName() + " Grupo " + aula.getGrupo() + " Tutor " + aula.getTutor() + " Materias " + aula.getMaterias());
                            }
                            else {
                                System.out.println("Nombre " + aula.getName() + " Grupo " + aula.getGrupo() + " Tutor " + aula.getTutor());
                           }
                        }
                    }
                }
            }       
            catch (Exception ex)
            {
              ex.printStackTrace();
            }                   
        }
}      
            