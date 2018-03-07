package com.facebook.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Trying to pass extra share id in older versions of messenger */
public class FeedStoryPermalinkOnClickListener implements OnClickListener {
    private NewsFeedAnalyticsEventBuilder f21739a;
    private AnalyticsLogger f21740b;
    private PerformanceLogger f21741c;
    private final InteractionTTILogger f21742d;
    private IFeedIntentBuilder f21743e;
    private SecureContextHelper f21744f;
    private FeedProps<GraphQLStory> f21745g;
    private final Provider<Boolean> f21746h;

    @Inject
    public FeedStoryPermalinkOnClickListener(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, PerformanceLogger performanceLogger, InteractionTTILogger interactionTTILogger, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, Provider<Boolean> provider, @Assisted FeedProps<GraphQLStory> feedProps) {
        this.f21739a = newsFeedAnalyticsEventBuilder;
        this.f21740b = analyticsLogger;
        this.f21741c = performanceLogger;
        this.f21742d = interactionTTILogger;
        this.f21743e = iFeedIntentBuilder;
        this.f21744f = secureContextHelper;
        this.f21746h = provider;
        this.f21745g = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1372743455);
        if ((view instanceof TextView) && ((TextView) view).hasSelection()) {
            Logger.a(2, EntryType.UI_INPUT_END, -2101688199, a);
            return;
        }
        GraphQLStory graphQLStory = (GraphQLStory) this.f21745g.a;
        if (((Boolean) this.f21746h.get()).booleanValue() && StoryProps.p(this.f21745g)) {
            HoneyClientEvent honeyClientEvent;
            String nullToEmpty = Strings.nullToEmpty(graphQLStory.ai());
            String c = graphQLStory.c();
            ArrayNode a2 = TrackableFeedProps.a(this.f21745g);
            if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                honeyClientEvent = null;
            } else {
                honeyClientEvent = new HoneyClientEvent("open_permalink_view").b("story_legacy_api_post_id", nullToEmpty).b("story_graphql_id", c).a("tracking", a2).b(true);
                honeyClientEvent.c = "native_newsfeed";
                honeyClientEvent = honeyClientEvent;
            }
            this.f21740b.a(honeyClientEvent);
        }
        this.f21742d.a(view.getContext(), "FeedStoryPermalink");
        this.f21741c.d(655368, "NNF_PermalinkFromFeedLoad");
        this.f21744f.a(this.f21743e.a(graphQLStory), view.getContext());
        LogUtils.a(-115313966, a);
    }
}
