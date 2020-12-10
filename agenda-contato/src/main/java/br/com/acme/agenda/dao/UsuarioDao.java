package br.com.acme.agenda.dao;

import java.util.List;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;

public interface UsuarioDao {
	
	public void cadastrarUsuario(Usuario usuario);
	
	public Usuario buscarPorEmail(String email);
	
	public List<Usuario> buscarUsuario();
	
}
