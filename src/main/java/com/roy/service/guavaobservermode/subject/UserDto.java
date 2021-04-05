package com.roy.service.guavaobservermode.subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 16:43
 */
@Data
@ToString
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private LocalDateTime registerTime;
}