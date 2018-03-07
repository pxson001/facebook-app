package com.facebook.ufiservices.event;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: plural */
public class UfiEvents$SetNotifyMeEvent extends FeedEvent {
    public final FeedProps<GraphQLStory> f11633a;
    public final String f11634b;
    public final String f11635c;
    public final String f11636d;
    public final String f11637e;
    private final String f11638f;
    private final String f11639g;
    public final boolean f11640h;

    public UfiEvents$SetNotifyMeEvent(FeedProps<GraphQLStory> feedProps, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.f11633a = feedProps;
        this.f11634b = str;
        this.f11635c = str2;
        this.f11636d = str3;
        this.f11637e = str4;
        this.f11638f = str5;
        this.f11639g = str6;
        this.f11640h = z;
    }
}
