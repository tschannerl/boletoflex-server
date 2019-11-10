package com.boletoflex.server.controllers;


import com.boletoflex.server.errors.BadRequestInfoException;
import com.boletoflex.server.models.Client;
import com.boletoflex.server.services.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;


    @GetMapping()
    public ResponseEntity<List<Client>> findAllClients(){
        try{
            List<Client> clientList = clientService.findAllClient();
            return ResponseEntity.ok().body(clientList);
        }catch (Exception e){
            logger.error("Erro ao listar todos os Clientes",e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> create(
            @RequestParam("name") String name,
            @RequestParam("identify") String identify,
            @RequestParam("orgIdentify") String orgIdentify,
            @RequestParam("document") String document,
            @RequestParam("nationality") String nationality,
            @RequestParam("naturalness") String naturalness,
            @RequestParam("address") String address,
            @RequestParam("addressNumber") String addressNumber,
            @RequestParam("cep") String cep,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("birth") String birth,
            @RequestParam("gender") String gender,
            @RequestParam("celNumber") String celNumber,
            @RequestParam("telNumber") String telNumber,
            @RequestParam("comNumber") String comNumber,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image
    ) {
        identify = this.clearNumber(identify);
        document = this.clearNumber(document);

        Client refClient;
        try {
            logger.info("Adicionando o cliente ao Banco");

            String imageString = Base64.getEncoder().encodeToString(image.getBytes());

            refClient = clientService.save(new Client(name, identify, orgIdentify, document, nationality, naturalness, address, Integer.parseInt(addressNumber), cep, city, state, birth, gender, celNumber, telNumber, comNumber, email, imageString));
        } catch (Exception ex) {
            logger.error(String.format("Problema ao inserir Cliente [%s], provavel existencia", name), ex);
            throw new BadRequestInfoException(String.format("Problema ao inserir Cliente [%s], provavel existencia", name));
        }

        return ResponseEntity.ok().body(
                refClient
        );
    }

    private String clearNumber(String number) {
        return number.replaceAll("\\D", "");
    }
}


