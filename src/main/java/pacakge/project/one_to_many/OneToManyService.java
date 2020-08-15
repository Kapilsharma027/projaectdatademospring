package pacakge.project.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OneToManyService {

	@Autowired
	private UserRepositoryotm userRepository;
	
	
	   public List<Userotm> getAllUser() {
			List<Userotm> users= new ArrayList<>();
			userRepository.findAll().forEach(users :: add);
			return users;
		}
}
