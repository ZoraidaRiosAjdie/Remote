import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

// El nombre lo indica, tiene como objetivo leer los objetos grabados
// en 'aulas.dat', y mostrarlos en la salida estándar.
//
//  También aquí, podemos crear la lista, es decir,
//
//    aulas.dat -----> lista objetos Aula ----> recorrer lista visualizando elementos.

public class AulaGrupoReadSerial{
        @SuppressWarnings("unchecked")
		public static void main(String[] args) throws Exception { 
            ArrayList<Aula> lista = null;
            try {
             FileInputStream inFile = new FileInputStream("aulas.dat");
             ObjectInputStream in = new ObjectInputStream(inFile);
             lista = (ArrayList<Aula>)in.readObject();
             in.close();
             inFile.close();
            }
            catch(IOException e)
            {
             System.err.println("ERROR");
            }
            catch(ClassNotFoundException e)
            {
             System.err.println("ERROR");
            }
            for (Aula rec : lista) {
            	if (rec.getMaterias()!=null) {
            		System.out.println("Nombre " + rec.getName() + " Grupo " + rec.getGrupo() + " Tutor " + rec.getTutor() + " Materias " + rec.getMaterias());
            	}
            	else {
            		System.out.println("Nombre " + rec.getName() + " Grupo " + rec.getGrupo() + " Tutor " + rec.getTutor());
            	}
            }
            
        	
        }
} 

