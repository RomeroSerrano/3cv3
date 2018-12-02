package mx.ipn.escom.wad.tarea6.util;

public class Message {
	private String type;
	private String text;

	public enum MessageType{
		MESSAGE_ALERT("MESSAGE_ALERT"),
		MESSAGE_SUCCESS("MESSAGE_SUCCESS"),
		MESSAGE_DANGER("MESSAGE_DANGER"),
		MESSAGE_WARNING("MESSAGE_WARNING");
		
		private String type;
		
		private MessageType(String type) {
			this.type = type;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public Message() {
		super();
	}
	
	public Message(MessageType type, String text) {
		super();
		this.type = type.getType();
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
