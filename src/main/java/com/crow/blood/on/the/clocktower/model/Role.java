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
package com.crow.blood.on.the.clocktower.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crow.blood.on.the.clocktower.model.enums.Alignment;
import com.crow.blood.on.the.clocktower.model.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@Entity
@Table(name = "Roles")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@JsonSerialize
public class Role implements Serializable, Named {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private Alignment startingAlignment;

	@Column
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	public Role(long id) {
		this.id = id;
	}
}
