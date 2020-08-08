package pacakge.project.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HelloService2 implements HelloInterface {

	public String getMyName() {
		// TODO Auto-generated method stub
		return "kapil sharma 1";
	}

}
