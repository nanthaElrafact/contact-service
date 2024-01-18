package com.contactservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactservice.entity.MedAffairsRequest;

@Repository
public interface MedAffairsRequestRepository extends JpaRepository<MedAffairsRequest, Integer>{

}
