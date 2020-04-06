package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Loan;

@Repository
public interface LoanDao extends JpaRepository<Loan, Integer>{

}
