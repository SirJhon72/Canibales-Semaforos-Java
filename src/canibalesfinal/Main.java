
package canibalesfinal;

public class Main {
    public static void main(String[] args) {
        /* Clase con metodos compartidos */
        Comedor Comedor = new Comedor(100);
        
        /* Clase del cocinero*/
        Cocinero Cocinero = new Cocinero(Comedor);
        Cocinero.start();
        
        /* Clase Canibal*/
        for(int i = 0; i < 5; i++){
            new Canibal(Comedor);
        }
        
    }
    
}
