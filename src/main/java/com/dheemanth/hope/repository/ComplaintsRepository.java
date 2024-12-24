package com.dheemanth.hope.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dheemanth.hope.complaints.Complaint;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaint,Long> {

}
