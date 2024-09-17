package br.com.salesforce.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.salesfoce.beans.Contato;
import br.com.salesforce.bo.ContatoBo;

@Path("/contato")
public class ContatoResource {

	private ContatoBo contatoBo = new ContatoBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(Contato contato, @Context UriInfo uriInfo) {
		contatoBo.inserirBo(contato);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(contato.getId()));

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Contato> visualizarRs() {
		return (ArrayList<Contato>) contatoBo.visualizarBo();
	}

}
