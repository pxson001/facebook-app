package com.facebook.notifications.util;

import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: minutiae_disk_storage_write_activities_succeeded */
class NotificationsFragmentTouchUtil$2 implements OnItemTouchListener {
    final /* synthetic */ ScrollingViewProxy f8874a;
    final /* synthetic */ NotificationsFragmentTouchUtil f8875b;

    NotificationsFragmentTouchUtil$2(NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, ScrollingViewProxy scrollingViewProxy) {
        this.f8875b = notificationsFragmentTouchUtil;
        this.f8874a = scrollingViewProxy;
    }

    public final boolean m10801a(MotionEvent motionEvent) {
        return NotificationsFragmentTouchUtil.a(this.f8875b, motionEvent, this.f8874a);
    }

    public final void m10802b(MotionEvent motionEvent) {
    }

    public final void m10800a(boolean z) {
    }
}
