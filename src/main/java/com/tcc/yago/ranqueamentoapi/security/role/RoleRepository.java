package com.tcc.yago.ranqueamentoapi.security.role;

import java.util.Optional;

import com.tcc.yago.ranqueamentoapi.security.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}