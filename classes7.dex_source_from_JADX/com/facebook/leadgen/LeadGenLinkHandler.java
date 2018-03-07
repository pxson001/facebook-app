package com.facebook.leadgen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.OutboundClickedEvent;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.util.LeadGenSplitFlowRequestMethodEnum;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.links.AttachmentLinkLauncher;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_info_blurb_rating */
public class LeadGenLinkHandler {
    public final FeedProps<GraphQLStoryAttachment> f6286a;
    private final AnalyticsLogger f6287b;
    private final LongClickTracker f6288c;
    private final FeedEventBus f6289d;
    private final AttachmentLinkInspector f6290e;
    private final AttachmentLinkLauncher f6291f;
    private final NewsFeedAnalyticsEventBuilder f6292g;
    public final CommonEventsBuilder f6293h;
    private final LeadGenUtil f6294i;
    public String f6295j;
    public String f6296k;

    @Inject
    public LeadGenLinkHandler(AttachmentLinkInspector attachmentLinkInspector, AttachmentLinkLauncher attachmentLinkLauncher, AnalyticsLogger analyticsLogger, LongClickTracker longClickTracker, FeedEventBus feedEventBus, CommonEventsBuilder commonEventsBuilder, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, LeadGenUtil leadGenUtil, @Assisted FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f6290e = attachmentLinkInspector;
        this.f6291f = attachmentLinkLauncher;
        this.f6287b = analyticsLogger;
        this.f6288c = longClickTracker;
        this.f6289d = feedEventBus;
        this.f6292g = newsFeedAnalyticsEventBuilder;
        this.f6286a = feedProps;
        this.f6293h = commonEventsBuilder;
        this.f6294i = leadGenUtil;
    }

    public final void m8131a(View view, String str, boolean z) {
        HoneyClientEvent honeyClientEvent;
        FeedProps feedProps = this.f6286a;
        String str2 = (String) view.getTag(2131558543);
        if (Strings.isNullOrEmpty(str)) {
            honeyClientEvent = null;
        } else {
            String str3 = str;
            honeyClientEvent = this.f6293h.a(str3, AttachmentLinkInspector.b(feedProps), m8130a(feedProps), "native_newsfeed", str2, GraphQLStoryAttachmentUtil.t((GraphQLStoryAttachment) feedProps.a));
        }
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (!TrackingNodes.a(honeyClientEvent2)) {
            TrackingNodes.a(honeyClientEvent2, view);
        }
        this.f6287b.a(honeyClientEvent2);
        m8132b(view, str, z);
    }

    public final void m8132b(View view, String str, boolean z) {
        String str2;
        Map b;
        if (AttachmentLinkInspector.a((GraphQLStoryAttachment) this.f6286a.a)) {
            str2 = "open_graph";
        } else {
            str2 = "other";
        }
        ArrayNode a = m8130a(this.f6286a);
        AttachmentLinkLauncher attachmentLinkLauncher = this.f6291f;
        Context context = view.getContext();
        Bundle a2 = m8129a(a, str, z);
        FeedProps feedProps = this.f6286a;
        if (AttachmentLinkInspector.c(feedProps)) {
            b = NewsFeedAnalyticsEventBuilder.b(str2, "native", AttachmentLinkInspector.b(feedProps), m8130a(feedProps));
        } else {
            b = null;
        }
        attachmentLinkLauncher.a(context, str, a2, b);
        FeedProps e = AttachmentProps.e(this.f6286a);
        if (e != null) {
            ArrayNode a3 = TrackableFeedProps.a(e);
            if (a3 != null) {
                this.f6288c.a(a3, str);
            }
        }
        if (a != null && a.e() != 0) {
            String str3 = null;
            GraphQLStory c = AttachmentProps.c(this.f6286a);
            if (c != null) {
                if (AttachmentProps.a(this.f6286a) != c) {
                    str3 = AttachmentProps.a(this.f6286a).g();
                }
                str3 = new OutboundClickedEvent(c.g(), str3);
            }
            FbEvent fbEvent = str3;
            if (fbEvent != null) {
                this.f6289d.a(fbEvent);
            }
        }
    }

    public static ArrayNode m8130a(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps g = AttachmentProps.g(feedProps);
        return g != null ? TrackableFeedProps.b(g) : null;
    }

    private Bundle m8129a(ArrayNode arrayNode, String str, boolean z) {
        Bundle a = this.f6291f.a(arrayNode, this.f6286a, str, "lead_gen");
        GraphQLStoryActionLink a2 = ActionLinkHelper.a((GraphQLStoryAttachment) this.f6286a.a, 1185006756);
        if (a2 == null) {
            return null;
        }
        if (z && LeadGenUtil.c(a2)) {
            a.putString("lead_gen_continued_flow_text", a2.au());
            a.putString("lead_gen_continued_flow_title", a2.av());
            a.putBoolean("lead_gen_require_continued_flow", true);
            a.putString("lead_gen_continued_flow_user_info_value", this.f6295j);
            if (LeadGenSplitFlowRequestMethodEnum.AUTOFILL == LeadGenSplitFlowRequestMethodEnum.fromValue(LeadGenUtil.a(a2))) {
                a.putBoolean("lead_gen_seamless_continued_flow", true);
                a.putString("extra_js_to_execute", this.f6296k);
            }
        }
        return a;
    }
}
