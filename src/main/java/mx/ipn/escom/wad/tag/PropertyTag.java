package mx.ipn.escom.wad.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import mx.ipn.escom.wad.tarea6.util.PropertyAccess;

public class PropertyTag extends SimpleTagSupport {
    private String propertyName;
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		if(this.propertyName != null) {
			JspWriter out = getJspContext().getOut();
			String property = PropertyAccess.getProperty(this.propertyName);
			out.println(property);
		}
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setProperty(String property) {
		this.propertyName = property;
	}
}
