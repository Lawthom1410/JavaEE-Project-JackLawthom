package qa.com.JavaEE_Project_JackLawthom.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import qa.com.JavaEE_Project_JackLawthom.persistence.repo.MatchRepo;
@Default
public class MatchServiceImpl implements MatchService {
	
	@Inject
	private MatchRepo repo;
	
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
