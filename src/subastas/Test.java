/**
 * Clase de prueba que simula un sistema de subastas con jugadores y subastas abiertas y ciegas.
 * Se crean jugadores, subastas y se procesan pujas para verificar el comportamiento del sistema.
 */
package subastas;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        // Crear jugadores
        Jugador jugador1 = new JugadorEstandar(1, "Carlos", 1000);
        Jugador jugador2 = new JugadorEstandar(2, "Ana", 1200);
        Jugador jugador3 = new JugadorVIP(3, "Luis", 2000, 0.1);
        Jugador jugador4 = new JugadorVIP(4, "Elena", 2500, 0.15);

        // Almacenar jugadores en una estructura polimórfica
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        // Crear subastas
        SubastaAbierta subasta1 = new SubastaAbierta(1, "Reloj Antiguo", 500);
        SubastaAbierta subasta2 = new SubastaAbierta(2, "Pintura Renacentista", 800);
        SubastaCiega subasta3 = new SubastaCiega(3, "Auto Clásico", 10000);

        // Almacenar subastas en una estructura polimórfica
        ArrayList<Subasta> subastas = new ArrayList<>();
        subastas.add(subasta1);
        subastas.add(subasta2);
        subastas.add(subasta3);

        // Los jugadores pujan en una subasta abierta y en una subasta ciega
        for (Jugador jugador : jugadores) {
            jugador.pujar(subasta1, 600);
            jugador.pujar(subasta3, 11000);
        }

        System.out.println(" ------- Informacion de los jugadores ---- ");
        // Mostrar información de cada jugador
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
        System.out.println(" -------------------------------");

        // Cerrar la subasta ciega
        subasta3.cerrarSubasta();

        // Informacion de las tres subastas
        System.out.println(" Estado de las subastas ");
        for (Subasta subasta : subastas) {
            System.out.println(subasta);
        }
        System.out.println(" -------------------------------");

        // Recorrer la lista de subastas y ejecutar toString() solo en SubastaCiega
        for (Subasta subasta : subastas) {
            if (subasta instanceof SubastaCiega) {
                System.out.println(" Informacion de la Subasta Ciega");
                System.out.println(subasta);
                System.out.println(" -------------------------------");
            }
        }
    }
}