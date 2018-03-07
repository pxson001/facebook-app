package com.facebook.orca.push.fbpushdata;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.methods.PushTraceInfoConfirmationMethod;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: newMessageResult */
public class PushTraceServiceHandler implements BlueServiceHandler {
    private static volatile PushTraceServiceHandler f6366c;
    public final ApiMethodRunnerImpl f6367a;
    public final PushTraceInfoConfirmationMethod f6368b;

    public static com.facebook.orca.push.fbpushdata.PushTraceServiceHandler m6015a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6366c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.push.fbpushdata.PushTraceServiceHandler.class;
        monitor-enter(r1);
        r0 = f6366c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m6016b(r0);	 Catch:{ all -> 0x0035 }
        f6366c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6366c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.push.fbpushdata.PushTraceServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.push.fbpushdata.PushTraceServiceHandler");
    }

    private static PushTraceServiceHandler m6016b(InjectorLike injectorLike) {
        return new PushTraceServiceHandler(ApiMethodRunnerImpl.a(injectorLike), PushTraceInfoConfirmationMethod.a(injectorLike));
    }

    @Inject
    public PushTraceServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, PushTraceInfoConfirmationMethod pushTraceInfoConfirmationMethod) {
        this.f6367a = apiMethodRunnerImpl;
        this.f6368b = pushTraceInfoConfirmationMethod;
    }

    public final OperationResult m6017a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("push_trace_confirmation".equals(str)) {
            this.f6367a.a(this.f6368b, operationParams.c.getString("traceInfo"));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }
}
