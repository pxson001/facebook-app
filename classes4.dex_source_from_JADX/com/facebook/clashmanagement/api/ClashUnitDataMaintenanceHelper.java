package com.facebook.clashmanagement.api;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel;
import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel.EdgesModel;
import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel.EdgesModel.NodeModel;
import com.facebook.clashmanagement.manager.ClashManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: message_count */
public class ClashUnitDataMaintenanceHelper {
    private static final Object f8118h = new Object();
    public final Lazy<ClashManager> f8119a;
    private final boolean f8120b;
    private final ClashUnitBatchComponentProvider f8121c;
    private final LightSharedPreferencesFactory f8122d;
    public final Lazy<GraphQLQueryExecutor> f8123e;
    public final ExecutorService f8124f;
    private final String f8125g;

    /* compiled from: message_count */
    public class C04471 implements FutureCallback<GraphQLResult<ClashUnitQueryModel>> {
        final /* synthetic */ ClashUnitDataMaintenanceHelper f9918a;

        public C04471(ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper) {
            this.f9918a = clashUnitDataMaintenanceHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                this.f9918a.m8399a((ClashUnitQueryModel) graphQLResult.e);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    private static ClashUnitDataMaintenanceHelper m8397b(InjectorLike injectorLike) {
        return new ClashUnitDataMaintenanceHelper(IdBasedLazy.a(injectorLike, 454), ProductMethodAutoProvider.b(injectorLike), (ClashUnitBatchComponentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ClashUnitBatchComponentProvider.class), LightSharedPreferencesFactoryMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2164), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper m8396a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8118h;	 Catch:{ all -> 0x006c }
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
        r1 = m8397b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8118h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper) r0;	 Catch:{  }
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
        r0 = f8118h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper.a(com.facebook.inject.InjectorLike):com.facebook.clashmanagement.api.ClashUnitDataMaintenanceHelper");
    }

    @Inject
    public ClashUnitDataMaintenanceHelper(Lazy<ClashManager> lazy, Product product, ClashUnitBatchComponentProvider clashUnitBatchComponentProvider, LightSharedPreferencesFactory lightSharedPreferencesFactory, Lazy<GraphQLQueryExecutor> lazy2, ExecutorService executorService, String str) {
        boolean z;
        this.f8119a = lazy;
        if (product != Product.FB4A || BuildConstants.j) {
            z = false;
        } else {
            z = true;
        }
        this.f8120b = z;
        this.f8121c = clashUnitBatchComponentProvider;
        this.f8122d = lightSharedPreferencesFactory;
        this.f8123e = lazy2;
        this.f8124f = executorService;
        this.f8125g = str;
    }

    public final boolean m8400b() {
        return this.f8120b && m8398f().a("EligibleClashUnits");
    }

    public final void m8401c() {
        if (this.f8120b) {
            Set<String> a = m8398f().a("EligibleClashUnits", new HashSet());
            Map hashMap = new HashMap();
            for (String split : a) {
                String[] split2 = split.split(":");
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            ((ClashManager) this.f8119a.get()).m10300a(hashMap);
        }
    }

    public final void m8402d() {
        if (this.f8120b) {
            m8398f().b().a().a("EligibleClashUnits", ((ClashManager) this.f8119a.get()).m10301b()).b();
        }
    }

    public final void m8399a(ClashUnitQueryModel clashUnitQueryModel) {
        Map hashMap = new HashMap();
        if (clashUnitQueryModel != null && clashUnitQueryModel.m10305a() != null) {
            ImmutableList a = clashUnitQueryModel.m10305a().m11123a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodeModel a2 = ((EdgesModel) a.get(i)).m11125a();
                hashMap.put(a2.j(), Integer.valueOf(a2.k()));
            }
            ((ClashManager) this.f8119a.get()).m10300a(hashMap);
            m8402d();
        }
    }

    public final BatchComponent m8403e() {
        InjectorLike injectorLike = this.f8121c;
        return new ClashUnitBatchComponent(((ClashManager) this.f8119a.get()).m10299a(), new ClashUnitGraphQlMethod(GraphQLProtocolHelper.a(injectorLike)), m8396a(injectorLike));
    }

    private LightSharedPreferencesImpl m8398f() {
        return this.f8122d.a("ClashUnitLightPref:" + this.f8125g);
    }
}
