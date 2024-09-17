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

import br.com.salesfoce.beans.ClientePf;
import br.com.salesforce.bo.ClientePfBo;

@Path("/clientepf")
public class ClientePfResource {

	private ClientePfBo clientePfBo = new ClientePfBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(ClientePf clientepf, @Context UriInfo uriInfo) {
		clientePfBo.inserirBo(clientepf);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(clientepf.getCodigo()));

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClientePf> visualizarRs() {
		return (ArrayList<ClientePf>) clientePfBo.visualizarBo();
	}

}
