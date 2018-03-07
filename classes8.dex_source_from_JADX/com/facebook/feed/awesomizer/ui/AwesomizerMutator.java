package com.facebook.feed.awesomizer.ui;

import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FBFeedAwesomizerProfileListCardProfileFragmentModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel.NodeModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel.NodeModel.Builder;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.NodesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardProfileFragmentModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.ModelHelper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: happening_now */
public class AwesomizerMutator {
    public static ImmutableList<PageTopicsByCountModel> m13862a(ImmutableList<PageTopicsByCountModel> immutableList, NodeModel nodeModel, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        Builder a = Builder.m13579a(nodeModel);
        a.f11637f = graphQLSubscribeStatus;
        NodeModel a2 = a.m13580a();
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PageTopicsByCountModel pageTopicsByCountModel = (PageTopicsByCountModel) immutableList.get(i);
            if (m13863a(nodeModel, pageTopicsByCountModel.m13611l().m13603j())) {
                ImmutableList.Builder builder2 = ImmutableList.builder();
                ImmutableList j = pageTopicsByCountModel.m13611l().m13603j();
                int size2 = j.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    EdgesModel edgesModel = (EdgesModel) j.get(i2);
                    if (nodeModel.equals(edgesModel.m13596a())) {
                        EdgesModel.Builder a3 = EdgesModel.Builder.m13576a(edgesModel);
                        a3.f11631a = a2;
                        builder2.c(a3.m13577a());
                    } else {
                        builder2.c(edgesModel);
                    }
                }
                PageTopicsByCountModel.Builder a4 = PageTopicsByCountModel.Builder.m13569a(pageTopicsByCountModel);
                SuggestedPagesModel.Builder a5 = SuggestedPagesModel.Builder.m13573a(pageTopicsByCountModel.m13611l());
                a5.f11630b = builder2.b();
                a4.f11628c = a5.m13574a();
                builder.c(a4.m13570a());
            } else {
                builder.c(pageTopicsByCountModel);
            }
        }
        return builder.b();
    }

    public static FollowedProfilesModel m13859a(FollowedProfilesModel followedProfilesModel, FollowedProfilesModel.EdgesModel edgesModel, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        FollowedProfilesModel.EdgesModel.Builder builder = new FollowedProfilesModel.EdgesModel.Builder();
        builder.f11677a = edgesModel.m13664a();
        builder.f11678b = edgesModel.m13667j();
        FollowedProfilesModel.EdgesModel.Builder builder2 = builder;
        builder2.f11677a = m13857a(edgesModel.m13664a(), graphQLSubscribeStatus);
        FollowedProfilesModel.EdgesModel a = builder2.m13660a();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList j = followedProfilesModel.m13680j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            FollowedProfilesModel.EdgesModel edgesModel2 = (FollowedProfilesModel.EdgesModel) j.get(i);
            if (edgesModel.equals(edgesModel2)) {
                builder3.c(a);
            } else {
                builder3.c(edgesModel2);
            }
        }
        FollowedProfilesModel.Builder a2 = FollowedProfilesModel.Builder.m13657a(followedProfilesModel);
        a2.f11675b = builder3.b();
        return a2.m13658a();
    }

    private static boolean m13863a(NodeModel nodeModel, ImmutableList<EdgesModel> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (nodeModel.equals(((EdgesModel) immutableList.get(i)).m13596a())) {
                return true;
            }
        }
        return false;
    }

    private static FBFeedAwesomizerProfileListCardProfileFragmentModel m13857a(FBFeedAwesomizerProfileListCardProfileFragmentModel fBFeedAwesomizerProfileListCardProfileFragmentModel, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        FBFeedAwesomizerProfileListCardProfileFragmentModel.Builder builder = new FBFeedAwesomizerProfileListCardProfileFragmentModel.Builder();
        FBFeedAwesomizerProfileListCardProfileFragmentModel.Builder builder2 = new FBFeedAwesomizerProfileListCardProfileFragmentModel.Builder();
        builder2.f11605a = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13536j();
        builder2.f11606b = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13537k();
        builder2.f11607c = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13538l();
        builder2.f11608d = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13539m();
        builder2.f11609e = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13540n();
        builder2.f11610f = fBFeedAwesomizerProfileListCardProfileFragmentModel.m13541o();
        builder = builder2;
        builder.f11610f = graphQLSubscribeStatus;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.f11605a);
        int a2 = ModelHelper.a(flatBufferBuilder, builder.f11606b);
        int a3 = ModelHelper.a(flatBufferBuilder, builder.f11607c);
        int b = flatBufferBuilder.b(builder.f11608d);
        int b2 = flatBufferBuilder.b(builder.f11609e);
        int a4 = flatBufferBuilder.a(builder.f11610f);
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new FBFeedAwesomizerProfileListCardProfileFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static UnfollowedProfilesModel m13861a(UnfollowedProfilesModel unfollowedProfilesModel, UnfollowedProfilesModel.EdgesModel edgesModel, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        UnfollowedProfilesModel.EdgesModel.Builder builder = new UnfollowedProfilesModel.EdgesModel.Builder();
        builder.f11718a = edgesModel.m13753a();
        builder.f11719b = edgesModel.m13756j();
        UnfollowedProfilesModel.EdgesModel.Builder builder2 = builder;
        builder2.f11718a = m13857a(edgesModel.m13753a(), graphQLSubscribeStatus);
        UnfollowedProfilesModel.EdgesModel a = builder2.m13749a();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList j = unfollowedProfilesModel.m13769j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            UnfollowedProfilesModel.EdgesModel edgesModel2 = (UnfollowedProfilesModel.EdgesModel) j.get(i);
            if (edgesModel.equals(edgesModel2)) {
                builder3.c(a);
            } else {
                builder3.c(edgesModel2);
            }
        }
        UnfollowedProfilesModel.Builder a2 = UnfollowedProfilesModel.Builder.m13746a(unfollowedProfilesModel);
        a2.f11716b = builder3.b();
        return a2.m13747a();
    }

    public static FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel m13860a(FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel followedProfilesModel, FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel edgesModel, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
        FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel.Builder builder = new FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel.Builder();
        builder.f11707a = edgesModel.m13724a();
        FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel.Builder builder2 = builder;
        FeedAwesomizerSeefirstCardProfileFragmentModel.Builder builder3 = new FeedAwesomizerSeefirstCardProfileFragmentModel.Builder();
        FeedAwesomizerSeefirstCardProfileFragmentModel a = edgesModel.m13724a();
        FeedAwesomizerSeefirstCardProfileFragmentModel.Builder builder4 = new FeedAwesomizerSeefirstCardProfileFragmentModel.Builder();
        builder4.f11690a = a.m13709j();
        builder4.f11691b = a.m13710k();
        builder4.f11692c = a.m13711l();
        builder4.f11693d = a.m13712m();
        builder4.f11694e = a.m13713n();
        builder4.f11695f = a.m13714o();
        builder4.f11696g = a.m13715p();
        builder3 = builder4;
        builder3.f11695f = graphQLSecondarySubscribeStatus;
        builder2.f11707a = builder3.m13699a();
        FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel a2 = builder2.m13720a();
        ImmutableList.Builder builder5 = ImmutableList.builder();
        ImmutableList j = followedProfilesModel.m13738j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel edgesModel2 = (FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel) j.get(i);
            if (!(edgesModel.m13724a() == null || edgesModel2.m13724a() == null)) {
                if (Objects.equal(edgesModel.m13724a().m13712m(), edgesModel2.m13724a().m13712m())) {
                    builder5.c(a2);
                } else {
                    builder5.c(edgesModel2);
                }
            }
        }
        FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.Builder a3 = FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.Builder.m13717a(followedProfilesModel);
        a3.f11705b = builder5.b();
        return a3.m13718a();
    }

    public static FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel m13858a(FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel suggestedPagesModel, NodesModel nodesModel, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        NodesModel.Builder builder = new NodesModel.Builder();
        builder.f11654a = nodesModel.m13629j();
        builder.f11655b = nodesModel.m13630k();
        builder.f11656c = nodesModel.m13631l();
        builder.f11657d = nodesModel.m13632m();
        builder.f11658e = nodesModel.m13633n();
        builder.f11659f = nodesModel.m13634o();
        NodesModel.Builder builder2 = builder;
        builder2.f11659f = graphQLSubscribeStatus;
        NodesModel a = builder2.m13621a();
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList j = suggestedPagesModel.m13647j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel2 = (NodesModel) j.get(i);
            if (nodesModel.equals(nodesModel2)) {
                builder3.c(a);
            } else {
                builder3.c(nodesModel2);
            }
        }
        FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.Builder a2 = FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.Builder.m13618a(suggestedPagesModel);
        a2.f11652b = builder3.b();
        return a2.m13619a();
    }
}
