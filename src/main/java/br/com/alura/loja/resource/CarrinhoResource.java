package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id) {
		return new CarrinhoDAO().busca(id).toXML();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String salva(String conteudo) {
		new CarrinhoDAO().adiciona((Carrinho) new XStream().fromXML(conteudo));
		return "<status>sucesso</status>";
	}
	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String busca(@PathParam("id") long id) {
//		return new CarrinhoDAO().busca(id).toJSON();
//	}	
}
