package pacakge.project.one_to_many;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;

public class UserMapper {

	
	public static UserotmDto toDto(Userotm userotm){
		UserotmDto userDto= new UserotmDto();
		BeanUtils.copyProperties(userotm, userDto);
		Set<AddressotmDto> addressdtoList = new HashSet<>();
		userotm.getAddressotm().forEach(useradress -> {
			AddressotmDto addressdto = new AddressotmDto();
			BeanUtils.copyProperties(useradress, addressdto);
			addressdtoList.add(addressdto);
		});
		userDto.setAddressotmDto(addressdtoList);
		return userDto; 
	}
}
