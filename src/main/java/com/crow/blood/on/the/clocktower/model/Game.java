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
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crow.blood.on.the.clocktower.model.enums.Alignment;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Data
@Entity
@Table(name = "Game")
@ToString
public class Game implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ToString.Exclude
	@OneToMany(mappedBy="game", targetEntity = GamePlayer.class)
	private List<GamePlayer> players;

	@OneToOne
	private Script script;

	@OneToOne
	@JoinColumn(name = "storytellerid")
	private Player storyTeller;

	@Column
	@Enumerated(EnumType.STRING)
	private Alignment winningAlignment;

	@Column
	private Timestamp date;


}
