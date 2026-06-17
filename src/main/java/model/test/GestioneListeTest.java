package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GestioneListe;

/**
 * Classe di test per la classe GestioneListe. Verifica il corretto
 * funzionamento delle operazioni su liste, categorie e articoli.
 * 
 * @author Faroni Pimenta
 */

class GestioneListeTest {

	/**
	 * Pulisce tutte le liste, categorie e articoli prima di ogni test.
	 * 
	 */
	@BeforeEach
	void setup() {
		GestioneListe.svuotaListe();
		GestioneListe.svuotaCategorie();
		GestioneListe.svuotaArticoli();
	}

	/**
	 * Verifica che una lista creata non sia nulla.
	 * 
	 */
	@Test
	void testCreazioneListe() {
		GestioneListe.creaLista("Ikea");
		assertNotNull(GestioneListe.getLista("Ikea"));
	}

	/**
	 * Verifica che una lista esistente venga cancellata correttamente.
	 * 
	 */
	@Test
	void testCancellaListe() {
		GestioneListe.creaLista("Ikea");
		assertTrue(GestioneListe.cancellaLista("Ikea"));
	}

	/**
	 * Verifica che venga lanciata un'eccezione quando si tenta di cancellare una
	 * lista che non esiste.
	 * 
	 */
	@Test
	void testEccezioneListaNonTrovata() {
		GestioneListe.creaLista("Ikea");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaLista("Supermercato");
		});
	}

	/**
	 * Verifica che una categoria venga aggiunta correttamente.
	 * 
	 */
	@Test
	void testAggiungeCategoria() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertEquals("Mobili", GestioneListe.getCategorie("Mobili").getNome());
	}

	/**
	 * Verifica che venga lanciata un'eccezione quando si tenta di aggiungere una
	 * categoria già esistente.
	 * 
	 */
	@Test
	void testEccezioneCategoriaEsistente() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.aggiungeCategoria("Mobili");
		});
	}

	/**
	 * Verifica che una categoria esistente venga cancellata correttamente.
	 * 
	 */
	@Test
	void testCancellaCategoria() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertTrue(GestioneListe.cancellaCategoria("Mobili"));
	}

	/**
	 * Verifica che venga lanciata un'eccezione quando si tenta di cancellare una
	 * categoria che non esiste.
	 */
	@Test
	void testEccezioneCategoriaNonTrovata() {
		GestioneListe.aggiungeCategoria("Mobili");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaCategoria("Elettronica");
		});
	}

	/**
	 * Verifica che un articolo venga aggiunto correttamente.
	 */
	@Test
	void testAggiungeArticolo() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertEquals("Tavolo", GestioneListe.getArticolo("Tavolo").getNome());
	}

	/**
	 * Verifica che venga lanciata un'eccezione quando si tenta di aggiungere un
	 * articolo già esistente.
	 * 
	 */
	@Test
	void testEccezioneArticoloEsistente() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.aggiungeArticolo("Tavolo");
		});
	}

	/**
	 * Verifica che un articolo esistente venga cancellato correttamente.
	 * 
	 */
	@Test
	void testCancellaArticolo() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertTrue(GestioneListe.cancellaArticolo("Tavolo"));
	}

	/**
	 * Verifica che venga lanciata un'eccezione quando si tenta di cancellare un
	 * articolo che non esiste.
	 * 
	 */
	@Test
	void testEccezioneArticoloNonTrovato() {
		GestioneListe.aggiungeArticolo("Tavolo");
		assertThrows(IllegalArgumentException.class, () -> {
			GestioneListe.cancellaArticolo("Sedia");
		});
	}

	/**
	 * Verifica che il metodo getTutteLeListe restituisca tutte le liste create.
	 * 
	 * */
	@Test
	void testGetTutteLeListe() {
		GestioneListe.creaLista("Ikea");
		GestioneListe.creaLista("Supermercato");
		assertEquals(2, GestioneListe.getTutteLeListe().size());
	}
	
	/**
	 * Verifica che il metodo getTutteLeListe non restituisca null.
	 * 
	 * */
	@Test
	void testGetTutteLeListeNonNull() {
		assertNotNull(GestioneListe.getTutteLeListe());
	}
}
