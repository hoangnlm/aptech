package java2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java2.DataStructure.DataStructureIterator;

public class ngay1804  {

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();
		roster.add(new Person("name1", 15, Person.Sex.MALE, "email1"));
		roster.add(new Person("name2", 18, Person.Sex.FEMALE, "email2"));
		roster.add(new Person("name3", 33, Person.Sex.MALE, "email3"));
		roster.add(new Person("name4", 22, Person.Sex.MALE, "email4"));
		roster.add(new Person("name5", 18, Person.Sex.MALE, "email5"));

//		processPersonsWithFunction(roster,
//		p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
//		p -> p.getEmailAddress(), email -> System.out.println(email));
	
		Predicate<Person> tester = new Predicate<Person>() {
			
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		};
		
		Function<Person, String> mapper = new Function<Person, String>() {
			
			@Override
			public String apply(Person p) {
				return p.emailAddress;
			}
		};
		
		Consumer<String> block = new Consumer<String>() {
			
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		
		processPersonsWithFunction(roster, tester, mapper, block);
		
	}

	public static void processPersonsWithFunction(List<Person> roster,
	Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}

class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	int age;
	Sex gender;
	String emailAddress;

	public Person(String name, int age, Sex gender, String emailAddress) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public int getAge() {
		return age;
	}

	public void printPerson() {
		// ...
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}
}
