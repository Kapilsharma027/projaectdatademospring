package pacakge.project.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pacakge.project.topic.Topic;
import pacakge.project.util.AppConstant.Result;
 // reset controller here convert it in json by itself. 
 @RestController
 @RequestMapping(value="/author" )
public class AuthorContoller {
	 
	@Autowired
	private AuthorService authorService;
	
	@Autowired AuthorRepository authorRepository;
	
		@RequestMapping(method = RequestMethod.GET, value = "/search")
		public List<Author> searchAuthor() {
			return authorService.searchAuthor();
		}
		
		
		@RequestMapping(method = RequestMethod.POST, value = "/add")
		public void addTopic(@RequestBody AuthorDto authorData ) {
			Author author = new Author();
			author.setFirstName(authorData.getFirstName());
			author.setLastName(authorData.getLastName());
			author.setMobile(authorData.getMobile());
			author.setDOB(authorData.getDOB());
			author.setResult(Result.FAIL);
			authorRepository.save(author);
		}	
 }
