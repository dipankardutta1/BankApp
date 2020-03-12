package com.example.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="loan_amount")
	private Double loanAmount;
	@Column(name="loan_sanction_date")
	@Temporal(TemporalType.DATE)
	private Date loanSanctionDate;
	
	@Column(name="loan_reason")
	private String loanReason;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanSanctionDate() {
		return loanSanctionDate;
	}

	public void setLoanSanctionDate(Date loanSanctionDate) {
		this.loanSanctionDate = loanSanctionDate;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}
	
	
	
	

}
