package com.facebook.composer.ui.underwood.common;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.Button;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: tapped_impressum */
public class ButtonAnimator {
    public AnimationDrawable f2110a;
    private Button f2111b;

    public ButtonAnimator(ImmutableList<Drawable> immutableList, Button button) {
        Preconditions.checkNotNull(button);
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkArgument(!immutableList.isEmpty());
        this.f2111b = button;
        this.f2110a = new AnimationDrawable();
        this.f2110a.setOneShot(true);
        if (!(VERSION.SDK_INT == 14 || VERSION.SDK_INT == 15)) {
            this.f2110a.setEnterFadeDuration(400);
            this.f2110a.setExitFadeDuration(400);
        }
        this.f2110a.addFrame((Drawable) immutableList.get(0), 0);
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                this.f2110a.addFrame((Drawable) immutableList.get(i2), 1200);
            }
        }
    }

    public final void m2081a() {
        this.f2111b.setBackgroundDrawable(this.f2110a);
        this.f2110a.start();
    }
}
