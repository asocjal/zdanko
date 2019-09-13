package zadanko;

import java.util.HashMap;
import java.util.Map;

public class Family {

	private int currentYear = 2000;
	private final Map<String, Integer> members = new HashMap<>();

	public Family(int currentYear) {
		changeYear(currentYear);
	}
	
	private int calYear(final int age) {
		if (age < 0) {
			throw new RuntimeException("Age cannot be lower than 0");
		}
		if (age > 200) {
			throw new RuntimeException("Age cannot be higher than 200");
		}
		return currentYear - age;
	}
	
	private void verifyName(final String name) throws Exception {
		if(name == null) {
			throw new Exception("Name cannot be null");
		}
		if(name.trim().length() < 3) {
			throw new Exception("Person name cannot be shorter than 3 characters");
		}
	}

	/**
	 * Adds new person
	 * 
	 * @param name Person name
	 * @param age Person age as it was in specified year
	 */
	public void addPerson(final String name, final int age) {
		try {
			verifyName(name);
			if (members.get(name) != null) {
				throw new Exception("Person " + name + "' already exists");
			}
			members.put(name, calYear(age));
		} catch (Exception ex) {
			throw new RuntimeException("Cannot add peron '" + name + "'", ex);
		}
	}

	/**
	 * Modifies existing person
	 * 
	 * @param name Person name
	 * @param age Person age as it was in specified year
	 */
	public void modifyPerson(final String name, final int age) {
		try {
			verifyName(name);
			if (members.get(name) == null) {
				throw new Exception("No person with name " + name + "'");
			}
			members.put(name, calYear(age));
		} catch (Exception ex) {
			throw new RuntimeException("Cannot modify persn '" + name + "'", ex);
		}
	}

	/**
	 * Changes current year
	 * 
	 * @param year New year
	 */
	public void changeYear(final int year) {
		if (year < 1900) {
			throw new RuntimeException("Year cannot be lower than 1900");
		}
		if (year > 2100) {
			throw new RuntimeException("Year cannot be higher than 2100");
		}
		currentYear = year;
	}

	/**
	 * 
	 * Sum of all family members age together for specified year
	 * 
	 * @return Sum of age for every family member
	 */
	public int sumFamilyAge() {
		int sum = 0;
		for (int year : members.values()) {
			int diff = currentYear - year;
			if (diff > 0) {
				sum += diff;
			}
		}
		return sum;
	}

}
