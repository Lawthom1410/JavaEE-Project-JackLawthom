package qa.com.JavaEE_Project_JackLawthom.service;

import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.TournamentDBRepo;

public class TournamentServiceImpl {
	
	@Inject
	private TournamentDBRepo repo;
	
	public String createTournament(String tournament) {
		return this.repo.createTournament(tournament);
	}
	

}
