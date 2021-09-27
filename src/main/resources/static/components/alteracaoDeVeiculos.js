Vue.component('alteracaoDeVeiculos', {
	template: `
	<b-card>
	<template class="bg-secondary text-light">
		<template v-if="veiculo.id == 0">
			<b-alert variant="primary" show>Digite o id de um veículo para buscar</b-alert>
			<b-alert variant="warning" v-if="veiculoNaoEncontrado" show>Não existe um veículo com o id informado!</b-alert>
			<b-form-input v-model="idBusca"></b-form-input><br>
			<b-button @click="buscarVeiculoPorId" variant="success" style="float: right;">Buscar Veículo</b-button>
		</template>

<form v-else ref="formOrient"  @submit.prevent="onSubmit">
	<b-alert variant="primary" show>Ao marcar a opção atualização resumida, apenas os campos "Descrição" e "Vendido" serão modificados na base de dados ao salvar as informações.</b-alert>

	<div class="form-group">
		<b-form-checkbox
		id="checkbox-1"
		v-model="atualizacaoResumida"
		name="checkbox-1"
		value="true"
		>
		Atualização Resumida
		</b-form-checkbox>
	</div>
	<br>

  
	<div class="form-group">
		<label> Veículo</label>
		<b-form-input v-model="veiculo.veiculo"></b-form-input>
	</div>


   <div class="form-group">
		  <label>Marca</label>
		<b-form-select v-model="veiculo.marca">
			   <b-form-select-option  v-for="marca in marcas" :value="marca"> {{marca}}  </b-form-select-option>
	   </b-form-select>
	</div>

	<div class="form-group">
		<label>Ano</label>
		<b-form-input v-model="veiculo.ano"></b-form-input>
	</div>

	<div class="form-group">
		<label>Descricao</label>
		<b-form-textarea
		id="textarea"
		v-model="veiculo.descricao"
		placeholder="Digite a descrição do veículo..."
		rows="3"
		max-rows="6"
	  ></b-form-textarea>
	</div>

	<div class="form-group">
		<b-form-checkbox
		
		v-model="veiculo.vendido"
		
		value="true"
		>
	   Vendido
		</b-form-checkbox>

	</div>

	<b-alert variant="success" v-if="showSuccess" show>Informações alteradas com sucesso!</b-alert>
	<b-alert variant="danger" v-if="showError" show>Um erro ocorreu. Revise suas informações e tente novamente!</b-alert>
	<b-button @click="veiculo.id = 0;" variant="" style="float: left;">Buscar Outro Veículo</b-button>
	<b-button @click="editarInformacoesDoVeiculo" variant="success" style="float: right;">Salvar Informações</b-button>
</form>
</template>
</b-card>
`,
	  data: function() {
		  return {
			veiculo:{
                id: 0,
            },
			marcas:[
                "Chevrolet",
                "Fiat",
                "Ford",
                "Honda",
                "Volkswagen",
			],
			idBusca: "",
			showSuccess: false,
            showError: false,
			veiculoNaoEncontrado: false,
			atualizacaoResumida: false,
		  }
	},
	mounted: function() {
		
	},
	computed: {
	 
	},
	methods: {
		buscarVeiculoPorId: function(){
			let self = this;
			Veiculo.buscarVeiculoPorId(this.idBusca).then(function (response) {
				if(response.data != null){
					self.veiculo = response.data;
				}else{
					self.veiculoNaoEncontrado = true;
				}
				
			}).catch((err) => {
				self.showError = true;
			})
		},

		editarInformacoesDoVeiculo: function(){
			this.atualizacaoResumida ? this.editarInformacoesDoVeiculoResumida() : this.editarInformacoesDoVeiculoCompleta();
		},

		editarInformacoesDoVeiculoCompleta: function() {
			let self = this;
			Veiculo.atualizarVeiculo(this.veiculo).then(function (response) {
				self.veiculo = response.data;
				self.showSuccess = true;
				setTimeout(function(){ self.showSuccess = false }, 3000);
			}).catch((err) => {
				self.showError = true;
				setTimeout(function(){ self.showError = false }, 3000);
			})
		},

		editarInformacoesDoVeiculoResumida: function(){
			let self = this;
			Veiculo.atualizarVeiculoResumido(this.veiculo).then(function (response) {
				self.veiculo = response.data;
				self.showSuccess = true;
				setTimeout(function(){ self.showSuccess = false }, 3000);
			}).catch((err) => {
				self.showError = true;
				setTimeout(function(){ self.showError = false }, 3000);
			})
		}
	}
});