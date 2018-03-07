package com.facebook.fbreact.jscperf;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_page_data */
public class JSCPerfPeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile JSCPerfPeriodicReporter f7337b;
    private JSCPerfRecorder f7338a;

    public static com.facebook.fbreact.jscperf.JSCPerfPeriodicReporter m8529a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7337b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.jscperf.JSCPerfPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f7337b;	 Catch:{ all -> 0x003a }
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
        r0 = m8530b(r0);	 Catch:{ all -> 0x0035 }
        f7337b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7337b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.jscperf.JSCPerfPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.jscperf.JSCPerfPeriodicReporter");
    }

    private static JSCPerfPeriodicReporter m8530b(InjectorLike injectorLike) {
        return new JSCPerfPeriodicReporter(JSCPerfRecorder.m8532a(injectorLike));
    }

    @Inject
    public JSCPerfPeriodicReporter(JSCPerfRecorder jSCPerfRecorder) {
        this.f7338a = jSCPerfRecorder;
    }

    @Nullable
    public final HoneyAnalyticsEvent m8531a(long j, String str) {
        JSCPerfRecord[] a = this.f7338a.m8535a();
        if (a == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (JSCPerfRecord jSCPerfRecord : a) {
            if (jSCPerfRecord != null) {
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                objectNode.a("size", jSCPerfRecord.f7339a);
                objectNode.a("extra_size", jSCPerfRecord.f7340b);
                objectNode.a("capacity", jSCPerfRecord.f7341c);
                objectNode.a("object_count", jSCPerfRecord.f7342d);
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                objectNode2.a("last_eden_gc_length", jSCPerfRecord.f7343e);
                objectNode2.a("last_gull_gc_length", jSCPerfRecord.f7344f);
                ObjectNode objectNode3 = new ObjectNode(JsonNodeFactory.a);
                objectNode3.c("heap", objectNode);
                objectNode3.c("gc", objectNode2);
                arrayList.add(objectNode3);
            }
        }
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("jsc_perf_event");
        honeyClientEvent.a("records", arrayList);
        return honeyClientEvent;
    }
}
