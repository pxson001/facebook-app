package com.facebook.components.fb.widget;

import com.facebook.components.EventHandler;

/* compiled from: creative_cam_front */
class TouchSpringIconComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f16648a;
    final /* synthetic */ Object f16649b;
    final /* synthetic */ TouchSpringIconComponent f16650c;

    TouchSpringIconComponent$1(TouchSpringIconComponent touchSpringIconComponent, EventHandler eventHandler, Object obj) {
        this.f16650c = touchSpringIconComponent;
        this.f16648a = eventHandler;
        this.f16649b = obj;
    }

    public void run() {
        this.f16650c.a(this.f16648a, this.f16649b);
    }
}
