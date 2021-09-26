package com.cars.repository;

import com.cars.entity.Veiculo;
import com.cars.model.VeiculoModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Integer>{
    
}
