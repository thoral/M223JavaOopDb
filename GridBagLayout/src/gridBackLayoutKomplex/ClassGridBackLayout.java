package gridBackLayoutKomplex;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class ClassGridBackLayout extends JPanel
{

	//Instanziere einen ButtonGroup
	ButtonGroup buttonGroup = new ButtonGroup();

	public  ClassGridBackLayout(String t) 
	{
		//Erzeuge nach Wunsch einen Rahmen 
		this.setBorder(BorderFactory.createTitledBorder(t) );	
	}
		
	public JRadioButton createRadioButton(String t, String ac) 
	{	
		JRadioButton b = new JRadioButton(t);
		b.setActionCommand(ac);
		add(b);
		buttonGroup.add(b);
		return b;
	}
	
	
}
