package com.agendamento.samuelFumega.SamuelFumega.resources;


import com.agendamento.samuelFumega.SamuelFumega.models.Automobile;
import com.agendamento.samuelFumega.SamuelFumega.services.ServiceAutomobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automovel")
public class ResourceAutomobile {

    @Autowired
    private ServiceAutomobile serviceAutomobile;

    @GetMapping("")
    public ResponseEntity<List<Automobile>> listAll (){

        return new ResponseEntity<List<Automobile>>(serviceAutomobile.listAll(), HttpStatus.OK);

    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Automobile> getAuto(@PathVariable("codigo") int id){

        Optional<Automobile> automobileOptional = serviceAutomobile.getAuto(id);

        if (automobileOptional.isPresent()) {

            return new ResponseEntity<Automobile>(automobileOptional.get(), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/salvar")
    public ResponseEntity<Automobile> saveAuto(@RequestBody Automobile automobile){

        if (automobile.getEstoque() > 0) {

            serviceAutomobile.saveAuto(automobile);

            return new ResponseEntity<Automobile>(automobile, HttpStatus.CREATED);

        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }
    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<Automobile> delAuto(@PathVariable("codigo") int codigo){

        Optional<Automobile> optionalAutomobile = serviceAutomobile.getAuto(codigo);

        if (optionalAutomobile.isPresent()) {

            serviceAutomobile.deleteAuto(optionalAutomobile.get());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/editar/{codigo}")
    public ResponseEntity<Automobile> upAuto(@PathVariable("codigo") int codigo, @RequestBody Automobile automobile){

        Optional<Automobile> automobileOptional = serviceAutomobile.getAuto(codigo);

        if (automobileOptional.isPresent()) {

            automobile.setID(codigo);

            serviceAutomobile.saveAuto(automobileOptional.get());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
