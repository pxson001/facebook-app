package com.facebook.api.feedcache.resync;

import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.DBFeedRerankHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbDeleteStoriesRequest;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.ufiservices.FeedbackBackgroundSyncPolicy;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.ui.imageloader.AsyncFeedImagePrefetchHelper;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: menu_copy_to_clipboard_press */
public class NewsFeedCacheSynchonizerHelper {
    public final AsyncFeedXConfigReader f5440a;
    public final NewsFeedXConfigReader f5441b;
    public final DbFeedHomeStoriesHandler f5442c;
    public final AsyncFeedImagePrefetchHelper f5443d;
    public final DBFeedRerankHandler f5444e;
    public final GraphQLDiskCache f5445f;
    public final FeedbackBackgroundSyncPolicy f5446g;
    private final FeedDbMutationService f5447h;

    public static NewsFeedCacheSynchonizerHelper m6663b(InjectorLike injectorLike) {
        return new NewsFeedCacheSynchonizerHelper(NewsFeedXConfigReader.a(injectorLike), DbFeedHomeStoriesHandler.a(injectorLike), AsyncFeedImagePrefetchHelper.b(injectorLike), DBFeedRerankHandler.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike), (GraphQLDiskCache) GraphQLDiskCacheImpl.a(injectorLike), FeedbackBackgroundSyncPolicy.b(injectorLike), FeedDbMutationService.a(injectorLike));
    }

    @Inject
    public NewsFeedCacheSynchonizerHelper(NewsFeedXConfigReader newsFeedXConfigReader, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, AsyncFeedImagePrefetchHelper asyncFeedImagePrefetchHelper, DBFeedRerankHandler dBFeedRerankHandler, AsyncFeedXConfigReader asyncFeedXConfigReader, GraphQLDiskCache graphQLDiskCache, FeedbackBackgroundSyncPolicy feedbackBackgroundSyncPolicy, FeedDbMutationService feedDbMutationService) {
        this.f5441b = newsFeedXConfigReader;
        this.f5442c = dbFeedHomeStoriesHandler;
        this.f5443d = asyncFeedImagePrefetchHelper;
        this.f5444e = dBFeedRerankHandler;
        this.f5440a = asyncFeedXConfigReader;
        this.f5445f = graphQLDiskCache;
        this.f5446g = feedbackBackgroundSyncPolicy;
        this.f5447h = feedDbMutationService;
    }

    public final void m6665a(Map<String, GraphQLFeedUnitEdge> map) {
        Builder builder = ImmutableList.builder();
        for (GraphQLFeedUnitEdge a : map.values()) {
            builder.c(DedupableUtil.a(a));
        }
        this.f5447h.a(new FeedDbDeleteStoriesRequest(builder.b()));
    }

    public final Map<String, GraphQLFeedUnitEdge> m6664a() {
        Map<String, GraphQLFeedUnitEdge> hashMap = new HashMap();
        ImmutableList a = this.f5442c.a(FeedType.b, TimeUnit.HOURS.toMillis((long) this.f5441b.i()));
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) a.get(i);
                if ("User".equals(clientFeedUnitEdge.z) && (clientFeedUnitEdge.c() instanceof GraphQLStory)) {
                    hashMap.put(((GraphQLStory) clientFeedUnitEdge.c()).c(), clientFeedUnitEdge);
                }
            }
        }
        return hashMap;
    }
}
