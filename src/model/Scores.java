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
		playerScoreArrayList = new ArrayList<>();
		load("data/Untitled2.txt", ",");
	}
	private void load(String path, String sep) throws IOException {
		File f=new File(path);
		FileReader fr=new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while(line!=null) {
			String[] parts=line.split(sep);
			String nickName=parts[0];
			int hits=Integer.parseInt(parts[1]);
			int score=Integer.parseInt(parts[2]);
			String time=parts[3];
			PlayerScore py=new PlayerScore(nickName, hits, score, time);
			playerScoreArrayList.add(py);
			line=br.readLine();
		}
		br.close();
		fr.close();
		playersScoresArray = new PlayerScore[playerScoreArrayList.size()];
		for (int i = 0; i < playerScoreArrayList.size(); i++) {
			playersScoresArray[i] = playerScoreArrayList.get(i);
		}
	}
	public PlayerScore[] getAllPlayersScores() {
		return playersScoresArray;
	}
	public void setAllPlayersScores(PlayerScore[] x) {
		this.playersScoresArray = x;
	}
}
