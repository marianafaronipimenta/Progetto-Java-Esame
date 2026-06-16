package gui.vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Pannello che visualizza il contenuto della lista di articoli selezionata.
 * Mostra gli articoli attivi, quelli cancellati e il prezzo totale.
 * 
 * @author Faroni Pimenta*/
@SuppressWarnings("serial")
public class ContentPanel extends JPanel{
	
	private JTextArea contenuto;

	/**
	 * Costruttore che inizializza il pannello del contenuto.
     * Crea l'area di testo non modificabile e la label del titolo.
	 * */
	public ContentPanel() {
		setLayout(new BorderLayout());

        contenuto = new JTextArea(10, 20);
        contenuto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        contenuto.setEditable(false);

        JLabel label = new JLabel("Lista di Articoli");

        add(label, BorderLayout.NORTH);
        add(contenuto, BorderLayout.CENTER);
    }

	/**
	 * Aggiorna il testo visualizzato nell'area di contenuto.
     *
     * @param testo    Il testo formattato da visualizzare.
     * */
    public void updateView(String testo) {
        contenuto.setText(testo);
    }
}
