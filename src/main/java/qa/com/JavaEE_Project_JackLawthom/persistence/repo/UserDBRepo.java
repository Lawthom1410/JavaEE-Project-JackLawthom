package qa.com.JavaEE_Project_JackLawthom.persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Match;
import qa.com.JavaEE_Project_JackLawthom.persistence.domain.Tournament;
import qa.com.JavaEE_Project_JackLawthom.persistence.domain.User;
import qa.com.JavaEE_Project_JackLawthom.util.JSONUtil;

@Transactional(value=TxType.SUPPORTS)
public class UserDBRepo implements UserRepo {
	
	@Inject
	private JSONUtil gson;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(value=TxType.REQUIRED)
	public String createUser(String user) {
		this.em.persist(this.gson.convertJson(user, User.class));
		return "Creation Success";
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String deleteUser(long id) {
		TypedQuery<Tournament> query = em.createQuery("SELECT t FROM Tournament t WHERE t.userId = '"+id+"'", Tournament.class);
		for (Tournament tournament : query.getResultList()) {
			long tournamentId = tournament.getTournamentId();
			TypedQuery<Match> matchQuery = em.createQuery("SELECT m FROM Match m WHERE m.tournamentId = '"+tournamentId+"'", Match.class);
			for (Match match : matchQuery.getResultList()) {
				long matchId = match.getMatchId();
				this.em.remove(this.em.find(Match.class, matchId));
			}
			this.em.remove(this.em.find(Tournament.class, tournamentId));
		}
		this.em.remove(this.em.find(User.class, id));
		return "Deletion Success";
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String updateUser(long id, String user) {
		User oldUser = this.em.find(User.class, id);
		User newUser = gson.convertJson(user, User.class);
		
		oldUser.setFirstName(newUser.getFirstName());
		oldUser.setLastName(newUser.getLastName());
		oldUser.setUsername(newUser.getUsername());
		oldUser.setEmail(newUser.getEmail());
		
		this.em.persist(oldUser);
		return "Update Success";
	}
	
	public String getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		return this.gson.getJson(query.getResultList());
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String getUserByUsername(String username) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = '"+username+"'", User.class);
		try {
			return this.gson.getJson(query.getResultList().get(0));
		} catch (Exception e) {
			return "Invalid Username";
		}
	}
	
	@Transactional(value=TxType.REQUIRED)
	public String getUserById(long id) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userId = '"+id+"'", User.class);
		return this.gson.getJson(query.getResultList().get(0));
	}
	
}
