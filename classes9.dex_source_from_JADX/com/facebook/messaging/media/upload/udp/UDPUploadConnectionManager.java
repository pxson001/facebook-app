package com.facebook.messaging.media.upload.udp;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.udp.UDPConnectionMethod.UDPConnectionParams;
import com.facebook.messaging.media.upload.udp.UDPMetadataUploadMethod.UDPUploadParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_activity_opened */
public class UDPUploadConnectionManager {
    private static volatile UDPUploadConnectionManager f12214j;
    public final ApiMethodRunnerImpl f12215a;
    public final UDPConnectionMethod f12216b;
    public final ApiMethodRunnerParams f12217c = new ApiMethodRunnerParams();
    private final ListeningExecutorService f12218d;
    private final DefaultBlueServiceOperationFactory f12219e;
    private final Clock f12220f;
    private final AtomicLong f12221g;
    private final AtomicReference<UDPServerConfig> f12222h;
    private final List<ServerConfigChangeListener> f12223i;

    /* compiled from: last_activity_opened */
    class C13531 extends OperationResultFutureCallback2 {
        final /* synthetic */ UDPUploadConnectionManager f12211a;

        C13531(UDPUploadConnectionManager uDPUploadConnectionManager) {
            this.f12211a = uDPUploadConnectionManager;
        }

        protected final void m12707a(OperationResult operationResult) {
            UDPUploadConnectionManager.m12714b(this.f12211a, (UDPServerConfig) operationResult.h());
        }
    }

    /* compiled from: last_activity_opened */
    class UDPConnectionCallable implements Callable<UDPServerConfig> {
        final /* synthetic */ UDPUploadConnectionManager f12212a;
        private final UDPConnectionParams f12213b;

        public UDPConnectionCallable(UDPUploadConnectionManager uDPUploadConnectionManager, UDPConnectionParams uDPConnectionParams) {
            this.f12212a = uDPUploadConnectionManager;
            this.f12213b = uDPConnectionParams;
        }

        public Object call() {
            return (UDPServerConfig) this.f12212a.f12215a.a(this.f12212a.f12216b, this.f12213b, this.f12212a.f12217c);
        }
    }

    public static com.facebook.messaging.media.upload.udp.UDPUploadConnectionManager m12710a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12214j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.udp.UDPUploadConnectionManager.class;
        monitor-enter(r1);
        r0 = f12214j;	 Catch:{ all -> 0x003a }
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
        r0 = m12713b(r0);	 Catch:{ all -> 0x0035 }
        f12214j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12214j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPUploadConnectionManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.UDPUploadConnectionManager");
    }

    private static UDPUploadConnectionManager m12713b(InjectorLike injectorLike) {
        return new UDPUploadConnectionManager(ApiMethodRunnerImpl.a(injectorLike), UDPConnectionMethod.m12677a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UDPUploadConnectionManager(ApiMethodRunnerImpl apiMethodRunnerImpl, UDPConnectionMethod uDPConnectionMethod, ListeningExecutorService listeningExecutorService, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Clock clock) {
        this.f12215a = apiMethodRunnerImpl;
        this.f12216b = uDPConnectionMethod;
        this.f12218d = listeningExecutorService;
        this.f12219e = defaultBlueServiceOperationFactory;
        this.f12220f = clock;
        this.f12221g = new AtomicLong(0);
        this.f12222h = new AtomicReference();
        this.f12223i = new ArrayList();
    }

    public final synchronized void m12717a(UDPPacketManager uDPPacketManager) {
        this.f12223i.add(uDPPacketManager);
    }

    private synchronized void m12712a(UDPServerConfig uDPServerConfig) {
        for (UDPPacketManager a : this.f12223i) {
            a.m12705a(uDPServerConfig);
        }
    }

    private void m12711a(long j) {
        if (this.f12222h.get() == null) {
            m12714b(this, (UDPServerConfig) FutureDetour.a(this.f12218d.a(new UDPConnectionCallable(this, new UDPConnectionParams(j))), 1609575795));
        } else if (this.f12220f.a() - this.f12221g.get() >= 1800000) {
            m12709a("udp_connection_refresh_server_config", new UDPConnectionParams(j));
        }
    }

    public final ListenableFuture<OperationResult> m12716a(MediaResource mediaResource, String str, UDPUploadSession uDPUploadSession) {
        return m12715c(mediaResource, str, uDPUploadSession);
    }

    public final ListenableFuture<OperationResult> m12718b(MediaResource mediaResource, String str, UDPUploadSession uDPUploadSession) {
        m12711a(uDPUploadSession.f12224a);
        return m12715c(mediaResource, str, uDPUploadSession);
    }

    private ListenableFuture<OperationResult> m12715c(MediaResource mediaResource, String str, UDPUploadSession uDPUploadSession) {
        return m12709a("udp_connection_upload_metadata", new UDPUploadParams(mediaResource, str, uDPUploadSession.f12225b, uDPUploadSession.f12224a));
    }

    private OperationFuture m12709a(String str, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("udp_parcel_key", parcelable);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f12219e, str, bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -931944701).a();
        Futures.a(a, new C13531(this), MoreExecutors.a());
        return a;
    }

    public static void m12714b(UDPUploadConnectionManager uDPUploadConnectionManager, UDPServerConfig uDPServerConfig) {
        uDPUploadConnectionManager.f12222h.set(uDPServerConfig);
        uDPUploadConnectionManager.f12221g.set(uDPUploadConnectionManager.f12220f.a());
        uDPUploadConnectionManager.m12712a(uDPServerConfig);
    }
}
