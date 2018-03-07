package com.facebook.push.fbpushdata;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hev1 */
public class FbPushDataDuplicateManager {
    private static final Class<?> f11268a = FbPushDataDuplicateManager.class;
    private static volatile FbPushDataDuplicateManager f11269e;
    public final Clock f11270b;
    public final List<String> f11271c = new LinkedList();
    public final HashMap<String, Long> f11272d = Maps.c();

    public static com.facebook.push.fbpushdata.FbPushDataDuplicateManager m13174a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11269e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbpushdata.FbPushDataDuplicateManager.class;
        monitor-enter(r1);
        r0 = f11269e;	 Catch:{ all -> 0x003a }
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
        r0 = m13175b(r0);	 Catch:{ all -> 0x0035 }
        f11269e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11269e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbpushdata.FbPushDataDuplicateManager.a(com.facebook.inject.InjectorLike):com.facebook.push.fbpushdata.FbPushDataDuplicateManager");
    }

    private static FbPushDataDuplicateManager m13175b(InjectorLike injectorLike) {
        return new FbPushDataDuplicateManager((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FbPushDataDuplicateManager(Clock clock) {
        this.f11270b = clock;
    }

    public final void m13176a(String str) {
        if (str != null && !m13177b(str)) {
            this.f11271c.add(str);
            this.f11272d.put(str, Long.valueOf(this.f11270b.a()));
            long a = this.f11270b.a();
            while (!this.f11271c.isEmpty()) {
                String str2 = (String) this.f11271c.get(0);
                if (a - ((Long) this.f11272d.get(str2)).longValue() <= 1800000) {
                    break;
                }
                this.f11271c.remove(0);
                this.f11272d.remove(str2);
            }
            if (this.f11271c.size() > 100) {
                while (((long) this.f11271c.size()) > 66) {
                    this.f11272d.remove((String) this.f11271c.remove(0));
                }
            }
            Integer.valueOf(this.f11271c.size());
        }
    }

    public final boolean m13177b(String str) {
        return this.f11272d.containsKey(str);
    }
}
