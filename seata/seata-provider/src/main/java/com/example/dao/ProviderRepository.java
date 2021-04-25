package com.example.dao;

import com.example.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 李磊
 */
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}