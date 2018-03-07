package com.facebook.feed.viewstate;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* compiled from: share_robotext */
public class UnseenBackgroundDrawable extends MutableLayerDrawable {
    public long f3855a;
    public int f3856b;
    public Drawable f3857c;
    public AnimationState f3858d;

    /* compiled from: share_robotext */
    public enum AnimationState {
        TRANSITION_NONE,
        TRANSITION_RUNNING,
        TRANSITION_FINISHED
    }

    public UnseenBackgroundDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        this.f3857c = drawableArr[1];
        this.f3858d = AnimationState.TRANSITION_NONE;
        this.f3856b = 255;
    }

    public void draw(Canvas canvas) {
        if (this.f3858d == AnimationState.TRANSITION_RUNNING) {
            this.f3856b = (int) ((1.0d - (((double) (SystemClock.uptimeMillis() - this.f3855a)) / 600.0d)) * 255.0d);
            if (this.f3856b <= 0) {
                this.f3856b = 0;
                this.f3858d = AnimationState.TRANSITION_FINISHED;
            }
            this.f3857c.setAlpha(this.f3856b);
            if (this.f3858d == AnimationState.TRANSITION_RUNNING) {
                invalidateSelf();
            }
        }
        super.draw(canvas);
    }
}
