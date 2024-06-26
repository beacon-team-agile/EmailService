package com.teamagile.emailApplication.domain.responses.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseStatus {
    private Boolean success;
    private String message;
}
