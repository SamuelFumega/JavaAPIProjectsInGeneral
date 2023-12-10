package com.agendamento.samuelFumega.SamuelFumega.resources;


import com.agendamento.samuelFumega.SamuelFumega.models.Rental;
import com.agendamento.samuelFumega.SamuelFumega.services.ServiceAutomobile;
import com.agendamento.samuelFumega.SamuelFumega.services.ServiceClient;
import com.agendamento.samuelFumega.SamuelFumega.services.ServiceRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel")
public class ResouceRental {

    @Autowired
    private ServiceRental serviceRental;

    @Autowired
    private ServiceAutomobile serviceAutomobile;

    @Autowired
    private ServiceClient serviceClient;


    @GetMapping("")
    public ResponseEntity<List<Rental>> listAll (){

        return new ResponseEntity<List<Rental>>(serviceRental.listAll(), HttpStatus.OK);

    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Rental> getRent(@PathVariable("codigo") int id){

        Optional<Rental> rentalOptional = serviceRental.getAlu(id);

        if (rentalOptional.isPresent()) {

            return new ResponseEntity<Rental>(rentalOptional.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Rental> saveRent(@RequestBody Rental rental){

        if (rental.getAutomobile().getEstoque() < 0 ){

            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

        if (rental.getValue() < 0){

            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

        serviceRental.saveAlu(rental);

        serviceAutomobile.removeAutomobileInStock(rental.getAutomobile());

        return new ResponseEntity<Rental>(rental, HttpStatus.CREATED);

    }
    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<Rental> delRent(@PathVariable("codigo") int codigo){

        Optional<Rental> rentalOptional = serviceRental.getAlu(codigo);

        if (rentalOptional.isPresent()) {

            serviceRental.deleteAlu(rentalOptional.get());

            serviceAutomobile.deliveryAutomobile(rentalOptional.get().getAutomobile());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }

        else

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping("/editar/{codigo}")
    public ResponseEntity<Rental> upRent(@PathVariable("codigo") int codigo, @RequestBody Rental rental){

        Optional<Rental> rentalOptional = serviceRental.getAlu(codigo);

        if (rentalOptional.isPresent()) {

            rental.setID(codigo);

            serviceRental.saveAlu(rentalOptional.get());

            return new ResponseEntity<>(null,HttpStatus.OK);

        }
        else

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
