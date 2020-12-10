package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.dao.UsuarioDao;
import br.com.acme.agenda.dao.UsuarioDaoImpl;
import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDao usuarioDao = new UsuarioDaoImpl();

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		this.usuarioDao.cadastrarUsuario(usuario);
	}

	@Override
	public List<Usuario> buscarUsuario() {
		return this.usuarioDao.buscarUsuario();
	}

	@Override
	public Usuario verificarUsuario(String login, String senha) {
		for(Usuario u : this.usuarioDao.buscarUsuario()) {
			if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuarioDao.buscarPorEmail(email);
	}
}
