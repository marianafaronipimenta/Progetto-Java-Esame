package gui.vista;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Dialogo per l'inserimento o la modifica di un articolo.
 * Permette di specificare nome, prezzo, categoria e nota.
 * 
 * @author Faroni Pimenta
 */
public class DialogoArticolo {
	private JTextField nome;
	private JTextField prezzo;
	private JTextField categoria;
	private JTextField nota;
	private JComponent inputs[];
	
	
	public DialogoArticolo() {
		nome = new JTextField(20);
		prezzo = new JTextField(20);
		categoria = new JTextField(20);
		nota = new JTextField(20);
		
		inputs = new JComponent[] {
			new JLabel("Inserisci il nome del nuovo articolo:"), nome,
			new JLabel("Inserisci la categoria del nuovo articolo:"), categoria,
			new JLabel("Inserisci il prezzo del nuovo articolo:"), prezzo,
			new JLabel("Inserisci la nota del nuovo articolo:"), nota
		};
	}
	
	/**
	 *  Mostra il dialogo e restituisce i valori inseriti dall'utente.
     *
     * @param msg Il titolo del dialogo.
     * @return array con [nome, prezzo, categoria, nota] o null se annullato.
     */
	public String[] getInputs(String msg) {
		int risultato = JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.OK_CANCEL_OPTION);
		
		if(risultato == JOptionPane.OK_CANCEL_OPTION)
		{
			return new String[] {
				nome.getText(),
				prezzo.getText(),
				categoria.getText(),
				nota.getText()
			};
		}
		else {
			return null;
		}
	}

}
