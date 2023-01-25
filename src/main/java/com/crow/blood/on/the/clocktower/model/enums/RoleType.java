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
package com.crow.blood.on.the.clocktower.model.enums;

import com.crow.blood.on.the.clocktower.model.Named;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
public enum RoleType implements Named {


	TOWN("TOWN"),
	OUTSIDER("OUTSIDER"),
	MINION("MINION"),
	DEMON("DEMON"),
	TRAVELLER("TRAVELLER");

	private String roleTypeCode;

	RoleType(String roleTypeCode) {
		this.roleTypeCode = roleTypeCode;
	}

	public String getRoleTypeCode() {
		return roleTypeCode;
	}

	@Override
	public String getName() {
		return getRoleTypeCode();
	}
}
