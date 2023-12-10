package com.agendamento.samuelFumega.SamuelFumega.resources;


import com.agendamento.samuelFumega.SamuelFumega.models.Automobile;
import com.agendamento.samuelFumega.SamuelFumega.models.Client;
import com.agendamento.samuelFumega.SamuelFumega.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ResourceClient {

    @Autowired
    private ServiceClient serviceClient;

    @GetMapping("")
    public ResponseEntity<List<Client>> listAll (){

        return new ResponseEntity<List<Client>>(serviceClient.listAll(), HttpStatus.OK);

    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Client> getClient(@PathVariable("codigo") int id){

        Optional<Client> optionalClient = serviceClient.getCli(id);

        if (optionalClient.isPresent()) {

            return new ResponseEntity<Client>(optionalClient.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/salvar")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){

        serviceClient.saveCli(client);

        return new ResponseEntity<Client>(client, HttpStatus.CREATED);

    }
    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<Client> delClient(@PathVariable("codigo") int codigo){

        Optional<Client> optionalCliente = serviceClient.getCli(codigo);

        if (optionalCliente.isPresent()) {

            serviceClient.deleteCli(optionalCliente.get());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/editar/{codigo}")
    public ResponseEntity<Client> upClient(@PathVariable("codigo") int codigo, @RequestBody Client client){
        Optional<Client> optionalClient = serviceClient.getCli(codigo);

        if (optionalClient.isPresent()) {
            client.setID(codigo);

            serviceClient.saveCli(optionalClient.get());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
