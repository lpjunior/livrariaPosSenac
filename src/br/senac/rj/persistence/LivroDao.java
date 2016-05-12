package br.senac.rj.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senac.rj.entity.Autor;
import br.senac.rj.entity.Editora;
import br.senac.rj.entity.Livro;
import br.senac.rj.entity.Livro.Categoria;
import br.senac.rj.entity.Livro.Idioma;

public class LivroDao {

	Connection con = DaoFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	
	public void create(Livro l) throws Exception {

	}

	public List<Livro> buscaLivro(Livro l) throws Exception {
		stmt = con.prepareStatement(
				"select * from listalivro where id = ? or isbn = ? or titulo like ? or autor like ? or editora like ? or categoria like ?");
		stmt.setInt(1, l.getId());
		stmt.setLong(2, l.getIsbn());
		stmt.setString(3, l.getTitulo());
		stmt.setString(4, l.getAutor().getNome());
		stmt.setString(5, l.getEditora().getNomeFantasia());
		stmt.setString(6, l.getCategoria().name());

		rs = stmt.executeQuery();

		List<Livro> lista = new ArrayList<Livro>();
		Livro livro = null;
		while (rs.next()) {
			livro = new Livro();
			livro.setId(rs.getInt(1));
			livro.setIsbn(rs.getLong(2));
			livro.setTitulo(rs.getString(3));
			livro.setIdioma(Idioma.valueOf(rs.getString(4)));
			livro.setEditora(new Editora());
			livro.getEditora().setNomeFantasia(rs.getString(5));
			livro.setAutor(new Autor());
			livro.getAutor().setNome(rs.getString(6));
			livro.setDataLancamento(Date.valueOf(rs.getDate(7).toString()).toLocalDate());
			livro.setCategoria(Categoria.valueOf(rs.getString(8)));
			lista.add(livro);
		}
		stmt.close();
		con.close();
		return lista;
	}

	public List<Livro> buscaLivro() throws Exception {
		stmt = con.prepareStatement("select * from listalivro");

		rs = stmt.executeQuery();

		List<Livro> lista = new ArrayList<Livro>();
		Livro livro = null;
		while (rs.next()) {
			livro = new Livro();
			livro.setId(rs.getInt(1));
			livro.setIsbn(rs.getLong(2));
			livro.setTitulo(rs.getString(3));
			livro.setIdioma(Idioma.valueOf(rs.getString(4)));
			livro.setEditora(new Editora());
			livro.getEditora().setNomeFantasia(rs.getString(5));
			livro.setAutor(new Autor());
			livro.getAutor().setNome(rs.getString(6));
			livro.setDataLancamento(Date.valueOf(rs.getDate(7).toString()).toLocalDate());
			livro.setCategoria(Categoria.valueOf(rs.getString(8)));
			lista.add(livro);
		}
		stmt.close();
		con.close();
		return lista;
	}

	public void atualizarLivro(Livro l) throws Exception {

	}

	public void excluirLivro(Livro l) throws Exception {
		stmt = con.prepareStatement("delete from livro where id = ?");
		stmt.execute();
		stmt.close();
		con.close();
	}
}