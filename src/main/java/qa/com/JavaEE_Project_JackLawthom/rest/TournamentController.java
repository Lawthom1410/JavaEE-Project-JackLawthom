package qa.com.JavaEE_Project_JackLawthom.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	
	@Path("/delete/{id}")
	@DELETE
	public String deleteTournament(@PathParam("id") Long id) {
		return this.service.deleteTournament(id);
	}
	
	@Path("/update/{id}")
	@POST
	public String updateTournament(@PathParam("id") Long id, String tournament) {
		return this.service.updateTournament(id, tournament);
	}
	
	@Path("/getAll")
	@GET
	public String getAllTournaments() {
		return this.service.getAllTournaments();
	}
	
	@Path("/createMatch")
	@POST
	public String createMatch(String match) {
		return this.service.createMatch(match);
	}
	
	@Path("/deleteMatch/{id}")
	@DELETE
	public String deleteMatch(@PathParam("id") long id) {
		return this.service.deleteMatch(id);
	}
	
	@Path("/updateMatch/{id}")
	@POST
	public String updateMatch(@PathParam("id") Long id, String match) {
		return this.service.updateMatch(id, match);
	}
	
	@Path("/getTournamentMatches/{id}")
	@GET
	public String getTournamentMatches(@PathParam("id") Long id) {
		return this.service.getTournamentMatches(id);
	}

}
