package com.facebook.cache;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import java.util.WeakHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile/%s/info/inner */
public class FbFragmentStackTracker {
    private static volatile FbFragmentStackTracker f8939c;
    public WeakHashMap<Object, Integer> f8940a = new WeakHashMap();
    private AbstractFbErrorReporter f8941b;

    public static com.facebook.cache.FbFragmentStackTracker m13800a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8939c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.cache.FbFragmentStackTracker.class;
        monitor-enter(r1);
        r0 = f8939c;	 Catch:{ all -> 0x003a }
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
        r0 = m13801b(r0);	 Catch:{ all -> 0x0035 }
        f8939c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8939c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.FbFragmentStackTracker.a(com.facebook.inject.InjectorLike):com.facebook.cache.FbFragmentStackTracker");
    }

    private static FbFragmentStackTracker m13801b(InjectorLike injectorLike) {
        return new FbFragmentStackTracker(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FbFragmentStackTracker(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8941b = abstractFbErrorReporter;
    }

    public final void m13802a(Object obj, int i) {
        if ((obj instanceof Fragment) || (obj instanceof Activity)) {
            if (i > 0) {
                this.f8940a.put(obj, Integer.valueOf(i));
            } else {
                this.f8940a.remove(obj);
            }
            AbstractFbErrorReporter abstractFbErrorReporter = this.f8941b;
            String str = "fb_fragment_stack_size";
            int i2 = 0;
            for (Integer intValue : this.f8940a.values()) {
                i2 = intValue.intValue() + i2;
            }
            abstractFbErrorReporter.mo345c(str, Integer.toString(i2));
        }
    }
}
