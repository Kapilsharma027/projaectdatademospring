package pacakge.project.topic;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// Service annotation define a class as businees 
@Service
public class TopicServce {
	
	@Autowired
	private TopicRepository topicRepository;
	

	
public List<Topic>getAllTopics(){
//return topics;
	// doing it by using repository
	List<Topic> topics = new ArrayList<>();
//	List<Topic> topics =  topicRepository.findAll(Sort.by("id"));
//	Page<Topic> topics =   topicRepository.findAll( PageRequest.of(1, 3));
	// here findAll in iterable method by default to get all record  for every we are adding by java 8 new syntex.
	topicRepository.findAll().forEach(topics :: add);
	return topics;
}

// Option is used to get rid from NULL pinter exception

public Topic getTopicById(String id){
//return topics.stream().filter(obj -> obj.getId().equals(id)).findFirst().get();
	Optional<Topic> topic=	topicRepository.findById(id);
	return topic.get();
}

// it will simple add in array topics
public void addTopic(Topic topic ){
//	topics.add(topic);
	Topic t = new Topic();

	t.setName(topic.getName());
	t.setDescription(topic.getDescription());
	topicRepository.save(t);
}

public void updateTopic(Topic topic, String id) {
//for(int i =0 ;i < topics.size(); i++) {
//Topic t = topics.get(i);
//if(t.getId().equals(id)) {
//	topics.set(i, topic);
//	return;
//}
//}
//	It can update because we have instance complete with id. In case of row with id available,
//	it knows that it has to update
	topicRepository.save(topic);
}
// Not need to return any thing here.
public void delete(String id) {
//topics.removeIf(f -> f.getId().equals(id));
	topicRepository.deleteById(id);
}
}
