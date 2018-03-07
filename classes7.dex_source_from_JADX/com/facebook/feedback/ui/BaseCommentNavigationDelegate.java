package com.facebook.feedback.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.ufiservices.flyout.EditCommentFragment;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIContentFragment;
import com.facebook.ufiservices.flyout.UFIParamsBuilder;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import com.facebook.ufiservices.flyout.history.CommentEditHistoryFragment;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* compiled from: selector must not be null */
public abstract class BaseCommentNavigationDelegate {
    private final String f4095a;
    private final PopoverFragmentContainer f4096b;
    private final Context f4097c;
    private final UFIPopoverLauncher f4098d;

    public abstract void mo223a(Context context, String str, String str2);

    public abstract void mo224a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams);

    public abstract void mo225a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams);

    public abstract void mo226b(GraphQLComment graphQLComment);

    public abstract void mo227b(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams);

    private BaseCommentNavigationDelegate(String str, PopoverFragmentContainer popoverFragmentContainer, Context context, UFIPopoverLauncher uFIPopoverLauncher) {
        this.f4095a = str;
        this.f4096b = popoverFragmentContainer;
        this.f4097c = context;
        this.f4098d = uFIPopoverLauncher;
    }

    public BaseCommentNavigationDelegate(String str, Context context, UFIPopoverLauncher uFIPopoverLauncher) {
        this(str, null, context, uFIPopoverLauncher);
    }

    public BaseCommentNavigationDelegate(String str, PopoverFragmentContainer popoverFragmentContainer, UFIPopoverLauncher uFIPopoverLauncher) {
        this(str, popoverFragmentContainer, null, uFIPopoverLauncher);
    }

    public final void m4709a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
        UFIContentFragment editCommentFragment = new EditCommentFragment();
        UFIParamsBuilder uFIParamsBuilder = new UFIParamsBuilder();
        uFIParamsBuilder.a.putString("moduleName", this.f4095a.toString());
        uFIParamsBuilder = uFIParamsBuilder;
        FlatBufferModelHelper.a(uFIParamsBuilder.a, "feedback", graphQLFeedback);
        uFIParamsBuilder = uFIParamsBuilder;
        FlatBufferModelHelper.a(uFIParamsBuilder.a, "comment", graphQLComment);
        uFIParamsBuilder = uFIParamsBuilder;
        uFIParamsBuilder.a.putBoolean("standalone", m4705a());
        editCommentFragment.g(uFIParamsBuilder.a);
        m4704a(editCommentFragment);
    }

    public final void m4707a(GraphQLComment graphQLComment) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(graphQLComment.y()), "Cannot show edit history for comment without an ID");
        String y = graphQLComment.y();
        String str = this.f4095a.toString();
        boolean a = m4705a();
        CommentEditHistoryFragment commentEditHistoryFragment = new CommentEditHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("node_id", y);
        bundle.putString("module", str);
        bundle.putBoolean("standalone", a);
        commentEditHistoryFragment.g(bundle);
        m4704a((UFIContentFragment) commentEditHistoryFragment);
    }

    private boolean m4705a() {
        return this.f4096b == null;
    }

    private void m4704a(UFIContentFragment uFIContentFragment) {
        if (this.f4096b != null) {
            this.f4096b.a(uFIContentFragment);
        } else {
            this.f4098d.a(uFIContentFragment, this.f4097c);
        }
    }
}
