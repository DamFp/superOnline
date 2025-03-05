/**
 * Clase que representa a un jugador en una subasta.
 * Cada jugador tiene un identificador único, un nombre y un saldo disponible para pujar.
 */
package subastas;

import java.time.LocalDateTime;

public class Jugador {
    protected int id;
    protected String nombre;
    protected double saldo;

    /**
     * Constructor para crear un jugador con un ID, nombre y saldo inicial.
     * @param id Identificador único del jugador.
     * @param nombre Nombre del jugador.
     * @param saldo Saldo disponible del jugador.
     */
    public Jugador(int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    /**
     * Devuelve el tipo de jugador.
     * Este método debe ser sobrescrito en las subclases.
     * @return Tipo de jugador.
     */
    public String getTipoJugador() {
        return "";
    }

    /**
     * Permite al jugador realizar una puja en una subasta si tiene saldo suficiente.
     * @param subasta La subasta en la que se quiere pujar.
     * @param cantidad La cantidad que se desea pujar.
     * @return true si la puja fue realizada exitosamente, false si no tiene saldo suficiente o la subasta está cerrada.
     */
    public boolean pujar(Subasta subasta, double cantidad) {
        if (saldo >= cantidad && subasta.estaAbierta()) {
            Puja puja = new Puja(this, cantidad, LocalDateTime.now());
            subasta.procesarPuja(puja);
            return true;
        }
        return false;
    }

    /**
     * Descuenta una cantidad del saldo del jugador si es posible.
     * @param cantidad Cantidad a descontar.
     */
    public void descontarSaldo(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
        } else {
            System.out.println("No se puede descontar la cantidad. Saldo insuficiente.");
        }
    }

    /**
     * Representación en cadena de texto del jugador.
     * @return Información del jugador en formato String.
     */
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre='" + nombre + '\'' + ", saldo=" + saldo + '}';
    }
}
