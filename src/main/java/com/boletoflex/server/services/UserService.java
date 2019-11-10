package com.boletoflex.server.services;

import com.boletoflex.server.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
