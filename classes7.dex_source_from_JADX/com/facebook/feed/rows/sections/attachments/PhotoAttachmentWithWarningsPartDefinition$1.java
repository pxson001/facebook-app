package com.facebook.feed.rows.sections.attachments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.warning.DisturbingMediaTracker;
import com.google.common.base.Preconditions;

/* compiled from: You must return a view when implementing DrawerContentController.onCreateView */
class PhotoAttachmentWithWarningsPartDefinition$1 implements OnClickListener {
    final /* synthetic */ PhotoAttachmentWithWarningsPartDefinition$State f20732a;
    final /* synthetic */ PhotoAttachmentWithWarningsPartDefinition f20733b;

    PhotoAttachmentWithWarningsPartDefinition$1(PhotoAttachmentWithWarningsPartDefinition photoAttachmentWithWarningsPartDefinition, PhotoAttachmentWithWarningsPartDefinition$State photoAttachmentWithWarningsPartDefinition$State) {
        this.f20733b = photoAttachmentWithWarningsPartDefinition;
        this.f20732a = photoAttachmentWithWarningsPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -476150599);
        ((LocalStatsLoggerImpl) this.f20733b.g.get()).a(6946819);
        ((DisturbingMediaTracker) this.f20733b.f.get()).b(this.f20732a.f20734a);
        Preconditions.checkNotNull(this.f20732a.f20736c);
        this.f20732a.f20736c.b(true);
        Logger.a(2, EntryType.UI_INPUT_END, 2034112456, a);
    }
}
