<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>
<link href="css/final.css" rel="stylesheet">
<title>Cadastro de Filme</title>
</head>
<body class="imageteladecadfilme">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form styleClass="cadatrafilme">

			<h1>Cadastro de Filme </h1>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome: " styleClass="label" />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" styleClass="telafilme" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Genêro: " styleClass="label"  />
				<h:inputText value="#{filmeBacking.genero}" maxlength="50"
					styleClass="telafilme"/>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Valor: " styleClass="label"  />
				<h:inputText value="#{filmeBacking.valor}"
					maxlength="50" onkeyup="masc_moeda(this)" styleClass="valorpromocao"/>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Disponível: " styleClass="label" />
				<h:selectOneRadio value="#{filmeBacking.disponivel}" styleClass="label">
					<f:selectItem itemValue="Sim" itemLabel="Sim"  />
					<f:selectItem itemValue="Não" itemLabel="Não" />
				</h:selectOneRadio>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Promoção: " styleClass="label" />
				<h:selectOneRadio value="#{filmeBacking.promocao}" styleClass="label">
					<f:selectItem itemValue="Sim" itemLabel="Sim"/>
					<f:selectItem itemValue="Não" itemLabel="Não" />
				</h:selectOneRadio>
			</h:panelGrid>


			<h:panelGrid columns="2">
				<h:outputText value="Valor Promoção: " styleClass="label"/>
				<h:inputText value="#{filmeBacking.valorPromocao}" maxlength="50"
					size="20" onkeyup="masc_moeda(this)" styleClass="valorpromocao"/>
			</h:panelGrid>

			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Confirmar" action="#{filmeBacking.salvar}" styleClass="botaosalvar" />
					<h:commandButton value="Cancelar"
						action="#{filmeBacking.cancelar}" styleClass="botaocancelar" />
				</h:panelGrid>
			</h:panelGrid>

		</h:form>

	</f:view>

</body>
</html>