package com.roy.service.impl.facade;

import com.roy.entity.Student;
import com.roy.service.facade.IStudentName;
import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:37 2021-03-29
 */
@Service
public class StudentNameService implements IStudentName {

  @Override
  public String getName() {
    Student student = new Student();
    return student.getName();
  }
}
