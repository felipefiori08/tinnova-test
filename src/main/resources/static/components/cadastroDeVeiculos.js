Vue.component('cadastroDeVeiculos', {
	template: `
	<b-card>
	<template class="bg-secondary text-light">
		<form ref="formOrient"  @submit.prevent="onSubmit">
			<b-alert variant="primary" show>Preencha todos os campos e clique em "Cadastrar"</b-alert>
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
				id="checkbox-1"
				v-model="veiculo.vendido"
				name="checkbox-1"
				value=true
				unchecked-value="not_accepted"
				>
			   Vendido
				</b-form-checkbox>

			</div>

			<b-alert variant="success" v-if="showSuccess" show>Veículo Cadastrado com Sucesso!</b-alert>
			<b-alert variant="danger" v-if="showError" show>Veículo Cadastrado com Sucesso!</b-alert>
			<b-button @click="cadastrarVeiculo" variant="success" style="float: right;">Cadastrar</b-button>
   </form>
</template>
</b-card>
`,
	  data: function() {
		  return {
			veiculo:{
                id: 0,
                veiculo: "",
                marca: "",
                ano: "",
                descricao: "",
                vendido: false
            },
			marcas:[
                "Chevrolet",
                "Fiat",
                "Ford",
                "Honda",
                "Volkswagen",
			],
			showSuccess: false,
            showError: false,
		  }
	},
	mounted: function() {
		
	},
	computed: {
	 
	},
	methods: {
		cadastrarVeiculo: function(){
			let self = this;
			Veiculo.cadastrarVeiculo(this.veiculo).then(function (response) {
				self.showSuccess = true;

				setTimeout(function(){ self.showSuccess = false }, 3000);
			}).catch((err) => {
				self.showError = true;
				setTimeout(function(){ self.showError = false }, 3000);
			})
		},
	}
});