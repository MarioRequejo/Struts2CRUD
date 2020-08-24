package com.laboratorio.action;

import java.util.List;

import com.laboratorio.bean.Exame;
import com.laboratorio.dao.ExameDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 6329394260276112660L;
	
	
	List<Exame> beanList = null;
	
	ExameDAO dao = new ExameDAO();
    
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = dao.listarExames();
			
			if (beanList.isEmpty()) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<Exame> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Exame> beanList) {
		this.beanList = beanList;
	}

	
}
