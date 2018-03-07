package com.facebook.feedplugins.pyml.rows;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

/* compiled from: onInfo MEDIA_INFO_VIDEO_TRACK_LAGGING */
public class PageLiker {
    private final CommonEventsBuilder f6169a;
    public final AnalyticsLogger f6170b;
    private final NewsFeedAnalyticsEventBuilder f6171c;
    private final RawLikeHelper f6172d;

    public static PageLiker m6642b(InjectorLike injectorLike) {
        return new PageLiker(CommonEventsBuilder.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), RawLikeHelper.m6644b(injectorLike));
    }

    @Inject
    public PageLiker(CommonEventsBuilder commonEventsBuilder, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, RawLikeHelper rawLikeHelper) {
        this.f6169a = commonEventsBuilder;
        this.f6170b = analyticsLogger;
        this.f6171c = newsFeedAnalyticsEventBuilder;
        this.f6172d = rawLikeHelper;
    }

    public final void m6643a(GraphQLPage graphQLPage, ArrayNode arrayNode, GraphQLSponsoredData graphQLSponsoredData, String str) {
        boolean z;
        boolean z2 = true;
        RawLikeHelper rawLikeHelper = this.f6172d;
        String ae = graphQLPage.ae();
        if (graphQLPage.O()) {
            z = false;
        } else {
            z = true;
        }
        rawLikeHelper.m6646a(ae, z, null, "native_newsfeed", "pyml_page_like", str, arrayNode, false, new 1(this, graphQLPage));
        boolean z3 = graphQLSponsoredData != null;
        if (graphQLPage.O()) {
            z2 = false;
        }
        this.f6170b.c(NewsFeedAnalyticsEventBuilder.a(z3, arrayNode, z2));
    }
}
