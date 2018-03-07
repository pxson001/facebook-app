package com.facebook.facecastdisplay.streamingreactions;

import android.animation.Animator;
import com.facebook.ui.animations.BaseAnimatorListener;
import javax.annotation.Nullable;

/* compiled from: state_caller_field_type */
public class StreamingReactionsAnimationListener extends BaseAnimatorListener {
    private boolean f3326a;

    public void onAnimationStart(@Nullable Animator animator) {
        this.f3326a = false;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f3326a) {
            mo156a(animator);
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.f3326a = true;
    }

    public void mo156a(Animator animator) {
    }
}
