package com.fdmgroup.FairBnBwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;

@Repository
public interface ContactDetailRepository extends JpaRepository <ContactDetail, Integer> {

}
