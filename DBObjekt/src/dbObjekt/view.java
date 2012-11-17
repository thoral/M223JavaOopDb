package dbObjekt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class view extends JFrame implements ActionListener{

	
	JButton neu = new JButton("new");
	JLabel laname = new JLabel("Name");
	JLabel labuch = new JLabel("Buch");
	JTextField jtname = new JTextField(15);
	JTextField jtbuch = new JTextField(15);
	
	
	
	public view()
	{
		super ("Buchbibliiothek");
		GridBagLayout  gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.getContentPane().setLayout(gbl);
		gbc.insets = new Insets(2,2,2,2);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(laname, gbc);
		add(laname);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(jtname, gbc);
		add(jtname);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbl.setConstraints(labuch, gbc);
		add(labuch);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbl.setConstraints(jtbuch, gbc);
		add(jtbuch);
		
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		neu.addActionListener(this);
		gbl.setConstraints(neu, gbc);
		add(neu);
		
		pack();
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()  ==  neu) dispose();  
		{
			kind k = new kind(jtname.getText(), jtbuch.getText() );
			
		}
		
	}
	
	public static void main(String[] args){
		
		view demo = new view();
		demo.setVisible(true);
	}
	
	
}
