package com.facebook.growth.friendfinder.fetcher;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.InvitableContactsModel.NodesModel;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.InvitableContactsModel.PageInfoModel;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.InvitableContactsModel.PageInfoModel.Builder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: parent_activity_name */
public class InvitableContactsFetcher {
    @VisibleForTesting
    public PageInfoModel f7296a;
    public final GraphQLQueryExecutor f7297b;
    public final ListeningExecutorService f7298c;
    public final UniqueIdForDeviceHolderImpl f7299d;

    /* compiled from: parent_activity_name */
    public class C07911 implements Function<GraphQLResult<InvitableContactsQueryModel>, ImmutableList<NodesModel>> {
        final /* synthetic */ InvitableContactsFetcher f7295a;

        public C07911(InvitableContactsFetcher invitableContactsFetcher) {
            this.f7295a = invitableContactsFetcher;
        }

        public Object apply(@Nullable Object obj) {
            NodeModel nodeModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((InvitableContactsQueryModel) graphQLResult.e).m7674a() == null || ((InvitableContactsQueryModel) graphQLResult.e).m7674a().m7669a().isEmpty()) {
                nodeModel = null;
            } else {
                nodeModel = ((EdgesModel) ((InvitableContactsQueryModel) graphQLResult.e).m7674a().m7669a().get(0)).m7665a();
            }
            NodeModel nodeModel2 = nodeModel;
            if (nodeModel2 == null || nodeModel2.m7661a() == null || nodeModel2.m7661a().m7656a().isEmpty()) {
                return RegularImmutableList.a;
            }
            PageInfoModel j = nodeModel2.m7661a().m7657j();
            if (j != null) {
                this.f7295a.f7296a = j;
            }
            return nodeModel2.m7661a().m7656a();
        }
    }

    @Inject
    public InvitableContactsFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f7297b = graphQLQueryExecutor;
        this.f7298c = listeningExecutorService;
        this.f7299d = uniqueIdForDeviceHolderImpl;
        Builder builder = new Builder();
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f7321a);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder.f7322b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        this.f7296a = new PageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
