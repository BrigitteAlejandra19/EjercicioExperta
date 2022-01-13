package com.example.ejercicioexperta.controller;

import com.example.ejercicioexperta.entity.Bar;
import com.example.ejercicioexperta.entity.BarErrorResponse;
import com.example.ejercicioexperta.exception.*;
import com.example.ejercicioexperta.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bar")
public class BarController {

    private final BarService barService;

    @Autowired
    public BarController(BarService barService) { this.barService = barService;}

    @GetMapping("/all")
    ResponseEntity <Object> showAll() {
        try {
            return ResponseEntity.ok(barService.showAllCompleteInfo()) ;
        } catch (BarSearchException e){
          return barSearchError();
        }
    }

    @GetMapping("/all/partial/info")
    ResponseEntity<Object> showAllPartialInfo() {
        try {
             return ResponseEntity.ok(barService.showAllPartialInfo());
    } catch (BarSearchException e){
            return barSearchError();
        }
    }

    @GetMapping("/detalle/{id}")
    ResponseEntity <Object> showDetailsById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(barService.showDetailsById(id));
        } catch (BarNotFoundException e) {
            return barNotFound(id);
        }
    }

    @PostMapping(path = "/save")
    ResponseEntity <Object>  save (@RequestBody Bar bar) {
        try {
            return ResponseEntity.ok(barService.save(bar));
        }catch (BarNotSaveException e) {
         return ResponseEntity.status(HttpStatus.CONFLICT)
                 .body(BarErrorResponse.build(HttpStatus.CONFLICT.value(), "Error to save the bar"));
        }
    }

    @PostMapping(path = "/init")
    ResponseEntity <Object>  init () {
        try {
            barService.init();
            return ResponseEntity.ok().build();
        } catch (BarInitException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(BarErrorResponse.build(HttpStatus.CONFLICT.value(), "Init failed"));
        } catch (BarSearchException e) {
            return barSearchError();
        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteByID(@PathVariable Integer id){
        try {
            barService.deleteByID(id);
            return ResponseEntity.noContent().build();//204
        } catch (BarNotFoundException e) {
            return barNotFound(id);
        } catch (BarDeleteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(BarErrorResponse.build(HttpStatus.CONFLICT.value(), "Can't delete bar with id : " + id));
        }
    }

    private ResponseEntity<Object> barNotFound(Integer id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(BarErrorResponse.build(HttpStatus.NOT_FOUND.value(), "Invalid bar id: " + id));
    }

    private ResponseEntity<Object> barSearchError() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(BarErrorResponse.build(HttpStatus.CONFLICT.value(), "Error to search the bars"));
    }

}
