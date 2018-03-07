package com.facebook.feedback.ui;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.offlinemode.comments.CanHandleSuccessfulOfflineComment;

/* compiled from: savedHasUserInteracted */
public interface FeedbackEventSubscriber extends Bindable<GraphQLFeedback>, CanHandleSuccessfulOfflineComment {
    void mo234a();
}
