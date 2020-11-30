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
<title>Alteração de Vendedor</title>
</head>
<body class="imageteladealvendedor">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form styleClass="cadatrafilme">

			<h1>Alteração de Vendedor</h1>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome: " styleClass="label" />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" 
					readonly="true" styleClass="telafilme" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Area Venda: " styleClass="label"/>
				<h:inputText value="#{vendedorBacking.areaVenda}" maxlength="50"
					styleClass="areavenda"/>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Cidade: " styleClass="label"/>
				<h:inputText value="#{vendedorBacking.cidade}" maxlength="50"
					styleClass="telafilme"/>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Estado: " styleClass="label" />
				<h:inputText value="#{vendedorBacking.estado}" maxlength="50"
					styleClass="telafilme"/>
			</h:panelGrid>


			<h:panelGrid columns="2">
				<h:outputText value="Sexo: " styleClass="label"/>
				<h:selectOneRadio value="#{vendedorBacking.sexo}" disabled="true" styleClass="label">
					<f:selectItem itemValue="F" itemLabel="Feminino" />
					<f:selectItem itemValue="M" itemLabel="Masculino" />
				</h:selectOneRadio>
			</h:panelGrid>


			<h:panelGrid columns="2">
				<h:outputText value="Idade: " styleClass="label"/>
				<h:inputText value="#{vendedorBacking.idade}" maxlength="3"
					readonly="true" styleClass="valorpromocao"/>
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Salário: " styleClass="label" />
				<h:inputText value="#{vendedorBacking.salario}" maxlength="20" 
					onkeyup="masc_moeda(this)" styleClass="valorpromocao"/>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Alterar"
						action="#{vendedorBacking.alterar}" styleClass="botaosalvar" />
					<h:commandButton value="Cancelar"
						action="#{vendedorBacking.cancelar}" styleClass="botaocancelar" />
				</h:panelGrid>
			</h:panelGrid>

		</h:form>

	</f:view>

</body>
</html>