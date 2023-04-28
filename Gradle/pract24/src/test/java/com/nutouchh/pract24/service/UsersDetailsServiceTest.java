package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.User;
import com.nutouchh.pract24.repository.UserRepository;
import com.nutouchh.pract24.security.UsersDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsersDetailsServiceTest {
    private UsersDetailsService usersDetailsService;
    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        usersDetailsService = new UsersDetailsService(userRepositoryMock);
    }

    @Test
    void loadUserByUsername_UserExists_ReturnsUserDetails() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");
        user.setPassword("testPassword");
        when(userRepositoryMock.findByUsername("testUser")).thenReturn(Optional.of(user));

        // Act
        UserDetails userDetails = usersDetailsService.loadUserByUsername("testUser");

        // Assert
        assertNotNull(userDetails);
        assertEquals(user.getUsername(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    void loadUserByUsername_UserDoesNotExist_ThrowsUsernameNotFoundException() {
        // Arrange
        when(userRepositoryMock.findByUsername("nonExistingUser")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> usersDetailsService.loadUserByUsername("nonExistingUser"));
    }
}