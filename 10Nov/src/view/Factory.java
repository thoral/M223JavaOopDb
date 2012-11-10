package view;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;



public class Factory extends JFrame  {

private JPanel mainPanel = new JPanel();
ButtonGroup buttonGroup = new ButtonGroup();

public JTextField addField(String name) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		JTextField tf = new JTextField(40);
		
		mainPanel.add(new JLabel (name) );
		mainPanel.add(tf, gbc);
		return tf;
	}

public RadioButtonPanel(String t) {
	
	//Nach Wunsch Rahmen erzeugen
this.setBorder(BorderFactory.createTitledBorder(t) );
mainPanel.add(buttonGroup);

}

public JRadioButton createRadioButton(String t, String ac) {
	// TODO Auto-generated method stub
	
	JRadioButton b = new JRadioButton(t);	
	b.setActionCommand(ac);	
	add(b);
	buttonGroup.add(b);
	mainPanel.add(buttonGroup);
	return b;
}

public JPanel getPanel() {
	
	mainPanel.setLayout( new GridBagLayout() );
	return mainPanel;
}

	
	
}
