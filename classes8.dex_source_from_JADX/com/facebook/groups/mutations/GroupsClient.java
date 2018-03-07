package com.facebook.groups.mutations;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupLeaveInputData;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupRecordNotificationNuxDisplayInputData;
import com.facebook.graphql.calls.GroupRequestToJoinInputData;
import com.facebook.graphql.calls.GroupSubscribeInputData;
import com.facebook.graphql.calls.GroupSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.GroupUnpinStoryInputData;
import com.facebook.graphql.calls.GroupUnpinStoryInputData.Source;
import com.facebook.graphql.calls.GroupUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutation.GroupSubscribeMutationString;
import com.facebook.groups.feed.protocol.GroupSubscriptionStatusMutation.GroupUnsubscribeMutationString;
import com.facebook.groups.mutations.protocol.GroupMutations.GroupLeaveCoreMutationString;
import com.facebook.groups.mutations.protocol.GroupMutations.GroupRecordNotificationNuxDisplayCoreMutationString;
import com.facebook.groups.mutations.protocol.GroupMutations.GroupRequestToJoinCoreMutationString;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupLeaveCoreMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupRequestToJoinCoreMutationModel.GroupModel;
import com.facebook.groups.mutations.protocol.GroupPostMutations.GroupUnpinStoryMutationString;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.LocalGroupModerationFieldsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import javax.inject.Inject;

/* compiled from: entity_ranges */
public class GroupsClient {
    public final GraphQLQueryExecutor f14753a;
    public final ControllerMutationGatekeepers f14754b;

    public static GroupsClient m16961b(InjectorLike injectorLike) {
        return new GroupsClient(GraphQLQueryExecutor.a(injectorLike), ControllerMutationGatekeepers.b(injectorLike));
    }

    public static GroupsClient m16960a(InjectorLike injectorLike) {
        return m16961b(injectorLike);
    }

    @Inject
    public GroupsClient(GraphQLQueryExecutor graphQLQueryExecutor, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f14753a = graphQLQueryExecutor;
        this.f14754b = controllerMutationGatekeepers;
    }

    public final ListenableFuture<Void> m16965a(String str, SubscribeLocation subscribeLocation) {
        GroupSubscribeInputData groupSubscribeInputData = new GroupSubscribeInputData();
        groupSubscribeInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupSubscribeInputData;
        graphQlCallInput.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("subscribe_location", subscribeLocation);
        return Futures.a(this.f14753a.a(GraphQLRequest.a((GroupSubscribeMutationString) new GroupSubscribeMutationString().a("input", graphQlCallInput))), Functions.constant(null));
    }

    public final ListenableFuture<Void> m16966a(String str, GroupUnsubscribeInputData.SubscribeLocation subscribeLocation) {
        GroupUnsubscribeInputData groupUnsubscribeInputData = new GroupUnsubscribeInputData();
        groupUnsubscribeInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupUnsubscribeInputData;
        graphQlCallInput.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("subscribe_location", subscribeLocation);
        return Futures.a(this.f14753a.a(GraphQLRequest.a((GroupUnsubscribeMutationString) new GroupUnsubscribeMutationString().a("input", graphQlCallInput))), Functions.constant(null));
    }

    public final ListenableFuture<Void> m16967a(String str, FetchGroupInformationModel fetchGroupInformationModel) {
        GroupRecordNotificationNuxDisplayInputData groupRecordNotificationNuxDisplayInputData = new GroupRecordNotificationNuxDisplayInputData();
        groupRecordNotificationNuxDisplayInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupRecordNotificationNuxDisplayInputData;
        GraphQlQueryString groupRecordNotificationNuxDisplayCoreMutationString = new GroupRecordNotificationNuxDisplayCoreMutationString();
        groupRecordNotificationNuxDisplayCoreMutationString.a("input", graphQlCallInput);
        return Futures.a(this.f14753a.a(GraphQLRequest.a(groupRecordNotificationNuxDisplayCoreMutationString).a(fetchGroupInformationModel)), Functions.constant(null));
    }

    public final ListenableFuture<Void> m16962a(GraphQLStory graphQLStory, Source source) {
        GroupUnpinStoryInputData groupUnpinStoryInputData = new GroupUnpinStoryInputData();
        groupUnpinStoryInputData.a("group_id", graphQLStory.aJ().b());
        GraphQlCallInput graphQlCallInput = groupUnpinStoryInputData;
        graphQlCallInput.a("story_id", graphQLStory.c());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("source", source);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupUnpinStoryMutationString = new GroupUnpinStoryMutationString();
        groupUnpinStoryMutationString.a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.a(groupUnpinStoryMutationString);
        if (this.f14754b.a()) {
            Builder builder = new Builder();
            builder.f14781a = graphQLStory.c();
            builder = builder;
            builder.f14784d = false;
            builder = builder;
            builder.f14785e = true;
            a.a(builder.m17110a());
            a.d = true;
        }
        return Futures.a(this.f14753a.a(a), Functions.constant(null));
    }

    public final ListenableFuture<Void> m16964a(String str, GroupRequestToJoinInputData.Source source) {
        GroupRequestToJoinInputData groupRequestToJoinInputData = new GroupRequestToJoinInputData();
        groupRequestToJoinInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupRequestToJoinInputData;
        graphQlCallInput.a("source", source);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupRequestToJoinCoreMutationString = new GroupRequestToJoinCoreMutationString();
        groupRequestToJoinCoreMutationString.a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.a(groupRequestToJoinCoreMutationString);
        GroupModel.Builder builder = new GroupModel.Builder();
        builder.f14770a = str;
        builder = builder;
        builder.f14771b = GraphQLGroupJoinState.REQUESTED;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f14770a);
        int a2 = flatBufferBuilder.a(builder.f14771b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        a.a(new GroupModel(new MutableFlatBuffer(wrap, null, null, true, null)));
        return Futures.a(this.f14753a.a(a), Functions.constant(null));
    }

    public final ListenableFuture<Void> m16963a(String str, GroupLeaveInputData.Source source, ReaddPolicy readdPolicy) {
        GroupLeaveInputData groupLeaveInputData = new GroupLeaveInputData();
        groupLeaveInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = groupLeaveInputData;
        graphQlCallInput.a("readd_policy", readdPolicy);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("source", source);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupLeaveCoreMutationString = new GroupLeaveCoreMutationString();
        groupLeaveCoreMutationString.a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.a(groupLeaveCoreMutationString);
        GroupLeaveCoreMutationModel.GroupModel.Builder builder = new GroupLeaveCoreMutationModel.GroupModel.Builder();
        builder.f14762a = str;
        builder = builder;
        builder.f14763b = GraphQLGroupJoinState.CAN_REQUEST;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f14762a);
        int a2 = flatBufferBuilder.a(builder.f14763b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        a.a(new GroupLeaveCoreMutationModel.GroupModel(new MutableFlatBuffer(wrap, null, null, true, null)));
        return Futures.a(this.f14753a.a(a), Functions.constant(null));
    }
}
