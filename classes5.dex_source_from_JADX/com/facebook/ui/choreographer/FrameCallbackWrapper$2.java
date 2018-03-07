package com.facebook.ui.choreographer;

/* compiled from: community_editor_mobile */
class FrameCallbackWrapper$2 implements Runnable {
    final /* synthetic */ FrameCallbackWrapper f5426a;

    FrameCallbackWrapper$2(FrameCallbackWrapper frameCallbackWrapper) {
        this.f5426a = frameCallbackWrapper;
    }

    public void run() {
        this.f5426a.a(System.nanoTime());
    }
}
