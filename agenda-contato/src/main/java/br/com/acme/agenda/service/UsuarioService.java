package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;

public interface UsuarioService {
	
	public void cadastrarUsuario(Usuario usuario);
	
	public List<Usuario> buscarUsuario();
	
	public Usuario buscarPorEmail(String email);
	
	public Usuario verificarUsuario(String login, String senha);

}
