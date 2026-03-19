package com.example.demo.mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.impl.UserServiceImpl;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testMockRemoveUser() {
        doNothing().when(userRepository).deleteById(1);
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        userService.deleteUser(1);
        assertThrows(IllegalArgumentException.class, () -> userService.findByIdUser(1));
        verify(userRepository, times(1)).deleteById(1);
    }

    @Test
    public void testMockPageableUsers() {
            when(userRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of()));
    
            Page<User> page = userService.findAllUsers(0, 1);
    
            assertThrows(IndexOutOfBoundsException.class, () -> page.getContent().get(0));
            verify(userRepository, times(1)).findAll(any(Pageable.class));
    }
}
