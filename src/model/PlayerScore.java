package model;

public class PlayerScore {
	
	private String nickName;
	private int hits;
	private int score;
	private String time;
	private CustomDate date;
	private int ranking;
	
	public PlayerScore(String nickName, int hits, int score, String time, CustomDate date) {
		setRanking(0);
		this.nickName=nickName;
		this.hits=hits;
		this.score=score;
		this.time=time;
		this.date=date;
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
	
}
