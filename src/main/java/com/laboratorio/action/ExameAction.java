package com.laboratorio.action;

import java.sql.SQLException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import com.laboratorio.bean.Exame;
import com.laboratorio.dao.ExameDAO;


public class ExameAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Exame exame = new Exame();
	ExameDAO dao = new ExameDAO();
	private List<Exame> listaExame;
	
	private boolean noData = false;
	private String sucessMsg = "", errorMsg = "";
	
	
	
	public String salvarExame() throws Exception {
		int ctr = 0;
		try {
			ctr = dao.incluirExame(exame);
			if (ctr > 0) {
				sucessMsg = "Exame salvo com sucesso!";
				return SUCCESS;
			} else {
				errorMsg = "Exame não salvo.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "input";
	}
	
	public String atualizarExame() throws Exception {
		try {
			int ctr = dao.atualizarExame(exame);
			if (ctr > 0) {
				sucessMsg = "Exame atualizado com sucesso!";
				return SUCCESS;
			} else {
				errorMsg = "Exame não atualizado.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "input";
	}
	
	public String excluirExame() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int pedido = Integer.parseInt(request.getParameter("pedido"));
		try {
			int ctr = dao.excluirExame(pedido);
			if (ctr > 0) {
				sucessMsg = "Exame excluido com sucesso!";
				listarTodosExames();
				return SUCCESS;
			} else {
				errorMsg = "Exame não excluído.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "input";
	}
	
	public String editarExame(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int pedido = Integer.parseInt(request.getParameter("pedido"));
        
        Exame e;
		try {
			e = dao.consultarExame(pedido);
			exame.setPedido(e.getPedido());
			exame.setPacienteMatr(e.getPacienteMatr());
			exame.setSolicitanteCRM(e.getSolicitanteCRM());
			exame.setConvenio(e.getConvenio());
			exame.setLaudo(e.getLaudo());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
        return SUCCESS;
        
    }
	
	public String listarTodosExames(){
        try {
			listaExame = dao.listarExames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return SUCCESS;
    }

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getListaExame() {
		return listaExame;
	}

	public void setListaExame(List<Exame> listaExame) {
		this.listaExame = listaExame;
	}
	
	public ExameDAO getDao() {
        return dao;
    }

    public void setDao(ExameDAO dao) {
        this.dao = dao;
    }
    
    public String getSucessMsg() {
        return sucessMsg;
    }

    public void setSucessMsg(String sucessMsg) {
        this.sucessMsg = sucessMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
