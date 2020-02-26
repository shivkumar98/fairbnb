package com.fdmgroup.FairBnBwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.FairBnBwebsite.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

}
