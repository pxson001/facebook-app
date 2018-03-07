package com.facebook.base.broadcast;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: update_contact_is_messenger_user */
public class CrossProcessFbBroadcastManager extends PermissionBasedFbBroadcastManager {
    private static CrossProcessFbBroadcastManager f1817c;
    private static final Object f1818d = new Object();

    private static CrossProcessFbBroadcastManager m3645b(InjectorLike injectorLike) {
        return new CrossProcessFbBroadcastManager((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 387));
    }

    @Inject
    public CrossProcessFbBroadcastManager(Context context, @Nullable Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(context, context.getPackageName() + ".permission.CROSS_PROCESS_BROADCAST_MANAGER", lazy);
    }

    public final void mo406a(Intent intent) {
        super.mo406a(new Intent(intent).setPackage(this.f1819a.getPackageName()));
    }

    public static CrossProcessFbBroadcastManager m3644a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CrossProcessFbBroadcastManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f1818d) {
                CrossProcessFbBroadcastManager crossProcessFbBroadcastManager;
                if (a2 != null) {
                    crossProcessFbBroadcastManager = (CrossProcessFbBroadcastManager) a2.mo818a(f1818d);
                } else {
                    crossProcessFbBroadcastManager = f1817c;
                }
                if (crossProcessFbBroadcastManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m3645b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f1818d, b3);
                        } else {
                            f1817c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = crossProcessFbBroadcastManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
