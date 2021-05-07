
package canibalesfinal;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Comedor {
   protected Semaphore Semaforo;
   protected ArrayList<Integer> Cazo = new ArrayList<>();
   protected int MisionerosTotales;
   protected boolean CocinaCerrada = false;
   
   public Comedor(int MisionerosTotales){
        this.Semaforo = new Semaphore(1);
        this.MisionerosTotales = MisionerosTotales;
    }
   
    /* Metodo de cocinar */
    protected int Cocinar(int CantidadMisioneros){
        int MisionerosRestantes = 0;
        try {
            Semaforo.acquire();
            /* Obtener el indice del ultimo misionero */
            
            if(MisionerosTotales > CantidadMisioneros && (MisionerosTotales - CantidadMisioneros) >= 0 ){
                while(CantidadMisioneros != 0){
                Cazo.add(1);
                CantidadMisioneros--;
                }
                MisionerosRestantes = Cazo.size();
                MisionerosTotales = MisionerosTotales - MisionerosRestantes;

            }else{
                CantidadMisioneros = MisionerosTotales;
                while(CantidadMisioneros != 0){
                    Cazo.add(1);
                    CantidadMisioneros--;
                }
                CocinaCerrada = true;
                System.out.println("COCINERO-ULTIMATUM------------ Ultima ronda de cocina, "
                        + "solo se cocinaron: " + MisionerosTotales + " misioneros ----------------");
                MisionerosRestantes = -1;
            }
            
            Semaforo.release();
           
        } catch (Exception e) {
           e.printStackTrace();
        }
       
        /* Cantidad de misioneros actuales en el caso */
        return MisionerosRestantes;               
    }
   
    /* Metodo de Comer */
    protected int Comer(int CantidadMisioneros){
        int MisionerosRestantes = 0;
        try {
            Semaforo.acquire();
            while(CantidadMisioneros != 0){
                Cazo.remove(Cazo.size()-1);
                CantidadMisioneros--;  
            }
            MisionerosRestantes = Cazo.size();
            Semaforo.release();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       /* Cantidad de Misioneros en el cazo despues de ser comidos*/
        return MisionerosRestantes;
    }

    public ArrayList<Integer> getCazo() {
        return Cazo;
    }

    public void setCazo(ArrayList<Integer> Cazo) {
        this.Cazo = Cazo;
    }

    public boolean isCocinaCerrada() {
        return CocinaCerrada;
    }

    public void setCocinaCerrada(boolean CocinaCerrada) {
        this.CocinaCerrada = CocinaCerrada;
    }
    
 
    

   
}

