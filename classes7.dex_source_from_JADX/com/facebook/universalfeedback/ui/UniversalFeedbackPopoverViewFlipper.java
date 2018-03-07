package com.facebook.universalfeedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.popover.PopoverViewFlipper;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionListener;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionType;
import javax.annotation.Nullable;

/* compiled from: edit_gallery_custom_params */
public class UniversalFeedbackPopoverViewFlipper extends PopoverViewFlipper {

    /* compiled from: edit_gallery_custom_params */
    class UFTransitionListener extends TransitionListener {
        final /* synthetic */ UniversalFeedbackPopoverViewFlipper f15381h;

        public UFTransitionListener(UniversalFeedbackPopoverViewFlipper universalFeedbackPopoverViewFlipper) {
            this.f15381h = universalFeedbackPopoverViewFlipper;
            super(universalFeedbackPopoverViewFlipper);
        }

        public final void m19403a() {
            PopoverWindowViewMeasurer popoverWindowViewMeasurer = new PopoverWindowViewMeasurer(this.f15381h.getContext());
            popoverWindowViewMeasurer.m19387a(this.a);
            popoverWindowViewMeasurer.m19387a(this.b);
            int paddingLeft = this.f15381h.getPaddingLeft() + this.f15381h.getPaddingRight();
            this.e = this.a.getMeasuredWidth() + paddingLeft;
            this.f = paddingLeft + this.b.getMeasuredWidth();
            paddingLeft = this.f15381h.getPaddingTop() + this.f15381h.getPaddingBottom();
            this.c = this.a.getMeasuredHeight() + paddingLeft;
            this.d = paddingLeft + this.b.getMeasuredHeight();
        }
    }

    public UniversalFeedbackPopoverViewFlipper(Context context) {
        super(context);
    }

    public UniversalFeedbackPopoverViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UniversalFeedbackPopoverViewFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setContentViewPreservingLayout(@Nullable View view) {
        if (view != null) {
            removeAllViews();
            addView(view);
        }
    }

    public final void m19405b(@Nullable View view) {
        if (view != null) {
            addView(view, getChildCount());
        }
    }

    protected final TransitionListener m19404a() {
        return new UFTransitionListener(this);
    }

    public final void m19406g() {
        if (this.n != TransitionType.NONE) {
            if (c()) {
                f();
                return;
            }
            int i = getLayoutParams().height;
            int i2 = this.j;
            if (i >= 0 && i2 >= 0 && i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                new PopoverWindowViewMeasurer(getContext()).m19387a(childAt);
                i2 = childAt.getMeasuredHeight() + (getPaddingTop() + getPaddingBottom());
                if (i2 > i) {
                    getLayoutParams().height = i2;
                }
            }
        }
    }
}
