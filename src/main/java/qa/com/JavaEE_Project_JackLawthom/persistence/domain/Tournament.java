package qa.com.JavaEE_Project_JackLawthom.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long tournamentId;
	
	private String tournamentName;

	public Tournament(long tournamentId, String tournamentName) {
		super();
		this.tournamentId = tournamentId;
		this.tournamentName = tournamentName;
	}
	
	public Tournament() {
		super();
	}

	public long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
	

}
