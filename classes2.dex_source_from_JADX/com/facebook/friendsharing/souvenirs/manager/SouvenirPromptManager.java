package com.facebook.friendsharing.souvenirs.manager;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptPrefKeys;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: most_recent */
public class SouvenirPromptManager {
    private static volatile SouvenirPromptManager f13321e;
    public final ListeningExecutorService f13322a;
    public final SouvenirPromptsDataAccessLayer f13323b;
    public final FbSharedPreferences f13324c;
    public final Clock f13325d;

    public static com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager m19626a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13321e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager.class;
        monitor-enter(r1);
        r0 = f13321e;	 Catch:{ all -> 0x003a }
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
        r0 = m19627b(r0);	 Catch:{ all -> 0x0035 }
        f13321e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13321e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager");
    }

    private static SouvenirPromptManager m19627b(InjectorLike injectorLike) {
        return new SouvenirPromptManager(C0055x2995691a.m1881a(injectorLike), SouvenirPromptsDataAccessLayer.m19630a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public SouvenirPromptManager(ListeningExecutorService listeningExecutorService, SouvenirPromptsDataAccessLayer souvenirPromptsDataAccessLayer, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f13322a = listeningExecutorService;
        this.f13323b = souvenirPromptsDataAccessLayer;
        this.f13324c = fbSharedPreferences;
        this.f13325d = clock;
    }

    public final ListenableFuture<Void> m19628a(String str) {
        return this.f13322a.mo271a(new 2(this, str));
    }

    public final Optional<Long> m19629b() {
        long a = this.f13324c.mo277a(SouvenirPromptPrefKeys.b, -1);
        return a != -1 ? Optional.of(Long.valueOf(a)) : Absent.INSTANCE;
    }
}
