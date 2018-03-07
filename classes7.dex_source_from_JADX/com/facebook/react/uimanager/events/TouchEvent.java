package com.facebook.react.uimanager.events;

import android.support.v4.util.Pools.SynchronizedPool;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

/* compiled from: footer_share_popover_menu */
public class TouchEvent extends Event<TouchEvent> {
    private static final SynchronizedPool<TouchEvent> f11908a = new SynchronizedPool(3);
    @Nullable
    private MotionEvent f11909b;
    @Nullable
    private TouchEventType f11910c;
    private short f11911d;
    public float f11912e;
    public float f11913f;

    public static TouchEvent m14161a(int i, long j, TouchEventType touchEventType, MotionEvent motionEvent, float f, float f2) {
        TouchEvent touchEvent = (TouchEvent) f11908a.a();
        if (touchEvent == null) {
            touchEvent = new TouchEvent();
        }
        touchEvent.m14162b(i, j, touchEventType, motionEvent, f, f2);
        return touchEvent;
    }

    private TouchEvent() {
    }

    private void m14162b(int i, long j, TouchEventType touchEventType, MotionEvent motionEvent, float f, float f2) {
        super.m13908a(i, j);
        short s = (short) 0;
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                TouchEventCoalescingKeyHelper.m14171a(motionEvent.getDownTime());
                break;
            case 1:
                TouchEventCoalescingKeyHelper.m14174d(motionEvent.getDownTime());
                break;
            case 2:
                s = TouchEventCoalescingKeyHelper.m14173c(motionEvent.getDownTime());
                break;
            case 3:
                TouchEventCoalescingKeyHelper.m14174d(motionEvent.getDownTime());
                break;
            case 5:
            case 6:
                TouchEventCoalescingKeyHelper.m14172b(motionEvent.getDownTime());
                break;
            default:
                throw new RuntimeException("Unhandled MotionEvent action: " + action);
        }
        this.f11910c = touchEventType;
        this.f11909b = MotionEvent.obtain(motionEvent);
        this.f11911d = s;
        this.f11912e = f;
        this.f11913f = f2;
    }

    public final void mo736a() {
        ((MotionEvent) Assertions.b(this.f11909b)).recycle();
        this.f11909b = null;
        f11908a.a(this);
    }

    public final String mo738b() {
        return ((TouchEventType) Assertions.b(this.f11910c)).getJSEventName();
    }

    public final boolean mo752e() {
        switch ((TouchEventType) Assertions.b(this.f11910c)) {
            case START:
            case END:
            case CANCEL:
                return false;
            case MOVE:
                return true;
            default:
                throw new RuntimeException("Unknown touch event type: " + this.f11910c);
        }
    }

    public final short mo753f() {
        return this.f11911d;
    }

    public final void mo737a(RCTEventEmitter rCTEventEmitter) {
        TouchesHelper.m14177a(rCTEventEmitter, (TouchEventType) Assertions.b(this.f11910c), this.f11751c, this);
    }

    public final MotionEvent m14168j() {
        Assertions.b(this.f11909b);
        return this.f11909b;
    }

    public final float m14169k() {
        return this.f11912e;
    }

    public final float m14170l() {
        return this.f11913f;
    }
}
