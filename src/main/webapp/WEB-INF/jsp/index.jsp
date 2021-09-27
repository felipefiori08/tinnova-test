<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1" />
    <title>Teste Tinnova</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/dist/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-vue/bootstrap-vue.min.css" />
    

</head>

<body>
    <section id="carros" style="width: 50%; margin-left: 10%; margin-top: 3%">
        <b-nav tabs>
            <b-nav-item @click="aba = 'cadastro'" :active="aba == 'cadastro'">Cadastrar Veículo</b-nav-item>
            <b-nav-item @click="aba = 'listagem'" :active="aba == 'listagem'" >Listar Veículos</b-nav-item>
            <b-nav-item @click="aba = 'alteracao'" :active="aba == 'alteracao'" >Buscar Veículo</b-nav-item>
          </b-nav>

    <cadastro-de-veiculos v-if="aba == 'cadastro'"> </cadastro-de-veiculos>
    <lista-de-veiculos v-if="aba == 'listagem'"></lista-de-veiculos>
    <alteracao-de-veiculos  v-if="aba == 'alteracao'"></alteracao-de-veiculos>


    </section>
 
</body>


<script src="${pageContext.request.contextPath}/vue/vue.js"></script>
<script src="${pageContext.request.contextPath}/axios/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/modules/api_config.js"></script>
<script src="${pageContext.request.contextPath}/modules/axios_config.js"></script>
<script src="${pageContext.request.contextPath}/modules/veiculo.js"></script>
<script src="${pageContext.request.contextPath}/components/cadastroDeVeiculos.js"></script>
<script src="${pageContext.request.contextPath}/components/listaDeVeiculos.js"></script>
<script src="${pageContext.request.contextPath}/components/alteracaoDeVeiculos.js"></script>

<!-- Load the following for BootstrapVueIcons support -->
<script src="${pageContext.request.contextPath}/bootstrap-vue/bootstrap-vue.min.js"></script>
<script src="${pageContext.request.contextPath}/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<script>
	new Vue({
		name: "",
		el: "#carros",
		data: {
            aba: 'cadastro'
		},
	
		computed: {
           
		},
        mounted:function(){
           
        },
		watch:{
		},
		methods: {

            
			
		},
        
	});
</script>


</html>