package com.example.demo.pool.repository;

import com.example.demo.pool.entity.Pool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoolRepository extends JpaRepository<Pool, Long> {
    Optional<Pool> findByPlaceName(String placeName);
}
