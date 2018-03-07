package com.facebook.inject;

import com.facebook.debug.log.BLog;
import com.facebook.inject.DebugClassGraphBuilder.ProviderCall;
import com.facebook.inject.ProvisioningDebugStack.StackType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.inject.Key;
import javax.inject.Provider;

/* compiled from: default_visibility */
public class ProvisioningDebugStackProvider<T> implements Provider<T> {
    private static final DebugClassGraphBuilder f5155a = DebugClassGraphBuilder.f5119a;
    private final Key<T> f5156b;
    private final Provider<T> f5157c;

    public ProvisioningDebugStackProvider(Key<T> key, Provider<T> provider) {
        this.f5156b = key;
        this.f5157c = provider;
    }

    public T get() {
        ProvisioningDebugStack.m10030a(StackType.INSTANCE_GET, this.f5156b);
        try {
            boolean b = BLog.b(2);
            if (b) {
                TracerDetour.a("Provider.get %s", this.f5156b, 1140962540);
            }
            try {
                ProviderCall a = f5155a.m10017a(this.f5156b);
                Object obj = null;
                try {
                    obj = this.f5157c.get();
                } finally {
                    f5155a.m10018a(a, r3);
                }
                if (b) {
                    TracerDetour.a(10, -445989303);
                }
                ProvisioningDebugStack.m10029a();
                return obj;
            } catch (Throwable th) {
                if (b) {
                    TracerDetour.a(10, 937968176);
                }
            }
        } catch (Throwable th2) {
            ProvisioningDebugStack.m10029a();
        }
    }
}
