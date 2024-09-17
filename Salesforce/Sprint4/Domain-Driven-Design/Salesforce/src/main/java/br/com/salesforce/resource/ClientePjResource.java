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

import br.com.salesfoce.beans.ClientePj;
import br.com.salesforce.bo.ClientePjBo;

@Path("/clientepj")
public class ClientePjResource {

	private ClientePjBo clientePjBo = new ClientePjBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(ClientePj clientepj, @Context UriInfo uriInfo) {
		clientePjBo.inserirBo(clientepj);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(clientepj.getCodigo()));

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClientePj> visualizarRs() {
		return (ArrayList<ClientePj>) clientePjBo.visualizarBo();
	}

}
