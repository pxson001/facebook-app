package com.facebook.katana.urimap;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.common.init.INeedInit;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_takeover_delete_thread_dialog_action */
public class LinkSharingNativeComposerPrefsWatcher implements INeedInit {
    private static volatile LinkSharingNativeComposerPrefsWatcher f2032c;
    public final Context f2033a;
    private final GatekeeperStoreImpl f2034b;

    public static com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher m2115a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2032c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher.class;
        monitor-enter(r1);
        r0 = f2032c;	 Catch:{ all -> 0x003a }
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
        r0 = m2117b(r0);	 Catch:{ all -> 0x0035 }
        f2032c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2032c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher");
    }

    private static LinkSharingNativeComposerPrefsWatcher m2117b(InjectorLike injectorLike) {
        return new LinkSharingNativeComposerPrefsWatcher((Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LinkSharingNativeComposerPrefsWatcher(Context context, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f2033a = context;
        this.f2034b = gatekeeperStoreImpl;
    }

    public void init() {
        m2116a(this);
    }

    public static void m2116a(LinkSharingNativeComposerPrefsWatcher linkSharingNativeComposerPrefsWatcher) {
        linkSharingNativeComposerPrefsWatcher.f2033a.getPackageManager().setComponentEnabledSetting(new ComponentName(linkSharingNativeComposerPrefsWatcher.f2033a, LinkSharingNativeComposerAliasActivity.class), linkSharingNativeComposerPrefsWatcher.f2034b.a(626, false) ? 1 : 2, 1);
    }
}
