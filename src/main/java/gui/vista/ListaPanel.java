package gui.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.Controller;

/**
 * Pannello principale dell'interfaccia grafica. Organizza il ContentPanel e
 * l'OpsPanel usando un BorderLayout.
 * 
 * @author Faroni Pimenta
 */
@SuppressWarnings("serial")
public class ListaPanel extends JPanel {

	private ContentPanel contenuto;

	/**
	 * Costruttore che inizializza il pannello principale. Crea e posiziona il
	 * ContentPanel al centro e l'OpsPanel in alto.
	 *
	 * @param controller    Il controller condiviso tra GUI e CLI.
	 */
	public ListaPanel(Controller controller) {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));

		contenuto = new ContentPanel();
		OpsPanel operazioni = new OpsPanel(controller);

		add(contenuto, BorderLayout.CENTER);
		add(operazioni, BorderLayout.NORTH);
	}

	/**
	 * Restituisce il pannello del contenuto.
     *
     * @return Il ContentPanel contenuto in questo pannello.
     * */
	public ContentPanel getContentPanel() {
		return contenuto;
	}
}
