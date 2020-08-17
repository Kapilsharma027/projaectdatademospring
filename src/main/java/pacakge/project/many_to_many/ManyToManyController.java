package pacakge.project.many_to_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mtm" )
public class ManyToManyController {
	
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value = "/operation",  method = RequestMethod.GET)
    public void getUsers() {
		
		Post post = new Post("Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");
		Post post2 = new Post("Hibernate Many to Many Example with Spring Boot 2",
                "Learn how to map a many to many relationship using hibernate 2",
                "Entire Post content with Sample code 2");
        // Create two tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");
//        Tag tag3 = new Tag("springboot_with_hibernte");

        // Add tag references in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);
        post2.getTags().add(tag1);
        post2.getTags().add(tag2);
//        post.setTags(tag2);

        // Add post reference in the tags
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);
        tag1.getPosts().add(post2);
        tag2.getPosts().add(post2);
        
        postRepository.save(post);
        postRepository.save(post2);

 
	}
	
}
