package com.facebook.video.channelfeed;

import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.calls.CallerInputCaller;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQuery.FetchVideoChannelByIdQueryString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQuery.FetchVideoChannelByVideoQueryString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQuery.FetchVideosByVideoChannelQueryString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQE.FetchVideoChannelByIdQueryQEString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQE.FetchVideoChannelByVideoQueryQEString;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQE.FetchVideosByVideoChannelQueryQEString;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: submitted_screen */
public class VideoChannelLoader {
    private final FetchFeedQueryUtil f2661a;
    private final GraphQLQueryExecutor f2662b;
    private final VideoDashConfig f2663c;
    private final ChannelFeedConfig f2664d;

    public static VideoChannelLoader m2572a(InjectorLike injectorLike) {
        return new VideoChannelLoader(FetchFeedQueryUtil.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), VideoDashConfig.a(injectorLike), ChannelFeedConfig.a(injectorLike));
    }

    @Inject
    public VideoChannelLoader(FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLQueryExecutor graphQLQueryExecutor, VideoDashConfig videoDashConfig, ChannelFeedConfig channelFeedConfig) {
        this.f2661a = fetchFeedQueryUtil;
        this.f2662b = graphQLQueryExecutor;
        this.f2663c = videoDashConfig;
        this.f2664d = channelFeedConfig;
    }

    public final GraphQLQueryFuture<GraphQLResult> m2573a(String str, int i, EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint, boolean z) {
        TypedGraphQlQueryString fetchVideoChannelByVideoQueryQEString;
        if (this.f2664d.q) {
            fetchVideoChannelByVideoQueryQEString = new FetchVideoChannelByVideoQueryQEString();
        } else {
            fetchVideoChannelByVideoQueryQEString = new FetchVideoChannelByVideoQueryString();
        }
        m2571a(fetchVideoChannelByVideoQueryQEString).a("video_id", str).a("video_channel_entry_point", entryPointInputVideoChannelEntryPoint).a("num_stories", Integer.valueOf(i)).a("exclude_video_id", str);
        return m2570a(fetchVideoChannelByVideoQueryQEString, z);
    }

    public final GraphQLQueryFuture<GraphQLResult> m2574a(String str, @Nullable String str2, int i, EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint, boolean z) {
        TypedGraphQlQueryString fetchVideoChannelByIdQueryQEString;
        Preconditions.checkNotNull(str, "videoChannelId cannot be null");
        if (this.f2664d.q) {
            fetchVideoChannelByIdQueryQEString = new FetchVideoChannelByIdQueryQEString();
        } else {
            fetchVideoChannelByIdQueryQEString = new FetchVideoChannelByIdQueryString();
        }
        m2571a(fetchVideoChannelByIdQueryQEString).a("video_channel_id", str).a("video_channel_entry_point", entryPointInputVideoChannelEntryPoint).a("num_stories", Integer.valueOf(i));
        if (str2 != null) {
            fetchVideoChannelByIdQueryQEString.a("exclude_video_id", str2);
        }
        return m2570a(fetchVideoChannelByIdQueryQEString, z);
    }

    public final GraphQLQueryFuture<GraphQLResult> m2575a(String str, String str2, @Nullable String str3, int i, boolean z) {
        TypedGraphQlQueryString fetchVideosByVideoChannelQueryQEString;
        Preconditions.checkNotNull(str, "videoChannelId cannot be null");
        if (this.f2664d.q) {
            fetchVideosByVideoChannelQueryQEString = new FetchVideosByVideoChannelQueryQEString();
        } else {
            fetchVideosByVideoChannelQueryQEString = new FetchVideosByVideoChannelQueryString();
        }
        m2571a(fetchVideosByVideoChannelQueryQEString).a("video_channel_id", str).a("num_stories", Integer.valueOf(i)).a("exclude_video_id", str2);
        if (str3 != null) {
            fetchVideosByVideoChannelQueryQEString.a("after", str3);
        }
        return m2570a(fetchVideosByVideoChannelQueryQEString, z);
    }

    private GraphQLQueryFuture m2570a(TypedGraphQlQueryString typedGraphQlQueryString, boolean z) {
        GraphQLRequest a = GraphQLRequest.a(typedGraphQlQueryString).a(z ? GraphQLCachePolicy.c : GraphQLCachePolicy.a);
        a.b = true;
        a = a;
        if (!z) {
            a.a(1800);
        }
        return this.f2662b.a(a);
    }

    private TypedGraphQlQueryString m2571a(TypedGraphQlQueryString typedGraphQlQueryString) {
        this.f2661a.a(typedGraphQlQueryString);
        this.f2661a.b(typedGraphQlQueryString);
        typedGraphQlQueryString.a("caller", CallerInputCaller.CHANNEL_VIEW_FROM_NEWSFEED);
        if (this.f2663c.a()) {
            typedGraphQlQueryString.a("scrubbing", "MPEG_DASH");
        }
        if (this.f2664d.q) {
            typedGraphQlQueryString.a("scale", GraphQlQueryDefaults.a());
        }
        return typedGraphQlQueryString;
    }
}
