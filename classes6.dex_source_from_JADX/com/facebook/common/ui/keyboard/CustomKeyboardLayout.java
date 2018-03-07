package com.facebook.common.ui.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_picker_nonintrusive_error_gms_upsell_result */
public class CustomKeyboardLayout extends FrameLayout {
    private SoftInputDetector f7759a;
    private Resources f7760b;
    private int f7761c;
    private int f7762d;
    private int f7763e;
    private int f7764f;
    private int f7765g;
    public OnCoverListener f7766h;
    private boolean f7767i;
    public int f7768j;
    public CustomKeyboardHandler f7769k;
    private OnGlobalFocusChangeListener f7770l;

    /* compiled from: place_picker_nonintrusive_error_gms_upsell_result */
    class C04591 implements OnGlobalFocusChangeListener {
        final /* synthetic */ CustomKeyboardLayout f7757a;

        C04591(CustomKeyboardLayout customKeyboardLayout) {
            this.f7757a = customKeyboardLayout;
        }

        public void onGlobalFocusChanged(@Nullable View view, View view2) {
            if (!CustomKeyboardLayout.m11090c(this.f7757a)) {
                this.f7757a.f7769k.removeMessages(1001);
            } else if (!this.f7757a.f7769k.hasMessages(1001)) {
                this.f7757a.f7769k.sendMessageDelayed(Message.obtain(this.f7757a.f7769k, 1001), 500);
            }
        }
    }

    /* compiled from: place_picker_nonintrusive_error_gms_upsell_result */
    class CustomKeyboardHandler extends Handler {
        private final WeakReference<CustomKeyboardLayout> f7758a;

        public CustomKeyboardHandler(CustomKeyboardLayout customKeyboardLayout) {
            this.f7758a = new WeakReference(customKeyboardLayout);
        }

        public void handleMessage(Message message) {
            CustomKeyboardLayout customKeyboardLayout = (CustomKeyboardLayout) this.f7758a.get();
            if (customKeyboardLayout != null && message.what == 1001) {
                CustomKeyboardLayout.setIsCovered(customKeyboardLayout, true);
            }
        }
    }

    /* compiled from: place_picker_nonintrusive_error_gms_upsell_result */
    public interface OnCoverListener {
        void m11082a();
    }

    private static <T extends View> void m11085a(Class<T> cls, T t) {
        m11086a((Object) t, t.getContext());
    }

    private static void m11086a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CustomKeyboardLayout) obj).m11084a(SoftInputDetector.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    public CustomKeyboardLayout(Context context) {
        super(context);
        m11089b();
    }

    public CustomKeyboardLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomKeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomKeyboardLayout, i, 0);
        this.f7765g = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        obtainStyledAttributes.recycle();
        m11089b();
    }

    private void m11089b() {
        m11085a(CustomKeyboardLayout.class, (View) this);
        m11091d();
        this.f7761c = this.f7760b.getConfiguration().orientation;
        this.f7770l = new C04591(this);
    }

    @Inject
    private void m11084a(SoftInputDetector softInputDetector, Resources resources) {
        this.f7759a = softInputDetector;
        this.f7760b = resources;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1853947861);
        super.onAttachedToWindow();
        this.f7769k = new CustomKeyboardHandler(this);
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f7770l);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -497721267, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -194459980);
        if (this.f7769k != null) {
            this.f7769k.removeMessages(1001);
            this.f7769k = null;
        }
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f7770l);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 941994996, a);
    }

    public void setOnCoverListener(@Nullable OnCoverListener onCoverListener) {
        this.f7766h = onCoverListener;
    }

    public static boolean m11090c(CustomKeyboardLayout customKeyboardLayout) {
        return customKeyboardLayout.f7759a.f;
    }

    public final void m11093a() {
        if (m11090c(this)) {
            setIsCovered(this, true);
        } else if (this.f7769k != null && !this.f7769k.hasMessages(1001)) {
            this.f7769k.sendMessageDelayed(Message.obtain(this.f7769k, 1001), 500);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = this.f7760b.getConfiguration().orientation;
        if (i3 != this.f7761c) {
            m11091d();
            this.f7761c = i3;
        }
        i3 = MeasureSpec.getSize(i2);
        boolean c = m11090c(this);
        if (c || !m11092e()) {
            if (c) {
                this.f7764f = this.f7759a.e;
                setIsCovered(this, true);
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, 1073741824));
            setMeasuredDimension(0, 0);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            int min = Math.min(Math.max(this.f7762d, this.f7764f), this.f7763e) + this.f7768j;
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(min, i3 - this.f7765g);
            } else {
                i3 = min;
            }
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(Math.max(i3, 0), 1073741824));
        setIsCovered(this, false);
    }

    public void setAdditionalHeight(int i) {
        this.f7768j = i;
    }

    public static void setIsCovered(CustomKeyboardLayout customKeyboardLayout, boolean z) {
        if (z != customKeyboardLayout.f7767i) {
            customKeyboardLayout.f7767i = z;
            if (customKeyboardLayout.f7769k != null) {
                customKeyboardLayout.f7769k.removeMessages(1001);
            }
            if (z && customKeyboardLayout.f7766h != null) {
                customKeyboardLayout.f7766h.m11082a();
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!m11090c(this)) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!m11090c(this)) {
            super.dispatchDraw(canvas);
        }
    }

    private void m11091d() {
        this.f7762d = this.f7760b.getDimensionPixelSize(2131427588);
        this.f7763e = this.f7760b.getDimensionPixelSize(2131427589);
    }

    private boolean m11092e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
