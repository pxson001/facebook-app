package com.facebook.http.common;

import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.client.methods.HttpUriRequest;

@Singleton
/* compiled from: recent_save_info_timeframe */
public class FbHttpRequestDebugLogger {
    private static volatile FbHttpRequestDebugLogger f7882c;
    private final FbSharedPreferences f7883a;
    public final Provider<FbHttpRequestProcessor> f7884b;

    /* compiled from: recent_save_info_timeframe */
    enum Status {
        ARRIVE,
        START,
        PRIORITY,
        NO_CHANGE,
        DROP,
        CANCEL,
        CANCELLED,
        FINISHED,
        FAILED
    }

    public static com.facebook.http.common.FbHttpRequestDebugLogger m12470a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7882c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.FbHttpRequestDebugLogger.class;
        monitor-enter(r1);
        r0 = f7882c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12476b(r0);	 Catch:{ all -> 0x0035 }
        f7882c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7882c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.FbHttpRequestDebugLogger.a(com.facebook.inject.InjectorLike):com.facebook.http.common.FbHttpRequestDebugLogger");
    }

    private static FbHttpRequestDebugLogger m12476b(InjectorLike injectorLike) {
        return new FbHttpRequestDebugLogger(FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2217));
    }

    @Inject
    public FbHttpRequestDebugLogger(FbSharedPreferences fbSharedPreferences, Provider<FbHttpRequestProcessor> provider) {
        this.f7883a = fbSharedPreferences;
        this.f7884b = provider;
    }

    public final <T> void m12480a(FbHttpRequest<T> fbHttpRequest, ListenableFuture<T> listenableFuture) {
        if (m12477b()) {
            m12471a(Status.ARRIVE, (FbHttpRequest) fbHttpRequest);
            Futures.m2458a((ListenableFuture) listenableFuture, new 1(this, fbHttpRequest), (Executor) DirectExecutor.INSTANCE);
        }
    }

    public final void m12478a(FbHttpRequest fbHttpRequest) {
        m12471a(Status.START, fbHttpRequest);
    }

    public final void m12481b(FbHttpRequest fbHttpRequest) {
        m12471a(Status.CANCEL, fbHttpRequest);
    }

    public final void m12479a(FbHttpRequest fbHttpRequest, RequestPriority requestPriority) {
        m12472a(Status.PRIORITY, fbHttpRequest, requestPriority);
    }

    public final void m12482c(FbHttpRequest fbHttpRequest) {
        m12471a(Status.NO_CHANGE, fbHttpRequest);
    }

    public static void m12473a(FbHttpRequestDebugLogger fbHttpRequestDebugLogger, @Nullable FbHttpRequest fbHttpRequest, Throwable th) {
        if (th == null) {
            fbHttpRequestDebugLogger.m12471a(Status.FINISHED, fbHttpRequest);
        } else {
            fbHttpRequestDebugLogger.m12471a(th instanceof CancellationException ? Status.CANCELLED : Status.FAILED, fbHttpRequest);
        }
    }

    private void m12471a(Status status, FbHttpRequest<?> fbHttpRequest) {
        m12472a(status, (FbHttpRequest) fbHttpRequest, null);
    }

    private void m12472a(Status status, FbHttpRequest<?> fbHttpRequest, @Nullable RequestPriority requestPriority) {
        if (m12477b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(FbHttpUtils.a(fbHttpRequest.m12235h()));
            if (status == Status.PRIORITY) {
                stringBuilder.append("->");
                stringBuilder.append(FbHttpUtils.a(requestPriority));
            } else {
                stringBuilder.append(" ");
            }
            m12474a(stringBuilder, 5);
            stringBuilder.append(fbHttpRequest.f7697n);
            stringBuilder.append(" ");
            m12474a(stringBuilder, 12);
            stringBuilder.append(status);
            stringBuilder.append(" ");
            m12474a(stringBuilder, 22);
            stringBuilder.append(fbHttpRequest.f7686c);
            stringBuilder.append("  (");
            stringBuilder.append(FbHttpUtils.b(fbHttpRequest));
            stringBuilder.append(") ");
            m12474a(stringBuilder, 90);
            HttpUriRequest httpUriRequest = fbHttpRequest.f7685b;
            if (!(httpUriRequest == null || httpUriRequest.getURI() == null)) {
                URI uri = httpUriRequest.getURI();
                stringBuilder.append(uri.getHost());
                stringBuilder.append(" ");
                String path = uri.getPath();
                if (path.contains(".jpg") || path.contains(".png") || path.contains(".gif") || path.contains(".mp4")) {
                    stringBuilder.append(path.substring(path.lastIndexOf(47) + 1));
                }
            }
            RequestProcessorSnapshot a = ((FbHttpRequestProcessor) this.f7884b.get()).m12266a();
            StringBuilder stringBuilder2 = new StringBuilder();
            m12474a(stringBuilder2, 11);
            stringBuilder2.append("RUNNING: ");
            m12475a(a.a, stringBuilder2);
            stringBuilder2.append("\n");
            stringBuilder2 = new StringBuilder();
            m12474a(stringBuilder2, 11);
            stringBuilder2.append("WAITING: ");
            m12475a(a.b, stringBuilder2);
            stringBuilder2.append("\n");
        }
    }

    public static void m12475a(ArrayList<FbHttpRequest<?>> arrayList, StringBuilder stringBuilder) {
        for (int i = 0; i < arrayList.size(); i++) {
            FbHttpRequest fbHttpRequest = (FbHttpRequest) arrayList.get(i);
            stringBuilder.append(fbHttpRequest.f7697n);
            stringBuilder.append('(');
            stringBuilder.append(FbHttpUtils.a(fbHttpRequest.m12235h()));
            if (fbHttpRequest.f7699p) {
                stringBuilder.append("*");
            }
            stringBuilder.append(") ");
        }
    }

    public static void m12474a(StringBuilder stringBuilder, int i) {
        int length = stringBuilder.length();
        for (int i2 = 0; i2 < i - length; i2++) {
            stringBuilder.append(" ");
        }
    }

    private boolean m12477b() {
        return BLog.b(3) && this.f7883a.mo286a(InternalHttpPrefKeys.f2513h, false);
    }
}
