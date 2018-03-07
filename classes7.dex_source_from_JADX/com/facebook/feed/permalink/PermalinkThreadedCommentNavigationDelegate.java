package com.facebook.feed.permalink;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.ReplyToMentionHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import javax.inject.Inject;

/* compiled from: admin_tapped_settings */
public class PermalinkThreadedCommentNavigationDelegate extends PermalinkCommentNavigationDelegate {
    public CommentsHelper f19648a;

    @Inject
    public PermalinkThreadedCommentNavigationDelegate(@Assisted Context context, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, UFIPopoverLauncher uFIPopoverLauncher) {
        super(context, iFeedIntentBuilder, secureContextHelper, uriIntentMapper, uFIPopoverLauncher);
    }

    public final void mo225a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        ReplyToMentionHelper.m5190a(graphQLComment, this.f19648a);
    }

    public final void mo224a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
    }

    public final void mo223a(Context context, String str, String str2) {
    }
}
