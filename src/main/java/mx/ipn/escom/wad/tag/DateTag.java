package mx.ipn.escom.wad.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport {
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	private String format;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = getJspContext().getOut();
		SimpleDateFormat format;
		if (this.format == null
				|| (this.format != null && this.format.equals(""))) {
			format = new SimpleDateFormat(DATE_FORMAT);
		} else {
			format = new SimpleDateFormat(this.format);
		}
		Date date = new Date();
		out.println("<h1>" + format.format(date) + "</h1>");
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
}
