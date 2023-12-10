package com.agendamento.samuelFumega.SamuelFumega.services;

import com.agendamento.samuelFumega.SamuelFumega.models.Client;
import com.agendamento.samuelFumega.SamuelFumega.repositories.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClient {

    @Autowired
    private RepositoryClient repositoryClient;

    public void saveCli(Client client){ // SALVAR cliente

        System.out.println("foi o método POST cliente");

        repositoryClient.save(client);

    }
    public List<Client> listAll(){ // LISTAR clientes

        System.out.println("foi o método LIST cliente");

        return repositoryClient.findAll();

    }
    public Optional<Client> getCli(int id){ // PEGAR cliente DISTINTA PELO ID

        System.out.println("foi o método GET cliente");

        return repositoryClient.findById(id);

    }
    public void deleteCli(Client client){ // DELETAR cliente DISTINTA PELO ID

        System.out.println("foi o método DELETE cliente");

        repositoryClient.delete(client);

    }
    public Optional<Client> getCli(String name){
        return repositoryClient.findByName(name);
    }
    public Optional<Client> getCliEmail(String email){
        return repositoryClient.findByEmail(email);
    }

}
