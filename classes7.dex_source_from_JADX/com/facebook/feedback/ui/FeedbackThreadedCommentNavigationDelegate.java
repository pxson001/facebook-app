package com.facebook.feedback.ui;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import javax.inject.Inject;

/* compiled from: runJSBundle */
public class FeedbackThreadedCommentNavigationDelegate extends FeedbackCommentNavigationDelegate {
    public CommentsHelper f4574a;

    @Inject
    public FeedbackThreadedCommentNavigationDelegate(@Assisted PopoverFragmentContainer popoverFragmentContainer, @Assisted FeedbackParams feedbackParams, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, UFIPopoverLauncher uFIPopoverLauncher) {
        super(popoverFragmentContainer, feedbackParams, secureContextHelper, uriIntentMapper, uFIPopoverLauncher);
    }

    public final void mo225a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        ReplyToMentionHelper.m5190a(graphQLComment, this.f4574a);
    }

    public final void mo224a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
    }

    public final void mo223a(Context context, String str, String str2) {
    }
}
