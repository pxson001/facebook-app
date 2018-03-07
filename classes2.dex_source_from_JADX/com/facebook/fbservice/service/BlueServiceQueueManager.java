package com.facebook.fbservice.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: first */
public class BlueServiceQueueManager {
    private static volatile BlueServiceQueueManager f23648d;
    private final Context f23649a;
    private final Set<BlueServiceQueue> f23650b = Sets.m1313a();
    private boolean f23651c;

    public static com.facebook.fbservice.service.BlueServiceQueueManager m32055a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23648d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbservice.service.BlueServiceQueueManager.class;
        monitor-enter(r1);
        r0 = f23648d;	 Catch:{ all -> 0x003a }
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
        r0 = m32056b(r0);	 Catch:{ all -> 0x0035 }
        f23648d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23648d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbservice.service.BlueServiceQueueManager.a(com.facebook.inject.InjectorLike):com.facebook.fbservice.service.BlueServiceQueueManager");
    }

    private static BlueServiceQueueManager m32056b(InjectorLike injectorLike) {
        return new BlueServiceQueueManager((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BlueServiceQueueManager(Context context) {
        this.f23649a = context;
    }

    public final synchronized void m32059a(BlueServiceQueue blueServiceQueue) {
        if (!m32057c(blueServiceQueue)) {
            this.f23650b.add(blueServiceQueue);
            ObjectDetour.c(this, -358390905);
        }
    }

    public final synchronized void m32061b(BlueServiceQueue blueServiceQueue) {
        if (!m32057c(blueServiceQueue)) {
            if (!this.f23650b.remove(blueServiceQueue)) {
                BLog.c("BlueServiceQueueManager", "Unknown queue [%s]", new Object[]{blueServiceQueue.m32093a()});
            }
            ObjectDetour.c(this, -429846287);
        }
    }

    public final synchronized void m32058a() {
        this.f23651c = true;
        Intent intent = new Intent(this.f23649a, DefaultBlueService.class);
        intent.setAction("Orca.DRAIN");
        this.f23649a.startService(intent);
    }

    public final synchronized void m32060b() {
        this.f23651c = false;
    }

    public final synchronized boolean m32062c() {
        return this.f23651c;
    }

    public final synchronized void m32063d() {
        Preconditions.checkState(this.f23651c);
        while (!this.f23650b.isEmpty()) {
            Integer.valueOf(this.f23650b.size());
            try {
                ObjectDetour.a(this, 1430744844);
            } catch (InterruptedException e) {
            }
        }
    }

    private static boolean m32057c(BlueServiceQueue blueServiceQueue) {
        return blueServiceQueue.f23660a == AuthQueue.class;
    }
}
