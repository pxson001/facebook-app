package com.facebook.messaging.localfetch;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.FetchThreadUsersParams;
import com.facebook.messaging.service.model.FetchThreadUsersResult;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: mPaymentPlatformItem */
public class LocalFetchServiceHandler implements BlueServiceHandler {
    private static final Object f11373c = new Object();
    public final FetchUserHandler f11374a;
    public final MonotonicClock f11375b;

    private static LocalFetchServiceHandler m11964b(InjectorLike injectorLike) {
        return new LocalFetchServiceHandler(FetchUserHandler.m11956a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LocalFetchServiceHandler(FetchUserHandler fetchUserHandler, MonotonicClock monotonicClock) {
        this.f11374a = fetchUserHandler;
        this.f11375b = monotonicClock;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.localfetch.LocalFetchServiceHandler m11963a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f11373c;	 Catch:{ all -> 0x006c }
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
        r1 = m11964b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11373c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.localfetch.LocalFetchServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.localfetch.LocalFetchServiceHandler) r0;	 Catch:{  }
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
        r0 = f11373c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.localfetch.LocalFetchServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.localfetch.LocalFetchServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.localfetch.LocalFetchServiceHandler");
    }

    public final OperationResult m11965a(OperationParams operationParams) {
        String str = operationParams.b;
        Object obj = -1;
        switch (str.hashCode()) {
            case 897221699:
                if (str.equals("fetch_users")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                Bundle bundle = operationParams.c;
                if (bundle == null) {
                    OperationResult.a(ErrorCode.OTHER, "Params can't be null.");
                }
                FetchThreadUsersParams fetchThreadUsersParams = (FetchThreadUsersParams) bundle.getParcelable("FetchThreadUsersParams");
                List arrayList = new ArrayList();
                ImmutableList immutableList = fetchThreadUsersParams.f17186a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    User a = this.f11374a.m11960a((UserKey) immutableList.get(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return OperationResult.a(new FetchThreadUsersResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, this.f11375b.now(), arrayList));
            default:
                throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }
}
