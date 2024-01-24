package com.ds.snackapp.repository;

import java.lang.StackWalker.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;

@Repository
public interface SelectionRepository extends JpaRepository<Selection,Integer> {
	
   @Query(value="select * from selection where dsuser_id= :userid and assignment_id = :assid", nativeQuery = true) 
   public Selection findUserselection(int assid, int userid);
   
   @Query(value="select count(id) from selection where creationtime between :sdate AND :edate and isselected = true", nativeQuery = true)
   public int fetchYesSelection(String sdate, String edate);
   
   @Query(value="select count(id) from selection where creationtime between :sdate AND :edate and isselected = false", nativeQuery = true)
   public int fetchNoSelection(String sdate, String edate);
   
    @Query(value="select count(id) from dsusers where id NOT IN(select dsuser_id from selection where creationtime between :sdate AND :edate)", nativeQuery = true) 
	public int fetchNoResponse(String sdate, String edate);

  // public Selection findUserselection(int assid, int userid);
   
   //@param annotation doubt
   
   // datatype doubt
   
   // nativequery object doubt
   
   // column name mismatch
   
   // repository annotation
	
	public Selection findByDsuser(Dsusers dsu);

}
