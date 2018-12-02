package mx.ipn.escom.wad.tarea6.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FieldErrors {
	private Map<String, List<String>> errores;

	public FieldErrors() {
		errores = new HashMap<String, List<String>>();
	}

	public void add(String name, String error) {
		if (errores.containsKey(name)) {
			List<String> list = errores.get(name);
			list.add(error);
			errores.put(name, list);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(error);
			errores.put(name, list);
		}
	}

	public List<String> get(String name) {
		List<String> list = errores.get(name);
		return list != null ? list : new ArrayList<String>();
	}

	public List<String> remove(String name) {
		return errores.remove(name);
	}

	public Set<String> getKeys() {
		return errores.keySet();
	}

	public Boolean hasErrors() {
		return !errores.isEmpty();
	}
}
