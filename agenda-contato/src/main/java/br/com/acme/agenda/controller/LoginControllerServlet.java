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
import br.com.acme.agenda.utils.Constantes;
import br.com.acme.agenda.utils.JPAUtil;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService service;
	
	public LoginControllerServlet() {
		this.service = new UsuarioServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario verificacao = this.service.verificarUsuario(login, senha);
		
		if(verificacao != null) {
			JPAUtil.usuario = verificacao;
			RequestDispatcher rd = request.getRequestDispatcher(Constantes.HOME);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(Constantes.LOGIN);
			request.setAttribute("erro", "Login ou senha inválidos!");
			rd.forward(request, response);
		}
		
		
	}
	
}
