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
package com.crow.blood.on.the.clocktower.model.statistics;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */

import lombok.Data;

import java.io.Serializable;

import com.crow.blood.on.the.clocktower.model.Player;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@JsonSerialize
public class PlayerStatistics implements Serializable {

	private Player player;
	private Ratio winRate = new Ratio();
	private Ratio bestRole = new Ratio();
	private Ratio mostPlayedRole = new Ratio();
	private Ratio bestScript = new Ratio();
	private Ratio mostPlayedScript = new Ratio();
	private Ratio deathRate = new Ratio();
	private RoleTypeRatio roleTypeRatio = new RoleTypeRatio();

}
