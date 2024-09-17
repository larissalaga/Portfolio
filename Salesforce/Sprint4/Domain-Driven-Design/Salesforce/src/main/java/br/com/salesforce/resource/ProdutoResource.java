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

import br.com.salesfoce.beans.Produto;
import br.com.salesforce.bo.ProdutoBo;

@Path("/produto")
public class ProdutoResource {

	private ProdutoBo produtoBo = new ProdutoBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(Produto produto, @Context UriInfo uriInfo) {
		produtoBo.inserirBo(produto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produto.getId()));

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Produto> visualizarRs() {
		return (ArrayList<Produto>) produtoBo.visualizarBo();
	}

}
