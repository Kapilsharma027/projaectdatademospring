package pacakge.project.course;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	// here only we have implementation and 
public List<Course> findByTopicId(String topicId);
}
