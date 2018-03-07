package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;

/* compiled from: friend_finder_legal_opened */
public class JSTouchDispatcher {
    private int f11713a = -1;
    private final float[] f11714b = new float[2];
    private boolean f11715c = false;
    private final ViewGroup f11716d;

    public JSTouchDispatcher(ViewGroup viewGroup) {
        this.f11716d = viewGroup;
    }

    public final void m13812a(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (!this.f11715c) {
            m13811c(motionEvent, eventDispatcher);
            this.f11715c = true;
            this.f11713a = -1;
        }
    }

    public final void m13813b(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.f11713a != -1) {
                FLog.b("React", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.f11715c = false;
            this.f11713a = TouchTargetHelper.m13980a(motionEvent.getX(), motionEvent.getY(), this.f11716d, this.f11714b);
            eventDispatcher.m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.START, motionEvent, this.f11714b[0], this.f11714b[1]));
        } else if (!this.f11715c) {
            if (this.f11713a == -1) {
                FLog.b("React", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            } else if (action == 1) {
                eventDispatcher.m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.END, motionEvent, this.f11714b[0], this.f11714b[1]));
                this.f11713a = -1;
            } else if (action == 2) {
                eventDispatcher.m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.MOVE, motionEvent, this.f11714b[0], this.f11714b[1]));
            } else if (action == 5) {
                eventDispatcher.m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.START, motionEvent, this.f11714b[0], this.f11714b[1]));
            } else if (action == 6) {
                eventDispatcher.m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.END, motionEvent, this.f11714b[0], this.f11714b[1]));
            } else if (action == 3) {
                if (TouchEventCoalescingKeyHelper.m14175e(motionEvent.getDownTime())) {
                    m13811c(motionEvent, eventDispatcher);
                } else {
                    FLog.b("React", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
                }
                this.f11713a = -1;
            } else {
                FLog.a("React", "Warning : touch event was ignored. Action=" + action + " Target=" + this.f11713a);
            }
        }
    }

    private void m13811c(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.f11713a == -1) {
            FLog.a("React", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        boolean z;
        if (this.f11715c) {
            z = false;
        } else {
            z = true;
        }
        Assertions.a(z, "Expected to not have already sent a cancel for this gesture");
        ((EventDispatcher) Assertions.b(eventDispatcher)).m14159a(TouchEvent.m14161a(this.f11713a, SystemClock.m13613b(), TouchEventType.CANCEL, motionEvent, this.f11714b[0], this.f11714b[1]));
    }
}
