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
import com.crow.blood.on.the.clocktower.model.Role;
import com.crow.blood.on.the.clocktower.model.Script;
import com.crow.blood.on.the.clocktower.model.ScriptRole;
import com.crow.blood.on.the.clocktower.repository.RoleRepository;
import com.crow.blood.on.the.clocktower.repository.ScriptRepository;
import com.crow.blood.on.the.clocktower.repository.ScriptRoleRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
@Service
public class ScriptService {

	@Autowired
	ScriptRoleRepository scriptRoleRepository;

	@Autowired
	ScriptRepository scriptRepository;

	@Autowired
	RoleService roleService;

	public Script getReference(Script script) {
		if (script == null) return null;
		Optional<Script> roleOptional = scriptRepository.findById(script.getId());
		if (roleOptional.isPresent()) return roleOptional.get();
		roleOptional = scriptRepository.findByName(script.getName());
		if (roleOptional.isPresent()) return roleOptional.get();
		throw new IllegalArgumentException("Script not found");
	}

	public Script addScript(final Script script) {
		Script savedScript = scriptRepository.save(script);
		Script scriptReference = scriptRepository.getReferenceById(savedScript.getId());
		addScriptRoles(script.getRoles(), scriptReference);

		return script;
	}

	private void addScriptRoles(List<ScriptRole> scriptRoles, Script script) {
		for (ScriptRole scriptRole : scriptRoles) {
			scriptRole.setScript(script);
			scriptRole.setRole(roleService.getRoleReference(scriptRole.getRole()));
			scriptRoleRepository.save(scriptRole);
		}
	}
}
