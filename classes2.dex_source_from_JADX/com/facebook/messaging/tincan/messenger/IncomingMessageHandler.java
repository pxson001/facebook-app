package com.facebook.messaging.tincan.messenger;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.notify.NewMessageNotificationFactory;
import com.facebook.messaging.notify.TincanMessageRequestNotification;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.tincan.database.DbFetchTincanMessagesHandler;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.facebook.messaging.tincan.database.SalamanderDecoder;
import com.facebook.messaging.tincan.database.TincanDbThreadsFetcher;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.messaging.tincan.inbound.ConnectionReceiver;
import com.facebook.messaging.tincan.inbound.PacketIdFactory;
import com.facebook.messaging.tincan.inbound.TincanPacket;
import com.facebook.messaging.tincan.outbound.Sender;
import com.facebook.messaging.tincan.thrift.CallerIDPayload;
import com.facebook.messaging.tincan.thrift.MessagingCollectionAddress;
import com.facebook.messaging.tincan.thrift.PacketType;
import com.facebook.messaging.tincan.thrift.Salamander;
import com.facebook.messaging.tincan.thrift.SalamanderType;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_ping_replies_received */
public class IncomingMessageHandler {
    private static final Class<?> f15241a = IncomingMessageHandler.class;
    private static volatile IncomingMessageHandler f15242u;
    private final DefaultBlueServiceOperationFactory f15243b;
    private final Provider<ConnectionReceiver> f15244c;
    private final DbWriteTincanHandler f15245d;
    private final SalamanderDecoder f15246e;
    private final DbFetchThreadUsersHandler f15247f;
    private final Provider<CacheInsertThreadsHandler> f15248g;
    private final Provider<MessageExpirationHelper> f15249h;
    private final MessagesBroadcaster f15250i;
    public final Provider<String> f15251j;
    private final Resources f15252k;
    private final TincanDbThreadsFetcher f15253l;
    private final TincanHelper f15254m;
    private final TincanSnippetHelper f15255n;
    private final NewMessageNotificationFactory f15256o;
    private final Provider<MessagesNotificationClient> f15257p;
    private final AppStateManager f15258q;
    private final DbFetchTincanMessagesHandler f15259r;
    private final Sender f15260s;
    private final MessengerPacketIdFactory f15261t;

    /* compiled from: total_ping_replies_received */
    public class OnInitBroadcastReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<IncomingMessageHandler> {
        private final TincanGatekeepers f2333a;

        protected void onReceive(Context context, Intent intent, Object obj) {
            IncomingMessageHandler incomingMessageHandler = (IncomingMessageHandler) obj;
            if (this.f2333a.m4519a()) {
                IncomingMessageHandler.m21761a(incomingMessageHandler);
            }
        }

        @Inject
        public OnInitBroadcastReceiverRegistration(Lazy<IncomingMessageHandler> lazy, TincanGatekeepers tincanGatekeepers) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, AppStateManager.f1110b);
            this.f2333a = tincanGatekeepers;
        }
    }

    public static com.facebook.messaging.tincan.messenger.IncomingMessageHandler m21754a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15242u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.messenger.IncomingMessageHandler.class;
        monitor-enter(r1);
        r0 = f15242u;	 Catch:{ all -> 0x003a }
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
        r0 = m21765b(r0);	 Catch:{ all -> 0x0035 }
        f15242u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15242u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.IncomingMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.IncomingMessageHandler");
    }

    private static IncomingMessageHandler m21765b(InjectorLike injectorLike) {
        return new IncomingMessageHandler(DefaultBlueServiceOperationFactory.m3780a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2727), DbWriteTincanHandler.m21775a(injectorLike), SalamanderDecoder.m21822a(injectorLike), DbFetchThreadUsersHandler.m21839a(injectorLike), IdBasedProvider.m1811a(injectorLike, 7695), IdBasedProvider.m1811a(injectorLike, 8577), MessagesBroadcaster.m21869a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), ResourcesMethodAutoProvider.m6510a(injectorLike), TincanDbThreadsFetcher.m21906a(injectorLike), TincanHelper.m21960a(injectorLike), TincanSnippetHelper.m21971a(injectorLike), NewMessageNotificationFactory.m22097a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8006), AppStateManager.m2245a(injectorLike), DbFetchTincanMessagesHandler.m22107a(injectorLike), Sender.m22110a(injectorLike), MessengerPacketIdFactory.m23032a(injectorLike));
    }

    @Inject
    public IncomingMessageHandler(BlueServiceOperationFactory blueServiceOperationFactory, Provider<ConnectionReceiver> provider, DbWriteTincanHandler dbWriteTincanHandler, SalamanderDecoder salamanderDecoder, DbFetchThreadUsersHandler dbFetchThreadUsersHandler, Provider<CacheInsertThreadsHandler> provider2, Provider<MessageExpirationHelper> provider3, MessagesBroadcaster messagesBroadcaster, Provider<String> provider4, Resources resources, TincanDbThreadsFetcher tincanDbThreadsFetcher, TincanHelper tincanHelper, TincanSnippetHelper tincanSnippetHelper, NewMessageNotificationFactory newMessageNotificationFactory, Provider<MessagesNotificationClient> provider5, AppStateManager appStateManager, DbFetchTincanMessagesHandler dbFetchTincanMessagesHandler, Sender sender, PacketIdFactory packetIdFactory) {
        this.f15243b = blueServiceOperationFactory;
        this.f15244c = provider;
        this.f15245d = dbWriteTincanHandler;
        this.f15246e = salamanderDecoder;
        this.f15247f = dbFetchThreadUsersHandler;
        this.f15248g = provider2;
        this.f15249h = provider3;
        this.f15250i = messagesBroadcaster;
        this.f15251j = provider4;
        this.f15252k = resources;
        this.f15253l = tincanDbThreadsFetcher;
        this.f15254m = tincanHelper;
        this.f15255n = tincanSnippetHelper;
        this.f15256o = newMessageNotificationFactory;
        this.f15257p = provider5;
        this.f15258q = appStateManager;
        this.f15259r = dbFetchTincanMessagesHandler;
        this.f15260s = sender;
        this.f15261t = packetIdFactory;
    }

    public final void m21767a(TincanPacket tincanPacket) {
        MessagingCollectionAddress messagingCollectionAddress = tincanPacket.b.msg_from;
        Long l = messagingCollectionAddress.user_id;
        String str = messagingCollectionAddress.instance_id;
        TincanMessageRequestNotification tincanMessageRequestNotification = new TincanMessageRequestNotification(this.f15252k.getString(2131232385), this.f15252k.getString(2131232386));
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f15257p.get();
        Intent intent = new Intent(MessagesNotificationIntents.v);
        intent.putExtra("notification", tincanMessageRequestNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
        m21762a(messagingCollectionAddress.user_id);
        if (this.f15258q.m2264l()) {
            m21761a(this);
        }
    }

    public final void m21770b(TincanPacket tincanPacket) {
        CallerIDPayload f = tincanPacket.b.body.f();
        Name name = new Name(f.first_name, f.last_name);
        name.m5813f();
        this.f15245d.m21790a(f.user_id.longValue(), name.m5808a(), name.m5810c(), name.m5813f());
        ((ConnectionReceiver) this.f15244c.get()).a(tincanPacket.a);
    }

    public final void m21769a(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        ThreadKey a = this.f15254m.m21962a(str);
        ThreadKey a2 = this.f15254m.m21962a(str2);
        this.f15245d.m21799a(a2, true);
        ((CacheInsertThreadsHandler) this.f15248g.get()).a(a, a2);
        ((CacheInsertThreadsHandler) this.f15248g.get()).a.a(a2, true);
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_key", a2);
        BlueServiceOperationFactoryDetour.a(this.f15243b, "TincanSendAnyQueuedMessages", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(IncomingMessageHandler.class), -146550065).mo3451a(true).mo3452a();
        this.f15250i.m21880a();
        this.f15250i.m21896b(a, a2);
    }

    public final void m21771b(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        m21758a(this.f15254m.m21962a(str), this.f15254m.m21962a(str2));
    }

    public final void m21768a(TincanPacket tincanPacket, byte[] bArr) {
        Preconditions.checkArgument(bArr != null);
        MessagingCollectionAddress messagingCollectionAddress = tincanPacket.b.msg_from;
        String str = tincanPacket.a;
        Long l = messagingCollectionAddress.user_id;
        String str2 = messagingCollectionAddress.instance_id;
        Salamander a = this.f15246e.m21831a(bArr);
        if (a == null) {
            m21755a(6530, tincanPacket);
        } else if (a.type == null || !SalamanderType.a.contains(a.type)) {
            m21755a(6540, tincanPacket);
        }
        MessageBuilder newBuilder = Message.newBuilder();
        try {
            this.f15246e.m21833a(str, messagingCollectionAddress.instance_id, messagingCollectionAddress.user_id.longValue(), tincanPacket.b.date_micros.longValue(), a, newBuilder);
        } catch (Throwable e) {
            BLog.b(f15241a, "Received salamander decoded with invalid body", e);
            m21755a(6550, tincanPacket);
        }
        Message R = newBuilder.R();
        if (R.K != null) {
            this.f15245d.m21801a(R.a, R.K.longValue());
        }
        if (m21764a(a)) {
            this.f15245d.m21799a(R.b, false);
            m21766b(R.b);
        }
        m21756a(R);
    }

    public final void m21772c(TincanPacket tincanPacket) {
        PacketType.b.get(tincanPacket.b.type);
        Base64.encodeToString(tincanPacket.b.body.g(), 0);
        if (tincanPacket.b.type.intValue() == 7000) {
            m21763a(new String(tincanPacket.b.body.g()));
            m21760a(tincanPacket, 2131232408);
        } else if (tincanPacket.b.type.intValue() >= 3000 && tincanPacket.b.type.intValue() <= 3999) {
            r0 = this.f15253l.m21910a(tincanPacket.b.body.g());
            if (r0 != null) {
                String str = "deviceidinvalid";
                long j = r0.d;
                String str2 = (String) this.f15251j.get();
                Preconditions.checkState(str2 != null);
                ThreadKey a = ThreadKey.a(str, j, Long.parseLong(str2));
                this.f15245d.m21794a(r0, a, "");
                m21758a(r0, a);
            }
        } else if (tincanPacket.b.type.intValue() >= 4000 && tincanPacket.b.type.intValue() <= 4999) {
            r0 = this.f15253l.m21910a(tincanPacket.b.body.g());
            if (r0 != null) {
                m21757a(r0);
            }
        } else if (tincanPacket.b.type.intValue() >= 6000 && tincanPacket.b.type.intValue() <= 6999) {
            m21763a(new String(tincanPacket.b.body.g()));
        }
    }

    public final void m21773d(TincanPacket tincanPacket) {
        Long l = tincanPacket.b.body.h().unix_time_micros;
        if (l == null) {
            BLog.b(f15241a, "Invalid delivery-receipt payload.");
            return;
        }
        long longValue = l.longValue() / 1000;
        ThreadKey a = this.f15246e.m21830a(tincanPacket.b.msg_from.instance_id, tincanPacket.b.msg_from.user_id.longValue());
        this.f15245d.m21807b(a, longValue);
        FetchThreadResult a2 = this.f15253l.m21911a(a, 0);
        if (a2.c == null) {
            BLog.a(f15241a, "Thread %s not found when processing delivery receipt.", new Object[]{a.toString()});
            return;
        }
        ((CacheInsertThreadsHandler) this.f15248g.get()).b(a2.c, a2.f);
        this.f15250i.m21885a(a);
    }

    public final void m21774e(TincanPacket tincanPacket) {
        Long l = tincanPacket.b.body.h().unix_time_micros;
        if (l == null) {
            BLog.b(f15241a, "Invalid read-receipt payload.");
            return;
        }
        long longValue = l.longValue() / 1000;
        ThreadKey a = this.f15246e.m21830a(tincanPacket.b.msg_from.instance_id, tincanPacket.b.msg_from.user_id.longValue());
        this.f15245d.m21808c(a, longValue);
        FetchThreadResult a2 = this.f15253l.m21911a(a, 0);
        if (a2.c == null) {
            BLog.a(f15241a, "Thread %s not found when processing read receipt.", new Object[]{a.toString()});
            return;
        }
        ((CacheInsertThreadsHandler) this.f15248g.get()).a(a2.c, a2.f);
        ((MessageExpirationHelper) this.f15249h.get()).a(a, longValue);
        this.f15250i.m21885a(a);
    }

    private void m21760a(TincanPacket tincanPacket, int i) {
        ThreadKey a = this.f15253l.m21910a(tincanPacket.b.body.g());
        if (a == null) {
            Message a2 = this.f15259r.m22109a(new String(tincanPacket.b.body.g()));
            if (a2 != null) {
                a = a2.b;
            }
        }
        if (a != null) {
            this.f15245d.m21799a(a, false);
            m21766b(a);
            m21759a(a, this.f15252k.getString(i));
        }
    }

    private void m21758a(ThreadKey threadKey, ThreadKey threadKey2) {
        ((CacheInsertThreadsHandler) this.f15248g.get()).a(threadKey, threadKey2);
        m21766b(threadKey2);
        m21759a(threadKey2, this.f15252k.getString(2131232405));
        this.f15250i.m21880a();
        this.f15250i.m21896b(threadKey, threadKey2);
    }

    private void m21757a(ThreadKey threadKey) {
        m21759a(threadKey, this.f15252k.getString(2131232405));
        this.f15245d.m21799a(threadKey, false);
        m21766b(threadKey);
        this.f15250i.m21880a();
        this.f15250i.m21885a(threadKey);
    }

    private void m21763a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        BlueServiceOperationFactoryDetour.a(this.f15243b, "TincanSetSalamanderError", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(IncomingMessageHandler.class), -1026420155).mo3452a();
    }

    private void m21756a(Message message) {
        this.f15255n.m21972a(message);
        ((CacheInsertThreadsHandler) this.f15248g.get()).b(new NewMessageResult(DataFreshnessResult.FROM_SERVER, message, null, null, message.c));
        this.f15250i.m21885a(message.b);
        ((MessagesNotificationClient) this.f15257p.get()).a(this.f15256o.m22099a(message, message.b, ThreadCustomization.a, new PushProperty(PushSource.TINCAN), TriState.YES));
    }

    private void m21762a(Long l) {
        String valueOf = String.valueOf(l);
        if (!this.f15253l.m21916b(valueOf)) {
            User a = this.f15247f.m21845a(new UserKey(Type.FACEBOOK, valueOf));
            if (a != null) {
                this.f15245d.m21790a(l.longValue(), a.m5843h(), a.m5844i(), a.m5846k());
            } else {
                this.f15245d.m21790a(l.longValue(), "Unknown", "Unknown", "Unknown");
            }
        }
    }

    public static void m21761a(IncomingMessageHandler incomingMessageHandler) {
        BlueServiceOperationFactoryDetour.a(incomingMessageHandler.f15243b, "TincanAutoAcceptPendingSession", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(TincanIncomingDispatcher.class), 1437732143).mo3452a();
        ((MessagesNotificationClient) incomingMessageHandler.f15257p.get()).a();
    }

    private void m21766b(ThreadKey threadKey) {
        FetchThreadResult a = this.f15253l.m21911a(threadKey, 0);
        if (a != FetchThreadResult.a) {
            ((CacheInsertThreadsHandler) this.f15248g.get()).b(a);
        }
    }

    private void m21759a(ThreadKey threadKey, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_key", threadKey);
        bundle.putString("message", str);
        BlueServiceOperationFactoryDetour.a(this.f15243b, "TincanAdminMessage", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(TincanIncomingDispatcher.class), 1994068465).mo3452a();
    }

    private static boolean m21764a(Salamander salamander) {
        return (salamander == null || salamander.type == null || salamander.type.intValue() != 2) ? false : true;
    }

    private void m21755a(int i, TincanPacket tincanPacket) {
        this.f15260s.m22118a(tincanPacket.b.msg_from, i, tincanPacket.b.sender_packet_id, this.f15261t.m23034a());
    }
}
