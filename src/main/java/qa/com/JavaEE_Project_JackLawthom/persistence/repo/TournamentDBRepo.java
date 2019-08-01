package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Tournament;
import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Match;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

@Transactional(value=TxType.SUPPORTS)
public class TournamentDBRepo implements TournamentRepo {
	
	@Inject
	private JSONUtil gson;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public String createTournament(String tournament) {
		this.em.persist(this.gson.convertJson(tournament, Tournament.class));
		return "Creation Success";		
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String deleteTournament(long id) {
		TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m WHERE m.tournamentId = '"+id+"'", Match.class);
		for (Match match : query.getResultList()) {
			this.em.remove(match);
		}
		this.em.remove(this.em.find(Tournament.class, id));
		return "Deletion Success";
	}

	@Transactional(value=TxType.REQUIRED)
	public String updateTournament(long id, String tournament) {
		Tournament oldTournament = this.em.find(Tournament.class, id);
		Tournament newTournament = gson.convertJson(tournament, Tournament.class);
		
		oldTournament.setTournamentName(newTournament.getTournamentName());
		oldTournament.setUserId(newTournament.getUserId());
		this.em.persist(oldTournament);
		return "Update Success";
		
//		Query query = em.createQuery("UPDATE Tournament t "
//				+ "SET t = newTournament "
//				+ "WHERE t.tournamentId = id", Tournament.class);
//		return "Update Success";
	}
	
	public String getAllTournaments(long id) {
		TypedQuery<Tournament> query = em.createQuery("SELECT t FROM Tournament t WHERE t.userId = '"+id+"'", Tournament.class);
		return this.gson.getJson(query.getResultList());
	}
	
}
