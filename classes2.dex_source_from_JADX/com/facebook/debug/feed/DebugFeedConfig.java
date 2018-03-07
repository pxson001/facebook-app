package com.facebook.debug.feed;

import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: row_type */
public class DebugFeedConfig {
    private static volatile DebugFeedConfig f6523c;
    private FbSharedPreferences f6524a;
    public boolean f6525b = false;

    public static com.facebook.debug.feed.DebugFeedConfig m11298a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6523c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.feed.DebugFeedConfig.class;
        monitor-enter(r1);
        r0 = f6523c;	 Catch:{ all -> 0x003a }
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
        r0 = m11299b(r0);	 Catch:{ all -> 0x0035 }
        f6523c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6523c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.feed.DebugFeedConfig.a(com.facebook.inject.InjectorLike):com.facebook.debug.feed.DebugFeedConfig");
    }

    private static DebugFeedConfig m11299b(InjectorLike injectorLike) {
        return new DebugFeedConfig(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public DebugFeedConfig(FbSharedPreferences fbSharedPreferences) {
        this.f6524a = fbSharedPreferences;
    }

    public final boolean m11300a() {
        return System.getProperty("enable_debug_feed", "false").equals("true") || this.f6525b || this.f6524a.mo286a(FeedPrefKeys.f5755s, false);
    }

    @DoNotStrip
    public void setDebugFeedEnabled(boolean z) {
        this.f6525b = z;
    }
}
