package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.CircularIndeterminateLoadingIndicator;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.RichDocumentImageView.ImageSetListener;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: num_related_articles */
public class CircularIndeterminateLoadingIndicatorPlugin extends BaseMediaFramePlugin<Void> implements ImageSetListener, TouchSpringUpdateListener {
    private static final SpringConfig f7620c = SpringConfig.b(RichDocumentUIConfig.f6539J, RichDocumentUIConfig.f6540K);
    private static final SpringConfig f7621d = SpringConfig.b(RichDocumentUIConfig.f6535F, RichDocumentUIConfig.f6536G);
    @Inject
    public Provider<TouchSpring> f7622a;
    @Inject
    public SpringSystem f7623b;
    public final CircularIndeterminateLoadingIndicator f7624e;
    public final TouchSpring f7625f = ((TouchSpring) this.f7622a.get());
    private final Spring f7626g;

    /* compiled from: num_related_articles */
    class C08751 extends SimpleSpringListener {
        final /* synthetic */ CircularIndeterminateLoadingIndicatorPlugin f7618a;

        C08751(CircularIndeterminateLoadingIndicatorPlugin circularIndeterminateLoadingIndicatorPlugin) {
            this.f7618a = circularIndeterminateLoadingIndicatorPlugin;
        }

        public final void m7897a(Spring spring) {
            float d = (float) spring.d();
            CircularIndeterminateLoadingIndicatorPlugin circularIndeterminateLoadingIndicatorPlugin = this.f7618a;
            if (circularIndeterminateLoadingIndicatorPlugin.f7624e != null) {
                circularIndeterminateLoadingIndicatorPlugin.f7624e.setAlpha(d);
            }
        }
    }

    /* compiled from: num_related_articles */
    class C08762 implements OnTouchListener {
        final /* synthetic */ CircularIndeterminateLoadingIndicatorPlugin f7619a;

        C08762(CircularIndeterminateLoadingIndicatorPlugin circularIndeterminateLoadingIndicatorPlugin) {
            this.f7619a = circularIndeterminateLoadingIndicatorPlugin;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f7619a.f7625f != null && this.f7619a.f7625f.onTouch(view, motionEvent);
        }
    }

    public static void m7898a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CircularIndeterminateLoadingIndicatorPlugin circularIndeterminateLoadingIndicatorPlugin = (CircularIndeterminateLoadingIndicatorPlugin) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3736);
        SpringSystem b = SpringSystem.b(fbInjector);
        circularIndeterminateLoadingIndicatorPlugin.f7622a = a;
        circularIndeterminateLoadingIndicatorPlugin.f7623b = b;
    }

    public CircularIndeterminateLoadingIndicatorPlugin(MediaFrame mediaFrame, CircularIndeterminateLoadingIndicator circularIndeterminateLoadingIndicator) {
        super(mediaFrame);
        Class cls = CircularIndeterminateLoadingIndicatorPlugin.class;
        m7898a(this, getContext());
        this.f7625f.a(this);
        this.f7625f.d = true;
        this.f7625f.b = 0.9f;
        this.f7625f.c = 1.0f;
        this.f7625f.a(f7620c);
        Spring c = this.f7623b.a().a(f7621d).c(0.0d);
        c.c = true;
        this.f7626g = c;
        this.f7626g.a(new C08751(this));
        this.f7624e = circularIndeterminateLoadingIndicator;
        this.f7624e.setOnTouchListener(new C08762(this));
    }

    public final void m7899a(float f) {
        this.f7624e.setScaleX(f);
        this.f7624e.setScaleY(f);
    }

    public final void mo510e() {
        this.f7624e.m7430e();
    }

    public final void mo504a(ViewLayout viewLayout) {
        if (this.f7624e != null) {
            if (((RichDocumentImageView) m7895i()).ja_()) {
                this.f7624e.setVisibility(4);
                return;
            }
            this.f7624e.setVisibility(0);
            this.f7626g.a(1.0d);
            this.f7624e.setAlpha(1.0f);
            this.f7624e.m7428a();
        }
    }

    public final void mo395a(RichDocumentImageView richDocumentImageView) {
        this.f7624e.m7430e();
        this.f7626g.b(0.0d);
    }

    public final void mo396b(RichDocumentImageView richDocumentImageView) {
        this.f7624e.m7430e();
        this.f7626g.b(0.0d);
    }

    public boolean isPressed() {
        return this.f7624e.isPressed();
    }

    public boolean performClick() {
        this.f7624e.m7429d();
        return false;
    }
}
