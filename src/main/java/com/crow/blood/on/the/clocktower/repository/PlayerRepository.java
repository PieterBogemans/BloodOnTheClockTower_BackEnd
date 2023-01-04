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

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crow.blood.on.the.clocktower.model.Player;
import com.crow.blood.on.the.clocktower.model.Role;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface PlayerRepository extends AbstractRepository<Player> {

	@Query("SELECT player FROM Player player WHERE name = ?1")
	Optional<Player> findByName(String name);

}
