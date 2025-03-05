/**
 * Clase que representa una puja realizada por un jugador en una subasta.
 * Cada puja almacena la cantidad ofertada y la fecha en que fue realizada.
 */
package subastas;

import java.time.LocalDateTime;

public class Puja {
    private Jugador jugador;
    private double cantidad;
    private LocalDateTime fechaHora;

    /**
     * Constructor para crear una nueva puja.
     * @param jugador Jugador que realiza la puja.
     * @param cantidad Cantidad ofertada en la puja.
     * @param fechaHora Fecha y hora en la que se realizó la puja.
     */
    public Puja(Jugador jugador, double cantidad, LocalDateTime fechaHora) {
        this.jugador = jugador;
        this.cantidad = cantidad;
        this.fechaHora = LocalDateTime.now();
    }

    /**
     * Constructor de copia para duplicar una puja existente.
     * @param otraPuja Objeto Puja que se desea duplicar.
     */
    public Puja(Puja otraPuja) {
        this(otraPuja.jugador, otraPuja.cantidad, otraPuja.fechaHora);
    }

    /**
     * Obtiene el jugador que realizó la puja.
     * @return Objeto Jugador que realizó la puja.
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Obtiene la cantidad ofertada en la puja.
     * @return Cantidad ofertada.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Representación en cadena de texto de la puja.
     * @return Información de la puja en formato String.
     */
    @Override
    public String toString() {
        return "Puja{" + "jugador=" + getJugador().toString() + ", cantidad=" + cantidad + ", fechaHora=" + fechaHora + '}';
    }
}
