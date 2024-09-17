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

import br.com.salesforce.bo.EnderecoBo;
import br.com.salesforce.modelo.Endereco;

@Path("/endereco")
public class EnderecoResource {

	private EnderecoBo enderecoBo = new EnderecoBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(Endereco endereco, @Context UriInfo uriInfo) {
		enderecoBo.inserirBo(endereco);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(endereco.getId()));

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Endereco> visualizarRs() {
		return (ArrayList<Endereco>) enderecoBo.visualizarBo();
	}

}
