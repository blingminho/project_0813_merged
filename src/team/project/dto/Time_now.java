package team.project.dto;
/**
 * DateToday.java와 관련있음
 * @author june
 *
 */
public class Time_now {
	private String simpletoday;//yyyyMMdd
	private String simple_today;//yyyy-MM-dd
	private String timetoday;//hh:mm:ss
	private String simple_before;//어제의 yyyy-MM-dd
	private String day;//오늘 dd
	private String before3Month_start;
	private String before3Month_end;
	private String before1Month_start;
	private String before2Month_start;
	private String before4Month_start;
	private String before5Month_start;

	
	public Time_now(String simpletoday, String simple_today, String timetoday, String simple_before, String day,
			String before3Month_start, String before3Month_end, String before1Month_start, String before2Month_start,
			String before4Month_start, String before5Month_start) {
		super();
		this.simpletoday = simpletoday;
		this.simple_today = simple_today;
		this.timetoday = timetoday;
		this.simple_before = simple_before;
		this.day = day;
		this.before3Month_start = before3Month_start;
		this.before3Month_end = before3Month_end;
		this.before1Month_start = before1Month_start;
		this.before2Month_start = before2Month_start;
		this.before4Month_start = before4Month_start;
		this.before5Month_start = before5Month_start;
	}
	public String getBefore2Month_start() {
		return before2Month_start;
	}
	public void setBefore2Month_start(String before2Month_start) {
		this.before2Month_start = before2Month_start;
	}
	public String getBefore4Month_start() {
		return before4Month_start;
	}
	public void setBefore4Month_start(String before4Month_start) {
		this.before4Month_start = before4Month_start;
	}
	public String getBefore5Month_start() {
		return before5Month_start;
	}
	public void setBefore5Month_start(String before5Month_start) {
		this.before5Month_start = before5Month_start;
	}
	public String getBefore3Month_start() {
		return before3Month_start;
	}
	public void setBefore3Month_start(String before3Month_start) {
		this.before3Month_start = before3Month_start;
	}
	public String getBefore3Month_end() {
		return before3Month_end;
	}
	public void setBefore3Month_end(String before3Month_end) {
		this.before3Month_end = before3Month_end;
	}
	public String getBefore1Month_start() {
		return before1Month_start;
	}
	public void setBefore1Month_start(String before1Month_start) {
		this.before1Month_start = before1Month_start;
	}
	public String getSimpletoday() {
		return simpletoday;
	}
	public void setSimpletoday(String simpletoday) {
		this.simpletoday = simpletoday;
	}
	public String getSimple_today() {
		return simple_today;
	}
	public void setSimple_today(String simple_today) {
		this.simple_today = simple_today;
	}
	public String getTimetoday() {
		return timetoday;
	}
	public void setTimetoday(String timetoday) {
		this.timetoday = timetoday;
	}
	public String getSimple_before() {
		return simple_before;
	}
	public void setSimple_before(String simple_before) {
		this.simple_before = simple_before;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
