package com.agendamento.samuelFumega.SamuelFumega.services;

import com.agendamento.samuelFumega.SamuelFumega.models.Rental;
import com.agendamento.samuelFumega.SamuelFumega.repositories.RepositoryRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRental {
    @Autowired
    private RepositoryRental repositoryRental;
    public void saveAlu(Rental rental){ // SALVAR aluguel

        System.out.println("foi o método POST aluguel");

        repositoryRental.save(rental);

    }
    public List<Rental> listAll(){ // LISTAR alugueis

        System.out.println("foi o método LIST aluguel");

        return repositoryRental.findAll();

    }
    public Optional<Rental> getAlu(int id){ // PEGAR aluguel DISTINTA PELO ID

        System.out.println("foi o método GET aluguel");

        return repositoryRental.findById(id);

    }
    public void deleteAlu(Rental rental){ // DELETAR aluguel DISTINTA PELO ID

        System.out.println("foi o método DELETE aluguel");

        repositoryRental.delete(rental);

    }
}
