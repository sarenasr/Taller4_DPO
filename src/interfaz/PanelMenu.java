package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener{
	
	JButton nuevo;
	JButton restart;
	JButton top10;
	JButton changePlayer;
	
	InterfazLightsOut mainPanel;
	
	public PanelMenu(InterfazLightsOut mainPanel) {
		this.mainPanel = mainPanel;
		setLayout(new GridLayout(4,1));
		nuevo = new JButton("NEW");
		restart = new JButton("RESTART");
		top10 = new JButton("TOP-10");
		changePlayer = new JButton("CHANGE PLAYER");
		
		nuevo.addActionListener(this);
		restart.addActionListener(this);
		top10.addActionListener(this);
		changePlayer.addActionListener(this);
		
		add(nuevo);
		add(restart);
		add(top10);
		add(changePlayer);
		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == nuevo) {
			//System.out.println("Nuevo");
			mainPanel.pintarTabla();
		}
		else if (e.getSource() == restart) {
			
			mainPanel.restartTabla();
		}
	}

}
