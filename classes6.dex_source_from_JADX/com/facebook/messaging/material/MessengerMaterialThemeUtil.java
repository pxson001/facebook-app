package com.facebook.messaging.material;

import android.content.Context;
import com.facebook.common.util.TriState;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.abtest.ExperimentsForMessengerMaterialAbTestModule;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;

/* compiled from: is_graduate */
public class MessengerMaterialThemeUtil {
    private final Context f12061a;
    private final int f12062b;
    private TriState f12063c = TriState.UNSET;

    public MessengerMaterialThemeUtil(Context context, int i) {
        this.f12061a = context;
        this.f12062b = i;
    }

    public final boolean m18986a() {
        if (!this.f12063c.isSet()) {
            this.f12063c = TriState.valueOf(m18984a(this.f12061a, this.f12062b));
        }
        return this.f12063c.asBoolean();
    }

    public static void m18985b(Context context, int i) {
        context.getTheme().applyStyle(i, true);
    }

    public static boolean m18984a(Context context, int i) {
        FbInjector fbInjector = FbInjector.get(context);
        if (!Boolean_IsMessengerMaterialDesignEnabledMethodAutoProvider.m18982a(fbInjector).booleanValue()) {
            return false;
        }
        context.setTheme(i);
        MaterialDesignExperimentHelper b = MaterialDesignExperimentHelper.m18988b(fbInjector);
        if (b.m18989a()) {
            m18985b(context, 2131625200);
        }
        if (b.m18990b()) {
            if (b.f12071a.a(ExperimentsForMessengerMaterialAbTestModule.f12068e, false)) {
                m18985b(context, 2131625202);
            } else {
                if (b.f12071a.a(ExperimentsForMessengerMaterialAbTestModule.f12069f, false)) {
                    m18985b(context, 2131625203);
                } else {
                    m18985b(context, 2131625201);
                }
            }
        }
        return true;
    }
}
