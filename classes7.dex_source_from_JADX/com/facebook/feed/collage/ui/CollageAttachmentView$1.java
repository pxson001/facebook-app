package com.facebook.feed.collage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: application_link_type */
class CollageAttachmentView$1 implements OnClickListener {
    final /* synthetic */ OnImageClickListener f19130a;
    final /* synthetic */ int f19131b;
    final /* synthetic */ CollageAttachmentView f19132c;

    CollageAttachmentView$1(CollageAttachmentView collageAttachmentView, OnImageClickListener onImageClickListener, int i) {
        this.f19132c = collageAttachmentView;
        this.f19130a = onImageClickListener;
        this.f19131b = i;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1796809058);
        this.f19132c.k.setVisibility(8);
        if (!(this.f19130a == null || this.f19132c.p == null)) {
            this.f19130a.a(this.f19132c, (CollageItem) this.f19132c.p.a().get(this.f19131b), this.f19131b);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 778277649, a);
    }
}
