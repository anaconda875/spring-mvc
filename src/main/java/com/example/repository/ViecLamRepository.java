package com.example.repository;

import com.example.model.ViecLam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViecLamRepository extends JpaRepository<ViecLam, Long> {
}
