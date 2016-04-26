package utilPkg;

import java.util.ArrayList;
import java.util.Arrays;

public class ValUtils {
	public static void valEmail(String obj) throws Exception {
		valFormat(obj, "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", "Invalid email format!");
	}

	public static void valName() throws Exception {

	}

	public static void valAge() throws Exception {

	}

	public static void valDate() throws Exception {

	}

	public static void valEmpty(Object obj) throws Exception {
		valEmpty(obj, "Argument cannot be empty!");
	}

	public static void valEmpty(Object obj, String message) throws Exception {
		if (obj == null)
			throw new IllegalArgumentException("Argument is null!");

		String[] s = obj.getClass().toString().split("\\.");

		if (!s[s.length - 1].equals("String"))
			throw new IllegalArgumentException("Argument must be a String or an Object!");

		if (obj.toString().trim().equals(""))
			throw new IllegalArgumentException(message);
	}

	public static void valFormat(String obj, String format) throws Exception {
		valFormat(obj, format, true);
	}

	public static void valFormat(String obj, String format, String message) throws Exception {
		valFormat(obj, format, message, true);
	}

	public static void valFormat(String obj, String format, boolean toMatch) throws Exception {
		String message = toMatch ? "Argument format must be \"" + format + "\""
		: "Argument format must not be \"" + format + "\"";
		valFormat(obj, format, message, toMatch);
	}

	public static void valFormat(String obj, String format, String message, boolean toMatch)
	throws Exception {
		if (toMatch) {
			if (!obj.matches(format))
				throw new IllegalArgumentException(message);
		} else {
			if (obj.matches(format))
				throw new IllegalArgumentException(message);
		}
	}

	public static void valRangedValue(Object obj, Object min, Object max) throws Exception {
		valRangedValue(obj, min, max, true);
	}

	public static void valRangedValue(Object obj, Object min, Object max, boolean inside)
	throws Exception {
		String message = inside
		? "Argument must be inside [" + min.toString() + ", " + max.toString() + "]!"
		: "Argument must be outside [" + min.toString() + ", " + max.toString() + "]!";
		valRangedValue(obj, min, true, max, true, message, inside);
	}

	public static void valRangedValue(Object obj, Object min, Object max, String message)
	throws Exception {
		valRangedValue(obj, min, true, max, true, message, true);
	}

	public static void valRangedValue(Object obj, Object min, Object max, String message,
	boolean inside) throws Exception {
		valRangedValue(obj, min, true, max, true, message, inside);
	}

	public static void valRangedValue(Object obj, Object min, boolean minInclusive, Object max,
	boolean maxInclusive, String message, boolean inside) throws Exception {
		String[] s = obj.getClass().toString().split("\\.");
		ArrayList<String> types = new ArrayList<>(6);
		types.add("Byte");
		types.add("Short");
		types.add("Integer");
		types.add("Long");
		types.add("Float");
		types.add("Double");

		if (!types.contains(s[s.length - 1]))
			throw new IllegalArgumentException("Argument must be a number!");

		double obj1 = (double) obj;
		double min1 = (double) min;
		double max1 = (double) max;

		if (inside) {
			if (minInclusive && maxInclusive && !(min1 <= obj1 && obj1 <= max1))
				throw new IllegalArgumentException(message);

			if (!minInclusive && maxInclusive && !(min1 < obj1 && obj1 <= max1))
				throw new IllegalArgumentException(message);

			if (minInclusive && !maxInclusive && !(min1 <= obj1 && obj1 < max1))
				throw new IllegalArgumentException(message);

			if (!minInclusive && !maxInclusive && !(min1 < obj1 && obj1 < max1))
				throw new IllegalArgumentException(message);
		} else {
			if (minInclusive && maxInclusive && min1 <= obj1 && obj1 <= max1)
				throw new IllegalArgumentException(message);

			if (!minInclusive && maxInclusive && min1 < obj1 && obj1 <= max1)
				throw new IllegalArgumentException(message);

			if (minInclusive && !maxInclusive && min1 <= obj1 && obj1 < max1)
				throw new IllegalArgumentException(message);

			if (!minInclusive && !maxInclusive && min1 < obj1 && obj1 < max1)
				throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Validate value in a specified set of values. Type must be a number or a String.
	 * 
	 * @param obj
	 * @param values
	 * @throws Exception
	 */
	public static void valSelectedValues(Object obj, Object[] values) throws Exception {
		valSelectedValues(obj, values, true);
	}

	/**
	 * Validate value in a specified set of values. Type must be a number or a String.
	 * 
	 * @param obj
	 * @param values
	 * @param message
	 * @throws Exception
	 */
	public static void valSelectedValues(Object obj, Object[] values, String message)
	throws Exception {
		valSelectedValues(obj, values, message, true);
	}

	/**
	 * Validate value in a specified set of values. Type must be a number or a String.
	 * 
	 * @param obj
	 * @param values
	 * @param toMatch
	 * @throws Exception
	 */
	public static void valSelectedValues(Object obj, Object[] values, boolean toMatch)
	throws Exception {
		String message = toMatch ? "Argument must be in " + Arrays.toString(values)
		: "Argument must not be in " + Arrays.toString(values);
		valSelectedValues(obj, values, message, true);
	}

	/**
	 * Validate value in a specified set of values. Type must be a number or a String.
	 * 
	 * @param obj
	 * @param values
	 * @param message
	 * @param toMatch
	 * @throws Exception
	 */
	public static void valSelectedValues(Object obj, Object[] values, String message,
	boolean toMatch) throws Exception {
		if (values == null)
			throw new IllegalAccessException("Array argument is null!");

		if (values.length == 0)
			throw new IllegalArgumentException("Array argument is empty!");

		String[] s = obj.getClass().toString().split("\\.");
		String type = s[s.length - 1];
		ArrayList<String> types = new ArrayList<>(7);
		types.add("Byte");
		types.add("Short");
		types.add("Integer");
		types.add("Long");
		types.add("Float");
		types.add("Double");
		types.add("String");

		if (!types.contains(type))
			throw new IllegalArgumentException("Argument must be a number or a String!");

		ArrayList<Object> objs = new ArrayList<>();

		for (Object object : values) {
			objs.add(object);
		}

		if (toMatch && !objs.contains(obj))
			throw new IllegalArgumentException(message);

		if (!toMatch && objs.contains(obj))
			throw new IllegalArgumentException(message);
	}
}
