import cli.InterfacciaTestuale;
import gui.ListaGui;
import gui.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		interfacciaGrafica(controller);
		interfacciaTestuale(controller);
	}

	private static void interfacciaGrafica(Controller controller) {
		new ListaGui(controller);
	}
	
	private static void interfacciaTestuale(Controller controller) {
		new InterfacciaTestuale(controller);
	}
}
