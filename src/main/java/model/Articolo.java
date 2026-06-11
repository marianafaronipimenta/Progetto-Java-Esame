package model;

import model.Categoria;

/**
 * Questa classe rappresenta un articolo che può essere inserito in una lista di spesa.
 * Ogni articolo ha un nome obbligatorio, una categoria, una nota e un prezzo.
 * 
 * @author Faroni Pimenta
 * */

public class Articolo {
	private String nome;
	private String nota;
	private Categoria categoria;
	private Double prezzo;
	
	
	/**
	 * Crea un articolo con tutti i campi specificati.
	 * 
	 * @param nome         il nome dell'articolo, non può essere vuoto o nullo
	 * @param categoria    la categoria dell'articolo
	 * @param nota         una nota descrittiva facoltativa
	 * @param prezzo       il prezzo dell'articolo
	 */
	public Articolo(String nome, Categoria categoria, String nota, double prezzo) {
		if(nome == null || nome.isEmpty())
		{
			throw new IllegalArgumentException("Il nome non può essere nullo o vuoto"); 
		}
		this.nome = nome;
		this.categoria = (categoria != null) ? categoria: new Categoria("Non categoriazato");
		this.nota = (nota != null) ? nota: "";
		this.prezzo = (prezzo >= 0) ? prezzo: 0;
	}
	
	/**
	 * Crea un articolo solo con il nome, usando i valori di default per i campi:categoria, prezzo e nota
	 * 
	 * @param nome         il nome dell'articolo
	 */
	public Articolo(String nome) {
		this(nome, new Categoria("Non categorizato"), "", 0);
	}
	
	/**
	 * Restituices il nome dell'articolo
	 * 
	 * @return    Il nome dell'articolo
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Restituices la nota dell'articolo
	 * 
	 * @return    la nota dell'articolo
	 */
	public String getNota() {
		return nota;
	}
	
	/**
	 * Restituices la categoria dell'articolo
	 * 
	 * @return    la categoria dell'articolo
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Restituices il prezzo dell'articolo
	 * 
	 * @return    Il prezzo dell'articolo
	 */
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	
	/**
	 * Modifica la categoria dell'articollo
	 * 
	 * @param categoria     la nuova categoria, non può essere nulla
	 * */
	public void setCategoria(Categoria categoria) {
		if(categoria == null)
		{
			throw new IllegalArgumentException("la categoria non può essere nullo");
		}
		this.categoria = categoria;
	}
	
	/**
	 * Modifica il prezzo dell'articollo
	 * 
	 * @param prezzo     il nuovo prezzo, non può essere negativo
	 * */
	public void setPrezzo(double prezzo) {
		if(prezzo <= 0)
		{
			throw new IllegalArgumentException("il prezzo non può essere nullo o negativo");
		}
		this.prezzo = prezzo;
	}
	
	/**
	 * Modifica la nota dell'articollo
	 * 
	 * @param categoria     la nuova nota, non può essere nulla
	 * */
	public void setNota(String nota) {
		this.nota = (nota != null) ? nota: "";
	}
	
	/**
	 * Verifica se il nome dell'articolo inizia con il prefisso specificado
	 * sato per la ricerca nelle lista
	 * 
	 * @param prefisso      la stringa da cercare
	 * @return true se il nome inizia con il prefisso, false altrimenti
	 * */ 
	public boolean iniziaCon(String prefisso) {
		if(prefisso == null || prefisso.isEmpty())
			return false;
		return nome.toLowerCase().startsWith(prefisso.toLowerCase());
	} 
	
	/**
	 * Restituice una rappresentazione testuale dell'articolo
	 * 
	 * @return una stringa con nome, categoria, prezzo e nota
	 * */
	@Override
	public String toString() {
		return nome + "|" + categoria + "| €" + prezzo + "|" + nota;
	}
}
