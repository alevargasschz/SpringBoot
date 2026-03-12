package com.example.demo.integrations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IUserService;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceIntegrationTest {
    
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired  
    private IUserService userService;

    private User buildValidUser(String name, String email) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPasswordHash("123456");
        user.setCreatedAt(Timestamp.valueOf("2025-03-11 10:10:10"));

        Role role = new Role();
        role.setName("NewRole");
        role.setDescription("A new role for testing");
        roleRepository.save(role);

        user.setRole(role);
        return user;
    }

    @Test
    public void testRemoveUser() {
        User user = buildValidUser("testuser", "testuser@example.com");
        userService.saveUser(user);
        userService.deleteUser(user.getId());

        assertThrows(IllegalArgumentException.class, () -> userService.findByIdUser(user.getId()));
    }


    @Test
    public void testPageableUsers() {
        User user1 = buildValidUser("userTest1" , "user1@example.com");
        userService.saveUser(user1);
        User user2 = buildValidUser("userTest2" , "user2@example.com");
        userService.saveUser(user2);

        Page<User> page = userService.findAllUsers(0, 1);

        assertEquals(1, page.getSize());
        assertEquals(user1, page.getContent().get(0));
    }
}
