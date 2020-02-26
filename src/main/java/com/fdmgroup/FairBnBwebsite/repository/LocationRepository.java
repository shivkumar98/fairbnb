package com.fdmgroup.FairBnBwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.FairBnBwebsite.model.Location;

@Repository
public interface LocationRepository extends JpaRepository <Location, Integer> {

}
