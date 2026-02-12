package com.tka.sams.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.sams.api.entity.AttendanceRecord;
import com.tka.sams.api.entity.Subject;
import com.tka.sams.api.entity.Users;
import com.tka.sams.api.model.AttendanceRecordRequest;
import com.tka.sams.api.model.attendance.StudentAttendanceGroupedDto;
import com.tka.sams.api.service.AttendanceRecordService;
import com.tka.sams.api.service.SubjectService;
import com.tka.sams.api.service.UserService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("http://localhost:5273")

public class AttendanceController {

	@Autowired
	private AttendanceRecordService attendanceRecordService;

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/get-all-attendance-records")
	public List<AttendanceRecord> getAllAttendanceRecords() {
		return attendanceRecordService.getAllAttendanceRecords();
	}

	@GetMapping("/get-attendance-by-faculty/{facultyUsername}")
	public List<AttendanceRecord> getAttendanceByFaculty(@PathVariable String facultyUsername) {
		return attendanceRecordService.getAttendanceByFaculty(facultyUsername);
	}

	@GetMapping("/get-attendance-by-date-subject/{date}/{subjectId}")
	public List<AttendanceRecord> getAllAttendanceRecords(@PathVariable String date, @PathVariable long subjectId) {
		return attendanceRecordService.getAllAttendanceRecords(date, subjectId);
	}

	@GetMapping("/get-attendance/{faculty}/{subjectId}/{date}")
	public List<AttendanceRecord> getAttendanceByFacultySubjectDate(@PathVariable String faculty,
			@PathVariable long subjectId, @PathVariable String date) {
		return attendanceRecordService.getAttendanceByFacultySubjectDate(faculty, subjectId, date);
	}

	@PostMapping("/take-attendance")
	public AttendanceRecord createAttendanceRecord(@RequestBody AttendanceRecordRequest request) {

		Users user = userService.getUserByName(request.getUsername());
		Subject subject = subjectService.getSubjectById(request.getSubjectId());
	
		AttendanceRecord attendanceRecord = new AttendanceRecord();
		attendanceRecord.setUser(user);
		attendanceRecord.setSubject(subject);
		attendanceRecord.setDate(request.getDate());
		attendanceRecord.setTime(request.getTime());
		attendanceRecord.setStudents(request.getStudents());
		attendanceRecord.setNumberOfStudents(request.getStudents().size());
		
		return attendanceRecordService.saveAttendance(attendanceRecord);
	}

	@GetMapping("/student/{studentId}/subject/{subjectId}")
	public StudentAttendanceGroupedDto getAttendanceByStudentAndSubject(@PathVariable long studentId,
			@PathVariable long subjectId) {

		return attendanceRecordService.getAttendanceForStudentAndSubject(studentId, subjectId);

	}

}
