package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

public interface TournamentRepo {
	String createTournament(String tournament);
	String deleteTournament(long id);
	String updateTournament(long id, String tournament);
	String getAllTournaments(long id);
}
