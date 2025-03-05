/**
 * Clase que representa una subasta abierta en la que los jugadores pueden realizar pujas visibles.
 * En esta modalidad, cada nueva puja debe superar la mejor puja actual para ser válida.
 */
package subastas;

public class SubastaAbierta extends Subasta {
    /**
     * Constructor para crear una subasta abierta con un identificador, nombre del objeto y precio inicial.
     * @param id Identificador único de la subasta.
     * @param nombreObjeto Nombre del objeto en subasta.
     * @param precioInicial Precio inicial de la subasta.
     */
    public SubastaAbierta(int id, String nombreObjeto, double precioInicial) {
        super(id, nombreObjeto, precioInicial);
    }

    /**
     * Procesa una puja en la subasta abierta.
     * Solo se acepta la puja si supera la mejor puja registrada hasta el momento.
     * @param puja Puja realizada por un jugador.
     */
    @Override
    public void procesarPuja(Puja puja) {
        if (puja.getCantidad() > mejorPuja) {
            mejorPuja = puja.getCantidad();
            mejorPostor = puja.getJugador();
        }
    }
}