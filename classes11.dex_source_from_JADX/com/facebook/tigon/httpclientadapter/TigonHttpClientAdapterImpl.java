package com.facebook.tigon.httpclientadapter;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ConstrainedExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.config.server.String_UserAgentStringMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.tigonapi.TigonDirectBufferCallbacks;
import com.facebook.tigon.tigonapi.TigonError;
import com.facebook.tigon.tigonapi.TigonResponse;
import com.facebook.tigon.tigonapi.TigonSummaryImpl;
import com.facebook.tigon.tigonliger.TigonLigerService;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: notif_update_available */
public class TigonHttpClientAdapterImpl {
    public final TigonLigerService f4953a;
    private final TigonFlowStateController f4954b;
    private final TigonFbRequestBuilder f4955c;
    public final TigonRequestStates f4956d = new TigonRequestStates();
    @Nonnull
    private final ExecutorService f4957e;
    @Nonnull
    public final Executor f4958f;
    private boolean f4959g = false;
    public final AtomicInteger f4960h = new AtomicInteger();

    /* compiled from: notif_update_available */
    class ClientCallbacks implements TigonDirectBufferCallbacks {
        final /* synthetic */ TigonHttpClientAdapterImpl f4950a;
        public final int f4951b;
        private final HttpWireCallback f4952c;

        public void onBody(java.nio.ByteBuffer r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0065 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r0 = r6.f4950a;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0 = r0.f4956d;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r1 = r6.f4951b;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0 = r0.m6286d(r1);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r1 = r6.f4951b;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r3 = "on body ";	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r3 = r0.m6273d();	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r2 = r2.toString();	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.m6236a(r1, r2);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0.m6279k();	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0 = r6.f4950a;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0 = r0.f4956d;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r1 = r6.f4951b;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r0 = r0.m6284b(r1);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            if (r0 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
        L_0x0031:
            r0.m6226a(r7);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r7 = 0;
        L_0x0035:
            if (r7 == 0) goto L_0x003e;
        L_0x0037:
            r0 = r6.f4950a;
            r0 = r0.f4953a;
            r0.releaseBodyBuffer(r7);
        L_0x003e:
            r0 = r6.f4951b;
            r1 = "on body";
            r2 = "done";
            com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.m6237a(r0, r1, r2);
        L_0x0047:
            return;
        L_0x0048:
            r0 = move-exception;
            r1 = "TigonHttpClientAdapter";	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r2 = "Can't write to the body buffer(%d)";	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r3 = 1;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r4 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r5 = r6.f4951b;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            r3[r4] = r5;	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            com.facebook.debug.log.BLog.b(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0048, all -> 0x006f }
            if (r7 == 0) goto L_0x0065;
        L_0x005e:
            r0 = r6.f4950a;
            r0 = r0.f4953a;
            r0.releaseBodyBuffer(r7);
        L_0x0065:
            r0 = r6.f4951b;
            r1 = "on body";
            r2 = "done";
            com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.m6237a(r0, r1, r2);
            goto L_0x0047;
        L_0x006f:
            r0 = move-exception;
            if (r7 == 0) goto L_0x0079;
        L_0x0072:
            r1 = r6.f4950a;
            r1 = r1.f4953a;
            r1.releaseBodyBuffer(r7);
        L_0x0079:
            r1 = r6.f4951b;
            r2 = "on body";
            r3 = "done";
            com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.m6237a(r1, r2, r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.ClientCallbacks.onBody(java.nio.ByteBuffer):void");
        }

        public ClientCallbacks(TigonHttpClientAdapterImpl tigonHttpClientAdapterImpl, int i, @Nullable HttpWireCallback httpWireCallback) {
            this.f4950a = tigonHttpClientAdapterImpl;
            this.f4951b = i;
            this.f4952c = httpWireCallback;
            if (this.f4952c != null) {
                httpWireCallback.a();
            }
        }

        public void onStarted(TigonRequest tigonRequest) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "on started");
            this.f4950a.f4956d.m6286d(this.f4951b).m6265a(tigonRequest);
        }

        public void onUploadProgress(long j, long j2) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "on upload progress");
            this.f4950a.f4956d.m6286d(this.f4951b).f4984m.m6311q();
            if (this.f4952c != null) {
                this.f4952c.a(j);
            }
        }

        public void onResponse(TigonResponse tigonResponse) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "on response");
            final TigonRequestState d = this.f4950a.f4956d.m6286d(this.f4951b);
            Preconditions.checkState(d.m6269a());
            final int e = d.m6274e();
            d.m6278i();
            final HttpResponse a = d.m6258a(tigonResponse);
            try {
                ExecutorDetour.a(this.f4950a.f4958f, new Runnable(this) {
                    final /* synthetic */ ClientCallbacks f4949d;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r4 = this;
                        r0 = r4.f4949d;
                        r0 = r0.f4951b;
                        r1 = "handleResponse";
                        com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.m6236a(r0, r1);
                        r0 = r4.f4949d;
                        r0 = r0.f4950a;
                        r0 = r0.f4960h;
                        r0 = r0.incrementAndGet();
                        r1 = r1;	 Catch:{ Exception -> 0x0041 }
                        r2 = r2;	 Catch:{ Exception -> 0x0041 }
                        r0 = r1.m6270a(r2, r0);	 Catch:{ Exception -> 0x0041 }
                        if (r0 == 0) goto L_0x0030;
                    L_0x001d:
                        r0 = r1;	 Catch:{ Exception -> 0x0041 }
                        r1 = r0;	 Catch:{ Exception -> 0x0041 }
                        r0 = r0.m6257a(r1);	 Catch:{ Exception -> 0x0041 }
                        r1 = r1;	 Catch:{ Exception -> 0x0041 }
                        r2 = r2;	 Catch:{ Exception -> 0x0041 }
                        r3 = r4.f4949d;	 Catch:{ Exception -> 0x0041 }
                        r3 = r3.f4950a;	 Catch:{ Exception -> 0x0041 }
                        r1.m6262a(r2, r0, r3);	 Catch:{ Exception -> 0x0041 }
                    L_0x0030:
                        r0 = r1;
                        r1 = r2;
                        r0.m6260a(r1);
                        r0 = r4.f4949d;
                        r0 = r0.f4950a;
                        r0 = r0.f4960h;
                        r0.decrementAndGet();
                    L_0x0040:
                        return;
                    L_0x0041:
                        r0 = move-exception;
                        r1 = r1;	 Catch:{ all -> 0x005e }
                        r2 = r2;	 Catch:{ all -> 0x005e }
                        r3 = r4.f4949d;	 Catch:{ all -> 0x005e }
                        r3 = r3.f4950a;	 Catch:{ all -> 0x005e }
                        r1.m6261a(r2, r0, r3);	 Catch:{ all -> 0x005e }
                        r0 = r1;
                        r1 = r2;
                        r0.m6260a(r1);
                        r0 = r4.f4949d;
                        r0 = r0.f4950a;
                        r0 = r0.f4960h;
                        r0.decrementAndGet();
                        goto L_0x0040;
                    L_0x005e:
                        r0 = move-exception;
                        r1 = r1;
                        r2 = r2;
                        r1.m6260a(r2);
                        r1 = r4.f4949d;
                        r1 = r1.f4950a;
                        r1 = r1.f4960h;
                        r1.decrementAndGet();
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tigon.httpclientadapter.TigonHttpClientAdapterImpl.ClientCallbacks.1.run():void");
                    }
                }, -670961812);
            } catch (Exception e2) {
                d.m6261a(e, e2, this.f4950a);
            }
        }

        public void onEOM(TigonSummaryImpl tigonSummaryImpl) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "onEOM");
            this.f4950a.f4956d.m6286d(this.f4951b).m6264a(this.f4950a, tigonSummaryImpl);
        }

        public void onError(@Nonnull TigonError tigonError, TigonSummaryImpl tigonSummaryImpl) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "onError: " + tigonError.f5030a + " " + tigonError.f5033d);
            this.f4950a.f4956d.m6286d(this.f4951b).m6263a(this.f4950a, tigonError, tigonSummaryImpl);
        }

        public void onWillRetry(TigonError tigonError, TigonSummaryImpl tigonSummaryImpl) {
            TigonHttpClientAdapterImpl.m6236a(this.f4951b, "on will retry");
            this.f4950a.f4956d.m6286d(this.f4951b).m6266a(tigonError, tigonSummaryImpl);
        }
    }

    public static TigonHttpClientAdapterImpl m6238b(InjectorLike injectorLike) {
        return new TigonHttpClientAdapterImpl((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), Executor_ResponseHandlerThreadPoolMethodAutoProvider.m6203a(injectorLike), TigonLigerService.m6368a(injectorLike), TigonFlowStateController.m6232a(injectorLike), new TigonFbRequestBuilder(String_UserAgentStringMethodAutoProvider.b(injectorLike), Executor_ResponseHandlerThreadPoolMethodAutoProvider.m6203a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TigonHttpClientAdapterImpl(ExecutorService executorService, Executor executor, TigonLigerService tigonLigerService, TigonFlowStateController tigonFlowStateController, TigonFbRequestBuilder tigonFbRequestBuilder, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4953a = tigonLigerService;
        this.f4954b = tigonFlowStateController;
        this.f4955c = tigonFbRequestBuilder;
        this.f4957e = new ConstrainedExecutorService("TigonCallbacks", 1, executorService, new LinkedBlockingDeque());
        this.f4958f = executor;
        if (gatekeeperStoreImpl.a(459, false)) {
            TigonRequestState.f4972c = abstractFbErrorReporter;
        }
    }

    public static void m6236a(int i, String str) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(i);
        }
    }

    static void m6237a(int i, String str, Object obj) {
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(i);
        }
    }

    public final void m6239a(HttpUriRequest httpUriRequest, String str, @Nullable CallerContext callerContext, int i, ResponseHandler responseHandler, RequestPriority requestPriority, boolean z, @Nullable HttpWireCallback httpWireCallback, RequestIdempotency requestIdempotency, FbRequestState fbRequestState, SettableFuture settableFuture) {
        if (TigonHttpClientAdapterModule.f4961a) {
            Integer.valueOf(i);
            httpUriRequest.getURI();
        }
        try {
            DirectByteBufferOutputStream b;
            TigonHttpEntityBodyProvider a = this.f4955c.m6230a(httpUriRequest);
            if (a == null) {
                b = TigonFbRequestBuilder.m6229b(httpUriRequest);
            } else {
                b = null;
            }
            FlowObserverRequestInfo flowObserverRequestInfo = new FlowObserverRequestInfo(this.f4954b, httpUriRequest, httpWireCallback);
            ClientCallbacks clientCallbacks = new ClientCallbacks(this, i, httpWireCallback);
            TigonRequestState a2 = this.f4956d.m6281a(str, i, responseHandler, flowObserverRequestInfo, fbRequestState, settableFuture, this.f4953a, this.f4959g);
            TigonRequest a3 = this.f4955c.m6231a(i, httpUriRequest, str, callerContext, requestPriority, z, requestIdempotency);
            flowObserverRequestInfo.m6212a(a3, i);
            if (a != null) {
                a2.m6267a(this.f4953a.mo134a(a3, a, clientCallbacks, this.f4957e));
            } else {
                a2.m6267a(this.f4953a.mo135a(a3, b == null ? null : b.m6201a(), b == null ? 0 : b.m6202b(), clientCallbacks, this.f4957e));
            }
            m6236a(i, "executeAsync ended");
        } catch (Throwable e) {
            BLog.a("TigonHttpClientAdapter", e, "Invalid request body from '%s' request", new Object[]{str});
            settableFuture.a(e);
            m6236a(i, "executeAsync ended; invalid request body");
        }
    }
}
