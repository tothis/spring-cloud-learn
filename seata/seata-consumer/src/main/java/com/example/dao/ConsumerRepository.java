package com.example.dao;

import com.example.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 李磊
 */
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}