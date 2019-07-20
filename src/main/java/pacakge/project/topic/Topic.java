package pacakge.project.topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//annotation used to declare it is a entity 
@Entity
@Table(name = "tbltopic")
public class Topic {
//Id is used to define which key is primary.
	@Id
	@Column(name = "topicid")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public Topic() {
	}
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	
}
