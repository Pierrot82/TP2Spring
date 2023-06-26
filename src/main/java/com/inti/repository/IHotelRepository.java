package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

}
