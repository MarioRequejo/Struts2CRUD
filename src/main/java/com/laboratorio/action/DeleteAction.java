package com.laboratorio.action;

import com.laboratorio.dao.ExameDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = -146601914103585418L;
	String msg;
	ExameDAO dao = new ExameDAO();
	private int pedido;

	@Override
	public String execute() throws Exception {
		
		try {
			int ctr = dao.excluirExame(pedido);
			
			if (ctr > 0) {
				msg = "Exame excluido com sucesso!";
			} else {
				msg = "Erro ao excluir";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
}
