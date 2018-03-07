package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.redspace.ui.animation.RedSpaceFadeAnimationHelper;

/* compiled from: PRIVACY_CHECKUP_COMPOSER_STEP_PREVIOUS */
public class RedSpaceFriendsSearchView extends FrameLayout implements RedSpaceAnimationSupportedView {
    private boolean f12489a;

    public RedSpaceFriendsSearchView(Context context) {
        super(context);
    }

    public RedSpaceFriendsSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedSpaceFriendsSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setEnabled(boolean z) {
        if (isEnabled() != z) {
            super.setEnabled(z);
            RedSpaceFadeAnimationHelper.m12838a(getChildAt(0), this.f12489a, z ? 1.0f : 0.2f);
            this.f12489a = false;
        }
    }

    public final void mo356a() {
        this.f12489a = true;
    }
}
