package model;

import java.util.ArrayList;

public class Stage {

	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	private Building first;
	private ArrayList<StageElements> itemsToDraw;
	
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public Stage() {
		itemsToDraw=new ArrayList<StageElements>();
		Building b1=new Building(1, 200, 374, 353, 733, "/Building1-01.jpg");
		Building b2=new Building(2, 372, 489, 477, 733,  "/Building5-01.jpg");
		Building b3=new Building(3, 543, 694, 402, 733, "/Building3-01.jpg");
		Building b4=new Building(4, 766, 863, 539, 733,  "/Building2-01.jpg");
		
		first=b1;
		b1.setNext(b2);
		b2.setPrev(b1);
		b2.setNext(b3);
		b3.setPrev(b2);
		b3.setNext(b4);
		b4.setPrev(b3);
		
		addItemsToDraw();
	}
	
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public void hit(double x, double y) {
		first.destroy(x, y);
	}
	//-------------------------------------
	// Getters
	//-------------------------------------
	public ArrayList<StageElements> getItemsToDraw(){
		return itemsToDraw;
	}
	public Building getFirst() {
		return first;
	}
	
	//-------------------------------------
	// Methods
	//-------------------------------------
	public void addItemsToDraw() {
		itemsToDraw.clear();
		deleteBuilding();
		Building currentI=first;
		if(first!=null) {
			while(currentI.getNext()!=null) {
				itemsToDraw.add(currentI);
				Damage currentJ=currentI.getFirst();
				if(currentJ!=null) {
					while(currentJ.getNext()!=null) {
						itemsToDraw.add(currentJ);
						currentJ=currentJ.getNext();
					}
				}
				currentI=currentI.getNext();
				if(currentI.getNext()==null) {
					itemsToDraw.add(currentI);
				}
			}
		}
	}
	
	public void deleteBuilding() {
		Building prev=first.getPrev();
		Building current=first;
		if(first!=null) {
			while(current.getNext()!=null) {
				if(current.getCollapsed()) {
					prev.setNext(current.getNext());
					current.getNext().setPrev(prev);
				}
				prev=current;
				current=current.getNext();
			}
			
		}
	}
	

}
