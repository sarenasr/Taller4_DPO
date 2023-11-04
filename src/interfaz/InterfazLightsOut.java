package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.*;

public class InterfazLightsOut extends JFrame
{
	private PanelJuego gamePanel;
	
	private PanelControls controls;
	
	private PanelInfo infoPanel;
	
	private PanelMenu menuPanel;
	
	private int size;
	
	private int difficulty;
	
	private Tablero tabla;
	
	InterfazLightsOut() {
		// inicializa el mundo
		size = 3;
		difficulty = 5;
        tabla = new Tablero(size);
        


        setTitle( "LightsOut" );
        setLayout( new BorderLayout( ) );
        Dimension dimension = Toolkit.getDefaultToolkit( ).getScreenSize( );
        setSize( dimension );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        getContentPane().setBackground(new Color(0,0,0));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        gamePanel = new PanelJuego(tabla,difficulty);
        
        controls = new PanelControls(this);	
        
        pintarTabla();
		mainPanel.add(gamePanel,"Center");
		
		
				  				
		mainPanel.add(controls,"North");		
		
		infoPanel = new PanelInfo();
		mainPanel.add(infoPanel,"South");
		
		menuPanel = new PanelMenu(this);
		mainPanel.add(menuPanel,"East");
		
		
		setContentPane(mainPanel);
		setVisible(true);
        
		
	}
	
	
	public void pintarTabla() {
		//System.out.println(size);
		this.tabla = new Tablero(size);
		//System.out.println(Arrays.deepToString(tabla.darTablero()));
		gamePanel.pintarTabla(this.tabla, difficulty);
		
	}
	
	public void updateTabla() {
		gamePanel.updateTabla(this.tabla);
	}
	
	public void restartTabla() {
		tabla.reiniciar();
		updateTabla();
	}
	
	public void changeSize(int tam) {
		this.size = tam + 3;
		pintarTabla();
	}
	
	
	public void changeDifficulty(int diff) {
		this.difficulty = diff;
		tabla.desordenar(diff);
		updateTabla();
	}
	

	

	
	public static void main( String[] args )
    {
		InterfazLightsOut interfaz = new InterfazLightsOut();
		//interfaz.panelTablero.PintarTablero(null);
		interfaz.setVisible(true);
    }
    
}
