package com.facebook.messages.ipc.peer;

import android.net.Uri;
import com.facebook.multiprocess.peer.state.PeerStateRole;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_since_fetched */
public class NotificationPeerRoleFactory {
    private static volatile NotificationPeerRoleFactory f2827a;

    public static com.facebook.messages.ipc.peer.NotificationPeerRoleFactory m4831a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f2827a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messages.ipc.peer.NotificationPeerRoleFactory.class;
        monitor-enter(r1);
        r0 = f2827a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m4830a();	 Catch:{ all -> 0x0034 }
        f2827a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2827a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messages.ipc.peer.NotificationPeerRoleFactory.a(com.facebook.inject.InjectorLike):com.facebook.messages.ipc.peer.NotificationPeerRoleFactory");
    }

    private static NotificationPeerRoleFactory m4830a() {
        return new NotificationPeerRoleFactory();
    }

    public final PeerStateRole m4832a(Uri uri, int i) {
        if (MessageNotificationPeerContract.f2835a.equals(uri)) {
            return new DashPeerRole(i);
        }
        if (MessageNotificationPeerContract.f2839e.equals(uri)) {
            return new ChatHeadPeerRole(i);
        }
        if (MessageNotificationPeerContract.f2847m.equals(uri)) {
            return new UserInteractionPeerRole(i);
        }
        if (MessageNotificationPeerContract.f2849o.equals(uri)) {
            return new ThreadUnreadCountPeerRole(i);
        }
        return null;
    }
}
