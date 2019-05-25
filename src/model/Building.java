package model;

public class Building extends StageElements{
	
	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	private Building next;
	private Building prev;
	private Damage first;
	private String[] images;
	private int hits;
	
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public Building(int id, double startX, double startY, double endX, double endY) {
		super(id, startX, startY, endX, endY);
		images = new String[5];
		fillArray();
		next=null;
		prev=null;
		first=null;
		hits=0;
	}
	
	//-------------------------------------
	// Getters 
	//-------------------------------------	
	public Building getNext() {
		return next;
	}
	
	public Building getPrev() {
		return prev;
	}
	
	//-------------------------------------
	// Setters  
	//-------------------------------------
	public void setPrev(Building prev) {
		this.prev = prev;
	}
	
	public void setNext(Building next) {
		this.next = next;
	}

	//-------------------------------------
	// Methods  
	//-------------------------------------
	public void destroy(double x, double y) {
		
		hits++;
	}
	
	public void fillArray() {
		images[0]="dI1";
		images[1]="dI2";
		images[2]="dI3";
		images[3]="dI4";
		images[4]="dI5";
	}
	
	public void addDamage(double x, double y) {
		
	}


}
