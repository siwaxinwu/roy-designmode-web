package com.roy.service.impl.facade;

import com.roy.entity.Student;
import com.roy.service.facade.IStudentAge;
import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:37 2021-03-29
 */
@Service
public class StudentAgeService implements IStudentAge {

  @Override
  public int getAge() {
    Student student = new Student();
    return student.getAge();
  }
}
