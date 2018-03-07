package com.facebook.nodes.canvas;

import android.graphics.Canvas;

/* compiled from: threadFolder */
public final class DeferredModeRenderState extends RenderState {
    private static final DeferredModeCanvasProxy f3187a = new DeferredModeCanvasProxy();
    private static final CanvasOperation[] f3188b = new CanvasOperation[0];
    private CanvasOperation[] f3189c = f3188b;

    public final void mo206a() {
        this.f3186a.m4088b(f3187a);
        DeferredModeCanvasProxy deferredModeCanvasProxy = f3187a;
        CanvasOperation[] canvasOperationArr = (CanvasOperation[]) deferredModeCanvasProxy.f3185c.toArray(DeferredModeCanvasProxy.f3184b);
        deferredModeCanvasProxy.f3185c.clear();
        this.f3189c = canvasOperationArr;
    }

    public final void mo207a(Canvas canvas) {
        for (CanvasOperation a : this.f3189c) {
            a.mo188a(canvas);
        }
    }
}
