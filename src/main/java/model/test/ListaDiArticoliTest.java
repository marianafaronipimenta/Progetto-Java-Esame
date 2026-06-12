package model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.ListaDiArticoli;
import model.Categoria;
import model.Articolo;

/**
 * Classe di test per la verifica del funzionamento della classe
 * ListaDiArticoli.
 * 
 * Verifica che il nome della lista venga salvato correttamente in seguito ad un
 * inserimento valido. Effettua i controlli del lancio eccezioni in caso di
 * inserimenti nulli o vuoti.
 * 
 * 
 * @author Gibello
 */

class ListaDiArticoliTest {

	@Test
	void testValidInsertion() {

		ListaDiArticoli nome = new ListaDiArticoli("Spesa Ikea");

		assertEquals("Spesa Ikea", nome.getNome());

	}

	@Test
	void testNullInsertionThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> new ListaDiArticoli(null));
	}

	@Test
	void testEmptyInsertionThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> new ListaDiArticoli(""));
	}

	@Test
	void testAggiungiArticoloValido() {
		
		ListaDiArticoli lista = new ListaDiArticoli("Lista Esselunga");
		Categoria cat = new Categoria("Alimentari");
		Articolo art = new Articolo("Pane", cat, "Fresco", 2.50);
		
		lista.aggiungiArticolo(art);
		
		assertTrue(lista.getArticoliDaComprare().contains(art));
		assertEquals(1, lista.getArticoliDaComprare().size());
		
	}

	@Test
	void testAggiungiArticoloDuplicatoLanciaEccezione() {
		
		ListaDiArticoli lista = new ListaDiArticoli("Spesa Esselunga");
		Categoria cat = new Categoria("Alimentari");
		Articolo art = new Articolo("Pane", cat, "Fresco", 2.50);
		
		lista.aggiungiArticolo(art);
		
		assertThrows(IllegalArgumentException.class, () -> lista.aggiungiArticolo(art));
	
	}
	
	@Test
	void testRimuoviArticoloSpostaNeiCancellati() {
		
		ListaDiArticoli lista = new ListaDiArticoli("Spesa Esselunga");
		Categoria cat = new Categoria("Alimentari");
		Articolo art = new Articolo("Pane", cat, "Fresco", 2.50);
		
		lista.aggiungiArticolo(art);
		lista.rimuoviArticolo(art);
		
		assertFalse(lista.getArticoliDaComprare().contains(art));
		assertTrue(lista.getArticoliCancellati().contains(art));
		
	}
	
	@Test
	void RipristinaArticoloDaiCancellati() {
	
		ListaDiArticoli lista = new ListaDiArticoli("Spesa Esselunga");
		Categoria cat = new Categoria("Alimentari");
		Articolo art = new Articolo("Pane", cat, "Fresco", 2.50);
		
		lista.aggiungiArticolo(art);
		lista.rimuoviArticolo(art);
		lista.ripristinaArticolo(art);
		
		assertTrue(lista.getArticoliDaComprare().contains(art));
		assertFalse(lista.getArticoliCancellati().contains(art));
		
	}
	
	@Test
	void testCalcolaPrezzoTotale() {
		
		ListaDiArticoli lista = new ListaDiArticoli("Spesa Esselunga");
		Categoria cat = new Categoria("Alimentari");
		
		lista.aggiungiArticolo(new Articolo("Pane", cat, "Fresco", 2.50));
		lista.aggiungiArticolo(new Articolo("Latte", cat, "Intero", 1.50));
		
		assertEquals(4.00, lista.calcolaPrezzoTotale(), 0.001);
		
	}
	
	
	@Test
	void testCercaArticoloPerPrefisso() {
		
		ListaDiArticoli lista = new ListaDiArticoli("Spesa Esselunga");
		Categoria cat = new Categoria("Alimentari");
		Articolo art1 = new Articolo("Mela", cat, "", 1.00);
		Articolo art2= new Articolo("Banana", cat, "", 1.50);
		
		
		lista.aggiungiArticolo(art1);
		lista.aggiungiArticolo(art2);
		lista.rimuoviArticolo(art2);
		
		assertEquals(art1, lista.cercaArticoloPerPrefisso("Me"));
		assertEquals(art2, lista.cercaArticoloPerPrefisso("Ban"));
		assertNull(lista.cercaArticoloPerPrefisso("Zucc"));
		
	}
	
}