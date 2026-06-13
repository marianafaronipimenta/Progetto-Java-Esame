package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Classe che gestisce le liste di articoli, le categorie e gli articoli.
 * Contiene campi statici per mantenere le liste, le categorie e gli articoli
 * condivisi tra tutte le liste.
 * 
 * @author Faroni Pimenta
 */
public class GestioneListe {
	private static List<Categoria> categorie = new ArrayList<>();
	private static List<Articolo> articoli = new ArrayList<>();
	private static Map<String, ListaDiArticoli> listeArticoli = new HashMap<>();

	/**
	 * Crea una nuova lista di articoli con il nome specificato.
     *
     * @param nome il nome della lista da creare
     */
	public static void creaLista(String nome) {
		listeArticoli.put(nome, new ListaDiArticoli(nome));

	}

	/**
	 * Restituisce la lista di articoli associata al nome specificato.
     *
     * @param nome il nome della lista da cercare
     * @return la lista di articoli associata al nome, o null se non esiste
     */
	public static ListaDiArticoli getLista(String nome) {
		return listeArticoli.get(nome);
	}

	/***/
	public static void svuotaListe() {
		listeArticoli.clear();
	}

	/***/
	public static boolean cancellaLista(String nome) {
		if (!listeArticoli.containsKey(nome)) {
			throw new IllegalArgumentException("Lista non trovata: " + nome);
		}
		listeArticoli.remove(nome);

		return true;
	}
	
	/***/
	public static void svuotaCategorie() {
		categorie.clear();
	}

	/***/
	public static void aggiungeCategoria(String nome) {
		for (Categoria c : categorie) {
			if (c.getNome().equals(nome)) {
				throw new IllegalArgumentException("Categoria gia' esistente: " + nome);
			}
		}
		categorie.add(new Categoria(nome));
	}

	/***/
	public static Categoria getCategorie(String nome) {
		for(Categoria c : categorie) {
			if(c.getNome().equals(nome)) {
				return c;
			}
		}	
		return null;
	}
	
	/**
	 * Cancella la categoria con il nome specificato.
     *
     * @param nome il nome della categoria da cancellare
     * @return true se la categoria è stata cancellata con successo
     * @exception IllegalArgumentException se la categoria non esiste
     */
	public static boolean cancellaCategoria(String nome) {
		for (Categoria c : categorie)
		{
			if(c.getNome().equals(nome))
			{
				categorie.remove(c);
				return true;
			}
		}
		throw new IllegalArgumentException("Categoria non trovata: " + nome);
	}

	
	/**
	 *  Rimuove tutti gli articoli.
     */
	public static void svuotaArticoli() {
		articoli.clear();
	}

	/**
	 * Aggiunge un nuovo articolo con il nome specificato.
     *
     * @param nome il nome dell'articolo da aggiungere
     * @exception IllegalArgumentException se l'articolo esiste già
     */
	public static void aggiungeArticolo(String nome) {
		for(Articolo a : articoli)
		{
			if(a.getNome().equals(nome))
			{
				throw new IllegalArgumentException("Articolo gia' esistente: " + nome);
			}
		}
		articoli.add(new Articolo(nome));
	}

	/**
	 *  Restituisce l'articolo con il nome specificato.
     *
     * @param nome il nome dell'articolo da cercare
     * @return l'articolo corrispondente al nome, o null se non esiste
     */
	public static Articolo getArticolo(String nome) {
		for(Articolo a : articoli)
		{
			if(a.getNome().equals(nome))
			{
				return a;
			}
		}
		
		return null;
	}

	/**
	 * Cancella l'articolo con il nome specificato.
     *
     * @param nome il nome dell'articolo da cancellare
     * @return true se l'articolo è stato cancellato con successo
     * @exception IllegalArgumentException se l'articolo non esiste
     */
	public static boolean cancellaArticolo(String nome) {
		for(Articolo a : articoli)
		{
			if(a.getNome().equals(nome))
			{
				articoli.remove(a);
				return true;
			}
		}
		
		throw new IllegalArgumentException("Articolo non trovato: " + nome);
	}

}
