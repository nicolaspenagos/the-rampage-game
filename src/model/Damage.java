package model;

public class Damage extends StageElements{
	//-------------------------------------
    // Constants  
    //-------------------------------------
	public final static double WIDTH=68.0;
	public final static double HEIGTH=68.0;
	
	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	private double imageStartX;
	private double imageStartY;
	private double imageEndX;
	private double imageEndY;
	private Damage next;

	
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public Damage(double startX, double endX, double startY, double endY, String image) {
		super(startX, startY, endX, endY, image);
		this.image=image;
		imageStartX=0;
		imageStartY=0;
		imageEndX=0;
		imageEndY=0;
		next=null;
	}
	
	//-------------------------------------
	// Getters 
	//-------------------------------------	
	public double getImageStartX() {
		return imageStartX;
	}

	public double getImageEndX() {
		return imageEndX;
	}
	
	public double getImageStartY() {
		return imageStartY;
	}
	
	public double getImageEndY() {
		return imageEndY;
	}
	
	public Damage getNext() {
		return next;
	}
	
	//-------------------------------------
	// Setters  
	//-------------------------------------
	public void setImageStartX(double imageStartX) {
		this.imageStartX = imageStartX;
	}

	public void setImageEndX(double imageEndX) {
		this.imageEndX = imageEndX;
	}

	public void setImageStartY(double imageStartY) {
		this.imageStartY = imageStartY;
	}
	
	public void setImageEndY(double imageEndY) {
		this.imageEndY = imageEndY;
	}
	
	public void setNext(Damage next) {
		this.next=next;
	}
	
	

}
