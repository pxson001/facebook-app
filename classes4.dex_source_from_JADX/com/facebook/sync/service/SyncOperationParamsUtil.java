package com.facebook.sync.service;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.connection.SyncConnectionHandler.ConnectionFreshness;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: fql_user_nux_status */
public class SyncOperationParamsUtil {
    private static volatile SyncOperationParamsUtil f11452a;

    public static com.facebook.sync.service.SyncOperationParamsUtil m11907a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11452a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.sync.service.SyncOperationParamsUtil.class;
        monitor-enter(r1);
        r0 = f11452a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11906a();	 Catch:{ all -> 0x0034 }
        f11452a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11452a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.service.SyncOperationParamsUtil.a(com.facebook.inject.InjectorLike):com.facebook.sync.service.SyncOperationParamsUtil");
    }

    private static SyncOperationParamsUtil m11906a() {
        return new SyncOperationParamsUtil();
    }

    public static <T extends Serializable> T m11908a(OperationParams operationParams) {
        return operationParams.c.getSerializable("syncPayload");
    }

    public static FbTraceNode m11909b(OperationParams operationParams) {
        return (FbTraceNode) operationParams.c.getParcelable("fbTraceNode");
    }

    public static FullRefreshParams m11910c(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        return new FullRefreshParams((FullRefreshReason) Preconditions.checkNotNull((FullRefreshReason) bundle.getParcelable("fullRefreshReason")), bundle.getString("syncTokenToReplace"));
    }

    public static ConnectionFreshness m11911d(OperationParams operationParams) {
        ConnectionFreshness connectionFreshness = (ConnectionFreshness) operationParams.c.getSerializable("connectionFreshness");
        if (connectionFreshness == null) {
            return ConnectionFreshness.ENSURE;
        }
        return connectionFreshness;
    }

    public static Bundle m11905a(ConnectionFreshness connectionFreshness) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("connectionFreshness", connectionFreshness);
        return bundle;
    }
}
