package com.facebook.messaging.bots.service;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQuery;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQuery.FetchBotCommandsQueryString;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel;
import com.facebook.messaging.bots.graphql.FetchBotCommandsQueryModels.FetchBotCommandsQueryModel.SuggestionsModel;
import com.facebook.messaging.bots.model.BotCommand;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: object_participant_profiles */
public class BotCommandsGraphQLFetcher {
    private final GraphQLQueryExecutor f8337a;

    /* compiled from: object_participant_profiles */
    class C09441 implements Function<GraphQLResult<FetchBotCommandsQueryModel>, ImmutableList<BotCommand>> {
        final /* synthetic */ BotCommandsGraphQLFetcher f8336a;

        C09441(BotCommandsGraphQLFetcher botCommandsGraphQLFetcher) {
            this.f8336a = botCommandsGraphQLFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return RegularImmutableList.a;
            }
            BotCommandsGraphQLFetcher botCommandsGraphQLFetcher = this.f8336a;
            FetchBotCommandsQueryModel fetchBotCommandsQueryModel = (FetchBotCommandsQueryModel) graphQLResult.e;
            Builder builder = ImmutableList.builder();
            ImmutableList a = fetchBotCommandsQueryModel.m8619a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(new BotCommand((SuggestionsModel) a.get(i)));
            }
            return builder.b();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    @Inject
    public BotCommandsGraphQLFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8337a = graphQLQueryExecutor;
    }

    public final ListenableFuture<ImmutableList<BotCommand>> m8631a(String str, @Nullable ThreadKey threadKey) {
        FetchBotCommandsQueryString a = FetchBotCommandsQuery.m8580a();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("text", str);
        if (!(threadKey == null || threadKey.d())) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            if (threadKey.b()) {
                objectNode2.a("thread_fbid", threadKey.b);
            } else {
                objectNode2.a("other_user_id", threadKey.d);
            }
            objectNode.c("thread", objectNode2);
        }
        a.a("query", objectNode.toString());
        GraphQLRequest a2 = GraphQLRequest.a(FetchBotCommandsQuery.m8580a()).a(a.a);
        a2.a(1800);
        return Futures.a(this.f8337a.a(a2), new C09441(this));
    }
}
