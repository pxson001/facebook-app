package com.facebook.feedplugins.links;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;

/* compiled from: SUBSCRIBED_TO */
public class ProfileLinkPartDefinition$Props<T extends Flattenable> {
    public final FeedProps<T> f23515a;
    public final ProfileNodeExtractor<T> f23516b;
    public final LinkEventFactory<FeedProps<T>> f23517c;

    public ProfileLinkPartDefinition$Props(FeedProps<T> feedProps, ProfileNodeExtractor<T> profileNodeExtractor, LinkEventFactory<FeedProps<T>> linkEventFactory) {
        this.f23515a = feedProps;
        this.f23516b = profileNodeExtractor;
        this.f23517c = linkEventFactory;
    }
}
