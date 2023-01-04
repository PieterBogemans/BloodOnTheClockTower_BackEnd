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
import com.crow.blood.on.the.clocktower.model.Player;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface GamePlayerRepository extends AbstractRepository<GamePlayer> {

	@Query("SELECT player FROM GamePlayer player WHERE playerid = ?1")
	List<GamePlayer> findByPlayer(long id);

	@Query("SELECT player FROM GamePlayer player WHERE roleid = ?1")
	List<GamePlayer> findByRole(long id);

}
