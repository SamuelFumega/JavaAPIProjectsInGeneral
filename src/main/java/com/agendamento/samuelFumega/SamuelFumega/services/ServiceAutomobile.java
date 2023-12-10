package com.agendamento.samuelFumega.SamuelFumega.services;

import com.agendamento.samuelFumega.SamuelFumega.models.Automobile;
import com.agendamento.samuelFumega.SamuelFumega.repositories.RepositoryAutomobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAutomobile {

    @Autowired
    private RepositoryAutomobile repositoryAutomobile;

    public void saveAuto(Automobile automobile){ // SALVAR automovel

        System.out.println("foi o método POST automovel");

        repositoryAutomobile.save(automobile);

    }
    public List<Automobile> listAll(){ // LISTAR autmoveis

        System.out.println("foi o método LIST automovel");

        return repositoryAutomobile.findAll();

    }
    public Optional<Automobile> getAuto(int id){ // PEGAR automovel DISTINTA PELO ID

        System.out.println("foi o método GET automovel");

        return repositoryAutomobile.findById(id);

    }
    public void deleteAuto(Automobile automobile){ // DELETAR automovel DISTINTA PELO ID

        System.out.println("foi o método DELETE automovel");

        repositoryAutomobile.delete(automobile);

    }
    public Optional<Automobile> getAuto(String name){
        return repositoryAutomobile.findByName(name);
    }

    public void deliveryAutomobile(Automobile automobile){

        System.out.println("foi o método Entrega de Automovel");

        automobile.setEstoque(automobile.getEstoque() + 1);

        saveAuto(automobile);

    }

    public void removeAutomobileInStock(Automobile automobile){

        System.out.println("foi o método Remoção de estoque do Automovel");

        automobile.setEstoque(automobile.getEstoque() - 1);

        saveAuto(automobile);

    }

}
