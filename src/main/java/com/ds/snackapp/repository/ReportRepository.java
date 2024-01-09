package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;

public interface ReportRepository extends JpaRepository<Selection, Integer>{
	
	@Query(value="select * from selection where creationtime between :sdate AND :edate", nativeQuery = true) 
	public List<Selection> findBySelection(String sdate, String edate);
	
//	@Query(value="select * from dsusers where id NOT IN(select dsuser_id from selection where creationtime between :sdate AND :edate)", nativeQuery = true) 
//	public List<Integer> findNoResponseDetails(String sdate, String edate);
	
	@Query(value="select dsusers.id, dsusers.name from dsusers  where dsusers.id NOT IN(select dsusers.id from dsusers right join selection on dsusers.id=selection.dsuser_id where DATE(selection.creationtime)= :sldate)", nativeQuery = true) 
	public List<Dsusers> findNoResponseDetails(String sldate);
	
//	@Query(value="select dsuser_id from selection where creationtime between :sdate AND :edate", nativeQuery = true) 
//	public List<Selection> findNoResponseDetails(String sdate, String edate);
	
	/*
	$query = $entityManager->createQuery(
            'select u.id,u.employeename,s.createdtime, s.isselected
                 FROM App\Entity\Selection s, App\Entity\Users u
                 where s.user = u.id AND s.createdtime BETWEEN :sdate AND :edate'
            )->setParameter('sdate',"$startdate"
                )->setParameter('edate',"$enddate")
        ;
        
     */
}
