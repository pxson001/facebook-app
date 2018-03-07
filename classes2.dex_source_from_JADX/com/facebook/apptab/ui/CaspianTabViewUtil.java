package com.facebook.apptab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.SpringUtil;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import java.lang.reflect.Array;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: sponsored_impressions_log_percent_enabled */
public class CaspianTabViewUtil {
    private static CaspianTabViewUtil f4208e;
    private static final Object f4209f = new Object();
    private final ColorFilter[][] f4210a = ((ColorFilter[][]) Array.newInstance(ColorFilter.class, new int[]{Theme.values().length, 26}));
    public final String f4211b;
    public final String f4212c;
    public Theme f4213d = Theme.LIGHT;

    /* compiled from: sponsored_impressions_log_percent_enabled */
    public enum Theme {
        LIGHT,
        DARK
    }

    private static CaspianTabViewUtil m7808b(InjectorLike injectorLike) {
        return new CaspianTabViewUtil(ResourcesMethodAutoProvider.m6510a(injectorLike), TabletExperimentConfiguration.m7856a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1));
    }

    @Inject
    public CaspianTabViewUtil(Resources resources, TabletExperimentConfiguration tabletExperimentConfiguration, Provider<Activity> provider) {
        Activity activity = (Activity) provider.get();
        int c = ContextUtils.m2503c(activity, 2130772524, 2131362584);
        int c2 = ContextUtils.m2503c(activity, 2130772523, 2131361916);
        int c3 = ContextUtils.m2503c(activity, 2130772526, 2131362585);
        int c4 = ContextUtils.m2503c(activity, 2130772525, 2131361920);
        if (tabletExperimentConfiguration.m7863i()) {
            m7807a(Theme.LIGHT, resources.getColor(2131362583), resources.getColor(2131362582));
        } else {
            m7807a(Theme.LIGHT, c, c2);
        }
        m7807a(Theme.DARK, c3, c4);
        this.f4211b = resources.getString(2131232634);
        this.f4212c = resources.getString(2131232635);
    }

    public static CaspianTabViewUtil m7806a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CaspianTabViewUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4209f) {
                CaspianTabViewUtil caspianTabViewUtil;
                if (a2 != null) {
                    caspianTabViewUtil = (CaspianTabViewUtil) a2.mo818a(f4209f);
                } else {
                    caspianTabViewUtil = f4208e;
                }
                if (caspianTabViewUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m7808b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4209f, b3);
                        } else {
                            f4208e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = caspianTabViewUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m7807a(Theme theme, int i, int i2) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int alpha2 = Color.alpha(i2);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        for (int i3 = 0; i3 <= 25; i3++) {
            float f = ((float) i3) / 25.0f;
            this.f4210a[theme.ordinal()][i3] = new PorterDuffColorFilter((((int) (f * ((float) (blue2 - blue)))) + blue) | ((((((int) (((float) (alpha2 - alpha)) * f)) + alpha) << 24) | ((((int) (((float) (red2 - red)) * f)) + red) << 16)) | ((((int) (((float) (green2 - green)) * f)) + green) << 8)), Mode.SRC_IN);
        }
    }

    public final ColorFilter m7809a(double d) {
        return this.f4210a[this.f4213d.ordinal()][(int) (SpringUtil.m11941a(d, 0.0d, 1.0d) * 25.0d)];
    }
}
