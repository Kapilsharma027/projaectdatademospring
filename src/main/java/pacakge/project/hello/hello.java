/**
 * 
 */
package pacakge.project.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @author kapil.sharma
 *
 */
/** Restcontroller is a spring mvc annotation  define then it is controller class request will execute it's method on url match. 
 */
@RestController
public class hello {
/** requestMapping define execute method on match url.
*/	@ApiOperation(value = "Hello User")
	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
      public String run() {
		return "hi";
	}
	
}
