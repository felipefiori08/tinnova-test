package com.cars.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.cars.entity.Veiculo;
import com.cars.model.VeiculoModel;
import com.cars.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/veiculos")
public class VeiculosApi {
    
    @Autowired
    VeiculoRepository veiculoRepository;

    @GetMapping
    public ResponseEntity<List<VeiculoModel>> getAllVeiculos(){
        try{
            List<VeiculoModel> veiculos = new ArrayList<VeiculoModel>();
            veiculos = veiculoRepository.findAll();

            return new ResponseEntity<>(veiculos, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
    }

   /* @GetMapping(value="veiculos/find")
    public ResponseEntity<List<Veiculo>> findVeiculos() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } */

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> getVeiculoById(@PathVariable int id){
        try{
            
            Optional<VeiculoModel> veiculo = veiculoRepository.findById(id);

            return new ResponseEntity(veiculo.get(), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<VeiculoModel> cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {

        try{
            VeiculoModel _veiculo = veiculoRepository.save(veiculo);
            return new ResponseEntity<>(_veiculo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel>  atualizarVeiculo(@PathVariable int id, @RequestBody Veiculo veiculo) {
        Optional<VeiculoModel> veiculoData = veiculoRepository.findById(id);

        if(veiculoData.isPresent()){
            VeiculoModel _veiculo = veiculoData.get();
            _veiculo.setVeiculo(veiculo.getVeiculo());
            _veiculo.setAno(veiculo.getAno());
            _veiculo.setMarca(veiculo.getMarca());
            _veiculo.setDescricao(veiculo.getDescricao());
            _veiculo.setVendido(veiculo.getVendido());

            return new ResponseEntity<>(veiculoRepository.save(_veiculo), HttpStatus.OK); 
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
      
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeiculoModel>  atualizarVeiculoResumido(@PathVariable int id, @RequestBody Veiculo veiculo) {
        Optional<VeiculoModel> veiculoData = veiculoRepository.findById(id);

        if(veiculoData.isPresent()){
            VeiculoModel _veiculo = veiculoData.get();
            _veiculo.setDescricao(veiculo.getDescricao());
            _veiculo.setVendido(veiculo.getVendido());

            return new ResponseEntity<>(veiculoRepository.save(_veiculo), HttpStatus.OK); 
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable int id, @RequestBody Veiculo veiculo) {
        try {
			veiculoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
        
}
