import cli.InterfacciaTestuale;
import gui.ListaGui;

public class Main {

	public static void main(String[] args) {
		interfacciaGrafica();
		interfacciaTestuale();
	}

	private static void interfacciaGrafica() {
		new ListaGui();
	}
	
	private static void interfacciaTestuale() {
		new InterfacciaTestuale();
	}
}
