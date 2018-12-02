package mx.ipn.escom.wad.tag;

import java.util.List;

import mx.ipn.escom.wad.tarea6.util.FieldErrors;

public class Functions {
	public static List<String> getErrors(FieldErrors fieldErrors, String name) {
		return fieldErrors.get(name);
	}
}
