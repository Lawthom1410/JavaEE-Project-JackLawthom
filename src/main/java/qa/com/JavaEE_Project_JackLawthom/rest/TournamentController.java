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
	
	@Path("/getUserTournaments/{id}")
	@GET
	public String getAllTournaments(@PathParam("id") Long id) {
		return this.service.getAllTournaments(id);
	}

}
