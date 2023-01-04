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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crow.blood.on.the.clocktower.repository.AbstractRepository;

/**
 * @author $Author: bogemapi $
 * @version $Revision: 0 $
 */
public abstract class AbstractController<T> {

	protected abstract AbstractRepository getRepository();

	@GetMapping
	public @ResponseBody List<T> getAll() {
		return (List<T>) getRepository().findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<T> add(@RequestBody T t) {
		getRepository().save(t);
		return (List<T>) getRepository().findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity delete(@PathVariable Long id) {
		getRepository().deleteById(id);
		return new ResponseEntity(getRepository().findAll(), HttpStatus.OK);
	}

}
