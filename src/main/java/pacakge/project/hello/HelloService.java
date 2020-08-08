package pacakge.project.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloService implements HelloInterface{
	public String getMyName() {
		return "kpail sharma";
	}
}
