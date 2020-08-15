package pacakge.project.topic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TopicRepository extends JpaRepository<Topic, Integer> {
//	  @Query("SELECT t from Topic t Where t.name LIKE '%d%'")
//		  public List<Topic> findNamedTopics();
//	  
//	  public List<Topic>  findAllByIdByNameAsc();
//	  List<Topic> topics = repository.findAll(Sort.by(Sort.Direction.ASC, "seatNumber"));

}
