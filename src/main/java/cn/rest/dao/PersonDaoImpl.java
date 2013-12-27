package cn.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import cn.rest.domain.Person;

@Component
public class PersonDaoImpl implements PersonDao {
	private List<Person> list = new ArrayList<Person>();
	private AtomicLong atomic = new AtomicLong();

	public PersonDaoImpl() {
		initData();
	}

	private void initData() {
		if (list.isEmpty()) {
			list.add(new Person(atomic.incrementAndGet(), "张三", 45));
			list.add(new Person(atomic.incrementAndGet(), "李四", 13));
			list.add(new Person(atomic.incrementAndGet(), "王五", 55));
			list.add(new Person(atomic.incrementAndGet(), "赵六", 31));
		}
	}

	@Override
	public List<Person> personList() {
		return list;
	}

	public boolean creatPerson(Person p) {
		return list.add(new Person(atomic.incrementAndGet(), p.getName(), p
				.getAge()));
	}

	public Person getPerson(long id) {
		for (Person per : list) {
			if (id == per.getId()) {
				return per;
			}
		}
		return null;
	}

	public boolean updatePerson(Person p) {
		for (Person per : list) {
			if (p.getId() == per.getId()) {
				list.remove(per);
				list.add(p);
				return true;
			}
		}
		return false;
	}

	public boolean deletePerson(long id) {
		for (Person per : list) {
			if (id == per.getId()) {
				return list.remove(per);
			}
		}
		return false;
	}
}
