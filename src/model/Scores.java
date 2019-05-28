package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import customsExceptions.NothingSelectedException;

public class Scores implements Serializable {

	// -------------------------------------
	// Constants
	// -------------------------------------
	public final static char WORLD_RANKING = 'W';
	public final static char TOP_5 = 'T';

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private PlayerScore[] playersScoresArrayToShow;
	private ArrayList<PlayerScore> playerScoreArrayList;
	private char category;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Scores() throws IOException {
		playerScoreArrayList = new ArrayList<>();
		load("data/Untitled2.txt", ",");
		setCategory(WORLD_RANKING);
		updatePlayerScoreArrayToShow();
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
				break;
			case "Nickname - BubbleSort":
				sortByNicknameBubbleSort();
				break;
			case "Hits - Selection":
				sortByHitsSelection();
				break;
			case "Score - Selection":
				sortByScoreSelection();
				break;
			case "Time - Insertion":
				sortByTimeInsertion();
				break;
			case "Date - Comparator":
				sortByDateComparator();
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

}
