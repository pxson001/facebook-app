package com.facebook.composer.tip;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.HeightAnimation;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: composer_location_tab */
public class LinearComposerNextTooltip extends CustomLinearLayout {
    private TextView f17010a;
    private Fb4aTitleBar f17011b;
    private View f17012c;
    private OnDismissListener f17013d;
    private OnGlobalLayoutListener f17014e;

    /* compiled from: composer_location_tab */
    class C13721 implements OnClickListener {
        final /* synthetic */ LinearComposerNextTooltip f17008a;

        C13721(LinearComposerNextTooltip linearComposerNextTooltip) {
            this.f17008a = linearComposerNextTooltip;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 866004126);
            this.f17008a.m20957a();
            Logger.a(2, EntryType.UI_INPUT_END, 2110555666, a);
        }
    }

    /* compiled from: composer_location_tab */
    class C13733 implements AnimationListener {
        final /* synthetic */ LinearComposerNextTooltip f17009a;

        C13733(LinearComposerNextTooltip linearComposerNextTooltip) {
            this.f17009a = linearComposerNextTooltip;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f17009a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: composer_location_tab */
    public interface OnDismissListener {
    }

    public LinearComposerNextTooltip(Context context) {
        super(context);
        m20956b();
    }

    public LinearComposerNextTooltip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20956b();
    }

    public LinearComposerNextTooltip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20956b();
    }

    private void m20956b() {
        setContentView(2130905046);
        this.f17010a = (TextView) a(2131563429);
        this.f17012c = a(2131563427);
        a(2131563430).setOnClickListener(new C13721(this));
        setVisibility(8);
        setOrientation(1);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f17013d = onDismissListener;
    }

    public void setText(String str) {
        this.f17010a.setText(str);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -38300328);
        super.onDetachedFromWindow();
        if (this.f17014e != null) {
            if (VERSION.SDK_INT < 16) {
                this.f17011b.getViewTreeObserver().removeGlobalOnLayoutListener(this.f17014e);
            } else {
                this.f17011b.getViewTreeObserver().removeOnGlobalLayoutListener(this.f17014e);
            }
        }
        LogUtils.g(610233035, a);
    }

    public final void m20957a() {
        View a = a(2131563428);
        HeightAnimation heightAnimation = new HeightAnimation(a, 0);
        heightAnimation.setAnimationListener(new C13733(this));
        heightAnimation.setDuration(200);
        a.startAnimation(heightAnimation);
    }
}
