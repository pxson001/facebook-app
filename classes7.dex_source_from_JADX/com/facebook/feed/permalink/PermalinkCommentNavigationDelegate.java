package com.facebook.feed.permalink;

import android.content.Context;
import android.content.Intent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedback.ui.BaseCommentNavigationDelegate;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: album_creator */
public class PermalinkCommentNavigationDelegate extends BaseCommentNavigationDelegate {
    private Context f19551a;
    private IFeedIntentBuilder f19552b;
    private SecureContextHelper f19553c;
    private UriIntentMapper f19554d;

    @Inject
    public PermalinkCommentNavigationDelegate(@Assisted Context context, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, UFIPopoverLauncher uFIPopoverLauncher) {
        super("story_view", context, uFIPopoverLauncher);
        this.f19551a = context;
        this.f19552b = iFeedIntentBuilder;
        this.f19553c = secureContextHelper;
        this.f19554d = uriIntentMapper;
    }

    public final void mo226b(GraphQLComment graphQLComment) {
        Intent a = this.f19552b.a(graphQLComment.l().z_());
        a.putExtra("fragment_title", this.f19551a.getString(2131233291));
        this.f19553c.b(a, this.f19551a);
    }

    public void mo225a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m22864a(graphQLComment, null, graphQLFeedback.j(), feedbackLoggingParams);
    }

    public final void mo227b(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m22864a(graphQLComment, null, graphQLFeedback.j(), feedbackLoggingParams);
    }

    public void mo224a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m22864a(graphQLComment, graphQLComment2, graphQLFeedback.j(), feedbackLoggingParams);
    }

    private void m22864a(GraphQLComment graphQLComment, @Nullable GraphQLComment graphQLComment2, String str, FeedbackLoggingParams feedbackLoggingParams) {
        this.f19553c.a(this.f19552b.a(graphQLComment.y(), graphQLComment, graphQLComment2 != null ? graphQLComment2.y() : null, str, GraphQLHelper.b(graphQLComment.l()), feedbackLoggingParams), this.f19551a);
    }

    public void mo223a(Context context, String str, String str2) {
        this.f19553c.a(this.f19554d.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aH, str, str2)), context);
    }
}
