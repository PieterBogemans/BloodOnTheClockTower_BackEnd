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

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crow.blood.on.the.clocktower.model.Game;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

@Repository
public interface GameRepository extends AbstractRepository<Game> {

	@Query("SELECT game FROM Game game")
	List<Game> findGames();


}
