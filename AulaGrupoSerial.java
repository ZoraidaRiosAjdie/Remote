import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray; 
import org.json.JSONObject; 

import java.util.ArrayList;

// Idéntico su objetivo que AulaGrupo, la diferencia es que esta clase
// además "graba" los objetos Aula de la lista en un fichero aulas.dat
//    Se pone un aulas.dat en el repositorio para que conozcas
//    que justamente su generación es el cometido de esta clase.

public class AulaGrupoSerial {
        public static void main(String[] args) throws Exception { 

        	ArrayList<Aula> lista = new ArrayList<Aula>();
        	
            String line = null;
            try {
               line = new String(Files.readAllBytes(Paths.get("fileAulas")));
            }       
            catch (Exception ex)
            {
              ex.printStackTrace();
            }                   
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
                lista.add(clase);   
                
             }
            System.out.println(lista.size());
            for(Aula rec : lista) {
            	if (rec.getMaterias()!=null) {
            		System.out.println("Nombre " + rec.getName() + " Grupo " + rec.getGrupo() + " Tutor " + rec.getTutor() + " Materias " + rec.getMaterias());
            	}
            	else {
            		System.out.println("Nombre " + rec.getName() + " Grupo " + rec.getGrupo() + " Tutor " + rec.getTutor());
            	}
            }
            
            try {
                FileOutputStream outFile = new FileOutputStream("aulas.dat");
                ObjectOutputStream out = new ObjectOutputStream(outFile);
                out.writeObject(lista);
                out.close();
              }
              catch(IOException e)
              {
                System.err.println("ERROR");
                System.err.println("An IOException was caught :"+e.getMessage());
              }   
        	
        	
        }
} 

