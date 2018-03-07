package com.facebook.apptab.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: structured_survey/intern_dev_mode_recent_survey_ ids */
public class AppTabBarBroadcaster {
    private static AppTabBarBroadcaster f3951b;
    private static final Object f3952c = new Object();
    public final BaseFbBroadcastManager f3953a;

    private static AppTabBarBroadcaster m6552b(InjectorLike injectorLike) {
        return new AppTabBarBroadcaster(LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public AppTabBarBroadcaster(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f3953a = baseFbBroadcastManager;
    }

    public static String m6551a(Intent intent) {
        return intent.getStringExtra("tab_bar_tap");
    }

    public static AppTabBarBroadcaster m6550a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppTabBarBroadcaster b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f3952c) {
                AppTabBarBroadcaster appTabBarBroadcaster;
                if (a2 != null) {
                    appTabBarBroadcaster = (AppTabBarBroadcaster) a2.mo818a(f3952c);
                } else {
                    appTabBarBroadcaster = f3951b;
                }
                if (appTabBarBroadcaster == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m6552b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f3952c, b3);
                        } else {
                            f3951b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = appTabBarBroadcaster;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
