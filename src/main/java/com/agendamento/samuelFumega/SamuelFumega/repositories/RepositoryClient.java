package com.agendamento.samuelFumega.SamuelFumega.repositories;

import com.agendamento.samuelFumega.SamuelFumega.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryClient extends JpaRepository<Client, Integer> {
    Optional<Client> findByName(String name);
    Optional<Client> findByEmail(String email);

}
