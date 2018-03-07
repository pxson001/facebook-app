package com.facebook.common.executors;

import android.annotation.SuppressLint;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.inject.InjectorLike;
import com.facebook.systrace.SystraceMetadata;
import java.util.List;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor"})
/* compiled from: update_nux_status */
public class FbHandlerThreadFactory {
    public static final Class<?> f1769a = FbHandlerThreadFactory.class;
    public static final Pattern f1770b = Pattern.compile("^>>>>> Dispatching to (\\w+)(?:\\{\\w+\\})?\\s*(?:\\(([\\w\\$\\.]+)\\))?\\s*(?:\\{[0-9a-f]+\\})? ([^@]+)(?:@\\w+)?: (\\d+)$");
    public static final WeakHashMap<FbHandlerThread, Void> f1771d = new WeakHashMap();
    private static volatile FbHandlerThreadFactory f1772e;
    public final BackgroundWorkLogger f1773c;

    /* compiled from: update_nux_status */
    public class FbHandlerThread extends HandlerThread {
        public final /* synthetic */ FbHandlerThreadFactory f1774a;
        private final String f1775b;
        private final boolean f1776c;
        public List<Object> f1777d;

        public FbHandlerThread(FbHandlerThreadFactory fbHandlerThreadFactory, String str, ThreadPriority threadPriority, boolean z) {
            this.f1774a = fbHandlerThreadFactory;
            super(str, threadPriority.getAndroidThreadPriority());
            this.f1775b = str;
            this.f1776c = z;
            FbHandlerThreadFactory.f1771d.put(this, null);
        }

        protected void onLooperPrepared() {
            SystraceMetadata.c();
            if (this.f1776c) {
                final String str = this.f1775b;
                final Looper looper = getLooper();
                this.f1777d = this.f1774a.f1773c.mo230a(new Object(this) {
                    final /* synthetic */ FbHandlerThread f1848c;

                    public final void m3690a(boolean z) {
                        FbHandlerThreadFactory.m3577a(this.f1848c.f1774a, str, looper, z);
                    }
                });
                FbHandlerThreadFactory.m3577a(this.f1774a, str, looper, this.f1774a.f1773c.mo231a());
            }
        }
    }

    public static com.facebook.common.executors.FbHandlerThreadFactory m3575a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1772e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.FbHandlerThreadFactory.class;
        monitor-enter(r1);
        r0 = f1772e;	 Catch:{ all -> 0x003a }
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
        r0 = m3578b(r0);	 Catch:{ all -> 0x0035 }
        f1772e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1772e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.FbHandlerThreadFactory.a(com.facebook.inject.InjectorLike):com.facebook.common.executors.FbHandlerThreadFactory");
    }

    private static FbHandlerThreadFactory m3578b(InjectorLike injectorLike) {
        return new FbHandlerThreadFactory(BaseBackgroundWorkLogger.m1660a(injectorLike));
    }

    @Inject
    public FbHandlerThreadFactory(BackgroundWorkLogger backgroundWorkLogger) {
        this.f1773c = backgroundWorkLogger;
    }

    public final HandlerThread m3579a(String str) {
        return new FbHandlerThread(this, str, ThreadPriority.NORMAL, true);
    }

    public final HandlerThread m3580a(String str, ThreadPriority threadPriority) {
        return new FbHandlerThread(this, str, threadPriority, true);
    }

    public final HandlerThread m3581a(String str, ThreadPriority threadPriority, boolean z) {
        return new FbHandlerThread(this, str, threadPriority, z);
    }

    public static void m3577a(FbHandlerThreadFactory fbHandlerThreadFactory, String str, Looper looper, boolean z) {
        if (z) {
            looper.setMessageLogging(new 1(fbHandlerThreadFactory, looper, str));
        } else {
            m3576a(looper);
        }
    }

    public static void m3576a(Looper looper) {
        looper.setMessageLogging(null);
    }
}
