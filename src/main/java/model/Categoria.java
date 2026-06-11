package model;

import java.util.Objects;

/**
 * Classe che rappresenta la categoria a cui può appartenere un articolo. Le
 * categorie sono uniche e vengono condivise tra tutte le liste.
 *
 * @author Gibello
 *
 */

public class Categoria {

	private String nome;

	public Categoria(String nome) {

		if (nome == null || nome.isEmpty()) {

			throw new IllegalArgumentException("Il nome inserito non può essere nullo o vuoto");
		}

		this.nome = nome;

	}

	/**
	 * Restituisce il nome della categoria.
	 * 
	 * @return Il nome della categoria.
	 */

	public String getNome() {

		return nome;
	}

	/**
	 * Imposta un nuovo nome per la categoria.
	 * 
	 * @param nome Il nuovo nome.
	 * @throws IllegalArgumentException Se il nuovo nome è nullo o vuoto.
	 */

	public void setNome(String nome) {

		if (nome == null || nome.isEmpty()) {

			throw new IllegalArgumentException("Il nome inserito non può essere nullo o vuoto");

		}

		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	
	/**
	 * Confronta la categoria inserita con un altro oggetto.
	 * Se due categorie hanno lo stesso nome, allora sono uguali.
	 * 
	 * @return true se gli oggetti sono uguali, altrimenti false.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(nome, other.nome);
	}

}
