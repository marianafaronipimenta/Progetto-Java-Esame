package gui.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.Controller;

public class ListaPanel extends JPanel{
	
	public ListaPanel(Controller controller) {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5,5,5,5));
		
		ContentPanel contenuto = new ContentPanel();
		OpsPanel operazioni = new OpsPanel(controller);
		
		add(contenuto, BorderLayout.CENTER);
		add(operazioni, BorderLayout.NORTH);
	}
}
