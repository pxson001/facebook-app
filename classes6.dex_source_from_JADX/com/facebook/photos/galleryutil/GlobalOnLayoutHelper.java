package com.facebook.photos.galleryutil;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: highlight_type */
public class GlobalOnLayoutHelper {

    /* compiled from: highlight_type */
    final class C08461 implements OnGlobalLayoutListener {
        final /* synthetic */ Runnable f13001a;
        final /* synthetic */ View f13002b;

        C08461(Runnable runnable, View view) {
            this.f13001a = runnable;
            this.f13002b = view;
        }

        @TargetApi(16)
        public final void onGlobalLayout() {
            this.f13001a.run();
            GlobalOnLayoutHelper.m20351b(this.f13002b, (OnGlobalLayoutListener) this);
        }
    }

    /* compiled from: highlight_type */
    final class C08472 implements OnGlobalLayoutListener {
        final /* synthetic */ View f13003a;
        final /* synthetic */ Runnable f13004b;

        C08472(View view, Runnable runnable) {
            this.f13003a = view;
            this.f13004b = runnable;
        }

        @TargetApi(16)
        public final void onGlobalLayout() {
            if (this.f13003a.getWidth() <= 0 || this.f13003a.getHeight() <= 0) {
                ViewParent parent = this.f13003a.getParent();
                while (parent instanceof View) {
                    parent = ((View) parent).getParent();
                }
                if ((parent != null ? 1 : null) == null) {
                    GlobalOnLayoutHelper.m20351b(this.f13003a, (OnGlobalLayoutListener) this);
                    return;
                }
                return;
            }
            this.f13004b.run();
            GlobalOnLayoutHelper.m20351b(this.f13003a, (OnGlobalLayoutListener) this);
        }
    }

    public static void m20349a(View view, Runnable runnable) {
        m20348a(view, new C08461(runnable, view));
    }

    public static OnGlobalLayoutListener m20350b(View view, Runnable runnable) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return m20352c(view, runnable);
        }
        runnable.run();
        return null;
    }

    public static OnGlobalLayoutListener m20352c(View view, Runnable runnable) {
        OnGlobalLayoutListener c08472 = new C08472(view, runnable);
        m20348a(view, c08472);
        return c08472;
    }

    public static void m20348a(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void m20351b(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (VERSION.SDK_INT >= 16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
