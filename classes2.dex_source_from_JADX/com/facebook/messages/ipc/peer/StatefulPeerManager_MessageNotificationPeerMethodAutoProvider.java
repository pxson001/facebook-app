package com.facebook.messages.ipc.peer;

import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.MessagesNotificationProcessTypeMethodAutoProvider;
import com.facebook.multiprocess.peer.PeerProcessManagerFactory;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;

/* compiled from: time_since_init */
public class StatefulPeerManager_MessageNotificationPeerMethodAutoProvider extends AbstractProvider<StatefulPeerManager> {
    private static volatile StatefulPeerManagerImpl f2826a;

    public static com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl m4828a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2826a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f2826a;	 Catch:{ all -> 0x003a }
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
        r0 = m4829b(r0);	 Catch:{ all -> 0x0035 }
        f2826a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2826a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl");
    }

    private static StatefulPeerManagerImpl m4829b(InjectorLike injectorLike) {
        return MessageNotificationPeerModule.m4837a(NotificationPeerRoleFactory.m4831a(injectorLike), MessagesNotificationProcessTypeMethodAutoProvider.m4833a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), PeerProcessManagerFactory.m4834a(injectorLike), CrossFbAppBroadcastManager.m3885a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    public Object get() {
        return MessageNotificationPeerModule.m4837a(NotificationPeerRoleFactory.m4831a(this), MessagesNotificationProcessTypeMethodAutoProvider.m4833a(this), (FbAppType) getInstance(FbAppType.class), PeerProcessManagerFactory.m4834a(this), CrossFbAppBroadcastManager.m3885a(this), IdBasedSingletonScopeProvider.m1810b(this, 494));
    }
}
