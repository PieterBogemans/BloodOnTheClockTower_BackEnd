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
package com.crow.blood.on.the.clocktower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Player;
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.repository.GamePlayerRepository;
import com.crow.blood.on.the.clocktower.repository.PlayerRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class GamePlayerService {


	@Autowired
	GamePlayerRepository repository;

	public List<GamePlayer> getGamePlayers(Player player) {
		return repository.findByPlayer(player.getId());
	}

	public List<GamePlayer> getGamePlayers(final Role role) {
		return repository.findByRole(role.getId());
	}
}
