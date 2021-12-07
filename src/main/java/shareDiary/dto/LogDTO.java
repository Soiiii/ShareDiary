package shareDiary.dto;

public class LogDTO {
	private LogDTO() { }
	private static LogDTO instance = new LogDTO();
	public static LogDTO getInstance() {
		return instance;
	}
	
	private int log_no;
	private String log_ip, log_target, log_date, log_id, log_etc;
	public int getLog_no() {
		return log_no;
	}
	public void setLog_no(int log_no) {
		this.log_no = log_no;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public String getLog_target() {
		return log_target;
	}
	public void setLog_target(String log_target) {
		this.log_target = log_target;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
	public String getLog_etc() {
		return log_etc;
	}
	public void setLog_etc(String log_etc) {
		this.log_etc = log_etc;
	}
}
