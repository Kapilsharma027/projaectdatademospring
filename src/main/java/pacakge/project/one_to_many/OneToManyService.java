package pacakge.project.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneToManyService {

	@Autowired
	private UserRepositoryotm userRepository;
	
	
	   public List<UserotmDto> getAllUser() {
			List<Userotm> users= new ArrayList<>();
			List<UserotmDto> usersDto= new ArrayList<>();
			userRepository.findAll().forEach(users :: add);
			for(Userotm user : users) {
				UserotmDto userDto= new UserotmDto();
				userDto = UserMapper.toDto(user);
				usersDto.add(userDto);
			}
			
			return usersDto;
//		   List<Userotm> users= new ArrayList<>();
//		   userRepository.findAll().forEach(users :: add);
//		   return users;
		   
		}
}
