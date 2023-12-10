package com.agendamento.samuelFumega.SamuelFumega.repositories;

import com.agendamento.samuelFumega.SamuelFumega.models.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryAutomobile extends JpaRepository<Automobile, Integer> {

    Optional<Automobile> findByName(String name);

}
