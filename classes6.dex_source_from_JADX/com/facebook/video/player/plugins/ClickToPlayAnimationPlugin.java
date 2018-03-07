package com.facebook.video.player.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: composer_cancel */
public class ClickToPlayAnimationPlugin extends ClickToPlayPlugin {
    private final AnimatorListener f19301a;
    public final ImageView f19302b;

    /* compiled from: composer_cancel */
    class C14371 extends AnimatorListenerAdapter {
        final /* synthetic */ ClickToPlayAnimationPlugin f19299a;

        C14371(ClickToPlayAnimationPlugin clickToPlayAnimationPlugin) {
            this.f19299a = clickToPlayAnimationPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19299a.f19302b.setVisibility(8);
            this.f19299a.f19302b.setAlpha(0.0f);
        }
    }

    @DoNotStrip
    public ClickToPlayAnimationPlugin(Context context) {
        this(context, null);
    }

    private ClickToPlayAnimationPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ClickToPlayAnimationPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19301a = new C14371(this);
        this.f19302b = (ImageView) a(2131560326);
    }

    protected int getContentView() {
        return 2130903575;
    }

    protected final void mo1481d() {
        super.mo1481d();
        m28070c(2130840511);
    }

    protected final void mo1482e() {
        super.mo1482e();
        m28070c(2130840510);
    }

    protected final void mo1480a(boolean z) {
        super.mo1480a(z);
        this.f19302b.setVisibility(z ? 8 : 0);
    }

    private void m28070c(int i) {
        RichVideoPlayerPluginUtils.a(this.f19302b, 250, i, this.f19301a);
    }
}
