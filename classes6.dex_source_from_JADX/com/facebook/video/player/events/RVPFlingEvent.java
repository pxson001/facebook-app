package com.facebook.video.player.events;

import android.view.MotionEvent;

/* compiled from: composer_edit_change_minutiae_tag */
public class RVPFlingEvent extends RichVideoPlayerEvent {
    public final MotionEvent f19280a;
    public final MotionEvent f19281b;
    public final float f19282c;
    public final float f19283d;

    public RVPFlingEvent(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f19280a = motionEvent;
        this.f19281b = motionEvent2;
        this.f19282c = f;
        this.f19283d = f2;
    }

    public String toString() {
        return "RVPFlingEvent{velocityX=" + this.f19282c + ", velocityY=" + this.f19283d + ", downEvent=" + this.f19280a + ", upEvent=" + this.f19281b + '}';
    }
}
