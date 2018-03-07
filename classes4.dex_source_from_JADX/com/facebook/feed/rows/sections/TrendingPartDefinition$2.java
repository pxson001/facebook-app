package com.facebook.feed.rows.sections;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLTopic;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: oxygen_map_draw_time_ns */
public class TrendingPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLTopic f5675a;
    final /* synthetic */ FeedProps f5676b;
    final /* synthetic */ TrendingPartDefinition f5677c;

    public TrendingPartDefinition$2(TrendingPartDefinition trendingPartDefinition, GraphQLTopic graphQLTopic, FeedProps feedProps) {
        this.f5677c = trendingPartDefinition;
        this.f5675a = graphQLTopic;
        this.f5676b = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1006218972);
        Intent a2 = this.f5677c.d.a(this.f5675a);
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f5677c.f;
        ArrayNode a3 = TrackableFeedProps.a(this.f5676b);
        String k = this.f5675a.k();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.d = "Topic";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = k;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "native_newsfeed";
        honeyClientEvent = honeyClientEvent;
        if (a3 != null) {
            honeyClientEvent.a("tracking", a3);
        }
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        this.f5677c.e.a(a2, view.getContext());
        this.f5677c.g.c(honeyAnalyticsEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 1207802413, a);
    }
}
