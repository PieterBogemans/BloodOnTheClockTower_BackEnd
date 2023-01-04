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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Player;
import com.crow.blood.on.the.clocktower.repository.PlayerRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class PlayerService {

	
	@Autowired
	PlayerRepository playerRepository;
	
	public Player getPlayerReference(Player player) {
		if (player == null) return null;
		Optional<Player> playerOptional = playerRepository.findById(player.getId());
		if (playerOptional.isPresent()) return playerOptional.get();
		playerOptional = playerRepository.findByName(player.getName());
		if (playerOptional.isPresent()) return playerOptional.get();
		return createPlayer(player);
	}

	private Player createPlayer(final Player player) {
		if (player.getName() == null) {
			throw new IllegalArgumentException("Player not recognised and has data missing, no player can be created: " + player.toString() );
		}
		return playerRepository.save(player);
	}


}
