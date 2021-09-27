const axios_api = axios.create({
	baseURL: ApiConfig.baseURL + ApiConfig.apiPath ,
	timeout: 60000,
	headers: { 'X-Custom-Header': 'foobar' }
});

axios_api.interceptors.request.use(request => {

	request.headers.authorization = 'Bearer ' + localStorage.getItem('jwt');

	return request;
}, error => {
	return Promise.reject(error);
});

axios_api.interceptors.response.use(response => {
	return response;
}, async function(error){
	const originalRequest = error.config;
	if (error.response.status === 401) {
		try{
			retorno = await Usuario.atualizarToken();
			if (retorno.status === 200) {
				originalRequest._retry = true;
			    const access_token = retorno.data.token
	
				localStorage.setItem('jwt', access_token);
				originalRequest.headers.authorization = 'Bearer ' + localStorage.getItem('jwt');
	
			    return axios_api(originalRequest);
			
			}else if(retorno.status === 403){
				Usuario.finalizarSessao(layoutApp.$store);
			}
		}catch(error){
			console.error(error);
		}
	} else{				
		return Promise.reject(error);	
	}
});
