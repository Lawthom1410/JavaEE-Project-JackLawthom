package qa.com.JavaEE_Project_JackLawthom.service;

import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.TournamentDBRepo;

public class TournamentServiceImpl {
	
	@Inject
	private TournamentDBRepo repo;
	
	public String createTournament(String tournament) {
		return this.repo.createTournament(tournament);
	}
	
	public String deleteTournament(long id) {
		return this.repo.deleteTournament(id);
	}
	
	public String updateTournament(long id, String tournament) {
		return this.repo.updateTournament(id, tournament);
	}
	
	public String getAllTournaments() {
		return this.repo.getAllTournaments();
	}
	
	public String createMatch(String match) {
		return this.repo.createMatch(match);
	}
	
	public String deleteMatch(long id) {
		return this.repo.deleteMatch(id);
	}
	
	public String updateMatch(long id, String match) {
		return this.repo.updateMatch(id, match);
	}
	
	public String getTournamentMatches(long id) {
		return this.repo.getTournamentMatches(id);
	}

}
