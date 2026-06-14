package gui.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


import gui.controller.Controller;

@SuppressWarnings("serial")
public class OpsPanel extends JPanel{
	
	public OpsPanel (Controller controller) {
		setLayout(new FlowLayout());
		
		JButton creaLista = new JButton("Crea lista");
		JButton cancellaLista = new JButton("Cancella lista");
		JButton aggiungiArticolo = new JButton("Aggiungi articolo");
		JButton cancellaArticolo = new JButton("Cancella articolo");
		JButton aggiungiCategoria = new JButton("Aggiungi categoria");
		JButton cancellaCategoria = new JButton("Cancella categoria");
	
		creaLista.addActionListener(controller);
		cancellaLista.addActionListener(controller);
		aggiungiArticolo.addActionListener(controller);
		cancellaArticolo.addActionListener(controller);
		aggiungiCategoria.addActionListener(controller);
		cancellaCategoria.addActionListener(controller);
		
		add(creaLista);
		add(cancellaLista);
		add(aggiungiArticolo);
		add(cancellaArticolo);
		add(aggiungiCategoria);
		add(cancellaCategoria);
	}
}
