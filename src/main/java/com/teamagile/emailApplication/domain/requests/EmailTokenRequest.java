package com.teamagile.emailApplication.domain.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailTokenRequest {
	String email;
	String token;
}
