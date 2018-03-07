package com.facebook.feed.photoreminder;

import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.widget.LazyView;

/* compiled from: admin_panel_show_public_view */
public class PhotoReminderViewController {
    public LazyView<PhotoReminderFrameView> f19751a;
    public MediaReminderModel f19752b;

    public final void m23014a() {
        if (this.f19751a.b()) {
            ((PhotoReminderFrameView) this.f19751a.a()).mo1466a(true);
        }
    }

    public final boolean m23015b() {
        if (!this.f19752b.i) {
            return false;
        }
        m23014a();
        this.f19752b.i = false;
        return true;
    }
}
