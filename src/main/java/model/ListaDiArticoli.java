package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Classe che implementa la gestione di una lista di articoli da acquistare (es.
 * Lista Esselunga, Lista Ikea). Gestisce sia gli articoli attivi da comprare
 * che quelli cancellati permettendone il ripristino. Ciascuna lista non può
 * avere il nome uguale a un'altra lista.
 * 
 * @author Gibello
 */

public class ListaDiArticoli implements Iterable<Articolo> {

	private final String nome;

	private final java.util.List<Articolo> articoliDaComprare = new java.util.ArrayList<>();
	private final java.util.List<Articolo> articoliCancellati = new java.util.ArrayList<>();

	/**
	 * Costruttore di ListaDiArticoli.class. Esegue il controllo sul nome inserito
	 * per la lista e blocca la creazione dell'oggetto se trova un inserimento null
	 * o vuoto.
	 * 
	 * @param nome Il nome della lista.
	 * @throws IllegalArgumentException Se il nome è nullo o vuoto.
	 * 
	 */

	public ListaDiArticoli(String nome) {

		if (nome == null || nome.isEmpty()) {

			throw new IllegalArgumentException(
					"Il nome assegnato alla lista di articoli non deve essere nullo o vuoto.");
		}

		this.nome = nome;
	}

	/**
	 * Il metodo inserisce un nuovo articolo nella lista della spesa.
	 * 
	 * @param articolo L'articolo da aggiungere.
	 * @throws IllegalArgumentException Se l'articolo è nullo, già presente o nei
	 *                                  cancellati.
	 */

	public void aggiungiArticolo(Articolo articolo) {
		
		if (articolo == null) {
			
			throw new IllegalArgumentException("L'articolo inserito non può essere nullo.");
		
		}
		
		if (articoliDaComprare.contains(articolo)) {
			
			throw new IllegalArgumentException("L'articolo inserito è già presente nella lista della spesa.");
		
		}
		

		if (articoliCancellati.contains(articolo)) {
			
			throw new IllegalArgumentException("L'articolo inserito è presente tra i cancellati. Usa il ripristino.");
		
		}
		
		articoliDaComprare.add(articolo);
		
	}

	/**
	 * Rimuove un articolo dalla lista della spesa e lo sposta nei cancellati.
	 * 
	 * 
	 * @param articolo L'articolo da rimuovere.
	 * @throws IllegalArgumentException Se l'articolo è nullo o non in lista.
	 * 
	 */

	public void rimuoviArticolo(Articolo articolo) {

		if (articolo == null) {

			throw new IllegalArgumentException("L'articolo da rimuovere non può essere nullo.");
		}

		if (!articoliDaComprare.remove(articolo)) {

			throw new IllegalArgumentException("L'articolo non è stato trovato nella lista della spesa.");
		}

		articoliCancellati.add(articolo);
	}

	/**
	 * Ripristina un articolo dalla lista dei cancellati.
	 * 
	 * 
	 * @param articolo L'articolo da ripristinare.
	 * @throws IllegalArgumentException Se l'articolo è nullo o non si trova nei
	 *                                  cancellati.
	 * 
	 */

	public void ripristinaArticolo(Articolo articolo) {

		if (articolo == null) {

			throw new IllegalArgumentException("L'articolo da ripristinare non può essere nullo.");

		}

		if (!articoliCancellati.remove(articolo)) {

			throw new IllegalArgumentException("L'articolo non è stato trovato nella lista dei cancellati.");

		}

		articoliDaComprare.add(articolo);

	}

	/**
	 * Calcola il prezzo totale degli articoli presenti sulla lista attiva.
	 * 
	 * @return totale Il costo totale degli articoli della lista.
	 * 
	 */

	public double calcolaPrezzoTotale() {

		double totale = 0.0;

		for (Articolo a : articoliDaComprare) {

			totale += a.getPrezzo();
		}

		return totale;
	}

	/**
	 * Cerca un articolo partendo dalle iniziali del suo nome sfruttando il
	 * controllo della classe Articolo. Cerca prima negli attivi e poi nei cancellati.
	 * 
	 *@param  prefisso Le lettere iniziali da cercare.
	 *@return a L`articolo oppure null se non è stato trovato.
	 *@throws IllegalArgumentException Se il prefisso è nullo o vuoto.
	 * 
	 */
	
	public Articolo cercaArticoloPerPrefisso(String prefisso) {
	
		if (prefisso == null || prefisso.isEmpty()) {

			throw new IllegalArgumentException("Il prefisso di ricerca non può essere vuoto o nullo.");
		}
		
		for (Articolo a : articoliDaComprare) {
			
			if (a.iniziaCon(prefisso)) {
			
				return a;
			}
		
		}
		
		
		for(Articolo a:articoliCancellati) {

			if (a.iniziaCon(prefisso)) {

				return a;
			}
		}

	return null;

}

	/**
	 * Restituisce il nome della lista.
	 * 
	 * @return Il nome della lista.
	 */

	public String getNome() {

		return nome;
	}

	/**
	 * Restituisce una copia della lista attiva.
	 * 
	 * @return Una lista degli articoli da comprare.
	 */

	public List<Articolo> getArticoliDaComprare() {

		return new ArrayList<>(articoliDaComprare);
	}

	/**
	 * Restituisce una copia degli articoli cancellati.
	 * 
	 * @return Una lista degli articoli rimossi.
	 */

	public List<Articolo> getArticoliCancellati() {

		return new ArrayList<>(articoliCancellati);
	}

	
	/**
	 * Rimuove definitivamente un articolo dalla lista dei presenti se esistente.
	 * 
	 * @param articolo L'articolo da eliminare.
	 */
	
	public void rimuoviDefinitivamenteDaComprare(Articolo articolo) {
	
		this.articoliDaComprare.remove(articolo);
	}
	
	/**
	 * Rimuove definitivamente un articolo dalla lista dei cancellati se esistente.
	 * 
	 * @param articolo L'articolo da eliminare.
	 */
	
	public void rimuoviDefinitivamenteDaCancellati(Articolo articolo) {
	
		this.articoliCancellati.remove(articolo);
	}
	
	/**
	 * Permette una iterazione combinata: restituisce prima gli articoli attivi e poi quelli nella lista dei cancellati
	 * 
	 * @return Un iteratore unico per scorrere l'intera lista.
	 */
	
	@Override
	public Iterator<Articolo> iterator() {
		
		List<Articolo> listaCompleta = new ArrayList<>(articoliDaComprare); 
		
		listaCompleta.addAll(articoliCancellati);
		
		return listaCompleta.iterator();
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDiArticoli other = (ListaDiArticoli) obj;
		return Objects.equals(nome, other.nome);
	}

}