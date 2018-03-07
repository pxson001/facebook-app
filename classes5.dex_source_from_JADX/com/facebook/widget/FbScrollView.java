package com.facebook.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.NoSaveStateView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/* compiled from: com.google.android.gms.signin.internal.IOfflineAccessCallbacks */
public class FbScrollView extends ScrollView implements NoSaveStateView {
    private boolean f5614a = true;

    public FbScrollView(Context context) {
        super(context);
    }

    public FbScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FbScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final boolean m10421a() {
        View childAt = getChildAt(getChildCount() - 1);
        return childAt.getHeight() + childAt.getTop() <= getScrollY() + getHeight();
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.f5614a = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f5614a) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f5614a) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    public ViewGroup asViewGroup() {
        return this;
    }
}
