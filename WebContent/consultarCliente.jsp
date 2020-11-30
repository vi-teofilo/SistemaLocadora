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
<title>Consulta de Cliente</title>
<link href="css/final.css" rel="stylesheet">
</head>
<body class="imageteladeconcliente">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form styleClass="painel-tablecliente">

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="3">
				<h:outputText value="Nome: " styleClass="label"/>
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" styleClass="telafilmecadcli"/>
				<h:commandButton value="Pesquisar Cliente"
					action="#{clienteBacking.pesquisar}" styleClass="botaopesquisarcliente"  />
			</h:panelGrid>

			<h:panelGrid columns="1" width="700">
			<a4j:keepAlive beanName="clienteBacking" ajaxOnly="true" />
                <rich:spacer height="30" />
				<rich:dataTable width="490" id="listaCliente" rows="10"
                    columnClasses="col" value="#{clienteBacking.listaCliente}"
                    var="cliente" styleClass="lista">

					<f:facet name="caption">
						<h:outputText value="Lista de Clientes" styleClass="lista" />
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column styleClass="labeltablecliente">
								<h:outputText value="Nome" styleClass="labeltablecliente" />
							</rich:column>
							<rich:column styleClass="labeltablecliente">
								<h:outputText value="Telefone" styleClass="labeltablecliente" />
							</rich:column>
							<rich:column styleClass="labeltableclientedata">
								<h:outputText value="Data de Nascimento"  styleClass="labeltableclientedata"/>
							</rich:column>
							<rich:column colspan="2" styleClass="labeltablecliente">
								<h:outputText value="Ações" styleClass="labeltablecliente" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>

					<rich:column>
						<h:outputText value="#{cliente.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{cliente.telefone}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{cliente.dataNascimento}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar"
								action="#{clienteBacking.alterarCliente}">
								<f:setPropertyActionListener value="#{cliente}"
									target="#{clienteBacking.clienteSelecionado}" />
							</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{clienteBacking.excluir}">
							<f:setPropertyActionListener value="#{cliente}"
								target="#{clienteBacking.clienteSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>


			<rich:datascroller align="center" for="listaCliente" maxPages="20"
                page="#{clienteBacking.scrollerPage}" id="sc2"
                reRender="listaCliente" />

 

            <h:panelGrid columns="1">
                <h:commandButton value="Cancelar"
                    action="#{clienteBacking.cancelar}" styleClass="botaocancelarlista"/>
            </h:panelGrid>




		</h:form>
	</f:view>

</body>
</html>