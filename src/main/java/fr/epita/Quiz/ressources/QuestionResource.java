package fr.epita.Quiz.ressources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;

import fr.epita.quiz.DAO.MCQChoiceDAO;
import fr.epita.quiz.DAO.QuestionDAO;
import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;

@Path("/Questions")
public class QuestionResource {
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqchoiceDAO;
	
	@GET
	@Path("/getAllQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		List<Question> list = questionDAO.getAllData();
		System.out.println(list);
		return Response.ok(list).build();
	}
	
	@POST
	@Path("/createQuestion")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody Question question) {
		questionDAO.insert(question);
		return Response.ok(question).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnsToQuestion(@PathParam("id") long questionId){
		
		mcqchoiceDAO.deleteChild(questionId);
		questionDAO.delete(questionId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "Success");
		String id = String.valueOf(questionId);
		map.put("id",id);
		return Response.ok(map).build();
	}
	
	@PUT
	@Path("/EditQuestion")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response editQuestion(@RequestBody Question question){
		
		
	
	
	questionDAO.update(question);
		return Response.ok(question).build();
	}
	
	
}
