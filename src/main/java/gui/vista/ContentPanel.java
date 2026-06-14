package gui.vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel{
	
	private JTextArea contenuto;

	public ContentPanel() {
		setLayout(new BorderLayout());

        contenuto = new JTextArea(10, 20);
        contenuto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        contenuto.setEditable(false);

        JLabel label = new JLabel("Lista di Articoli");

        add(label, BorderLayout.NORTH);
        add(contenuto, BorderLayout.CENTER);
    }

    public void updateView(String testo) {
        contenuto.setText(testo);
    }
}
