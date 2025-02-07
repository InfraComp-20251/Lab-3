public class Main {
    public static void main(String[] args) throws Exception {
       
        Fila fila = new Fila();

        for (int i = 0; i < 5; i++) {
            new Cajero(i, fila).start();
        }

        GeneradorClientes generador = new GeneradorClientes(40,fila);
        generador.start();

    }
}
