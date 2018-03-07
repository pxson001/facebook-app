package com.facebook.universalfeedback.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager.LayoutParams;
import com.facebook.fbui.popover.PopoverWindow;

/* compiled from: edit_gallery_controller_state */
public class UniversalFeedbackPopoverWindow extends PopoverWindow {
    public int f15384a = -1;

    public UniversalFeedbackPopoverWindow(Context context) {
        super(context);
    }

    protected final int m19410g() {
        return 2130907596;
    }

    protected final void m19407a(View view, boolean z, LayoutParams layoutParams) {
        super.a(view, z, layoutParams);
        if (layoutParams.width == -1) {
            layoutParams.width = this.f15384a;
        }
    }

    public final void m19408d(View view) {
        ((UniversalFeedbackPopoverViewFlipper) this.f).setContentViewPreservingLayout(view);
    }

    public final void m19409e(View view) {
        ((UniversalFeedbackPopoverViewFlipper) this.f).m19405b(view);
    }

    protected final OnGlobalLayoutListener m19411k() {
        final OnGlobalLayoutListener k = super.k();
        return new OnGlobalLayoutListener(this) {
            final /* synthetic */ UniversalFeedbackPopoverWindow f15383b;

            public void onGlobalLayout() {
                ((UniversalFeedbackPopoverViewFlipper) this.f15383b.f).m19406g();
                k.onGlobalLayout();
            }
        };
    }
}
