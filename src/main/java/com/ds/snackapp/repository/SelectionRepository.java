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

  // public Selection findUserselection(int assid, int userid);
   
   //@param annotation doubt
   
   // datatype doubt
   
   // nativequery object doubt
   
   // column name mismatch
   
   // repository annotation
	
	public Selection findByDsuser(Dsusers dsu);

}
