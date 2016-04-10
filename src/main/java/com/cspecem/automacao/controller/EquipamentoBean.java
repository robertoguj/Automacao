package com.cspecem.automacao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.cspecem.automacao.model.Equipamento;

public class EquipamentoBean {
	
	
	private Equipamento equipamento;
	private List<SelectItem> area;
	private List<SelectItem> local;
	
	
	public List<SelectItem> getArea() {
		if (this.area == null) {
			this.area = new ArrayList<SelectItem>();
			this.area.add(new SelectItem("RM", "Raw Material"));
			this.area.add(new SelectItem("SP", "Sinter Plant"));
			this.area.add(new SelectItem("Coke", "Coke Making Plant"));
			this.area.add(new SelectItem("BF", "Blast Furnace"));
			this.area.add(new SelectItem("SMP", "Steel Making Plant"));
			this.area.add(new SelectItem("CC", "Continuous Casting"));
			this.area.add(new SelectItem("Power Plant", "Power Plant"));
			this.area.add(new SelectItem("Power Receiving", "Power Receiving and Distribution Facility"));
			this.area.add(new SelectItem("EC", "Energy Center"));
			this.area.add(new SelectItem("Fuel Distribution", "Fuel Distribution Facility"));
		}
		return area;
	}
	
	public List<SelectItem> getLocal() {
		if (this.local == null) {
			this.local.add(new SelectItem("PCL Room", "Sala dos PLCs"));
			this.local.add(new SelectItem("Computer Room", "Sala dos servidores"));
			this.local.add(new SelectItem("Operating Room", "Sala de operação"));
		}
		return local;
	}
	

}
