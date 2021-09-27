package com;

import com.cars.model.VeiculoModel;
import com.cars.repository.VeiculoRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class JPAUnitTest  {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	VeiculoRepository repository;

	@Test
	public void retornaListaVaziaSeNaoExistiremVeiculos(){

		Iterable<VeiculoModel> veiculos = repository.findAll();

		assertThat(veiculos).isEmpty();
	}

	@Test
	public void deveCadastrarUmVeiculo(){
		VeiculoModel veiculo = repository.save(new VeiculoModel("Celta 1.0", "Chevrolet", 2010, "Cor prata, 2 portas", false));

		assertThat(veiculo).hasFieldOrPropertyWithValue("veiculo", "Celta 1.0");
		assertThat(veiculo).hasFieldOrPropertyWithValue("marca", "Chevrolet");
		assertThat(veiculo).hasFieldOrPropertyWithValue("ano", 2010);
		assertThat(veiculo).hasFieldOrPropertyWithValue("descricao", "Cor prata, 2 portas");
		assertThat(veiculo).hasFieldOrPropertyWithValue("vendido", false);
	}

	@Test
	public void deveRetornarAListaDeTodosOsVeiculos(){
		VeiculoModel veiculo1 = new VeiculoModel("Celta 1.0", "Chevrolet", 2010, "Cor prata, 2 portas", false);
		entityManager.persist(veiculo1);

		VeiculoModel veiculo2 = new VeiculoModel("Camaro", "Chevrolet", 2013, "Cor amarelo, 2 portas", true);
		entityManager.persist(veiculo2);

		VeiculoModel veiculo3 = new VeiculoModel("Jetta", "Volkswagen", 2018, "Cor branco, 4 portas", false);
		entityManager.persist(veiculo3);

		VeiculoModel veiculo4 = new VeiculoModel("Honda City", "Honda", 2016, "Cor chumbo, 4 portas", false);
		entityManager.persist(veiculo4);

		Iterable<VeiculoModel> tutorials = repository.findAll();

		assertThat(tutorials).hasSize(4).contains(veiculo1, veiculo2, veiculo3, veiculo4);
	}

	@Test 
	public void deveRetornarUmVeiculoAposProcuraPeloId(){
		VeiculoModel veiculo1 = new VeiculoModel("Celta 1.0", "Chevrolet", 2010, "Cor prata, 2 portas", false);
		entityManager.persist(veiculo1);

		VeiculoModel veiculo2 = new VeiculoModel("Camaro", "Chevrolet", 2013, "Cor amarelo, 2 portas", true);
		entityManager.persist(veiculo2);

		VeiculoModel veiculoEncontrado =  repository.findById(veiculo2.getId()).get();

		assertThat(veiculoEncontrado).isEqualTo(veiculo2);
	}

	@Test
	public void deveAtualizarUmVeiculoPeloId(){
		VeiculoModel veiculo1 = new VeiculoModel("Celta 1.0", "Chevrolet", 2010, "Cor prata, 2 portas", false);
		entityManager.persist(veiculo1);

		VeiculoModel veiculo2 = new VeiculoModel("Jetta", "Volkswagen", 2018, "Cor branco, 4 portas", false);
		entityManager.persist(veiculo2);

		VeiculoModel veiculoAtualizado = new VeiculoModel("Jetta 3.0", "Volkswagen", 2018, "Cor branco, 4 portas turbo", false);

		VeiculoModel veiculo = repository.findById(veiculo2.getId()).get();
		veiculo.setVeiculo(veiculoAtualizado.getVeiculo());
		veiculo.setMarca(veiculoAtualizado.getMarca());
		veiculo.setAno(veiculoAtualizado.getAno());
		veiculo.setDescricao(veiculoAtualizado.getDescricao());
		veiculo.setVendido(veiculoAtualizado.getVendido());
		repository.save(veiculo);


		VeiculoModel veiculoCheckUpdate = repository.findById(veiculo2.getId()).get();

		assertThat(veiculoCheckUpdate.getId()).isEqualTo(veiculo2.getId());
		assertThat(veiculoCheckUpdate.getVeiculo()).isEqualTo(veiculoAtualizado.getVeiculo());
		assertThat(veiculoCheckUpdate.getMarca()).isEqualTo(veiculoAtualizado.getMarca());
		assertThat(veiculoCheckUpdate.getAno()).isEqualTo(veiculoAtualizado.getAno());
		assertThat(veiculoCheckUpdate.getDescricao()).isEqualTo(veiculoAtualizado.getDescricao());
		assertThat(veiculoCheckUpdate.getVendido()).isEqualTo(veiculoAtualizado.getVendido());

	}

	@Test
	public void deveRemoverUmVeiculoPeloId(){
		VeiculoModel veiculo1 = new VeiculoModel("Celta 1.0", "Chevrolet", 2010, "Cor prata, 2 portas", false);
		entityManager.persist(veiculo1);

		VeiculoModel veiculo2 = new VeiculoModel("Camaro", "Chevrolet", 2013, "Cor amarelo, 2 portas", true);
		entityManager.persist(veiculo2);

		VeiculoModel veiculo3 = new VeiculoModel("Jetta", "Volkswagen", 2018, "Cor branco, 4 portas", false);
		entityManager.persist(veiculo3);

		repository.deleteById(veiculo2.getId());

		Iterable<VeiculoModel> veiculos = repository.findAll();

		assertThat(veiculos).hasSize(2).contains(veiculo1, veiculo3);

	
	}

}
