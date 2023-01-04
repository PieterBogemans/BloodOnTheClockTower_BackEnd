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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crow.blood.on.the.clocktower.model.enums.Alignment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@Entity
@Table(name = "GamePlayer")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class GamePlayer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	@JoinColumn(name = "playerid")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "gameid")
	@JsonIgnore
	private Game game;

	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;

	@Column
	@Enumerated(EnumType.STRING)
	private Alignment alignment;

	@Column
	private boolean died;

	@Column
	private boolean won;

}
