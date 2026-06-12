package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Articolo;
import model.Categoria;

class ArticoloTest {

	@Test
	void testNomeEccezioneVuoto() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Articolo("");
		});
	}
	
	@Test 
	void testNomeEccezioneNullo() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Articolo(null);
		});
	}
	
	@Test
	void testPrezzoDefault() {
		Articolo articolo = new Articolo("Latte");
		assertEquals(0, articolo.getPrezzo());
	}

	@Test
	void testCategoriaDefault() {
		Articolo articolo = new Articolo("latte");
		assertEquals(new Categoria("Non categorizzato"), articolo.getCategoria());
	}
	
	@Test
	void testNotaDefault() {
		Articolo articolo = new Articolo("Latte");
		assertEquals("", articolo.getNota());
	}
	
	@Test
	void testSetPrezzo() {
		Articolo articolo = new Articolo("Latte");
		articolo.setPrezzo(1.50);
		assertEquals(1.50, articolo.getPrezzo());
	}
	
	@Test 
	void testSetCategoria() {
		Articolo articolo = new Articolo("Latte");
		articolo.setCategoria(new Categoria("Senza lattosio"));
		assertEquals(new Categoria("Senza lattosio"), articolo.getCategoria());
	}
	
	@Test 
	void testSetNota() {
		Articolo articolo = new Articolo("Latte");
		articolo.setNota("Lotto: 260611");
	}
	
	@Test 
	void testPrezzoEccezioneNegativo() {
		Articolo articolo = new Articolo("Latte");
		assertThrows(IllegalArgumentException.class, () -> {
			articolo.setPrezzo(-1.0); 
		});
	}
	
	@Test 
	void testPrezzoEccezioneZero() {
		Articolo articolo = new Articolo("Latte");
		assertThrows(IllegalArgumentException.class, () -> {
			articolo.setPrezzo(0.0); 
		});
	}
	
	
	@Test
	void testPrefissoTrovato() {
		Articolo articolo = new Articolo("Latte");
		assertTrue(articolo.iniziaCon("lat"));
	}
	
	@Test 
	void testPrefissoNonTrovato() {
		Articolo articolo = new Articolo("Latte");
		assertFalse(articolo.iniziaCon("xyz"));
	}
	
	@Test
	void testPrefissoVuoto() {
		Articolo articolo = new Articolo("Latte");
		assertFalse(articolo.iniziaCon(""));
	}
	
	@Test
	void testPrefissoLower() {
		Articolo articolo = new Articolo("Latte");
		assertTrue(articolo.iniziaCon("LaT"));
	}
}
