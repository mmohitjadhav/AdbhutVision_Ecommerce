package com.app.service;


import java.util.List;

import com.app.model.*;

public interface FeedbackService {

	void saveFeedback(Feedback feedback);

	List<Feedback> findAllFeedbacks();

}

