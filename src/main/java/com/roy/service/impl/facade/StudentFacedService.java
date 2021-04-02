package com.roy.service.impl.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 对外提供一个服务专供某个应用调用 在实际开发的过程中，我们提供服务出去，应该专属提供给他，而不是让消费者到处找 针对不同的消费者如果能共用服务的话，就抽取公共的
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 10:42 2021-03-29
 */
@Service
public class StudentFacedService {

  @Autowired private StudentNameService studentNameService;

  @Autowired private StudentAgeService studentAgeService;

  @Autowired private StudentAddressService studentAddressService;

  public String getStudentName() {
    return studentNameService.getName();
  }

  public int getStudentAge() {
    return studentAgeService.getAge();
  }

  public String getStudentAddress() {
    return studentAddressService.getAddress();
  }
}
