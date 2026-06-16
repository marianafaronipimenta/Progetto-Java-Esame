package cli;

import java.util.Scanner;
import gui.controller.Controller;
import model.Articolo;

/**
 * 
 * Classe che gestisce l'interfaccia utente da riga di comando (CLI).
 * L'interazione con l'utente viene effettuata tramite menù numerati. La logica
 * viene lasciata al Controller e in caso di errori o eccezioni, l'operazione
 * viene fatta ripetere.
 * 
 * @author Gibello
 * 
 */

public class InterfacciaTestuale {

	
	private final Controller controller;
	
	private final Scanner scanner;
	
	
	/**
	 * Costruttore dell'interfaccia testuale.
	 * 
	 * @param controller Il controllore dei flussi del sistema.
	 * 
	 */
	
	public InterfacciaTestuale(Controller controller) {
		
		this.controller = controller;
		
		this.scanner = new Scanner(System.in);
		
		avviaMenu();
		
	}
	
	
	/**
	 * 
	 * Gestisce il menù da riga di comando.
	 * 
	 */
	
	private void avviaMenu() {
		
		boolean inEsecuzione = true;
		
		while (inEsecuzione) {
			
			System.out.println("\n==================================");
			System.out.println("   INTERFACCIA DA RIGA DI COMANDO   ");
			System.out.println("1. Crea una nuova lista");
			System.out.println("2. Cancella una lista esistente");
			System.out.println("3. Aggiungi una nuova categoria");
			System.out.println("4. Aggiungi un articolo al catalogo");
			System.out.println("5. Inserisci un articolo in una lista");
			System.out.println("6. Rimuovi un articolo da una lista (sposta nei cancellati)");
			System.out.println("7. Ripristina un articolo dai cancellati");
			System.out.println("8. Calcola il prezzo totale di una lista");
			System.out.println("9. Cerca un articolo per prefisso in una lista");
			System.out.println("0. Torna al menù principale / Esci");
			System.out.print("Scegli un'opzione: ");
		
			String scelta = scanner.nextLine().trim();
			
			switch (scelta) {
			
			case "1":
				eseguiCreazioneLista();
				break;
				
			case "2":
				eseguiCancellazioneLista();
				break;
				
			case "3":
				eseguiAggiuntaCategoria();
				break;
				
			case "4":
				eseguiAggiuntaArticoloCatalogo();
				break;
				
			case "5":
				eseguiAggiuntaArticoloALista();
				break;
				
			case "6":
				eseguiRimozioneArticoloDaLista();
				break;
				
			case "7":
				eseguiRipristinoArticoloInLista();
				break;
				
			case "8":
				eseguiCalcoloTotale();
				break;
				
			case "9":
				eseguiRicercaPerPrefisso();
				break;
				
			case "0":
				System.out.println("Uscita dal menù");
				inEsecuzione = false;
				break;
				
			default:
				System.out.println("Opzione non valida. Riprova.");
				
			}
		}
	}
	
	private void eseguiCreazioneLista() {
		
		System.out.print("Inserisci il nome della nuova lista: ");
		String nome = scanner.nextLine().trim();
		
		if (controller.gestisciCreazioneLista(nome)) {
			
			System.out.println("Lista \"" + nome + "\" creata con successo!");
		
		} else {
			
			System.out.println("Errore: nome vuoto o lista già esistente.");
			System.out.println("Ripetizione dell'operazione:");
			
			eseguiCreazioneLista();
			
		}
		
	}
	
	private void eseguiCancellazioneLista() {
	
		System.out.print("Inserisci il nome della lista da cancellare: ");
	
		String nome = scanner.nextLine().trim();
	
		
		if (controller.gestisciCancellazioneLista(nome)) {
			
			System.out.println("Lista rimossa con successo!");
		
		} else {
			

			System.out.println("Errore: lista non trovata. Ripetizione in corso: ");
			
			eseguiCancellazioneLista();
		}
	
	}
	
	private void eseguiAggiuntaCategoria() {
		
		System.out.print("Inserisci il nome della nuova categoria: ");
		
		String nome = scanner.nextLine().trim();
	
		
		if (controller.gestisciAggiuntaCategoria(nome)) {
			
			System.out.println("Categoria \"" + nome + "\" creata con successo!");
		
		} else {
			
			System.out.println("Errore: nome vuoto o categoria già esistente. Ripetizione in corso: ");
			
			eseguiAggiuntaCategoria();
		}
		
	}
	
	private void eseguiAggiuntaArticoloCatalogo() {
		
		System.out.print("Inserisci il nome del nuovo articolo: ");
		
		String nome = scanner.nextLine().trim();
	
		
		if (controller.gestisciAggiuntaArticoloCatalogo(nome)) {
			
			System.out.println("Articolo \"" + nome + "\" inserito con successo!");
		
		} else {
			
			System.out.println("Errore: nome vuoto o articolo già esistente. Ripetizione in corso: ");
			
			eseguiAggiuntaArticoloCatalogo();
		}	
		
	}
	
	
	private void eseguiAggiuntaArticoloALista() {
	
		System.out.print("Inserisci il nome della lista in cui inserire l'articolo: ");
		
		String nomeLista = scanner.nextLine().trim();
		
		System.out.print("Inserisci il nome dell'articolo: ");
		
		String nomeArticolo = scanner.nextLine().trim();
		
		
		Articolo art = controller.ottieniLista(nomeLista) != null ? model.GestioneListe.getArticolo(nomeArticolo) : null;
		
		
		if (controller.gestisciAggiuntaArticoloLista(nomeLista, art)) {
			
			System.out.println("Articolo \"" + nomeArticolo + "\" inserito nella lista \"" + nomeLista + "\" !");
		
		} else {
			
			System.out.println("Errore: lista o articolo non trovati, oppure articolo duplicato. Ripetizione in corso: ");
			
			eseguiAggiuntaArticoloALista();
		}
	
	}
	
	private void eseguiRimozioneArticoloDaLista() {
		
		System.out.print("Inserisci il nome della lista: ");
		
		String nomeLista = scanner.nextLine().trim();
		
		System.out.print("Inserisci il nome dell'articolo da cancellare: ");
		
		String nomeArticolo = scanner.nextLine().trim();
		
		
		Articolo art = controller.ottieniLista(nomeLista) != null ? model.GestioneListe.getArticolo(nomeArticolo) : null;
		
		
		
		if (controller.gestisciRimozioneArticoloDallaLista(nomeLista, art)) {
			
			System.out.println("Articolo spostato nella lista dei cancellati!");
		
		} else {
			
			System.out.println("Errore: articolo non trovato nella lista selezionata. Ripetizione in corso: ");
			
			eseguiRimozioneArticoloDaLista();
		}	
		
	}
	
	
	private void eseguiRipristinoArticoloInLista() {
		
		System.out.print("Inserisci il nome della lista: ");
		
		String nomeLista = scanner.nextLine().trim();
		
		System.out.print("Inserisci il nome dell'articolo da ripristinare: ");
		
		String nomeArticolo = scanner.nextLine().trim();
		
		
		Articolo art = controller.ottieniLista(nomeLista) != null ? model.GestioneListe.getArticolo(nomeArticolo) : null;
		
		
		if (controller.gestisciRipristinoArticoloInLista(nomeLista, art)) {
			
			System.out.println("Articolo ripristinato correttamente nella lista!");
		
		} else {
			
			System.out.println("Errore: articolo non trovato nella lista dei cancellati. Ripetizione in corso: ");
			
			eseguiRipristinoArticoloInLista();
		}
		
	}
	
	
	private void eseguiCalcoloTotale() {
	
		
		System.out.print("Inserisci il nome della lista di cui calcolare il costo totale: ");
		
		String nomeLista = scanner.nextLine().trim();
	
	
		if (controller.ottieniLista(nomeLista) != null) {
			
			double totale = controller.ottieniCostoTotaleLista(nomeLista);
			
			System.out.println("Il costo totale per la lista \"" + nomeLista + "\" è di: € " + String.format("%.2f", totale));
			
		} else {
			
			System.out.println("Errore: lista non trovata. Ripetizione in corso: ");
			
			eseguiCalcoloTotale();
		}
		
	}
	
	
	private void eseguiRicercaPerPrefisso() {
		

		System.out.print("Inserisci il nome della lista in cui cercare: ");
		
		String nomeLista = scanner.nextLine().trim();
		
		
		System.out.print("Inserisci il prefisso da cercare: ");
		
		String prefisso = scanner.nextLine().trim();
		
		
		Articolo trovato = controller.gestisciRicercaPerPrefisso(nomeLista, prefisso);
		
		
		if (trovato != null) {
			
			
			System.out.println ("Articolo trovato: " + trovato.toString());
		
		}	else {
			
			System.out.println ("Nessun articolo trovato con prefisso \"" + prefisso + "\" ");
		}
		
	}
		
}

