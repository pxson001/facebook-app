package com.facebook.feedplugins.multishare;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: network_wifi_rssi */
public class BusinessLocationActionLinkClickListenerProvider extends AbstractAssistedProvider<BusinessLocationActionLinkClickListener> {
    public final BusinessLocationActionLinkClickListener m7519a(FeedProps<GraphQLStory> feedProps, String str, int i) {
        return new BusinessLocationActionLinkClickListener(CommonEventsBuilder.b(this), DefaultFeedUnitRenderer.a(this), feedProps, str, i);
    }
}
