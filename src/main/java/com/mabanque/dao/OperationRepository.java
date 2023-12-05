package com.mabanque.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mabanque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>
{
	@Query(value = "SELECT * FROM operation  WHERE operation.code_cpte = :x order by operation.date_operation DESC",nativeQuery = true)
	public Page<Operation> listOperation(@Param("x")String codeCpte,Pageable pageable);
}
