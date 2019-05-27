package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Scores {
	private PlayerScore[] playersScoresArray;
	private ArrayList<PlayerScore> playerScoreArrayList;
	
	public Scores() throws IOException {
		load("", "");
	}
	private void load(String path, String sep) throws IOException {
		File f=new File(path);
		FileReader fr=new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while(line!=null) {
			String[] parts=line.split(sep);
			int ranking=Integer.parseInt(parts[0]);	
		}
		
	}
	public PlayerScore[] getAllPlayersScores() {
		return playersScoresArray;
	}
	public void setAllPlayersScores(PlayerScore[] x) {
		this.playersScoresArray = x;
	}
}
