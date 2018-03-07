package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: first_count */
public class ReactViewGroup extends ViewGroup implements ReactHitSlopView, ReactInterceptingViewGroup, ReactPointerEventsView, ReactClippingViewGroup {
    private static final LayoutParams f11960a = new LayoutParams(0, 0);
    private static final Rect f11961b = new Rect();
    private boolean f11962c = false;
    @Nullable
    private View[] f11963d = null;
    public int f11964e;
    @Nullable
    private Rect f11965f;
    @Nullable
    public Rect f11966g;
    public PointerEvents f11967h = PointerEvents.AUTO;
    @Nullable
    private ChildrenLayoutChangeListener f11968i;
    @Nullable
    private ReactViewBackgroundDrawable f11969j;
    @Nullable
    private OnInterceptTouchEventListener f11970k;
    public boolean f11971l = false;

    /* compiled from: first_count */
    final class ChildrenLayoutChangeListener implements OnLayoutChangeListener {
        private final ReactViewGroup f11959a;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.f11959a = reactViewGroup;
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f11959a.getRemoveClippedSubviews()) {
                ReactViewGroup.m14223b(this.f11959a, view);
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.m13859a(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.f11969j != null) {
            getOrCreateReactViewBackground().m14214a(i);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setTranslucentBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackground(null);
        if (this.f11969j != null && drawable != null) {
            super.setBackground(new LayerDrawable(new Drawable[]{this.f11969j, drawable}));
        } else if (drawable != null) {
            super.setBackground(drawable);
        }
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.f11970k = onInterceptTouchEventListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((this.f11970k != null && this.f11970k.mo732a(this, motionEvent)) || this.f11967h == PointerEvents.NONE || this.f11967h == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1297029251);
        if (this.f11967h == PointerEvents.NONE || this.f11967h == PointerEvents.BOX_NONE) {
            Logger.a(2, EntryType.UI_INPUT_END, -1702743922, a);
            return false;
        }
        LogUtils.a(400799890, a);
        return true;
    }

    public boolean hasOverlappingRendering() {
        return this.f11971l;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.f11971l = z;
    }

    public final void m14229a(int i, float f) {
        getOrCreateReactViewBackground().m14215a(i, f);
    }

    public final void m14234b(int i, float f) {
        getOrCreateReactViewBackground().m14217b(i, f);
    }

    public void setBorderRadius(float f) {
        getOrCreateReactViewBackground().m14212a(f);
    }

    public final void m14228a(float f, int i) {
        getOrCreateReactViewBackground().m14213a(f, i);
    }

    public void setBorderStyle(@Nullable String str) {
        getOrCreateReactViewBackground().m14216a(str);
    }

    public void setRemoveClippedSubviews(boolean z) {
        int i = 0;
        if (z != this.f11962c) {
            this.f11962c = z;
            if (z) {
                this.f11965f = new Rect();
                ReactClippingViewGroupHelper.m14201a(this, this.f11965f);
                this.f11964e = getChildCount();
                this.f11963d = new View[Math.max(12, this.f11964e)];
                this.f11968i = new ChildrenLayoutChangeListener(this);
                while (i < this.f11964e) {
                    View childAt = getChildAt(i);
                    this.f11963d[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.f11968i);
                    i++;
                }
                mo757a();
                return;
            }
            Assertions.b(this.f11965f);
            Assertions.b(this.f11963d);
            Assertions.b(this.f11968i);
            for (int i2 = 0; i2 < this.f11964e; i2++) {
                this.f11963d[i2].removeOnLayoutChangeListener(this.f11968i);
            }
            getDrawingRect(this.f11965f);
            m14221b(this.f11965f);
            this.f11963d = null;
            this.f11965f = null;
            this.f11964e = 0;
            this.f11968i = null;
        }
    }

    public boolean getRemoveClippedSubviews() {
        return this.f11962c;
    }

    public final void mo758a(Rect rect) {
        rect.set(this.f11965f);
    }

    public final void mo757a() {
        if (this.f11962c) {
            Assertions.b(this.f11965f);
            Assertions.b(this.f11963d);
            ReactClippingViewGroupHelper.m14201a(this, this.f11965f);
            m14221b(this.f11965f);
        }
    }

    private void m14221b(Rect rect) {
        int i = 0;
        Assertions.b(this.f11963d);
        int i2 = 0;
        while (i < this.f11964e) {
            m14218a(rect, i, i2);
            if (this.f11963d[i].getParent() == null) {
                i2++;
            }
            i++;
        }
    }

    private void m14218a(Rect rect, int i, int i2) {
        boolean z = true;
        View view = ((View[]) Assertions.b(this.f11963d))[i];
        f11961b.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean intersects = rect.intersects(f11961b.left, f11961b.top, f11961b.right, f11961b.bottom);
        Animation animation = view.getAnimation();
        boolean z2 = (animation == null || animation.hasEnded()) ? false : true;
        if (!intersects && view.getParent() != null && !z2) {
            super.removeViewsInLayout(i - i2, 1);
        } else if (intersects && view.getParent() == null) {
            super.addViewInLayout(view, i - i2, f11960a, true);
            invalidate();
        } else if (!intersects) {
            z = false;
        }
        if (z && (view instanceof ReactClippingViewGroup)) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.mo757a();
            }
        }
    }

    public static void m14223b(ReactViewGroup reactViewGroup, View view) {
        int i = 0;
        if (reactViewGroup.f11962c && reactViewGroup.getParent() != null) {
            Assertions.b(reactViewGroup.f11965f);
            Assertions.b(reactViewGroup.f11963d);
            f11961b.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (reactViewGroup.f11965f.intersects(f11961b.left, f11961b.top, f11961b.right, f11961b.bottom) != (view.getParent() != null)) {
                int i2 = 0;
                while (i < reactViewGroup.f11964e) {
                    if (reactViewGroup.f11963d[i] == view) {
                        reactViewGroup.m14218a(reactViewGroup.f11965f, i, i2);
                        return;
                    }
                    if (reactViewGroup.f11963d[i].getParent() == null) {
                        i2++;
                    }
                    i++;
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 234321197);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f11962c) {
            mo757a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1874857776, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1104786157);
        super.onAttachedToWindow();
        if (this.f11962c) {
            mo757a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1784533721, a);
    }

    public PointerEvents getPointerEvents() {
        return this.f11967h;
    }

    protected void dispatchSetPressed(boolean z) {
    }

    void setPointerEvents(PointerEvents pointerEvents) {
        this.f11967h = pointerEvents;
    }

    int getAllChildrenCount() {
        return this.f11964e;
    }

    final View m14226a(int i) {
        return ((View[]) Assertions.b(this.f11963d))[i];
    }

    final void m14232a(View view, int i) {
        m14222b(view, i);
    }

    private void m14222b(View view, int i) {
        int i2 = 0;
        Assertions.a(this.f11962c);
        Assertions.b(this.f11965f);
        Assertions.b(this.f11963d);
        m14225c(view, i);
        for (int i3 = 0; i3 < i; i3++) {
            if (this.f11963d[i3].getParent() == null) {
                i2++;
            }
        }
        m14218a(this.f11965f, i, i2);
        view.addOnLayoutChangeListener(this.f11968i);
    }

    final void m14231a(View view) {
        int i = 0;
        Assertions.a(this.f11962c);
        Assertions.b(this.f11965f);
        Assertions.b(this.f11963d);
        view.removeOnLayoutChangeListener(this.f11968i);
        int c = m14224c(view);
        if (this.f11963d[c].getParent() != null) {
            for (int i2 = 0; i2 < c; i2++) {
                if (this.f11963d[i2].getParent() == null) {
                    i++;
                }
            }
            super.removeViewsInLayout(c - i, 1);
        }
        m14220b(c);
    }

    final void m14233b() {
        Assertions.a(this.f11962c);
        Assertions.b(this.f11963d);
        for (int i = 0; i < this.f11964e; i++) {
            this.f11963d[i].removeOnLayoutChangeListener(this.f11968i);
        }
        removeAllViewsInLayout();
        this.f11964e = 0;
    }

    private int m14224c(View view) {
        int i = this.f11964e;
        View[] viewArr = (View[]) Assertions.b(this.f11963d);
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void m14225c(View view, int i) {
        View[] viewArr = (View[]) Assertions.b(this.f11963d);
        int i2 = this.f11964e;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                this.f11963d = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.f11963d, 0, length);
                viewArr = this.f11963d;
            }
            i2 = this.f11964e;
            this.f11964e = i2 + 1;
            viewArr[i2] = view;
        } else if (i < i2) {
            if (length == i2) {
                this.f11963d = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.f11963d, 0, i);
                System.arraycopy(viewArr, i, this.f11963d, i + 1, i2 - i);
                viewArr = this.f11963d;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.f11964e++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        }
    }

    private void m14220b(int i) {
        View[] viewArr = (View[]) Assertions.b(this.f11963d);
        int i2 = this.f11964e;
        if (i == i2 - 1) {
            i2 = this.f11964e - 1;
            this.f11964e = i2;
            viewArr[i2] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            i2 = this.f11964e - 1;
            this.f11964e = i2;
            viewArr[i2] = null;
        }
    }

    @VisibleForTesting
    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).f11956m;
        }
        return 0;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.f11969j == null) {
            this.f11969j = new ReactViewBackgroundDrawable();
            Drawable background = getBackground();
            super.setBackground(null);
            if (background == null) {
                super.setBackground(this.f11969j);
            } else {
                super.setBackground(new LayerDrawable(new Drawable[]{this.f11969j, background}));
            }
        }
        return this.f11969j;
    }

    @Nullable
    public Rect getHitSlopRect() {
        return this.f11966g;
    }

    public void setHitSlopRect(@Nullable Rect rect) {
        this.f11966g = rect;
    }
}
