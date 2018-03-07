package com.facebook.groups.feed.controller;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.FeedUnitCache.FeedUnitCacheSubscriber;
import com.facebook.api.feedcache.memory.FeedUnitCache.MutationType;
import com.facebook.controller.connectioncontroller.common.AbstractConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionChunk;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: failed to obtain source image */
public class BridgeConnectionController implements FeedUnitCacheSubscriber, ConnectionController<GraphQLFeedUnitEdge, Boolean> {
    public final GroupsFeedPager f13864a;
    public final FeedUnitCache f13865b;
    private ConnectionListener<GraphQLFeedUnitEdge> f13866c;

    public static BridgeConnectionController m15502a(InjectorLike injectorLike) {
        return new BridgeConnectionController(GroupsFeedPager.m15565b(injectorLike), FeedUnitCache.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m15507a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, Object obj) {
    }

    public final /* bridge */ /* synthetic */ void m15511b(int i, Object obj) {
    }

    @Inject
    public BridgeConnectionController(GroupsFeedPager groupsFeedPager, FeedUnitCache feedUnitCache) {
        this.f13864a = groupsFeedPager;
        this.f13865b = feedUnitCache;
    }

    public final FeedUnitCollection m15516g() {
        return this.f13864a.f13923c;
    }

    public final void m15503a() {
    }

    public final void m15510b() {
        this.f13864a.m15573g();
    }

    public final void m15513c() {
    }

    public final void m15506a(ConnectionListener<GraphQLFeedUnitEdge> connectionListener) {
        if (this.f13866c != null) {
            throw new RuntimeException("Only allow one listener in Bridge Connection Controller");
        }
        this.f13866c = connectionListener;
    }

    public final void m15512b(ConnectionListener<GraphQLFeedUnitEdge> connectionListener) {
        if (this.f13866c != connectionListener) {
            throw new RuntimeException("Unrecognized listener!");
        }
        this.f13866c = null;
    }

    public final ConnectionState<GraphQLFeedUnitEdge> m15514d() {
        boolean z = false;
        final FeedUnitCollection feedUnitCollection = this.f13864a.f13923c;
        ConnectionLocation connectionLocation = new ConnectionLocation(feedUnitCollection.j(), LocationType.BEFORE, false);
        String r = feedUnitCollection.r();
        LocationType locationType = LocationType.AFTER;
        if (!this.f13864a.f13938r) {
            z = true;
        }
        final ConnectionChunk connectionChunk = new ConnectionChunk(connectionLocation, new ConnectionLocation(r, locationType, z));
        return new AbstractConnectionState<GraphQLFeedUnitEdge>(this) {
            final /* synthetic */ BridgeConnectionController f13863c;

            public final int m15500d() {
                return feedUnitCollection.a();
            }

            public final Object m15499a(int i) {
                return feedUnitCollection.b(i);
            }

            public final ImmutableList<ConnectionChunk> m15501e() {
                return ImmutableList.of(connectionChunk);
            }
        };
    }

    public final void m15509a(String str, Predicate<GraphQLFeedUnitEdge> predicate) {
        throw new RuntimeException("Not supported!");
    }

    public final void m15508a(FeedUnit feedUnit) {
        FeedUnitCollection feedUnitCollection = this.f13864a.f13923c;
        if (feedUnitCollection.a() > 0 && !feedUnitCollection.a(feedUnit.g()).isEmpty()) {
            feedUnitCollection.a(feedUnit.g()).get(0);
            feedUnitCollection.a.a(feedUnit);
            if (!feedUnitCollection.a(feedUnit.g()).isEmpty()) {
                feedUnitCollection.a(feedUnit.g()).get(0);
                if (this.f13866c != null) {
                    this.f13866c.a(feedUnitCollection.a((GraphQLFeedUnitEdge) feedUnitCollection.a(feedUnit.g()).get(0)), 1);
                }
            }
        }
    }

    public final void m15505a(MutationType mutationType, Throwable th) {
    }

    public final MutationControllerManager m15515e() {
        return null;
    }
}
