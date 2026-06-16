package gui.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


import gui.controller.Controller;


/**
 * Pannello dei pulsanti operativi dell'interfaccia grafica.
 * Contiene tutti i bottoni per interagire con le liste di articoli
 * e li collega al Controller tramite ActionListener.
 * 
 * @author Faroni Pimenta*/
@SuppressWarnings("serial")
public class OpsPanel extends JPanel{
	
	/**
	 * Costruttore che inizializza il pannello con tutti i bottoni operativi.
     * Ogni bottone è collegato al Controller tramite un ActionCommand univoco.
     *
     * @param controller     Il controller che gestisce gli eventi dei bottoni.
     * */
	public OpsPanel (Controller controller) {
		setLayout(new GridLayout(4,3,5,5));
		
		JButton creaLista = new JButton("Crea lista");
		JButton cancellaLista = new JButton("Cancella lista");
		JButton aggiungiArticoloCatalogo = new JButton("Aggiungi articolo al catalago");
		JButton inserisceArticoloLista = new JButton("Inserisce articolo in una lista");
		JButton rimuoviArticoloLista = new JButton("Rimuovi articolo da lista");
		JButton ripristinaArticolo = new JButton("Ripristina articolo");
		JButton cancellaArticolo = new JButton("Cancella articolo");
		JButton cancellaCategoria = new JButton("Cancella categoria");
		JButton calcolaTotale = new JButton("Calcola il valore totale");
		JButton cercaPerPrefisso = new JButton("Cerca articolo per prefisso");
	
		creaLista.setActionCommand("CREA_LISTA");
		cancellaLista.setActionCommand("CANCELLA_LISTA");
		aggiungiArticoloCatalogo.setActionCommand("AGGIUNGI_ARTICOLO");
		inserisceArticoloLista.setActionCommand("INSERISCI_ARTICOLO_LISTA");
		rimuoviArticoloLista.setActionCommand("RIMUOVI_ARTICOLO_LISTA");
		ripristinaArticolo.setActionCommand("RIPRISTINA_ARTICOLO");
		cancellaArticolo.setActionCommand("CANCELLA_ARTICOLO");
		cancellaCategoria.setActionCommand("CANCELLA_CATEGORIA");
		calcolaTotale.setActionCommand("CALCOLA_TOTALE");
		cercaPerPrefisso.setActionCommand("CERCA_PREFISSO");
		
		
		creaLista.addActionListener(controller);
		cancellaLista.addActionListener(controller);
		aggiungiArticoloCatalogo.addActionListener(controller);
		inserisceArticoloLista.addActionListener(controller);
		rimuoviArticoloLista.addActionListener(controller);
		ripristinaArticolo.addActionListener(controller);
		cancellaArticolo.addActionListener(controller);
		cancellaCategoria.addActionListener(controller);
		calcolaTotale.addActionListener(controller);
		cercaPerPrefisso.addActionListener(controller);
		
		add(creaLista);
		add(cancellaLista);
		add(aggiungiArticoloCatalogo);
		add(inserisceArticoloLista);
		add(rimuoviArticoloLista);
		add(ripristinaArticolo);
		add(cancellaArticolo);
		add(cancellaCategoria);
		add(calcolaTotale);
		add(cercaPerPrefisso);
	}
}
