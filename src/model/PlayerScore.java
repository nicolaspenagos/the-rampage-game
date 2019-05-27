package model;

import java.io.Serializable;

public class PlayerScore implements Serializable, Comparable<PlayerScore> {

	private String nickName;
	private int hits;
	private int score;
	private String time;
	private CustomDate date;
	private int ranking;

	public PlayerScore(String nickName, int hits, int score, String time) {
		setRanking(0);
		this.nickName = nickName;
		this.hits = hits;
		this.score = score;
		this.time = time;
		this.date = new CustomDate();
	}

	public PlayerScore(String nickName, int hits, int score, String time, CustomDate cD) {
		setRanking(0);
		this.nickName = nickName;
		this.hits = hits;
		this.score = score;
		this.time = time;
		this.date = cD;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public CustomDate getDate() {
		return date;
	}

	public void setDate(CustomDate date) {
		this.date = date;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	@Override
	public int compareTo(PlayerScore another) {
		if (this.getScore() > another.getScore()) {
			return -1;
		} else if (this.getScore() == another.getScore()) {
			if (this.getTime().compareTo(another.getTime()) < 0) {
				return -1;
			} else if (this.getTime().compareTo(another.getTime()) == 0) {
				if (this.getHits() < another.getHits()) {
					return -1;
				} else if (getHits() == another.getHits()) {
					return 0;
				}
			}
		}
		return 1;
	}

}


