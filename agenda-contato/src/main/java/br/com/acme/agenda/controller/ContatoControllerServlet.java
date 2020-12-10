package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.utils.Constantes;
import br.com.acme.agenda.utils.JPAUtil;

/**
 * Servlet implementation class ContatoControllerServlet 
 * PRIMEIRA CAMADA
 */
@WebServlet("/contatoControllerServlet")
public class ContatoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Contato contato;
	private ContatoService service;
	private List<Contato> contatos;
	
	public ContatoControllerServlet() {
		this.contato = new Contato();
		this.service = new ContatoServiceImpl();
		this.contatos = new ArrayList<Contato>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idContato = request.getParameter("id");
		String valor = request.getParameter("valor");
		String metodo = request.getParameter("metodo");
		
		String temp = metodo == null ? "null" : metodo;
		
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LISTAR_CONTATOS);
		
		switch (temp) {
		case "":
			String ativoInativo = Boolean.parseBoolean(valor) ? "desativado" : "ativado";
			this.service.ativarDesativarContato(Long.parseLong(idContato),Boolean.parseBoolean(valor));
			request.setAttribute("ativoInativo", "Contato " + ativoInativo + " com sucesso!");
			break;
		case "editar":
			RequestDispatcher rdEditar = request.getRequestDispatcher(Constantes.CADASTRAR_CONTATOS);
			this.contato = this.service.buscarPorIdContato(Long.parseLong(idContato));
			request.setAttribute("contato", this.contato);
			request.setAttribute("opcao", "editar");
			rdEditar.forward(request, response);
			break;
		case "visualizar":
			RequestDispatcher rdVisualizar = request.getRequestDispatcher(Constantes.CADASTRAR_CONTATOS);
			this.contato = this.service.buscarPorIdContato(Long.parseLong(idContato));
			request.setAttribute("contato", this.contato);
			request.setAttribute("opcao", "visualizar");
			rdVisualizar.forward(request, response);
			break;
		case "excluir":
			this.service.remover(Long.parseLong(idContato));
			break;
		default:

		}
				
		this.contatos = this.service.listarContatos(JPAUtil.usuario.getId());
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String idContato = request.getParameter("id");
		
		this.contato = new Contato(null, JPAUtil.usuario.getId(), nome, email, telefone, true);
		
		System.out.println(JPAUtil.usuario.getId());
		
		switch (idContato) {
		case "":
			if(this.service.validaEamil(email)) {
				request.setAttribute("erroEmail","Email " + email + " já cadastrado!");
			}else {
				this.service.salvar(this.contato);
				request.setAttribute("sucesso","Contato " + nome + " salvo com sucesso!");	
			}
			break;

		default:
			this.service.editarContato(Long.parseLong(idContato), this.contato);
			request.setAttribute("editado","Contato atualizado com sucesso!");
			break;
		}

		doGet(request, response);
		
	}
	
}







