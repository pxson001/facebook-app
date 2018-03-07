package com.facebook.katana.platform;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.common.action.PlatformAppCallResultBroadcaster;
import com.facebook.platform.common.server.PlatformCommonClient;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: turn_in */
public class PlatformMediaUploadActivityReceiver {
    public static final Class<?> f1135a = PlatformMediaUploadActivityReceiver.class;
    private static volatile PlatformMediaUploadActivityReceiver f1136g;
    public final DefaultBlueServiceOperationFactory f1137b;
    public final AbstractFbErrorReporter f1138c;
    public final PlatformAppCallResultBroadcaster f1139d;
    public final PlatformCommonClient f1140e;
    public final Executor f1141f;

    /* compiled from: turn_in */
    public class C01961 implements FutureCallback<OperationResult> {
        final /* synthetic */ boolean f1133a;
        final /* synthetic */ PlatformMediaUploadActivityReceiver f1134b;

        public C01961(PlatformMediaUploadActivityReceiver platformMediaUploadActivityReceiver, boolean z) {
            this.f1134b = platformMediaUploadActivityReceiver;
            this.f1133a = z;
        }

        public void onSuccess(Object obj) {
            PlatformAppCall platformAppCall = (PlatformAppCall) ((OperationResult) obj).k();
            if (platformAppCall != null) {
                PlatformAppCallResultBroadcaster platformAppCallResultBroadcaster = this.f1134b.f1139d;
                boolean z = this.f1133a;
                String a = platformAppCallResultBroadcaster.b.a(platformAppCall.d);
                if (a != null && a.equalsIgnoreCase(platformAppCall.g)) {
                    Intent intent = new Intent("com.facebook.platform.AppCallResultBroadcast");
                    intent.setPackage(platformAppCall.d);
                    if (platformAppCall.i != null) {
                        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", platformAppCall.i);
                    }
                    intent.putExtra("com.facebook.platform.protocol.CALL_ID", platformAppCall.a);
                    if (z) {
                        intent.putExtra("com.facebook.platform.extra.DID_COMPLETE", true);
                    } else {
                        intent.putExtra("com.facebook.platform.status.ERROR_TYPE", "UnknownError");
                    }
                    intent.addFlags(32);
                    platformAppCallResultBroadcaster.a.sendBroadcast(intent);
                }
                this.f1134b.f1140e.a(platformAppCall.a);
            }
        }

        public void onFailure(Throwable th) {
            PlatformMediaUploadActivityReceiver platformMediaUploadActivityReceiver = this.f1134b;
            platformMediaUploadActivityReceiver.f1138c.a(SoftError.a(PlatformMediaUploadActivityReceiver.f1135a.getSimpleName(), "Unexpected failure of GetPendingAppCallForMediaUploadOperation call.").g());
        }
    }

    public static com.facebook.katana.platform.PlatformMediaUploadActivityReceiver m1164a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1136g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.platform.PlatformMediaUploadActivityReceiver.class;
        monitor-enter(r1);
        r0 = f1136g;	 Catch:{ all -> 0x003a }
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
        r0 = m1165b(r0);	 Catch:{ all -> 0x0035 }
        f1136g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1136g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.platform.PlatformMediaUploadActivityReceiver.a(com.facebook.inject.InjectorLike):com.facebook.katana.platform.PlatformMediaUploadActivityReceiver");
    }

    private static PlatformMediaUploadActivityReceiver m1165b(InjectorLike injectorLike) {
        return new PlatformMediaUploadActivityReceiver(DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new PlatformAppCallResultBroadcaster((Context) injectorLike.getInstance(Context.class), PlatformPackageUtilities.b(injectorLike)), PlatformCommonClient.b(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformMediaUploadActivityReceiver(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter, PlatformAppCallResultBroadcaster platformAppCallResultBroadcaster, PlatformCommonClient platformCommonClient, Executor executor) {
        this.f1137b = defaultBlueServiceOperationFactory;
        this.f1138c = abstractFbErrorReporter;
        this.f1139d = platformAppCallResultBroadcaster;
        this.f1140e = platformCommonClient;
        this.f1141f = executor;
    }
}
