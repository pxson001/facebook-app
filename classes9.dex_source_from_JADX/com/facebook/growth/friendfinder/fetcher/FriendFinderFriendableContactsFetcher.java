package com.facebook.growth.friendfinder.fetcher;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.NodesModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.PageInfoModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.PageInfoModel.Builder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: parent_group_id */
public class FriendFinderFriendableContactsFetcher {
    @VisibleForTesting
    public PageInfoModel f7290a;
    public final GraphQLImageHelper f7291b;
    public final GraphQLQueryExecutor f7292c;
    public final ListeningExecutorService f7293d;
    public final UniqueIdForDeviceHolderImpl f7294e;

    /* compiled from: parent_group_id */
    public class C07901 implements Function<GraphQLResult<FetchFriendableContactsQueryModel>, ImmutableList<NodesModel>> {
        final /* synthetic */ FriendFinderFriendableContactsFetcher f7289a;

        public C07901(FriendFinderFriendableContactsFetcher friendFinderFriendableContactsFetcher) {
            this.f7289a = friendFinderFriendableContactsFetcher;
        }

        public Object apply(@Nullable Object obj) {
            NodeModel nodeModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchFriendableContactsQueryModel) graphQLResult.e).m7615a() == null || ((FetchFriendableContactsQueryModel) graphQLResult.e).m7615a().m7610a().isEmpty()) {
                nodeModel = null;
            } else {
                nodeModel = ((EdgesModel) ((FetchFriendableContactsQueryModel) graphQLResult.e).m7615a().m7610a().get(0)).m7606a();
            }
            NodeModel nodeModel2 = nodeModel;
            if (nodeModel2 == null || nodeModel2.m7602a() == null || nodeModel2.m7602a().m7597a().isEmpty()) {
                return RegularImmutableList.a;
            }
            PageInfoModel j = nodeModel2.m7602a().m7598j();
            if (j != null) {
                this.f7289a.f7290a = j;
            }
            return nodeModel2.m7602a().m7597a();
        }
    }

    @Inject
    public FriendFinderFriendableContactsFetcher(GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f7291b = graphQLImageHelper;
        this.f7292c = graphQLQueryExecutor;
        this.f7293d = listeningExecutorService;
        this.f7294e = uniqueIdForDeviceHolderImpl;
        Builder builder = new Builder();
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f7306a);
        int b2 = flatBufferBuilder.b(builder.f7308c);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder.f7307b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        this.f7290a = new PageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
