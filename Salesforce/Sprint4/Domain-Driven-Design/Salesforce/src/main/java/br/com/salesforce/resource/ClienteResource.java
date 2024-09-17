package br.com.salesforce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.salesfoce.beans.Cliente;
import br.com.salesforce.bo.ClienteBo;

@Path("/cliente")
public class ClienteResource {

	private ClienteBo clienteBo = new ClienteBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(Cliente cliente, @Context UriInfo uriInfo) {
		clienteBo.inserirBo(cliente);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(cliente.getCodigo()));

		return Response.created(builder.build()).build();
	}

}
