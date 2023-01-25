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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@JsonSerialize
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Ratio {
	private Named descriptor;
	private long positive = 0;
	private long negative = 0;

	@JsonIgnore
	public double getRatio() {
		return positive / getTotal();
	}

	public long getTotal() {
		return positive + negative;
	}
}
