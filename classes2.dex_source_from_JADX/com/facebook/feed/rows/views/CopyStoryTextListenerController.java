package com.facebook.feed.rows.views;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;

/* compiled from: is_blocked_by_viewer */
public class CopyStoryTextListenerController implements SupportsCopyStoryText {
    private final Context f19242a;
    private CopyStoryTextListener f19243b;
    private GestureDetectorCompat f19244c;

    public CopyStoryTextListenerController(Context context) {
        this.f19242a = context;
    }

    public void setCopyTextGestureListener(CopyStoryTextListener copyStoryTextListener) {
        this.f19243b = copyStoryTextListener;
        this.f19244c = new GestureDetectorCompat(this.f19242a, copyStoryTextListener);
    }

    public final void iD_() {
        this.f19244c = null;
        this.f19243b = null;
    }

    public final boolean m26959a(MotionEvent motionEvent) {
        if (this.f19244c != null) {
            this.f19244c.m31181a(motionEvent);
        }
        if (this.f19243b == null || motionEvent.getAction() != 1 || !this.f19243b.f23099f) {
            return true;
        }
        this.f19243b.f23099f = false;
        return false;
    }
}
