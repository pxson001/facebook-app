package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: use_oxygen_for_internal */
public class LocalFbBroadcastManager extends BaseFbBroadcastManager {
    private static LocalFbBroadcastManager f1529b;
    private static final Object f1530c = new Object();
    private final FbLocalBroadcastManager f1531a;

    private static LocalFbBroadcastManager m2947b(InjectorLike injectorLike) {
        return new LocalFbBroadcastManager(FbLocalBroadcastManagerMethodAutoProvider.m2958a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 387));
    }

    @VisibleForTesting
    public LocalFbBroadcastManager(Context context) {
        this(FbLocalBroadcastManager.m2961a(context), null);
    }

    @Inject
    public LocalFbBroadcastManager(FbLocalBroadcastManager fbLocalBroadcastManager, Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(lazy);
        this.f1531a = fbLocalBroadcastManager;
    }

    public final void mo406a(Intent intent) {
        this.f1531a.m2969a(intent);
    }

    protected final void mo405a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable Handler handler) {
        this.f1531a.m2968a(broadcastReceiver, intentFilter, handler != null ? handler.getLooper() : null);
    }

    protected final void mo404a(BroadcastReceiver broadcastReceiver) {
        this.f1531a.m2966a(broadcastReceiver);
    }

    public static LocalFbBroadcastManager m2946a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LocalFbBroadcastManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f1530c) {
                LocalFbBroadcastManager localFbBroadcastManager;
                if (a2 != null) {
                    localFbBroadcastManager = (LocalFbBroadcastManager) a2.mo818a(f1530c);
                } else {
                    localFbBroadcastManager = f1529b;
                }
                if (localFbBroadcastManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m2947b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f1530c, b3);
                        } else {
                            f1529b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = localFbBroadcastManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
