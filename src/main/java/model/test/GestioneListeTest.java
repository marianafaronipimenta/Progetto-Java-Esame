package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GestioneListe;

/**
 * Classe di test per la classe GestioneListe.
 * Verifica il corretto funzionamento delle operazioni su liste, categorie e articoli.
 * 
 * @author Faroni Pimenta
 */

class GestioneListeTest {
	@BeforeEach
	void setup() {
		GestioneListe.svuotaListe();
		GestioneListe.svuotaCategorie();
		GestioneListe.svuotaArticoli();
	}

	@Test
	void testCreazioneListe() {
		GestioneListe.creaLista("Ikea");
		assertNotNull(GestioneListe.getLista("Ikea"));
	}

	@Test
	void testCancellaListe() {
		GestioneListe.creaLista("Ikea");
		assertTrue(GestioneListe.cancellaLista("Ikea"));
	}

	@Test
	void testEccezioneListaNonTrovata() {
		GestioneListe.creaLista("Ikea");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaLista("Supermercato");
		});
	}
	
	
	@Test
	void testAggiungeCategoria() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertEquals("Mobili", GestioneListe.getCategorie("Mobili").getNome());
	}
	
	@Test
	void testEccezioneCategoriaEsistente() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.aggiungeCategoria("Mobili");
		});
	}
	
	
	@Test
	void testCancellaCategoria() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertTrue(GestioneListe.cancellaCategoria("Mobili"));
	}
	
	@Test
	void testEccezioneCategoriaNonTrovata() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaCategoria("Elettronica");
		});
	}
	
	@Test
	void testAggiungeArticolo() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertEquals("Tavolo", GestioneListe.getArticolo("Tavolo").getNome());
	}
	
	@Test
	void testEccezioneArticoloEsistente() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.aggiungeArticolo("Tavolo");
		});
	}
	
	@Test
	void testCancellaArticolo() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertTrue(GestioneListe.cancellaArticolo("Tavolo"));
	}
	
	@Test 
	void testEccezioneArticoloNonTrovato() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaArticolo("Sedia");
		});
	}
}
