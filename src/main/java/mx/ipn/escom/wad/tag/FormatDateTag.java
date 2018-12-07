package mx.ipn.escom.wad.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormatDateTag extends SimpleTagSupport {
    private Date date;
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		if(this.date != null) {
			JspWriter out = getJspContext().getOut();
			String formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
			out.println(formatedDate);
		}
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
