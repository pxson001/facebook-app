package com.facebook.feedback.ui;

import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.ufiservices.flyout.FeedbackParams;

/* compiled from: selected_object_position */
public interface OnFeedbackLoadListener {
    void mo197a(ServiceException serviceException, FeedbackParams feedbackParams);

    void mo199b(GraphQLFeedback graphQLFeedback);

    void mo200c(GraphQLFeedback graphQLFeedback);
}
