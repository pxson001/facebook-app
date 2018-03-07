package com.facebook.orca.common.ui.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.facebook.R;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import com.facebook.widget.animatablelistview.AnimatingItemView;

/* compiled from: owner_authored_posts */
public class SlidingOutSuggestionViewBase extends CustomFrameLayout {
    public AnimatingItemView f5320a;
    public boolean f5321b;
    public int f5322c;
    private DesiredVisibility f5323d;

    /* compiled from: owner_authored_posts */
    enum DesiredVisibility {
        WHATEVER,
        SHOW,
        HIDE,
        ANIMATE_IN,
        ANIMATE_OUT
    }

    public SlidingOutSuggestionViewBase(Context context) {
        this(context, null);
    }

    public SlidingOutSuggestionViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingOutSuggestionViewBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingOutSuggestionView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 1) {
                this.f5322c = obtainStyledAttributes.getInteger(index, this.f5322c);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void m4720a() {
        this.f5323d = DesiredVisibility.SHOW;
        mo217f();
    }

    public final void m4721b() {
        this.f5323d = DesiredVisibility.HIDE;
        mo217f();
    }

    public final void m4722e() {
        this.f5323d = DesiredVisibility.ANIMATE_OUT;
        mo217f();
    }

    private void mo217f() {
        if (!this.f5321b) {
            int i = this.f5320a.getVisibility() == 0 ? 1 : 0;
            switch (this.f5323d) {
                case SHOW:
                    this.f5320a.setVisibility(0);
                    break;
                case HIDE:
                    this.f5320a.setVisibility(8);
                    break;
                case ANIMATE_OUT:
                    if (i != 0) {
                        float f = this.f5322c == 1 ? 1.0f : -1.0f;
                        final AnimatingItemInfo animatingItemInfo = new AnimatingItemInfo();
                        this.f5320a.setItemInfo(animatingItemInfo);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(animatingItemInfo, "animationOffset", new float[]{f, 0.0f});
                        ofFloat.setDuration(300);
                        ofFloat.setInterpolator(new LinearInterpolator());
                        ofFloat.addListener(new AnimatorListenerAdapter(this) {
                            final /* synthetic */ SlidingOutSuggestionViewBase f5318b;

                            public void onAnimationEnd(Animator animator) {
                                this.f5318b.f5321b = false;
                                this.f5318b.f5320a.setVisibility(8);
                                animatingItemInfo.setAnimationOffset(1.0f);
                            }
                        });
                        ofFloat.start();
                        this.f5321b = true;
                        break;
                    }
                    break;
            }
            this.f5323d = DesiredVisibility.WHATEVER;
        }
    }

    public int getAnimateOutDirection() {
        return this.f5322c;
    }

    public void setAnimateOutDirection(int i) {
        this.f5322c = i;
    }
}
