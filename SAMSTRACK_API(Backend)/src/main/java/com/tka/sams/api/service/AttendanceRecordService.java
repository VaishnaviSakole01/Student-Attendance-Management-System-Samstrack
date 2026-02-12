package com.tka.sams.api.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.AttendanceRecordDao;
import com.tka.sams.api.entity.AttendanceRecord;
import com.tka.sams.api.entity.Student;
import com.tka.sams.api.entity.Users;
import com.tka.sams.api.model.attendance.DateTimeDto;
import com.tka.sams.api.model.attendance.StudentAttendanceGroupedDto;
import com.tka.sams.api.model.attendance.SubjectDto;

@Service
public class AttendanceRecordService {
	@Autowired
	private AttendanceRecordDao dao;

	public List<AttendanceRecord> getAllAttendanceRecords() {
		List<AttendanceRecord> records = dao.getAllAttendanceRecords();

		return records;

	}

	public List<AttendanceRecord> getAttendanceByFaculty(String facultyUsername) {
		return dao.getAttendanceByFaculty(facultyUsername);
	}

	public List<AttendanceRecord> getAllAttendanceRecords(String date, long subjectId) {
		List<AttendanceRecord> records = dao.getAllAttendanceRecords(date, subjectId);

		return records;

	}

	public StudentAttendanceGroupedDto getAttendanceForStudentAndSubject(long studentId, long subjectId) {
		List<AttendanceRecord> records = dao.getAttendanceForStudentAndSubject(studentId, subjectId);

		if (records == null || records.isEmpty()) {
			return null;
		}

		StudentAttendanceGroupedDto dto = new StudentAttendanceGroupedDto();

		// Initialize subject and student only once using the first record
		for (AttendanceRecord record : records) {
			// Initialize student details from the record
			for (Student student : record.getStudents()) {
				if (student.getId().equals(studentId)) {
					dto.setStudentId(student.getId());
					dto.setStudentName(student.getName());
					dto.setEmail(student.getEmail());
					break;
				}
			}

			// Subject
			SubjectDto subjectDto = new SubjectDto();
			subjectDto.setId(record.getSubject().getId());
			subjectDto.setName(record.getSubject().getName());
			dto.setSubject(subjectDto);

			// Break after setting once
			break;
		}

		// Fill dateTime list
		List<DateTimeDto> dateTimeList = new ArrayList<>();
		for (AttendanceRecord record : records) {
			DateTimeDto dtDto = new DateTimeDto();
			dtDto.setDate(record.getDate());
			dtDto.setTime(record.getTime());

			Users faculty = record.getUser();
			if (faculty != null) {
				dtDto.setFacultyName(faculty.getFirstName());
			}

			dateTimeList.add(dtDto);
		}

		dto.setDateTime(dateTimeList);

		return dto;
	}

	public AttendanceRecord saveAttendance(AttendanceRecord attendanceRecord) {

		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());

		attendanceRecord.setId(id);

		return dao.saveAttendance(attendanceRecord);
	}

	public List<AttendanceRecord> getAttendanceByFacultySubjectDate(String faculty, long subjectId, String date) {

		return dao.getAttendanceByFacultySubjectDate(faculty, subjectId, date);
	}
}
