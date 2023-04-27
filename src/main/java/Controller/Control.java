package Controller;

public class Control {
	public static Object catchnull(Object o) {
		try {
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}
}
