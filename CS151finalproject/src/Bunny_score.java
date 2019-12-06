

public class Bunny_score {


	private int [] score = new int[5]; 
	private String playerName; 
	private int game_number;
	
		public Bunny_score(int [] scoreSingle, String playerName, int g_number) {
	
		this.score= scoreSingle;
		this.playerName = playerName;
		game_number = g_number;
	}
	/**
	 * @return the game_number
	 */
	public int getGame_number() {
		return game_number;
	}

	/**
	 * @param game_number the game_number to set
	 */
	public void setGame_number(int game_number) {
		this.game_number = game_number;
	}
	/**
	 * @return the score
	 */
	public int[] getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int[] score) {
		this.score = score;
	}
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}

