package com.facebook.notifications.lockscreenservice;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.FrozenNewMessageNotification;
import com.facebook.messages.ipc.MessagesCrossProcessBroadcastReceiver;
import com.facebook.messages.ipc.MessagesCrossProcessContract;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: loginMessengerAccountParams */
public class LockMessageLoader implements INeedInit {
    private static volatile LockMessageLoader f8873h;
    private final Context f8874a;
    private final Provider<String> f8875b;
    public final Map<String, MessageNotification> f8876c = Maps.c();
    private final MessagesCrossProcessContract f8877d;
    private final StatefulPeerManagerImpl f8878e;
    private final KeyguardManager f8879f;
    private final LockScreenUtil f8880g;

    /* compiled from: loginMessengerAccountParams */
    public class C05341 {
        public final /* synthetic */ LockMessageLoader f11150a;

        C05341(LockMessageLoader lockMessageLoader) {
            this.f11150a = lockMessageLoader;
        }
    }

    public static com.facebook.notifications.lockscreenservice.LockMessageLoader m9236a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8873h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.lockscreenservice.LockMessageLoader.class;
        monitor-enter(r1);
        r0 = f8873h;	 Catch:{ all -> 0x003a }
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
        r0 = m9239b(r0);	 Catch:{ all -> 0x0035 }
        f8873h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8873h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.lockscreenservice.LockMessageLoader.a(com.facebook.inject.InjectorLike):com.facebook.notifications.lockscreenservice.LockMessageLoader");
    }

    private static LockMessageLoader m9239b(InjectorLike injectorLike) {
        return new LockMessageLoader((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), MessagesCrossProcessContract.m9243a(injectorLike), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), KeyguardManagerMethodAutoProvider.b(injectorLike), LockScreenUtil.m9246a(injectorLike));
    }

    @Inject
    public LockMessageLoader(Context context, Provider<String> provider, MessagesCrossProcessContract messagesCrossProcessContract, StatefulPeerManager statefulPeerManager, KeyguardManager keyguardManager, LockScreenUtil lockScreenUtil) {
        this.f8874a = context;
        this.f8875b = provider;
        this.f8877d = messagesCrossProcessContract;
        this.f8878e = statefulPeerManager;
        this.f8879f = keyguardManager;
        this.f8880g = lockScreenUtil;
    }

    public void init() {
        MessagesCrossProcessContract messagesCrossProcessContract = this.f8877d;
        C05341 c05341 = new C05341(this);
        Context context = this.f8874a;
        MessagesCrossProcessBroadcastReceiver messagesCrossProcessBroadcastReceiver = new MessagesCrossProcessBroadcastReceiver(c05341, messagesCrossProcessContract.f8883b);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(messagesCrossProcessContract.f8885d);
        intentFilter.addAction(messagesCrossProcessContract.f8886e);
        intentFilter.addAction(messagesCrossProcessContract.f8887f);
        context.registerReceiver(messagesCrossProcessBroadcastReceiver, intentFilter, messagesCrossProcessContract.f8884c, null);
    }

    @VisibleForTesting
    public final void m9241a(FrozenNewMessageNotification frozenNewMessageNotification) {
        if (frozenNewMessageNotification != null && this.f8880g.m9264c(true)) {
            String str = (String) this.f8875b.get();
            String str2 = frozenNewMessageNotification.c;
            if (str == null || !str.equals(str2)) {
                String str3 = frozenNewMessageNotification.e;
                MessageNotification messageNotification = (MessageNotification) this.f8876c.get(str3);
                Set set = (Set) this.f8878e.a(Uri.parse("peer://msg_notification_unread_count/thread/" + Uri.encode(str3)));
                int size = set == null ? 1 : set.contains(frozenNewMessageNotification.a) ? set.size() : set.size() + 1;
                int i = size;
                if (messageNotification == null) {
                    messageNotification = new MessageNotification(i, frozenNewMessageNotification);
                    this.f8876c.put(str3, messageNotification);
                } else {
                    FrozenNewMessageNotification frozenNewMessageNotification2 = messageNotification.c;
                    if (Objects.equal(frozenNewMessageNotification2, frozenNewMessageNotification) || frozenNewMessageNotification2.j >= frozenNewMessageNotification.j) {
                        messageNotification = null;
                    } else {
                        messageNotification = new MessageNotification(i, frozenNewMessageNotification);
                        this.f8876c.put(str3, messageNotification);
                    }
                }
                if (messageNotification != null) {
                    m9240c();
                }
            }
        }
    }

    public final void m9242b() {
        this.f8876c.clear();
        this.f8878e.a(MessageNotificationPeerContract.c, null);
        m9240c();
    }

    public static void m9237a(LockMessageLoader lockMessageLoader, String str) {
        MessageNotification messageNotification = (MessageNotification) lockMessageLoader.f8876c.get(str);
        if (messageNotification != null) {
            lockMessageLoader.m9238a(messageNotification);
        }
    }

    private void m9238a(MessageNotification messageNotification) {
        String str = messageNotification.c.e;
        if (this.f8876c.containsKey(str)) {
            this.f8876c.remove(str);
        }
        m9240c();
    }

    private void m9240c() {
        if (this.f8880g.m9264c(true) && this.f8879f.inKeyguardRestrictedInputMode()) {
            Intent intent = new Intent(this.f8874a, LockScreenService.class);
            intent.setAction("com.facebook.notifications.lockscreen.ACTION_LAUNCH_LOCKSCREEN_NOTIFICATIONS");
            this.f8874a.startService(intent);
        }
    }
}
