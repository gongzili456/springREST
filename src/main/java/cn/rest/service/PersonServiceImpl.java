package cn.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.rest.dao.PersonDao;
import cn.rest.domain.Person;

@Component
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDao personDao;

	@Override
	public List<Person> personList() {
		return personDao.personList();
	}

	@Override
	public boolean creatPerson(Person p) {
		return personDao.creatPerson(p);
	}

	@Override
	public boolean updatePerson(Person p) {
		return personDao.updatePerson(p);
	}

	@Override
	public boolean deletePerson(long id) {
		return personDao.deletePerson(id);
	}

	@Override
	public Person getPerson(long id) {
		return personDao.getPerson(id);
	}

}
