package model;

public class Building extends StageElements{
	//-------------------------------------
	// Constants  
	//-------------------------------------
	public final static int MAX_HITS = 10;
	
	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	private Building next;
	private Building prev;
	private Damage first;
	private String[] images;
	private int hits;

	

	private boolean collapsed;
	
	
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public Building(int id, double startX, double startY, double endX, double endY, String image) {
		super(startX, startY, endX, endY, image);
		images = new String[5];
		fillArray();
		collapsed=false;
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
	
	public Damage getFirst() {
		return first;
	}
	
	public boolean getCollapsed() {
		return collapsed;
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
		if(x>=startX&&x<=endX&&y>=startY&&y<=endY) {
			hits++;
			addDamage(x,y);
			if(hits>MAX_HITS)
				collapsed = true;
		}else if(next!=null) {
			next.destroy(x, y);
		}
	}
	
	public void fillArray() {
		images[0]="dI1";
		images[1]="dI2";
		images[2]="dI3";
		images[3]="dI4";
		images[4]="dI5";
	}
	
	public void addDamage(double x, double y) {
		y=y+8;
		x=x+8;
		Damage toAdd = new Damage(x,(x+Damage.HEIGTH),y,(y+Damage.HEIGTH), generateImageId());
		if(first==null) {
			first=toAdd;
		}else {
			Damage last=getLast();
			last.setNext(toAdd);
		}
	}
	
	public String generateImageId() {
		int number=(int) (Math.random() * 4) + 1;
		return "damage"+number+".png";	
	}
	
	public Damage getLast() {
		Damage current=first;
		while(current.getNext()!=null) {
			current=current.getNext();
		}
		return current;
	}


}
