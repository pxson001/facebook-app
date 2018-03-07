package com.facebook.messaging.composershortcuts;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.composershortcuts.ComposerShortcutsManager.ShortcutsList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messaging_emoji_db */
public class DefaultComposerShortcutsManager implements ComposerShortcutsManager {
    private static volatile DefaultComposerShortcutsManager f10066b;
    private final DefaultComposerShortcuts f10067a;

    public static com.facebook.messaging.composershortcuts.DefaultComposerShortcutsManager m10575a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10066b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.composershortcuts.DefaultComposerShortcutsManager.class;
        monitor-enter(r1);
        r0 = f10066b;	 Catch:{ all -> 0x003a }
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
        r0 = m10576b(r0);	 Catch:{ all -> 0x0035 }
        f10066b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10066b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composershortcuts.DefaultComposerShortcutsManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.composershortcuts.DefaultComposerShortcutsManager");
    }

    private static DefaultComposerShortcutsManager m10576b(InjectorLike injectorLike) {
        return new DefaultComposerShortcutsManager(DefaultComposerShortcuts.m10563a(injectorLike));
    }

    @Inject
    public DefaultComposerShortcutsManager(DefaultComposerShortcuts defaultComposerShortcuts) {
        this.f10067a = defaultComposerShortcuts;
    }

    public final ShortcutsList mo406a(ComposerShortcutsFilter composerShortcutsFilter) {
        return new ShortcutsList(this.f10067a.m10567a(), false);
    }

    public final ListenableFuture<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> mo407a() {
        return Futures.a(RegularImmutableBiMap.a);
    }

    public final void mo408a(ComposerShortcutItem composerShortcutItem) {
    }
}
