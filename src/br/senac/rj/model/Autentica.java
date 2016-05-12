package br.senac.rj.model;

import br.senac.rj.entity.Perfil;
import br.senac.rj.entity.Usuario;

public interface Autentica {

	Perfil verificaAutenticacao(Usuario u);
	Usuario efetuarLogin(Usuario u);
}
