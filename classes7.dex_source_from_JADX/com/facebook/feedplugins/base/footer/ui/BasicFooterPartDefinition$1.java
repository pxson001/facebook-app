package com.facebook.feedplugins.base.footer.ui;

import android.view.View;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.NetEgoStoryFooterButtonClickLoggingHandler;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
import com.facebook.graphql.model.interfaces.HasTracking;

/* compiled from: SyncConnectionHandler */
public class BasicFooterPartDefinition$1 implements ButtonClickedListener {
    final /* synthetic */ FeedProps f23015a;
    final /* synthetic */ boolean f23016b;
    final /* synthetic */ FeedListType f23017c;
    final /* synthetic */ BasicFooterPartDefinition f23018d;

    public BasicFooterPartDefinition$1(BasicFooterPartDefinition basicFooterPartDefinition, FeedProps feedProps, boolean z, FeedListType feedListType) {
        this.f23018d = basicFooterPartDefinition;
        this.f23015a = feedProps;
        this.f23016b = z;
        this.f23017c = feedListType;
    }

    public final void m25497a(View view, FooterButtonId footerButtonId) {
        NetEgoStoryFooterButtonClickLoggingHandler netEgoStoryFooterButtonClickLoggingHandler = (NetEgoStoryFooterButtonClickLoggingHandler) this.f23018d.d.get();
        FeedProps feedProps = this.f23015a;
        Flattenable c = feedProps.c();
        if (((c instanceof GraphQLGroupTopStoriesFeedUnit) || (c instanceof GraphQLPageStoriesYouMissedFeedUnit)) && NetEgoStoryFooterButtonClickLoggingHandler.m25408a(c) != null) {
            netEgoStoryFooterButtonClickLoggingHandler.f22856a.a(NewsFeedAnalyticsEventBuilder.c(NetEgoStoryFooterButtonClickLoggingHandler.m25408a(c), GraphQLHelper.a((HasTracking) feedProps.a, (HasTracking) c)));
        }
        this.f23018d.c.a(this.f23015a, view, footerButtonId, this.f23016b, this.f23017c);
    }
}
