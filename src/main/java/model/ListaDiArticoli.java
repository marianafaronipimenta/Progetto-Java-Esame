package model;

import java.util.Objects;

/**
 * Classe che implementa la gestione di una lista di articoli da acquistare (es.
 * Lista Esselunga, Lista Ikea). Gestisce sia gli articoli attivi da comprare
 * che quelli cancellati permettendone il ripristino. Ciascuna lista non può
 * avere il nome uguale a un'altra lista.
 * 
 * @author Gibello
 */

public class ListaDiArticoli {

	private final String nome;

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
	 * 
	 * @return Il nome della lista.
	 */

	public String getNome() {

		return nome;
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