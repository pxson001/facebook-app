package com.facebook.messaging.composershortcuts;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messaging_pub_ack */
public class DefaultComposerShortcuts {
    private static volatile DefaultComposerShortcuts f10055d;
    private final BuiltinComposerShortcuts f10056a;
    private final boolean f10057b;
    @GuardedBy("this")
    private ImmutableList<ComposerShortcutItem> f10058c;

    public static com.facebook.messaging.composershortcuts.DefaultComposerShortcuts m10563a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10055d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.composershortcuts.DefaultComposerShortcuts.class;
        monitor-enter(r1);
        r0 = f10055d;	 Catch:{ all -> 0x003a }
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
        r0 = m10564b(r0);	 Catch:{ all -> 0x0035 }
        f10055d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10055d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composershortcuts.DefaultComposerShortcuts.a(com.facebook.inject.InjectorLike):com.facebook.messaging.composershortcuts.DefaultComposerShortcuts");
    }

    private static DefaultComposerShortcuts m10564b(InjectorLike injectorLike) {
        return new DefaultComposerShortcuts(BuiltinComposerShortcuts.m10488a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    DefaultComposerShortcuts(BuiltinComposerShortcuts builtinComposerShortcuts, Boolean bool) {
        this.f10056a = builtinComposerShortcuts;
        this.f10057b = bool.booleanValue();
    }

    final synchronized ImmutableList<ComposerShortcutItem> m10567a() {
        ImmutableList<ComposerShortcutItem> immutableList;
        if (this.f10058c != null) {
            immutableList = this.f10058c;
        } else {
            this.f10058c = this.f10057b ? m10566c() : m10565b();
            immutableList = this.f10058c;
        }
        return immutableList;
    }

    private ImmutableList<ComposerShortcutItem> m10565b() {
        return ImmutableList.of(this.f10056a.m10493a("text"), this.f10056a.m10493a("ride_service_promotion"), this.f10056a.m10493a("quick_reply"), this.f10056a.m10493a("camera"), this.f10056a.m10493a("gallery"), this.f10056a.m10493a("stickers"), this.f10056a.m10493a("emoji"), this.f10056a.m10493a("contentsearch"), this.f10056a.m10493a("voice_clip"), this.f10056a.m10493a("sendlocation"), this.f10056a.m10493a("payment"), this.f10056a.m10493a("ride_service"), new ComposerShortcutItem[]{this.f10056a.m10493a("ephemeral"), this.f10056a.m10493a("send_event")});
    }

    private ImmutableList<ComposerShortcutItem> m10566c() {
        return ImmutableList.of(this.f10056a.m10493a("text"), this.f10056a.m10493a("camera"), this.f10056a.m10493a("gallery"), this.f10056a.m10493a("stickers"), this.f10056a.m10493a("contentsearch"), this.f10056a.m10493a("voice_clip"), this.f10056a.m10493a("sendlocation"), this.f10056a.m10493a("send_event"));
    }
}
