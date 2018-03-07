package com.facebook.ui.toaster;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;

/* compiled from: comment_ufi_opened */
public class ClickableToast {
    private static final String f5494a = ClickableToast.class.getSimpleName();
    private final ClickableToastCoordinator f5495b;
    public final Style f5496c;
    public View f5497d;
    public PopupWindow f5498e;
    public int f5499f = 3000;
    public int f5500g = 16973828;
    private final Runnable f5501h = new C05051(this);
    public View f5502i;
    public final OnTouchListener f5503j = new C05062(this);
    public final OnGlobalLayoutListener f5504k = new C05073(this);

    /* compiled from: comment_ufi_opened */
    class C05051 implements Runnable {
        final /* synthetic */ ClickableToast f5487a;

        C05051(ClickableToast clickableToast) {
            this.f5487a = clickableToast;
        }

        public void run() {
            this.f5487a.m10352b();
        }
    }

    /* compiled from: comment_ufi_opened */
    class C05062 implements OnTouchListener {
        final /* synthetic */ ClickableToast f5488a;

        C05062(ClickableToast clickableToast) {
            this.f5488a = clickableToast;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            ClickableToast.m10350e(this.f5488a);
            Rect rect = new Rect();
            if (view.getTouchDelegate() != null) {
                view.getTouchDelegate().onTouchEvent(motionEvent);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    childAt.getHitRect(rect);
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && childAt.dispatchTouchEvent(motionEvent)) {
                        break;
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: comment_ufi_opened */
    class C05073 implements OnGlobalLayoutListener {
        final /* synthetic */ ClickableToast f5489a;

        C05073(ClickableToast clickableToast) {
            this.f5489a = clickableToast;
        }

        public void onGlobalLayout() {
            this.f5489a.m10353c();
        }
    }

    /* compiled from: comment_ufi_opened */
    /* synthetic */ class C05095 {
        static final /* synthetic */ int[] f5493a = new int[Style.values().length];

        static {
            try {
                f5493a[Style.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5493a[Style.SNACKBAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: comment_ufi_opened */
    public enum Style {
        STANDARD(2131429214, -2, -2),
        SNACKBAR(2131429215, -1, -2);
        
        private final int mHeight;
        private final int mWidth;
        private final int mYOffsetResId;

        private Style(int i, int i2, int i3) {
            this.mYOffsetResId = i;
            this.mWidth = i2;
            this.mHeight = i3;
        }

        public final int getYOffsetResId() {
            return this.mYOffsetResId;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }
    }

    ClickableToast(ClickableToastCoordinator clickableToastCoordinator, Style style) {
        this.f5495b = clickableToastCoordinator;
        this.f5496c = style;
    }

    public final void m10351a() {
        this.f5495b.a(this);
    }

    public final void m10352b() {
        this.f5495b.b(this);
    }

    final void m10353c() {
        Activity activity = (Activity) ContextUtils.a(this.f5497d.getContext(), Activity.class);
        if (activity != null && !activity.isFinishing()) {
            View findViewById;
            if (this.f5502i == null) {
                findViewById = activity.findViewById(16908290);
                if (findViewById == null) {
                    findViewById = activity.getWindow().getDecorView();
                }
            } else {
                findViewById = this.f5502i;
            }
            final View view = findViewById;
            if (this.f5498e == null) {
                this.f5497d.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                this.f5498e = new PopupWindow(this.f5497d, this.f5496c.getWidth(), this.f5496c.getHeight());
                this.f5498e.setAnimationStyle(this.f5500g);
                this.f5497d.setOnTouchListener(this.f5503j);
                final int dimensionPixelOffset = this.f5497d.getResources().getDimensionPixelOffset(this.f5496c.getYOffsetResId());
                view.post(new Runnable(this) {
                    final /* synthetic */ ClickableToast f5492c;

                    public void run() {
                        if (this.f5492c.f5498e != null) {
                            this.f5492c.f5498e.showAtLocation(view, 81, 0, dimensionPixelOffset);
                        }
                    }
                });
                this.f5497d.getViewTreeObserver().addOnGlobalLayoutListener(this.f5504k);
                m10350e(this);
                return;
            }
            switch (C05095.f5493a[this.f5496c.ordinal()]) {
                case 1:
                    this.f5498e.update(this.f5496c.getWidth(), this.f5496c.getHeight());
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    this.f5498e.update(view, 0, -this.f5497d.getHeight(), -1, -1);
                    return;
                default:
                    return;
            }
        }
    }

    final void m10354d() {
        if (this.f5498e != null) {
            try {
                this.f5498e.dismiss();
            } catch (Throwable e) {
                BLog.b(f5494a, "Exception while trying to dismiss the popup window.", e);
            }
        }
        if (VERSION.SDK_INT >= 16) {
            this.f5497d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f5504k);
        } else {
            this.f5497d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f5504k);
        }
        this.f5498e = null;
    }

    public static void m10350e(ClickableToast clickableToast) {
        clickableToast.f5497d.removeCallbacks(clickableToast.f5501h);
        clickableToast.f5497d.postDelayed(clickableToast.f5501h, (long) clickableToast.f5499f);
    }
}
