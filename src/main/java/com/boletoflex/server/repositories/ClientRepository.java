package com.boletoflex.server.repositories;

import com.boletoflex.server.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
