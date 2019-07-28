package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Match;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

@Transactional(value=TxType.SUPPORTS)
public class MatchDBRepo implements MatchRepo {
	
	@Inject
	private JSONUtil gson;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public String createMatch(String match) {
		this.em.persist(this.gson.convertJson(match, Match.class));
		return "Creation Success";	
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String deleteMatch(long id) {
		this.em.remove(this.em.find(Match.class, id));
		return "Deletion Success";
	}

	@Transactional(value=TxType.REQUIRED)
	public String updateMatch(long id, String match) {
		Match oldMatch = this.em.find(Match.class, id);
		Match newMatch = gson.convertJson(match, Match.class);
		
		oldMatch.setRoundLabel(newMatch.getRoundLabel());
		oldMatch.setNamePlayer1(newMatch.getNamePlayer1());
		oldMatch.setNamePlayer2(newMatch.getNamePlayer2());
		oldMatch.setTreeRow(newMatch.getTreeRow());
		oldMatch.setTreeCol(newMatch.getTreeCol());
		oldMatch.setTournamentId(newMatch.getTournamentId());
		this.em.persist(oldMatch);
		return "Update Success";
	}
	
	public String getTournamentMatches(long id) {
		TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m WHERE m.tournamentId = '"+id+"'", Match.class);
		return this.gson.getJson(query.getResultList());
	}

}
