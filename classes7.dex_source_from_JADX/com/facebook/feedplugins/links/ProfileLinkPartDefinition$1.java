package com.facebook.feedplugins.links;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.sections.attachments.calltoaction.PageLikeAttachmentPartDefinition$3;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SUBSCRIBED_TO */
public class ProfileLinkPartDefinition$1 implements OnClickListener {
    final /* synthetic */ ProfileLinkPartDefinition$Props f23513a;
    final /* synthetic */ ProfileLinkPartDefinition f23514b;

    public ProfileLinkPartDefinition$1(ProfileLinkPartDefinition profileLinkPartDefinition, ProfileLinkPartDefinition$Props profileLinkPartDefinition$Props) {
        this.f23514b = profileLinkPartDefinition;
        this.f23513a = profileLinkPartDefinition$Props;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1710994490);
        PageLikeAttachmentPartDefinition$3 pageLikeAttachmentPartDefinition$3 = this.f23513a.f23516b;
        this.f23514b.a.a(LinkifyTargetBuilder.a(ActionLinkHelper.a((GraphQLStoryAttachment) this.f23513a.f23515a.a, -581184810).ab()), this.f23513a.f23517c.a(this.f23513a.f23515a, view), view);
        Logger.a(2, EntryType.UI_INPUT_END, 1179464104, a);
    }
}
