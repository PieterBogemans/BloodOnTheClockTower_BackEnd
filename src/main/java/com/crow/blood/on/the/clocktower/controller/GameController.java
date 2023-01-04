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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.crow.blood.on.the.clocktower.model.Game;
import com.crow.blood.on.the.clocktower.repository.AbstractRepository;
import com.crow.blood.on.the.clocktower.repository.GameRepository;
import com.crow.blood.on.the.clocktower.service.GameService;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@RestController
@RequestMapping("/game")
public class GameController extends AbstractController<Game> {

	@Autowired
	GameRepository repository;

	@Autowired
	GameService service;

	@Override
	protected AbstractRepository getRepository() {
		return repository;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<Game> add(@RequestBody Game game) {
		service.addGame(game);
		return getRepository().findAll();
	}


}
