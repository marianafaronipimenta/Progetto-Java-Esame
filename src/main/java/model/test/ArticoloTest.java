package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Articolo;
import model.Categoria;


/**
 * Classe di test per la classe Articolo.
 * Verifica il corretto funzionamento del costruttore, dei setter e dei metodi di ricerca.
 * 
 * @author Faroni Pimenta
 */
class ArticoloTest {

	/**
	 * Verifica che venga lanciata un'eccezione quando il nome è vuoto.
	 * 
	 * */
	@Test
	void testNomeEccezioneVuoto() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Articolo("");
		});
	}
	
	/**
	 * Verifica che venga lanciata un'eccezione quando il nome è nullo.
	 * 
	 * */
	@Test 
	void testNomeEccezioneNullo() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Articolo(null);
		});
	}
	
	/**
	 * Verifica che il prezzo di default sia zero.
	 * 
	 * */
	@Test
	void testPrezzoDefault() {
		Articolo articolo = new Articolo("Latte");
		assertEquals(0, articolo.getPrezzo());
	}

	/**
	 * Verifica che la categoria di default sia "Non categorizzato".
	 * 
	 * */
	@Test
	void testCategoriaDefault() {
		Articolo articolo = new Articolo("latte");
		assertEquals(new Categoria("Non categorizzato"), articolo.getCategoria());
	}
	
	/**
	 * Verifica che la nota di default sia una stringa vuota.
	 * 
	 * */
	@Test
	void testNotaDefault() {
		Articolo articolo = new Articolo("Latte");
		assertEquals("", articolo.getNota());
	}
	
	/**
	 * Verifica che il prezzo venga modificato correttamente.
	 * 
	 * */
	@Test
	void testSetPrezzo() {
		Articolo articolo = new Articolo("Latte");
		articolo.setPrezzo(1.50);
		assertEquals(1.50, articolo.getPrezzo(),  0.001);
	}
	
	/**
	 * Verifica che la categoria venga modificata correttamente.
	 * 
	 * */
	@Test 
	void testSetCategoria() {
		Articolo articolo = new Articolo("Latte");
		articolo.setCategoria(new Categoria("Senza lattosio"));
		assertEquals(new Categoria("Senza lattosio"), articolo.getCategoria());
	}
	
	/**
	 * Verifica che la nota venga modificata correttamente.
	 * 
	 * */
	@Test 
	void testSetNota() {
		Articolo articolo = new Articolo("Latte");
		articolo.setNota("Lotto: 260611");
		assertEquals("Lotto: 260611", articolo.getNota());
	}
	
	/**
	 * Verifica che venga lanciata un'eccezione quando il prezzo è negativo.
	 * 
	 * */
	@Test 
	void testPrezzoEccezioneNegativo() {
		Articolo articolo = new Articolo("Latte");
		assertThrows(IllegalArgumentException.class, () -> {
			articolo.setPrezzo(-1.0); 
		});
	}
	
	/**
	 * Verifica che il metodo iniziaCon trovi correttamente un prefisso esistente.
	 * 
	 * */
	@Test
	void testPrefissoTrovato() {
		Articolo articolo = new Articolo("Latte");
		assertTrue(articolo.iniziaCon("lat"));
	}
	
	/**
	 * Verifica che il metodo iniziaCon restituisca false per un prefisso non esistente.
	 * 
	 * */
	@Test 
	void testPrefissoNonTrovato() {
		Articolo articolo = new Articolo("Latte");
		assertFalse(articolo.iniziaCon("xyz"));
	}
	
	/**
	 * Verifica che il metodo iniziaCon restituisca false per un prefisso vuoto.*/
	@Test
	void testPrefissoVuoto() {
		Articolo articolo = new Articolo("Latte");
		assertFalse(articolo.iniziaCon(""));
	}
	
	/**
	 * Verifica che il metodo iniziaCon sia case insensitive.
	 * 
	 * */
	@Test
	void testPrefissoLower() {
		Articolo articolo = new Articolo("Latte");
		assertTrue(articolo.iniziaCon("LaT"));
	}
	
	/**
	 * Verifica che due articoli con lo stesso nome siano considerati uguali.
	 * 
	 * */
	@Test
	void testArticoliUguali() {

		Articolo n1 = new Articolo("Latte");
		Articolo n2 = new Articolo("Latte");

		assertTrue(n1.equals(n2));
	}
}
