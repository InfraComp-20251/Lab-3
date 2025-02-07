public class GeneradorClientes extends Thread {

    private int numeroDeClientes;
    private Fila fila;
    

    public GeneradorClientes(int numeroDeClientes, Fila fila) {
        this.numeroDeClientes= numeroDeClientes;
        this.fila = fila;
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroDeClientes; i++) {
            Cliente cliente = new Cliente(i);
            fila.agregarCliente(cliente);
            try {
                Thread.sleep((int) Math.random()*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
