<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>
<title>Devolução</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form styleClass="cadatrafilme">
				<h1>Devolução</h1>
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:selectOneMenu id="comboFilme" required="false" onchange="submit()"
					valueChangeListener="#{locacaoBacking.popularFilmeAlugado}" styleClass="inputdevolver">
					<f:selectItem itemValue="#{null}" itemLabel="Selecione um filme..." />
					<f:selectItems value="#{filmeBacking.carregarFilmesAlugadosCombo()}"/>
				</h:selectOneMenu>
			</h:panelGrid>

			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Confirmar devolução" action="#{locacaoBacking.devolverFilme()}" styleClass="botaoconfirma"/>
					<h:commandButton value="Voltar" action="#{locacaoBacking.cancelar}" styleClass="botaocancelar"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:form>
	</f:view>




</body>
</html>