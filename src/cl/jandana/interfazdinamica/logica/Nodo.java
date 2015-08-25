package cl.jandana.interfazdinamica.logica;

import java.util.Vector;

/**
 *
 * @author Javier
 */
public class Nodo {

    private Vector vector;

    public Nodo() {
        vector = new Vector();
        for (int i = 0; i < 3; i++) {
            vector.addElement((double) 1);
        }
    }
 public Nodo(Vector v) {
        vector =v;
        
    }
    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }
    
   

    
}
