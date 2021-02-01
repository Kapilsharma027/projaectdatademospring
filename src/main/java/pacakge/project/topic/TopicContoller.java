package pacakge.project.topic;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
 // reset controller here convert it in json by itself. 
 @RestController
public class TopicContoller {
	 //auto wired is used to inject the service
	 @Value("${spring.mail.username}")
	  private String username;
	 @Autowired
	 private TopicServce TopicServce;
	 
	 @Autowired
	  private MailContentBuilder mailContentBuilder;
	 
	  @Autowired
	    private JavaMailSender sender;
	  
	  Logger logger = LoggerFactory.getLogger(TopicContoller.class);
	  @ApiOperation(value = "Get All Mail")
	    @RequestMapping(value ="/sendMail",  method = RequestMethod.GET)
	    public String sendMail() {
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);

	        try {
	            helper.setTo("kapil.sharma@diaspark.com");
	            helper.setText(mailContentBuilder.build("Token_String"),true);
	            helper.setSubject("The Weather Man Registration Complete");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        }

	        sender.send(message);
	        return "Mail Sent Success!";
	    }
	 
	 
	 
    @ApiOperation(value = "Get All Topics")
	@RequestMapping(value = "/topics",  method = RequestMethod.GET)
    public List<Topic> getTopics() {
    	logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        System.out.println(username);
        logger.info("An INFO Message" + username);
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return TopicServce.getAllTopics();
	}
	/*
	
	@RequestMapping("/topics/{foo}")
	public Topic getTopicById(@PathVariable("foo") String id) {
		return TopicServce.getTopicById(id);
	}
	OR
	below
	*/
    @ApiOperation(value = "Get All Topics by Id")
	@RequestMapping(value = "/topics/{id}",  method = RequestMethod.GET)
	public Topic getTopicById(@PathVariable Integer id) {
		return TopicServce.getTopicById(id);
		
	}
	
/*	Post request
 * Default Method is Get so we don't need to specify in case of get request.
 * For Post type we have to define ,like at value "/topic" it has Request of post.
 * @RequestBody defines the to type of object in body will accept. 
*/	
    @ApiOperation(value = "Save Topic")
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		TopicServce.addTopic(topic);
	}
/*
 * For put we have to use both topic and id on which put
*/
    @ApiOperation(value = "Update Topic by Id")
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void upDateTopic(@RequestBody Topic topic, @PathVariable String id) {
		TopicServce.updateTopic(topic, id);
	}
	/*
	 * For Delete have to use id on which we will delete
	*/
    @ApiOperation(value = "Delete Topic by Id")
		@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
		public void deleteTopic(@PathVariable Integer id) {
			TopicServce.delete(id);
		}
 }
