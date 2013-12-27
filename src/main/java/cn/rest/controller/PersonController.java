package cn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.rest.domain.Person;
import cn.rest.service.PersonService;

@Controller
@RequestMapping("users")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Person> home() {
		return personService.personList();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public void creatPerson(@RequestBody Person person) {
		personService.creatPerson(person);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody
	Person getPerson(@PathVariable long userId) {
		return personService.getPerson(userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void updatePerson(@RequestBody Person p, @PathVariable long userId) {
		p.setId(userId);
		personService.updatePerson(p);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void deletePerson(@PathVariable long userId) {
		personService.deletePerson(userId);
	}

}
