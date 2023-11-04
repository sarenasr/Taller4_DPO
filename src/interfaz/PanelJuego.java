package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelJuego extends JPanel implements ActionListener{
	
	private JButton[][] gameButtons;
	
	private Tablero tabla;
	
	private int dificultad;
	
	private int height;
	
	private int width;

	public PanelJuego(Tablero tabla, int dificultad) {
		height = tabla.darTablero().length;
		width = tabla.darTablero().length;
		setLayout(new GridLayout(height,width));
		
	}
	
	
	public void pintarTabla(Tablero tabla, int dificultad)
	{
		this.removeAll();
		this.tabla = tabla;
		tabla.desordenar(dificultad);
		tabla.salvar_tablero();
		height = tabla.darTablero().length;
		width = tabla.darTablero().length;
		setLayout(new GridLayout(height,width));
		this.gameButtons = new JButton[height][width];
		for (int r = 0; r < height; r ++) {
			for (int c = 0; c < width; c++) {	
				JButton button = new JButton();			//creats a new JButton object.
				gameButtons[r][c] = button;				//adds the button to the array.
				button.setName(""+r+c);					//sets up the name of each button accordingly where they appear on the game board.
				button.setBackground(Color.BLACK);		//sets each button to black, turned off.
				if(tabla.darTablero()[r][c] == true)							//uses the random variable to change the color of the button to yellow, turned on.
				{
					backgroundColor(button);
				}
				button.addActionListener(this);			//adds an actionlistener to each button.
				add(button);				//adds the button to the buttonPanel.
			
			}
		}
	}
	
	public void updateTabla(Tablero tabla)
	{
		this.tabla = tabla;
		for (int r = 0; r < height; r ++) {
			for (int c = 0; c < width; c++) {
				gameButtons[r][c].setBackground(Color.BLACK);		//sets each button to black, turned off.
				if(tabla.darTablero()[r][c] == true)							//uses the random variable to change the color of the button to yellow, turned on.
				{
					backgroundColor(gameButtons[r][c]);
				}
			}
		}
	}
	
	
	private void backgroundColor(JButton b)
	{
		if(b.getBackground()==Color.BLACK)			//the button b is black, then it is changed to yellow, otherwise it is
		{											//changed to black.
			b.setBackground(Color.YELLOW);
		}
		else
		{
			b.setBackground(Color.BLACK);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		String location = button.getName();
		
		
		char colChar = location.charAt(0);				//gets the char character a position 0 of the button name.
		char rowChar = location.charAt(1);				//gets the char character a position 1 of the button name.
		int col = Character.getNumericValue(colChar);	//this int converted from the char from pos 0 will be used a column indicator.
		int row = Character.getNumericValue(rowChar);	//this int converted from the char from pos 0 will be used a row indicator.

		tabla.jugar(col, row);
		
		updateTabla(tabla);
		
		
		isWon();
	}
	
	private void isWon() {
		if (tabla.tableroIluminado() == true)
		{
			tabla.reiniciar();
			pintarTabla(tabla,dificultad);
		}
	}
	
	
}
