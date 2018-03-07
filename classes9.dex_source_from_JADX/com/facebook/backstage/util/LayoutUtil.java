package com.facebook.backstage.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: removeMemberParams */
public class LayoutUtil {

    /* compiled from: removeMemberParams */
    public final class C05902 implements OnGlobalLayoutListener {
        final /* synthetic */ View f5581a;
        final /* synthetic */ Runnable f5582b;

        public C05902(View view, Runnable runnable) {
            this.f5581a = view;
            this.f5582b = runnable;
        }

        @TargetApi(16)
        public final void onGlobalLayout() {
            if (this.f5581a.getWidth() > 0 && this.f5581a.getHeight() > 0) {
                this.f5582b.run();
                View view = this.f5581a;
                if (VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        }
    }
}
