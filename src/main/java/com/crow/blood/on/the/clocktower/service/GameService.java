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

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.blood.on.the.clocktower.model.Game;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.model.Script;
import com.crow.blood.on.the.clocktower.repository.GamePlayerRepository;
import com.crow.blood.on.the.clocktower.repository.GameRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	GamePlayerRepository gamePlayerRepository;

	@Autowired
	ScriptService scriptService;

	@Autowired
	PlayerService playerService;

	@Autowired
	RoleService roleService;

	public Game addGame(final Game game) {
		try  {

			getData(game);
			Game savedGame = gameRepository.save(game);
			Game gameReference = gameRepository.getReferenceById(savedGame.getId());
			addGamePlayers(game.getPlayers(), gameReference);

			return game;
		} catch (IllegalArgumentException e) {
			removeAddedGamePlayers(game.getPlayers(), game);
			gameRepository.delete(game);
			throw new IllegalArgumentException(e);
		}
	}

	private void getData(final Game game) {
		game.setScript(scriptService.getReference(game.getScript()));
		game.setStoryTeller(playerService.getPlayerReference(game.getStoryTeller()));
		if (game.getDate() == null) game.setDate(new Timestamp(System.currentTimeMillis()));
	}

	private void addGamePlayers(List<GamePlayer> gamePlayers, Game game) {
		for (GamePlayer gamePlayer : gamePlayers) {
			gamePlayer.setGame(game);
			gamePlayer.setPlayer(playerService.getPlayerReference(gamePlayer.getPlayer()));
			gamePlayer.setRole(roleService.getRoleReference(gamePlayer.getRole()));
			isRoleInScript(gamePlayer.getRole(), game.getScript());
			calculateWin(gamePlayer);
			gamePlayerRepository.save(gamePlayer);
		}
	}

	private void removeAddedGamePlayers(List<GamePlayer> gamePlayers, Game game) {
		for (GamePlayer gamePlayer : gamePlayers) {
			gamePlayerRepository.delete(gamePlayer);
		}
	}

	private void isRoleInScript(final Role role, final Script script) {
		if (!script.containsRole(role.getName())) throw new IllegalArgumentException("Role with name \"" +
				role.getName() + "\" does not exist in the \"" + script.getName() + "\" script.");
	}

	private boolean calculateWin(GamePlayer player) {
		boolean won = player.getAlignment().equals(player.getGame().getWinningAlignment());
		player.setWon(won);
		return won;
	}
}
