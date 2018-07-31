package com.java.reporting.tool;

import java.math.BigDecimal;

public class Instruction {

	private String entity;
	private String buysell;
	private BigDecimal agreedFx;
	private String currency;
	private String instDate;
	private String settleDate;
	private int units;
	private BigDecimal ppu;

	public Instruction(String entity, String buysell, BigDecimal agreedFx, String currency, String instDate,
			String settleDate, int units, BigDecimal ppu) {
		this.entity = entity;
		this.buysell = buysell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instDate = instDate;
		this.settleDate = settleDate;
		this.units = units;
		this.ppu = ppu;
	}

	public Instruction() {
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getBuysell() {
		return buysell;
	}

	public void setBuysell(String buysell) {
		this.buysell = buysell;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInstDate() {
		return instDate;
	}

	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public BigDecimal getPpu() {
		return ppu;
	}

	public void setPpu(BigDecimal ppu) {
		this.ppu = ppu;
	}

}
