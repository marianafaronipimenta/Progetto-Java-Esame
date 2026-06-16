package gui;

import javax.swing.JFrame;

import gui.controller.Controller;
import gui.vista.ListaPanel;
import java.awt.Dimension;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class ListaGui extends JFrame{
	
	private ListaPanel listaPanel;

	public ListaGui(Controller controller) {
		setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds (100 , 100 , (int)(tela.width * 0.8), (int)(tela.height * 0.8));
		setTitle ("Lista di Articoli");
		
		listaPanel = new ListaPanel(controller);
		setContentPane(listaPanel);
		
		setVisible(true);
	}
	
	public ListaPanel getContentPanel() {
		return listaPanel;
	}
	
	public void aggiornaContenuto(String testo) {
		listaPanel.getContentPanel().updateView(testo);
	}
}
