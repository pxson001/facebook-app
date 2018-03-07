package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$12 implements Runnable {
    final /* synthetic */ GraphQLWriteLock f11708a;
    final /* synthetic */ Callable f11709b;
    final /* synthetic */ SettableFuture f11710c;
    final /* synthetic */ ConsistencyMemoryCache f11711d;
    final /* synthetic */ FeedbackGraphQLGenerator f11712e;

    FeedbackGraphQLGenerator$12(FeedbackGraphQLGenerator feedbackGraphQLGenerator, GraphQLWriteLock graphQLWriteLock, Callable callable, SettableFuture settableFuture, ConsistencyMemoryCache consistencyMemoryCache) {
        this.f11712e = feedbackGraphQLGenerator;
        this.f11708a = graphQLWriteLock;
        this.f11709b = callable;
        this.f11710c = settableFuture;
        this.f11711d = consistencyMemoryCache;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
        r0 = r3.f11708a;	 Catch:{ Throwable -> 0x0019 }
        r0.g();	 Catch:{ Throwable -> 0x0019 }
        r0 = r3.f11709b;	 Catch:{ Throwable -> 0x0019 }
        r0 = r0.call();	 Catch:{ Throwable -> 0x0019 }
        r0 = (com.facebook.fbservice.service.OperationResult) r0;	 Catch:{ Throwable -> 0x0019 }
        r1 = r0.b();	 Catch:{ Throwable -> 0x0019 }
        if (r1 != 0) goto L_0x0037;
    L_0x0013:
        r1 = new com.facebook.fbservice.service.ServiceException;	 Catch:{ Throwable -> 0x0019 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0019 }
        throw r1;	 Catch:{ Throwable -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        r1 = r3.f11708a;	 Catch:{ all -> 0x005b }
        r2 = 0;
        r1.a(r2);	 Catch:{ all -> 0x005b }
        r1 = r3.f11710c;	 Catch:{ all -> 0x005b }
        r2 = r0 instanceof java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x002a;
    L_0x0026:
        r0 = r0.getCause();	 Catch:{ all -> 0x005b }
    L_0x002a:
        r0 = com.facebook.fbservice.service.ServiceException.a(r0);	 Catch:{ all -> 0x005b }
        r1.a(r0);	 Catch:{ all -> 0x005b }
        r0 = r3.f11708a;
        r0.e();
    L_0x0036:
        return;
    L_0x0037:
        r1 = r3.f11708a;	 Catch:{  }
        r2 = 1;
        r1.a(r2);	 Catch:{  }
        r1 = r3.f11710c;	 Catch:{  }
        r2 = -597937836; // 0xffffffffdc5c3154 float:-2.47914927E17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.FutureDetour.a(r1, r0, r2);	 Catch:{  }
        r0 = r3.f11708a;	 Catch:{ Throwable -> 0x0062 }
        r0.c();	 Catch:{ Throwable -> 0x0062 }
        r0 = r3.f11712e;	 Catch:{ Throwable -> 0x0062 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x0062 }
        r1 = r3.f11708a;	 Catch:{ Throwable -> 0x0062 }
        r2 = r3.f11711d;	 Catch:{ Throwable -> 0x0062 }
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x0062 }
    L_0x0055:
        r0 = r3.f11708a;
        r0.e();
        goto L_0x0036;
    L_0x005b:
        r0 = move-exception;
        r1 = r3.f11708a;
        r1.e();
        throw r0;
    L_0x0062:
        r0 = move-exception;
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.controller.mutation.util.FeedbackGraphQLGenerator$12.run():void");
    }
}
