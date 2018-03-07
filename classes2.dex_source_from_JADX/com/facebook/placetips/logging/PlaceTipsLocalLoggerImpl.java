package com.facebook.placetips.logging;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.google.common.base.Throwables;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: topic_composer_nux */
public class PlaceTipsLocalLoggerImpl implements PlaceTipsDebugStatusDataProvider, PlaceTipsLocalLogger {
    private static final Class<?> f2411a = PlaceTipsLocalLoggerImpl.class;
    private static volatile PlaceTipsLocalLoggerImpl f2412d;
    private final LinkedList<String> f2413b = new LinkedList();
    private final Provider<TriState> f2414c;

    public static com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl m4594a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2412d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl.class;
        monitor-enter(r1);
        r0 = f2412d;	 Catch:{ all -> 0x003a }
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
        r0 = m4595b(r0);	 Catch:{ all -> 0x0035 }
        f2412d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2412d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl.a(com.facebook.inject.InjectorLike):com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl");
    }

    private static PlaceTipsLocalLoggerImpl m4595b(InjectorLike injectorLike) {
        return new PlaceTipsLocalLoggerImpl(IdBasedProvider.m1811a(injectorLike, 640));
    }

    @Inject
    public PlaceTipsLocalLoggerImpl(Provider<TriState> provider) {
        this.f2414c = provider;
    }

    public final void mo653a(String str) {
        m4596b(null, str, new Object[0]);
    }

    public final void mo654a(String str, Object... objArr) {
        m4596b(null, str, objArr);
    }

    public final void mo655a(Throwable th, String str) {
        m4596b(th, str, new Object[0]);
    }

    public final void mo656a(Throwable th, String str, Object... objArr) {
        m4596b(th, str, objArr);
    }

    private void m4596b(@Nullable Throwable th, String str, Object... objArr) {
        if (((TriState) this.f2414c.get()).asBoolean(false)) {
            m4597c(th, str, objArr);
        }
    }

    private void m4597c(@Nullable Throwable th, String str, Object... objArr) {
        synchronized (this.f2413b) {
            this.f2413b.addLast(StringFormatUtil.a(str, objArr));
            if (th != null) {
                this.f2413b.addLast(Throwables.getStackTraceAsString(th));
            }
            while (this.f2413b.size() > 500) {
                this.f2413b.removeFirst();
            }
        }
    }

    public final CharSequence mo652a() {
        StringBuilder stringBuilder = new StringBuilder("-----------RECENT LOGS (newest on the bottom)---------");
        if (this.f2413b.isEmpty()) {
            return stringBuilder.append("\nno logs in memory");
        }
        synchronized (this.f2413b) {
            Iterator it = this.f2413b.iterator();
            while (it.hasNext()) {
                stringBuilder.append("\n**").append((String) it.next());
            }
        }
        return stringBuilder;
    }
}
