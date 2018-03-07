package com.facebook.feed.permalink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.api.ufiservices.FetchSingleCommentParams;
import com.facebook.api.ufiservices.FetchSingleCommentParams.Builder;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.google.common.base.Preconditions;

/* compiled from: album_creator_dialog_shown */
public class CommentPermalinkFragmentFactory implements IFragmentFactory {
    public final Fragment m22862a(Intent intent) {
        String stringExtra = intent.getStringExtra("comment_id");
        String stringExtra2 = intent.getStringExtra("feedback_id");
        String stringExtra3 = intent.getStringExtra("story_id");
        String stringExtra4 = intent.getStringExtra("story_cache_id");
        String stringExtra5 = intent.getStringExtra("group_id");
        String stringExtra6 = intent.getStringExtra("relevant_comment_id");
        GraphQLComment graphQLComment = (GraphQLComment) FlatBufferModelHelper.a(intent, "comment");
        boolean booleanExtra = intent.getBooleanExtra("include_comments_disabled_fields", false);
        GraphQLComment graphQLComment2 = (GraphQLComment) FlatBufferModelHelper.a(intent, "relevant_comment");
        FeedbackLoggingParams feedbackLoggingParams = (FeedbackLoggingParams) intent.getParcelableExtra("feedback_logging_params");
        Builder builder = new Builder();
        builder.h = graphQLComment;
        Builder builder2 = builder;
        builder2.i = graphQLComment2;
        builder2 = builder2;
        builder2.a = stringExtra;
        builder2 = builder2;
        builder2.b = stringExtra2;
        builder2 = builder2;
        builder2.d = stringExtra3;
        builder2 = builder2;
        builder2.e = stringExtra4;
        builder2 = builder2;
        builder2.g = stringExtra6;
        builder2 = builder2;
        builder2.j = stringExtra5;
        builder2 = builder2;
        builder2.k = booleanExtra;
        FetchSingleCommentParams a = builder2.a();
        Preconditions.checkNotNull(a, "Comment params are required");
        ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment = new ThreadedCommentsPermalinkFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("commentParams", a);
        bundle.putParcelable("feedbackLoggingParams", feedbackLoggingParams);
        threadedCommentsPermalinkFragment.g(bundle);
        return threadedCommentsPermalinkFragment;
    }
}
