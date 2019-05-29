package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import customsExceptions.NothingSelectedException;
import customsExceptions.TheArrayIsNotProperlySortedException;

public class Scores implements Serializable {
	
	// -------------------------------------
	// Constants 
	// -------------------------------------
	public final static String PATH = "data/Untitled2.txt";
	public final static char WORLD_RANKING = 'W';
	public final static char TOP_5 = '5';
	public final static char RANKING = 'R';
	public final static char NICKNAME = 'N';
	public final static char TIME = 'T';
	public final static char HITS = 'H';
	public final static char SCORE = 'S';
	public final static char DATE = 'D';

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private PlayerScore[] playersScoresArrayToShow;
	private ArrayList<PlayerScore> playerScoreArrayList;
	private char category;
	private char typeOfSort;
	private PlayerScore current;
	private PlayerScore root;
	private PlayerScore[] topFive;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Scores(PlayerScore current) throws IOException {
		playerScoreArrayList = new ArrayList<>();
		load("data/Untitled2.txt", ",");
		setCategory(WORLD_RANKING);
		updatePlayerScoreArrayToShow();
		typeOfSort=RANKING;
		topFive = new PlayerScore[5];
	    root=null;
		this.current=current;
	}

	// -------------------------------------
	// Getters
	// -------------------------------------
	public PlayerScore[] getAllPlayersScoresToShow() {
		return playersScoresArrayToShow;
	}

	public char getCategory() {
		return category;
	}
	
	public PlayerScore getRoot() {
		return root;
	}
	
	public PlayerScore[] getTopFive() {
		return topFive;
	}

	// -------------------------------------
	// Setters
	// -------------------------------------
	public void setAllPlayersScores(PlayerScore[] x) {
		this.playersScoresArrayToShow = x;
	}

	public void setCategory(char category) {
		this.category = category;
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	private void load(String path, String sep) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			String[] parts = line.split(sep);
			String nickName = parts[0];
			int hits = Integer.parseInt(parts[1]);
			int score = Integer.parseInt(parts[2]);
			String time = parts[3];
			PlayerScore py = new PlayerScore(nickName, hits, score, time);
			playerScoreArrayList.add(py);
			line = br.readLine();
		}
		br.close();
		fr.close();

	}

	public void updatePlayerScoreArrayToShow() {
		playersScoresArrayToShow = new PlayerScore[playerScoreArrayList.size()];
		for (int i = 0; i < playerScoreArrayList.size(); i++) {
			playersScoresArrayToShow[i] = playerScoreArrayList.get(i);
		}
		sortByRankingComparable();
	}

	public void selectSorting(String option) throws NothingSelectedException {

		if (option != null) {
			switch (option) {
			case "Ranking - BubbleSort":
				sortByRankingBubbleSort();
				typeOfSort=RANKING;
				break;
			case "Nickname - BubbleSort":
				sortByNicknameBubbleSort();
				typeOfSort=NICKNAME;
				break;
			case "Hits - Selection":
				sortByHitsSelection();
				typeOfSort=HITS;
				break;
			case "Score - Selection":
				sortByScoreSelection();
				typeOfSort=SCORE;
				break;
			case "Time - Insertion":
				sortByTimeInsertion();
				typeOfSort=TIME;
				break;
			case "Date - Comparator":
				sortByDateComparator();
				typeOfSort=DATE;
				break;
			}
		} else {
			throw new NothingSelectedException();
		}
	}

	private void sortByDateComparator() {
		Arrays.parallelSort(playersScoresArrayToShow, new CustomDateComparator());
	}

	private void sortByTimeInsertion() {
		for (int i = 1; i < playersScoresArrayToShow.length; i++) {
			PlayerScore aux = playersScoresArrayToShow[i];
			int j;
			for (j=i-1; j >=0 && playersScoresArrayToShow[j].getTime().compareTo(aux.getTime())>0; j--) {
				playersScoresArrayToShow[j+1] = playersScoresArrayToShow[j];
			}
			playersScoresArrayToShow[j+1] = aux;
		 }
		
	}

	private void sortByScoreSelection() {
		int n = playersScoresArrayToShow.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (playersScoresArrayToShow[j].getScore() > playersScoresArrayToShow[min_idx].getScore())
					min_idx = j;

			PlayerScore temp = playersScoresArrayToShow[min_idx];
			playersScoresArrayToShow[min_idx] = playersScoresArrayToShow[i];
			playersScoresArrayToShow[i] = temp;
		}

	}

	private void sortByNicknameBubbleSort() {
		for (int i = playersScoresArrayToShow.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (playersScoresArrayToShow[j].getNickName()
						.compareTo(playersScoresArrayToShow[j + 1].getNickName()) > 0) {
					PlayerScore temp = playersScoresArrayToShow[j + 1];
					playersScoresArrayToShow[j + 1] = playersScoresArrayToShow[j];
					playersScoresArrayToShow[j] = temp;
				}
			}
		}

	}

	private void sortByHitsSelection() {
		int n = playersScoresArrayToShow.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (playersScoresArrayToShow[j].getHits() < playersScoresArrayToShow[min_idx].getHits())
					min_idx = j;

			PlayerScore temp = playersScoresArrayToShow[min_idx];
			playersScoresArrayToShow[min_idx] = playersScoresArrayToShow[i];
			playersScoresArrayToShow[i] = temp;
		}
	}

	public void sortByRankingComparable() {
		Arrays.sort(playersScoresArrayToShow);
		for (int i = 0; i < playersScoresArrayToShow.length; i++) {
			PlayerScore current = playersScoresArrayToShow[i];
			current.setRanking(i + 1);
		}
	}

	public void sortByRankingBubbleSort() {
		for (int i = playersScoresArrayToShow.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (playersScoresArrayToShow[j].getRanking() > playersScoresArrayToShow[j + 1].getRanking()) {
					PlayerScore temp = playersScoresArrayToShow[j + 1];
					playersScoresArrayToShow[j + 1] = playersScoresArrayToShow[j];
					playersScoresArrayToShow[j] = temp;
				}
			}
		}
	}
	
	public PlayerScore search(String x, String y) throws TheArrayIsNotProperlySortedException {
		PlayerScore px=null;
		if(typeOfSort==RANKING||typeOfSort==NICKNAME) {
			if(y.equals("Ranking - Binary Search")) {
				px=binarySearchByRanking(Integer.parseInt(x));
			}else {
				px=binarySearchByNickName(x);
			}
		}else {
			throw new TheArrayIsNotProperlySortedException();
		}
		return px;
	}

	private PlayerScore binarySearchByNickName(String nickName) {
		sortByNicknameBubbleSort();
		PlayerScore px = null;
		
		int low = 0;
		int high = playersScoresArrayToShow.length-1;
		boolean founded = false;
		
		while(low <= high&&!founded) {
			int mid = (low + high)/2;
			if(playersScoresArrayToShow[mid].getNickName().compareTo(nickName)<0) {
				low = mid +1;
			}else if(playersScoresArrayToShow[mid].getNickName().compareTo(nickName)>0) {
				high = mid -1;
			}else {
				px = playersScoresArrayToShow[mid];
				founded = true;  
			}
		}
		return px;
	}

	private PlayerScore binarySearchByRanking(int x) {
		sortByRankingComparable();
		PlayerScore px = null;
		
		int low = 0;
		int high = playersScoresArrayToShow.length-1;
		boolean founded = false;
		
		while(low <= high&&!founded) {
			int mid = (low + high)/2;
			if(playersScoresArrayToShow[mid].getRanking()<x) {
				low = mid +1;
			}else if(playersScoresArrayToShow[mid].getRanking()>x) {
				
				high = mid -1;
			}else {
			
				px = playersScoresArrayToShow[mid];
				
				founded = true;  
			}
		}
		
		return px;
		
	}
	
	public void savePlayer() throws IOException {
		PlayerScore[] temp = playersScoresArrayToShow;
		PlayerScore[] newArray= new PlayerScore[ playersScoresArrayToShow.length+1];
		for (int i = 0; i < temp.length; i++) {
			newArray[i]=temp[i];
		}
		newArray[temp.length]=current;
		playersScoresArrayToShow=newArray;
		sortByRankingComparable();
		overrideTxt();
	}
	
	public void overrideTxt() throws IOException {
		String txt="";
		
		for(int i=0; i<playersScoresArrayToShow.length;i++) {
			current=playersScoresArrayToShow[i];
			if(i<playersScoresArrayToShow.length-1)
				txt+=current.getNickName()+","+current.getHits()+","+current.getScore()+","+current.getTime()+"\n";
			else
				txt+=current.getNickName()+","+current.getHits()+","+current.getScore()+","+current.getTime();
		}
		
		PrintWriter pw = new PrintWriter(new File(PATH));
		pw.print(txt);
		pw.close();
		
	}
	
	public void generateTopFive() {
		sortByRankingComparable();
		for (int i = 0; i < 5; i++) {
			topFive[i]=playersScoresArrayToShow[i];
			addNode(playersScoresArrayToShow[i]);
		}
	}
	
	public void addNode(PlayerScore toAdd) {
		if(root==null) {
			root=toAdd;
		}else {
			PlayerScore current = root;
			boolean added = false;
			
			while(!added){
				if(root.compareTo(current)>0) {
					if(current.getRight()==null) {
						current.setRight(toAdd);
						added=true;
					}else {
						current=current.getRight();
					}
				}else {
					if(current.getLeft()==null) {
						current.setLeft(toAdd);
						added=true;
					}else {
						current=current.getLeft();
					}
				}
			}
		}
	}
	
    public int sumScores(PlayerScore n) {
    	int suma=n.getScore();
    	if(n.getLeft()==null && n.getRight()==null){
    		return suma;
    	}else{
    		if(n.getRight()==null){
    			suma+=sumScores(n.getLeft());
    		}else if(n.getRight()==null){
    			suma+=sumScores(n.getLeft());
    		}else{
    			suma+=sumScores(n.getLeft());
    			suma+=sumScores(n.getRight());
    		}
    	}
    	return suma;
    }
    
    public String palindrome1() {
    	String name="There is no one palindrome nickname";
    	boolean keep=true;
    	for (int i = 0; i < topFive.length&&keep; i++) {
			keep=((palindrome(topFive[i].getNickName())));
			name=topFive[i].getNickName();
		}
		return name;
    }
    
    public static boolean palindrome(String word) {
		return palindrome(word, 0);
	}
	
	private static boolean palindrome(String word, int n) {
		if(n == word.length()-1-n) {
			return true;
		}
		else if(word.charAt(n) == word.charAt(word.length()-1-n)) {
			return palindrome(word, n+1);
		}
		else {
			return false;
		}
	}
}

