package com.facebook.auth.login;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.userscope.UserScope;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.service.BlueServiceQueueManager;
import com.facebook.graphql.executor.GraphQLQueryExecutorRequestManager;
import com.facebook.graphql.pending.GraphQLPendingRequestManager;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: tags_count */
public class AuthDataStoreLogoutHelper {
    private final DefaultAndroidThreadUtil f1309a;
    private final BlueServiceQueueManager f1310b;
    private final FbHttpRequestProcessor f1311c;
    private final LoggedInUserSessionManager f1312d;
    private final UserScope f1313e;
    private final GraphQLPendingRequestManager f1314f;

    public static AuthDataStoreLogoutHelper m1548a(InjectorLike injectorLike) {
        return new AuthDataStoreLogoutHelper(DefaultAndroidThreadUtil.b(injectorLike), BlueServiceQueueManager.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), (UserScope) injectorLike.getInstance(UserScope.class), GraphQLQueryExecutorRequestManager.m1550a(injectorLike));
    }

    @Inject
    public AuthDataStoreLogoutHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, BlueServiceQueueManager blueServiceQueueManager, FbHttpRequestProcessor fbHttpRequestProcessor, LoggedInUserSessionManager loggedInUserSessionManager, UserScope userScope, GraphQLPendingRequestManager graphQLPendingRequestManager) {
        this.f1309a = defaultAndroidThreadUtil;
        this.f1310b = blueServiceQueueManager;
        this.f1311c = fbHttpRequestProcessor;
        this.f1312d = loggedInUserSessionManager;
        this.f1313e = userScope;
        this.f1314f = graphQLPendingRequestManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1549a(java.lang.Runnable r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        r2 = r3.f1309a;
        r2.b();
        r2 = r3.f1310b;
        r2.a();
        r2 = r3.f1311c;	 Catch:{ all -> 0x005a }
        r2.b();	 Catch:{ all -> 0x005a }
        r2 = r3.f1311c;	 Catch:{ all -> 0x0053 }
        r2.d();	 Catch:{ all -> 0x0053 }
        r2 = r3.f1310b;	 Catch:{ all -> 0x0053 }
        r2.d();	 Catch:{ all -> 0x0053 }
        r2 = r3.f1314f;	 Catch:{ all -> 0x0053 }
        r2.mo86a();	 Catch:{ all -> 0x0053 }
        r4.run();	 Catch:{ all -> 0x0053 }
        r2 = r3.f1312d;	 Catch:{ all -> 0x0053 }
        r2 = r2.b();	 Catch:{ all -> 0x0053 }
        if (r2 != 0) goto L_0x004f;
    L_0x002b:
        r2 = r0;
    L_0x002c:
        com.google.common.base.Preconditions.checkState(r2);	 Catch:{ all -> 0x0053 }
        r2 = r3.f1312d;	 Catch:{ all -> 0x0053 }
        r2 = r2.a();	 Catch:{ all -> 0x0053 }
        if (r2 != 0) goto L_0x0051;
    L_0x0037:
        com.google.common.base.Preconditions.checkState(r0);	 Catch:{ all -> 0x0053 }
        r0 = r3.f1313e;	 Catch:{ all -> 0x0053 }
        r0.a();	 Catch:{ all -> 0x0053 }
        r0 = r3.f1311c;	 Catch:{  }
        r0.c();	 Catch:{  }
        r0 = r3.f1310b;
        r0.b();
        r0 = r3.f1314f;
        r0.mo87b();
        return;
    L_0x004f:
        r2 = r1;
        goto L_0x002c;
    L_0x0051:
        r0 = r1;
        goto L_0x0037;
    L_0x0053:
        r0 = move-exception;
        r1 = r3.f1311c;	 Catch:{  }
        r1.c();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x005a:
        r0 = move-exception;
        r1 = r3.f1310b;
        r1.b();
        r1 = r3.f1314f;
        r1.mo87b();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.AuthDataStoreLogoutHelper.a(java.lang.Runnable):void");
    }
}
