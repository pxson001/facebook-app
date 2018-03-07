package com.facebook.clashmanagement.manager;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@UserScoped
/* compiled from: is_reliability_check_enabled */
public class ClashManager {
    private static final Object f9911d = new Object();
    private final Set<ClashUnit> f9912a;
    private final Clock f9913b;
    @GuardedBy("this")
    private final Map<ClashLocation, ClashSessionTracker> f9914c = new HashMap();

    private static ClashManager m10298b(InjectorLike injectorLike) {
        return new ClashManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ClashUnit(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ClashManager(Set<ClashUnit> set, Clock clock) {
        this.f9912a = set;
        this.f9913b = clock;
    }

    public final synchronized void m10300a(Map<String, Integer> map) {
        for (ClashUnitBase clashUnitBase : this.f9912a) {
            if (map.containsKey(clashUnitBase.m10307a())) {
                int intValue = ((Integer) map.get(clashUnitBase.m10307a())).intValue();
                for (ClashLocation clashLocation : clashUnitBase.m10308b()) {
                    ClashSessionTracker clashSessionTracker = (ClashSessionTracker) this.f9914c.get(clashLocation);
                    if (clashSessionTracker == null) {
                        clashSessionTracker = new ClashSessionTracker(clashLocation);
                        this.f9914c.put(clashLocation, clashSessionTracker);
                    }
                    clashSessionTracker.a(clashUnitBase, intValue);
                }
            } else {
                for (ClashLocation clashLocation2 : clashUnitBase.m10308b()) {
                    ClashSessionTracker clashSessionTracker2 = (ClashSessionTracker) this.f9914c.get(clashLocation2);
                    if (clashSessionTracker2 != null) {
                        clashSessionTracker2.a(clashUnitBase);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.clashmanagement.manager.ClashManager m10297a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f9911d;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m10298b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9911d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.manager.ClashManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.clashmanagement.manager.ClashManager) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f9911d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.manager.ClashManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.clashmanagement.manager.ClashManager.a(com.facebook.inject.InjectorLike):com.facebook.clashmanagement.manager.ClashManager");
    }

    public final List<String> m10299a() {
        List<String> arrayList = new ArrayList(this.f9912a.size());
        for (ClashUnitBase clashUnitBase : this.f9912a) {
            arrayList.add("");
        }
        return arrayList;
    }

    public final synchronized Set<String> m10301b() {
        Set<String> hashSet;
        hashSet = new HashSet();
        for (ClashSessionTracker a : this.f9914c.values()) {
            hashSet.addAll(a.a());
        }
        return hashSet;
    }
}
