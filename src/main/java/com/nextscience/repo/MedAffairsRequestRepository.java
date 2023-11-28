package com.nextscience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextscience.entity.MedAffairsRequest;

@Repository
public interface MedAffairsRequestRepository extends JpaRepository<MedAffairsRequest, Integer>{

}
