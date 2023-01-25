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

import lombok.Data;

import com.crow.blood.on.the.clocktower.model.enums.RoleType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@JsonSerialize
public class RoleTypeRatio {

	private Ratio town = new Ratio();
	private Ratio outsider = new Ratio();
	private Ratio minion = new Ratio();
	private Ratio demon = new Ratio();
	private Ratio traveller = new Ratio();

	public void setRatio(Ratio ratio, RoleType roleType) {
		switch (roleType) {
			case TOWN:
				setTown(ratio);
				break;
			case OUTSIDER:
				setOutsider(ratio);
				break;
			case MINION:
				setMinion(ratio);
				break;
			case DEMON:
				setDemon(ratio);
				break;
			case TRAVELLER:
				setTraveller(ratio);
				break;
		}
	}

}
