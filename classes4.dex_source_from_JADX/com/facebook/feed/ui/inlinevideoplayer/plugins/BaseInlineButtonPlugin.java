package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;

/* compiled from: popover_attach_to_activity */
public abstract class BaseInlineButtonPlugin extends StubbableRichVideoPlayerPlugin {
    public LinearLayout f4436b;
    protected FbTextView f4437c;
    protected ImageView f4438d;
    protected Boolean f4439l;
    protected boolean f4440m;
    private Runnable f4441n;

    /* compiled from: popover_attach_to_activity */
    class C02431 implements Runnable {
        final /* synthetic */ BaseInlineButtonPlugin f5724a;

        C02431(BaseInlineButtonPlugin baseInlineButtonPlugin) {
            this.f5724a = baseInlineButtonPlugin;
        }

        public void run() {
            if (this.f5724a.f4437c != null && this.f5724a.f4437c.getVisibility() == 0) {
                this.f5724a.m4942f();
            }
        }
    }

    protected abstract int mo387b(boolean z);

    public BaseInlineButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getLayoutToInflate() {
        return 2130904921;
    }

    protected void setupViews(View view) {
        this.f4436b = (LinearLayout) view.findViewById(2131563181);
        this.f4437c = (FbTextView) view.findViewById(2131563184);
        this.f4438d = (ImageView) view.findViewById(2131563182);
        this.f4441n = new C02431(this);
    }

    protected int getStubLayout() {
        return 2130907683;
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return this.f4440m;
    }

    protected void mo378c() {
        if (this.f14153c) {
            this.f4436b.setVisibility(8);
            this.f4436b.setOnClickListener(null);
        }
    }

    public final void m4937a(boolean z) {
        if (this.f4439l == null || this.f4439l.booleanValue() != z) {
            this.f4439l = Boolean.valueOf(z);
            int i = z ? 2130840956 : 2130840955;
            int b = mo387b(z);
            this.f4436b.setBackgroundResource(i);
            this.f4437c.setText(b);
            mo388c(z);
            this.f4437c.removeCallbacks(this.f4441n);
            this.f4437c.postDelayed(this.f4441n, 3000);
        }
    }

    protected final void m4942f() {
        final int width = this.f4437c.getWidth();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ BaseInlineButtonPlugin f5767b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f5767b.f4437c.getLayoutParams().width = (int) (((float) width) * floatValue);
                this.f5767b.f4437c.requestLayout();
                this.f5767b.f4437c.invalidate();
                this.f5767b.f4436b.setAlpha((floatValue * 0.3f) + 0.7f);
            }
        });
        ofFloat.start();
    }

    public final void m4943k() {
        this.f4436b.setAlpha(1.0f);
        this.f4437c.getLayoutParams().width = -2;
        this.f4437c.requestLayout();
        this.f4437c.invalidate();
    }

    protected void mo388c(boolean z) {
    }
}
