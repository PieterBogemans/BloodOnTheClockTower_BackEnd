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
public enum Alignment {

	EVIL("EVIL"),
	GOOD("GOOD");

	private String alignmentCode;

	Alignment(String alignment) {
		this.alignmentCode = alignment;
	}

	public String getAlignmentCode() {
		return alignmentCode;
	}
}
