package com.ds.snackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Selection;

public interface SelectionRepository extends JpaRepository<Selection,Integer> {

}
