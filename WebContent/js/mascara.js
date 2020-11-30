function masc_numero(objeto){
	var numero = "";
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	objeto.value = numero;
}

function masc_cep(objeto){
	var retorno = "";
	var numero;
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	parte1 = numero.substr(0,2);
	if (parte1.length > 0) {
		retorno = parte1;
	}
	parte2 = numero.substr(2,3);
	if (parte2.length > 0) {
		retorno += "." + parte2;
	}
	parte3 = numero.substr(5,3);
	if (parte3.length > 0) {
		retorno += "-" + parte3;
	}
	objeto.value = retorno;
}

function masc_telefone(objeto){
	var retorno = "";
	var numero;
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	parte1 = numero.substr(0,2);
	if (parte1.length > 0) {
		retorno = "(" + parte1 + ")";
	}
	parte2 = numero.substr(2,4);
	if (parte2.length > 0) {
		retorno += " " + parte2;
	}
	parte3 = numero.substr(6,4);
	if (parte3.length > 0) {
		retorno += "-" + parte3;
	}
	objeto.value = retorno;
}

function masc_cpf(objeto){
	var retorno = "";
	var numero;
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	
	parte1 = numero.substr(0,3);
	if (parte1.length > 0) {
		retorno = parte1;
	}
	parte2 = numero.substr(3,3);
	if (parte2.length > 0) {
		retorno += "." + parte2;
	}
	parte3 = numero.substr(6,3);
	if (parte3.length > 0) {
		retorno += "." + parte3;
	}
	parte4 = numero.substr(9,2);
	if (parte4.length > 0) {
		retorno += "-" + parte4;
	}
	objeto.value = retorno;
}

function masc_rg(objeto){
	var retorno = "";
	var numero;
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	
	parte1 = numero.substr(0,2);
	if (parte1.length > 0) {
		retorno = parte1;
	}
	parte2 = numero.substr(2,3);
	if (parte2.length > 0) {
		retorno += "." + parte2;
	}
	parte3 = numero.substr(5,3);
	if (parte3.length > 0) {
		retorno += "." + parte3;
	}
	digito = objeto.value.substr(10,1).replace("-", "");
	parte4 = digito;
	if (parte4.length > 0) {
		retorno += "-" + parte4;
	}
	objeto.value = retorno;
}

function masc_nascimento(objeto){
	var retorno = "";
	var numero;
	var padrao = /\D/g;
	
	numero = objeto.value.replace(padrao, "");
	parte1 = numero.substr(0,2);
	if (parte1.length > 0) {
		retorno = parte1;
	}
	parte2 = numero.substr(2,2);
	if (parte2.length > 0) {
		retorno += "/" + parte2;
	}
	parte3 = numero.substr(4,4);
	if (parte3.length > 0) {
		retorno += "/" + parte3;
	}
	objeto.value = retorno;
}
function masc_moeda(objeto) {
	var v = objeto.value.replace(/\D/g,'');
	v = (v/100).toFixed(2) + '';
	v = v.replace(".", ",");
	v = v.replace(/(\d)(\d{3})(\d{3}),/g, "$1.$2.$3,");
	v = v.replace(/(\d)(\d{3}),/g, "$1.$2,");
	objeto.value = v;
}