const Veiculo = {

  listarTodosOsVeiculos: function() {
	  return axios_api.get('veiculos/');
  },
  
  buscarVeiculoPorId: function(idVeiculo){
	return axios_api.get('veiculos/'+idVeiculo);
  },
  
  cadastrarVeiculo: function(veiculo){
    return axios_api.post('veiculos/',veiculo);
  },

  removerVeiculo: function(veiculo){
    return axios_api.delete('veiculos/'+veiculo.id);
  },

  atualizarVeiculo: function(veiculo){
    return axios_api.put('veiculos/'+veiculo.id, veiculo);
  },

  atualizarVeiculoResumido: function(veiculo){
    return axios_api.patch('veiculos/'+veiculo.id, veiculo);
  }

};
