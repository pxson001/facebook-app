package com.facebook.ufiservices.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$PermalinkClickedEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ufiservices.qe.ExperimentsForUFIServicesModule;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

/* compiled from: friending_mark_friend_requests_seen */
public class StoryContinueReadingSpan extends ContinueReadingSpan {
    private final FeedProps<GraphQLStory> f23111a;
    private final IFeedIntentBuilder f23112b;
    private final PerformanceLogger f23113c;
    private final InteractionTTILogger f23114d;
    private final SecureContextHelper f23115e;
    private final CommonEventsBuilder f23116f;
    private final AnalyticsLogger f23117g;
    private final Lazy<NavigationLogger> f23118h;
    private final FeedEventBus f23119i;
    private final NewsfeedAnalyticsLogger f23120j;
    private final QeAccessor f23121k;

    @Inject
    public StoryContinueReadingSpan(@ForAppContext Context context, @Assisted FeedProps<GraphQLStory> feedProps, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, PerformanceLogger performanceLogger, InteractionTTILogger interactionTTILogger, CommonEventsBuilder commonEventsBuilder, AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, QeAccessor qeAccessor, FeedEventBus feedEventBus) {
        super(context, null);
        this.f23111a = feedProps;
        this.f23116f = commonEventsBuilder;
        this.f23117g = analyticsLogger;
        this.f23112b = iFeedIntentBuilder;
        this.f23113c = performanceLogger;
        this.f23114d = interactionTTILogger;
        this.f23115e = secureContextHelper;
        this.f23118h = lazy;
        this.f23119i = feedEventBus;
        this.f23120j = newsfeedAnalyticsLogger;
        this.f23121k = qeAccessor;
    }

    public void onClick(View view) {
        if (this.f23111a != null) {
            this.f23114d.m4248a(view.getContext(), "StoryContinueReadingSpan");
            this.f23113c.mo392d(655368, "NNF_PermalinkFromFeedLoad");
            ((NavigationLogger) this.f23118h.get()).m5498a("tap_continue_reading");
            if (StoryProps.m27466p(this.f23111a)) {
                HoneyClientEvent honeyClientEvent;
                JsonNode a = TrackableFeedProps.m27451a(this.f23111a);
                String str = "native_newsfeed";
                if (a == null || a.mo712e() == 0) {
                    honeyClientEvent = null;
                } else {
                    honeyClientEvent = new HoneyClientEvent("open_permalink_view");
                    honeyClientEvent.f3099c = str;
                    honeyClientEvent = honeyClientEvent.m5085a("tracking", a).mo699b(true);
                }
                this.f23117g.mo528a(honeyClientEvent);
            }
            this.f23119i.mo651a(new StoryEvents$PermalinkClickedEvent(this.f23111a));
            Intent a2 = this.f23112b.mo3007a((GraphQLStory) this.f23111a.f13444a);
            if (this.f23121k.mo596a(ExperimentsForUFIServicesModule.a, false)) {
                ArrayNode a3 = TrackableFeedProps.m27451a(this.f23111a);
                Builder newBuilder = FeedbackLoggingParams.newBuilder();
                newBuilder.f22397a = a3;
                newBuilder = newBuilder;
                this.f23120j.m26301a((GraphQLStory) this.f23111a.f13444a, newBuilder);
                a2.putExtra("feedback_logging_params", newBuilder.m30319a());
            }
            this.f23115e.mo662a(a2, view.getContext());
        }
    }
}
