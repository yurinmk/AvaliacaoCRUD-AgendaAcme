/**
 * 
 */
package br.com.acme.agenda.service;

import java.util.List;

import br.com.acme.agenda.model.Contato;

/**
 * @author david
 *
 */
public interface ContatoService {

	public void salvar(Contato contato);
	
	public void editarContato(Long idContato, Contato contato);

	public List<Contato> listarContatos(Long idUsuario);

	public void remover(Long idContato);

	public Contato buscarPorIdContato(Long idContato);
	
	public Contato buscarPorEmail(String email);
	
	public void ativarDesativarContato(Long idContato, boolean valor);
	
	public boolean validaEamil(String email);
}
