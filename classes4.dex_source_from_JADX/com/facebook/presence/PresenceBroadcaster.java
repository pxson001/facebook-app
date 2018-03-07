package com.facebook.presence;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.CrossProcessBroadcastManager;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchStickerPacksParams */
public class PresenceBroadcaster {
    private static volatile PresenceBroadcaster f11709d;
    private final Context f11710a;
    private final CrossProcessBroadcastManager f11711b;
    private final BaseFbBroadcastManager f11712c;

    public static com.facebook.presence.PresenceBroadcaster m12254a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11709d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.presence.PresenceBroadcaster.class;
        monitor-enter(r1);
        r0 = f11709d;	 Catch:{ all -> 0x003a }
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
        r0 = m12256b(r0);	 Catch:{ all -> 0x0035 }
        f11709d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11709d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.presence.PresenceBroadcaster.a(com.facebook.inject.InjectorLike):com.facebook.presence.PresenceBroadcaster");
    }

    private static PresenceBroadcaster m12256b(InjectorLike injectorLike) {
        return new PresenceBroadcaster((Context) injectorLike.getInstance(Context.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), CrossProcessBroadcastManager.m12259a(injectorLike));
    }

    @Inject
    public PresenceBroadcaster(Context context, BaseFbBroadcastManager baseFbBroadcastManager, CrossProcessBroadcastManager crossProcessBroadcastManager) {
        this.f11710a = context;
        this.f11712c = baseFbBroadcastManager;
        this.f11711b = crossProcessBroadcastManager;
    }

    public final void m12257a(Message message) {
        Intent intent = new Intent("com.facebook.presence.ACTION_PUSH_RECEIVED");
        intent.putExtra("extra_message", message);
        m12255a(intent);
    }

    public final void m12258a(String str, PresenceList presenceList, boolean z) {
        Intent intent = new Intent("com.facebook.presence.ACTION_PRESENCE_RECEIVED");
        intent.putExtra("extra_topic_name", str);
        intent.putExtra("extra_presence_map", presenceList);
        intent.putExtra("extra_full_list", z);
        m12255a(intent);
    }

    private void m12255a(Intent intent) {
        this.f11712c.a(intent);
        this.f11711b.m12261a(intent, this.f11710a);
    }
}
