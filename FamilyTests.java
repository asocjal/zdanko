package zadanko;

public class FamilyTests {

	private static void testBasic() {
		Family family = new Family(1995);
		family.addPerson("Michał", 3);
		family.addPerson("Rafał", 6);
		if (family.sumFamilyAge() != 9) {
			throw new RuntimeException("Test failed. Incorrect age calculated");
		}
	}

	private static void testChangeYear() {
		Family family = new Family(1995);
		family.addPerson("Michał", 3);
		family.addPerson("Rafał", 6);
		family.changeYear(2005);
		if (family.sumFamilyAge() != 29) {
			throw new RuntimeException("Test failed. Incorrect age calculated");
		}
	}

	private static void testChangeYear2() {
		Family family = new Family(1995);
		family.addPerson("Michał", 3);
		family.addPerson("Rafał", 6);
		family.changeYear(2005);
		family.addPerson("Piotr", 1);
		if (family.sumFamilyAge() != 30) {
			throw new RuntimeException("Test failed. Incorrect age calculated");
		}
	}

	private static void testExceptionNegativeYear() {
		try {
			Family family = new Family(1995);
			family.addPerson("Michał", -3);
			throw new RuntimeException("Test failed. Exception not thrown for nagative age");

		} catch (Exception ex) {
			if(!"Cannot add peron 'Michał'".equals(ex.getMessage())) {
				throw new RuntimeException("Test failed. Incorrect exception message");
			}
			if(ex.getCause() == null) {
				throw new RuntimeException("Test failed. Incorrect exception message");
			}
			if(!"Age cannot be lower than 0".equals(ex.getCause().getMessage())) {
				throw new RuntimeException("Test failed. Incorrect exception message");
			}
		}
	}

	public static void main(String[] args) {
		testBasic();
		testChangeYear();
		testChangeYear2();
		testExceptionNegativeYear();
		System.out.println("All tests passed!");
	}
}
