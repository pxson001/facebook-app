package com.facebook.sync.delta;

import com.facebook.fbtrace.FbTraceNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: feed_only */
public class DeltasWithSequenceIdsFactory {
    private static volatile DeltasWithSequenceIdsFactory f14512a;

    /* compiled from: feed_only */
    public interface DeltaNoOpSniffer<DW> {
        boolean m18411a(DW dw);

        Integer m18412b(DW dw);
    }

    public static com.facebook.sync.delta.DeltasWithSequenceIdsFactory m18414a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14512a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.sync.delta.DeltasWithSequenceIdsFactory.class;
        monitor-enter(r1);
        r0 = f14512a;	 Catch:{ all -> 0x0039 }
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
        r0 = m18413a();	 Catch:{ all -> 0x0034 }
        f14512a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14512a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.delta.DeltasWithSequenceIdsFactory.a(com.facebook.inject.InjectorLike):com.facebook.sync.delta.DeltasWithSequenceIdsFactory");
    }

    private static DeltasWithSequenceIdsFactory m18413a() {
        return new DeltasWithSequenceIdsFactory();
    }

    public static <DW> ImmutableList<DeltaWithSequenceId<DW>> m18415a(List<DW> list, long j, DeltaNoOpSniffer<DW> deltaNoOpSniffer, FbTraceNode fbTraceNode) {
        int i = 0;
        Builder builder = ImmutableList.builder();
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            long j2 = (((long) i) + j) + ((long) i2);
            if (deltaNoOpSniffer.m18411a(obj) && deltaNoOpSniffer.m18412b(obj) != null && deltaNoOpSniffer.m18412b(obj).intValue() >= 2) {
                i2 += deltaNoOpSniffer.m18412b(obj).intValue() - 1;
            }
            builder.c(new DeltaWithSequenceId(obj, j2, fbTraceNode));
            i++;
        }
        return builder.b();
    }
}
