package com.facebook.feed.rows.util;

import android.os.Bundle;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.timeline.intent.ModelBundle;
import javax.inject.Inject;

/* compiled from: [ */
public class ProfileLinkHandler {
    private final IFeedIntentBuilder f313a;
    private final GraphQLLinkExtractor f314b;
    private final AnalyticsLogger f315c;
    private final NavigationLogger f316d;

    @Inject
    public ProfileLinkHandler(IFeedIntentBuilder iFeedIntentBuilder, GraphQLLinkExtractor graphQLLinkExtractor, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger) {
        this.f313a = iFeedIntentBuilder;
        this.f314b = graphQLLinkExtractor;
        this.f315c = analyticsLogger;
        this.f316d = navigationLogger;
    }

    public final void m278a(LinkifyTargetGraphQL linkifyTargetGraphQL, HoneyClientEvent honeyClientEvent, View view) {
        String a = this.f314b.a(linkifyTargetGraphQL.b(), linkifyTargetGraphQL.d());
        if (a != null) {
            String str;
            if (!TrackingNodes.a(honeyClientEvent)) {
                TrackingNodes.a(honeyClientEvent, view);
            }
            this.f315c.a(honeyClientEvent);
            NavigationLogger navigationLogger = this.f316d;
            if (honeyClientEvent == null || !honeyClientEvent.j) {
                str = "tap_profile_pic";
            } else {
                str = "tap_profile_pic_sponsored";
            }
            navigationLogger.a(str);
            Bundle bundle = new Bundle();
            int g = linkifyTargetGraphQL.b().g();
            String d = linkifyTargetGraphQL.d();
            if (linkifyTargetGraphQL.ad_() != null) {
                str = linkifyTargetGraphQL.ad_().b();
            } else {
                str = null;
            }
            ModelBundle.a(bundle, g, d, str, linkifyTargetGraphQL.C_());
            this.f313a.a(view.getContext(), a, bundle, null);
        }
    }
}
