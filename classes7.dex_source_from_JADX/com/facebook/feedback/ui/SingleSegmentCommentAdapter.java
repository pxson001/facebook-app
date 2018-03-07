package com.facebook.feedback.ui;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.widget.listview.FbListAdapter;

/* compiled from: scriptURL */
public interface SingleSegmentCommentAdapter extends Bindable<FeedProps<GraphQLFeedback>>, FbListAdapter {
    GraphQLComment mo205a(int i);

    void mo206a(FeedbackLoggingParams feedbackLoggingParams);

    void mo207a(NotificationLogObject notificationLogObject);

    void mo208a(String str);
}
