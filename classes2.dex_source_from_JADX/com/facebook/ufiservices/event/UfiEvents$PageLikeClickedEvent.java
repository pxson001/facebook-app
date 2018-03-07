package com.facebook.ufiservices.event;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: plural */
public class UfiEvents$PageLikeClickedEvent extends FeedEvent {
    public final FeedProps<? extends FeedUnit> f11641a;
    public final String f11642b;
    public final String f11643c;
    public final String f11644d;
    public final String f11645e;

    public UfiEvents$PageLikeClickedEvent(FeedProps<? extends FeedUnit> feedProps, String str, String str2, String str3, String str4) {
        this.f11641a = feedProps;
        this.f11642b = str;
        this.f11643c = str2;
        this.f11644d = str3;
        this.f11645e = str4;
    }
}
