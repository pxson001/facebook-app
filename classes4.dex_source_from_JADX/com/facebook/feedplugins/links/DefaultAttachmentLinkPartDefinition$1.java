package com.facebook.feedplugins.links;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterPersistentState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: device_status */
class DefaultAttachmentLinkPartDefinition$1 implements OnClickListener {
    final /* synthetic */ DefaultAttachmentLinkPartDefinition$Props f13871a;
    final /* synthetic */ FollowShareAttachmentPersistentState f13872b;
    final /* synthetic */ OfflineAttachmentSaveFooterPersistentState f13873c;
    final /* synthetic */ boolean f13874d;
    final /* synthetic */ HasInvalidate f13875e;
    final /* synthetic */ DefaultAttachmentLinkPartDefinition f13876f;

    DefaultAttachmentLinkPartDefinition$1(DefaultAttachmentLinkPartDefinition defaultAttachmentLinkPartDefinition, DefaultAttachmentLinkPartDefinition$Props defaultAttachmentLinkPartDefinition$Props, FollowShareAttachmentPersistentState followShareAttachmentPersistentState, OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState, boolean z, HasInvalidate hasInvalidate) {
        this.f13876f = defaultAttachmentLinkPartDefinition;
        this.f13871a = defaultAttachmentLinkPartDefinition$Props;
        this.f13872b = followShareAttachmentPersistentState;
        this.f13873c = offlineAttachmentSaveFooterPersistentState;
        this.f13874d = z;
        this.f13875e = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2009946097);
        this.f13876f.d.a(view, this.f13871a.f13866a, this.f13871a.f13867b, this.f13871a.f13869d, this.f13872b, this.f13873c, this.f13874d, this.f13875e);
        Logger.a(2, EntryType.UI_INPUT_END, -1825667664, a);
    }
}
