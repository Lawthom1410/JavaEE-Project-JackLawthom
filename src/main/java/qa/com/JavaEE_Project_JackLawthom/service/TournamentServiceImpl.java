package qa.com.JavaEE_Project_JackLawthom.service;

import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.TournamentDBRepo;

public class TournamentServiceImpl {
	
	@Inject
	private TournamentRepo repo;
	
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

}
