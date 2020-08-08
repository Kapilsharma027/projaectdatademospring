package pacakge.project.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloModel {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HelloModel(String id) {
		super();
		this.id = id;
	}
	public HelloModel() {
		super();
	}
}
