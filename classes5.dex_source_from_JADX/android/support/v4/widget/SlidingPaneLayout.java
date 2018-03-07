package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: user_actions_session_id */
public class SlidingPaneLayout extends ViewGroup {
    static final SlidingPanelLayoutImpl f520a;
    private int f521b;
    private int f522c;
    public Drawable f523d;
    public Drawable f524e;
    private final int f525f;
    public boolean f526g;
    private View f527h;
    public float f528i;
    private float f529j;
    private int f530k;
    private boolean f531l;
    private int f532m;
    private float f533n;
    private float f534o;
    private PanelSlideListener f535p;
    private final ViewDragHelper f536q;
    private boolean f537r;
    private boolean f538s;
    private final Rect f539t;
    public final ArrayList<DisableLayerRunnable> f540u;

    /* compiled from: user_actions_session_id */
    class DisableLayerRunnable implements Runnable {
        final View f510a;
        final /* synthetic */ SlidingPaneLayout f511b;

        DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
            this.f511b = slidingPaneLayout;
            this.f510a = view;
        }

        public void run() {
            if (this.f510a.getParent() == this.f511b) {
                ViewCompat.a(this.f510a, 0, null);
                SlidingPaneLayout.m1020c(this.f511b, this.f510a);
            }
            this.f511b.f540u.remove(this);
        }
    }

    /* compiled from: user_actions_session_id */
    public class LayoutParams extends MarginLayoutParams {
        private static final int[] f512e = new int[]{16843137};
        public float f513a = 0.0f;
        boolean f514b;
        boolean f515c;
        Paint f516d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f512e);
            this.f513a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: user_actions_session_id */
    public interface PanelSlideListener {
    }

    /* compiled from: user_actions_session_id */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00351();
        boolean f517a;

        /* compiled from: user_actions_session_id */
        final class C00351 implements Creator<SavedState> {
            C00351() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f517a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f517a ? 1 : 0);
        }
    }

    /* compiled from: user_actions_session_id */
    interface SlidingPanelLayoutImpl {
        void mo195a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* compiled from: user_actions_session_id */
    class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        public void mo195a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: user_actions_session_id */
    class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method f518a;
        private Field f519b;

        SlidingPanelLayoutImplJB() {
            try {
                this.f518a = View.class.getDeclaredMethod("getDisplayList", null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f519b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f519b.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public final void mo195a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f518a == null || this.f519b == null) {
                view.invalidate();
                return;
            }
            try {
                this.f519b.setBoolean(view, true);
                this.f518a.invoke(view, null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.mo195a(slidingPaneLayout, view);
        }
    }

    /* compiled from: user_actions_session_id */
    class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        public final void mo195a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.a.a(view, ((LayoutParams) view.getLayoutParams()).f516d);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f520a = new SlidingPanelLayoutImplJBMR1();
        } else if (i >= 16) {
            f520a = new SlidingPanelLayoutImplJB();
        } else {
            f520a = new SlidingPanelLayoutImplBase();
        }
    }

    public void setParallaxDistance(int i) {
        this.f532m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f532m;
    }

    public void setSliderFadeColor(int i) {
        this.f521b = i;
    }

    public int getSliderFadeColor() {
        return this.f521b;
    }

    public void setCoveredFadeColor(int i) {
        this.f522c = i;
    }

    public int getCoveredFadeColor() {
        return this.f522c;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.f535p = panelSlideListener;
    }

    private void m1012a(View view) {
        int paddingLeft;
        int i;
        boolean f = m1023f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (f) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !m1019b(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6;
                int max = Math.max(f ? paddingLeft : width, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    i6 = width;
                } else {
                    i6 = paddingLeft;
                }
                i6 = Math.min(i6, childAt.getRight());
                int min = Math.min(height, childAt.getBottom());
                if (max < i || max2 < r3 || i6 > r4 || min > r2) {
                    i6 = 0;
                } else {
                    i6 = 4;
                }
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    private static boolean m1019b(View view) {
        if (ViewCompat.a.j(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -982378391);
        super.onAttachedToWindow();
        this.f538s = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 88039600, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1708333393);
        super.onDetachedFromWindow();
        this.f538s = true;
        int size = this.f540u.size();
        for (int i = 0; i < size; i++) {
            ((DisableLayerRunnable) this.f540u.get(i)).run();
        }
        this.f540u.clear();
        LogUtils.g(1665532309, a);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (isInEditMode()) {
            if (mode != Integer.MIN_VALUE && mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f527h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f515c = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (layoutParams.f513a > 0.0f) {
                    f += layoutParams.f513a;
                    if (layoutParams.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i8 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                layoutParams.f514b = z3;
                z3 |= z;
                if (layoutParams.f514b) {
                    this.f527h = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f525f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.f513a <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f527h) {
                            if (layoutParams.f513a > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.f513a * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i8 > i9 || layoutParams.f513a > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.f526g = z;
        if (this.f536q.m1044a() != 0 && !z) {
            this.f536q.m1056f();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = m1023f();
        if (f) {
            this.f536q.m1045a(2);
        } else {
            this.f536q.m1045a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f538s) {
            float f2 = (this.f526g && this.f537r) ? 1.0f : 0.0f;
            this.f528i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = 0;
                if (layoutParams.f514b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f525f) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f530k = min;
                    i8 = f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f515c = ((i7 + i8) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i9 = (int) (((float) min) * this.f528i);
                    i10 = i7 + (i8 + i9);
                    this.f528i = ((float) i9) / ((float) this.f530k);
                } else {
                    if (!this.f526g || this.f532m == 0) {
                        i9 = 0;
                    } else {
                        i9 = (int) ((1.0f - this.f528i) * ((float) this.f532m));
                    }
                    i11 = i9;
                    i10 = paddingRight;
                }
                if (f) {
                    i8 = (i5 - i10) + i11;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i10 - i11;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i9 = childAt.getWidth() + paddingRight;
                i8 = i10;
            } else {
                i9 = paddingRight;
                i8 = i7;
            }
            i6++;
            paddingRight = i9;
            i7 = i8;
        }
        if (this.f538s) {
            if (this.f526g) {
                if (this.f532m != 0) {
                    m1016b(this.f528i);
                }
                if (((LayoutParams) this.f527h.getLayoutParams()).f515c) {
                    m1013a(this.f527h, this.f528i, this.f521b);
                }
            } else {
                for (i9 = 0; i9 < childCount; i9++) {
                    m1013a(getChildAt(i9), 0.0f, this.f521b);
                }
            }
            m1012a(this.f527h);
        }
        this.f538s = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1956460952);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f538s = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2039144258, a);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f526g) {
            this.f537r = view == this.f527h;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.MotionEventCompat.a(r8);
        r0 = r7.f526g;
        if (r0 != 0) goto L_0x002b;
    L_0x000a:
        if (r3 != 0) goto L_0x002b;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002b;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r4 = r8.getX();
        r4 = (int) r4;
        r5 = r8.getY();
        r5 = (int) r5;
        r0 = android.support.v4.widget.ViewDragHelper.m1039b(r0, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0028:
        r0 = r1;
    L_0x0029:
        r7.f537r = r0;
    L_0x002b:
        r0 = r7.f526g;
        if (r0 == 0) goto L_0x0035;
    L_0x002f:
        r0 = r7.f531l;
        if (r0 == 0) goto L_0x0041;
    L_0x0033:
        if (r3 == 0) goto L_0x0041;
    L_0x0035:
        r0 = r7.f536q;
        r0.m1055e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x003e:
        return r2;
    L_0x003f:
        r0 = r2;
        goto L_0x0029;
    L_0x0041:
        r0 = 3;
        if (r3 == r0) goto L_0x0046;
    L_0x0044:
        if (r3 != r1) goto L_0x004c;
    L_0x0046:
        r0 = r7.f536q;
        r0.m1055e();
        goto L_0x003e;
    L_0x004c:
        switch(r3) {
            case 0: goto L_0x005c;
            case 1: goto L_0x004f;
            case 2: goto L_0x007e;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r2;
    L_0x0050:
        r3 = r7.f536q;
        r3 = r3.m1048a(r8);
        if (r3 != 0) goto L_0x005a;
    L_0x0058:
        if (r0 == 0) goto L_0x003e;
    L_0x005a:
        r2 = r1;
        goto L_0x003e;
    L_0x005c:
        r7.f531l = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f533n = r0;
        r7.f534o = r3;
        r4 = r7.f527h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = android.support.v4.widget.ViewDragHelper.m1039b(r4, r0, r3);
        if (r0 == 0) goto L_0x004f;
    L_0x0074:
        r0 = r7.f527h;
        r0 = r7.m1022d(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x007c:
        r0 = r1;
        goto L_0x0050;
    L_0x007e:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f533n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f534o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f536q;
        r6 = r4.f551b;
        r4 = r6;
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x004f;
    L_0x009e:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004f;
    L_0x00a2:
        r0 = r7.f536q;
        r0.m1055e();
        r7.f531l = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1633995346);
        if (this.f526g) {
            this.f536q.m1053b(motionEvent);
            float x;
            float y;
            switch (motionEvent.getAction() & 255) {
                case 0:
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    this.f533n = x;
                    this.f534o = y;
                    break;
                case 1:
                    if (m1022d(this.f527h)) {
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        float f = x - this.f533n;
                        float f2 = y - this.f534o;
                        int i = this.f536q.f551b;
                        if ((f * f) + (f2 * f2) < ((float) (i * i)) && ViewDragHelper.m1039b(this.f527h, (int) x, (int) y)) {
                            m1015a(0);
                            break;
                        }
                    }
                    break;
            }
            LogUtils.a(682723317, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 150836500, a);
        return onTouchEvent;
    }

    private boolean m1015a(int i) {
        if (!this.f538s && !m1014a(0.0f)) {
            return false;
        }
        this.f537r = false;
        return true;
    }

    private boolean m1018b(int i) {
        if (!this.f538s && !m1014a(1.0f)) {
            return false;
        }
        this.f537r = true;
        return true;
    }

    private boolean m1017b() {
        return m1018b(0);
    }

    private boolean m1021c() {
        return m1015a(0);
    }

    private void m1013a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f516d == null) {
                layoutParams.f516d = new Paint();
            }
            layoutParams.f516d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ViewCompat.g(view) != 2) {
                ViewCompat.a(view, 2, layoutParams.f516d);
            }
            m1020c(this, view);
        } else if (ViewCompat.g(view) != 0) {
            if (layoutParams.f516d != null) {
                layoutParams.f516d.setColorFilter(null);
            }
            Runnable disableLayerRunnable = new DisableLayerRunnable(this, view);
            this.f540u.add(disableLayerRunnable);
            ViewCompat.a(this, disableLayerRunnable);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f526g || layoutParams.f514b || this.f527h == null)) {
            canvas.getClipBounds(this.f539t);
            if (m1023f()) {
                this.f539t.left = Math.max(this.f539t.left, this.f527h.getRight());
            } else {
                this.f539t.right = Math.min(this.f539t.right, this.f527h.getLeft());
            }
            canvas.clipRect(this.f539t);
        }
        if (VERSION.SDK_INT < 11) {
            if (layoutParams.f515c && this.f528i > 0.0f) {
                if (!view.isDrawingCacheEnabled()) {
                    view.setDrawingCacheEnabled(true);
                }
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.f516d);
                    z = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                    z = super.drawChild(canvas, view, j);
                }
                canvas.restoreToCount(save);
                return z;
            } else if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
        }
        z = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return z;
    }

    public static void m1020c(SlidingPaneLayout slidingPaneLayout, View view) {
        f520a.mo195a(slidingPaneLayout, view);
    }

    private boolean m1014a(float f) {
        if (!this.f526g) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.f527h.getLayoutParams();
        if (m1023f()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f530k) * f)) + ((float) this.f527h.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f530k) * f));
        }
        if (!this.f536q.m1049a(this.f527h, width, this.f527h.getTop())) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
        ViewCompat.d(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f536q.m1050a(true)) {
            return;
        }
        if (this.f526g) {
            ViewCompat.d(this);
        } else {
            this.f536q.m1056f();
        }
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        this.f523d = getResources().getDrawable(i);
    }

    public void setShadowResourceLeft(int i) {
        this.f523d = getResources().getDrawable(i);
    }

    public void setShadowResourceRight(int i) {
        this.f524e = getResources().getDrawable(i);
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (m1023f()) {
            drawable = this.f524e;
        } else {
            drawable = this.f523d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m1023f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void m1016b(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        float f2;
        boolean f3 = m1023f();
        LayoutParams layoutParams = (LayoutParams) this.f527h.getLayoutParams();
        if (layoutParams.f515c) {
            if ((f3 ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt != this.f527h) {
                        i2 = (int) ((1.0f - this.f529j) * ((float) this.f532m));
                        this.f529j = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.f532m));
                        if (f3) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            if (f3) {
                                f2 = 1.0f - this.f529j;
                            } else {
                                f2 = this.f529j - 1.0f;
                            }
                            m1013a(childAt, f2, this.f522c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt != this.f527h) {
                i2 = (int) ((1.0f - this.f529j) * ((float) this.f532m));
                this.f529j = f;
                i2 -= (int) ((1.0f - f) * ((float) this.f532m));
                if (f3) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f3) {
                        f2 = 1.0f - this.f529j;
                    } else {
                        f2 = this.f529j - 1.0f;
                    }
                    m1013a(childAt, f2, this.f522c);
                }
            }
        }
    }

    private boolean m1022d(View view) {
        if (view == null) {
            return false;
        }
        return this.f526g && ((LayoutParams) view.getLayoutParams()).f515c && this.f528i > 0.0f;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        boolean z;
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.f526g) {
            boolean z2;
            if (!this.f526g || this.f528i == 1.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        } else {
            z = this.f537r;
        }
        savedState.f517a = z;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f517a) {
            m1017b();
        } else {
            m1021c();
        }
        this.f537r = savedState.f517a;
    }

    private boolean m1023f() {
        return ViewCompat.h(this) == 1;
    }
}
