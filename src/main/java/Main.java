import cli.InterfacciaTestuale;
import gui.ListaGui;
import gui.controller.Controller;


/**
 * Classe principale che avvia l'applicazione Lista di Articoli.
 * Inizializza il Controller e le due interfacce utente: grafica (Swing) e
 * testuale (CLI), condividendo lo stesso Controller tra entrambe.
 * 
 * @author Faroni Pimenta*/
public class Main {

	/**
	 * Punto di ingresso dell'applicazione.
     * Crea il Controller, avvia l'interfaccia grafica e quella testuale.
     *
     * @param args Argomenti da riga di comando (non utilizzati).
	 * */
	public static void main(String[] args) {
		Controller controller = new Controller();
		ListaGui gui = new ListaGui(controller);
		controller.setView(gui);
		interfacciaTestuale(controller);
	}
	
	/**
	 * Avvia l'interfaccia testuale da riga di comando.
     *
     * @param controller Il controller condiviso con la GUI.
	 * */
	private static void interfacciaTestuale(Controller controller) {
		new InterfacciaTestuale(controller);
	}
}
