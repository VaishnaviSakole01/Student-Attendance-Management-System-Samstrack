package com.tka.sams.api.model.attendance;
public class DateTimeDto {
    private String facultyName;
    private String date;
    private String time;

    public DateTimeDto() {
		// TODO Auto-generated constructor stub
	}

	public DateTimeDto(String facultyName, String date, String time) {
		super();
		this.facultyName = facultyName;
		this.date = date;
		this.time = time;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
    
}
