package cn.rest.service;

import java.util.List;

import cn.rest.domain.Person;

public interface PersonService {

	List<Person> personList();

	boolean creatPerson(Person p);

	boolean updatePerson(Person p);

	boolean deletePerson(long id);
	
	Person getPerson(long id);

}
