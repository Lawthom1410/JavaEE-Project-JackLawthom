package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Tournament;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

@Transactional(value=TxType.SUPPORTS)
public class TournamentDBRepo {
	
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
		this.em.remove(this.em.find(Tournament.class, id));
		return "Deletion Success";
	}

}
