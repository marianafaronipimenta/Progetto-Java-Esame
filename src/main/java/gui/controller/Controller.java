package gui.controller;

import model.GestioneListe;
import model.ListaDiArticoli;
import model.Articolo;

/**
 * Controller dell'architettura MVC. Il controller serve a gestire il flusso tra
 * le interfacce CLI/GUI e la logica del dominio gestendo gli inserimenti errati
 * tramite opportune eccezioni.
 * 
 * @author Gibello
 */

public class Controller {

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
	 *@param nome Il nome dell'articolo.
	 *@return true se è stato aggiunto, false in caso di errori o duplicati.
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
