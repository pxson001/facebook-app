package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;

/* compiled from: android.media.intent.category.LIVE_AUDIO */
public class FlyoutAnimatorListener<V extends View & HasPromptFlyout> implements AnimatorListener {
    private final View f19297a;
    private final boolean f19298b;
    private final float f19299c;
    public final V2Attachment f19300d;

    public FlyoutAnimatorListener(V v, boolean z, float f, V2Attachment v2Attachment) {
        this.f19297a = ((HasPromptFlyout) v).getFlyoutView();
        this.f19298b = z;
        this.f19299c = f;
        this.f19300d = v2Attachment;
    }

    public void onAnimationStart(Animator animator) {
        if (this.f19298b) {
            this.f19297a.setVisibility(0);
            ((View) this.f19297a.getParent()).setVisibility(0);
        } else if (!(this.f19300d == null || this.f19300d.getCollapseAnimator() == null)) {
            this.f19300d.getCollapseAnimator().start();
        }
        this.f19297a.setPivotX(((float) this.f19297a.getMeasuredWidth()) * this.f19299c);
        this.f19297a.setPivotY(0.0f);
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f19298b) {
            if (!(this.f19300d == null || this.f19300d.getExpandAnimator() == null)) {
                this.f19300d.getExpandAnimator().start();
            }
            return;
        }
        this.f19297a.setVisibility(8);
        ((View) this.f19297a.getParent()).setVisibility(8);
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }
}
