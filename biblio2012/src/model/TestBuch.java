package model;

import junit.framework.TestCase;



public class TestBuch extends TestCase {

	protected void tearDwon()  throws Exception{
		
		super.setUp();
	}
	
	public void testBuchErzeugen()
	{
		
		assertNotNull(new Buch() );
		assertTrue(new Buch() instanceof Buch);		
	}
	
	
	public void testBuchAttribute()
	{
		Buch b = new Buch();
		b.setAutor("Peter Herzel äüö");
		assertEquals("Peter Herzel äüö", b.getAutor() );
	}
	
	public void testBuchSave()
	{
		Buch b = new Buch();
		b.setAutor("Peter Herzel");
		b.setTitle("Modul 223 äüö");
		b.save();
		assertEquals("Peter Herzel", b.getAutor() );
	}
	 
	public void testBuchID()
	{
		Buch b = new Buch();
		b.setAutor("Peter Herzel");
		b.setTitle("Modul 223 äüö");
		b.save();
		assertEquals("Peter Herzel", b.getAutor() );
		assertTrue(b.getId() > 0);
	}
	
	public void testBuchSaveAndRetrie()
	{
		Buch b = new Buch();
		b.setTitle("Modul 223 äüö");
		b.setIsbn("1234");
		b.setSuchbegriffe("such");
		b.save();
		int id = b.getId();
		Buch b2 = new Buch();
		b2.load(id);
		
		assertEquals("Peter Herzel", b2.getTitle() );
		assertEquals("Peter Herzel", b2.getIsbn() );
		assertEquals("Peter Herzel", b2.getSuchbegriffe() );

		assertTrue(b.getId() > 0);
		
	}
	
	
	
}




