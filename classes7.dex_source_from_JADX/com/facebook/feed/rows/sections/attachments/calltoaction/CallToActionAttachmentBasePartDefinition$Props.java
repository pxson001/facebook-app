package com.facebook.feed.rows.sections.attachments.calltoaction;

import com.facebook.directinstall.util.DirectInstallButtonHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: WORD_TRANSLITERATED */
public class CallToActionAttachmentBasePartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f20863a;
    public final LegacyAngoraAttachmentUtil f20864b;
    public final DirectInstallButtonHelper f20865c;

    public CallToActionAttachmentBasePartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, DirectInstallButtonHelper directInstallButtonHelper) {
        this.f20863a = feedProps;
        this.f20864b = legacyAngoraAttachmentUtil;
        this.f20865c = directInstallButtonHelper;
    }
}
