package com.facebook.messaging.inbox2.cameraroll;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setThreadEphemerality */
public class InboxCameraRollItemView extends CustomFrameLayout {
    private static final CallerContext f2704c = CallerContext.a(InboxCameraRollItemView.class);
    private static final SpringConfig f2705d = new SpringConfig(500.0d, 50.0d);
    @Inject
    FbDraweeControllerBuilder f2706a;
    @Inject
    SpringSystem f2707b;
    private Spring f2708e;
    private final BaseControllerListener f2709f = new C04461(this);
    public FbDraweeView f2710g;
    private View f2711h;

    /* compiled from: setThreadEphemerality */
    class C04461 extends BaseControllerListener {
        final /* synthetic */ InboxCameraRollItemView f2702a;

        C04461(InboxCameraRollItemView inboxCameraRollItemView) {
            this.f2702a = inboxCameraRollItemView;
        }

        public final void m2668a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: setThreadEphemerality */
    class C04472 extends SimpleSpringListener {
        final /* synthetic */ InboxCameraRollItemView f2703a;

        C04472(InboxCameraRollItemView inboxCameraRollItemView) {
            this.f2703a = inboxCameraRollItemView;
        }

        public final void m2669a(Spring spring) {
            float d = 1.0f - (((float) spring.d()) * 0.15f);
            this.f2703a.f2710g.setScaleX(d);
            this.f2703a.f2710g.setScaleY(d);
        }
    }

    private static <T extends View> void m2673a(Class<T> cls, T t) {
        m2674a((Object) t, t.getContext());
    }

    private static void m2674a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InboxCameraRollItemView) obj).m2672a(FbDraweeControllerBuilder.b(fbInjector), SpringSystem.b(fbInjector));
    }

    public InboxCameraRollItemView(Context context) {
        super(context);
        m2671a();
    }

    public InboxCameraRollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2671a();
    }

    public InboxCameraRollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2671a();
    }

    private void m2671a() {
        setContentView(2130904862);
        m2673a(InboxCameraRollItemView.class, (View) this);
        m2675b();
        this.f2710g = (FbDraweeView) c(2131563088);
        this.f2711h = c(2131563089);
    }

    public void setMediaResource(MediaResource mediaResource) {
        ((FbDraweeControllerBuilder) this.f2706a.p().a(f2704c).b(this.f2710g.getController())).a(this.f2709f);
        this.f2706a.c(ImageRequest.a(mediaResource.c));
        this.f2710g.setController(this.f2706a.s());
    }

    private void m2675b() {
        this.f2708e = this.f2707b.a().a(f2705d).a(new C04472(this));
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f2711h.setVisibility(z ? 0 : 8);
        this.f2708e.b(z ? 1.0d : 0.0d);
    }

    public final void m2676a(boolean z, boolean z2) {
        setSelected(z);
        if (!z2) {
            this.f2708e.a(this.f2708e.i);
        }
    }

    private void m2672a(FbDraweeControllerBuilder fbDraweeControllerBuilder, SpringSystem springSystem) {
        this.f2706a = fbDraweeControllerBuilder;
        this.f2707b = springSystem;
    }
}
