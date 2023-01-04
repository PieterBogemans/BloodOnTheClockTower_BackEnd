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
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.model.Script;
import com.crow.blood.on.the.clocktower.repository.AbstractRepository;
import com.crow.blood.on.the.clocktower.repository.RoleRepository;
import com.crow.blood.on.the.clocktower.service.GamePlayerService;
import com.crow.blood.on.the.clocktower.service.RoleService;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController<Role> {

	@Autowired
	RoleRepository repository;

	@Autowired
	GamePlayerService gamePlayerService;

	@Autowired
	RoleService roleService;

	@Override
	protected AbstractRepository getRepository() {
		return repository;
	}

	@RequestMapping(value = "/gameplayers", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	List<GamePlayer> getGamePlayers(@RequestBody Role role) {
		return gamePlayerService.getGamePlayers(role);
	}

	@RequestMapping(value = "/script", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	List<Role> getRoles(@RequestBody Script script) {
		return roleService.getRoles(script);
	}





}
