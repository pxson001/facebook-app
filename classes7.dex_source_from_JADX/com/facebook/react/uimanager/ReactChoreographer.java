package com.facebook.react.uimanager;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayDeque;

/* compiled from: friend_finder_friendable_contacts_page_fetched */
public class ReactChoreographer {
    private static ReactChoreographer f11760a;
    private final Choreographer f11761b = Choreographer.getInstance();
    private final ReactChoreographerDispatcher f11762c = new ReactChoreographerDispatcher(this);
    public final ArrayDeque<FrameCallback>[] f11763d = new ArrayDeque[CallbackType.values().length];
    private int f11764e = 0;
    public boolean f11765f = false;

    /* compiled from: friend_finder_friendable_contacts_page_fetched */
    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3);
        
        private final int mOrder;

        private CallbackType(int i) {
            this.mOrder = i;
        }

        final int getOrder() {
            return this.mOrder;
        }
    }

    /* compiled from: friend_finder_friendable_contacts_page_fetched */
    class ReactChoreographerDispatcher implements FrameCallback {
        final /* synthetic */ ReactChoreographer f11759a;

        public ReactChoreographerDispatcher(ReactChoreographer reactChoreographer) {
            this.f11759a = reactChoreographer;
        }

        public void doFrame(long j) {
            this.f11759a.f11765f = false;
            for (int i = 0; i < this.f11759a.f11763d.length; i++) {
                int size = this.f11759a.f11763d[i].size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((FrameCallback) this.f11759a.f11763d[i].removeFirst()).doFrame(j);
                    this.f11759a.f11764e = this.f11759a.f11764e - 1;
                }
            }
            this.f11759a.f11764e = this.f11759a.f11764e - 1;
        }
    }

    public static ReactChoreographer m13927a() {
        UiThreadUtil.m13554b();
        if (f11760a == null) {
            f11760a = new ReactChoreographer();
        }
        return f11760a;
    }

    private ReactChoreographer() {
        int i = 0;
        while (i < this.f11763d.length) {
            this.f11763d[i] = new ArrayDeque();
            i++;
        }
    }

    public final void m13933a(CallbackType callbackType, FrameCallback frameCallback) {
        UiThreadUtil.m13554b();
        this.f11763d[callbackType.getOrder()].addLast(frameCallback);
        this.f11764e++;
        Assertions.a(this.f11764e > 0);
        if (!this.f11765f) {
            this.f11761b.postFrameCallback(this.f11762c);
            this.f11765f = true;
        }
    }

    public final void m13934b(CallbackType callbackType, FrameCallback frameCallback) {
        UiThreadUtil.m13554b();
        if (this.f11763d[callbackType.getOrder()].removeFirstOccurrence(frameCallback)) {
            this.f11764e--;
            this.f11764e = this.f11764e - 1;
            return;
        }
        FLog.b("React", "Tried to remove non-existent frame callback");
    }

    public static void m13931b(ReactChoreographer reactChoreographer) {
        Assertions.a(reactChoreographer.f11764e >= 0);
        if (reactChoreographer.f11764e == 0 && reactChoreographer.f11765f) {
            reactChoreographer.f11761b.removeFrameCallback(reactChoreographer.f11762c);
            reactChoreographer.f11765f = false;
        }
    }
}
