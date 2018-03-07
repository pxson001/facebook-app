package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import com.facebook.attachments.photos.ui.PhotoAttachmentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: V_VP9 */
public class AlbumAttachmentItemView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f21052a;
    public PhotoAttachmentView f21053b;

    public AlbumAttachmentItemView(Context context) {
        this(context, 2130903227);
    }

    private AlbumAttachmentItemView(Context context, int i) {
        super(context);
        setContentView(i);
        this.f21053b = (PhotoAttachmentView) c(2131559536);
        this.f21053b.setBackgroundResource(2130840254);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1756117208);
        super.onAttachedToWindow();
        this.f21052a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -685111934, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2143669090);
        super.onDetachedFromWindow();
        this.f21052a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1733405759, a);
    }

    public final boolean m23934a() {
        return this.f21052a;
    }
}
