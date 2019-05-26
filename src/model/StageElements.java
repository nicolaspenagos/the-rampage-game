package model;

import java.util.ArrayList;

public class StageElements {
	
	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	protected double startX;
	protected double startY;
	protected double endX;
	protected double endY;
	protected String image;
	private double width;
	private double height;
	protected ArrayList<StageElements> all;
	
	public StageElements(double startX, double endX, double startY, double endY, String image) {
		all=new ArrayList<>();
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
		this.image=image;
		width=endX-startX;
		height=endY-startY;
	}
	
	//-------------------------------------
	// Getters 
	//-------------------------------------
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
	
	public String getImage() {
		return image;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
}
