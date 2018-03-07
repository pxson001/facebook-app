package com.facebook.friending.suggestion.model;

import com.facebook.friending.suggestion.abtest.ExperimentsForFriendingSuggestionAbTestModule;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLModels.FetchFriendingSuggestionQueryModel;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLModels.FetchFriendingSuggestionQueryModel.FriendSuggestionsModel;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLModels.FriendingSuggestionUserFieldsModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TH */
public class FriendingSuggestionListLoader {
    public final GraphQLQueryExecutor f24961a;
    public final String f24962b;

    /* compiled from: TH */
    public class C30041 implements Function<GraphQLResult<FetchFriendingSuggestionQueryModel>, FriendingSuggestionListLoaderResult> {
        final /* synthetic */ FriendingSuggestionListLoader f24960a;

        public C30041(FriendingSuggestionListLoader friendingSuggestionListLoader) {
            this.f24960a = friendingSuggestionListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchFriendingSuggestionQueryModel) graphQLResult.e).m26729a() == null) {
                return new FriendingSuggestionListLoaderResult(RegularImmutableList.a, FriendingSuggestionListLoader.m26718b());
            }
            FriendSuggestionsModel a = ((FetchFriendingSuggestionQueryModel) graphQLResult.e).m26729a();
            Builder builder = ImmutableList.builder();
            ImmutableList a2 = a.m26725a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                builder.c(new FriendingSuggestionItemModel((FriendingSuggestionUserFieldsModel) a2.get(i)));
            }
            return new FriendingSuggestionListLoaderResult(builder.b(), a.m26726j() == null ? FriendingSuggestionListLoader.m26718b() : a.m26726j());
        }
    }

    @Inject
    public FriendingSuggestionListLoader(GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor) {
        String str;
        this.f24961a = graphQLQueryExecutor;
        if (qeAccessor.a(ExperimentsForFriendingSuggestionAbTestModule.c, false) || qeAccessor.a(ExperimentsForFriendingSuggestionAbTestModule.d, false)) {
            str = "friend_suggestion_pymk";
        } else {
            str = "friend_suggestion_connectivity";
        }
        this.f24962b = str;
    }

    public static DefaultPageInfoFieldsModel m26718b() {
        DefaultPageInfoFieldsModel.Builder builder = new DefaultPageInfoFieldsModel.Builder();
        builder.c = false;
        builder = builder;
        builder.b = false;
        return builder.a();
    }
}
