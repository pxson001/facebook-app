package com.facebook.feed.renderer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Map;

/* compiled from: description */
class DefaultFeedUnitRenderer$7 implements OnClickListener {
    final /* synthetic */ FeedProps f13978a;
    final /* synthetic */ FeedProps f13979b;
    final /* synthetic */ String f13980c;
    final /* synthetic */ GraphQLStoryAttachment f13981d;
    final /* synthetic */ DefaultFeedUnitRenderer f13982e;

    DefaultFeedUnitRenderer$7(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FeedProps feedProps, FeedProps feedProps2, String str, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f13982e = defaultFeedUnitRenderer;
        this.f13978a = feedProps;
        this.f13979b = feedProps2;
        this.f13980c = str;
        this.f13981d = graphQLStoryAttachment;
    }

    public void onClick(View view) {
        boolean z;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1175780189);
        FeedProps feedProps = this.f13978a;
        if (feedProps == null || !StoryProps.p(feedProps)) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        ArrayNode c = DefaultFeedUnitRenderer.c(this.f13982e, this.f13979b);
        if (NativeThirdPartyUriHelper.a(this.f13980c)) {
            NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f13982e.g;
            Map d = NewsFeedAnalyticsEventBuilder.d(z2, c);
            d.put("cta_click", Boolean.valueOf(true));
            DefaultFeedUnitRenderer defaultFeedUnitRenderer = this.f13982e;
            TrackingNode a2 = TrackingNodes.a(view);
            if (a2 != null) {
                ArrayNode b = TrackingNodes.b(a2);
                if (b != null) {
                    d.put("tn", b);
                }
            }
            this.f13982e.a(this.f13980c, null, d).onClick(view);
        } else {
            HoneyClientEvent a3 = DefaultFeedUnitRenderer.a(this.f13982e, view, this.f13980c, z2, c, GraphQLStoryAttachmentUtil.t(this.f13981d));
            if (a3 != null) {
                this.f13982e.a(this.f13979b, a3, this.f13980c).onClick(view);
            }
        }
        LogUtils.a(1327621497, a);
    }
}
