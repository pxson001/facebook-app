package com.facebook.feedplugins.attachments.collage;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.warning.DisturbingMediaTracker;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;

/* compiled from: TOOLTIP_ICONS_TEXT */
class CollageAttachmentWithWarningsPartDefinition$1 implements OnClickListener {
    final /* synthetic */ CollageAttachmentWithWarningsPartDefinition$State f22561a;
    final /* synthetic */ CollageAttachmentWithWarningsPartDefinition f22562b;

    CollageAttachmentWithWarningsPartDefinition$1(CollageAttachmentWithWarningsPartDefinition collageAttachmentWithWarningsPartDefinition, CollageAttachmentWithWarningsPartDefinition$State collageAttachmentWithWarningsPartDefinition$State) {
        this.f22562b = collageAttachmentWithWarningsPartDefinition;
        this.f22561a = collageAttachmentWithWarningsPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1279979289);
        ((LocalStatsLoggerImpl) this.f22562b.c.get()).a(6946819);
        for (int i = 0; i < this.f22561a.f22563a.size(); i++) {
            GraphQLMedia r = ((GraphQLStoryAttachment) ((FeedProps) this.f22561a.f22563a.get(i)).a).r();
            if (r.ak()) {
                ((DisturbingMediaTracker) this.f22562b.b.get()).b(r);
            }
        }
        Preconditions.checkNotNull(this.f22561a.f22564b);
        this.f22561a.f22564b.b(true);
        LogUtils.a(1384812586, a);
    }
}
