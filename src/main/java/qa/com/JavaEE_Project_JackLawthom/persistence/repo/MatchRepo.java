package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

public interface MatchRepo {
	String createMatch(String match);
	String deleteMatch(long id);
	String updateMatch(long id, String match);
	String getTournamentMatches(long id);
}
