Vue.component('listaDeVeiculos', {
	template: `
	<b-card>
	<b-table striped hover :items="veiculos" :fields="fields">
		<template #cell(vendido)="data">
			<i>{{ data.value ? 'Sim' : 'Não'}}</i>
		  </template>

		  <template #cell(remover)="data">
		   <b-button variant="danger" @click="removerVeiculo(data.item)">Remover
		   </b-button>
		  </template>

	</b-table>
	<b> Número de Veículos:</b> {{veiculos.length}}<br>
	<b> Número de Veículos Vendidos:</b> {{numeroVeiculosVendidos}}
</b-card>
`,
	  data: function() {
		  return {
			veiculos: [],
            fields: [
                {
                    key: 'veiculo', 
                    sortable: true,
                    label: 'Veículo'
                },

                {
                    key: 'marca', 
                    sortable: true,
                
                },
                {
                    key: 'ano', 
                    sortable: true,
                },
                {
                    key: 'descricao', 
                    sortable: true,
                    label: 'Descrição'
                },
                {
                    key: 'vendido', 
                    sortable: true,
                },
                {
                    key: 'remover'
                }
            ],
		}
	},
	mounted: function() {
		this.listarTodosVeiculos();
	},
	computed: {
		numeroVeiculosVendidos: function(){
			return this.veiculos.filter(veiculo => veiculo.vendido).length;
		},
	},
	methods: {
		listarTodosVeiculos: function(){
			let self = this;
			Veiculo.listarTodosOsVeiculos().then(function (response) {
				self.veiculos = response.data;
			}).catch((err) => {
				
			})
		},

		removerVeiculo: function(veiculo){
			let self = this;
			Veiculo.removerVeiculo(veiculo).then(function (response) {
				self.listarTodosVeiculos();
			}).catch((err) => {
				
			})
		},
	}
});