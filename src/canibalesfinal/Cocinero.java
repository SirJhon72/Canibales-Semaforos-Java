
package canibalesfinal;

public class Cocinero extends Thread{
    protected Comedor Comedor;
    protected final int TIME = 2000;
    
    public Cocinero(Comedor Comedor){
        this.Comedor = Comedor;
    }
    
    @Override
    public void run(){
        boolean COCINA = true;
        while(COCINA){
            try {
                if(Comedor.getCazo().size() == 0 || Comedor.getCazo().size() < 10){
                    int rangoMisioneros = (10 - Comedor.getCazo().size());                    
                    int cantidadMisioneros = (int)(Math.random()*rangoMisioneros+1);
                    
                    int total = Comedor.Cocinar(cantidadMisioneros);
                    if(total != -1){
                        System.out.println("COCINERO - COOKING EL cocinero desperto y cocino: +" +cantidadMisioneros + ", "
                                + "hay en total: "+ total + " en el cazo");
                        int time = (int)(Math.random()*TIME+1);
                        sleep(time);                        
                    }else{
                        System.out.println("COCINERO - SE CIERRA LA COCINA");
                        COCINA = false;
                    }
                }
                else{
                    int time = (int)(Math.random()*TIME+1);
                    sleep(time);
                    System.out.println("COCINERO - WAITING Aun hay " + Comedor.getCazo().size()  +" misioneros en el cazo, vuelve a dormir");
                }               
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
