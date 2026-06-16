import cli.InterfacciaTestuale;
import gui.ListaGui;
import gui.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		ListaGui gui = new ListaGui(controller);
		controller.setView(gui);
		interfacciaTestuale(controller);
	}
	
	private static void interfacciaTestuale(Controller controller) {
		new InterfacciaTestuale(controller);
	}
}
