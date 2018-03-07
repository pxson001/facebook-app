package com.facebook.orca.push.fbpushdata;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.database.ContactUpdateHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fblibraries.fblogin.FirstPartySsoSessionInfo;
import com.facebook.fblibraries.fblogin.SsoLoginUtil;
import com.facebook.fbservice.ops.BlueServiceOperation;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.ipc.MessengerUserUtils;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ReadThreadManager;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notificationpolicy.MessagePushData;
import com.facebook.messaging.notificationpolicy.NotificationDelayTestManager;
import com.facebook.messaging.notificationpolicy.NotificationPolicyEngine;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.facebook.messaging.notify.NewMessageNotification.MessengerUserStatus;
import com.facebook.messaging.notify.NewMessageNotificationFactory;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.SimpleMessageNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.MessagesSyncInitializationHandler;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.facebook.orca.push.MessagesPushHandler;
import com.facebook.presence.PresenceBroadcaster;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.push.externalcloud.PrimaryPushTokenHolder;
import com.facebook.push.fbpushdata.FbPushDataHandler;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: new_app_locale */
public class OrcaFbPushDataHandler implements FbPushDataHandler {
    private static final Object f6321H = new Object();
    public static final Class<?> f6322a = OrcaFbPushDataHandler.class;
    private final Lazy<MessageUtil> f6323A;
    private final Provider<Boolean> f6324B;
    private final RtcCallHandler f6325C;
    private final Random f6326D = new Random();
    private final NewMessageNotificationFactory f6327E;
    private final NotificationPolicyEngine f6328F;
    private final NotificationDelayTestManager f6329G;
    public final Executor f6330b;
    private final LoggedInUserSessionManager f6331c;
    private final Resources f6332d;
    public final MessagesPushHandler f6333e;
    private final PushDeserialization f6334f;
    private final PresenceBroadcaster f6335g;
    private final MessagesReliabilityLogger f6336h;
    private final PrimaryPushTokenHolder f6337i;
    private final MessengerUserUtils f6338j;
    public final Lazy<SsoLoginUtil> f6339k;
    private final Product f6340l;
    public final ObjectMapper f6341m;
    private final Provider<BlueServiceOperation> f6342n;
    private final ReadThreadManager f6343o;
    private final ContactUpdateHelper f6344p;
    private final DefaultBlueServiceOperationFactory f6345q;
    private final Provider<TriState> f6346r;
    private final FbNetworkManager f6347s;
    private final Provider<DataCache> f6348t;
    private final DbFetchThreadHandler f6349u;
    private final AbstractFbErrorReporter f6350v;
    private final BaseFbBroadcastManager f6351w;
    private final MessagingIntentUris f6352x;
    public final Context f6353y;
    public final MessagingPerformanceLogger f6354z;

    /* compiled from: new_app_locale */
    class C09531 implements ActionReceiver {
        final /* synthetic */ OrcaFbPushDataHandler f6316a;

        C09531(OrcaFbPushDataHandler orcaFbPushDataHandler) {
            this.f6316a = orcaFbPushDataHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1915881139);
            OrcaFbPushDataHandler orcaFbPushDataHandler = this.f6316a;
            ExecutorDetour.a(orcaFbPushDataHandler.f6330b, new C09542(orcaFbPushDataHandler, intent), 2028826261);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1040577991, a);
        }
    }

    /* compiled from: new_app_locale */
    public class C09542 implements Runnable {
        final /* synthetic */ Intent f6317a;
        final /* synthetic */ OrcaFbPushDataHandler f6318b;

        public C09542(OrcaFbPushDataHandler orcaFbPushDataHandler, Intent intent) {
            this.f6318b = orcaFbPushDataHandler;
            this.f6317a = intent;
        }

        public void run() {
            MessagePushData messagePushData = (MessagePushData) this.f6317a.getParcelableExtra("message_push_data");
            try {
                OrcaFbPushDataHandler.m5996a(this.f6318b, messagePushData.f3377a, this.f6318b.f6341m.a(messagePushData.f3378b), messagePushData.f3379c);
            } catch (Throwable e) {
                BLog.b(OrcaFbPushDataHandler.f6322a, e, "Failed to parse JSON.", new Object[0]);
            }
        }
    }

    private static OrcaFbPushDataHandler m6002b(InjectorLike injectorLike) {
        return new OrcaFbPushDataHandler((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), MessagesPushHandler.m5978a(injectorLike), PushDeserialization.m6009a(injectorLike), PresenceBroadcaster.a(injectorLike), MessagesReliabilityLogger.a(injectorLike), PrimaryPushTokenHolder.a(injectorLike), MessengerUserUtils.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5772), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 5796), ReadThreadManager.a(injectorLike), ContactUpdateHelper.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 722), FbNetworkManager.a(injectorLike), IdBasedProvider.a(injectorLike, 2567), DbFetchThreadHandler.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (MessagingIntentUris) FbandroidMessagingIntentUris.a(injectorLike), (Context) injectorLike.getInstance(Context.class), MessagingPerformanceLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 2664), IdBasedProvider.a(injectorLike, 4144), RtcCallHandler.a(injectorLike), NewMessageNotificationFactory.a(injectorLike), NotificationPolicyEngine.m3311a(injectorLike), NotificationDelayTestManager.m3279a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler m5993a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f6321H;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m6002b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6321H;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f6321H;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.push.fbpushdata.OrcaFbPushDataHandler");
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public OrcaFbPushDataHandler(ExecutorService executorService, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Resources resources, MessagesPushHandler messagesPushHandler, PushDeserialization pushDeserialization, PresenceBroadcaster presenceBroadcaster, MessagesReliabilityLogger messagesReliabilityLogger, PrimaryPushTokenHolder primaryPushTokenHolder, MessengerUserUtils messengerUserUtils, Lazy<SsoLoginUtil> lazy, ObjectMapper objectMapper, Product product, Provider<BlueServiceOperation> provider, ReadThreadManager readThreadManager, ContactUpdateHelper contactUpdateHelper, BlueServiceOperationFactory blueServiceOperationFactory, Provider<TriState> provider2, FbNetworkManager fbNetworkManager, Provider<DataCache> provider3, DbFetchThreadHandler dbFetchThreadHandler, FbErrorReporter fbErrorReporter, FbBroadcastManager fbBroadcastManager, MessagingIntentUris messagingIntentUris, Context context, MessagingPerformanceLogger messagingPerformanceLogger, Lazy<MessageUtil> lazy2, Provider<Boolean> provider4, RtcCallHandler rtcCallHandler, NewMessageNotificationFactory newMessageNotificationFactory, NotificationPolicyEngine notificationPolicyEngine, NotificationDelayTestManager notificationDelayTestManager) {
        this.f6330b = executorService;
        this.f6331c = loggedInUserAuthDataStore;
        this.f6332d = resources;
        this.f6333e = messagesPushHandler;
        this.f6334f = pushDeserialization;
        this.f6335g = presenceBroadcaster;
        this.f6336h = messagesReliabilityLogger;
        this.f6337i = primaryPushTokenHolder;
        this.f6338j = messengerUserUtils;
        this.f6339k = lazy;
        this.f6341m = objectMapper;
        this.f6340l = product;
        this.f6342n = provider;
        this.f6343o = readThreadManager;
        this.f6344p = contactUpdateHelper;
        this.f6345q = blueServiceOperationFactory;
        this.f6346r = provider2;
        this.f6347s = fbNetworkManager;
        this.f6348t = provider3;
        this.f6349u = dbFetchThreadHandler;
        this.f6350v = fbErrorReporter;
        this.f6351w = fbBroadcastManager;
        this.f6352x = messagingIntentUris;
        this.f6353y = context;
        this.f6354z = messagingPerformanceLogger;
        this.f6323A = lazy2;
        this.f6324B = provider4;
        this.f6325C = rtcCallHandler;
        this.f6327E = newMessageNotificationFactory;
        this.f6328F = notificationPolicyEngine;
        this.f6329G = notificationDelayTestManager;
        this.f6351w.a().a(MessagesBroadcastIntents.B, new C09531(this)).a().b();
    }

    public final void m6007a(JsonNode jsonNode, PushProperty pushProperty) {
        String b = JSONUtil.b(jsonNode.b("type"));
        if (("msg".equals(b) || "orca_message".equals(b) || "orca_friend_msg".equals(b) || "orca_thread_read".equals(b) || "voip".equals(b) || "voip_presence".equals(b) || "messenger_status_change".equals(b) || "wakeup_mqtt".equals(b) || "p2p_payment".equals(b) || "messenger_reminder".equals(b) || "messenger_stale_push".equals(b) || "message_request".equals(b) || "internal".equals(b) || "pre_reg_push".equals(b)) && this.f6340l != Product.PAA) {
            boolean b2 = this.f6331c.b();
            boolean g = JSONUtil.g(jsonNode.b("is_logged_out_push"));
            String b3 = JSONUtil.b(jsonNode.b("message"));
            JsonNode b4 = jsonNode.b("params");
            if (Product.MESSENGER == this.f6340l && "pre_reg_push".equals(b) && !b2) {
                PushSource pushSource = pushProperty.a;
                SimpleMessageNotification simpleMessageNotification = new SimpleMessageNotification(b3, pushProperty, Type.PRE_REG_PUSH);
                MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6333e.f6308b.get();
                Intent intent = new Intent(MessagesNotificationIntents.x);
                intent.putExtra("notification", simpleMessageNotification);
                ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
                return;
            }
            CharSequence a = this.f6337i.a();
            if (StringUtil.a(a)) {
                m6006d("no_user", pushProperty);
            } else if (!Objects.equal(JSONUtil.b(jsonNode.b("target_uid")), a)) {
                m6006d("eaten_wrong_user", pushProperty);
            } else if (!b2 && !g) {
                m6006d("logged_out_user", pushProperty);
            } else if (b2 && g) {
                m6006d("logged_in_user", pushProperty);
            } else {
                if ("msg".equals(b) || "orca_message".equals(b)) {
                    if (g) {
                        m6005c(b3, pushProperty);
                    } else if (this.f6329G.m3283a(b3, b4, pushProperty)) {
                        m5996a(this, b3, b4, pushProperty);
                    }
                } else if ("orca_friend_msg".equals(b)) {
                    FriendInstallNotification a2 = FriendInstallNotification.a(b3, this.f6332d.getString(2131230720), b4, pushProperty);
                    if (a2 != null) {
                        this.f6333e.m5983a(a2);
                    } else {
                        m6006d("invalid_payload", pushProperty);
                    }
                } else if ("voip".equals(b)) {
                    this.f6325C.b(b4);
                } else if ("voip_presence".equals(b)) {
                    Long.valueOf(JSONUtil.c(b4.b("uid")));
                    this.f6325C.a(b4);
                } else if ("orca_thread_read".equals(b)) {
                    m5998a(b4);
                } else if ("messenger_status_change".equals(b)) {
                    m6003b(b4);
                } else if ("wakeup_mqtt".equals(b)) {
                    m5997a(pushProperty);
                } else if ("p2p_payment".equals(b)) {
                    PaymentNotification a3 = PaymentNotification.a(b3, this.f6332d.getString(2131230720), b4, pushProperty);
                    if (a3 != null) {
                        this.f6333e.m5987a(a3);
                    } else {
                        m6006d("invalid_payload", pushProperty);
                    }
                } else if ("messenger_reminder".equals(b)) {
                    this.f6333e.m5988a(new PromotionNotification(this.f6332d.getString(2131230720), b3, b3, b4.d("path") ? JSONUtil.b(b4.b("path")) : this.f6352x.a().toString()));
                } else if ("messenger_stale_push".equals(b)) {
                    this.f6333e.m5990a(new StaleNotification(this.f6332d.getString(2131230720), b3, b3));
                } else if ("message_request".equals(b)) {
                    this.f6333e.m5984a(new MessageRequestNotification(this.f6332d.getString(2131230720), b3));
                } else if (Product.MESSENGER == this.f6340l && "internal".equals(b)) {
                    m5999a(b3, pushProperty);
                }
                m6004c(jsonNode);
            }
        }
    }

    private void m5999a(String str, PushProperty pushProperty) {
        PushSource pushSource = pushProperty.a;
        SimpleMessageNotification simpleMessageNotification = new SimpleMessageNotification(str, pushProperty, Type.INTERNAL);
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6333e.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.w);
        intent.putExtra("notification", simpleMessageNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    private void m6005c(String str, PushProperty pushProperty) {
        if (StringUtil.a(str)) {
            m6006d("invalid_payload", pushProperty);
            return;
        }
        if (this.f6340l == Product.MESSENGER) {
            boolean z;
            String a = this.f6337i.a();
            FirstPartySsoSessionInfo a2 = ((SsoLoginUtil) this.f6339k.get()).a(this.f6353y);
            if (a2 == null || a2.a == null) {
                z = false;
            } else {
                z = a2.a.equals(a);
            }
            if (z) {
                m6006d("eaten_fb4a", pushProperty);
                return;
            }
        } else if (this.f6338j.a(this.f6337i.a()).b) {
            m6006d("eaten_messenger", pushProperty);
            return;
        }
        LoggedOutMessageNotification loggedOutMessageNotification = new LoggedOutMessageNotification(this.f6332d.getString(2131230720), str, pushProperty);
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6333e.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.j);
        intent.putExtra("notification", loggedOutMessageNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public static synchronized void m5996a(OrcaFbPushDataHandler orcaFbPushDataHandler, String str, JsonNode jsonNode, PushProperty pushProperty) {
        boolean z = false;
        synchronized (orcaFbPushDataHandler) {
            Message a = orcaFbPushDataHandler.f6334f.m6013a(str, jsonNode);
            ServerMessageAlertFlags b = PushDeserialization.m6011b(jsonNode);
            if (orcaFbPushDataHandler.f6328F.m3316a()) {
                if (b.d || !(b.a || b.b)) {
                    z = true;
                }
                orcaFbPushDataHandler.f6328F.m3315a(a.a, z);
            } else {
                String a2 = MessagingIdUtil.a(JSONUtil.b(jsonNode.b("unified_tid")));
                GroupMessageInfo a3 = orcaFbPushDataHandler.f6334f.m6014a(jsonNode);
                if (a == null) {
                    orcaFbPushDataHandler.m6006d("invalid_payload", pushProperty);
                } else {
                    ThreadKey threadKey = a.b;
                    String a4;
                    if (threadKey == null) {
                        ThreadSummary a5 = ((DataCache) orcaFbPushDataHandler.f6348t.get()).a(a2);
                        if (a5 == null) {
                            a5 = orcaFbPushDataHandler.f6349u.a(ThreadCriteria.a(a2), 0).c;
                        }
                        if (a5 != null) {
                            threadKey = a5.a;
                            MessageBuilder a6 = Message.newBuilder().a(a).a(a5.a);
                            orcaFbPushDataHandler.f6323A.get();
                            if (MessageUtil.R(a)) {
                                a4 = orcaFbPushDataHandler.m5994a(a5);
                                if (a4 != null) {
                                    a6.b(a4);
                                }
                            }
                            a = a6.R();
                        } else {
                            orcaFbPushDataHandler.f6350v.a("OrcaC2DMPush", "Received C2DM push for unrecognized threadId.");
                        }
                    } else if (((Boolean) orcaFbPushDataHandler.f6324B.get()).booleanValue()) {
                        orcaFbPushDataHandler.f6323A.get();
                        if (MessageUtil.R(a)) {
                            a4 = orcaFbPushDataHandler.m5994a(((DataCache) orcaFbPushDataHandler.f6348t.get()).a(threadKey));
                            if (a4 != null) {
                                a = Message.newBuilder().a(a).b(a4).R();
                            }
                        }
                    }
                    if (!orcaFbPushDataHandler.m6001a(a.a)) {
                        orcaFbPushDataHandler.f6351w.a(MessagesSyncInitializationHandler.a);
                    }
                    if (orcaFbPushDataHandler.f6340l == Product.MESSENGER || !orcaFbPushDataHandler.f6338j.a(orcaFbPushDataHandler.f6337i.a()).a) {
                        long j = pushProperty.c - a.c;
                        if (PushSource.isPushNotification(pushProperty.a) && j > 1800000 && ((TriState) orcaFbPushDataHandler.f6346r.get()).asBoolean(false) && ((Long) orcaFbPushDataHandler.f6347s.e().or(Long.valueOf(0))).longValue() < 300000) {
                            z = orcaFbPushDataHandler.m6000a(a.b);
                            a2 = pushProperty.b;
                            ThreadKey threadKey2 = a.b;
                            Boolean.valueOf(z);
                            if (!z) {
                                orcaFbPushDataHandler.m6006d("dropped_by_readness", pushProperty);
                            }
                        }
                        int parseInt = Integer.parseInt(JSONUtil.a(jsonNode.b("mu"), "-1"));
                        MessengerUserStatus messengerUserStatus = parseInt == 1 ? MessengerUserStatus.IS_MESSENGER_USER : parseInt == 0 ? MessengerUserStatus.IS_NOT_MESSENGER_USER : MessengerUserStatus.UNKNOWN;
                        PushSource pushSource = pushProperty.a;
                        orcaFbPushDataHandler.f6335g.a(a);
                        orcaFbPushDataHandler.f6333e.m5986a(orcaFbPushDataHandler.f6327E.a(str, a, threadKey, a3, null, pushProperty, null, b, messengerUserStatus), -1);
                    } else {
                        orcaFbPushDataHandler.m6006d("eaten_messenger", pushProperty);
                    }
                }
            }
        }
    }

    @Nullable
    private String m5994a(@Nullable ThreadSummary threadSummary) {
        if (threadSummary != null && ((Boolean) this.f6324B.get()).booleanValue()) {
            String str = threadSummary.D.f;
            if (!StringUtil.a(str)) {
                return str;
            }
        }
        return null;
    }

    private boolean m6001a(String str) {
        Message b = this.f6349u.b(str);
        return (b == null || b.o) ? false : true;
    }

    private boolean m6000a(ThreadKey threadKey) {
        final int nextInt = this.f6326D.nextInt();
        this.f6354z.b(nextInt, "OrcaFbPushDataHandler");
        Bundle bundle = new Bundle();
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.a = ThreadCriteria.a(threadKey);
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.f = 0;
        bundle.putParcelable("fetchThreadParams", fetchThreadParamsBuilder.i());
        bundle.putInt("logger_instance_key", nextInt);
        OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f6345q, "fetch_thread", bundle, CallerContext.a(OrcaFbPushDataHandler.class), -1750234964).c();
        OperationResult operationResult = (OperationResult) FutureUtils.a(c);
        Futures.a(c, new OperationResultFutureCallback(this) {
            final /* synthetic */ OrcaFbPushDataHandler f6320b;

            protected final void m5991a(ServiceException serviceException) {
                this.f6320b.f6354z.n(nextInt);
            }

            protected final void m5992a(Object obj) {
                this.f6320b.f6354z.o(nextInt);
            }
        });
        if (operationResult == null) {
            return true;
        }
        return ((FetchThreadResult) operationResult.k()).c.f();
    }

    private void m5998a(JsonNode jsonNode) {
        String a = JSONUtil.a(jsonNode.b("thread_timestamps"), null);
        if (a != null) {
            try {
                JsonNode a2 = this.f6341m.a(a);
                Builder builder = ImmutableMap.builder();
                Iterator H = a2.H();
                while (H.hasNext()) {
                    Entry entry = (Entry) H.next();
                    ThreadSummary a3 = ((DataCache) this.f6348t.get()).a(MessagingIdUtil.a((String) entry.getKey()));
                    if (a3 != null) {
                        ThreadKey threadKey = a3.a;
                        long a4 = JSONUtil.a((JsonNode) entry.getValue(), -1);
                        if (a4 > 0) {
                            builder.b(threadKey, Long.valueOf(a4));
                            m5995a(threadKey, a4);
                        }
                    }
                }
                this.f6333e.m5989a(new ReadThreadNotification(builder.b()));
            } catch (IOException e) {
                BLog.a(f6322a, "Failed to parse thread_counts");
            }
        }
    }

    private void m6003b(JsonNode jsonNode) {
        String b = JSONUtil.b(jsonNode.b("uid"));
        if (jsonNode.d("is_messenger_user")) {
            boolean g = JSONUtil.g(jsonNode.b("is_messenger_user"));
            Boolean.valueOf(g);
            this.f6344p.a(b, g);
        }
    }

    private void m6006d(String str, PushProperty pushProperty) {
        this.f6336h.a("", null, pushProperty.a.toString(), pushProperty.b, str);
    }

    private void m6004c(JsonNode jsonNode) {
        if (jsonNode.d("params") && jsonNode.b("params").d("trace_info")) {
            Object b = JSONUtil.b(jsonNode.b("params").b("trace_info"));
            if (!StringUtil.a(b)) {
                Bundle bundle = new Bundle();
                bundle.putString("traceInfo", b);
                BlueServiceOperation blueServiceOperation = (BlueServiceOperation) this.f6342n.get();
                blueServiceOperation.o = true;
                blueServiceOperation.a("push_trace_confirmation", bundle, null);
            }
        }
    }

    private void m5995a(ThreadKey threadKey, long j) {
        this.f6343o.a(threadKey, ActionIdHelper.a(j), j);
    }

    private void m5997a(PushProperty pushProperty) {
        m6006d("mqtt_wakeup_via_gcm", pushProperty);
    }
}
