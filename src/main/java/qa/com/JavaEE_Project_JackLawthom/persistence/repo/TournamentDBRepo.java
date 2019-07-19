package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Tournament;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

public class TournamentDBRepo {
	
	@Inject
	private JSONUtil gson;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public String createTournament(String tournament) {
		this.em.persist(this.gson.convertJson(tournament, Tournament.class));
		return "Creation Success";		
	}

}
