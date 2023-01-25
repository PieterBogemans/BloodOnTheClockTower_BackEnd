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

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.model.Named;
import com.crow.blood.on.the.clocktower.model.enums.RoleType;
import com.crow.blood.on.the.clocktower.model.statistics.Descriptor;
import com.crow.blood.on.the.clocktower.model.statistics.Ratio;
import com.crow.blood.on.the.clocktower.model.statistics.RoleTypeRatio;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class StatisticsService {

	public static Ratio convertGamePlayersToWinrate(List<GamePlayer> gamePlayers, Named descriptor) {
		return convertGamePlayers(gamePlayers, descriptor, GamePlayer::isWon);
	}

	public static Ratio convertGamePlayersToDeathRate(List<GamePlayer> gamePlayers) {
		return convertGamePlayers(gamePlayers, new Descriptor("Death Rate"), GamePlayer::isDied);
	}

	public static Ratio convertGamePlayers(List<GamePlayer> gamePlayers, Named descriptor, Function<GamePlayer, Boolean> function) {
		Ratio ratio = new Ratio();
		if (descriptor != null) ratio.setDescriptor(descriptor);
		Map<Boolean, List<GamePlayer>> winRateMap = gamePlayers.stream().collect(groupingBy(function));
		if (winRateMap != null) {
			if (winRateMap.get(true) != null && !winRateMap.get(true).isEmpty()) ratio.setPositive(winRateMap.get(true).size());
			if (winRateMap.get(false) != null && !winRateMap.get(false).isEmpty()) ratio.setNegative(winRateMap.get(false).size());
		}
		return ratio;
	}

	public static Map<Named, List<GamePlayer>> getNamedMap(List<GamePlayer> gamePlayers, Function<GamePlayer, Named> groupingFunction) {
		return gamePlayers.stream().collect(groupingBy(groupingFunction));
	}

	public static Map<Named, List<GamePlayer>> getRoleMap(List<GamePlayer> gamePlayers) {
		return gamePlayers.stream().collect(groupingBy(GamePlayer::getRole));
	}

	public static Map<Named, List<GamePlayer>> getScriptMap(List<GamePlayer> gamePlayers) {
		return gamePlayers.stream().collect(groupingBy(player -> player.getGame().getScript()));
	}

	public static Map<Named, List<GamePlayer>> getRoleTypeMap(List<GamePlayer> gamePlayers) {
		return gamePlayers.stream().collect(groupingBy(player -> player.getRole().getRoleType()));
	}

	public static Map<Named, Ratio> getNamedRatioMap(Map<Named, List<GamePlayer>> roleMap) {
		return roleMap.entrySet()
			.stream()
			.collect(Collectors.toMap(
					entry -> entry.getKey(),
					entry -> StatisticsService.convertGamePlayersToWinrate(entry.getValue(), entry.getKey())
			));
	}

	public static Optional<Ratio> getHighestWinrate(Map<Named, Ratio> namedRatioMap) {
		return namedRatioMap.values().stream().max(Comparator.comparing(ratio -> ratio.getRatio()));
	}

	public static Optional<Ratio> getMostPlayed(Map<Named, Ratio> namedRatioMap) {
		return namedRatioMap.values().stream().max(Comparator.comparing(ratio -> ratio.getTotal()));
	}

	public static Optional<RoleTypeRatio> getRoleTypeRatio(Map<Named, Ratio> roleTypeRatioMap) {
		RoleTypeRatio roleTypeRatio = new RoleTypeRatio();

		for (RoleType roleType : RoleType.values()) {
			Ratio ratio = roleTypeRatioMap.get(roleType);
			if (ratio != null) roleTypeRatio.setRatio(ratio, roleType);
		}
		return Optional.ofNullable(roleTypeRatio);
	}
}
