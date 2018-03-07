package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupAddMemberInputData;
import com.facebook.graphql.calls.GroupAddMemberInputData.Source;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutation.GroupAddMembersMutationString;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: estimated_count */
public class MultipleMemberAdder {
    private GraphQLQueryExecutor f14718a;

    public static MultipleMemberAdder m16847b(InjectorLike injectorLike) {
        return new MultipleMemberAdder(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public MultipleMemberAdder(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f14718a = graphQLQueryExecutor;
    }

    public final ListenableFuture<GraphQLResult<GroupAddMembersMutationModel>> m16848a(String str, ImmutableList<String> immutableList, @Nullable Source source) {
        GroupAddMemberInputData groupAddMemberInputData = new GroupAddMemberInputData();
        groupAddMemberInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupAddMemberInputData;
        graphQlCallInput.a("user_ids", immutableList);
        graphQlCallInput = graphQlCallInput;
        if (source != null) {
            graphQlCallInput.a("source", source);
        }
        GraphQlQueryString groupAddMembersMutationString = new GroupAddMembersMutationString();
        groupAddMembersMutationString.a("input", graphQlCallInput);
        return this.f14718a.a(GraphQLRequest.a(groupAddMembersMutationString));
    }

    public static MultipleMemberAdder m16846a(InjectorLike injectorLike) {
        return m16847b(injectorLike);
    }
}
