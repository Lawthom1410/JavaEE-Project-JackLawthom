package qa.com.JavaEE_Project_JackLawthom.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import qa.com.JavaEE_Project_JackLawthom.service.TournamentServiceImpl;

@Path("/Tournament")
public class TournamentController {
	
	@Inject
	TournamentServiceImpl service;
	
	@Path("/create")
	@POST
	public String createTournament(String tournament) {
		return this.service.createTournament(tournament);
	}

}
