package com.laboratorio.action;

import java.sql.ResultSet;

import com.laboratorio.bean.Exame;
import com.laboratorio.dao.ExameDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = -1905974197186620917L;
	
	private String msg = "";
	ResultSet rs = null;
	ExameDAO dao = new ExameDAO();
	Exame exame = new Exame();
	String submitType;
	private int pedido;
	
	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	@Override
	public String execute() throws Exception {
		try {
			
			if (submitType.equals("updatedata")) {
				
				exame = dao.consultarExame(pedido);
				exame.setPedido(exame.getPedido());
				exame.setPacienteMatr(exame.getPacienteMatr());
				exame.setSolicitanteCRM(exame.getSolicitanteCRM());
				exame.setConvenio(exame.getConvenio());
				exame.setLaudo(exame.getLaudo());
			} else {
				exame.setPedido(exame.getPedido());
				exame.setPacienteMatr(exame.getPacienteMatr());
				exame.setSolicitanteCRM(exame.getSolicitanteCRM());
				exame.setConvenio(exame.getConvenio());
				exame.setLaudo(exame.getLaudo());
				int i = dao.atualizarExame(exame);
				if (i > 0) {
					msg = "Exame atualizado com sucesso!";
				} else {
					msg = "Exame não atualizado.";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
