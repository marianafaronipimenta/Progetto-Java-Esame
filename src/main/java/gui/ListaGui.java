package gui;

import javax.swing.JFrame;

import gui.controller.Controller;
import gui.vista.ListaPanel;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Finestra principale dell'interfaccia grafica Swing.
 * Estende JFrame e contiene il pannello principale dell'applicazione.
 * 
 * @author Faroni Pimenta*/
@SuppressWarnings("serial")
public class ListaGui extends JFrame{
	
	private ListaPanel listaPanel;

	/**
	 * Costruttore che inizializza la finestra principale.
     * Imposta dimensioni, titolo e pannello principale.
     *
     * @param controller     Il controller condiviso tra GUI e CLI.
     * */
	public ListaGui(Controller controller) {
		setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds (100 , 100 , (int)(tela.width * 0.8), (int)(tela.height * 0.8));
		setTitle ("Lista di Articoli");
		
		listaPanel = new ListaPanel(controller);
		setContentPane(listaPanel);
		
		setVisible(true);
	}
	
	/**
	 * Restituisce il pannello principale della finestra.
     *
     * @return Il pannello principale ListaPanel.*/
	public ListaPanel getContentPanel() {
		return listaPanel;
	}
	
	/**
	 * Aggiorna il contenuto visualizzato nel ContentPanel.
     *
     * @param testo      Il testo formattato da visualizzare.
     */
	public void aggiornaContenuto(String testo) {
		listaPanel.getContentPanel().updateView(testo);
	}
}
