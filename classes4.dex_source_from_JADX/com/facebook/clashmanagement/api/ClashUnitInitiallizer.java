package com.facebook.clashmanagement.api;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper.C04471;
import com.facebook.clashmanagement.api.ClashUnitQuery.ClashUnitQueryString;
import com.facebook.clashmanagement.manager.ClashManager;
import com.facebook.common.init.INeedInit;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

@UserScoped
/* compiled from: message_lifetime */
public class ClashUnitInitiallizer implements INeedInit {
    private static final Object f8116b = new Object();
    private final ClashUnitDataMaintenanceHelper f8117a;

    private static ClashUnitInitiallizer m8395b(InjectorLike injectorLike) {
        return new ClashUnitInitiallizer(ClashUnitDataMaintenanceHelper.m8396a(injectorLike));
    }

    @Inject
    public ClashUnitInitiallizer(ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper) {
        this.f8117a = clashUnitDataMaintenanceHelper;
    }

    public void init() {
        ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper = this.f8117a;
        ClashManager clashManager = (ClashManager) clashUnitDataMaintenanceHelper.f8119a.get();
        if (clashUnitDataMaintenanceHelper.m8400b()) {
            clashUnitDataMaintenanceHelper.m8401c();
            return;
        }
        ClashUnitQueryString a = ClashUnitQuery.m10302a();
        a.a("names", clashManager.m10299a());
        Futures.a(((GraphQLQueryExecutor) clashUnitDataMaintenanceHelper.f8123e.get()).a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c)), new C04471(clashUnitDataMaintenanceHelper), clashUnitDataMaintenanceHelper.f8124f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.clashmanagement.api.ClashUnitInitiallizer m8394a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8116b;	 Catch:{ all -> 0x006c }
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
        r1 = m8395b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8116b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.api.ClashUnitInitiallizer) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.clashmanagement.api.ClashUnitInitiallizer) r0;	 Catch:{  }
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
        r0 = f8116b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.api.ClashUnitInitiallizer) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.clashmanagement.api.ClashUnitInitiallizer.a(com.facebook.inject.InjectorLike):com.facebook.clashmanagement.api.ClashUnitInitiallizer");
    }
}
