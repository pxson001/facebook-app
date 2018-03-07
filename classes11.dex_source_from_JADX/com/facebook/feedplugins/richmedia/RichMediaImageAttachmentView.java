package com.facebook.feedplugins.richmedia;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.CoverPhotoWithPlayIconView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: button_neutral */
public class RichMediaImageAttachmentView extends CustomRelativeLayout implements AttachmentHasLargeImage, AttachmentEdgeToEdge, AttachmentHasLightningBoltAnimation, AttachmentHasTapPrompt {
    @Inject
    public FbDraweeControllerBuilder f9182a;
    private final CoverPhotoWithPlayIconView f9183b;
    public final TextView f9184c;
    public final TextView f9185d;
    public final FbDraweeView f9186e;
    public final ValueAnimator f9187f;
    private final Runnable f9188g;
    private final Runnable f9189h;

    /* compiled from: button_neutral */
    class C11071 implements Runnable {
        final /* synthetic */ RichMediaImageAttachmentView f9178a;

        C11071(RichMediaImageAttachmentView richMediaImageAttachmentView) {
            this.f9178a = richMediaImageAttachmentView;
        }

        public void run() {
            this.f9178a.f9184c.setVisibility(0);
            this.f9178a.f9187f.start();
        }
    }

    /* compiled from: button_neutral */
    class C11082 implements Runnable {
        final /* synthetic */ RichMediaImageAttachmentView f9179a;

        C11082(RichMediaImageAttachmentView richMediaImageAttachmentView) {
            this.f9179a = richMediaImageAttachmentView;
        }

        public void run() {
            this.f9179a.f9186e.setVisibility(8);
        }
    }

    /* compiled from: button_neutral */
    class C11093 implements AnimatorUpdateListener {
        final /* synthetic */ RichMediaImageAttachmentView f9180a;

        C11093(RichMediaImageAttachmentView richMediaImageAttachmentView) {
            this.f9180a = richMediaImageAttachmentView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            this.f9180a.f9184c.setAlpha(f.floatValue());
            this.f9180a.f9184c.setTranslationY(((1.0f - f.floatValue()) * ((float) this.f9180a.f9184c.getHeight())) / 2.0f);
        }
    }

    /* compiled from: button_neutral */
    class C11104 implements AnimatorListener {
        final /* synthetic */ RichMediaImageAttachmentView f9181a;

        C11104(RichMediaImageAttachmentView richMediaImageAttachmentView) {
            this.f9181a = richMediaImageAttachmentView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f9181a.f9184c.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void m9852a(Object obj, Context context) {
        ((RichMediaImageAttachmentView) obj).f9182a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public RichMediaImageAttachmentView(Context context) {
        this(context, null);
    }

    private RichMediaImageAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private RichMediaImageAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9187f = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f9188g = new C11071(this);
        this.f9189h = new C11082(this);
        Class cls = RichMediaImageAttachmentView.class;
        m9852a((Object) this, getContext());
        setContentView(2130906857);
        this.f9183b = (CoverPhotoWithPlayIconView) a(2131567019);
        this.f9184c = (TextView) a(2131567022);
        this.f9185d = (TextView) a(2131567021);
        this.f9186e = (FbDraweeView) a(2131567020);
        this.f9187f.setDuration(1000);
        this.f9187f.setInterpolator(new DecelerateInterpolator());
        this.f9187f.addUpdateListener(new C11093(this));
        this.f9187f.addListener(new C11104(this));
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
    }

    public void setLargeImageAspectRatio(float f) {
        this.f9183b.setAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        this.f9183b.setVisibility(draweeController != null ? 0 : 8);
        this.f9183b.setController(draweeController);
    }

    public final void mo252c() {
        this.f9184c.setVisibility(8);
    }

    public final void L_(int i) {
        postDelayed(this.f9188g, (long) i);
    }

    public final void mo250a(int i, String str) {
        this.f9186e.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f9182a.a(CallerContext.a(getClass())).b(this.f9186e.getController())).b(Uri.parse(str)).c(true)).s());
        this.f9186e.setVisibility(0);
        postDelayed(this.f9189h, (long) i);
    }

    public final void mo251b() {
        removeCallbacks(this.f9189h);
        this.f9186e.setVisibility(8);
    }

    public final void mo249a() {
        this.f9183b.setPadding(0, 0, 0, 0);
        LayoutParams layoutParams = (LayoutParams) this.f9183b.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
        }
        this.f9183b.setLayoutParams(layoutParams);
    }
}
