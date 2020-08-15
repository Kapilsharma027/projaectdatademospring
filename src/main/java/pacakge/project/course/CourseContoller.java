package pacakge.project.course;
import java.lang.reflect.Method;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pacakge.project.topic.Topic;
 // reset controller here convert it in json by itself. 
    @RestController
    public class CourseContoller {
	 //auto wired is used to inject the service
	 @Autowired
	 private CourseServce courseServce;
	 
	@ApiOperation(value = "Get All Courses  by topic's id")
	@RequestMapping(method = RequestMethod.GET, value ="/topics/{id}/course")
    public List<Course> getCourse(@PathVariable Integer id) {
		return courseServce.getAllCourses(id);
	}
	/*
	
	@RequestMapping("/topics/{foo}")
	public Topic getTopicById(@PathVariable("foo") String id) {
		return TopicServce.getTopicById(id);
	}
	OR
	below
	*/
	 @ApiOperation(value = "Get Course  by course id")
	@RequestMapping(method = RequestMethod.GET, value ="/topics/{topicid}/courses/{courseid}")
	public Course getCourseById(@PathVariable String topicid, @PathVariable Integer courseid) {
		return courseServce.getCourseById(courseid);
		
	}
	
/*	Post request
 * Default Method is Get so we don't need to specify in case of get request.
 * For Post type we have to define ,like at value "/topic" it has Request of post.
 * @RequestBody defines the to type of object in body will accept. 
*/	@ApiOperation(value = "add Course by topic id")
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable Integer topicId) {
		// Just make sure to topic id 
		course.setTopic(new Topic(topicId, "", ""));
		// and than it will replace it
		courseServce.addCourse(course);
	}
/*
 * For put we have to use both topic and id on which put
*/
    @ApiOperation(value = "Update Course by topic id")
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void upDateCourse(@RequestBody Course course, @PathVariable Integer id, @PathVariable Integer topicId) {
		// Just make sure to topic id 
				course.setTopic(new Topic(topicId, "", ""));
		courseServce.updateCourse(course);
	}
	/*
	 * For Delete have to use id on which we will delete
	*/
        @ApiOperation(value = "Delete Course  by topic id")
		@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
		public void deleteCourse(@PathVariable Integer id) {
			courseServce.delete(id);
		}
 }
