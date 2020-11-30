package br.com.foursys.locadora.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.foursys.locadora.controller.FilmeController;
import br.com.foursys.locadora.vo.FilmeVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioFilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RelatorioFilmeServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<FilmeVO> filmes = new FilmeController().retornaFilmes();

		try {

			String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");

			// caminho do jasper 
			String caminhoJasper = getServletContext()
					.getRealPath("/WEB-INF/classes/br/com/foursys/locadora/relatorio/") + "/";
			String caminho = getServletContext().getRealPath("/");

			JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(filmes);
			Map parametros = new HashMap();
			parametros.put("titulo", "Relatorios de Filmes");
			parametros.put(filmes, jrDT);
			parametros.put("total", "Total de Filmes: " + filmes.size());
			JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "filmes.jasper", parametros, jrDT);

			if ("visualizar".equals(acao)) {
				JasperViewer.viewReport(jasperPrint, false);
			} else if ("pdf".equals(acao)) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, caminho + "/RelatorioFilme.pdf");
				response.sendRedirect("RelatorioFilme.pdf");
			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

}
