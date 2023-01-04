/* ------------------------------------------------------
 *
 *     PRODUCT: AKCT Core
 *        FILE: : $
 *
 * MODIFIED BY: : bogemapi $
 *          ON: :  $
 *     VERSION: : 0 $
 *
 * ------------------------------------------------------
 */
package com.crow.blood.on.the.clocktower.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crow.blood.on.the.clocktower.model.Role;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface RoleRepository extends AbstractRepository<Role> {

	@Query("SELECT role FROM Role role WHERE id = ?1")
	Optional<Role> findById(Long id);

	@Query("SELECT role FROM Role role WHERE name = ?1")
	Optional<Role> findByName(String name);

}
