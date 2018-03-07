package com.facebook.graphql.executor;

import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import java.util.concurrent.locks.ReadWriteLock;
import javax.annotation.Nullable;

/* compiled from: feed_story */
public class MutationRunnerParams {
    private final PendingGraphQlMutationRequest f11845a;
    public final MutationRequest f11846b;
    public final OfflineQueryBehavior f11847c;
    private final GraphQLWriteLock f11848d;
    private final GraphQLQueryAnalyticsEvent f11849e;
    private final ReadWriteLock f11850f;
    public final int f11851g;
    private final LegacyMutation f11852h;

    public MutationRunnerParams(PendingGraphQlMutationRequest pendingGraphQlMutationRequest, MutationRequest mutationRequest, OfflineQueryBehavior offlineQueryBehavior, GraphQLWriteLock graphQLWriteLock, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, ReadWriteLock readWriteLock, int i, LegacyMutation legacyMutation) {
        this.f11845a = pendingGraphQlMutationRequest;
        this.f11846b = mutationRequest;
        this.f11847c = offlineQueryBehavior;
        this.f11848d = graphQLWriteLock;
        this.f11849e = graphQLQueryAnalyticsEvent;
        this.f11850f = readWriteLock;
        this.f11851g = i;
        this.f11852h = legacyMutation;
    }

    @Nullable
    public final PendingGraphQlMutationRequest m12440a() {
        return this.f11845a;
    }

    @Nullable
    public final MutationRequest m12441b() {
        return this.f11846b;
    }

    public final OfflineQueryBehavior m12442c() {
        return this.f11847c;
    }

    public final GraphQLWriteLock m12443d() {
        return this.f11848d;
    }

    public final GraphQLQueryAnalyticsEvent m12444e() {
        return this.f11849e;
    }

    public final ReadWriteLock m12445f() {
        return this.f11850f;
    }

    public final int m12446g() {
        return this.f11851g;
    }

    @Nullable
    public final LegacyMutation m12447h() {
        return this.f11852h;
    }
}
