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
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.model.Script;
import com.crow.blood.on.the.clocktower.model.ScriptRole;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface ScriptRoleRepository extends AbstractRepository<ScriptRole> {

	@Query("SELECT script_role FROM ScriptRole script_role WHERE scriptid = ?1")
	List<ScriptRole> findByScriptId(Long id);


}
