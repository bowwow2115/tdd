package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradesServiceTest {

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JdbcTemplate jdbc;

    @BeforeEach
    public void setupDatabase() {
        jdbc.execute("insert into student(id, firstname, lastname, email_address)" +
                "values (1, 'SeungHun', 'Park', 'bowwow12@naver.com')");
    }

    @AfterEach
    public void setUpAfterTransaction() {
        jdbc.execute("DELETE FROM student");
    }

    @Test
    public void createStudentService() {

        studentService.createStudent("SeungHun", "Park", "bowwow12@naver.com");

        CollegeStudent student = studentDao.findByEmailAddress("bowwow12@naver.com");

        assertEquals("bowwow12@naver.com", student.getEmailAddress());
    }

    @Test
    public void isStudentNullCheck() {
        assertTrue(studentService.checkIfStudentIsNull(1));
        assertFalse(studentService.checkIfStudentIsNull(0));
    }
}
