package com.db.donaldapi.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionMessageDto {
    private String content;
    private LocalDateTime dateTime;
}
