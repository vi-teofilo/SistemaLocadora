<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>
<title>Consulta de Loçação</title>
</head>
<body>
	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form styleClass="painel-tablelocacao">

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="3">
				<h:outputText value="Nome do filme:" styleClass="labellocacao" />
				<h:inputText value="#{locacaoBacking.nomeFilme}" maxlength="50"
					styleClass="telafilmelista" />
				<h:commandButton value="Pesquisar Locação"
					action="#{locacaoBacking.pesquisar}" styleClass="botaopesquisarlocacao" />
			</h:panelGrid>

			<h:panelGrid columns="1" width="700">
				<a4j:keepAlive beanName="locacaoBacking" ajaxOnly="true" />
                <rich:spacer height="30" />
				<rich:dataTable width="490" id="listaLocacao" rows="10"
                    columnClasses="col" value="#{locacaoBacking.listaLocacao}"
                    var="locacao" styleClass="lista">

					<f:facet name="caption">
						<h:outputText value="Lista de Locação" styleClass="label"/>
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column styleClass="labeltable">
								<h:outputText value="Cliente" styleClass="labeltable"/>
							</rich:column>
							<rich:column styleClass="labeltable">
								<h:outputText value="Filme" styleClass="labeltable"/>
							</rich:column>
							<rich:column styleClass="labeltable">
								<h:outputText value="Data" styleClass="labeltable"/>
							</rich:column>

						</rich:columnGroup>
					</f:facet>

					<rich:column>
						<h:outputText value="#{locacao.nomeCliente}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacao.nomeFilme}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{locacaoBacking.formataData(locacao.dataLocacao)}" />
					</rich:column>

				</rich:dataTable>
				
			</h:panelGrid>
			<rich:datascroller align="center" for="listaLocacao" maxPages="20"
                page="#{locacaoBacking.scrollerPage}" id="sc2"
                reRender="listalocacao" />

 

            <h:panelGrid columns="1">
                <h:commandButton value="Cancelar"
                    action="#{locacaoBacking.cancelar}" styleClass="botaocancelarlista"/>
            </h:panelGrid>
				
		</h:form>
	</f:view>
</body>
</html>