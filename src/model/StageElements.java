package model;

public abstract class StageElements {
	
	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	protected int id;
	protected double startX;
	protected double startY;
	protected double endX;
	protected double endY;
	
	public StageElements(int id, double startX, double startY, double endX, double endY) {
		this.id=id;
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
	}
	
	//-------------------------------------
	// Getters 
	//-------------------------------------
	public int getId() {
		return id;
	}

	public double getStartX() {
		return startX;
	}
	
	public double getStartY() {
		return startY;
	}
	
	public double getEndX() {
		return endX;
	}
	
	public double getEndY() {
		return endY;
	}
	
}
