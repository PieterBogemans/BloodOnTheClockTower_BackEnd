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

import com.crow.blood.on.the.clocktower.model.Named;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
public class Descriptor implements Named {
	private String name;

	public Descriptor(final String name) {
		this.name = name;
	}
}
