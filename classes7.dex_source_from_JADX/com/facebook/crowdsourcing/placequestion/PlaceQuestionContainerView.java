package com.facebook.crowdsourcing.placequestion;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: com.facebook.intent.extra.SKIP_IN_APP_BROWSER */
public class PlaceQuestionContainerView extends CustomLinearLayout {
    public final int f17521a;
    public int f17522b;
    public View f17523c;
    public View f17524d;
    public int f17525e = 0;
    public int f17526f = 0;

    /* compiled from: com.facebook.intent.extra.SKIP_IN_APP_BROWSER */
    public class C14521 extends Animation {
        int f17514a = -1;
        int f17515b = -1;
        final /* synthetic */ int f17516c;
        final /* synthetic */ int f17517d;
        final /* synthetic */ int f17518e;
        final /* synthetic */ int f17519f;
        final /* synthetic */ PlaceQuestionContainerView f17520g;

        public C14521(PlaceQuestionContainerView placeQuestionContainerView, int i, int i2, int i3, int i4) {
            this.f17520g = placeQuestionContainerView;
            this.f17516c = i;
            this.f17517d = i2;
            this.f17518e = i3;
            this.f17519f = i4;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            int i = (int) (((float) this.f17516c) + (((float) (this.f17517d - this.f17516c)) * f));
            int i2 = (int) (((float) this.f17518e) + (((float) (this.f17519f - this.f17518e)) * f));
            if (i != this.f17514a) {
                PlaceQuestionContainerView.setContainerMargin(this.f17520g, i);
            }
            if (i2 != this.f17515b) {
                this.f17520g.setContentHeight(i2);
            }
            if (!(i == this.f17514a && i2 == this.f17515b)) {
                this.f17520g.requestLayout();
            }
            this.f17514a = i;
            this.f17515b = i2;
        }
    }

    public PlaceQuestionContainerView(Context context, int i) {
        super(context);
        setContentView(2130906258);
        setOrientation(1);
        this.f17524d = a(2131565986);
        this.f17523c = a(2131565987);
        this.f17521a = (int) getResources().getDimension(2131431448);
        this.f17522b = i;
        setContainerMargin(this, this.f17522b * this.f17521a);
    }

    public final void m21410a(View view, int i) {
        removeView(this.f17524d);
        addView(view, 0);
        this.f17524d = view;
        if (this.f17525e > 0) {
            this.f17524d.setLayoutParams(new LayoutParams(-1, this.f17525e));
            m21411c(MeasureSpec.makeMeasureSpec(i, 1073741824));
        }
    }

    public final void m21411c(int i) {
        if (this.f17526f == 0) {
            this.f17524d.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
            this.f17526f = this.f17524d.getMeasuredHeight();
            if (this.f17525e == 0) {
                this.f17525e = this.f17526f;
            }
        }
    }

    public void setContentHeight(int i) {
        ViewGroup.LayoutParams layoutParams = (LayoutParams) this.f17524d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = i;
        this.f17525e = i;
        this.f17524d.setLayoutParams(layoutParams);
    }

    public static void setContainerMargin(PlaceQuestionContainerView placeQuestionContainerView, int i) {
        ViewGroup.LayoutParams layoutParams = (FrameLayout.LayoutParams) placeQuestionContainerView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        if (i >= 0) {
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 48;
        }
        placeQuestionContainerView.setLayoutParams(layoutParams);
    }
}
