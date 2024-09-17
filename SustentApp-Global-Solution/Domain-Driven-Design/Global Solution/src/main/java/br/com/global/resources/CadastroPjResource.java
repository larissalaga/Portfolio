package br.com.global.resources;

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

import br.com.global.beans.CadastroPJ;
import br.com.global.bo.CadastroPjBo;

@Path("/cadastropj")
public class CadastroPjResource {
	
	private CadastroPjBo cadastroPjBo = new CadastroPjBo();
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(CadastroPJ cadastroPj, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		cadastroPjBo.inserirBo(cadastroPj);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cadastroPj.getCnpj());

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CadastroPJ> visualizarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<CadastroPJ>) cadastroPjBo.visualizarBo();
	}

}
