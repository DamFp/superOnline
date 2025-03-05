/**
 * Clase que representa una subasta ciega, donde las pujas son ocultas hasta el cierre de la subasta.
 * Solo al finalizar la subasta se revela el ganador y la mejor puja.
 */
package subastas;

import java.util.ArrayList;

public class SubastaCiega extends Subasta {
    private ArrayList<Puja> pujas;

    /**
     * Constructor para crear una subasta ciega con un identificador, nombre del objeto y precio inicial.
     * @param id Identificador único de la subasta.
     * @param nombreObjeto Nombre del objeto en subasta.
     * @param precioInicial Precio inicial de la subasta.
     */
    public SubastaCiega(int id, String nombreObjeto, double precioInicial) {
        super(id, nombreObjeto, precioInicial);
        this.pujas = new ArrayList<>();
    }

    /**
     * Procesa una puja en la subasta ciega agregándola a la lista de pujas sin revelar información.
     * @param puja Puja realizada por un jugador.
     */
    @Override
    public void procesarPuja(Puja puja) {
        pujas.add(puja);
    }

    /**
     * Cierra la subasta ciega, determina al ganador y gestiona el pago si es posible.
     */
    @Override
    public void cerrarSubasta() {
        super.cerrarSubasta();
        Puja mejor = pujas.stream().max((p1, p2) -> Double.compare(p1.getCantidad(), p2.getCantidad())).orElse(null);
        if (mejor != null) {
            mejorPuja = mejor.getCantidad();
            mejorPostor = mejor.getJugador();
            if (mejorPostor.saldo >= mejorPuja) {
                mejorPostor.descontarSaldo(mejorPuja);
            } else {
                System.out.println("El ganador no tiene suficiente saldo para pagar la puja.");
            }
        }
    }

    /**
     * Obtiene la lista de pujas realizadas en la subasta ciega.
     * @return Lista de pujas en la subasta ciega.
     */
    public ArrayList<Puja> getPujas() {
        return new ArrayList<>(pujas);
    }
}
