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
<title>Consulta de Filme</title>
<link href="css/final.css" rel="stylesheet">
</head>
<body class="imageteladeconfilme ">


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form styleClass="painel-tablecliente">
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
		
			<h:panelGrid columns="3">
				<h:outputText value="Nome: " styleClass="label"/>
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" styleClass="telafilmecad "  />
				<h:commandButton value="Pesquisar Filme" 
					action="#{filmeBacking.pesquisar}" styleClass="botaopesquisar" />
			</h:panelGrid>
			
			<h:panelGrid columns="1" width="300">
			 <a4j:keepAlive beanName="filmeBacking" ajaxOnly="true" />
                <rich:spacer height="30" />
				<rich:dataTable width="490" id="listaFilme" rows="10"
                    columnClasses="col" value="#{filmeBacking.listaFilme}"
                    var="filme" styleClass="lista">

					<f:facet name="caption">
						<h:outputText value="Lista de Filmes" styleClass="label"/>
					</f:facet>

					<f:facet name="header" >
						<rich:columnGroup>
							<rich:column styleClass="labeltablefilme" >
								<h:outputText value="Nome" styleClass="labeltablefilme" />
							</rich:column>
							<rich:column styleClass="labeltablefilme">
								<h:outputText value="Gênero" styleClass="labeltablefilme"/>
							</rich:column>
							<rich:column styleClass="labeltablefilme">
								<h:outputText value="Valor" styleClass="labeltablefilme" />
							</rich:column>
							<rich:column styleClass="labeltablefilme">
								<h:outputText value="Promoção" styleClass="labeltablefilme"/>
							</rich:column>
							<rich:column styleClass="labeltablefilme">
								<h:outputText value="Disponível" styleClass="labeltablefilme" />
							</rich:column>
							<rich:column colspan="2" styleClass="labeltablefilme">
								<h:outputText value="Ações" styleClass="labeltablefilme" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>

					<rich:column>
						<h:outputText value="#{filme.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.genero}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.valor}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.promocao}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{filme.disponivel}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar" 
								action="#{filmeBacking.alterarFilme}">
								<f:setPropertyActionListener value="#{filme}"
									target="#{filmeBacking.filmeSelecionado}" />
							</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{filmeBacking.excluir}">
							<f:setPropertyActionListener value="#{filme}"
								target="#{filmeBacking.filmeSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>

				<rich:datascroller align="center" for="listaFilme" maxPages="20"
                page="#{filmeBacking.scrollerPage}" id="sc2"
                reRender="listaFilme" />

 

            <h:panelGrid columns="1">
                <h:commandButton value="Cancelar"
                    action="#{filmeBacking.cancelar}" styleClass="botaocancelarlista"/>
            </h:panelGrid>
				



		</h:form>
	</f:view>

</body>
</html>