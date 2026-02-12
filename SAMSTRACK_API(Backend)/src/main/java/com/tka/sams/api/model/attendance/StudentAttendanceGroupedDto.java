package com.tka.sams.api.model.attendance;

import java.util.List;

public class StudentAttendanceGroupedDto {
    private Long studentId;
    private String studentName;
    private String email;
    private SubjectDto subject;
    private List<DateTimeDto> dateTime;

    public StudentAttendanceGroupedDto() {
		// TODO Auto-generated constructor stub
	}

	public StudentAttendanceGroupedDto(Long studentId, String studentName, String email, SubjectDto subject,
			List<DateTimeDto> dateTime) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.subject = subject;
		this.dateTime = dateTime;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SubjectDto getSubject() {
		return subject;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}

	public List<DateTimeDto> getDateTime() {
		return dateTime;
	}

	public void setDateTime(List<DateTimeDto> dateTime) {
		this.dateTime = dateTime;
	}
    
    
}
