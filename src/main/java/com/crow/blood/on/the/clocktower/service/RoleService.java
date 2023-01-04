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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class RoleService {


	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ScriptRoleRepository scriptRoleRepository;

	public Role getRoleReference(Role role) {
		if (role == null) return null;
		Optional<Role> roleOptional = roleRepository.findById(role.getId());
		if (roleOptional.isPresent()) return roleOptional.get();
		roleOptional = roleRepository.findByName(role.getName());
		if (roleOptional.isPresent()) return roleOptional.get();
		return createRole(role);
	}

	private Role createRole(final Role role) {
		if (role.getName() == null || role.getRoleType() == null || role.getStartingAlignment() == null) {
			throw new IllegalArgumentException("Role not recognised and has data missing, no role can be created: " + role.toString() );
		}
		return roleRepository.save(role);
	}

	public List<Role> getRoles(Script script) {
		List<ScriptRole> scriptRoles = scriptRoleRepository.findByScriptId(script.getId());
		List<Long> roleIds = scriptRoles != null && !scriptRoles.isEmpty() ?
				scriptRoles
						.stream()
						.map(scriptRole -> scriptRole.getRole().getId())
						.collect(Collectors.toList())
				: new ArrayList<>();
		return roleIds != null && !roleIds.isEmpty() ? roleRepository.findAllById(roleIds) : new ArrayList<>();
	}
}
