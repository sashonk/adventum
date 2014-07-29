package adventum.util;

import adventum.model.Identity;
import adventum.model.Person;


public class ModelUtil {

	private ModelUtil() {
		// no-op
	}



	public boolean equals(final Identity i1, final Identity i2) {
		if (i1 == null || i2 == null) {
			throw new NullPointerException();
		}

		if (i1.getClass() != i2.getClass()) {
			return false;
		}

		return i1.getId().equals(i2.getId());
	}

	public static String shortName(final HasName model) {
		StringBuilder sb = new StringBuilder();
		sb.append(model.getLastName());
		sb.append(' ');

		String firstName = model.getFirstName();
		if (firstName.length() > 1) {
			firstName = firstName.substring(0, 1).concat(".");
		}
		sb.append(firstName);


		return sb.toString();
	}




}
