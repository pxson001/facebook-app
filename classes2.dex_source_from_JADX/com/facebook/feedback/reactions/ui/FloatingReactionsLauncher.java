package com.facebook.feedback.reactions.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.particles.ParticleSystemView;
import com.facebook.particles.SimpleParticleStyle;
import com.facebook.particles.suppliers.GaussianInRange;
import com.facebook.particles.suppliers.RandomInRange;
import javax.inject.Inject;

@ContextScoped
/* compiled from: growth_set_continuous_contacts_upload */
public class FloatingReactionsLauncher {
    private static FloatingReactionsLauncher f21502e;
    private static final Object f21503f = new Object();
    private final ReactionsExperimentUtil f21504a;
    public PopupWindow f21505b;
    public ParticleSystemView f21506c;
    public SimpleParticleStyle f21507d;

    private static FloatingReactionsLauncher m29210b(InjectorLike injectorLike) {
        return new FloatingReactionsLauncher(ReactionsExperimentUtil.m10410a(injectorLike));
    }

    @Inject
    public FloatingReactionsLauncher(ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f21504a = reactionsExperimentUtil;
    }

    public final void m29213a(View view) {
        if ((this.f21505b == null || !this.f21505b.isShowing()) && this.f21504a.f6216c.m2189a(834, false)) {
            if (this.f21505b == null) {
                m29211b(view.getContext());
            }
            this.f21505b.showAtLocation(view, 0, 0, 0);
            m29209a(view.getContext());
        }
    }

    public static FloatingReactionsLauncher m29208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FloatingReactionsLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21503f) {
                FloatingReactionsLauncher floatingReactionsLauncher;
                if (a2 != null) {
                    floatingReactionsLauncher = (FloatingReactionsLauncher) a2.mo818a(f21503f);
                } else {
                    floatingReactionsLauncher = f21502e;
                }
                if (floatingReactionsLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29210b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21503f, b3);
                        } else {
                            f21502e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = floatingReactionsLauncher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m29211b(Context context) {
        Activity activity = (Activity) ContextUtils.m2500a(context, Activity.class);
        if (activity == null || !activity.isFinishing()) {
            m29212c(context);
            this.f21505b = new PopupWindow(this.f21506c, -1, -1);
            this.f21505b.setTouchable(false);
            this.f21505b.setFocusable(false);
            this.f21505b.setClippingEnabled(false);
            this.f21505b.setBackgroundDrawable(new ColorDrawable(0));
            this.f21505b.setInputMethodMode(2);
        }
    }

    private void m29212c(Context context) {
        if (this.f21506c == null) {
            this.f21506c = new ParticleSystemView(context);
            this.f21506c.setParticleSystemCallback(new 1(this));
        }
        this.f21506c.a();
    }

    private void m29209a(Context context) {
        if (this.f21507d == null) {
            Resources resources = context.getResources();
            float dimension = resources.getDimension(2131430650);
            float dimension2 = resources.getDimension(2131430651);
            float dimension3 = resources.getDimension(2131430652);
            float dimension4 = resources.getDimension(2131430653);
            float dimension5 = resources.getDimension(2131430654);
            float dimension6 = resources.getDimension(2131430655);
            SimpleParticleStyle simpleParticleStyle = new SimpleParticleStyle(((BitmapDrawable) resources.getDrawable(2130842924)).getBitmap());
            simpleParticleStyle.b = new RandomInRange(dimension3, dimension4);
            SimpleParticleStyle simpleParticleStyle2 = simpleParticleStyle;
            simpleParticleStyle2.c = new RandomInRange(dimension5, dimension6);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.e = new RandomInRange(dimension, dimension2);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.g = new GaussianInRange(-20.0f, 20.0f);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.f = RandomInRange.b;
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.h = new RandomInRange(0.6f, 0.75f);
            this.f21507d = simpleParticleStyle2;
        }
        m29212c(context);
        for (int i = 0; i < 20; i++) {
            this.f21506c.a(this.f21507d);
        }
    }
}
