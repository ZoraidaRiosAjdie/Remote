import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Aula implements Serializable{
	private String name;
	private String grupo;
	private int tutor;
	private ArrayList <String> materias;
	public Aula (String n, String g, int t, ArrayList<String> m) {
        name = n;
	 	grupo = g;
	 	tutor = t;
	 	materias = m;
    }
   	public Aula () {
   		
   	}
	public String getName(){
		return name;
	}
	public String getGrupo() {
		return grupo;
	}
	public int getTutor(){
		return tutor;
	}
	public ArrayList getMaterias(){
		return materias;
	}
	public void setName(String name){
          this.name = name;
        }
	public void setGrupo(String grupo){
          this.grupo = grupo;
        }
    public void setTutor(int tutor){
    	this.tutor = tutor;
    }
    public void setMaterias(ArrayList<String> materias){
    	this.materias = materias;
    }

	 @Override
	 public boolean equals(Object o){
	 	if (o == null) return false;
                 if (o == this) return true;
                 if (!(o instanceof Aula)){
	 		return false;
                 }
	 	Aula a = (Aula) o;
	 	if(grupo.equals(a.getGrupo())) {
	 		//Tengo que agregar que los dos sean true tanto grpo como name
	 		return true;
                }
	 	else {
                  return false;
               }
        }
    }
 

