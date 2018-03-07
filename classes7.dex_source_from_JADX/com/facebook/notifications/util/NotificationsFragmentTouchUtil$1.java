package com.facebook.notifications.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: minutiae_disk_storage_write_activities_succeeded */
class NotificationsFragmentTouchUtil$1 implements OnTouchListener {
    final /* synthetic */ ScrollingViewProxy f8872a;
    final /* synthetic */ NotificationsFragmentTouchUtil f8873b;

    NotificationsFragmentTouchUtil$1(NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, ScrollingViewProxy scrollingViewProxy) {
        this.f8873b = notificationsFragmentTouchUtil;
        this.f8872a = scrollingViewProxy;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return NotificationsFragmentTouchUtil.a(this.f8873b, motionEvent, this.f8872a);
    }
}
