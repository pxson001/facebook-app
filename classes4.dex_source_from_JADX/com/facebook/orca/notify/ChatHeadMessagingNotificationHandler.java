package com.facebook.orca.notify;

import android.app.KeyguardManager;
import android.net.Uri;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher;
import com.facebook.messaging.chatheads.ipc.ChatHeadMessageNotification;
import com.facebook.messaging.chatheads.ipc.ChatHeadMessageNotification.Builder;
import com.facebook.messaging.chatheads.ipc.ChatHeadsMuteStateManager;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.AlertDisposition;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: shimmed */
public class ChatHeadMessagingNotificationHandler extends AbstractMessagingNotificationHandler {
    private static volatile ChatHeadMessagingNotificationHandler f2233j;
    private final Provider<Boolean> f2234a;
    private final KeyguardManager f2235b;
    private final MessagesForegroundActivityListener f2236c;
    private final ChatHeadsIntentDispatcher f2237d;
    private final StatefulPeerManagerImpl f2238e;
    private final ScreenPowerState f2239f;
    private final MessageUtil f2240g;
    private final ChatHeadsMuteStateManager f2241h;
    private final RuntimePermissionsUtil f2242i;

    public static com.facebook.orca.notify.ChatHeadMessagingNotificationHandler m2435a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2233j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.ChatHeadMessagingNotificationHandler.class;
        monitor-enter(r1);
        r0 = f2233j;	 Catch:{ all -> 0x003a }
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
        r0 = m2436b(r0);	 Catch:{ all -> 0x0035 }
        f2233j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2233j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.ChatHeadMessagingNotificationHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.ChatHeadMessagingNotificationHandler");
    }

    private static ChatHeadMessagingNotificationHandler m2436b(InjectorLike injectorLike) {
        return new ChatHeadMessagingNotificationHandler(IdBasedProvider.a(injectorLike, 4128), KeyguardManagerMethodAutoProvider.b(injectorLike), MessagesForegroundActivityListener.a(injectorLike), ChatHeadsIntentDispatcher.m1684a(injectorLike), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), ScreenPowerState.a(injectorLike), MessageUtil.a(injectorLike), ChatHeadsMuteStateManager.m2473b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public ChatHeadMessagingNotificationHandler(Provider<Boolean> provider, KeyguardManager keyguardManager, MessagesForegroundActivityListener messagesForegroundActivityListener, ChatHeadsIntentDispatcher chatHeadsIntentDispatcher, StatefulPeerManager statefulPeerManager, ScreenPowerState screenPowerState, MessageUtil messageUtil, ChatHeadsMuteStateManager chatHeadsMuteStateManager, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f2234a = provider;
        this.f2235b = keyguardManager;
        this.f2236c = messagesForegroundActivityListener;
        this.f2237d = chatHeadsIntentDispatcher;
        this.f2238e = statefulPeerManager;
        this.f2239f = screenPowerState;
        this.f2240g = messageUtil;
        this.f2241h = chatHeadsMuteStateManager;
        this.f2242i = runtimePermissionsUtil;
    }

    protected final void mo156a(NewMessageNotification newMessageNotification) {
        AlertDisposition alertDisposition = newMessageNotification.h;
        if (((Boolean) this.f2234a.get()).booleanValue() && this.f2242i.a()) {
            ChatHeadsMuteStateManager chatHeadsMuteStateManager = this.f2241h;
            ThreadKey threadKey = newMessageNotification.d;
            Object obj = null;
            if (((Boolean) chatHeadsMuteStateManager.f2245c.get()).booleanValue() && threadKey != null) {
                String g = threadKey.g();
                Object obj2 = chatHeadsMuteStateManager.f2243a.a("chat_head_mute_state", g) >= 2 ? 1 : null;
                Object obj3;
                if (chatHeadsMuteStateManager.f2244b.a() - chatHeadsMuteStateManager.f2243a.b("chat_head_mute_state", g) < 86400000) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (!(obj2 == null || r6 == null)) {
                    int i = 1;
                }
            }
            if (obj == null) {
                return;
            }
        }
        alertDisposition.b = true;
    }

    protected final void mo159b(NewMessageNotification newMessageNotification) {
        if (!newMessageNotification.h.b) {
            if (!Boolean.TRUE.equals(this.f2238e.a(MessageNotificationPeerContract.j)) || !Boolean.TRUE.equals(this.f2238e.a(MessageNotificationPeerContract.n))) {
                if (!this.f2235b.inKeyguardRestrictedInputMode() || this.f2236c.b == null) {
                    AlertDisposition alertDisposition = newMessageNotification.h;
                    if (!alertDisposition.g) {
                        if (!MessageUtil.B(newMessageNotification.c) || this.f2240g.w(newMessageNotification.c)) {
                            ThreadKey threadKey = newMessageNotification.d;
                            if (threadKey != null) {
                                Object obj;
                                if ((Boolean.TRUE.equals(this.f2238e.a(Uri.parse("peer://msg_notification_chathead/active_threads/" + Uri.encode(threadKey.toString())))) && this.f2239f.a()) || Boolean.TRUE.equals(this.f2238e.a(MessageNotificationPeerContract.n))) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (newMessageNotification.b() || r0 != null) {
                                    ChatHeadsIntentDispatcher chatHeadsIntentDispatcher = this.f2237d;
                                    Builder builder = new Builder();
                                    builder.a = newMessageNotification.c;
                                    builder = builder;
                                    chatHeadsIntentDispatcher.m1691a(new ChatHeadMessageNotification(builder.a, builder.b, builder.c));
                                    alertDisposition.g = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected final void mo157a(ReadThreadNotification readThreadNotification) {
        if (((Boolean) this.f2234a.get()).booleanValue()) {
            Iterator it = readThreadNotification.a.keySet().iterator();
            while (it.hasNext()) {
                this.f2237d.m1696c((ThreadKey) it.next(), "read_on_web");
            }
        }
    }

    public final void mo155a(ThreadKey threadKey, String str) {
        if (((Boolean) this.f2234a.get()).booleanValue()) {
            this.f2237d.m1696c(threadKey, str);
        }
    }

    public final void mo158a(String str) {
        if (((Boolean) this.f2234a.get()).booleanValue()) {
            this.f2237d.m1693a(str);
        }
    }
}
