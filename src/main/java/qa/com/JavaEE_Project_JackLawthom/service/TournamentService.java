package qa.com.JavaEE_Project_JackLawthom.service;

public interface TournamentService {
	String createTournament(String tournament);
	String deleteTournament(long id);
	String updateTournament(long id, String tournament);
	String getAllTournaments();
}
