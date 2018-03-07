package com.facebook.api.feedcache.memory;

import com.facebook.api.feedcache.memory.visitor.AddCommentCacheVisitor;
import com.facebook.api.feedcache.memory.visitor.AddCommentCacheVisitorProvider;
import com.facebook.api.graphql.commentservice.CommentsServiceModels$CommentCreateShimMutationFragmentModel;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CustomMutationVisitorFactory;
import javax.inject.Inject;

/* compiled from: feed_mark_survey_completed */
public class CommentCreateCacheVisitorFactory implements CustomMutationVisitorFactory<CommentsServiceModels$CommentCreateShimMutationFragmentModel> {
    private final AddCommentCacheVisitorProvider f11876a;

    public final CacheVisitor mo882a(Object obj) {
        CommentsServiceModels$CommentCreateShimMutationFragmentModel commentsServiceModels$CommentCreateShimMutationFragmentModel = (CommentsServiceModels$CommentCreateShimMutationFragmentModel) obj;
        String k = commentsServiceModels$CommentCreateShimMutationFragmentModel.m12476j().k();
        return new AddCommentCacheVisitor(FeedbackMutator.a(this.f11876a), commentsServiceModels$CommentCreateShimMutationFragmentModel.m12474a(), k);
    }

    @Inject
    public CommentCreateCacheVisitorFactory(AddCommentCacheVisitorProvider addCommentCacheVisitorProvider) {
        this.f11876a = addCommentCacheVisitorProvider;
    }

    public final Class mo883a() {
        return CommentsServiceModels$CommentCreateShimMutationFragmentModel.class;
    }
}
