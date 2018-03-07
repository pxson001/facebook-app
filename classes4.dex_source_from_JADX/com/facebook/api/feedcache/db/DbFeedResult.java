package com.facebook.api.feedcache.db;

import com.facebook.graphql.model.GraphQLFeedHomeStories;
import javax.annotation.Nullable;

/* compiled from: user_tile */
public class DbFeedResult {
    public static DbFeedResult f405a = new DbFeedResult(null, -1);
    public final GraphQLFeedHomeStories f406b;
    public final long f407c;

    public DbFeedResult(@Nullable GraphQLFeedHomeStories graphQLFeedHomeStories, long j) {
        this.f406b = graphQLFeedHomeStories;
        this.f407c = j;
    }

    public final boolean m685a() {
        return this.f406b != null && this.f407c < System.currentTimeMillis();
    }

    public final GraphQLFeedHomeStories m686b() {
        return this.f406b;
    }

    public final long m687c() {
        return this.f407c;
    }
}
