package com.laboratorio.service;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.google.gson.Gson;
import com.laboratorio.bean.Exame;
import com.laboratorio.dao.ExameDAO;

@WebService
@SOAPBinding(style = Style.RPC)
public class ExameService {

	@WebMethod
	public String getExame(int pedido) {
		Exame exame;
		ExameDAO dao = new ExameDAO();
		String json = "Exame nao encontrado";
		try {
			exame = dao.consultarExame(pedido);
			Gson gson = new Gson(); // conversor
			json = gson.toJson( exame );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
		
	}
	
}
