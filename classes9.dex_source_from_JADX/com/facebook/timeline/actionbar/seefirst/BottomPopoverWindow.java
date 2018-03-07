package com.facebook.timeline.actionbar.seefirst;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.popover.PopoverViewFlipper.NubShown;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: use_payment_engine */
public class BottomPopoverWindow extends PopoverWindow {
    public final ScreenUtil f774a;

    public static BottomPopoverWindow m833b(InjectorLike injectorLike) {
        return new BottomPopoverWindow((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike));
    }

    @Inject
    public BottomPopoverWindow(Context context, ScreenUtil screenUtil) {
        super(context);
        this.f774a = screenUtil;
    }

    protected final void m834a(View view, boolean z, LayoutParams layoutParams) {
        if (z) {
            super.a(view, z, layoutParams);
            return;
        }
        int e;
        a(new ColorDrawable(ContextCompat.b(getContext(), 17170443)));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        int measuredHeight = this.f.getMeasuredHeight();
        layoutParams.windowAnimations = 2131625442;
        layoutParams2.gravity = 81;
        layoutParams.gravity = 81;
        int c = this.f774a.c() / 2;
        measuredHeight /= 2;
        if (VERSION.SDK_INT > 21) {
            e = this.f774a.e() - this.f774a.d();
        } else {
            e = 0;
        }
        layoutParams.y = e;
        this.f.setPadding(0, 0, 0, 0);
        this.f.setNubShown(NubShown.NONE);
        this.f.a(c, measuredHeight);
    }
}
