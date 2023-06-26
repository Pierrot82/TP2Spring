package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Salarie;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Integer> {

}
