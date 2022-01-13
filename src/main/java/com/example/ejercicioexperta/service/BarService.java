package com.example.ejercicioexperta.service;

import com.example.ejercicioexperta.entity.Bar;
import com.example.ejercicioexperta.entity.BarDto;
import com.example.ejercicioexperta.exception.*;
import com.example.ejercicioexperta.repository.IBarRepo;
import com.example.ejercicioexperta.uitls.BarInitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BarService {

    private final IBarRepo iBarRepo;

    @Autowired
    public BarService(IBarRepo iBarRepo) { this.iBarRepo = iBarRepo; }

    public Bar save(Bar bar) throws BarNotSaveException {
        try {
            iBarRepo.save(bar);
         return bar;
        } catch (Exception e) {
            throw new BarNotSaveException();
        }
   }

    public List<Bar> showAllCompleteInfo() throws BarSearchException {
        try{
            List<Bar> bars = new ArrayList<>();
            for(Bar bar : iBarRepo.findAll()) {
                bars.add(  new Bar(
                        bar.getIdBar(),
                        bar.getNombre(),
                        bar.getDomicilio(),
                        bar.getPuntuacion(),
                        bar.getEmail(),
                        bar.getTelefono(),
                        bar.getCuit(),
                        bar.getHorario(),
                        bar.getEstacionamiento())
                );
            }
            return bars;
        } catch (Exception e) {
            throw new BarSearchException();
        }
    }

    public List<BarDto> showAllPartialInfo() throws BarSearchException {
        try{
            List<BarDto> barDtos = new ArrayList<>();
            for(Bar bar : iBarRepo.findAll()) {
            barDtos.add(  new BarDto(bar.getIdBar(), bar.getNombre(), bar.getDomicilio(), bar.getPuntuacion()));
            }
            return barDtos;
        } catch (Exception e) {
            throw new BarSearchException();
            }
    }

    public void deleteByID(Integer idBar) throws BarNotFoundException, BarDeleteException {
        if(!iBarRepo.existsById(idBar)) {
            throw new BarNotFoundException();
        }
        try{
            iBarRepo.deleteById(idBar);
        } catch (Exception e) {
            throw new BarDeleteException();
        }
    }

    public Bar showDetailsById(Integer id) throws BarNotFoundException {
        final Optional<Bar> barOpt = iBarRepo.findById(id);
        if(barOpt.isPresent()) {
            return barOpt.get();
        }
        throw new BarNotFoundException();
    }

    public void init() throws BarInitException, BarSearchException {
        if(showAllCompleteInfo().isEmpty()) {
            try {
                List<Bar> bars = BarInitUtils.createBarsInit();
                if(iBarRepo.saveAll(bars).isEmpty()) {
                    throw new BarInitException();
                }
            } catch (Exception e) {
                throw new BarInitException();
            }
        }
    }
}
