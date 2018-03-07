package com.facebook.katana.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.facebook.apptab.ui.CaspianTabViewUtil;
import com.facebook.apptab.ui.CaspianTabViewUtil.Theme;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(11)
@ContextScoped
/* compiled from: sponsored_impressions_log_viewability_enabled */
public class ThemeTransitionHelper {
    private static ThemeTransitionHelper f4200g;
    private static final Object f4201h = new Object();
    private final CaspianTabViewUtil f4202a;
    private final Lazy<SpringSystem> f4203b;
    private final List<TransitionView> f4204c = new ArrayList();
    private double f4205d;
    private Spring f4206e;
    private int f4207f = -1;

    /* compiled from: sponsored_impressions_log_viewability_enabled */
    class TransitionView {
        final /* synthetic */ ThemeTransitionHelper f4229a;
        private final ColorDrawable f4230b;
        private final int f4231c;
        private final int f4232d;
        private final int f4233e;
        private final int f4234f;
        private final int f4235g;
        private final int f4236h;

        public TransitionView(ThemeTransitionHelper themeTransitionHelper, ColorDrawable colorDrawable, int i) {
            this.f4229a = themeTransitionHelper;
            this.f4230b = colorDrawable;
            int color = colorDrawable.getColor();
            this.f4234f = Color.red(color);
            this.f4235g = Color.green(color);
            this.f4236h = Color.blue(color);
            this.f4231c = Color.red(i);
            this.f4232d = Color.green(i);
            this.f4233e = Color.blue(i);
        }

        public final void m7832a(double d) {
            double d2 = 1.0d - d;
            ((ColorDrawable) this.f4230b.mutate()).setColor(Color.rgb((int) ((((double) this.f4231c) * d) + (((double) this.f4234f) * d2)), (int) ((((double) this.f4232d) * d) + (((double) this.f4235g) * d2)), (int) ((d2 * ((double) this.f4236h)) + (((double) this.f4233e) * d))));
        }
    }

    /* compiled from: sponsored_impressions_log_viewability_enabled */
    class TransitionSpringListener extends SimpleSpringListener {
        final /* synthetic */ ThemeTransitionHelper f4247a;

        public TransitionSpringListener(ThemeTransitionHelper themeTransitionHelper) {
            this.f4247a = themeTransitionHelper;
        }

        public final void mo1160a(Spring spring) {
            boolean z;
            ThemeTransitionHelper themeTransitionHelper = this.f4247a;
            double d = spring.m7821d();
            if (spring.f4222i > 0.0d) {
                z = true;
            } else {
                z = false;
            }
            ThemeTransitionHelper.m7799a(themeTransitionHelper, d, z);
        }

        public final void mo1161b(Spring spring) {
            if (spring.m7827g(0.0d)) {
                ThemeTransitionHelper.m7799a(this.f4247a, 0.0d, false);
            } else if (spring.m7827g(1.0d)) {
                ThemeTransitionHelper.m7799a(this.f4247a, 1.0d, true);
            }
        }
    }

    private static ThemeTransitionHelper m7800b(InjectorLike injectorLike) {
        return new ThemeTransitionHelper(CaspianTabViewUtil.m7806a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3433));
    }

    @Inject
    public ThemeTransitionHelper(CaspianTabViewUtil caspianTabViewUtil, Lazy<SpringSystem> lazy) {
        this.f4202a = caspianTabViewUtil;
        this.f4203b = lazy;
    }

    public final ThemeTransitionHelper m7804a(@Nullable View view, int i) {
        if (view != null) {
            Drawable background = view.getBackground();
            if (background instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) background;
                if (VERSION.SDK_INT == 16) {
                    Drawable colorDrawable2 = new ColorDrawable(colorDrawable.getColor());
                    view.setBackgroundDrawable(colorDrawable2);
                    colorDrawable = colorDrawable2;
                }
                this.f4204c.add(new TransitionView(this, colorDrawable, i));
            }
        }
        return this;
    }

    public static ThemeTransitionHelper m7797a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThemeTransitionHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4201h) {
                ThemeTransitionHelper themeTransitionHelper;
                if (a2 != null) {
                    themeTransitionHelper = (ThemeTransitionHelper) a2.mo818a(f4201h);
                } else {
                    themeTransitionHelper = f4200g;
                }
                if (themeTransitionHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m7800b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4201h, b3);
                        } else {
                            f4200g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = themeTransitionHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ThemeTransitionHelper m7803a(int i) {
        this.f4207f = i;
        return this;
    }

    private void m7798a() {
        m7802c();
        this.f4206e.m7818b(1.0d);
    }

    private void m7801b() {
        m7802c();
        this.f4206e.m7818b(0.0d);
    }

    public final void m7805a(int i, float f, int i2, FragmentActivity fragmentActivity) {
        if (this.f4207f >= 0) {
            int i3 = (i2 == -1 || i2 == this.f4207f) ? 1 : 0;
            if (i3 == 0 || ((i != this.f4207f - 1 || ((double) f) <= 0.5d) && (i != this.f4207f || ((double) f) >= 0.5d))) {
                if (VERSION.SDK_INT >= 21) {
                    fragmentActivity.getWindow().setStatusBarColor(ContextUtils.m2503c(fragmentActivity, 2130772558, 0));
                }
                m7801b();
                return;
            }
            if (VERSION.SDK_INT >= 21) {
                fragmentActivity.getWindow().setStatusBarColor(ContextCompat.m7855b(fragmentActivity, 2131362144));
            }
            m7798a();
        }
    }

    public static void m7799a(ThemeTransitionHelper themeTransitionHelper, double d, boolean z) {
        if (d == 0.0d || d == 1.0d || Math.abs(themeTransitionHelper.f4205d - d) >= 0.01d) {
            themeTransitionHelper.f4205d = d;
            for (TransitionView a : themeTransitionHelper.f4204c) {
                a.m7832a(d);
            }
            if (z) {
                themeTransitionHelper.f4202a.f4213d = Theme.DARK;
                return;
            }
            themeTransitionHelper.f4202a.f4213d = Theme.LIGHT;
        }
    }

    private void m7802c() {
        if (this.f4206e == null) {
            Spring l = ((SpringSystem) this.f4203b.get()).m7838a().m7814a(SpringConfig.m7842a(40.0d, 8.0d)).m7813a(0.0d).m7818b(0.0d).m7830l();
            l.f4216c = true;
            this.f4206e = l;
            this.f4206e.m7815a(new TransitionSpringListener(this));
        }
    }
}
