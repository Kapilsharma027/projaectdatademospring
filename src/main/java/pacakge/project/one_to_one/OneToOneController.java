package pacakge.project.one_to_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/oto" )
public class OneToOneController {
	@Autowired
	private UserRepositoryoto userRepository;
	
	@Autowired
    private AddressRepositoryoto addressRepository;

	@RequestMapping(value = "/users",  method = RequestMethod.GET)
    public List<Useroto> getUsers() {
		List<Useroto> users= new ArrayList<>();
		userRepository.findAll().forEach(users :: add);
		return users;
	}
	
	@RequestMapping(value = "/users/{id}",  method = RequestMethod.GET)
    public Optional<Useroto> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void saveUser(@RequestBody Useroto user ) {

        userRepository.save(user);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	
	@RequestMapping(value = "/addresses",  method = RequestMethod.GET)
    public List<Addressoto> getAddresses() {
		List<Addressoto> addresses= new ArrayList<>();
		addressRepository.findAll().forEach(addresses :: add);
		return addresses;
	}
	
	@RequestMapping(value = "/addresses/{id}",  method = RequestMethod.GET)
    public Optional<Addressoto> getAddress(@PathVariable Long id) {
		return addressRepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addresses")
	public void saveAddress(@RequestBody Addressoto address ) {

		addressRepository.save(address);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/addresses/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressRepository.deleteById(id);
	}


}
