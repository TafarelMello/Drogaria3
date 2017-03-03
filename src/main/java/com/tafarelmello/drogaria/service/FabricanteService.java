package com.tafarelmello.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.tafarelmello.drogaria.dao.FabricanteDAO;
import com.tafarelmello.drogaria.domain.Fabricante;

@Path("fabricante")
public class FabricanteService {
	
	@GET
	public String listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);
		
		return json;
	}
	
	@GET
	@Path("{codigo}")	
	public String buscar(@PathParam("codigo")Long codigo){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);
		
		return  json;
	}
	
	@POST
	public String salvar(String json){
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
		
		String jsonSaida = gson.toJson(fabricante);
		
		return jsonSaida;
	}
}