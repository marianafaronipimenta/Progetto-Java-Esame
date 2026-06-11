package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ListaDiArticoli;

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

}