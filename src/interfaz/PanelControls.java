package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelControls extends JPanel implements ActionListener{
	
	
	InterfazLightsOut mainPanel;
	
	JComboBox sizePicker;
	
	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;
	
	
	public PanelControls(InterfazLightsOut mainPanel) {
		this.mainPanel = mainPanel;
		String[] sizes = {"3x3","4x4","5x5","6X6","7x7"};
		JLabel size = new JLabel();
		size.setText("Size:");
		sizePicker = new JComboBox(sizes);
		sizePicker.addActionListener(this);
		
		JLabel difficulty = new JLabel();
		difficulty.setText("Difficulty:");
		easy = new JRadioButton("Easy");
		medium = new JRadioButton("Medium");
		hard = new JRadioButton("Hard");
		easy.setSelected(true);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		ButtonGroup difficultyGroup = new ButtonGroup();
		difficultyGroup.add(easy);
		difficultyGroup.add(medium);
		difficultyGroup.add(hard);
		
		this.setLayout(new GridLayout(1,6));	 	
		this.add(size);
		this.add(sizePicker,"North");					
		this.add(difficulty);
		this.add(easy,"North");					
		this.add(medium,"North");					
		this.add(hard,"North");		
	}
	
	public int getSizeTable()
	{
		//System.out.println(sizePicker.getSelectedIndex());
		return sizePicker.getSelectedIndex();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sizePicker) {
			mainPanel.changeSize(getSizeTable());
			//System.out.println(sizePicker.getSelectedIndex());
		}
		
		else if (e.getSource()==easy) {
			mainPanel.changeDifficulty(5);
		}
		
		else if (e.getSource()==medium) {
			mainPanel.changeDifficulty(10);
		}
		else if (e.getSource()==hard) {
			mainPanel.changeDifficulty(15);
		}
	}

}
