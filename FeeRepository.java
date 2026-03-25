package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
