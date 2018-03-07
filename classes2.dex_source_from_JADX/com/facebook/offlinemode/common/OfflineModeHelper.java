package com.facebook.offlinemode.common;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.common.NetworkException;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_name */
public class OfflineModeHelper {
    private static final Set<ErrorCode> f12460a = EnumSet.of(ErrorCode.CONNECTION_FAILURE);
    private static volatile OfflineModeHelper f12461e;
    private final Clock f12462b;
    private final AnalyticsLogger f12463c;
    private final ProcessName f12464d;

    public static com.facebook.offlinemode.common.OfflineModeHelper m18526a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12461e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offlinemode.common.OfflineModeHelper.class;
        monitor-enter(r1);
        r0 = f12461e;	 Catch:{ all -> 0x003a }
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
        r0 = m18527b(r0);	 Catch:{ all -> 0x0035 }
        f12461e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12461e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.common.OfflineModeHelper.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.common.OfflineModeHelper");
    }

    private static OfflineModeHelper m18527b(InjectorLike injectorLike) {
        return new OfflineModeHelper(SystemClockMethodAutoProvider.m1498a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), ProcessNameMethodAutoProvider.m2431b(injectorLike));
    }

    @Inject
    public OfflineModeHelper(Clock clock, AnalyticsLogger analyticsLogger, ProcessName processName) {
        this.f12462b = clock;
        this.f12463c = analyticsLogger;
        this.f12464d = processName;
    }

    public final void m18529a(PendingRequest pendingRequest) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("offline_mode_operation_saved");
        honeyClientEvent.f3099c = "offline";
        this.f12463c.mo526a(honeyClientEvent.m5090b("request_id", pendingRequest.b).m5090b("operation_type", pendingRequest.c()));
    }

    public final void m18530a(ImmutableList<PendingRequest> immutableList, int i, int i2, int i3, ProcessQueueTrigger processQueueTrigger, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("offline_mode_queue_processing_finished");
        honeyClientEvent.f3099c = "offline";
        this.f12463c.mo526a(honeyClientEvent.m5084a("time_taken_ms", this.f12462b.mo211a() - j).m5083a("requests_submitted", i).m5083a("requests_dropped", i2).m5083a("requests_still_pending", i3).m5083a("requests_total", immutableList.size()).m5090b("trigger", processQueueTrigger.toString()));
    }

    public final void m18535b(PendingRequest pendingRequest) {
        m18531a("offline_mode_operation_retried", pendingRequest);
    }

    public final void m18536c(PendingRequest pendingRequest) {
        m18531a("offline_mode_operation_retry_succeeded", pendingRequest);
    }

    public final void m18531a(String str, PendingRequest pendingRequest) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "offline";
        this.f12463c.mo526a(honeyClientEvent.m5090b("request_id", pendingRequest.b).m5084a("time_spent_pending_ms", this.f12462b.mo211a() - pendingRequest.d).m5083a("attempts_number", pendingRequest.f).m5090b("operation_type", pendingRequest.c()));
    }

    public final boolean m18533a(Throwable th) {
        return m18532a() && m18528b(th);
    }

    public final boolean m18532a() {
        return this.f12464d.e();
    }

    public static boolean m18528b(Throwable th) {
        if (ExceptionUtil.a(th, ApiException.class) != null) {
            return false;
        }
        if (ExceptionUtil.a(th, UnknownHostException.class) != null) {
            return true;
        }
        if (ExceptionUtil.a(th, ConnectException.class) != null) {
            return true;
        }
        if (ExceptionUtil.a(th, SocketException.class) != null) {
            return true;
        }
        if (ExceptionUtil.a(th, NetworkException.class) != null) {
            return true;
        }
        if (ExceptionUtil.a(th, IOException.class) != null) {
            return true;
        }
        ServiceException serviceException = (ServiceException) ExceptionUtil.a(th, ServiceException.class);
        return serviceException != null && f12460a.contains(serviceException.errorCode);
    }

    public final boolean m18534a(Throwable th, OfflineQueryBehavior offlineQueryBehavior) {
        boolean z = offlineQueryBehavior != OfflineQueryBehavior.a && m18533a(th);
        return z;
    }
}
