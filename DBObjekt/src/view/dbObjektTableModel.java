package view;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class dbObjektTableModel extends AbstractTableModel implements
		TableModel {

	String[] columnNames = {
			"Kind Klasse",
			"Kind Name",
			"Buch Isbn",
			"Buch Titel",
			"Buch Suchbegriffe"
	};
	
	@Override
	/*	Hole mir den Index aus dem Array 
	 * (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return columnNames[c];
	}

	//@Override SPalten
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	//@Override Zeilen
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override  Inhalt
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
