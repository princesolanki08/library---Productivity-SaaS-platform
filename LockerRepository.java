package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {
}
