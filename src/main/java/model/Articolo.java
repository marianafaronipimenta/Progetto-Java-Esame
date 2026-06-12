package model;

import model.Categoria;

/**
 * Questa classe rappresenta un articolo che può essere inserito in una lista
 * della spesa. Ogni articolo ha un nome obbligatorio, una categoria, una nota e
 * un prezzo.
 * 
 * @author Faroni Pimenta
 */

public class Articolo {
	private String nome;
	private String nota;
	private Categoria categoria;
	private Double prezzo;

	/**
	 * Crea un articolo con tutti i campi specificati.
	 * 
	 * @param nome      Il nome dell'articolo, non può essere vuoto o nullo.
	 * @param categoria La categoria dell'articolo.
	 * @param nota      Una nota descrittiva facoltativa.
	 * @param prezzo    Il prezzo dell'articolo.
	 */
	public Articolo(String nome, Categoria categoria, String nota, double prezzo) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Il nome non può essere nullo o vuoto");
		}
		this.nome = nome;
		this.categoria = (categoria != null) ? categoria : new Categoria("Non categorizzato");
		this.nota = (nota != null) ? nota : "";
		this.prezzo = (prezzo >= 0) ? prezzo : 0;
	}

	/**
	 * Crea un articolo solo con il nome, usando i valori di default per i campi:
	 * categoria, prezzo e nota.
	 * 
	 * @param nome il nome dell'articolo.
	 */
	public Articolo(String nome) {
		this(nome, new Categoria("Non categorizzato"), "", 0);
	}

	/**
	 * Restituisce il nome dell'articolo.
	 * 
	 * @return Il nome dell'articolo.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Restituisce la nota dell'articolo.
	 * 
	 * @return La nota dell'articolo.
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * Restituisce la categoria dell'articolo.
	 * 
	 * @return La categoria dell'articolo.
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Restituisce il prezzo dell'articolo.
	 * 
	 * @return Il prezzo dell'articolo.
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Modifica la categoria dell'articolo.
	 * 
	 * @param categoria La nuova categoria non può essere nulla.
	 */
	public void setCategoria(Categoria categoria) {
		if (categoria == null) {
			throw new IllegalArgumentException("La categoria non può essere nulla");
		}
		this.categoria = categoria;
	}

	/**
	 * Modifica il prezzo dell'articolo.
	 * 
	 * @param prezzo Il nuovo prezzo che non può essere negativo.
	 */
	public void setPrezzo(double prezzo) {
		if (prezzo <= 0) {
			throw new IllegalArgumentException("Il prezzo non può essere nullo o negativo");
		}
		this.prezzo = prezzo;
	}

	/**
	 * Modifica la nota dell'articolo.
	 * 
	 * @param nota La nuova nota non può essere nulla.
	 */
	public void setNota(String nota) {
		this.nota = (nota != null) ? nota : "";
	}

	/**
	 * Verifica se il nome dell'articolo inizia con il prefisso specificato. Usato
	 * per la ricerca nella lista.
	 * 
	 * @param prefisso La stringa da cercare.
	 * @return true se il nome inizia con il prefisso, false altrimenti.
	 */
	public boolean iniziaCon(String prefisso) {
		if (prefisso == null || prefisso.isEmpty())
			return false;
		return nome.toLowerCase().startsWith(prefisso.toLowerCase());
	}

	/**
	 * Restituisce una rappresentazione testuale dell'articolo.
	 * 
	 * @return una stringa con nome, categoria, prezzo e nota.
	 */
	@Override
	public String toString() {
		return nome + "|" + categoria + "| €" + prezzo + "|" + nota;
	}
}
