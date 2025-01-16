package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;
    private String doctorsFirstName;
    private String doctorsLastName;
    private List<String> treatmentTypes;

}
