package com.facebook.widget.animatablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.ViewTransform;
import com.facebook.widget.animatablelistview.AnimatingItemInfo.AnimationListener;
import com.facebook.widget.listview.WrappingListItemView;
import java.lang.ref.WeakReference;

/* compiled from: fbNativeReady */
public class AnimatingItemView extends CustomViewGroup implements WrappingListItemView {
    private AnimatingItemInfo<?> f14973a;
    private float f14974b = 1.0f;
    private float f14975c = 1.0f;
    private float f14976d = 1.0f;
    private float f14977e = 1.0f;
    private int f14978f = 0;
    private final ViewTransform f14979g = new ViewTransform(this);
    private AnimatingItemViewListener f14980h;

    /* compiled from: fbNativeReady */
    class AnimatingItemViewListener extends AnimationListener {
        private WeakReference<AnimatingItemView> f20451a;

        public AnimatingItemViewListener(AnimatingItemView animatingItemView) {
            this.f20451a = new WeakReference(animatingItemView);
        }

        public final void mo838a() {
            AnimatingItemView animatingItemView = (AnimatingItemView) this.f20451a.get();
            if (animatingItemView != null) {
                AnimatingItemView.m15362b(animatingItemView);
            }
        }
    }

    public AnimatingItemView(Context context) {
        super(context);
        m15360a();
    }

    public AnimatingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15360a();
    }

    public AnimatingItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15360a();
    }

    private void m15360a() {
        this.f14980h = new AnimatingItemViewListener(this);
    }

    public void setItemInfo(AnimatingItemInfo<?> animatingItemInfo) {
        if (this.f14973a != null) {
            this.f14973a.m20009b(this.f14980h);
        }
        this.f14973a = animatingItemInfo;
        if (this.f14973a != null) {
            this.f14973a.m20007a(this.f14980h);
        }
        m15362b(this);
    }

    public AnimatingItemInfo<?> getItemInfo() {
        return this.f14973a;
    }

    public View getWrappedView() {
        return getChildCount() > 0 ? getChildAt(0) : null;
    }

    public static void m15362b(AnimatingItemView animatingItemView) {
        int i;
        int i2 = 1;
        if (animatingItemView.f14973a != null) {
            if (animatingItemView.f14974b != animatingItemView.f14973a.f20446b) {
                i = 1;
            } else {
                i = 0;
            }
            if (animatingItemView.f14978f == animatingItemView.f14973a.f20450f) {
                i2 = 0;
            }
            animatingItemView.f14974b = animatingItemView.f14973a.f20446b;
            animatingItemView.f14978f = animatingItemView.f14973a.f20450f;
            animatingItemView.f14975c = animatingItemView.f14973a.f20447c;
            animatingItemView.f14976d = animatingItemView.f14973a.f20448d;
            animatingItemView.f14977e = animatingItemView.f14973a.f20449e;
        } else {
            i = animatingItemView.f14974b != 1.0f ? 1 : 0;
            if (animatingItemView.f14978f == 0) {
                i2 = 0;
            }
            animatingItemView.f14974b = 1.0f;
            animatingItemView.f14978f = 0;
            animatingItemView.f14975c = 1.0f;
            animatingItemView.f14976d = 1.0f;
            animatingItemView.f14977e = 1.0f;
        }
        animatingItemView.f14979g.setScaleX(animatingItemView.f14975c);
        animatingItemView.f14979g.setScaleY(animatingItemView.f14976d);
        animatingItemView.f14979g.setAlpha(animatingItemView.f14977e);
        if (i2 != 0) {
            animatingItemView.f14979g.setVisibility(animatingItemView.f14978f);
        }
        if (i != 0) {
            animatingItemView.requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int max2;
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                max = Math.max(i4, childAt.getMeasuredWidth());
                max2 = Math.max(i5, childAt.getMeasuredHeight());
            } else {
                max = i4;
                max2 = i5;
            }
            i3++;
            i4 = max;
            i5 = max2;
        }
        max = (getPaddingLeft() + getPaddingRight()) + i4;
        max2 = Math.max((getPaddingTop() + getPaddingBottom()) + i5, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(Math.max(max, getSuggestedMinimumWidth()), i), View.resolveSize(Math.abs((int) (((float) max2) * this.f14974b)), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                if (this.f14974b < 0.0f) {
                    int measuredHeight = childAt.getMeasuredHeight() - (bottom - paddingTop);
                    paddingTop -= measuredHeight;
                    bottom -= measuredHeight;
                }
                layoutChild(paddingLeft, right, paddingTop, bottom, childAt);
            }
        }
    }
}
