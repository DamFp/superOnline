package subastas;

public class JugadorEstandar extends Jugador {
    /**
     * Constructor para crear un jugador estándar con un ID, nombre y saldo inicial.
     * @param id Identificador único del jugador.
     * @param nombre Nombre del jugador.
     * @param saldo Saldo disponible del jugador.
     */
    public JugadorEstandar(int id, String nombre, double saldo) {
        super(id, nombre, saldo);
    }

    /**
     * Obtiene el tipo de jugador.
     * @return "Jugador Estándar".
     */
    @Override
    public String getTipoJugador() {
        return "Jugador Estándar";
    }
}
