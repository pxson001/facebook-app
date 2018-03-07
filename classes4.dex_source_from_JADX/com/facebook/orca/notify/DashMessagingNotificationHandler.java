package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.messages.ipc.FrozenNewMessageNotificationFactory;
import com.facebook.messages.ipc.MessagesCrossProcessContract;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.ipc.MessagingNotificationPreferences;
import com.facebook.messages.ipc.peer.MessageNotificationPeerHelper;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.push.PushSource;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: share_xma_token */
public class DashMessagingNotificationHandler extends AbstractMessagingNotificationHandler {
    private static volatile DashMessagingNotificationHandler f2246h;
    public final Context f2247a;
    private final MessagesCrossProcessContract f2248b;
    private final FrozenNewMessageNotificationFactory f2249c;
    public final MessagingIntentUris f2250d;
    private final Provider<String> f2251e;
    private final StatefulPeerManagerImpl f2252f;
    public final FbAndroidMessagingNotificationPreferences f2253g;

    public static com.facebook.orca.notify.DashMessagingNotificationHandler m2475a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2246h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.DashMessagingNotificationHandler.class;
        monitor-enter(r1);
        r0 = f2246h;	 Catch:{ all -> 0x003a }
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
        r0 = m2476b(r0);	 Catch:{ all -> 0x0035 }
        f2246h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2246h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.DashMessagingNotificationHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.DashMessagingNotificationHandler");
    }

    private static DashMessagingNotificationHandler m2476b(InjectorLike injectorLike) {
        return new DashMessagingNotificationHandler((Context) injectorLike.getInstance(Context.class), MessagesCrossProcessContract.m9243a(injectorLike), new FrozenNewMessageNotificationFactory(), FbandroidMessagingIntentUris.m2487a(injectorLike), IdBasedProvider.a(injectorLike, 4442), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), FbAndroidMessagingNotificationPreferences.m10901a(injectorLike));
    }

    protected final void mo157a(ReadThreadNotification readThreadNotification) {
        Iterator it = readThreadNotification.a.keySet().iterator();
        while (it.hasNext()) {
            mo155a((ThreadKey) it.next(), null);
        }
    }

    @Inject
    public DashMessagingNotificationHandler(Context context, MessagesCrossProcessContract messagesCrossProcessContract, FrozenNewMessageNotificationFactory frozenNewMessageNotificationFactory, MessagingIntentUris messagingIntentUris, Provider<String> provider, StatefulPeerManager statefulPeerManager, MessagingNotificationPreferences messagingNotificationPreferences) {
        this.f2247a = context;
        this.f2248b = messagesCrossProcessContract;
        this.f2249c = frozenNewMessageNotificationFactory;
        this.f2250d = messagingIntentUris;
        this.f2251e = provider;
        this.f2252f = statefulPeerManager;
        this.f2253g = messagingNotificationPreferences;
    }

    protected final void mo156a(NewMessageNotification newMessageNotification) {
        if (!newMessageNotification.b()) {
            boolean z = false;
            ThreadKey threadKey = newMessageNotification.d;
            if (threadKey != null) {
                z = Boolean.TRUE.equals(this.f2252f.a(Uri.parse("peer://msg_notification_dash/active_threads/" + threadKey.toString())));
            }
            if (!z) {
                newMessageNotification.h.a = true;
            }
        }
    }

    protected final void mo159b(NewMessageNotification newMessageNotification) {
        if (newMessageNotification.d != null && !PushSource.SMS_READONLY_MODE.equals(newMessageNotification.g.a) && !newMessageNotification.h.a) {
            String str = (String) this.f2251e.get();
            if (str != null) {
                String str2;
                Message message = newMessageNotification.c;
                int a = MessageNotificationPeerHelper.a(newMessageNotification.d, message.a, this.f2252f);
                if (this.f2253g.m10903b()) {
                    str2 = message.f;
                } else {
                    str2 = this.f2247a.getResources().getQuantityString(2131689496, a, new Object[]{Integer.valueOf(a)});
                }
                FrozenNewMessageNotificationFactory frozenNewMessageNotificationFactory = this.f2249c;
                String threadKey = newMessageNotification.d.toString();
                GroupMessageInfo groupMessageInfo = newMessageNotification.e;
                String str3 = "android.intent.action.VIEW";
                Intent intent = new Intent(str3, this.f2250d.mo166a(newMessageNotification.d));
                intent.setFlags(67108864);
                intent.putExtra("from_notification", true);
                intent.putExtra("trigger", "notification");
                this.f2248b.m9245a(frozenNewMessageNotificationFactory.m2486a(message, threadKey, str2, groupMessageInfo, PendingIntent.getActivity(this.f2247a, 0, intent, 0), str), str);
            }
        }
    }

    protected final void mo162a(LoggedOutMessageNotification loggedOutMessageNotification) {
    }

    protected final void mo161a(FriendInstallNotification friendInstallNotification) {
    }

    protected final void mo160a(FailedToSendMessageNotification failedToSendMessageNotification) {
    }

    public final void mo158a(String str) {
        MessagesCrossProcessContract messagesCrossProcessContract = this.f2248b;
        String str2 = (String) this.f2251e.get();
        Intent intent = new Intent(messagesCrossProcessContract.f8886e);
        intent.putExtra("userId", str2);
        messagesCrossProcessContract.f8882a.sendBroadcast(intent, messagesCrossProcessContract.f8884c);
    }

    public final void mo155a(ThreadKey threadKey, String str) {
        MessagesCrossProcessContract messagesCrossProcessContract = this.f2248b;
        String str2 = (String) this.f2251e.get();
        Intent intent = new Intent(messagesCrossProcessContract.f8887f);
        intent.putExtra("threadId", threadKey.toString());
        intent.putExtra("userId", str2);
        messagesCrossProcessContract.f8882a.sendBroadcast(intent, messagesCrossProcessContract.f8884c);
    }
}
