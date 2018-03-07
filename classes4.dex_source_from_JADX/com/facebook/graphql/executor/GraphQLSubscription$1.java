package com.facebook.graphql.executor;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: rtc_speex_wb_bei */
class GraphQLSubscription$1 implements FutureCallback<GraphQLResult<T>> {
    final /* synthetic */ GraphQLSubscription f3174a;

    GraphQLSubscription$1(GraphQLSubscription graphQLSubscription) {
        this.f3174a = graphQLSubscription;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.Object r7) {
        /*
        r6 = this;
        r7 = (com.facebook.graphql.executor.GraphQLResult) r7;
        r4 = 1;
        r5 = 0;
        r0 = r6.f3174a;
        r0 = r0.a;
        r1 = r6.f3174a;
        monitor-enter(r1);
        r2 = r6.f3174a;	 Catch:{ all -> 0x003a }
        r2 = r2.j;	 Catch:{ all -> 0x003a }
        if (r2 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r6.f3174a;	 Catch:{ all -> 0x003a }
        r2 = 1;
        com.facebook.graphql.executor.GraphQLSubscription.a(r0, r2);	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0018:
        return;
    L_0x0019:
        r2 = r6.f3174a;	 Catch:{ all -> 0x003a }
        r3 = 0;
        com.facebook.graphql.executor.GraphQLSubscription.a(r2, r3);	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        if (r7 != 0) goto L_0x003d;
    L_0x0022:
        r1 = com.facebook.graphql.executor.GraphQLSubscription.class;
        r2 = "Failed to retrieve new push result %s";
        r3 = new java.lang.Object[r4];
        r4 = r0.toString();
        r3[r5] = r4;
        com.facebook.debug.log.BLog.a(r1, r2, r3);
        r1 = new com.facebook.graphql.executor.QueryNotFoundException;
        r1.<init>();
        r0.onFailure(r1);
        goto L_0x0018;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x003d:
        r1 = r6.f3174a;
        r1 = r1.e;
        if (r1 == 0) goto L_0x0051;
    L_0x0043:
        r1 = r7.d();
        r2 = r6.f3174a;
        r2 = r2.e;
        r2 = r2.get();
        if (r1 == r2) goto L_0x0018;
    L_0x0051:
        r1 = r6.f3174a;
        r2 = new java.lang.ref.WeakReference;
        r3 = r7.d();
        r2.<init>(r3);
        r1.e = r2;
        r1 = r7.i();	 Catch:{ Exception -> 0x0066 }
        r0.onSuccess(r1);	 Catch:{ Exception -> 0x0066 }
        goto L_0x0018;
    L_0x0066:
        r0 = move-exception;
        r1 = com.facebook.graphql.executor.GraphQLSubscription.class;
        r2 = "Failed to run success callback for new update";
        com.facebook.debug.log.BLog.b(r1, r2, r0);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLSubscription$1.onSuccess(java.lang.Object):void");
    }

    public void onFailure(Throwable th) {
    }
}
