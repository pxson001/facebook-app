package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: pymk_id */
public class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private int mTempLeftRightOffset = 0;
    private int mTempTopBottomOffset = 0;
    private ViewOffsetHelper mViewOffsetHelper;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m10122a((View) v, i);
        if (this.mViewOffsetHelper == null) {
            this.mViewOffsetHelper = new ViewOffsetHelper(v);
        }
        this.mViewOffsetHelper.m10272a();
        if (this.mTempTopBottomOffset != 0) {
            this.mViewOffsetHelper.m10273a(this.mTempTopBottomOffset);
            this.mTempTopBottomOffset = 0;
        }
        if (this.mTempLeftRightOffset != 0) {
            this.mViewOffsetHelper.m10274b(this.mTempLeftRightOffset);
            this.mTempLeftRightOffset = 0;
        }
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.m10273a(i);
        }
        this.mTempTopBottomOffset = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.m10274b(i);
        }
        this.mTempLeftRightOffset = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        return this.mViewOffsetHelper != null ? this.mViewOffsetHelper.f7143d : 0;
    }

    public int getLeftAndRightOffset() {
        return this.mViewOffsetHelper != null ? this.mViewOffsetHelper.f7144e : 0;
    }
}
