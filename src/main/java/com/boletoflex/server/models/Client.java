package com.boletoflex.server.models;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String identify;
    private String orgIdentify;
    @Column(unique=true)
    private String document;
    private String nationality;
    private String naturalness;
    private String address;
    private Integer addressNumber;
    private String cep;
    private String city;
    private String state;
    private String birth;
    private String gender;
    private String celNumber;
    private String telNumber;
    private String comNumber;
    private String email;
    @Column(length = 102400)
    private String image;
    private Date register = Date.from(LocalDateTime.now().atZone(ZoneId.ofOffset("UTC", ZoneOffset.of("-00:00"))).toInstant());

    public Client() {
    }

    public Client(String name, String identify, String orgIdentify, String document, String nationality, String naturalness, String address, Integer addressNumber, String cep, String city, String state, String birth, String gender, String celNumber, String telNumber, String comNumber, String email, String image) {
        this.name = name;
        this.identify = identify;
        this.orgIdentify = orgIdentify;
        this.document = document;
        this.nationality = nationality;
        this.naturalness = naturalness;
        this.address = address;
        this.addressNumber = addressNumber;
        this.cep = cep;
        this.city = city;
        this.state = state;
        this.birth = birth;
        this.gender = gender;
        this.celNumber = celNumber;
        this.telNumber = telNumber;
        this.comNumber = comNumber;
        this.email = email;
        this.image = image;

    }
}
