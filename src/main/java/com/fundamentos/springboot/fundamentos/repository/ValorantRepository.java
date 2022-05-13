package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.Valorant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValorantRepository extends JpaRepository<Valorant, Long> {
}
