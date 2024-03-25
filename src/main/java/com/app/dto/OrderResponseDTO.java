package com.app.dto;


import java.util.List;

import com.app.model.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {

	private Orders order;
	
	private List<OrderDetailsDTO> details;
	
}