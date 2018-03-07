package com.facebook.http.executors.qebased;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.engine.HttpRequestExecutor;
import com.facebook.http.executors.qebased.HttpExecutorExperiment.HttpEngine;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@Singleton
/* compiled from: readMaxEventsPerBatchQE */
public class QeHttpRequestExecutor implements HttpRequestExecutor {
    private static volatile QeHttpRequestExecutor f7958f;
    public final HttpExecutorExperiment f7959a;
    public final Lazy<HttpRequestExecutor> f7960b;
    public final Lazy<HttpRequestExecutor> f7961c;
    public final AbstractFbErrorReporter f7962d;
    public HttpRequestExecutor f7963e;

    /* compiled from: readMaxEventsPerBatchQE */
    class InitializeExecutorThread extends Thread {
        final /* synthetic */ QeHttpRequestExecutor f7965a;

        public InitializeExecutorThread(QeHttpRequestExecutor qeHttpRequestExecutor) {
            this.f7965a = qeHttpRequestExecutor;
        }

        public void run() {
            synchronized (this.f7965a) {
                m12547a();
                ObjectDetour.c(this.f7965a, 512623376);
            }
        }

        private void m12547a() {
            if (this.f7965a.f7959a.m12378a() == HttpEngine.LIGER) {
                try {
                    this.f7965a.f7963e = (HttpRequestExecutor) this.f7965a.f7961c.get();
                } catch (Throwable th) {
                    this.f7965a.f7962d.m2346a("liger_init", th);
                }
            }
            if (this.f7965a.f7963e == null) {
                this.f7965a.f7963e = (HttpRequestExecutor) this.f7965a.f7960b.get();
            }
            this.f7965a.f7962d.mo345c("HTTP_ENGINE", this.f7965a.f7963e.mo1704b());
        }
    }

    public static com.facebook.http.executors.qebased.QeHttpRequestExecutor m12534a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7958f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.qebased.QeHttpRequestExecutor.class;
        monitor-enter(r1);
        r0 = f7958f;	 Catch:{ all -> 0x003a }
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
        r0 = m12535b(r0);	 Catch:{ all -> 0x0035 }
        f7958f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7958f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.qebased.QeHttpRequestExecutor.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.qebased.QeHttpRequestExecutor");
    }

    private static QeHttpRequestExecutor m12535b(InjectorLike injectorLike) {
        return new QeHttpRequestExecutor(HttpExecutorExperiment.m12375a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7183), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2255), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public QeHttpRequestExecutor(HttpExecutorExperiment httpExecutorExperiment, Lazy<HttpRequestExecutor> lazy, Lazy<HttpRequestExecutor> lazy2, FbErrorReporter fbErrorReporter) {
        this.f7959a = httpExecutorExperiment;
        this.f7960b = lazy;
        this.f7961c = lazy2;
        this.f7962d = fbErrorReporter;
        new InitializeExecutorThread(this).start();
    }

    public final HttpResponse mo1702a(HttpUriRequest httpUriRequest, FbRequestState fbRequestState, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics) {
        return m12536d().mo1702a(httpUriRequest, fbRequestState, httpContext, httpFlowStatistics);
    }

    public final void mo1703a() {
        m12536d().mo1703a();
    }

    public final String mo1704b() {
        return m12536d().mo1704b();
    }

    public final boolean mo1705c() {
        return m12536d().mo1705c();
    }

    private synchronized HttpRequestExecutor m12536d() {
        while (this.f7963e == null) {
            try {
                ObjectDetour.a(this, 343690818);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.f7963e;
    }
}
