package com.facebook.reviews.util.helper;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel.ReviewStoryModel;
import com.google.common.collect.ImmutableList;

/* compiled from: profile_video_cta_video_id */
public class PageSaveStateMutator {
    public static EdgesModel m4908a(EdgesModel edgesModel, GraphQLStory graphQLStory) {
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).z() == null || graphQLStory.as() == null || graphQLStory.as().m() == null) {
            return edgesModel;
        }
        GraphQLNode a = Builder.a(StoryAttachmentHelper.o(graphQLStory).z()).a(graphQLStory.as().m()).a();
        GraphQLStoryAttachment.Builder a2 = GraphQLStoryAttachment.Builder.a(StoryAttachmentHelper.o(graphQLStory));
        a2.t = a;
        GraphQLStoryAttachment a3 = a2.a();
        GraphQLStory.Builder a4 = GraphQLStory.Builder.a(graphQLStory);
        a4.m = ImmutableList.of(a3);
        GraphQLStory a5 = a4.a();
        EdgesModel.Builder builder = new EdgesModel.Builder();
        builder = EdgesModel.Builder.a(EdgesModel.a(edgesModel));
        ReviewStoryModel.Builder builder2 = new ReviewStoryModel.Builder();
        builder2.a = a5;
        builder.a = builder2.a();
        return builder.a();
    }
}
