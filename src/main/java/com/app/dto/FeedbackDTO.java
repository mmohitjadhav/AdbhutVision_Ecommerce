package com.app.dto;


import org.springframework.beans.BeanUtils;


import com.app.model.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDTO {

	private int feedbackId;
	
	private String email;
	
	private String message;
	
	private int rating;
	
	private int customerId;
	
	private String name;

	public Feedback toEntity(FeedbackDTO dto) {
		Feedback feedback=new Feedback();
		BeanUtils.copyProperties(dto, feedback);		
		return feedback;
	}
}