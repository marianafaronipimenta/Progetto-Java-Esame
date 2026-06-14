package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GestioneListe;
import gui.controller.Controller;
import gui.vista.ListaPanel;


@SuppressWarnings("serial")
public class ListaGui extends JFrame{

	public ListaGui(Controller controller) {
		setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		setBounds (100 , 100 , 450 , 300);
		setTitle ("Lista di Articoli");
		
		JPanel listaPanel = new ListaPanel(controller);
		setContentPane(listaPanel);
		
		setVisible(true);
	}
	
}
