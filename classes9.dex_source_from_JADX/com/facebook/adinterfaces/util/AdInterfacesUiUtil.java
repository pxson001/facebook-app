package com.facebook.adinterfaces.util;

import android.animation.LayoutTransition;
import android.animation.LayoutTransition.TransitionListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;

/* compiled from: VACUUM */
public class AdInterfacesUiUtil {

    /* compiled from: VACUUM */
    public interface ScrollEndedCallback {
        void mo1007a();
    }

    /* compiled from: VACUUM */
    final class C27531 implements Runnable {
        final /* synthetic */ ScrollView f23249a;
        final /* synthetic */ int f23250b;
        final /* synthetic */ View f23251c;
        final /* synthetic */ int f23252d;
        final /* synthetic */ ScrollEndedCallback f23253e;

        C27531(ScrollView scrollView, int i, View view, int i2, ScrollEndedCallback scrollEndedCallback) {
            this.f23249a = scrollView;
            this.f23250b = i;
            this.f23251c = view;
            this.f23252d = i2;
            this.f23253e = scrollEndedCallback;
        }

        public final void run() {
            final int top = (this.f23250b + this.f23251c.getTop()) - this.f23252d;
            if (this.f23249a.getScrollY() != top) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f23249a.getScrollY(), top});
                ofInt.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ C27531 f23248b;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        this.f23248b.f23249a.scrollTo(0, intValue);
                        this.f23248b.f23249a.invalidate();
                        if (intValue == top && this.f23248b.f23253e != null) {
                            this.f23248b.f23253e.mo1007a();
                        }
                    }
                });
                ofInt.start();
            } else if (this.f23253e != null) {
                this.f23253e.mo1007a();
            }
        }
    }

    /* compiled from: VACUUM */
    final class C27542 implements Runnable {
        final /* synthetic */ View f23254a;

        C27542(View view) {
            this.f23254a = view;
        }

        public final void run() {
            AdInterfacesUiUtil.m25234a(this.f23254a);
        }
    }

    public static void m25234a(View view) {
        m25235a(view, null);
    }

    public static void m25235a(View view, ScrollEndedCallback scrollEndedCallback) {
        ViewParent parent = view.getParent();
        int i = 0;
        while (parent != null && !(parent instanceof ScrollView)) {
            if (parent instanceof View) {
                i += ((View) parent).getTop();
            }
            parent = parent.getParent();
        }
        if (parent instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) parent;
            scrollView.post(new C27531(scrollView, i, view, (int) view.getResources().getDimension(2131429277), scrollEndedCallback));
        }
    }

    public static void m25239b(View view) {
        view.postDelayed(new C27542(view), 500);
    }

    public static void m25237a(ViewGroup viewGroup, int i) {
        if (VERSION.SDK_INT >= 11) {
            LayoutTransition layoutTransition = new LayoutTransition();
            if (VERSION.SDK_INT >= 16) {
                layoutTransition.disableTransitionType(i);
            } else {
                layoutTransition.setStartDelay(i, 0);
                layoutTransition.setDuration(i, 0);
            }
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    public static void m25236a(ViewGroup viewGroup) {
        m25238a(viewGroup, null);
    }

    public static void m25238a(ViewGroup viewGroup, TransitionListener transitionListener) {
        if (VERSION.SDK_INT >= 11) {
            LayoutTransition layoutTransition = new LayoutTransition();
            if (transitionListener != null) {
                layoutTransition.addTransitionListener(transitionListener);
            }
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    public static int m25233a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }
}
