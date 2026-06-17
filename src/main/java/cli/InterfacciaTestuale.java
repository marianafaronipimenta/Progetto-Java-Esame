package cli;

import java.util.Scanner;
import gui.controller.Controller;
import model.Articolo;
import model.GestioneListe;

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
			System.out.println("3. Aggiungi una categoria globale");
			System.out.println("4. Inserisci un articolo completo in una lista");
			System.out.println("5. Rimuovi un articolo da una lista (sposta nei cancellati)");
			System.out.println("6. Ripristina un articolo dai cancellati");
			System.out.println("7. Calcola il prezzo totale di una lista");
			System.out.println("8. Cerca un articolo per prefisso in una lista");
			System.out.println("0. Esci");
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
				eseguiAggiuntaArticoloCompletoALista();
				break;

			case "5":
				eseguiRimozioneArticoloDaLista();
				break;

			case "6":
				eseguiRipristinoArticoloInLista();
				break;

			case "7":
				eseguiCalcoloTotale();
				break;

			case "8":
				eseguiRicercaPerPrefisso();
				break;

			case "0":
				System.out.println("Uscita dall'interfaccia testuale");
				inEsecuzione = false;
				break;

			default:
				System.out.println("Opzione non valida. Riprova.");

			}
		}
	}

	private void eseguiCreazioneLista() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della nuova lista: ");
			String nome = scanner.nextLine().trim();

			if (controller.gestisciCreazioneLista(nome)) {

				System.out.println("Lista \"" + nome + "\" creata con successo!");

				successo = true;

			} else {

				System.out.println("Errore: nome vuoto o lista già esistente. Riprova.");

			}

		}

	}

	private void eseguiCancellazioneLista() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della lista da cancellare: ");

			String nome = scanner.nextLine().trim();

			if (controller.gestisciCancellazioneLista(nome)) {

				System.out.println("Lista rimossa con successo!");

				successo = true;

			} else {

				System.out.println("Errore: lista non trovata. Riprova.");

			}

		}

	}

	private void eseguiAggiuntaCategoria() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della nuova categoria: ");

			String nome = scanner.nextLine().trim();

			if (controller.gestisciAggiuntaCategoria(nome)) {

				System.out.println("Categoria \"" + nome + "\" creata con successo!");

				successo = true;

			} else {

				System.out.println("Errore: nome vuoto o categoria già esistente. Riprova.");

			}

		}

	}

	private void eseguiAggiuntaArticoloCompletoALista() {

		boolean successo = false;
		
		while (!successo) {
		
			System.out.print("Inserisci il nome della lista di destinazione: ");

			String nomeLista = scanner.nextLine().trim();
			
			if (controller.ottieniLista(nomeLista) == null) {
				
				System.out.println ("Errore: lista non trovata nel sistema. Riprova.");
				
				continue;
			}

			System.out.print("Inserisci il nome del nuovo articolo: ");

			String nomeArticolo = scanner.nextLine().trim();
			
			
			System.out.print("Inserisci la categoria dell'articolo (se nuova, verrà creata): ");
			
			String nomeCategoria = scanner.nextLine().trim();
			
			
			System.out.print("Inserisci una nota descrittiva (opzionale): ");

			String nota = scanner.nextLine().trim();

			
			double prezzo = 0.0;
			
			boolean prezzoValido = false;
			
			while (!prezzoValido) {
				
				System.out.print("Inserisci il prezzo dell'articolo (es. 2.50): ");
				
				try {
					
					prezzo = Double.parseDouble(scanner.nextLine().trim());
					
					if (prezzo >= 0) {
						
						prezzoValido = true;
						
					} else {
						
						System.out.println("Errore: il prezzo non può essere negativo.");
					
						} 
					
				} catch (NumberFormatException e) {
						
						System.out.println("Errore: formato numerico non valido.");
						
					}
					
				}
			
				if (controller.gestisciInserimentoArticoloCompleto(nomeArticolo, nomeCategoria, nota, prezzo)) {

			System.out.println("Articolo \"" + nomeArticolo + "\" inserito nella lista \"" + nomeLista + "\"  e registrato nel catalogo globale!");

			successo = true;
			
			} else {

				System.out.println("Errore: impossibile inserire l'articolo (probabile duplicato). Riprova.");

			}
	
		}
	
	}

	private void eseguiRimozioneArticoloDaLista() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della lista: ");

			String nomeLista = scanner.nextLine().trim();

			if (controller.ottieniLista(nomeLista) == null) {

				System.out.println("Errore: lista non trovata. Riprova.");

				continue;
			}

			System.out.print("Inserisci il nome dell'articolo da cancellare: ");

			String nomeArticolo = scanner.nextLine().trim();

			Articolo art = GestioneListe.getArticolo(nomeArticolo);

			if (controller.gestisciRimozioneArticoloDallaLista(nomeLista, art)) {

				System.out.println("Articolo spostato nella sezione dei cancellati di questa lista!");

				successo = true;

			} else {

				System.out.println("Errore: articolo non trovato nella lista selezionata. Riprova.");

			}

		}

	}

	private void eseguiRipristinoArticoloInLista() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della lista: ");

			String nomeLista = scanner.nextLine().trim();

			if (controller.ottieniLista(nomeLista) == null) {

				System.out.println("Errore: lista non trovata. Riprova.");

				continue;

			}

			System.out.print("Inserisci il nome dell'articolo da ripristinare: ");

			String nomeArticolo = scanner.nextLine().trim();

			Articolo art = GestioneListe.getArticolo(nomeArticolo);

			if (controller.gestisciRipristinoArticoloInLista(nomeLista, art)) {

				System.out.println("Articolo ripristinato correttamente nella lista attiva!");

				successo = true;

			} else {

				System.out.println("Errore: articolo non trovato nella lista dei cancellati. Riprova.");

			}

		}

	}

	private void eseguiCalcoloTotale() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della lista di cui calcolare il costo totale: ");

			String nomeLista = scanner.nextLine().trim();

			if (controller.ottieniLista(nomeLista) != null) {

				double totale = controller.ottieniCostoTotaleLista(nomeLista);

				System.out.println(
						"Il costo totale per la lista \"" + nomeLista + "\" è di: € " + String.format("%.2f", totale));

				successo = true;

			} else {

				System.out.println("Errore: lista non trovata. Riprova.");

			}

		}

	}

	private void eseguiRicercaPerPrefisso() {

		boolean successo = false;

		while (!successo) {

			System.out.print("Inserisci il nome della lista in cui cercare: ");

			String nomeLista = scanner.nextLine().trim();

			if (controller.ottieniLista(nomeLista) == null) {

				System.out.println("Errore: lista non trovata. Riprova.");

				continue;
			}

			System.out.print("Inserisci il prefisso da cercare: ");

			String prefisso = scanner.nextLine().trim();

			Articolo trovato = controller.gestisciRicercaPerPrefisso(nomeLista, prefisso);

			if (trovato != null) {

				System.out.println("Articolo trovato: " + trovato.toString());

			} else {

				System.out.println("Nessun articolo trovato con prefisso \"" + prefisso + "\" ");
			}

			successo = true;

		}

	}

}