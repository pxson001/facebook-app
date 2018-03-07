package com.facebook.feedplugins.links;

import android.view.View;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.facebook.links.AttachmentLinkInspector;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SUGGESTED_BADGE */
public class AttachmentLinkClickEventFactory implements LinkEventFactory<FeedProps<GraphQLStoryAttachment>> {
    private final CommonEventsBuilder f23507a;
    private final AttachmentLinkInspector f23508b;
    private final LinkClickType f23509c;

    /* compiled from: SUGGESTED_BADGE */
    public enum LinkClickType {
        CTA_BUTTON,
        ATTACHMENT
    }

    @Nullable
    public final HoneyClientEvent m25765a(Object obj, View view) {
        FeedProps feedProps = (FeedProps) obj;
        JsonNode jsonNode = null;
        String str = (String) view.getTag(2131558543);
        String a = AttachmentCallToActionButtonLinkUtils.m25764a(feedProps, this.f23508b);
        if (Strings.isNullOrEmpty(a)) {
            return null;
        }
        FeedProps feedProps2 = feedProps.b;
        if (feedProps2 != null) {
            jsonNode = TrackableFeedProps.b(feedProps2);
        }
        if (this.f23509c == LinkClickType.ATTACHMENT) {
            return this.f23507a.b(a, AttachmentLinkInspector.b(feedProps), jsonNode, "native_newsfeed", str, GraphQLStoryAttachmentUtil.t((GraphQLStoryAttachment) feedProps.a));
        }
        return this.f23507a.a(a, AttachmentLinkInspector.b(feedProps), jsonNode, "native_newsfeed", str, GraphQLStoryAttachmentUtil.t((GraphQLStoryAttachment) feedProps.a));
    }

    @Inject
    public AttachmentLinkClickEventFactory(CommonEventsBuilder commonEventsBuilder, AttachmentLinkInspector attachmentLinkInspector, @Assisted LinkClickType linkClickType) {
        this.f23507a = commonEventsBuilder;
        this.f23508b = attachmentLinkInspector;
        this.f23509c = linkClickType;
    }
}
