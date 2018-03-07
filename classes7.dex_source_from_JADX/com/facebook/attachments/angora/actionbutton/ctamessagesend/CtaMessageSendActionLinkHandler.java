package com.facebook.attachments.angora.actionbutton.ctamessagesend;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.api.graphql.ctamessagesend.CtaMessageSend2Mutation.CtaMessageSendMutation2String;
import com.facebook.api.graphql.ctamessagesend.CtaMessageSend2MutationModels.CtaMessageSendMutation2Model;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.OutboundClickedEvent;
import com.facebook.graphql.calls.CtaAdMessageSend2InputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: userID */
public class CtaMessageSendActionLinkHandler {
    public static final String f889a = CtaMessageSendLogger.class.getSimpleName();
    public final FeedProps<GraphQLStoryAttachment> f890b;
    private final AnalyticsLogger f891c;
    private final LongClickTracker f892d;
    private final FeedEventBus f893e;
    private final AttachmentLinkInspector f894f;
    public final CommonEventsBuilder f895g;
    private final GraphQLQueryExecutor f896h;
    private final Executor f897i;
    private LinkHandlingHelper f898j;
    private final Context f899k;
    public AbstractFbErrorReporter f900l;

    /* compiled from: userID */
    class C00801 implements FutureCallback<GraphQLResult<CtaMessageSendMutation2Model>> {
        final /* synthetic */ CtaMessageSendActionLinkHandler f888a;

        C00801(CtaMessageSendActionLinkHandler ctaMessageSendActionLinkHandler) {
            this.f888a = ctaMessageSendActionLinkHandler;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f888a.f900l.a(CtaMessageSendActionLinkHandler.f889a, "send message graphql mutation failed");
        }
    }

    @Inject
    public CtaMessageSendActionLinkHandler(AttachmentLinkInspector attachmentLinkInspector, AnalyticsLogger analyticsLogger, LongClickTracker longClickTracker, FeedEventBus feedEventBus, CommonEventsBuilder commonEventsBuilder, GraphQLQueryExecutor graphQLQueryExecutor, Context context, FbErrorReporter fbErrorReporter, LinkHandlingHelper linkHandlingHelper, Executor executor, @Assisted FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f894f = attachmentLinkInspector;
        this.f891c = analyticsLogger;
        this.f892d = longClickTracker;
        this.f893e = feedEventBus;
        this.f900l = fbErrorReporter;
        this.f896h = graphQLQueryExecutor;
        this.f899k = context;
        this.f898j = linkHandlingHelper;
        this.f897i = executor;
        this.f890b = feedProps;
        this.f895g = commonEventsBuilder;
    }

    public final void m885a(View view, String str, String str2) {
        HoneyClientEvent honeyClientEvent;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, str);
        FeedProps feedProps = this.f890b;
        String str3 = (String) view.getTag(2131558543);
        if (Strings.isNullOrEmpty(formatStrLocaleSafe)) {
            honeyClientEvent = null;
        } else {
            String str4 = formatStrLocaleSafe;
            honeyClientEvent = this.f895g.a(str4, AttachmentLinkInspector.b(feedProps), m883a(feedProps), "native_newsfeed", str3, GraphQLStoryAttachmentUtil.t((GraphQLStoryAttachment) feedProps.a));
        }
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (!TrackingNodes.a(honeyClientEvent2)) {
            TrackingNodes.a(honeyClientEvent2, view);
        }
        this.f891c.a(honeyClientEvent2);
        m884a(str, str2);
    }

    private void m884a(String str, String str2) {
        ArrayNode a = m883a(this.f890b);
        if (str == null) {
            this.f900l.a(f889a, "send message failed: page id is null");
            return;
        }
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(MessengerLinks.w, str);
        this.f898j.m9458a(this.f899k, Uri.parse(formatStrLocaleSafe));
        CtaAdMessageSend2InputData ctaAdMessageSend2InputData = new CtaAdMessageSend2InputData();
        ctaAdMessageSend2InputData.a("page_id", str);
        GraphQlCallInput graphQlCallInput = ctaAdMessageSend2InputData;
        graphQlCallInput.a("ad_id", str2);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString ctaMessageSendMutation2String = new CtaMessageSendMutation2String();
        ctaMessageSendMutation2String.a("input", graphQlCallInput);
        Futures.a(this.f896h.a(GraphQLRequest.a(ctaMessageSendMutation2String)), new C00801(this), this.f897i);
        FeedProps e = AttachmentProps.e(this.f890b);
        if (e != null) {
            ArrayNode a2 = TrackableFeedProps.a(e);
            if (a2 != null) {
                this.f892d.a(a2, formatStrLocaleSafe);
            }
        }
        if (a != null && a.e() != 0) {
            String str3 = null;
            GraphQLStory c = AttachmentProps.c(this.f890b);
            if (c != null) {
                GraphQLStory a3 = AttachmentProps.a(this.f890b);
                if (!(a3 == null || a3 == c)) {
                    str3 = a3.g();
                }
                str3 = new OutboundClickedEvent(c.g(), str3);
            }
            FbEvent fbEvent = str3;
            if (fbEvent != null) {
                this.f893e.a(fbEvent);
            }
        }
    }

    public static ArrayNode m883a(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps g = AttachmentProps.g(feedProps);
        return g != null ? TrackableFeedProps.b(g) : null;
    }
}
