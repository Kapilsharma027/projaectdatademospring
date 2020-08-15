package pacakge.project.one_to_many;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/otm" )
public class OneToManyController {
	@Autowired
	private UserRepositoryotm userRepository;
	
	@Autowired
    private AddressRepositoryotm addressRepository;
	
	@Autowired
	private OneToManyService oneToManyService;

	@RequestMapping(value = "/users",  method = RequestMethod.GET)
    public List<Userotm> getUsers() {
		return oneToManyService.getAllUser();
	}
	
	@RequestMapping(value = "/users/{id}",  method = RequestMethod.GET)
    public Optional<Userotm> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void saveUser(@RequestBody UserotmDto userdto ) {
		Userotm user = new Userotm();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		
		Set<Addressotm> addressList = new HashSet<>();
		  for (Addressotm address : userdto.getAddressotm())
	        {
			  Addressotm adrs = new Addressotm();
			  adrs.setStreet(address.getStreet());
			  adrs.setCity(address.getCity());
			  adrs.setState(address.getState());
			  adrs.setZipCode(address.getZipCode());
			  adrs.setCountry(address.getCountry());
			  adrs.setUserotm(user);
			  addressList.add(adrs);
	        }
		  user.setAddressotm(addressList);
//		  Set<Addressotm> employeeAddressSet = new HashSet();
        userRepository.save(user);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	
	@RequestMapping(value = "/addresses",  method = RequestMethod.GET)
    public List<Addressotm> getAddresses() {
		List<Addressotm> addresses= new ArrayList<>();
		addressRepository.findAll().forEach(addresses :: add);
		return addresses;
	}
	
	@RequestMapping(value = "/addresses/{id}",  method = RequestMethod.GET)
    public Optional<Addressotm> getAddress(@PathVariable Long id) {
		return addressRepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addresses")
	public void saveAddress(@RequestBody Addressotm address ) {

		addressRepository.save(address);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/addresses/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressRepository.deleteById(id);
	}


}
