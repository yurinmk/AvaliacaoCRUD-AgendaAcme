/**
 * 
 */
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.dao.ContatoDao;
import br.com.acme.agenda.dao.ContatoDaoImpl;
import br.com.acme.agenda.model.Contato;

/**
 * @author SEUNDA CAMADA
 *
 */
public class ContatoServiceImpl implements ContatoService {
	
	private ContatoDao contatoDao;
	
	public ContatoServiceImpl() {
		contatoDao = new ContatoDaoImpl(); 
	}

	@Override
	public void salvar(Contato contato) {
		this.contatoDao.salvar(contato);
	}

	@Override
	public List<Contato> listarContatos(Long idUsuario) {
		return this.contatoDao.listarContatos(idUsuario);
	}

	@Override
	public void remover(Long idContato) {
		this.contatoDao.remover(idContato);
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {
		return this.contatoDao.buscarPorIdContato(idContato);
	}

	@Override
	public Contato buscarPorEmail(String email) {
		return this.contatoDao.buscarPorEmail(email);
	}

	@Override
	public void ativarDesativarContato(Long idContato, boolean valor) {
		if(idContato != null) {
			if(valor) {
				this.contatoDao.ativarDesativarContato(idContato, false);
			}else {
				this.contatoDao.ativarDesativarContato(idContato, true);
			}	
		}	
	}

	@Override
	public void editarContato(Long idContato, Contato contato) {
		this.contatoDao.editarContato(idContato, contato);
	}
	
	@Override
	public boolean validaEamil(String email) {
		if(this.contatoDao.buscarPorEmail(email) != null) {
			return true;
		}else {
			return false;
		}
		
	}

}
