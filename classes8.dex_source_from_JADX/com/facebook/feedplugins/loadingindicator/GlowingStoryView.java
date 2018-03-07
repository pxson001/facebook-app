package com.facebook.feedplugins.loadingindicator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.animations.NativeBaseAnimatorListener;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: friends_center_requests_tab */
public class GlowingStoryView extends CustomFrameLayout {
    private LoadingStoryView f12883a;
    private AnimatorSet f12884b;

    public GlowingStoryView(Context context) {
        super(context);
        m14635e();
    }

    public GlowingStoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14635e();
    }

    public GlowingStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14635e();
    }

    private void m14635e() {
        setContentView(2130904596);
        this.f12883a = (LoadingStoryView) c(2131562549);
        this.f12884b = m14636f();
    }

    public final void m14637a() {
        if (!this.f12884b.isStarted()) {
            this.f12884b.start();
        }
    }

    public final void m14638b() {
        this.f12884b.cancel();
    }

    private AnimatorSet m14636f() {
        ObjectAnimator.ofFloat(this.f12883a, "alpha", new float[]{1.0f, 0.45f}).setDuration(500).setInterpolator(new AccelerateInterpolator());
        ObjectAnimator.ofFloat(this.f12883a, "alpha", new float[]{0.45f, 1.0f}).setDuration(500).setInterpolator(new DecelerateInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{r0, r1});
        animatorSet.setStartDelay(500);
        animatorSet.addListener(new NativeBaseAnimatorListener(this) {
            final /* synthetic */ GlowingStoryView f12882b;

            public void onAnimationEnd(Animator animator) {
                animatorSet.start();
            }
        });
        return animatorSet;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 860111280);
        this.f12884b.removeAllListeners();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -653861824, a);
    }
}
