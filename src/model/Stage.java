package model;

import java.util.ArrayList;
import customsExceptions.GameEndedException;

public class Stage {

	//-------------------------------------
	// Atributtes 
	//-------------------------------------
	private Building first;
	private ArrayList<StageElements> itemsToDraw;
	private int linkedListSize;
	//-------------------------------------
	// Constructor
	//-------------------------------------
	public Stage() {
		itemsToDraw=new ArrayList<StageElements>();
		Building b1=new Building(1, 138, 268, 237, 570, "/Building1-01.jpg");
		Building b2=new Building(2, 318, 448, 329, 570,  "/Building5-01.jpg");
		Building b3=new Building(3, 518, 668, 402, 570, "/Building3-01.jpg");
		Building b4=new Building(4, 718, 838, 386, 570,  "/Building2-01.jpg");
		
		
		first=b1;
		b1.setNext(b2);
		b2.setPrev(b1);
		b2.setNext(b3);
		b3.setPrev(b2);
		b3.setNext(b4);
		b4.setPrev(b3);
		
		//addItemsToDraw();
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
	
	public int collapsing() throws GameEndedException{
		Building current=first;
		int id=0;
		if(first!=null) {
			if(current.getNext()==null) {
				if(first!=null) {
					 if(first.getCollapsed()) {
						 id=first.getId();
						 first=null;
					 }
				}
			}
			while(current.getNext()!=null) {
				if(current.getCollapsed()) {
					id=current.getId();
					deleteBuilding(current);
				}
				current=current.getNext();
				if(current.getNext()==null) {
					if(current.getCollapsed()) {
						id=current.getId();
						deleteBuilding(current);
					}
				}
			}
		}else {
			throw new GameEndedException();
		}
		return id;
	}
	/*public void addItemsToDraw() {
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
					itemsToDraw.add(currentJ);
				}
		     	currentI=currentI.getNext();
			}
			itemsToDraw.add(currentI);
		}
	}*/
	
	public void deleteBuilding(Building current) {
		Building prev=current.getPrev();
		if(current!=null) {
			if(current.getPrev()==null) {
				first=current.getNext();
				current.getNext().setPrev(null);
			}else {
				Building temp=current.getNext();
				current.getPrev().setNext(current.getNext());
				if(temp!=null)
				temp.setPrev(current.getPrev());
				
			}
			
		}
	}
	

}
