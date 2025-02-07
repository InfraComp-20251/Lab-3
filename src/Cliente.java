public class Cliente {

    private int id;
    private int tiempoProcesamiento;

    public Cliente(int id) {
        this.id = id;
        this.tiempoProcesamiento = (int) Math.random()*2000;
        System.out.println("Cliente " + id + " creado con tiempo de procesamiento " + tiempoProcesamiento + " ms");
    }

    public int getId() {
        return id;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

}
