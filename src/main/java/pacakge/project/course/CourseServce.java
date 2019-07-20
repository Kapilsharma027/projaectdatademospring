package pacakge.project.course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service annotation define a class as businees 
@Service
public class CourseServce {
	
	@Autowired
	private CourseRepository courseRepository;
	

	
public List<Course>getAllCourses(String id){
//return topics;
	// doing it by using repository
	List<Course> courses = new ArrayList<>();
	// here findAll in iterable method by default to get all record  for every we are adding by java 8 new syntex.
	courseRepository.findByTopicId(id).forEach(courses::add);
	return courses;
}

// from any method here we can call that directly like directly it will give out put
//courseRepository.findByName("any name");

// Option is used to get rid from NULL pinter exception

public Course getCourseById(String id){
//return topics.stream().filter(obj -> obj.getId().equals(id)).findFirst().get();
	Optional<Course> course =	courseRepository.findById(id);
	return course.get();
}

// it will simple add in array topics
public void addCourse(Course course ){
//	topics.add(topic);
	courseRepository.save(course);
}

public void updateCourse(Course course) {
//for(int i =0 ;i < topics.size(); i++) {
//Topic t = topics.get(i);
//if(t.getId().equals(id)) {
//	topics.set(i, topic);
//	return;
//}
//}
//	It can update because we have instance complete with id. In case of row with id available,
//	it knows that it has to update
	courseRepository.save(course);
}
// Not need to return any thing here.
public void delete(String id) {
//topics.removeIf(f -> f.getId().equals(id));
	courseRepository.deleteById(id);
}
}
