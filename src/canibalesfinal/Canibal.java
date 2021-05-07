
package canibalesfinal;

public class Canibal extends Thread{
    protected Comedor Comedor; 
    protected final int TIME = 2000;
    boolean CocinaCerrada = false;

    
    public Canibal( Comedor Comedor){
        this.Comedor = Comedor;
        new Thread(this).start();
    }
    
    @Override
    public void run(){
        boolean COMER = true;
        while(COMER){
            try {
               if(Comedor.getCazo().size() > 0){
                    int solicitud = ((Comedor.isCocinaCerrada() == false) ? (int)(Math.random()*10+1) : (int)(Math.random()*Comedor.getCazo().size()+1) );
                    if(Comedor.getCazo().size() >= solicitud){
                        int restantes = Comedor.Comer(solicitud);
                        if(Comedor.isCocinaCerrada() == false && Comedor.getCazo().size() != 0){
                            System.out.println("CANIBAL - EATING El canibal comio: " + solicitud + " misioneros, sobran: " + restantes);
                            int time = (int)(Math.random()*TIME+1);
                            sleep(time);
                        }else{
                            System.out.println("CANIBAL - EATING El canibal comio: " + solicitud + " misioneros, sobran: " + restantes);
                            int time = (int)(Math.random()*TIME+1);
                            sleep(time);
                            if(Comedor.isCocinaCerrada() == true && Comedor.getCazo().size() == 0){
                                System.out.println("CANIBAL - Ya no hay misioneros por comer, fin del programa");
                                COMER = false;
                            }
                        } 
                    }else{
                        System.out.println("CANIBAL - WAITING El canibal queria comer: " + solicitud + " pero solo hay " + Comedor.getCazo().size());
                        int time = (int)(Math.random()*TIME+1);
                        sleep(time);
                    }
               }else{
                   if(Comedor.isCocinaCerrada() == false){
                    System.out.println("CANIBAL - WAITING - El cazo esta vacio, el canibal debe esperar a que el cocinero cocine");
                    int time = (int)(Math.random()*TIME+1);
                    sleep(time);
                   }else{
                        System.out.println("CANIBAL - Ya no hay misioneros por comer, fin del programa");
                        COMER = false;
                        int time = (int)(Math.random()*TIME+1);
                        sleep(time);
                   }
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
