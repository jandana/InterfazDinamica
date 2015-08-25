package cl.jandana.interfazdinamica.logica;

import cl.jandana.interfazdinamica.util.PanelDinamico;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Logica implements Runnable {

    private boolean running;
    private final PanelDinamico panel;
    private final Matriz matriz;
    private Thread runner;

    public Logica(Matriz matriz, PanelDinamico panel) {
        this.matriz = matriz;
        this.panel = panel;
    }

//    public void setDatos(Matriz matriz, PanelDinamico panel) {
//        this.matriz = matriz;
//        this.panel = panel;
//    }
    public void start() {
        if (matriz != null) {
            runner = new Thread(this);
            runner.setPriority(Thread.MIN_PRIORITY);
            running = true;
            runner.start();
        }
    }

    @Override
    public void run() {
        Random rn = new Random();
        int iteraciones = 0;
        while (running) {
            int filas = rn.nextInt(matriz.getFilas() + 1);
            int colum = rn.nextInt(matriz.getColumnas() + 1);
            for (int i = 0; i < matriz.getFilas(); i++) {
                for (int j = 0; j < matriz.getColumnas(); j++) {
                    Vector v = new Vector();
                    if (i == filas && j == colum) {
                        v.addElement((double) 0);
                        v.addElement((double) 0);
                        v.addElement((double) 0);
                        matriz.getMatriz()[filas][colum] = new Nodo(v);
                    } else {
                        v.addElement((double) 1);
                        v.addElement((double) 1);
                        v.addElement((double) 1);
                        matriz.getMatriz()[i][j] = new Nodo(v);
                    }
                }
            }
            iteraciones++;
            panel.render(matriz, iteraciones);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void stop() {
        if (runner != null) {
            running = false;
            while (runner.isAlive()) {
            }
        }
    }
}
