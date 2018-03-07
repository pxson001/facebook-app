package com.facebook.nodes;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;
import com.facebook.nodes.canvas.DrawViewCanvasOperation;

/* compiled from: thread_background_color */
public class ViewNode extends Node {
    private final View f3179a;

    public ViewNode(View view) {
        if (view == null) {
            throw new IllegalStateException("Wrapped view inside a ViewNode cannot be null");
        }
        this.f3179a = view;
        this.f3179a.setTag(2131558567, this);
    }

    public final void mo205a(LayoutParams layoutParams) {
        super.mo205a(layoutParams);
        this.f3179a.setLayoutParams(layoutParams);
    }

    protected final void mo184a(int i, int i2) {
        if (this.f3179a.getVisibility() != 8) {
            this.f3179a.measure(i, i2);
            m4091c(this.f3179a.getMeasuredWidth(), this.f3179a.getMeasuredHeight());
            return;
        }
        super.mo184a(i, i2);
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        if (this.f3179a.getVisibility() != 8) {
            this.f3179a.layout(i, i2, i3, i4);
        }
    }

    protected final void mo177a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        if (this.f3179a.getVisibility() != 8) {
            deferredModeCanvasProxy.m4235a(new DrawViewCanvasOperation(this.f3077h, this.f3078i, this.f3179a));
        }
    }

    public final int mo204d() {
        return this.f3179a.getBaseline();
    }

    public final void mo176a(BaseThreadingModel baseThreadingModel) {
        BaseThreadingModel baseThreadingModel2 = this.f3086q;
        if (baseThreadingModel2 != null) {
            baseThreadingModel2.f3065a.removeView(this.f3179a);
        }
        if (baseThreadingModel != null) {
            baseThreadingModel.f3065a.addView(this.f3179a);
        }
        super.mo176a(baseThreadingModel);
    }
}
