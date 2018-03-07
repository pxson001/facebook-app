package com.facebook.base.broadcast;

import android.content.Context;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.build.SignatureType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: unknown_activity_root */
public class CrossFbAppBroadcastManager extends PermissionBasedFbBroadcastManager {
    private static CrossFbAppBroadcastManager f1948c;
    private static final Object f1949d = new Object();

    private static CrossFbAppBroadcastManager m3886b(InjectorLike injectorLike) {
        return new CrossFbAppBroadcastManager((Context) injectorLike.getInstance(Context.class), SignatureTypeMethodAutoProvider.m2801b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 387));
    }

    @Inject
    public CrossFbAppBroadcastManager(Context context, SignatureType signatureType, Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(context, signatureType.getPermission(), lazy);
    }

    public static CrossFbAppBroadcastManager m3885a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CrossFbAppBroadcastManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f1949d) {
                CrossFbAppBroadcastManager crossFbAppBroadcastManager;
                if (a2 != null) {
                    crossFbAppBroadcastManager = (CrossFbAppBroadcastManager) a2.mo818a(f1949d);
                } else {
                    crossFbAppBroadcastManager = f1948c;
                }
                if (crossFbAppBroadcastManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m3886b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f1949d, b3);
                        } else {
                            f1948c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = crossFbAppBroadcastManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
