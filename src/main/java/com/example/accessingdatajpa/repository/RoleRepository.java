package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.models.ERole;
import com.example.accessingdatajpa.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author daniellaera
 * @since 28.07.2021
 */
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
