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
	private int id;

	

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
		all.add(this);
		this.id=id;
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
	public int getId() {
		return id;
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
	public boolean destroy(double x, double y) {
		boolean hit = false;
		if(x>=startX&&x<=endX&&y>=startY&&y<=endY&&!collapsed) {
			hit=true;
			hits++;
			addDamage(x,y);
			if(hits>MAX_HITS)
				collapsed = true;
		}else if(next!=null) {
			hit=next.destroy(x, y);
		}
		return hit;
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
			all.add(toAdd);
			System.out.println("FIRST");
		}else {
			
			Damage last=getLast();
			all.add(toAdd);
			last.setNext(toAdd);
			System.out.println(last.getImage());
			System.out.println(last.getImageStartX());
			System.out.println(last.getImageStartY());
		
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
