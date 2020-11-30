<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Locadora</title>
<link href="css/final.css" rel="stylesheet">
</head>
<body class="image">
	<div>

		<f:subview id="view" >

			<h:form id="menu">
				
					<rich:toolBar styleClass="confgmenu" >
							
						<rich:dropDownMenu value="Cadastro" styleClass="congfcadastrolabel" >
								
							<rich:menuItem id="menu1" value="Cadastro Filme"
								action="#{filmeBacking.cadastraFilme}"
								styleClass="confgmenu"  >
							</rich:menuItem>

							<rich:menuItem id="menu2" value="Cadastro Cliente" 
								action="#{clienteBacking.cadastraCliente}"
								styleClass="confgmenu" >
							</rich:menuItem>

							<rich:menuItem id="menu3" value="Cadastro Vendedor" 
								action="#{vendedorBacking.cadastraVendedor}"
								styleClass="confgmenu" >
							</rich:menuItem>

						</rich:dropDownMenu>

						<rich:dropDownMenu value="Consulta" styleClass="congfcadastrolabel" >

							<rich:menuItem id="menu4" value="Consulta Filme"
								action="#{filmeBacking.consultaFilme}" styleClass="confgmenu"  >
							</rich:menuItem>

							<rich:menuItem id="menu5" value="Consulta Cliente"
								action="#{clienteBacking.consultaCliente}" styleClass="confgmenu" >
							</rich:menuItem>

							<rich:menuItem id="menu6" value="Consulta Vendedor"
								action="#{vendedorBacking.consultaVendedor}" styleClass="confgmenu"  >
							</rich:menuItem>
							<rich:menuItem id="menu7" value="Consulta Locação"
								action="#{locacaoBacking.consultaLocacao}" styleClass="confgmenu"  >
							</rich:menuItem>

						</rich:dropDownMenu>

						<rich:dropDownMenu value="Locação" styleClass="congfcadastrolabel" >

							<rich:menuItem id="menu8" value="Efetuar Locação"
								action="#{locacaoBacking.efetuarLocacao}" styleClass="confgmenu" >
							</rich:menuItem>

							<rich:menuItem id="menu9" value="Devolução"
								action="#{locacaoBacking.devolveLocacao}" styleClass="confgmenu" >
							</rich:menuItem>

						</rich:dropDownMenu>
						
						<rich:dropDownMenu value="Relatório" styleClass="congfcadastrolabel" >

							<rich:menuItem id="menu10" value="Relatorio de Cliente"
								action="#{relatorioBacking.relatorioCliente}" styleClass="confgmenu" >
							</rich:menuItem>

							<rich:menuItem id="menu11" value="Relatório de Filme"
								action="#{relatorioBacking.relatorioFilme}" styleClass="confgmenu"  >
							</rich:menuItem>
							<rich:menuItem id="menu12" value="Relatório de Vendedor"
								action="#{relatorioBacking.relatorioVendedor}" styleClass="confgmenu" >
							</rich:menuItem>
							<rich:menuItem id="menu13" value="Relatório de Locação"
								action="#{relatorioBacking.relatorioLocacao}" styleClass="confgmenu" >
							</rich:menuItem>

						</rich:dropDownMenu>
					</rich:toolBar>
			
			</h:form>

		</f:subview>



	</div>

</body>
</html>