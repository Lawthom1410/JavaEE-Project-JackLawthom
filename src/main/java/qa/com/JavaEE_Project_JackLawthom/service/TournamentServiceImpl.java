package qa.com.JavaEE_Project_JackLawthom.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.TournamentRepo;
@Default
public class TournamentServiceImpl implements TournamentService {
	
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
	
	public String getAllTournaments(long id) {
		return this.repo.getAllTournaments(id);
	}

}
