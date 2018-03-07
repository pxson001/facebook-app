package com.facebook.facecastdisplay.protocol;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel.NodeModel;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsConnection.Builder;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.google.common.collect.ImmutableList;

/* compiled from: sticker_edit_flow */
public final class LiveBlingbarFeedbackConverter {
    public static GraphQLTopReactionsConnection m4041a(TopReactionsModel topReactionsModel) {
        if (topReactionsModel == null) {
            return null;
        }
        Builder builder = new Builder();
        if (topReactionsModel.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < topReactionsModel.a().size(); i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge;
                EdgesModel edgesModel = (EdgesModel) topReactionsModel.a().get(i);
                if (edgesModel == null) {
                    graphQLTopReactionsEdge = null;
                } else {
                    GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo;
                    GraphQLTopReactionsEdge.Builder builder3 = new GraphQLTopReactionsEdge.Builder();
                    NodeModel a = edgesModel.a();
                    if (a == null) {
                        graphQLFeedbackReactionInfo = null;
                    } else {
                        GraphQLFeedbackReactionInfo.Builder builder4 = new GraphQLFeedbackReactionInfo.Builder();
                        builder4.g = a.a();
                        graphQLFeedbackReactionInfo = builder4.a();
                    }
                    builder3.d = graphQLFeedbackReactionInfo;
                    builder3.e = edgesModel.b();
                    graphQLTopReactionsEdge = builder3.a();
                }
                builder2.c(graphQLTopReactionsEdge);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }
}
