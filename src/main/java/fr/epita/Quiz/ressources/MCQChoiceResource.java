package fr.epita.Quiz.ressources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.DAO.MCQChoiceDAO;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
@Path("/MCQChoice")
public class MCQChoiceResource {
	
	@Inject
	MCQChoiceDAO mcqchoicedao; 
	
	
	
	@POST
	@Path("/createMCQChoice")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody MCQChoice[] mcqchoices) {
		for (MCQChoice mcqChoice : mcqchoices) {
			mcqchoicedao.insert(mcqChoice);
		}
		
		return Response.ok(mcqchoices).build();
	}

}
