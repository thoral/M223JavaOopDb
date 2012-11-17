package swing;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class RadioButtonPanel extends JPanel{

	ButtonGroup buttonGroup = new ButtonGroup();

	public RadioButtonPanel(String t) {
	
		//Nach Wunsch RAhmen erzeugen
		this.setBorder(BorderFactory.createTitledBorder(t) );	
		}
		
		public JRadioButton createRadioButton(String t, String ac) {
		// TODO Auto-generated method stub
		
		JRadioButton b = new JRadioButton(t);
		
		b.setActionCommand(ac);
		
		add(b);
		buttonGroup.add(b);
		return b;
	}
	
}
