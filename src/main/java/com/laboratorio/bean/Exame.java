package com.laboratorio.bean;

public class Exame {
	private int pedido;
	private String pacienteMatr, 
	solicitanteCRM, 
	convenio,
	laudo;

	public Exame() {
	}
	
	public Exame(int pedido, String pacienteMatr, String solicitanteCRM, String convenio, String laudo) {
		this.pedido = pedido;
		this.pacienteMatr = pacienteMatr;
		this.solicitanteCRM = solicitanteCRM;
		this.convenio = convenio;
		this.laudo = laudo;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getPacienteMatr() {
		return pacienteMatr;
	}

	public void setPacienteMatr(String pacienteMatr) {
		this.pacienteMatr = pacienteMatr;
	}

	public String getSolicitanteCRM() {
		return solicitanteCRM;
	}

	public void setSolicitanteCRM(String solicitanteCRM) {
		this.solicitanteCRM = solicitanteCRM;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}
	}
