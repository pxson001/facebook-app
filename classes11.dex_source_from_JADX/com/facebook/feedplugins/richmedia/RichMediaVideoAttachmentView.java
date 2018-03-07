package com.facebook.feedplugins.richmedia;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.inject.FbInjector;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: bundle_wall_load_flushed */
public class RichMediaVideoAttachmentView extends CustomRelativeLayout implements AttachmentEdgeToEdge, AttachmentHasTapPrompt {
    @Inject
    public VideoSizer f9230a;
    public final RichVideoPlayer f9231b;
    public final TextView f9232c;
    public final TextView f9233d;
    public final ValueAnimator f9234e;
    private final Runnable f9235f;
    public double f9236g;
    public String f9237h;

    /* compiled from: bundle_wall_load_flushed */
    class C11141 implements Runnable {
        final /* synthetic */ RichMediaVideoAttachmentView f9227a;

        C11141(RichMediaVideoAttachmentView richMediaVideoAttachmentView) {
            this.f9227a = richMediaVideoAttachmentView;
        }

        public void run() {
            this.f9227a.f9234e.start();
        }
    }

    /* compiled from: bundle_wall_load_flushed */
    class C11152 implements AnimatorUpdateListener {
        final /* synthetic */ RichMediaVideoAttachmentView f9228a;

        C11152(RichMediaVideoAttachmentView richMediaVideoAttachmentView) {
            this.f9228a = richMediaVideoAttachmentView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            this.f9228a.f9232c.setAlpha(f.floatValue());
            this.f9228a.f9232c.setTranslationY(((1.0f - f.floatValue()) * ((float) this.f9228a.f9232c.getHeight())) / 2.0f);
        }
    }

    /* compiled from: bundle_wall_load_flushed */
    class C11163 implements AnimatorListener {
        final /* synthetic */ RichMediaVideoAttachmentView f9229a;

        C11163(RichMediaVideoAttachmentView richMediaVideoAttachmentView) {
            this.f9229a = richMediaVideoAttachmentView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f9229a.f9232c.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void m9880a(Object obj, Context context) {
        ((RichMediaVideoAttachmentView) obj).f9230a = VideoSizer.a(FbInjector.get(context));
    }

    public RichMediaVideoAttachmentView(Context context) {
        this(context, null);
    }

    private RichMediaVideoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private RichMediaVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9234e = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f9235f = new C11141(this);
        this.f9236g = 1.7777777777777777d;
        Class cls = RichMediaVideoAttachmentView.class;
        m9880a(this, getContext());
        setContentView(2130906858);
        this.f9231b = (RichVideoPlayer) a(2131560290);
        this.f9231b.a(new VideoPlugin(context));
        this.f9231b.a(new CoverImagePlugin(context));
        this.f9231b.a(new LoadingSpinnerPlugin(context));
        this.f9232c = (TextView) a(2131567022);
        this.f9233d = (TextView) a(2131567021);
        this.f9234e.setDuration(1000);
        this.f9234e.setInterpolator(new DecelerateInterpolator());
        this.f9234e.addUpdateListener(new C11152(this));
        this.f9234e.addListener(new C11163(this));
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
    }

    public final void mo252c() {
        this.f9232c.setVisibility(8);
    }

    public final void L_(int i) {
        postDelayed(this.f9235f, (long) i);
    }

    public final void mo249a() {
        this.f9231b.setPadding(0, 0, 0, 0);
        LayoutParams layoutParams = (LayoutParams) this.f9231b.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
        }
        this.f9231b.setLayoutParams(layoutParams);
    }
}
