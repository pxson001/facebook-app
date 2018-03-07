package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: ServicesListGraphQL */
class InlineCommentComposerPartDefinition$2 implements OnClickListener {
    final /* synthetic */ FeedProps f23334a;
    final /* synthetic */ GraphQLStory f23335b;
    final /* synthetic */ InlineCommentComposerPartDefinition f23336c;

    InlineCommentComposerPartDefinition$2(InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, FeedProps feedProps, GraphQLStory graphQLStory) {
        this.f23336c = inlineCommentComposerPartDefinition;
        this.f23334a = feedProps;
        this.f23335b = graphQLStory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 541374414);
        ArrayNode a2 = TrackableFeedProps.a(this.f23334a);
        Builder builder = new Builder();
        builder.a = this.f23335b.l();
        builder = builder;
        builder.d = this.f23335b.l().z_();
        builder = builder;
        FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
        builder2.a = a2;
        FeedbackLoggingParams.Builder builder3 = builder2;
        builder3.c = "native_newsfeed";
        builder.g = builder3.a();
        Builder builder4 = builder;
        builder4.i = true;
        builder4 = builder4;
        builder4.c = this.f23334a;
        this.f23336c.i.a(view.getContext(), builder4.a());
        InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition = this.f23336c;
        FeedProps feedProps = this.f23334a;
        if (feedProps != null) {
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            ArrayNode a3 = TrackableFeedProps.a(feedProps);
            if (NewsFeedAnalyticsEventBuilder.B(a3)) {
                honeyAnalyticsEvent = null;
            } else {
                HoneyClientEvent a4 = new HoneyClientEvent("inline_composer_click").a("tracking", a3);
                a4.c = "native_newsfeed";
                honeyAnalyticsEvent = a4;
            }
            inlineCommentComposerPartDefinition.c.c(honeyAnalyticsEvent);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1897343795, a);
    }
}
