<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/final.css" rel="stylesheet">
<title>Relatório em Java</title>
<script type="text/javascript">
	function visualizarRelatorio() {
		enviar("visualizar");
	}

	function gerarRelatorioPDF() {
		enviar("pdf");
	}

	function enviar(acao) {
		document.forms[0].acao.value = acao;
		document.forms[0].target = "_blank";
		document.forms[0].action = "./RelatorioFilmeServlet";
		document.forms[0].submit();
	}
	function voltar() {
		window.location.href = "http://localhost:8080/Sistema_Locadora/";
	}
</script>
</head>
<body>
	<h1>Relatório de Filmes</h1>



	<form action="./RelatorioServlet" method="post"
		onsubmit="return false;" class="painel-tablerelatorio" >
		<input type="hidden" name="acao" /> <input type="submit"
			value="Visualizar Relatorio"
			onclick="javascript:visualizarRelatorio();" class="botaovisualizar"> <input
			type="submit" value="Gerar Relatório PDF"
			onclick="javascript:gerarRelatorioPDF();" class="botaogerar">
			<input type="button" value="Voltar" onclick="voltar();" class="botaovoltar" />
	</form>



</body>
</html>