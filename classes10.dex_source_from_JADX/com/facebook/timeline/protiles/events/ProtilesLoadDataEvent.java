package com.facebook.timeline.protiles.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;

/* compiled from: feed_filter_links */
public class ProtilesLoadDataEvent implements KeyedEvent<String> {
    private final Type f12100a;
    private final GraphQLProfileTileSectionType f12101b;
    private final String f12102c;
    private final String f12103d;
    private final int f12104e;

    /* compiled from: feed_filter_links */
    public enum Type {
        FULL_DATA,
        ITEMS
    }

    public ProtilesLoadDataEvent(Type type, GraphQLProfileTileSectionType graphQLProfileTileSectionType, String str, String str2, int i) {
        this.f12100a = type;
        this.f12101b = graphQLProfileTileSectionType;
        this.f12102c = str;
        this.f12103d = str2;
        this.f12104e = i;
    }

    public final Object m12103c() {
        return this.f12100a.toString();
    }
}
