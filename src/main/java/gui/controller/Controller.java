package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.GestioneListe;
import model.ListaDiArticoli;
import model.Articolo;
import model.Categoria;

/**
 * Controller dell'architettura MVC. Il controller serve a gestire il flusso tra
 * le interfacce CLI/GUI e la logica del dominio, intercettando gli eventi Swing
 * e gestendo le eccezioni per garantire la corretta ripetizione delle
 * operazioni.
 * 
 * @author Gibello
 */

public class Controller implements ActionListener {

	private gui.ListaGui view;

	private String listaAttuale = null;

	/**
	 * Associa la vista Swing principale al controller.
	 * 
	 * @param view Il frame principale della GUI.
	 */
	public void setView(gui.ListaGui view) {

		this.view = view;
	}

	/**
	 * Intercetta i clic sui pulsanti della GUI (OpsPanel) e smista le operazioni.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if ("CREA_LISTA".equals(comando)) {

			String nome = JOptionPane.showInputDialog(view, "Inserisci il nome della nuova lista:");

			if (nome != null && !nome.trim().isEmpty()) {

				if (gestisciCreazioneLista(nome)) {

					JOptionPane.showMessageDialog(view, "Lista creata con successo!");

					aggiornaInterfacciaGrafica(listaAttuale);

				} else {

					JOptionPane.showMessageDialog(view, "Errore: lista già esistente.", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		}

		else if ("CANCELLA_LISTA".equals(comando)) {

			String nome = JOptionPane.showInputDialog(view, "Inserisci il nome della lista da cancellare:");

			if (nome != null) {

				if (gestisciCancellazioneLista(nome)) {

					JOptionPane.showMessageDialog(view, "Lista rimossa.");

				}

				if (nome.equals(listaAttuale)) {

					this.listaAttuale = null;
				}

				aggiornaInterfacciaGrafica(listaAttuale);

			} else {

				JOptionPane.showMessageDialog(view, "Errore: Lista non trovata.", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if ("AGGIUNGI_CATEGORIA".equals(comando)) {

			String nome = JOptionPane.showInputDialog(view, "Inserisci il nome della nuova categoria:");

			if (nome != null) {

				if (gestisciAggiuntaCategoria(nome)) {

					JOptionPane.showMessageDialog(view, "Categoria aggiunta!.");

					aggiornaInterfacciaGrafica(listaAttuale);

				} else {

					JOptionPane.showMessageDialog(view, "Errore: categoria già esistente o vuota.", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		else if ("CANCELLA_CATEGORIA".equals(comando)) {

			String nome = JOptionPane.showInputDialog(view, "Inserisci il nome della categoria da cancellare: ");

			if (nome != null) {

				if (gestisciCancellazioneCategoria(nome)) {

					JOptionPane.showMessageDialog(view, "Categoria rimossa!");

				} else {

					JOptionPane.showMessageDialog(view, "Errore: Categoria non trovata.", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		else if ("AGGIUNGI_ARTICOLO".equals(comando)) {

			if (listaAttuale == null) {

				JOptionPane.showMessageDialog(view, "Seleziona o crea prima una lista.", "Avviso",
						JOptionPane.WARNING_MESSAGE);

				return;

			}

		}

		else if ("CANCELLA_ARTICOLO".equals(comando)) {

			if (listaAttuale == null) {

				JOptionPane.showMessageDialog(view, "Seleziona prima una lista!", "Avviso",
						JOptionPane.WARNING_MESSAGE);

				return;

			}

			String nomeArt = JOptionPane.showInputDialog(view, "Nome dell'articolo da rimuovere da questa lista: ");

			if (nomeArt != null) {

				Articolo art = GestioneListe.getArticolo(nomeArt);

				if (gestisciRimozioneArticoloDallaLista(listaAttuale, art)) {

					JOptionPane.showMessageDialog(view, "Articolo spostato nei cancellati.");

					aggiornaInterfacciaGrafica(listaAttuale);

				} else {

					JOptionPane.showMessageDialog(view, "Errore: Articolo non trovato.", "Errore",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		}

	}

	private void aggiornaInterfacciaGrafica(String nomeListaAttuale) {

		if (view != null) {

			String testo = ottieniTestoFormattatoLista(nomeListaAttuale);

			view.aggiornaContenuto(testo);
		}
	}

	/**
	 * Converte il contenuto di una lista in testo formattato pronto per il
	 * ContentPanel, rispettando l'incapsulamento del pattern MVC.
	 * 
	 * @param nomeLista Il nome della lista da formattare.
	 * @return Una stringa contenente l'elenco degli articoli attivi e cancellati.
	 */

	public String ottieniTestoFormattatoLista(String nomeLista) {

		if (nomeLista == null) {

			return "Nessuna lista selezionata. Crea o seleziona una lista dai pulsanti in alto.";
		}

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null) {

			return "Lista non trovata!";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("=== 	LISTA SELEZIONATA: ").append(lista.getNome().toUpperCase()).append(" ===\n\n");

		sb.append("ARTICOLI DA COMPRARE:\n");

		for (Articolo a : lista.getArticoliDaComprare()) {

			sb.append("- ").append(a.toString()).append("\n");
		}

		sb.append("\nARTICOLI CANCELLATI:\n");

		for (Articolo a : lista.getArticoliCancellati()) {

			sb.append("[Cancellato] ").append(a.getNome()).append(" (Categoria: ").append(a.getCategoria().getNome())
					.append(")\n");
		}

		sb.append("\n-----------------------------------\n");

		sb.append("PREZZO TOTALE ATTIVI: € ").append(String.format("%.2f", lista.calcolaPrezzoTotale()));

		return sb.toString();
	}

	/**
	 * 
	 * Restituisce il nome della lista aperta attualmente nella GUI.
	 * 
	 * @return il nome della lista attuale.
	 * 
	 */

	public String getListaAttuale() {

		return listaAttuale;
	}

	/**
	 * Creazione di una nuova lista nel sistema.
	 * 
	 * @param nome Il nome della lista da creare.
	 * @return true se la lista è stata creata, false se l'operazione è fallita.
	 * 
	 */

	public boolean gestisciCreazioneLista(String nome) {

		try {

			GestioneListe.creaLista(nome);

			return true;

		}

		catch (IllegalArgumentException e) {

			return false;

		}

	}

	/**
	 * Rimozione di una lista esistente dal sistema.
	 * 
	 * @param nome Il nome della lista.
	 * @return true se la lista è stata rimossa con successo, false altrimenti.
	 * 
	 */

	public boolean gestisciCancellazioneLista(String nome) {

		try {

			return GestioneListe.cancellaLista(nome);

		}

		catch (IllegalArgumentException e) {

			return false;
		}

	}

	/**
	 * Recupero di una lista di articoli tramite il nome.
	 * 
	 * @param nome Il nome della lista.
	 * @return l'oggetto ListaDiArticoli o null se non esiste.
	 * 
	 */

	public ListaDiArticoli ottieniLista(String nome) {

		return GestioneListe.getLista(nome);
	}

	/**
	 * Tentativo di aggiungere una nuova categoria.
	 * 
	 * @param nome Il nome della categoria.
	 * @return true se la categoria è stata aggiunta, false se duplicata o non
	 *         valida.
	 * 
	 */

	public boolean gestisciAggiuntaCategoria(String nome) {

		try {

			GestioneListe.aggiungeCategoria(nome);

			return true;
		}

		catch (IllegalArgumentException e) {

			return false;
		}

	}

	/**
	 * 
	 * Tentativo di cancellare una categoria.
	 * 
	 * @param nome Il nome della categoria.
	 * @return true se viene cancellata, false se non trovata.
	 * 
	 */

	public boolean gestisciCancellazioneCategoria(String nome) {

		try {

			return GestioneListe.cancellaCategoria(nome);
		}

		catch (IllegalArgumentException e) {

			return false;
		}
	}

	/**
	 * 
	 * Tentativo di aggiunta di un articolo esistente a una lista della spesa.
	 * 
	 * @param nomeLista Il nome della lista di destinazione.
	 * @param articolo  L'articolo da aggiungere.
	 * @return true se inserito, false in caso di errori o duplicazioni.
	 * 
	 */

	public boolean gestisciAggiuntaArticoloLista(String nomeLista, Articolo articolo) {

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null || articolo == null) {

			return false;
		}

		try {

			lista.aggiungiArticolo(articolo);

			return true;

		}

		catch (IllegalArgumentException e) {

			return false;

		}
	}

	/**
	 * 
	 * Spostamento di un articolo della lista nella sua sezione dei cancellati.
	 * 
	 * @param nomeLista Il nome della lista.
	 * @param articolo  L'articolo da rimuovere.
	 * @return true se rimosso, false altrimenti.
	 * 
	 */

	public boolean gestisciRimozioneArticoloDallaLista(String nomeLista, Articolo articolo) {

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null) {

			return false;
		}

		try {

			lista.rimuoviArticolo(articolo);

			return true;
		}

		catch (IllegalArgumentException e) {

			return false;

		}
	}

	/**
	 * 
	 * Rispristino di un articolo dalla lista dei cancellati di una lista specifica.
	 * 
	 * @param nomeLista Il nome della lista.
	 * @param articolo  L'articolo da ripristinare.
	 * @return true se ripristinato, false altrimenti.
	 * 
	 */

	public boolean gestisciRipristinoArticoloInLista(String nomeLista, Articolo articolo) {

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null) {

			return false;
		}

		try {

			lista.ripristinaArticolo(articolo);

			return true;
		}

		catch (IllegalArgumentException e) {

			return false;
		}

	}

	/**
	 * Crea un articolo completo e lo inserisce in una lista specifica. Se la
	 * categoria inserita non esiste ancora nel catalogo globale,viene creata prima
	 * di associare l`articolo.
	 * 
	 * @param nomeArticolo Il nome dell'articolo.
	 * @param nomeCategoria Il nome della categoria (se non esiste, viene creata).
	 * @param nota La nota opzionale.
	 * @param prezzo il costo dell'articolo.
	 * 
	 * @return true se l'operazione ha successo, false altrimenti.
	 * 
	 */

	public boolean gestisciInserimentoArticoloCompleto(String nomeArticolo, String nomeCategoria, String nota, double prezzo) {
	
		try {
		
			model.Categoria categoria = model.GestioneListe.getCategorie(nomeCategoria);
			
			if (categoria == null && nomeCategoria != null && nomeCategoria.trim().isEmpty()) {
				
				model.GestioneListe.aggiungeCategoria(nomeCategoria);
				
				categoria = model.GestioneListe.getCategorie(nomeCategoria);
				
				
			} else if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
				
				categoria = new model.Categoria("Non categorizzato");
			}
			
			model.Articolo nuovoArticolo = new model.Articolo(nomeArticolo, categoria, nota, prezzo);
			
			model.GestioneListe.inserisciArticoloInCatalogo(nuovoArticolo);
			
			if (this.listaAttuale != null) {
				
				boolean inserito = gestisciAggiuntaArticoloLista(this.listaAttuale, nuovoArticolo);
				
				if (inserito) {
					
					aggiornaInterfacciaGrafica(listaAttuale);
					
					return true;
					
				}
			}
			
			return false;
			
		} catch (IllegalArgumentException e) {
			
			return false;
		}
	}		
	
	/**
	 * 
	 * Calcolo del costo totale degli articoli in una lista.
	 * 
	 * 
	 * @param nomeLista Il nome della lista.
	 * @return il prezzo totale oppure 0.0 se la lista non esiste.
	 * 
	 */

	public double ottieniCostoTotaleLista(String nomeLista) {

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null) {

			return 0.0;
		}

		return lista.calcolaPrezzoTotale();
	}

	/**
	 * 
	 * Ricerca di un articolo in una lista per prefisso.
	 * 
	 * 
	 * @param nomeLista La lista in cui cercare.
	 * @param prefisso  Il prefisso del nome.
	 * @return l'articolo trovato o null se non esiste o in caso di errore.
	 * 
	 */

	public Articolo gestisciRicercaPerPrefisso(String nomeLista, String prefisso) {

		ListaDiArticoli lista = GestioneListe.getLista(nomeLista);

		if (lista == null) {

			return null;
		}

		try {

			return lista.cercaArticoloPerPrefisso(prefisso);

		}

		catch (IllegalArgumentException e) {

			return null;
		}

	}

	/**
	 * 
	 * Tentativo di aggiungere un nuovo articolo di default al catalogo globale.
	 * 
	 * @param nome Il nome dell'articolo.
	 * @return true se è stato aggiunto, false in caso di errori o duplicati.
	 * 
	 */

	public boolean gestisciAggiuntaArticoloCatalogo(String nome) {

		try {

			GestioneListe.aggiungeArticolo(nome);

			return true;
		}

		catch (IllegalArgumentException e) {

			return false;
		}

	}

}
