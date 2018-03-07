package com.facebook.fbservice.service;

import android.os.RemoteException;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontext.DefaultCallerContextHolder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftErrorHelper;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.executors.DefaultHandlerExecutorServiceFactory;
import com.facebook.common.executors.HandlerExecutorServiceFactory;
import com.facebook.common.executors.HandlerListeningExecutorService;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.DefaultRequestStateHolder;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: findContentDeserializer */
public class BlueServiceQueue {
    public final Class<? extends Annotation> f23660a;
    private final Provider<BlueServiceHandler> f23661b;
    private final Set<BlueServiceQueueHook> f23662c;
    private final DefaultHandlerExecutorServiceFactory f23663d;
    public final BlueServiceQueueManager f23664e;
    private final ViewerContextManager f23665f;
    private final AbstractFbErrorReporter f23666g;
    private final AnalyticsLogger f23667h;
    private final MonotonicClock f23668i;
    private final BackgroundWorkLogger f23669j;
    private final ThreadPriority f23670k;
    private final SoftErrorHelper f23671l;
    private final Provider<Boolean> f23672m;
    @GuardedBy("this")
    private final LinkedList<Operation> f23673n = Lists.m1306b();
    @GuardedBy("this")
    private final Map<String, OperationHolder> f23674o = Maps.m838c();
    @GuardedBy("this")
    private final LinkedList<Operation> f23675p = Lists.m1306b();
    private final AtomicBoolean f23676q = new AtomicBoolean(false);
    public HandlerListeningExecutorService f23677r;
    public volatile OperationHolder f23678s;
    @GuardedBy("this")
    private OperationHolder f23679t;
    private boolean f23680u = false;

    /* compiled from: findContentDeserializer */
    public class OperationHolder {
        public final Operation f23686a;
        public final FbRequestState f23687b;
        private final StatsCollector f23688c;
        private final long f23689d;
        private long f23690e;
        @GuardedBy("BlueServiceQueue.this")
        public long f23691f;
        @GuardedBy("BlueServiceQueue.this")
        public boolean f23692g;
        @GuardedBy("BlueServiceQueue.this")
        public ListenableFuture<OperationResult> f23693h;
        @GuardedBy("BlueServiceQueue.this")
        public OperationResult f23694i;
        public List<ICompletionHandler> f23695j = Lists.m1296a();
        public BlueServiceProgressCallback f23696k;

        OperationHolder(Operation operation, FbRequestState fbRequestState, StatsCollector statsCollector, long j) {
            this.f23686a = operation;
            this.f23687b = fbRequestState;
            this.f23688c = statsCollector;
            this.f23689d = j;
            this.f23692g = false;
        }

        public final long m32115a() {
            Preconditions.checkState(this.f23690e >= this.f23689d, "Must set startTime before invoking getElapsedQueuedTime");
            return this.f23690e - this.f23689d;
        }

        public static void m32113b(OperationHolder operationHolder) {
            if (operationHolder.f23688c != null) {
                operationHolder.f23688c.mo2832a();
            }
        }

        public static void m32114c(OperationHolder operationHolder) {
            if (operationHolder.f23688c != null) {
                boolean z;
                if (operationHolder.f23694i != null) {
                    z = operationHolder.f23694i.f22220b;
                } else {
                    z = false;
                }
                operationHolder.f23688c.mo2833a(z);
            }
        }
    }

    /* compiled from: findContentDeserializer */
    class C09713 implements Runnable {
        final /* synthetic */ BlueServiceQueue f23702a;

        C09713(BlueServiceQueue blueServiceQueue) {
            this.f23702a = blueServiceQueue;
        }

        public void run() {
            BlueServiceQueue.m32089d(this.f23702a);
        }
    }

    private static void m32084a(FbRequestState fbRequestState, CallerContext callerContext) {
        DefaultCallerContextHolder.f7308a.set(callerContext);
        DefaultRequestStateHolder.f7555a.set(fbRequestState);
    }

    private static void m32090e() {
        DefaultCallerContextHolder.f7308a.remove();
        DefaultRequestStateHolder.f7555a.remove();
    }

    public BlueServiceQueue(Class<? extends Annotation> cls, Provider<BlueServiceHandler> provider, Set<BlueServiceQueueHook> set, HandlerExecutorServiceFactory handlerExecutorServiceFactory, BlueServiceQueueManager blueServiceQueueManager, ViewerContextManager viewerContextManager, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock, BackgroundWorkLogger backgroundWorkLogger, ThreadPriority threadPriority, SoftErrorHelper softErrorHelper, Provider<Boolean> provider2) {
        this.f23660a = cls;
        this.f23661b = provider;
        this.f23662c = set;
        this.f23663d = handlerExecutorServiceFactory;
        this.f23664e = blueServiceQueueManager;
        this.f23665f = viewerContextManager;
        this.f23666g = fbErrorReporter;
        this.f23667h = analyticsLogger;
        this.f23668i = monotonicClock;
        this.f23669j = backgroundWorkLogger;
        this.f23670k = threadPriority;
        this.f23671l = softErrorHelper;
        this.f23672m = provider2;
    }

    final Class<? extends Annotation> m32093a() {
        return this.f23660a;
    }

    final void m32098b() {
        Preconditions.checkState(!this.f23676q.get(), "Queue cannot be started after stopped");
        this.f23677r = this.f23663d.m32066a("Blue_" + this.f23660a.getSimpleName(), this.f23670k, false);
        this.f23664e.m32059a(this);
    }

    final void m32100c() {
        if (!this.f23676q.getAndSet(true)) {
            ExecutorDetour.a(this.f23677r, new 1(this), -1444596132);
        }
    }

    final void m32094a(Operation operation, @Nullable ICompletionHandler iCompletionHandler) {
        Preconditions.checkState(!this.f23676q.get(), "Cannot add an operation after queue was stopped");
        FbRequestState a = m32079a(operation);
        synchronized (this) {
            final OperationHolder operationHolder = new OperationHolder(operation, a, this.f23669j.mo229a("BlueServiceQueue", m32086b(operation)), this.f23668i.now());
            operationHolder.f23696k = new BlueServiceProgressCallback(this) {
                final /* synthetic */ BlueServiceQueue f23698b;

                public final void mo3505a(OperationResult operationResult) {
                    this.f23698b.m32087b(operationHolder, operationResult);
                }
            };
            if (!(iCompletionHandler == null || operationHolder.f23695j == null)) {
                operationHolder.f23695j.add(iCompletionHandler);
            }
            this.f23673n.add(operation);
            this.f23674o.put(operation.m32102b(), operationHolder);
        }
        for (BackgroundTaskManager a2 : this.f23662c) {
            a2.m32121a(this.f23660a);
        }
        m32082a(this, 0);
    }

    public static void m32082a(BlueServiceQueue blueServiceQueue, long j) {
        blueServiceQueue.f23677r.mo310a(new C09713(blueServiceQueue), j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m32089d(com.facebook.fbservice.service.BlueServiceQueue r17) {
        /*
        r11 = 0;
        r14 = 0;
        r13 = 3;
    L_0x0004:
        r0 = r17;
        r2 = r0.f23678s;
        if (r2 != 0) goto L_0x004b;
    L_0x000a:
        r2 = r17.m32091f();
        r3 = 32;
        if (r2 < r3) goto L_0x0015;
    L_0x0012:
        r17.m32092g();
    L_0x0015:
        monitor-enter(r17);
        r0 = r17;
        r2 = r0.f23673n;	 Catch:{ all -> 0x0047 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x004f;
    L_0x0020:
        r0 = r17;
        r2 = r0.f23680u;	 Catch:{ all -> 0x0047 }
        if (r2 != 0) goto L_0x004a;
    L_0x0026:
        r2 = 1;
        r0 = r17;
        r0.f23680u = r2;	 Catch:{ all -> 0x0047 }
        r0 = r17;
        r2 = r0.f23662c;	 Catch:{ all -> 0x0047 }
        r3 = r2.iterator();	 Catch:{ all -> 0x0047 }
    L_0x0033:
        r2 = r3.hasNext();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x004a;
    L_0x0039:
        r2 = r3.next();	 Catch:{ all -> 0x0047 }
        r2 = (com.facebook.backgroundtasks.BackgroundTaskManager) r2;	 Catch:{ all -> 0x0047 }
        r0 = r17;
        r4 = r0.f23660a;	 Catch:{ all -> 0x0047 }
        r2.m32122b(r4);	 Catch:{ all -> 0x0047 }
        goto L_0x0033;
    L_0x0047:
        r2 = move-exception;
        monitor-exit(r17);	 Catch:{ all -> 0x0047 }
        throw r2;
    L_0x004a:
        monitor-exit(r17);	 Catch:{  }
    L_0x004b:
        r17.m32092g();
        return;
    L_0x004f:
        r2 = 0;
        r0 = r17;
        r0.f23680u = r2;	 Catch:{  }
        r0 = r17;
        r2 = r0.f23673n;	 Catch:{  }
        r2 = r2.removeFirst();	 Catch:{  }
        r0 = r2;
        r0 = (com.facebook.fbservice.service.Operation) r0;	 Catch:{  }
        r9 = r0;
        r0 = r17;
        r2 = r0.f23674o;	 Catch:{  }
        r3 = r9.m32102b();	 Catch:{  }
        r2 = r2.get(r3);	 Catch:{  }
        r0 = r2;
        r0 = (com.facebook.fbservice.service.BlueServiceQueue.OperationHolder) r0;	 Catch:{  }
        r10 = r0;
        if (r10 != 0) goto L_0x007b;
    L_0x0072:
        r2 = "BlueServiceQueue";
        r3 = "No holder for queued operation!";
        com.facebook.debug.log.BLog.a(r2, r3);	 Catch:{  }
        monitor-exit(r17);	 Catch:{  }
        goto L_0x0004;
    L_0x007b:
        r0 = r17;
        r2 = r0.f23668i;	 Catch:{  }
        r2 = r2.now();	 Catch:{  }
        r10.f23690e = r2;	 Catch:{  }
        r0 = r17;
        r0.f23679t = r10;	 Catch:{  }
        com.facebook.fbservice.service.BlueServiceQueue.OperationHolder.m32113b(r10);	 Catch:{  }
        monitor-exit(r17);	 Catch:{  }
        r2 = com.facebook.debug.log.BLog.b(r13);
        if (r2 == 0) goto L_0x00a8;
    L_0x0094:
        r2 = new java.lang.StringBuilder;
        r3 = "****** BlueService (";
        r2.<init>(r3);
        r3 = r9.m32101a();
        r2 = r2.append(r3);
        r3 = ")";
        r2.append(r3);
    L_0x00a8:
        r2 = "BlueService (%s)";
        r3 = r9.m32101a();
        r4 = 82372870; // 0x4e8e906 float:5.4756936E-36 double:4.0697605E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r3, r4);
        r2 = 159494010; // 0x981af7a float:3.1220638E-33 double:7.8800511E-316;
        r2 = com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour.a(r2);
        r3 = "BlueService";
        r4 = r9.m32101a();
        com.facebook.loom.logger.api.LoomLogger.a(r2, r3, r4);
        r2 = "queuedTime: %d ms";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00fd }
        r4 = 0;
        r6 = r10.m32115a();	 Catch:{ Throwable -> 0x00fd }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00fd }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00fd }
        com.facebook.debug.tracer.Tracer.m888d(r2, r3);	 Catch:{ Throwable -> 0x00fd }
        r2 = -1727067535; // 0xffffffff990f0a71 float:-7.395035E-24 double:NaN;
        r2 = com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour.a(r2);	 Catch:{ Throwable -> 0x00fd }
        r3 = "queuedTime";
        r4 = r10.m32115a();	 Catch:{ Throwable -> 0x00fd }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x00fd }
        com.facebook.loom.logger.api.LoomLogger.a(r2, r3, r4);	 Catch:{ Throwable -> 0x00fd }
        r0 = r17;
        r2 = r0.f23676q;	 Catch:{ Throwable -> 0x00fd }
        r2 = r2.get();	 Catch:{ Throwable -> 0x00fd }
        if (r2 == 0) goto L_0x0133;
    L_0x00f5:
        r2 = new java.util.concurrent.CancellationException;	 Catch:{ Throwable -> 0x00fd }
        r3 = "Queue stopped";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00fd }
        throw r2;	 Catch:{ Throwable -> 0x00fd }
    L_0x00fd:
        r2 = move-exception;
        r3 = "BlueServiceQueue";
        r4 = "Exception during service";
        com.facebook.debug.log.BLog.a(r3, r4, r2);	 Catch:{ all -> 0x01e7 }
        r3 = r9.m32101a();	 Catch:{ all -> 0x01e7 }
        r0 = r17;
        r0.m32085a(r2, r3);	 Catch:{ all -> 0x01e7 }
        r3 = r9.m32104d();	 Catch:{ all -> 0x01e7 }
        if (r3 == 0) goto L_0x0232;
    L_0x0114:
        r2 = com.facebook.fbservice.service.OperationResult.m30118a(r2);	 Catch:{ all -> 0x01e7 }
    L_0x0118:
        r0 = r17;
        r0.m32080a(r10, r2);	 Catch:{ all -> 0x01e7 }
        r2 = -76767764; // 0xfffffffffb6c9dec float:-1.2285851E36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r14, r2);
        r2 = com.facebook.debug.log.BLog.b(r13);
        if (r2 == 0) goto L_0x012e;
    L_0x0129:
        r2 = "BlueServiceQueue";
        com.facebook.debug.tracer.Tracer.m886c(r2);
    L_0x012e:
        com.facebook.fbservice.service.BlueServiceQueue.OperationHolder.m32114c(r10);
        goto L_0x0004;
    L_0x0133:
        r2 = r9.m32103c();	 Catch:{  }
        r3 = "overridden_viewer_context";
        r2 = r2.getParcelable(r3);	 Catch:{  }
        r2 = (com.facebook.auth.viewercontext.ViewerContext) r2;	 Catch:{  }
        r0 = r17;
        r3 = r0.f23665f;	 Catch:{ all -> 0x01e2 }
        r12 = r3.mo214b(r2);	 Catch:{ all -> 0x01e2 }
        r7 = r9.m32105e();	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r2 = r10.f23687b;	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        m32084a(r2, r7);	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r2 = new com.facebook.fbservice.service.OperationParams;	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r3 = r9.m32101a();	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r4 = r9.m32103c();	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r5 = r9.m32102b();	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r6 = r10.f23687b;	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r8 = r10.f23696k;	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r3 = "BlueServiceHandlerProvider.get()";
        r4 = -234367054; // 0xfffffffff207d7b2 float:-2.690639E30 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3, r4);	 Catch:{ Throwable -> 0x01d2, all -> 0x0200 }
        r0 = r17;
        r3 = r0.f23661b;	 Catch:{ all -> 0x01ca }
        r3 = r3.get();	 Catch:{ all -> 0x01ca }
        r3 = (com.facebook.fbservice.service.BlueServiceHandler) r3;	 Catch:{ all -> 0x01ca }
        r4 = -1412512599; // 0xffffffffabcec4a9 float:-1.4691765E-12 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4);	 Catch:{  }
        monitor-enter(r17);	 Catch:{  }
        r4 = r10.f23692g;	 Catch:{ all -> 0x01fd }
        if (r4 == 0) goto L_0x0243;
    L_0x0182:
        r4 = com.facebook.fbservice.service.ErrorCode.CANCELLED;	 Catch:{ all -> 0x01fd }
        r4 = com.facebook.fbservice.service.OperationResult.m30111a(r4);	 Catch:{ all -> 0x01fd }
    L_0x0188:
        monitor-exit(r17);	 Catch:{ all -> 0x01fd }
        if (r4 != 0) goto L_0x0240;
    L_0x018b:
        r4 = "BlueServiceHandler.handleOperation";
        r5 = 1306375695; // 0x4dddb60f float:4.64962016E8 double:6.454353515E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4, r5);	 Catch:{  }
        r2 = r3.mo3506a(r2);	 Catch:{ CancellationException -> 0x0203 }
        r3 = -538098777; // 0xffffffffdfed43a7 float:-3.4193384E19 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);	 Catch:{  }
    L_0x019d:
        if (r12 == 0) goto L_0x01a2;
    L_0x019f:
        r12.close();	 Catch:{  }
    L_0x01a2:
        m32090e();	 Catch:{  }
        r3 = r2 instanceof com.facebook.fbservice.service.FutureOperationResult;	 Catch:{  }
        if (r3 == 0) goto L_0x022c;
    L_0x01a9:
        r2 = (com.facebook.fbservice.service.FutureOperationResult) r2;	 Catch:{  }
        r2 = r2.m32208n();	 Catch:{  }
        r0 = r17;
        r0.m32081a(r10, r2);	 Catch:{  }
    L_0x01b4:
        r2 = 670332372; // 0x27f475d4 float:6.7851354E-15 double:3.311881963E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r14, r2);
        r2 = com.facebook.debug.log.BLog.b(r13);
        if (r2 == 0) goto L_0x01c5;
    L_0x01c0:
        r2 = "BlueServiceQueue";
        com.facebook.debug.tracer.Tracer.m886c(r2);
    L_0x01c5:
        com.facebook.fbservice.service.BlueServiceQueue.OperationHolder.m32114c(r10);
        goto L_0x0004;
    L_0x01ca:
        r2 = move-exception;
        r3 = -1698558234; // 0xffffffff9ac20ee6 float:-8.026059E-23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x01d2:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x01d4 }
    L_0x01d4:
        r3 = move-exception;
        r16 = r3;
        r3 = r2;
        r2 = r16;
    L_0x01da:
        if (r12 == 0) goto L_0x01e1;
    L_0x01dc:
        if (r3 == 0) goto L_0x0228;
    L_0x01de:
        r12.close();	 Catch:{ Throwable -> 0x0223 }
    L_0x01e1:
        throw r2;	 Catch:{  }
    L_0x01e2:
        r2 = move-exception;
        m32090e();	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x01e7:
        r2 = move-exception;
        r3 = 694742931; // 0x2968ef93 float:5.1722146E-14 double:3.43248615E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r14, r3);
        r3 = com.facebook.debug.log.BLog.b(r13);
        if (r3 == 0) goto L_0x01f9;
    L_0x01f4:
        r3 = "BlueServiceQueue";
        com.facebook.debug.tracer.Tracer.m886c(r3);
    L_0x01f9:
        com.facebook.fbservice.service.BlueServiceQueue.OperationHolder.m32114c(r10);
        throw r2;
    L_0x01fd:
        r2 = move-exception;
        monitor-exit(r17);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x0200:
        r2 = move-exception;
        r3 = r11;
        goto L_0x01da;
    L_0x0203:
        r2 = move-exception;
        monitor-enter(r17);	 Catch:{ all -> 0x021b }
        r3 = r10.f23692g;	 Catch:{ all -> 0x0218 }
        if (r3 == 0) goto L_0x0217;
    L_0x0209:
        r2 = com.facebook.fbservice.service.ErrorCode.CANCELLED;	 Catch:{ all -> 0x0218 }
        r2 = com.facebook.fbservice.service.OperationResult.m30111a(r2);	 Catch:{ all -> 0x0218 }
        monitor-exit(r17);	 Catch:{ all -> 0x0218 }
        r3 = 1685415327; // 0x6475659f float:1.81071E22 double:8.32705812E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);	 Catch:{  }
        goto L_0x019d;
    L_0x0217:
        throw r2;	 Catch:{  }
    L_0x0218:
        r2 = move-exception;
        monitor-exit(r17);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x021b:
        r2 = move-exception;
        r3 = 1608443812; // 0x5fdee7a4 float:3.2123974E19 double:7.94676831E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x0223:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x01e1;
    L_0x0228:
        r12.close();	 Catch:{  }
        goto L_0x01e1;
    L_0x022c:
        r0 = r17;
        r0.m32080a(r10, r2);	 Catch:{  }
        goto L_0x01b4;
    L_0x0232:
        r3 = com.facebook.fbservice.service.ErrorCodeUtil.a(r2);	 Catch:{  }
        r4 = com.facebook.fbservice.service.ErrorCodeUtil.b(r2);	 Catch:{  }
        r2 = com.facebook.fbservice.service.OperationResult.m30112a(r3, r4, r2);	 Catch:{  }
        goto L_0x0118;
    L_0x0240:
        r2 = r4;
        goto L_0x019d;
    L_0x0243:
        r4 = r11;
        goto L_0x0188;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbservice.service.BlueServiceQueue.d(com.facebook.fbservice.service.BlueServiceQueue):void");
    }

    @VisibleForTesting
    private void m32085a(Throwable th, @Nullable String str) {
        if (!((Boolean) this.f23672m.get()).booleanValue()) {
            return;
        }
        if (SoftErrorHelper.m32069a(th)) {
            HoneyAnalyticsEvent b = new HoneyClientEvent("orca_service_exception").m5090b("type", th.getClass().getSimpleName()).m5090b("msg", th.getMessage());
            if (str != null) {
                b.m5090b("operation", str);
            }
            this.f23667h.mo526a(b);
            return;
        }
        this.f23666g.m2343a("BlueServiceQueue", "Failed BlueService operation [" + str + "]", th);
    }

    private FbRequestState m32079a(Operation operation) {
        return new FbRequestState("Blue_" + this.f23660a.getSimpleName() + "_" + operation.f23682b + "_" + operation.f23681a);
    }

    private synchronized int m32091f() {
        return this.f23675p.size();
    }

    private synchronized void m32092g() {
        long now = this.f23668i.now();
        Iterator it = this.f23675p.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            OperationHolder operationHolder = (OperationHolder) this.f23674o.get(operation.m32102b());
            if (operationHolder != null) {
                if (now - operationHolder.f23691f <= 30000) {
                    break;
                }
                this.f23674o.remove(operation.m32102b());
                it.remove();
            } else {
                BLog.a("BlueServiceQueue", "No holder for recently completed operation!");
                it.remove();
            }
        }
        if (this.f23675p.size() > 0) {
            m32082a(this, 15000);
        }
    }

    private synchronized void m32081a(OperationHolder operationHolder, ListenableFuture<OperationResult> listenableFuture) {
        TracerDetour.a("BlueServiceQueue.operationDeferred", -1844405228);
        try {
            operationHolder.f23693h = listenableFuture;
            this.f23678s = operationHolder;
            ListenableFuture listenableFuture2 = operationHolder.f23693h;
            Futures.m2458a(listenableFuture2, new 4(this, operationHolder), this.f23677r);
            TracerDetour.a(listenableFuture2);
        } finally {
            TracerDetour.a(593466214);
        }
    }

    private synchronized void m32080a(OperationHolder operationHolder, OperationResult operationResult) {
        TracerDetour.a("BlueServiceQueue.operationDone", 491031813);
        try {
            operationHolder.f23694i = operationResult;
            operationHolder.f23691f = this.f23668i.now();
            this.f23675p.add(operationHolder.f23686a);
            OperationHolder operationHolder2 = this.f23679t;
            if (operationHolder2 == operationHolder) {
                this.f23679t = operationHolder2;
            }
            for (ICompletionHandler b : operationHolder.f23695j) {
                try {
                    b.mo3504b(operationHolder.f23694i);
                } catch (RemoteException e) {
                }
            }
            operationHolder.f23695j = null;
            TracerDetour.a(1703615009);
        } finally {
            TracerDetour.a(-1506870666);
        }
    }

    private synchronized void m32087b(OperationHolder operationHolder, OperationResult operationResult) {
        if (operationHolder.f23695j != null) {
            for (ICompletionHandler a : operationHolder.f23695j) {
                try {
                    a.mo3503a(operationResult);
                } catch (RemoteException e) {
                }
            }
        }
    }

    final synchronized boolean m32095a(String str) {
        return this.f23674o.containsKey(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m32096a(java.lang.String r4, com.facebook.fbservice.service.ICompletionHandler r5) {
        /*
        r3 = this;
        r1 = 0;
        monitor-enter(r3);
        r0 = r3.f23674o;	 Catch:{ all -> 0x0024 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0024 }
        r0 = (com.facebook.fbservice.service.BlueServiceQueue.OperationHolder) r0;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x000f;
    L_0x000c:
        r0 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0024 }
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = r0.f23694i;	 Catch:{ all -> 0x0024 }
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r0 = r0.f23694i;	 Catch:{ all -> 0x0024 }
    L_0x0015:
        monitor-exit(r3);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r5.mo3504b(r0);	 Catch:{ RemoteException -> 0x0027 }
    L_0x001b:
        r0 = 1;
        goto L_0x000e;
    L_0x001d:
        r0 = r0.f23695j;	 Catch:{  }
        r0.add(r5);	 Catch:{  }
        r0 = r1;
        goto L_0x0015;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{  }
        throw r0;
    L_0x0027:
        r0 = move-exception;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbservice.service.BlueServiceQueue.a(java.lang.String, com.facebook.fbservice.service.ICompletionHandler):boolean");
    }

    final synchronized boolean m32099b(String str) {
        boolean z;
        OperationHolder operationHolder = (OperationHolder) this.f23674o.get(str);
        if (operationHolder == null) {
            z = false;
        } else if (operationHolder.f23694i != null) {
            z = false;
        } else {
            Operation operation = operationHolder.f23686a;
            if (operationHolder.f23693h != null) {
                operationHolder.f23692g = true;
                z = operationHolder.f23693h.cancel(true);
            } else if (this.f23673n.remove(operation)) {
                m32080a(operationHolder, OperationResult.m30111a(ErrorCode.CANCELLED));
                operationHolder.f23692g = true;
                z = true;
            } else if (this.f23679t == null || this.f23679t.f23686a != operation) {
                z = false;
            } else {
                this.f23679t.f23692g = true;
                BlueServiceHandler blueServiceHandler = (BlueServiceHandler) this.f23661b.get();
                if (blueServiceHandler instanceof Cancelable) {
                    this.f23677r.getClass();
                    operationHolder.f23692g = true;
                    z = ((Cancelable) blueServiceHandler).a(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    final synchronized boolean m32097a(String str, RequestPriority requestPriority) {
        boolean z;
        OperationHolder operationHolder = (OperationHolder) this.f23674o.get(str);
        if (operationHolder == null) {
            z = false;
        } else {
            FbRequestState fbRequestState = operationHolder.f23687b;
            if (fbRequestState == null) {
                z = false;
            } else {
                fbRequestState.m11636a(requestPriority, true);
                z = true;
            }
        }
        return z;
    }

    private String m32086b(Operation operation) {
        String str;
        if (operation == null || operation.f23682b == null) {
            str = "Unknown";
        } else {
            str = operation.f23682b;
        }
        return this.f23660a.getSimpleName() + "/" + str;
    }
}
