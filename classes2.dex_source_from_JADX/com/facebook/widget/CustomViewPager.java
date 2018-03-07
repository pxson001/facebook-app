package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;
import com.facebook.fbui.draggable.ScrollabilityCompatUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: rtt */
public class CustomViewPager extends ViewPager implements HorizontalScrollAwareView, FbCustomViewGroup {
    public boolean f6372a = true;
    private boolean f6373b = true;
    private boolean f6374c = false;
    private OnAttachStateChangeListener f6375d;

    /* compiled from: rtt */
    public interface OnAttachStateChangeListener {
        void mo1718a();

        void mo1719b();
    }

    public CustomViewPager(Context context) {
        super(context);
        m10773a(context, null);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10773a(context, attributeSet);
    }

    private void m10773a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomViewPager);
            this.f6372a = obtainStyledAttributes.getBoolean(0, true);
            this.f6373b = obtainStyledAttributes.getBoolean(2, true);
            this.f6374c = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.f6375d = onAttachStateChangeListener;
    }

    public boolean getInitializeHeightToFirstItem() {
        return this.f6374c;
    }

    protected int getMeasuredHeightOfFirstItem() {
        View childAt = getChildAt(0);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        if (m10774c(measuredHeight)) {
            return measuredHeight;
        }
        childAt.measure(MeasureSpec.makeMeasureSpec((measuredWidth - getPaddingLeft()) - getPaddingRight(), Integer.MIN_VALUE), 0);
        return childAt.getMeasuredHeight();
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("CustomViewPager.onMeasure", 1935601534);
        try {
            super.onMeasure(i, i2);
            if (!this.f6374c || getVisibility() == 8 || getChildCount() == 0) {
                TracerDetour.a(-940022743);
                return;
            }
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (m10774c(measuredHeight)) {
                setMeasuredDimension(getMeasuredWidth(), measuredHeight + paddingTop);
                TracerDetour.a(1186854203);
                return;
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(getMeasuredHeightOfFirstItem() + paddingTop, 1073741824));
            TracerDetour.a(-1264335834);
        } catch (Throwable th) {
            TracerDetour.a(-524895099);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -72608478);
        super.onDetachedFromWindow();
        if (this.f6375d != null) {
            this.f6375d.mo1719b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1937009758, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1771698438);
        super.onAttachedToWindow();
        if (this.f6375d != null) {
            this.f6375d.mo1718a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1813742764, a);
    }

    public void mo1482b(int i, boolean z) {
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        this.f6374c = z;
        setLayoutParams(layoutParams);
    }

    public void setIsSwipingEnabled(boolean z) {
        this.f6372a = z;
    }

    public boolean getIsSwipingEnabled() {
        return this.f6372a;
    }

    public void setAllowDpadPaging(boolean z) {
        this.f6373b = z;
    }

    public boolean getAllowDpadPaging() {
        return this.f6373b;
    }

    public boolean mo1486a(Direction direction, int i, int i2) {
        return this.f6372a && getAdapter() != null && ((direction == Direction.RIGHT && this.f6409k > 0) || (direction == Direction.LEFT && this.f6409k < getAdapter().mo1711b() - 1));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 228490916);
        if (this.f6372a) {
            try {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                Logger.a(2, EntryType.UI_INPUT_END, 836576614, a);
                return onTouchEvent;
            } catch (Throwable e) {
                BLog.b(CustomViewPager.class, "ViewPager threw an IllegalArgumentException. ", e);
            }
        }
        LogUtils.a(1419761789, a);
        return false;
    }

    protected final boolean mo1485a(View view, boolean z, int i, int i2, int i3) {
        return ScrollabilityCompatUtils.a((ViewGroup) view, i > 0 ? Direction.RIGHT : Direction.LEFT, i2, i3);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6372a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Throwable e) {
                BLog.b(CustomViewPager.class, "ViewPager threw an IllegalArgumentException. ", e);
            }
        }
        return false;
    }

    public void detachRecyclableViewFromParent(View view) {
        super.detachViewFromParent(view);
        requestLayout();
    }

    public void attachRecyclableViewToParent(View view, int i, LayoutParams layoutParams) {
        if (!(view instanceof IViewAttachAware) || !RecyclableViewHelper.a(this, view, i)) {
            super.attachViewToParent(view, i, layoutParams);
            requestLayout();
        }
    }

    public void removeRecyclableViewFromParent(View view, boolean z) {
        super.removeDetachedView(view, z);
    }

    public final boolean mo1484a(int i) {
        boolean z = false;
        if (this.f6373b) {
            return super.mo1484a(i);
        }
        Object b = mo1487b(this.f6409k);
        if (b == null) {
            BLog.b("CustomViewPager", "arrowScroll tried to scroll when there was no current child.");
            return false;
        }
        View view;
        View findFocus = findFocus();
        if (findFocus == b) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent;
                int i2;
                for (parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == b) {
                        i2 = 1;
                        break;
                    }
                }
                boolean z2 = false;
                if (i2 == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                        stringBuilder.append(" => ").append(parent.getClass().getSimpleName());
                    }
                    BLog.b("CustomViewPager", "arrowScroll tried to find focus based on non-child current focused view %s", new Object[]{stringBuilder.toString()});
                    view = null;
                }
            }
            view = findFocus;
        }
        if (b instanceof ViewGroup) {
            boolean z3;
            View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) b, view, i);
            if (findNextFocus == null || findNextFocus == view) {
                z3 = false;
            } else {
                z3 = findNextFocus.requestFocus();
            }
            z = z3;
        } else if (!b.hasFocus()) {
            z = b.requestFocus();
        }
        if (!z) {
            return z;
        }
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        return z;
    }

    @Nullable
    public final View mo1487b(int i) {
        if (getAdapter() == null) {
            return null;
        }
        View[] sortedChildren = getSortedChildren();
        int a = m10772a(sortedChildren);
        if (a == -1) {
            return null;
        }
        int i2 = this.f6409k;
        if (i2 == i) {
            return sortedChildren[a];
        }
        a = i - Math.max(0, i2 - a);
        if (a < 0 || a >= sortedChildren.length) {
            return null;
        }
        return sortedChildren[a];
    }

    private int m10772a(View[] viewArr) {
        ItemPosition g = m10775g();
        int scrollX = getScrollX() + getPaddingLeft();
        int i = -1;
        int i2 = g == ItemPosition.RIGHT ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i3 = 0; i3 < viewArr.length; i3++) {
            int left = viewArr[i3].getLeft();
            switch (2.a[g.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (left != scrollX) {
                        break;
                    }
                    return i3;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (left < scrollX && left > r2) {
                        i = i3;
                        i2 = left;
                        break;
                    }
                case 3:
                    if (left > scrollX && left < r2) {
                        i = i3;
                        i2 = left;
                        break;
                    }
                default:
                    break;
            }
        }
        return i;
    }

    private View[] getSortedChildren() {
        int childCount = getChildCount();
        View[] viewArr = new View[childCount];
        for (int i = 0; i < childCount; i++) {
            viewArr[i] = getChildAt(i);
        }
        Arrays.sort(viewArr, new 1(this));
        return viewArr;
    }

    private static boolean m10774c(int i) {
        return i > 0 && i < 65535;
    }

    private ItemPosition m10775g() {
        int i = this.f6409k;
        int i2 = this.f6403c;
        if (this.f6404d == 0.0f) {
            return ItemPosition.CENTER;
        }
        if (i > i2) {
            return ItemPosition.RIGHT;
        }
        return ItemPosition.LEFT;
    }
}
