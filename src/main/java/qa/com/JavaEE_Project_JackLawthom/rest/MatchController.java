package qa.com.JavaEE_Project_JackLawthom.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import qa.com.JavaEE_Project_JackLawthom.service.MatchServiceImpl;

@Path("/Match")
public class MatchController {
	
	@Inject
	MatchServiceImpl service;
	
	@Path("/create")
	@POST
	public String createMatch(String match) {
		return this.service.createMatch(match);
	}
	
	@Path("/delete/{id}")
	@DELETE
	public String deleteMatch(@PathParam("id") long id) {
		return this.service.deleteMatch(id);
	}
	
	@Path("/update/{id}")
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
