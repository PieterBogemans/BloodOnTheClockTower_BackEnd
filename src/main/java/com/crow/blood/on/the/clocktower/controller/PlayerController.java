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
package com.crow.blood.on.the.clocktower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Player;
import com.crow.blood.on.the.clocktower.model.statistics.PlayerStatistics;
import com.crow.blood.on.the.clocktower.repository.AbstractRepository;
import com.crow.blood.on.the.clocktower.repository.PlayerRepository;
import com.crow.blood.on.the.clocktower.service.GamePlayerService;
import com.crow.blood.on.the.clocktower.service.PlayerService;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController extends AbstractController<Player> {

	@Autowired
	PlayerRepository repository;

	@Autowired
	GamePlayerService gamePlayerService;

	@Autowired
	PlayerService playerService;

	@Override
	protected AbstractRepository getRepository() {
		return repository;
	}

	@CrossOrigin
	@RequestMapping(value = "/gameplayers", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	List<GamePlayer> getGamePlayers(@RequestBody Player player) {
		return gamePlayerService.getGamePlayers(player);
	}

	@CrossOrigin
	@RequestMapping(value = "/stats", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	PlayerStatistics getPlayerStats(@RequestBody Player player) {
		return playerService.getPlayerStats(player);
	}


}
