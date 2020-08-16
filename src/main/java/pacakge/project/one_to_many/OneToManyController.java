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
    public List<UserotmDto> getUsers() {
//		List<Userotm> users = new ArrayList<>();
//		users = userRepository.findAll();
//		return users;
		return oneToManyService.getAllUser();
	}
	
	@RequestMapping(value = "/users/{id}",  method = RequestMethod.GET)
    public UserotmDto getUser(@PathVariable Long id) {
		
		Userotm user = userRepository.getOne(id);
		UserotmDto userDto= new UserotmDto();
		userDto = UserMapper.toDto(user);
		 return userDto;
//		return userRepository.findById(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void saveUser(@RequestBody UserotmDto userdto ) {
		Userotm user = new Userotm();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		
		Set<Addressotm> addressList = new HashSet<>();
		  for (AddressotmDto address : userdto.getAddressotmDto())
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
// This method is created just to check fetch type
	@RequestMapping(value = "/usersf",  method = RequestMethod.GET)
    public void getUsersf() {
		List<Userotm> users = new ArrayList<>();
		users = userRepository.findAll();
		users.forEach(System.out::println);
//		return oneToManyService.getAllUser();
	}
	
	// This method is created just to check fetch type
	@RequestMapping(value = "/usersf/{id}",  method = RequestMethod.GET)
    public Optional<Userotm> getUserf(@PathVariable Long id) {
		
		return userRepository.findById(id);
//		user.forEach(System.out::println);
//		return userRepository.findById(id);
		
	}
}
