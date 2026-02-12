package com.tka.sams.api.model.attendance;

import java.util.List;

public class AttendanceListResponse {
    private String studentName;
    private String studentEmail;
    private List<StudentAttendanceDto> attendances;

    public AttendanceListResponse() {
		// TODO Auto-generated constructor stub
	}

	public AttendanceListResponse(String studentName, String studentEmail, List<StudentAttendanceDto> attendances) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.attendances = attendances;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public List<StudentAttendanceDto> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<StudentAttendanceDto> attendances) {
		this.attendances = attendances;
	}
    
    
}
