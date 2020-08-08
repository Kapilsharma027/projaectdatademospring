package pacakge.project.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pacakge.project.topic.Topic;
//annotation used to declare it is a entity 
@Entity
public class Course {
//Id is used to define which key is primary.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
// create an instance of Topic to tie it with Topic	
	
	@ManyToOne
	private Topic topic;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public Course() {
	}
	public Course(Integer id, String name, String description, Integer topicid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicid, "", "");
	}
	// getters and setters
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
