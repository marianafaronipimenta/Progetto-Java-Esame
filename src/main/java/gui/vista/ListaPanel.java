package gui.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.Controller;

@SuppressWarnings("serial")
public class ListaPanel extends JPanel{
	
	private ContentPanel contenuto;
	
	public ListaPanel(Controller controller) {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5,5,5,5));
		
		contenuto = new ContentPanel();
		OpsPanel operazioni = new OpsPanel(controller);
		
		add(contenuto, BorderLayout.CENTER);
		add(operazioni, BorderLayout.NORTH);
	}
	
	public ContentPanel getContentPanel() {
		return contenuto;
	}
}
