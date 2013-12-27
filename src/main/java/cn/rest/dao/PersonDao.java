package cn.rest.dao;

import java.util.List;

import cn.rest.domain.Person;

public interface PersonDao {

	List<Person> personList();

	boolean creatPerson(Person p);

	boolean updatePerson(Person p);

	boolean deletePerson(long id);

	Person getPerson(long id);
}
