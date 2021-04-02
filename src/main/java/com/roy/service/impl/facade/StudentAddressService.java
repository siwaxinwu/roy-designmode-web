package com.roy.service.impl.facade;

import com.roy.entity.Student;
import com.roy.service.facade.IStudentAddress;
import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:37 2021-03-29
 */
@Service
public class StudentAddressService implements IStudentAddress {

  @Override
  public String getAddress() {
    Student student = new Student();
    return student.getAddress();
  }
}
