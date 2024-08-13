package com.example.userprofile.backend.service;

import com.example.userprofile.model.User;
import com.example.userprofile.repository.UserRepository;
import com.example.userprofile.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetAllUsers(){
        User user1 = new User();
        user1.setId(1L);
        user1.setName("J1");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("J2");

        List<User> userList = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUser();

        assertEquals(2, result.size());
        assertEquals("J1", result.get(0).getName());
        assertEquals("J2", result.get(1).getName());
    }
    @Test
    public void getUserById(){
        User user = new User();
        user.setId(3L);
        user.setName("J3");

        when(userRepository.findById(3L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(3L);
        assertEquals("J3", result.getName());
    }
}
