package com.facebook.orca.threadview.ephemeral;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.titlebar.TintableTitleBarButton;

/* compiled from: maxLengthEver */
public class EphemeralToggleButton extends CustomFrameLayout implements TintableTitleBarButton {
    private GlyphView f8161a;
    private GlyphView f8162b;

    public EphemeralToggleButton(Context context) {
        super(context);
        m8076b();
    }

    public EphemeralToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8076b();
    }

    public EphemeralToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8076b();
    }

    private void m8076b() {
        setContentView(2130903988);
        this.f8161a = (GlyphView) c(2131561201);
        this.f8162b = (GlyphView) c(2131561202);
    }

    public void setSelected(boolean z) {
        float f;
        int i = 0;
        float f2 = 1.0f;
        super.setSelected(z);
        this.f8161a.setVisibility(z ? 8 : 0);
        GlyphView glyphView = this.f8161a;
        if (z) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        glyphView.setAlpha(f);
        this.f8161a.setRotation(0.0f);
        GlyphView glyphView2 = this.f8162b;
        if (!z) {
            i = 8;
        }
        glyphView2.setVisibility(i);
        glyphView2 = this.f8162b;
        if (!z) {
            f2 = 0.0f;
        }
        glyphView2.setAlpha(f2);
        this.f8162b.setRotation(0.0f);
    }

    public void setEphemeralModeWithAnimation(final boolean z) {
        m8075a(z ? this.f8161a : this.f8162b, z ? this.f8162b : this.f8161a, new AnimatorListenerAdapter(this) {
            final /* synthetic */ EphemeralToggleButton f8160b;

            public void onAnimationEnd(Animator animator) {
                this.f8160b.setSelected(z);
            }
        });
    }

    private static void m8075a(View view, View view2, AnimatorListener animatorListener) {
        view2.setVisibility(0);
        view2.setAlpha(0.0f);
        view2.setRotation(180.0f);
        view2.animate().alpha(1.0f).rotationBy(180.0f).setDuration(500).start();
        view.animate().alpha(0.0f).rotationBy(180.0f).setDuration(500).setListener(animatorListener).start();
    }

    public final void m8077a() {
        this.f8162b.animate().cancel();
        this.f8161a.animate().cancel();
    }

    public void setButtonTintColor(int i) {
        this.f8161a.setGlyphColor(i);
        this.f8162b.setGlyphColor(i);
    }
}
