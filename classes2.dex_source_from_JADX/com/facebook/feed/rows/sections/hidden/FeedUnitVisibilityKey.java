package com.facebook.feed.rows.sections.hidden;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.HideableUnit;

/* compiled from: is_mobile_pushable */
public class FeedUnitVisibilityKey implements ContextStateKey<String, FeedUnitVisibilityState> {
    private static final String f18981a = FeedUnitVisibilityKey.class.getName();
    private final String f18982b;

    public FeedUnitVisibilityKey(HideableUnit hideableUnit) {
        this.f18982b = f18981a + hideableUnit.mo2507g();
    }

    public final Object mo2130a() {
        return new FeedUnitVisibilityState();
    }

    public final Object mo2131b() {
        return this.f18982b;
    }
}
