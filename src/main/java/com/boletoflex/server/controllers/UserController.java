package com.boletoflex.server.controllers;


import com.boletoflex.server.errors.BadRequestInfoException;
import com.boletoflex.server.models.Client;
import com.boletoflex.server.models.User;
import com.boletoflex.server.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping(path = {"/login"})
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password){
        Optional<User> user;
        try {
            logger.info("Buscando o usuário");
            user = userService.findByUsername(username);

            if (!user.isPresent()){
                logger.error(String.format("Usuário [%s] não localizado", username));
                throw new BadRequestInfoException(String.format("Usuário [%s] não localizado", username));
            }else {
                if (!user.get().getPassword().equals(password)){
                    logger.error(String.format("Credenciais incorretas para o usuário [%s]", username));
                    throw new BadRequestInfoException(String.format("Credenciais incorretas para o usuário [%s]", username));
                }
            }
        } catch (Exception ex) {
            logger.error(String.format("Problema ao buscar o usuario [%s]", username), ex);
            throw new BadRequestInfoException(String.format("Problema ao buscar o usuario [%s]", username));
        }

        return ResponseEntity.ok().body(
              user.get()
        );
    }

}
