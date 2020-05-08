package fr.epita.Quiz.ressources;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.DAO.AnswerDAO;
import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.buisness.ExamDataService;


@Path("/exam")
public class ExamResource {
	
	@Inject
	ExamDataService examDS;
	
	@Inject
	AnswerDAO answerDAO;
	
	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody Answer answer) {
		//dummy code, to be replaced
		answer.setId(1l);
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		return Response.serverError().build();
	
	}
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		//beginning dummy implementation
		Answer answer = new Answer();
		answer.setAns("This is a sampleAnswer with id " + answerId);
		answer.setId(answerId);
		return Response.ok(answer).build();
	}
	
	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswers() {
		
		Answer answer = answerDAO.getById(1l);
		
		
		return Response.ok(Arrays.asList(answer)).build();
	}
	
	
	@PUT
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response putAnswerToQuestion(@RequestBody Answer answer) {
		
		return Response.ok(Arrays.asList(answer)).build();
	
	}
	
	
	@DELETE
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteAnswerToQuestion(@RequestBody Answer answer) {
		
		return Response.ok(Arrays.asList(answer)).build();
	
	}
	
}
