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
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@Entity
@Table(name = "Script")
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@JsonSerialize
public class Script implements Serializable, Named {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ToString.Exclude
	@OneToMany(mappedBy="script", targetEntity = ScriptRole.class)
	private List<ScriptRole> roles;

	@Column
	private String name;

	public Script(long id) {
		this.id = id;
	}

	public boolean containsRole(String name) {
		return roles.stream()
				.anyMatch(role -> name.equals(role.getRole().getName()));
	}

}
