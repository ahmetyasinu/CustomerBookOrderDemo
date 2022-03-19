package com.ahmetyasin.demogetir.user;

import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IUserRepository repository;
    @Test
    void save() {
        UserDto userDto = new UserDto();
        userDto.setUsername("Ali");
        userDto.setPassword("214213213");
        User userMock = mock(User.class);

        when(repository.save(ArgumentMatchers.any(User.class))).thenReturn(userMock);
        userService.save(userDto);

    }

}