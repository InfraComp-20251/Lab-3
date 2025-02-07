public class Cajero extends Thread {

    private int id;
    private Fila fila;
    private float factorCansancio = 1;

    public Cajero(int id, Fila fila) {
        this.id = id;
        this.fila = fila;
    }

    public synchronized void recepcion (Cliente cliente){
        System.out.println("Cajero " + id + " atendiendo al " + cliente.getId());

        int tiempoCalculado = (int) (cliente.getTiempoProcesamiento() * factorCansancio);
       

        try {
            Thread.sleep(tiempoCalculado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cajero " + id + " termino de atender al " + cliente.getId() + " con tiempo base " + 
        cliente.getTiempoProcesamiento() +"con un factor de cansancio: "+ factorCansancio+ " ms y tiempo calculado " + tiempoCalculado);

        factorCansancio += 0.0001 * cliente.getTiempoProcesamiento();
        
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente = fila.retirarCliente();
            recepcion(cliente);
        }
    }
}
