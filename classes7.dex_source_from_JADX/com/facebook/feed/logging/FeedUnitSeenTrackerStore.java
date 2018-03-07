package com.facebook.feed.logging;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: android.intent.action.PACKAGE_REMOVED */
public class FeedUnitSeenTrackerStore {
    private final Map<FeedUnit, Object> f19343a = Maps.c();

    public static FeedUnitSeenTrackerStore m22798a(InjectorLike injectorLike) {
        return new FeedUnitSeenTrackerStore();
    }
}
