package mx.ipn.escom.wad.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;
import mx.ipn.escom.wad.tarea6.util.FieldErrors;

public class InputTag extends SimpleTagSupport {
	public static final String INPUT_TEXT = "text";
	public static final String DEFAULT = INPUT_TEXT;
	private String id;
	private String name;
	private String type;
	private String value;
	private String cssClass;
	private String errorClass;
	private String showErrors;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspWriter out = getJspContext().getOut();
		StringBuilder sb = new StringBuilder("<input ");
		sb.append("id=\"" + this.id + "\" ");
		sb.append("name=\"" + this.name + "\" ");
		if (this.type == null || (this.type != null && this.type.equals(""))) {
			sb.append("type=\"" + DEFAULT + "\" ");
		} else {
			sb.append("type=\"" + this.type + "\" ");
		}
		if (this.value != null && !this.value.equals("")) {
			sb.append("value=\"" + this.value + "\" ");
		}
		StringBuilder classTemp = new StringBuilder();
		if (this.cssClass != null && !this.cssClass.equals("")) {
			classTemp.append(this.cssClass);
		}
		String erroresString = "";
		if (showErrors != null && showErrors.equals("true")) {
			FieldErrors listErrores = (FieldErrors) getJspContext().findAttribute("fieldErrors");
			FieldErrors sessionListError = (FieldErrors) getJspContext().getAttribute(NombreObjetosSession.FIELD_ERRORS,
					PageContext.SESSION_SCOPE);
			System.out.println("--> PC: " + listErrores);
			System.out.println("--> PC: " + sessionListError);
			listErrores = (listErrores == null && sessionListError != null) ? sessionListError : listErrores;

			if (listErrores != null) {
				List<String> nameError = listErrores.get(this.name);
				if (!nameError.isEmpty()) {
					StringBuilder errores = new StringBuilder("<div class=\"invalid-feedback\">");
					errores.append("<ul class=\"error-list\">");
					for (String e : nameError) {
						errores.append("<li>" + e + "</li>");
					}
					errores.append("</ul></div>");
					erroresString = errores.toString();
					if (this.errorClass != null && !this.errorClass.equals("")) {
						classTemp.append(" ").append(this.errorClass);
					}
				}
			} else {
				System.err.println("listErrors NULL");
			}
		}
		sb.append("class=\"" + classTemp + "\" ");
		sb.append("/>");
		System.err.println("SB: " + sb.toString());
		sb.append(erroresString);
		System.err.println("SB 1: " + sb.toString());
		out.print(sb.toString());
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass
	 *            the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	/**
	 * @return the errorClass
	 */
	public String getErrorClass() {
		return errorClass;
	}

	/**
	 * @param errorClass
	 *            the errorClass to set
	 */
	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	/**
	 * @return the showErrors
	 */
	public String getShowErrors() {
		return showErrors;
	}

	/**
	 * @param showErrors
	 *            the showErrors to set
	 */
	public void setShowErrors(String showErrors) {
		this.showErrors = showErrors;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
