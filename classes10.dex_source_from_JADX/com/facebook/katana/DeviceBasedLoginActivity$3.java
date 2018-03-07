package com.facebook.katana;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: SEGMENT_UPLOADING_FAILURE */
class DeviceBasedLoginActivity$3 implements AnimatorListener {
    final /* synthetic */ DBLPasswordLoginFragment f24174a;
    final /* synthetic */ DeviceBasedLoginActivity f24175b;

    DeviceBasedLoginActivity$3(DeviceBasedLoginActivity deviceBasedLoginActivity, DBLPasswordLoginFragment dBLPasswordLoginFragment) {
        this.f24175b = deviceBasedLoginActivity;
        this.f24174a = dBLPasswordLoginFragment;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        DeviceBasedLoginActivity.b(this.f24175b, this.f24174a);
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }
}
