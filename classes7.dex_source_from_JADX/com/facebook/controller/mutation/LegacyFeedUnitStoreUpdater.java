package com.facebook.controller.mutation;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: tap_photo_tray */
public class LegacyFeedUnitStoreUpdater implements LegacyFeedUnitUpdater {
    public ConnectionStore f2268a;

    public final void m2220a(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLPersistableNode) {
            this.f2268a.a((GraphQLPersistableNode) feedUnit);
            return;
        }
        throw new RuntimeException("Replacing non-GraphQLPersistableNode is not supported:" + feedUnit.getClass().getSimpleName());
    }

    public final void m2221a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        throw new UnsupportedOperationException("FeedEdge removal not supported yet");
    }

    public final void m2219a() {
        throw new UnsupportedOperationException("Story clear not supported yet");
    }

    public final void m2222a(String str) {
        throw new UnsupportedOperationException("Story posting not supported yet");
    }

    public final GraphQLStory m2223b(String str) {
        throw new UnsupportedOperationException("Story posting not supported yet");
    }

    public final GraphQLStory m2224c(String str) {
        throw new UnsupportedOperationException("Story posting not supported yet");
    }

    public final List<FeedEdge> m2225d(String str) {
        return Lists.a(this.f2268a.a(str));
    }

    public final GraphQLFeedUnitEdge m2226e(String str) {
        throw new UnsupportedOperationException("Story posting not supported yet");
    }
}
