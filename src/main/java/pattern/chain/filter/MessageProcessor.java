package pattern.chain.filter;

public class MessageProcessor {
	String msg;
	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String process(String msg) {
		return  msg.replace("<","[").replace(">","]");
	}
}
