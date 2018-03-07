package com.facebook.debug.debugoverlay;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

/* compiled from: sync_device_id */
class DebugOverlayController$2 implements Runnable {
    final /* synthetic */ DebugOverlayTag f2575a;
    final /* synthetic */ String f2576b;
    final /* synthetic */ DebugOverlayController f2577c;

    DebugOverlayController$2(DebugOverlayController debugOverlayController, DebugOverlayTag debugOverlayTag, String str) {
        this.f2577c = debugOverlayController;
        this.f2575a = debugOverlayTag;
        this.f2576b = str;
    }

    public void run() {
        DebugOverlayController debugOverlayController = this.f2577c;
        if (debugOverlayController.g == null) {
            View debugOverlayLogView = new DebugOverlayLogView(debugOverlayController.c);
            LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 24, -3);
            layoutParams.gravity = 51;
            debugOverlayController.b.addView(debugOverlayLogView, layoutParams);
            debugOverlayController.g = debugOverlayLogView;
        }
        this.f2577c.g.m2969a(this.f2575a, this.f2576b);
    }
}
