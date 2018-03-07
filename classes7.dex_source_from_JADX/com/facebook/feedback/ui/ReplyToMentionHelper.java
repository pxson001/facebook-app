package com.facebook.feedback.ui;

import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.tagging.model.TaggingProfile.Builder;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;

/* compiled from: rotated_text_count */
public class ReplyToMentionHelper {
    public static void m5190a(GraphQLComment graphQLComment, CommentsHelper commentsHelper) {
        if (commentsHelper != null) {
            GraphQLActor r = graphQLComment.r();
            String aa = r.aa();
            Builder builder = new Builder();
            builder.a = new Name(aa);
            Builder builder2 = builder;
            builder2.e = Type.USER;
            builder2 = builder2;
            builder2.b = Long.parseLong(r.H());
            commentsHelper.f4377u.mo240a(builder2.j());
            commentsHelper.m4971f();
        }
    }
}
