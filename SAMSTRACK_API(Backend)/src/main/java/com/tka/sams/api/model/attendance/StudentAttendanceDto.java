package com.tka.sams.api.model.attendance;

import java.util.List;

public class StudentAttendanceDto {
	private String attendanceId;
	private String date;
	private String time;
	private SubjectDto subject;
	private FacultyDto faculty;
	private List<StudentDto> students;

	public StudentAttendanceDto() {
		// TODO Auto-generated constructor stub
	}

	public StudentAttendanceDto(String attendanceId, String date, String time, SubjectDto subject, FacultyDto faculty,
			List<StudentDto> students) {
		super();
		this.attendanceId = attendanceId;
		this.date = date;
		this.time = time;
		this.subject = subject;
		this.faculty = faculty;
		this.students = students;
	}

	public String getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
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

	public SubjectDto getSubject() {
		return subject;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}

	public FacultyDto getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyDto faculty) {
		this.faculty = faculty;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}

}
