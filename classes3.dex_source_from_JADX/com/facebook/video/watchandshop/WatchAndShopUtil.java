package com.facebook.video.watchandshop;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: channel */
public class WatchAndShopUtil {
    private static WatchAndShopUtil f247b;
    private static final Object f248c = new Object();
    public QeAccessor f249a;

    private static WatchAndShopUtil m227b(InjectorLike injectorLike) {
        return new WatchAndShopUtil((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WatchAndShopUtil(QeAccessor qeAccessor) {
        this.f249a = qeAccessor;
    }

    public static WatchAndShopUtil m226a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WatchAndShopUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f248c) {
                WatchAndShopUtil watchAndShopUtil;
                if (a2 != null) {
                    watchAndShopUtil = (WatchAndShopUtil) a2.a(f248c);
                } else {
                    watchAndShopUtil = f247b;
                }
                if (watchAndShopUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m227b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f248c, b3);
                        } else {
                            f247b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = watchAndShopUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
