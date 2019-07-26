package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Match;

public interface MatchRepo {
	String createMatch(String match);
	String deleteMatch(long id);
	String updateMatch(long id, String match);
	String getTournamentMatches(long id);
}
