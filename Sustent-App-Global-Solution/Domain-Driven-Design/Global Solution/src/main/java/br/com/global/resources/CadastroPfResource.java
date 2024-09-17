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

import br.com.global.beans.CadastroPF;
import br.com.global.bo.CadastroPfBo;

@Path("/cadastropf")
public class CadastroPfResource {
	
	private CadastroPfBo cadastroPfBo = new CadastroPfBo();
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response inserirRs(CadastroPF cadastroPf, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		cadastroPfBo.inserirBo(cadastroPf);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cadastroPf.getNome());

		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CadastroPF> visualizarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<CadastroPF>) cadastroPfBo.visualizarBo();
	}

}
