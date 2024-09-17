package br.com.salesforce.resource;

import java.sql.SQLException;
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

import br.com.salesforce.beans.Formulario;
import br.com.salesforce.bo.FormularioBo;

@Path("/formulario")
public class FormularioResource {
    
	private FormularioBo formularioBo = new FormularioBo();

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(Formulario formulario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		formularioBo.inserirBo(formulario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(formulario.getNome());

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Formulario> visualizarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Formulario>) formularioBo.visualizarBo();
	}
}
