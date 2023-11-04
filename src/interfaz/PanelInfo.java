package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel implements ActionListener{

	public PanelInfo()
	{
		setLayout(new GridLayout());
		JLabel jugadas = new JLabel("Jugadas:");
		JLabel counter = new JLabel("0");
		JLabel player = new JLabel("Jugador:");
		JLabel playerName = new JLabel("Guest");
		
		add(jugadas);
		add(counter);
		add(player);
		add(playerName);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
