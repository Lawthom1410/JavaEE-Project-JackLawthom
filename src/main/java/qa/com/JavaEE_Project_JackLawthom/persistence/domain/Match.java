package qa.com.JavaEE_Project_JackLawthom.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long matchId;
	
	private String roundLabel;
	private String namePlayer1;
	private String namePlayer2;
	private int treeRow;
	private int treeCol;
	
	private long tournamentId;

	public Match(long matchId, String roundLabel, String namePlayer1, String namePlayer2, int treeRow, int treeCol, long tournamentId) {
		super();
		this.matchId = matchId;
		this.roundLabel = roundLabel;
		this.namePlayer1 = namePlayer1;
		this.namePlayer2 = namePlayer2;
		this.treeRow = treeRow;
		this.treeCol = treeCol;
		this.tournamentId = tournamentId;
	}
	
	public Match() {
		super();
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getRoundLabel() {
		return roundLabel;
	}

	public void setRoundLabel(String roundLabel) {
		this.roundLabel = roundLabel;
	}

	public String getNamePlayer1() {
		return namePlayer1;
	}

	public void setNamePlayer1(String namePlayer1) {
		this.namePlayer1 = namePlayer1;
	}

	public String getNamePlayer2() {
		return namePlayer2;
	}

	public void setNamePlayer2(String namePlayer2) {
		this.namePlayer2 = namePlayer2;
	}

	public int getTreeRow() {
		return treeRow;
	}

	public void setTreeRow(int treeRow) {
		this.treeRow = treeRow;
	}

	public int getTreeCol() {
		return treeCol;
	}

	public void setTreeCol(int treeCol) {
		this.treeCol = treeCol;
	}

	public long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}
	
	

}
