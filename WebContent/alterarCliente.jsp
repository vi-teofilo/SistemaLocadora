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
<title>Alteração de Cliente</title>
</head>
<body class="imageteladealcliente">

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form styleClass="cadatrafilme">

			<h1>Alteração de Cliente</h1>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome: " styleClass="label" />
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" styleClass="telafilme"
					readonly="true" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Logradouro: " styleClass="label" />
				<h:inputText value="#{clienteBacking.logradouro}" maxlength="50"
					styleClass="areavenda" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Numero: " styleClass="label"  />
				<h:inputText value="#{clienteBacking.numeroLogradouro}"
					maxlength="50" styleClass="valorpromocao"  onkeyup="masc_numero(this)" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Bairro: " styleClass="label" />
				<h:inputText value="#{clienteBacking.bairro}" maxlength="50"
					styleClass="telafilme" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Cidade: " styleClass="label" />
				<h:inputText value="#{clienteBacking.cidade}" maxlength="50"
					styleClass="telafilme" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Estado: " styleClass="label" />
				<h:inputText value="#{clienteBacking.estado}" maxlength="50"
				styleClass="telafilme" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Cep: " styleClass="label" />
				<h:inputText value="#{clienteBacking.cep}" maxlength="50" styleClass="valorpromocao"
					onkeyup="masc_cep(this)" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Telefone: " styleClass="label" />
				<h:inputText value="#{clienteBacking.telefone}" maxlength="50"
					styleClass="valorpromocao" onkeyup="masc_telefone(this)" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="CPF: " styleClass="label" />
				<h:inputText value="#{clienteBacking.cpf}" maxlength="50" styleClass="cpf"
					onkeyup="masc_cpf(this)" readonly="true" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="RG: " styleClass="label" />
				<h:inputText value="#{clienteBacking.rg}" maxlength="50" styleClass="cpf"
					onkeyup="masc_rg(this)" readonly="true" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Sexo: " styleClass="label"  />
				<h:selectOneRadio value="#{clienteBacking.sexo}" disabled="true" styleClass="label">
					<f:selectItem itemValue="F" itemLabel="Feminino" />
					<f:selectItem itemValue="M" itemLabel="Masculino" />
				</h:selectOneRadio>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Data de Nascimento: " styleClass="label" />
				<h:inputText value="#{clienteBacking.dataNascimento}" maxlength="50"
					styleClass="valorpromocao" onkeyup="masc_nascimento(this)" readonly="true" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Idade: " styleClass="label" />
				<h:inputText value="#{clienteBacking.idade}" maxlength="50"
					styleClass="valorpromocao" readonly="true" />
			</h:panelGrid>

			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Alterar"
						action="#{clienteBacking.alterar}"  styleClass="botaosalvar"  />
					<h:commandButton value="Cancelar"
						action="#{clienteBacking.cancelar}" styleClass="botaocancelar" />
				</h:panelGrid>
			</h:panelGrid>

		</h:form>

	</f:view>

</body>
</html>