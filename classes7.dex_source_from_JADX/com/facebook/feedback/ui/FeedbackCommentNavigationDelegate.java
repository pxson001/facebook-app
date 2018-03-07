package com.facebook.feedback.ui;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.flyout.ProfileListParams.Builder;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import com.facebook.ufiservices.flyout.UFIProfileListFragment;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: scaled_image */
public class FeedbackCommentNavigationDelegate extends BaseCommentNavigationDelegate {
    private PopoverFragmentContainer f4447a;
    private SecureContextHelper f4448b;
    private UriIntentMapper f4449c;
    private FeedbackParams f4450d;

    @Inject
    public FeedbackCommentNavigationDelegate(@Assisted PopoverFragmentContainer popoverFragmentContainer, @Assisted FeedbackParams feedbackParams, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, UFIPopoverLauncher uFIPopoverLauncher) {
        super(feedbackParams.h(), popoverFragmentContainer, uFIPopoverLauncher);
        this.f4447a = popoverFragmentContainer;
        this.f4448b = secureContextHelper;
        this.f4449c = uriIntentMapper;
        this.f4450d = feedbackParams;
    }

    public final void mo226b(GraphQLComment graphQLComment) {
        GraphQLFeedback l = graphQLComment.l();
        Builder builder = new Builder();
        builder.a = l.z_();
        Builder builder2 = builder;
        builder2.d = ProfileListParamType.LIKERS_FOR_FEEDBACK_ID;
        ProfileListParams a = builder2.a();
        UFIProfileListFragment uFIProfileListFragment = new UFIProfileListFragment();
        uFIProfileListFragment.g(a.k());
        this.f4447a.a(uFIProfileListFragment);
    }

    public void mo225a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m5034a(graphQLComment, null, graphQLFeedback.z_(), true, feedbackLoggingParams);
    }

    public final void mo227b(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m5034a(graphQLComment, null, graphQLFeedback.z_(), false, feedbackLoggingParams);
    }

    public void mo224a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m5034a(graphQLComment, graphQLComment2, graphQLFeedback.z_(), false, feedbackLoggingParams);
    }

    private void m5034a(GraphQLComment graphQLComment, @Nullable GraphQLComment graphQLComment2, String str, boolean z, FeedbackLoggingParams feedbackLoggingParams) {
        GraphQLFeedback l = graphQLComment.l();
        Preconditions.checkArgument(!Strings.isNullOrEmpty(l.z_()), "Cannot show replies for reply without an ID");
        String y = graphQLComment2 != null ? graphQLComment2.y() : null;
        ThreadedCommentsFeedbackFragment threadedCommentsFeedbackFragment = new ThreadedCommentsFeedbackFragment();
        FeedbackParams.Builder builder = new FeedbackParams.Builder();
        builder.a = graphQLComment.l();
        builder = builder;
        builder.m = y;
        FeedbackParams.Builder builder2 = builder;
        builder2.p = GraphQLHelper.b(l);
        builder2 = builder2;
        builder2.g = feedbackLoggingParams;
        builder2 = builder2;
        builder2.f = str;
        builder2 = builder2;
        builder2.i = z;
        threadedCommentsFeedbackFragment.g(builder2.a(this.f4450d.k).a().v());
        this.f4447a.a(threadedCommentsFeedbackFragment);
    }

    public void mo223a(Context context, String str, String str2) {
        this.f4448b.a(this.f4449c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aH, str, str2)), context);
    }
}
