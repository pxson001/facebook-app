package com.facebook.analytics;

import com.facebook.analytics.counterlogger.CommunicationScheduler;
import com.facebook.analytics.counterlogger.CommunicationScheduler.Logger;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_surface */
public class CounterLogger {
    private static final String f8025a = CounterLogger.class.getSimpleName();
    private static volatile CounterLogger f8026d;
    @GuardedBy("itself")
    private final Map<String, Map<String, Counter>> f8027b = new HashMap();
    @GuardedBy("this")
    private final CommunicationScheduler f8028c;

    /* compiled from: reaction_surface */
    class Counter {
        private int f8042a = 0;
        private long f8043b = 0;
        private long f8044c = 0;

        public final void m12627a(long j) {
            this.f8042a++;
            this.f8043b += j;
            this.f8044c += j * j;
        }

        public final JsonNode m12626a() {
            JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
            objectNode.m5129a("count", this.f8042a);
            objectNode.m5130a("sum", this.f8043b);
            objectNode.m5130a("s_sum", this.f8044c);
            return objectNode;
        }
    }

    public static com.facebook.analytics.CounterLogger m12608a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8026d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.CounterLogger.class;
        monitor-enter(r1);
        r0 = f8026d;	 Catch:{ all -> 0x003a }
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
        r0 = m12609b(r0);	 Catch:{ all -> 0x0035 }
        f8026d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8026d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.CounterLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.CounterLogger");
    }

    private static CounterLogger m12609b(InjectorLike injectorLike) {
        return new CounterLogger(CommunicationSchedulerMethodAutoProvider.m12616a(injectorLike));
    }

    @Inject
    public CounterLogger(CommunicationScheduler communicationScheduler) {
        this.f8028c = communicationScheduler;
    }

    private synchronized void m12610d(final String str) {
        this.f8028c.m12623a(str, "data", new Logger(this) {
            final /* synthetic */ CounterLogger f8041b;

            public final JsonNode mo1706a(boolean z, int i) {
                if (z) {
                    return this.f8041b.m12614b(str);
                }
                this.f8041b.m12615c(str);
                return null;
            }
        });
    }

    public final void m12611a(String str) {
        m12612a(str, 1);
    }

    public final void m12612a(String str, long j) {
        m12613a(str, j, "counters");
    }

    public final void m12613a(String str, long j, String str2) {
        synchronized (this.f8027b) {
            if (!this.f8027b.containsKey(str2)) {
                this.f8027b.put(str2, new HashMap());
                m12610d(str2);
            }
            Map map = (Map) this.f8027b.get(str2);
            if (!map.containsKey(str)) {
                map.put(str, new Counter());
            }
            ((Counter) map.get(str)).m12627a(j);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    final com.fasterxml.jackson.databind.JsonNode m12614b(java.lang.String r5) {
        /*
        r4 = this;
        r1 = 0;
        r2 = r4.f8027b;
        monitor-enter(r2);
        r0 = r4.f8027b;	 Catch:{ all -> 0x0021 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0021 }
        r0 = (java.util.Map) r0;	 Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = com.google.common.collect.ImmutableMap.copyOf(r0);	 Catch:{ all -> 0x0021 }
        r0.clear();	 Catch:{ all -> 0x0021 }
        monitor-exit(r2);	 Catch:{ all -> 0x0021 }
        r0 = r3.isEmpty();
        if (r0 == 0) goto L_0x0024;
    L_0x001f:
        r0 = r1;
        goto L_0x0010;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r0;
    L_0x0024:
        r2 = new com.fasterxml.jackson.databind.node.ObjectNode;
        r0 = com.fasterxml.jackson.databind.node.JsonNodeFactory.f3121a;
        r2.<init>(r0);
        r0 = r3.entrySet();
        r3 = r0.iterator();
    L_0x0033:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0053;
    L_0x0039:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (com.facebook.analytics.CounterLogger.Counter) r0;
        r0 = r0.m12626a();
        r2.m5143c(r1, r0);
        goto L_0x0033;
    L_0x0053:
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.CounterLogger.b(java.lang.String):com.fasterxml.jackson.databind.JsonNode");
    }

    final void m12615c(String str) {
        synchronized (this.f8027b) {
            if (this.f8027b.containsKey(str)) {
                ((Map) this.f8027b.get(str)).clear();
            }
        }
    }
}
