package com.fdmgroup.FairBnBwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.FairBnBwebsite.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>{

}
