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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crow.blood.on.the.clocktower.model.GamePlayer;
import com.crow.blood.on.the.clocktower.repository.AbstractRepository;
import com.crow.blood.on.the.clocktower.repository.GamePlayerRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@RestController
@RequestMapping("/gamePlayer")
public class GamePlayerController extends AbstractController<GamePlayer> {

	@Autowired
	GamePlayerRepository repository;

	@Override
	protected AbstractRepository getRepository() {
		return repository;
	}

}
