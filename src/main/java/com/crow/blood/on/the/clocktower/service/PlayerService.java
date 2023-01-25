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
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.blood.on.the.clocktower.model.Game;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Named;
import com.crow.blood.on.the.clocktower.model.Player;
import com.crow.blood.on.the.clocktower.model.enums.RoleType;
import com.crow.blood.on.the.clocktower.model.statistics.Descriptor;
import com.crow.blood.on.the.clocktower.model.statistics.PlayerStatistics;
import com.crow.blood.on.the.clocktower.model.statistics.Ratio;
import com.crow.blood.on.the.clocktower.model.statistics.RoleTypeRatio;
import com.crow.blood.on.the.clocktower.repository.PlayerRepository;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class PlayerService {

	
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	GamePlayerService gamePlayerService;
	
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

	public PlayerStatistics getPlayerStats(Player playerRequest) {
		PlayerStatistics statistics = new PlayerStatistics();
		Player player = getPlayerReference(playerRequest);
		List<GamePlayer> gamePlayers = gamePlayerService.getGamePlayers(player);

		if (gamePlayers != null && !gamePlayers.isEmpty()) {
			statistics.setPlayer(player);
			statistics.setWinRate(StatisticsService.convertGamePlayersToWinrate(gamePlayers, new Descriptor("Winrate")));
			statistics.setDeathRate(StatisticsService.convertGamePlayersToDeathRate(gamePlayers));

			Map<Named, List<GamePlayer>> roleMap = StatisticsService.getRoleMap(gamePlayers);
			Map<Named, Ratio> roleRatioMap = StatisticsService.getNamedRatioMap(roleMap);
			Optional<Ratio> bestRole = StatisticsService.getHighestWinrate(roleRatioMap);
			Optional<Ratio> mostPlayedRole = StatisticsService.getMostPlayed(roleRatioMap);

			Map<Named, List<GamePlayer>> scriptMap = StatisticsService.getScriptMap(gamePlayers);
			Map<Named, Ratio> scriptRatioMap = StatisticsService.getNamedRatioMap(scriptMap);
			Optional<Ratio> bestScript = StatisticsService.getHighestWinrate(scriptRatioMap);
			Optional<Ratio> mostPlayedScript = StatisticsService.getMostPlayed(scriptRatioMap);

			Map<Named, List<GamePlayer>> roleTypeMap = StatisticsService.getRoleTypeMap(gamePlayers);
			Map<Named, Ratio> roleTypeRatioMap = StatisticsService.getNamedRatioMap(roleTypeMap);
			Optional<RoleTypeRatio> roleTypeRatio = StatisticsService.getRoleTypeRatio(roleTypeRatioMap);

			if (bestRole.isPresent()) statistics.setBestRole(bestRole.get());
			if (mostPlayedRole.isPresent()) statistics.setMostPlayedRole(mostPlayedRole.get());
			if (bestScript.isPresent()) statistics.setBestScript(bestScript.get());
			if (mostPlayedScript.isPresent()) statistics.setMostPlayedScript(mostPlayedScript.get());
			if (roleTypeRatio.isPresent()) statistics.setRoleTypeRatio(roleTypeRatio.get());
		}

		return statistics;
	}
}
