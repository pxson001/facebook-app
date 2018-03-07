package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
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
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: total_retx */
public class GlobalFbBroadcastManager extends BaseFbBroadcastManager {
    private static GlobalFbBroadcastManager f2322b;
    private static final Object f2323c = new Object();
    protected final Context f2324a;

    private static GlobalFbBroadcastManager m4508b(InjectorLike injectorLike) {
        return new GlobalFbBroadcastManager((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 387));
    }

    @Inject
    public GlobalFbBroadcastManager(Context context, Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(lazy);
        this.f2324a = (Context) Preconditions.checkNotNull(context);
    }

    protected final void mo405a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable Handler handler) {
        this.f2324a.registerReceiver(broadcastReceiver, intentFilter, null, handler);
    }

    protected final void mo404a(BroadcastReceiver broadcastReceiver) {
        this.f2324a.unregisterReceiver(broadcastReceiver);
    }

    public final void mo406a(Intent intent) {
        this.f2324a.sendBroadcast(intent, null);
    }

    public static GlobalFbBroadcastManager m4507a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GlobalFbBroadcastManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f2323c) {
                GlobalFbBroadcastManager globalFbBroadcastManager;
                if (a2 != null) {
                    globalFbBroadcastManager = (GlobalFbBroadcastManager) a2.mo818a(f2323c);
                } else {
                    globalFbBroadcastManager = f2322b;
                }
                if (globalFbBroadcastManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m4508b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f2323c, b3);
                        } else {
                            f2322b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = globalFbBroadcastManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
