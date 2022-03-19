package com.ahmetyasin.demogetir.user;

import com.ahmetyasin.demogetir.entity.Customer;
import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.IUserRepository;
import com.ahmetyasin.demogetir.service.OrderItemService;
import com.ahmetyasin.demogetir.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(OrderItemService.class);

    @Override
    public List<UserDto> findAll() {
        logger.info("Finding all {} datas.", UserDto.class);

        List<User> users=this.userRepository.findAll();

        return MapperHelper.convertAll(users,UserDto.class);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        User user = null;

        if (result.isPresent()) {
            user = result.get();

        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + id);
        }

        return MapperHelper.convert(user,UserDto.class);
    }

    @Transactional
    @Override
    public void save(UserDto userDto) {

        userRepository.save(MapperHelper.convertBack(userDto,User.class));

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void update(UserDto userDto, Long id) {
        userRepository.save(MapperHelper.convertBack(userDto,User.class));
    }


}
