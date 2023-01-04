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
import com.crow.blood.on.the.clocktower.model.Game;
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.model.Script;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface ScriptRepository extends AbstractRepository<Script> {

	@Query("SELECT script FROM Script script")
	List<Script> findScripts();

	@Query("SELECT script FROM Script script WHERE name = ?1")
	Optional<Script> findByName(String name);


}
