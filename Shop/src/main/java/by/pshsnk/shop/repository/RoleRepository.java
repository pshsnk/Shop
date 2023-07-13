package by.pshsnk.shop.repository;


import by.pshsnk.shop.models.role.ERole;
import by.pshsnk.shop.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
