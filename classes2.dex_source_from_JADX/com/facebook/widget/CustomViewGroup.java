package com.facebook.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.v4.app.NoSaveStateView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.util.FindViewUtil;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: messenger_attachment_image_webp_android */
public class CustomViewGroup extends ViewGroup implements NoSaveStateView, FbCustomViewGroup {
    private int mContentViewResourceId;
    private boolean mSaveStateFromParentEnabled = true;

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        try {
            onMeasureInternal(i, i2);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.mContentViewResourceId, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.mContentViewResourceId, e2);
        }
    }

    private void onMeasureInternal(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            int max;
            int max2;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                measureChildWithMargins(childAt, i, 0, i2, 0);
                max = Math.max(i4, (childAt.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin);
                max2 = Math.max(i5, (childAt.getMeasuredHeight() + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin);
            } else {
                max = i4;
                max2 = i5;
            }
            i3++;
            i4 = max;
            i5 = max2;
        }
        setMeasuredDimension(resolveSize(Math.max((getPaddingLeft() + getPaddingRight()) + i4, getSuggestedMinimumWidth()), i), resolveSize(Math.max((getPaddingTop() + getPaddingBottom()) + i5, getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            onLayoutInternal(z, i, i2, i3, i4);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.mContentViewResourceId, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.mContentViewResourceId, e2);
        }
    }

    private void onLayoutInternal(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutChild(paddingLeft, right, paddingTop, bottom, childAt);
            }
        }
    }

    protected void layoutChild(int i, int i2, int i3, int i4, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = layoutParams.gravity;
        if (i5 != -1) {
            int i6 = i5 & 7;
            i5 &= 112;
            switch (i6) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    i = (((((i2 - i) - measuredWidth) / 2) + i) + layoutParams.leftMargin) - layoutParams.rightMargin;
                    break;
                case 3:
                    i += layoutParams.leftMargin;
                    break;
                case 5:
                    i = (i2 - measuredWidth) - layoutParams.rightMargin;
                    break;
                default:
                    i += layoutParams.leftMargin;
                    break;
            }
            switch (i5) {
                case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                    i3 = (((((i4 - i3) - measuredHeight) / 2) + i3) + layoutParams.topMargin) - layoutParams.bottomMargin;
                    break;
                case 48:
                    i3 += layoutParams.topMargin;
                    break;
                case 80:
                    i3 = (i4 - measuredHeight) - layoutParams.bottomMargin;
                    break;
                default:
                    i3 += layoutParams.topMargin;
                    break;
            }
        }
        view.layout(i, i3, i + measuredWidth, i3 + measuredHeight);
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setContentView(int i) {
        this.mContentViewResourceId = i;
        TracerDetour.a("CustomViewGroup.setContentView", 2032988588);
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.mContentViewResourceId, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.mContentViewResourceId, e2);
        } finally {
            TracerDetour.a(1376249994);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.mContentViewResourceId, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.mContentViewResourceId, e2);
        }
    }

    public <T extends View> T getView(int i) {
        return FindViewUtil.m6202b((View) this, i);
    }

    protected <T extends View> T getView(View view, int i) {
        return FindViewUtil.m6202b(view, i);
    }

    public <T extends View> Optional<T> getOptionalView(int i) {
        return FindViewUtil.m6200a(this, i);
    }

    protected <T extends View> Optional<T> getOptionalView(View view, int i) {
        return FindViewUtil.m6200a(view, i);
    }

    public void detachRecyclableViewFromParent(View view) {
        super.detachViewFromParent(view);
        requestLayout();
    }

    public void detachRecyclableViewsFromParent(int i, int i2) {
        super.detachViewsFromParent(i, i2);
        requestLayout();
    }

    public void attachRecyclableViewToParent(View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof IViewAttachAware) || !RecyclableViewHelper.a(this, view, i)) {
            super.attachViewToParent(view, i, layoutParams);
            requestLayout();
        }
    }

    public void removeRecyclableViewFromParent(View view, boolean z) {
        super.removeDetachedView(view, z);
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.mSaveStateFromParentEnabled = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.mSaveStateFromParentEnabled) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.mSaveStateFromParentEnabled) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    public ViewGroup asViewGroup() {
        return this;
    }
}
