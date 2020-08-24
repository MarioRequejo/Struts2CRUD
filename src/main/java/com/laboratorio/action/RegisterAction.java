package com.laboratorio.action;

import com.laboratorio.bean.Exame;
import com.laboratorio.dao.Admin;
import com.laboratorio.dao.ExameDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 2139116285823340125L;
	Exame exame = new Exame();
	ExameDAO dao = new ExameDAO();
	private String msg = "";
	Admin admin = null;
	int ctr = 0;

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	@Override
	public String execute() throws Exception {
		exame.setPedido(exame.getPedido());
		exame.setPacienteMatr(exame.getPacienteMatr());
		exame.setSolicitanteCRM(exame.getSolicitanteCRM());
		exame.setConvenio(exame.getConvenio());
		exame.setLaudo(exame.getLaudo());
		try {
			ctr = dao.incluirExame(exame);
			
			if (ctr > 0) {
				msg = "Exame salvo com sucesso";
			} else {
				msg = "Erro ao salvar exame";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}

	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

}
