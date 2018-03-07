package com.facebook.video.player.plugins;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.video.player.events.RVPFlingEvent;

/* compiled from: commerce_view_product_details */
class VideoControlsBasePlugin$OnFlingListener extends SimpleOnGestureListener {
    final /* synthetic */ VideoControlsBasePlugin f19420a;

    public VideoControlsBasePlugin$OnFlingListener(VideoControlsBasePlugin videoControlsBasePlugin) {
        this.f19420a = videoControlsBasePlugin;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f19420a.g.a(new RVPFlingEvent(motionEvent, motionEvent2, f, f2));
        return true;
    }
}
