package com.facebook.video.creativeediting.trimmer;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: e176f26654685dcac473e43d823b1ca5 */
public abstract class StripScrubberTouchListener implements OnTouchListener {
    public int f15480a;

    public abstract int mo1198a();

    public abstract void mo1199a(int i);

    public abstract int mo1200b();

    public abstract void mo1201b(int i);

    public abstract void mo1202c();

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        motionEvent.getRawY();
        int actionMasked = motionEvent.getActionMasked();
        if (rawX >= mo1198a() && rawX <= mo1200b()) {
            switch (actionMasked) {
                case 0:
                    mo1199a(rawX);
                    this.f15480a = rawX;
                    return true;
                case 1:
                    mo1202c();
                    return true;
                case 2:
                    mo1201b(rawX);
                    this.f15480a = rawX;
                    return true;
                default:
                    return true;
            }
        } else if (actionMasked != 2) {
            return false;
        } else {
            mo1202c();
            return true;
        }
    }
}
