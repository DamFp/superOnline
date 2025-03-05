/**
 * Clase que representa a un jugador VIP en una subasta.
 * Un jugador VIP recibe un descuento en sus pujas.
 */
package subastas;

public class JugadorVIP extends Jugador {
    private double descuento;

    /**
     * Constructor para crear un jugador VIP con un ID, nombre, saldo y un porcentaje de descuento.
     * @param id Identificador único del jugador.
     * @param nombre Nombre del jugador.
     * @param saldo Saldo disponible del jugador.
     * @param descuento Porcentaje de descuento aplicado a las pujas.
     */
    public JugadorVIP(int id, String nombre, double saldo, double descuento) {
        super(id, nombre, saldo);
        this.descuento = descuento;
    }

    /**
     * Permite a un jugador VIP realizar una puja en una subasta con su descuento aplicado.
     * @param subasta La subasta en la que se quiere pujar.
     * @param cantidad La cantidad que se desea pujar antes de aplicar el descuento.
     * @return true si la puja fue realizada exitosamente, false si no tiene saldo suficiente o la subasta está cerrada.
     */
    @Override
    public boolean pujar(Subasta subasta, double cantidad) {
        double montoFinal = cantidad * (1 - descuento);
        return super.pujar(subasta, montoFinal);
    }

    /**
     * Obtiene el tipo de jugador.
     * @return "Jugador VIP".
     */
    @Override
    public String getTipoJugador() {
        return "Jugador VIP";
    }
}
