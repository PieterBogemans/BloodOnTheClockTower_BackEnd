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

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
public enum RoleType {


	TOWN("TOWN"),
	OUTSIDER("OUTSIDER"),
	MINION("MINION"),
	DEMON("DEMON");

	private String roleTypeCode;

	RoleType(String roleTypeCode) {
		this.roleTypeCode = roleTypeCode;
	}

	public String getRoleTypeCode() {
		return roleTypeCode;
	}
}
