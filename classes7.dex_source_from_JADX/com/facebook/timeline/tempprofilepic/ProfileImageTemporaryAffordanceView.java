package com.facebook.timeline.tempprofilepic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;

/* compiled from: facecast_comment_draft_saved_tag */
public class ProfileImageTemporaryAffordanceView extends CustomFrameLayout {
    public ImageWithTextView f14954a;

    public ProfileImageTemporaryAffordanceView(Context context) {
        super(context);
        m18791a();
    }

    public ProfileImageTemporaryAffordanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18791a();
    }

    private void m18791a() {
        setContentView(2130907472);
        this.f14954a = (ImageWithTextView) c(2131567975);
    }

    public ImageWithTextView getTimerTextView() {
        return this.f14954a;
    }

    public void setBackgroundAlpha(int i) {
        Preconditions.checkNotNull(getBackground(), "Do not call setBackgroundAlpha if the view does not have a background drawable");
        getBackground().setAlpha(i);
        invalidate();
    }

    public void setTimerText(CharSequence charSequence) {
        this.f14954a.setText(charSequence);
    }

    public void setTimerDrawable(Drawable drawable) {
        this.f14954a.setImageDrawable(drawable);
    }
}
