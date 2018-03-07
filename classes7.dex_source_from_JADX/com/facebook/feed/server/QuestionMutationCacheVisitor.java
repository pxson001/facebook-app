package com.facebook.feed.server;

import com.facebook.controller.mutation.util.AttachmentListMutator;
import com.facebook.controller.mutation.util.AttachmentMutator;
import com.facebook.feed.protocol.QuestionAddPollOptionModels.QuestionAddResponseMutationModel;
import com.facebook.feed.protocol.QuestionPollUpdateVoteModels.QuestionMutationFragmentModel.OptionsModel.EdgesModel;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.Assisted;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UFI_FLYOUT */
public class QuestionMutationCacheVisitor implements CacheVisitor {
    private final RecursiveModelTransformer<GraphQLStory> f21649a;
    private final QuestionAddResponseMutationModel f21650b;
    private final AttachmentMutator f21651c;
    private final AttachmentListMutator f21652d;

    @Inject
    public QuestionMutationCacheVisitor(@Assisted final QuestionAddResponseMutationModel questionAddResponseMutationModel, AttachmentMutator attachmentMutator, AttachmentListMutator attachmentListMutator) {
        this.f21650b = questionAddResponseMutationModel;
        this.f21651c = attachmentMutator;
        this.f21652d = attachmentListMutator;
        this.f21649a = new RecursiveModelTransformer(GraphQLStory.class, new TypedModelVisitor<GraphQLStory>(this) {
            final /* synthetic */ QuestionMutationCacheVisitor f21648b;

            @Nullable
            public final Object m24234a(@Nullable Object obj) {
                GraphQLStory graphQLStory = (GraphQLStory) obj;
                if (graphQLStory == null || questionAddResponseMutationModel == null || questionAddResponseMutationModel.a() == null || questionAddResponseMutationModel.a().k() == null || questionAddResponseMutationModel.a().k().a() == null || questionAddResponseMutationModel.a().k().a().isEmpty()) {
                    return graphQLStory;
                }
                EdgesModel edgesModel = (EdgesModel) questionAddResponseMutationModel.a().k().a().get(0);
                GraphQLStoryAttachment a = AttachmentMutator.a(StoryAttachmentHelper.o(graphQLStory), edgesModel.a().k().a(), edgesModel.a().j());
                Builder a2 = Builder.a(graphQLStory);
                a2.m = AttachmentListMutator.a(graphQLStory.M(), a);
                return a2.a();
            }
        });
    }

    public final <T> T m24235a(T t) {
        return this.f21649a.a(t);
    }

    public final Set<String> m24236a() {
        return Sets.a(new String[]{this.f21650b.a().j()});
    }
}
