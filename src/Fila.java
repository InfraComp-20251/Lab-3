import java.util.ArrayList;

public class Fila {

    private ArrayList<Cliente> clientes;

    public Fila() {
        this.clientes = new ArrayList<Cliente>();
    }
    
    public synchronized void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        if (clientes.size() == 1){
            notify();
        }
        
    }

    public synchronized Cliente retirarCliente() {
        
        while(clientes.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            return clientes.remove(0);
    }

}
