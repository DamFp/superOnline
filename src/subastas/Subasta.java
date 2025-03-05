/**
 * Clase que representa una subasta en la que los jugadores pueden realizar pujas.
 * Cada subasta tiene un identificador, un objeto en subasta, un precio inicial y un estado de apertura o cierre.
 */
package subastas;

public class Subasta {

    protected int id;
    protected String nombreObjeto;
    protected double precioInicial;
    protected Jugador mejorPostor;
    protected double mejorPuja;
    protected boolean abierta;

    /**
     * Constructor para crear una subasta con un identificador, nombre del objeto y precio inicial.
     * @param id Identificador único de la subasta.
     * @param nombreObjeto Nombre del objeto en subasta.
     * @param precioInicial Precio inicial de la subasta.
     */
    public Subasta(int id, String nombreObjeto, double precioInicial) {
        this.id = id;
        this.nombreObjeto = nombreObjeto;
        this.precioInicial = precioInicial;
        this.mejorPuja = precioInicial;
        this.abierta = true;
    }

    /**
     * Procesa una puja realizada en la subasta.
     * @param puja Puja realizada por un jugador.
     */
    public void procesarPuja(Puja puja) {

    }

    /**
     * Cierra la subasta para que no se acepten más pujas.
     */
    public void cerrarSubasta() {
        this.abierta = false;
    }

    /**
     * Verifica si la subasta está abierta para recibir pujas.
     * @return true si la subasta está abierta, false si está cerrada.
     */
    public boolean estaAbierta() {
        return abierta;
    }

    /**
     * Representación en cadena de texto de la subasta.
     * @return Información de la subasta en formato String.
     */
    @Override
    public String toString() {
        return "Subasta{" + "id=" + id + ", objeto='" + nombreObjeto + '\'' + ", mejorPuja=" + mejorPuja + ", abierta=" + abierta + '}';
    }
}
