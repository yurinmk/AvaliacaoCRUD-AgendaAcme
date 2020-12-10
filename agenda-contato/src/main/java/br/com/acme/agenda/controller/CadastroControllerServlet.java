package br.com.acme.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.service.UsuarioService;
import br.com.acme.agenda.service.UsuarioServiceImpl;

@WebServlet("/registerControllerServlet")
public class CadastroControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService service;
	
	public CadastroControllerServlet() {
		this.service = new UsuarioServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String senhaTemp = request.getParameter("senhaTemp");
		
		Usuario usuarioExistente = this.service.buscarPorEmail(email);
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		
		if(senha.equals(senhaTemp)) {
			
			if(usuarioExistente != null) {
				request.setAttribute("errorUsuario", "Usuário já cadastrado!");
				rd.forward(request, response);
			}else {
				Usuario novoUsuario = new Usuario(null, email, senha);
				this.service.cadastrarUsuario(novoUsuario);
				
				request.setAttribute("sucesso", "Usuário cadastrado com sucesso!");
				rd.forward(request, response);
			}
		}else {
			request.setAttribute("errorSenha", "As senhas precisam ser iguais!");
			rd.forward(request, response);
		}
		
	}
	
	

}
