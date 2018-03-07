package com.facebook.orca.notify;

import android.app.Activity;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pysf_size_param */
public class MessagesForegroundActivityListener {
    private static volatile MessagesForegroundActivityListener f8543c;
    public final StatefulPeerManagerImpl f8544a;
    public Activity f8545b;

    public static com.facebook.orca.notify.MessagesForegroundActivityListener m13089a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8543c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.MessagesForegroundActivityListener.class;
        monitor-enter(r1);
        r0 = f8543c;	 Catch:{ all -> 0x003a }
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
        r0 = m13090b(r0);	 Catch:{ all -> 0x0035 }
        f8543c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8543c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.MessagesForegroundActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.MessagesForegroundActivityListener");
    }

    private static MessagesForegroundActivityListener m13090b(InjectorLike injectorLike) {
        return new MessagesForegroundActivityListener(StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.m4828a(injectorLike));
    }

    @Inject
    public MessagesForegroundActivityListener(StatefulPeerManagerImpl statefulPeerManagerImpl) {
        this.f8544a = statefulPeerManagerImpl;
    }

    public final void m13091a(Activity activity) {
        this.f8545b = activity;
        if (this.f8544a != null) {
            this.f8544a.m4872a(MessageNotificationPeerContract.f2848n, Boolean.valueOf(true));
        }
    }

    public final Activity m13092b() {
        return this.f8545b;
    }
}
