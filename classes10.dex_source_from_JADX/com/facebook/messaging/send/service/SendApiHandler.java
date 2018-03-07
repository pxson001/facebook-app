package com.facebook.messaging.send.service;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.perf.LatencyLogger;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.analytics.reliability.NetworkChannel;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageAttachmentInfo;
import com.facebook.messaging.model.messages.MessageAttachmentInfoFactory;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.send.service.SendMessageExceptionHelper.FailedMessageBuilder;
import com.facebook.messaging.send.service.SendViaMqttResult.Result;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.quickpromotion.filter.QuickPromotionThreadActivityEvent;
import com.facebook.quickpromotion.filter.QuickPromotionUserEvent;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: recovery_message */
public class SendApiHandler {
    private static final Class<?> f3868a = SendApiHandler.class;
    private static final Object f3869r = new Object();
    private final SendViaMqttHandler f3870b;
    private final Lazy<SendViaGraphHandler> f3871c;
    private final MessagesReliabilityLogger f3872d;
    private final LatencyLogger f3873e;
    private final AggregatedReliabilityLogger f3874f;
    private final Lazy<MediaUploadManager> f3875g;
    private final UiCounters f3876h;
    private final Lazy<SendMessageExceptionHelper> f3877i;
    private final MqttPushServiceClientManagerImpl f3878j;
    private final MessageAttachmentInfoFactory f3879k;
    private final FbNetworkManager f3880l;
    private final MonotonicClock f3881m;
    private final QuickPromotionThreadActivityEvent f3882n;
    private final Provider<Boolean> f3883o;
    private final Provider<Boolean> f3884p;
    private final Provider<Boolean> f3885q;

    private static SendApiHandler m3638b(InjectorLike injectorLike) {
        return new SendApiHandler(SendViaMqttHandler.m3693a(injectorLike), IdBasedLazy.a(injectorLike, 8355), MessagesReliabilityLogger.a(injectorLike), LatencyLogger.a(injectorLike), AggregatedReliabilityLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 2644), UiCounters.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8353), MqttPushServiceClientManagerImpl.a(injectorLike), MessageAttachmentInfoFactory.a(injectorLike), FbNetworkManager.a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), QuickPromotionThreadActivityEvent.a(injectorLike), IdBasedProvider.a(injectorLike, 4057), IdBasedProvider.a(injectorLike, 4222), IdBasedProvider.a(injectorLike, 4223));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.service.SendApiHandler m3633a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3869r;	 Catch:{ all -> 0x006c }
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
        r1 = m3638b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3869r;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendApiHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.service.SendApiHandler) r0;	 Catch:{  }
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
        r0 = f3869r;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendApiHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.service.SendApiHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.service.SendApiHandler");
    }

    @Inject
    public SendApiHandler(SendViaMqttHandler sendViaMqttHandler, Lazy<SendViaGraphHandler> lazy, MessagesReliabilityLogger messagesReliabilityLogger, LatencyLogger latencyLogger, AggregatedReliabilityLogger aggregatedReliabilityLogger, Lazy<MediaUploadManager> lazy2, UiCounters uiCounters, Lazy<SendMessageExceptionHelper> lazy3, MqttPushServiceClientManager mqttPushServiceClientManager, MessageAttachmentInfoFactory messageAttachmentInfoFactory, FbNetworkManager fbNetworkManager, MonotonicClock monotonicClock, QuickPromotionThreadActivityEvent quickPromotionThreadActivityEvent, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f3870b = sendViaMqttHandler;
        this.f3871c = lazy;
        this.f3872d = messagesReliabilityLogger;
        this.f3873e = latencyLogger;
        this.f3874f = aggregatedReliabilityLogger;
        this.f3875g = lazy2;
        this.f3876h = uiCounters;
        this.f3877i = lazy3;
        this.f3878j = mqttPushServiceClientManager;
        this.f3879k = messageAttachmentInfoFactory;
        this.f3880l = fbNetworkManager;
        this.f3881m = monotonicClock;
        this.f3882n = quickPromotionThreadActivityEvent;
        this.f3883o = provider;
        this.f3884p = provider2;
        this.f3885q = provider3;
    }

    public final NewMessageResult m3641a(SendMessageParams sendMessageParams) {
        String str;
        Message message = sendMessageParams.a;
        MessageAttachmentInfo b = this.f3879k.b(sendMessageParams.a);
        SendViaMqttResult a = m3634a(sendMessageParams, b);
        if (a != null) {
            Result result = a.f3964a;
            if (result == Result.SUCCEEDED) {
                Preconditions.checkState(a.f3964a == Result.SUCCEEDED);
                return a.f3968e;
            } else if (result == Result.FAILED && a.m3707f()) {
                FailedMessageBuilder a2 = ((SendMessageExceptionHelper) this.f3877i.get()).m3654a().m3645a(message);
                Preconditions.checkState(a.f3964a.isFailure());
                a2.f3890e = a.f3970g;
                a2 = a2;
                a2.f3893h = a.m3706e();
                throw new SendMessageException(a.m3705d(), a2.m3646a(SendErrorType.PERMANENT_FAILURE).m3644a(SendChannel.MQTT).m3643a());
            }
        }
        if (a == null || !a.f3964a.isFailure()) {
            str = "via_graph";
        } else {
            str = "via_graph_after_mqtt_failure";
        }
        return m3635a(sendMessageParams, b, str);
    }

    public final FetchThreadResult m3640a(SendMessageByRecipientsParams sendMessageByRecipientsParams) {
        return m3639b(sendMessageByRecipientsParams);
    }

    public final NewMessageResult m3642a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams) {
        return m3636a(sendMessageToPendingThreadParams, this.f3879k.b(sendMessageToPendingThreadParams.a), "via_graph");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.messaging.send.service.SendViaMqttResult m3634a(com.facebook.messaging.service.model.SendMessageParams r33, com.facebook.messaging.model.messages.MessageAttachmentInfo r34) {
        /*
        r32 = this;
        r0 = r32;
        r2 = r0.f3884p;
        r2 = r2.get();
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0027;
    L_0x0010:
        r0 = r32;
        r2 = r0.f3885q;
        r2 = r2.get();
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 != 0) goto L_0x0027;
    L_0x0020:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_DYNAMIC_PRICING_ENABLED;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
    L_0x0026:
        return r27;
    L_0x0027:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.z;
        if (r2 == 0) goto L_0x0046;
    L_0x002f:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.z;
        r2 = r2.keySet();
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x0046;
    L_0x003f:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_BROADCAST;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x0046:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.u;
        if (r2 == 0) goto L_0x006b;
    L_0x004e:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.u;
        r2 = r2.b;
        if (r2 == 0) goto L_0x006b;
    L_0x0058:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.u;
        r2 = r2.b;
        r2 = r2.b;
        if (r2 == 0) goto L_0x006b;
    L_0x0064:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_FB_SHARE;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x006b:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.E;
        if (r2 != 0) goto L_0x007b;
    L_0x0073:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.F;
        if (r2 == 0) goto L_0x0082;
    L_0x007b:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_HAS_APP_ATTRIBUTION;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x0082:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.u;
        if (r2 == 0) goto L_0x009d;
    L_0x008a:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.u;
        r2 = r2.a;
        r3 = com.facebook.messaging.model.share.SentShareAttachment.Type.PAYMENT;
        if (r2 != r3) goto L_0x009d;
    L_0x0096:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_PAYMENT_MESSAGE;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x009d:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.G;
        r2 = com.facebook.messaging.location.sending.LocationMessageUtil.a(r2);
        if (r2 == 0) goto L_0x00c1;
    L_0x00a9:
        r0 = r32;
        r2 = r0.f3883o;
        r2 = r2.get();
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 != 0) goto L_0x00c1;
    L_0x00b9:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_HAS_LOCATION_SHARE;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x00c1:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.G;
        r2 = com.facebook.messaging.event.sending.EventMessageUtil.a(r2);
        if (r2 == 0) goto L_0x00d5;
    L_0x00cd:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_HAS_EVENT_MESSAGE;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x00d5:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.O;
        if (r2 == 0) goto L_0x00e5;
    L_0x00dd:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_HAS_FLOWER_BORDER;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x00e5:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.Q;
        if (r2 == 0) goto L_0x0101;
    L_0x00ed:
        r0 = r33;
        r2 = r0.a;
        r2 = r2.Q;
        r2 = r2.isEmpty();
        if (r2 != 0) goto L_0x0101;
    L_0x00f9:
        r2 = com.facebook.messaging.send.service.SendViaMqttResult.Details.SEND_SKIPPED_HAS_PLATFORM_METADATA;
        r27 = com.facebook.messaging.send.service.SendViaMqttResult.m3698a(r2);
        goto L_0x0026;
    L_0x0101:
        r0 = r32;
        r2 = r0.f3872d;
        r0 = r32;
        r3 = r0.f3880l;
        r3 = r3.d();
        r4 = com.facebook.messaging.analytics.reliability.NetworkChannel.MQTT;
        r0 = r33;
        r1 = r34;
        r2.a(r0, r1, r3, r4);
        r0 = r32;
        r2 = r0.f3873e;
        r0 = r33;
        r3 = r0.a;
        r3 = r3.b;
        r0 = r33;
        r4 = r0.a;
        r4 = r4.n;
        r2.a(r3, r4);
        r29 = new com.facebook.messaging.abtest.SendMessageParametersExperiment$Config;
        r29.<init>();
        r2 = 0;
        r8 = 1;
        r9 = r2;
    L_0x0131:
        r0 = r29;
        r2 = r0.c;
        if (r8 > r2) goto L_0x02fe;
    L_0x0137:
        r0 = r32;
        r2 = r0.f3874f;
        r3 = com.facebook.messaging.analytics.reliability.NetworkChannel.MQTT;
        r0 = r33;
        r4 = r0.a;
        r2.a(r3, r4);
        r3 = 0;
        r0 = r32;
        r2 = r0.f3881m;
        r30 = r2.now();
        r10 = 0;
        r0 = r32;
        r2 = r0.f3880l;
        r12 = r2.d();
        r0 = r32;
        r2 = r0.f3878j;	 Catch:{ Exception -> 0x0304, all -> 0x0302 }
        r28 = r2.a();	 Catch:{ Exception -> 0x0304, all -> 0x0302 }
        r10 = r28.c();	 Catch:{ Exception -> 0x0308, all -> 0x02f5 }
        r0 = r29;
        r2 = r0.e;	 Catch:{ Exception -> 0x030e, all -> 0x02f5 }
        if (r8 > r2) goto L_0x0171;
    L_0x0168:
        r0 = r29;
        r2 = r0.d;	 Catch:{ Exception -> 0x030e, all -> 0x02f5 }
        r0 = r28;
        r0.a(r2);	 Catch:{ Exception -> 0x030e, all -> 0x02f5 }
    L_0x0171:
        r2 = "SendViaMqttHandler.attemptSend";
        r3 = 147482769; // 0x8ca6891 float:1.2182016E-33 double:7.28661695E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r3);	 Catch:{ Exception -> 0x030e, all -> 0x02f5 }
        r0 = r32;
        r2 = r0.f3870b;	 Catch:{ all -> 0x0314 }
        r3 = r33;
        r4 = r29;
        r5 = r8;
        r6 = r30;
        r27 = r2.m3696a(r3, r4, r5, r6);	 Catch:{ all -> 0x0314 }
        r2 = com.facebook.messaging.send.service.SendApiHandler.C05941.f3867a;	 Catch:{ all -> 0x029b }
        r3 = r27.m3703a();	 Catch:{ all -> 0x029b }
        r3 = r3.ordinal();	 Catch:{ all -> 0x029b }
        r2 = r2[r3];	 Catch:{ all -> 0x029b }
        switch(r2) {
            case 1: goto L_0x01a8;
            case 2: goto L_0x021d;
            case 3: goto L_0x0259;
            default: goto L_0x0197;
        };
    L_0x0197:
        r2 = -769250742; // 0xffffffffd2262a4a float:-1.78418516E11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);	 Catch:{ Exception -> 0x02a3, all -> 0x02f5 }
        if (r28 == 0) goto L_0x0318;
    L_0x019f:
        r28.f();
        r2 = r27;
    L_0x01a4:
        r8 = r8 + 1;
        r9 = r2;
        goto L_0x0131;
    L_0x01a8:
        r0 = r32;
        r2 = r0.f3872d;	 Catch:{  }
        r0 = r32;
        r3 = r0.f3881m;	 Catch:{  }
        r4 = r3.now();	 Catch:{  }
        r4 = r4 - r30;
        r7 = "via_mqtt";
        r9 = r27.m3708g();	 Catch:{  }
        r11 = r28.c();	 Catch:{  }
        r13 = com.facebook.messaging.analytics.reliability.NetworkChannel.MQTT;	 Catch:{  }
        r14 = 0;
        r3 = r33;
        r6 = r34;
        r2.a(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{  }
        r0 = r32;
        r2 = r0.f3874f;	 Catch:{  }
        r3 = com.facebook.messaging.analytics.reliability.NetworkChannel.MQTT;	 Catch:{  }
        r0 = r33;
        r4 = r0.a;	 Catch:{  }
        r4 = r4.n;	 Catch:{  }
        r5 = 0;
        r2.a(r3, r4, r5);	 Catch:{  }
        r0 = r32;
        r2 = r0.f3876h;	 Catch:{  }
        r3 = com.facebook.quickpromotion.filter.QuickPromotionUserEvent.MESSAGE_SENT;	 Catch:{  }
        r3 = r3.toEventName();	 Catch:{  }
        r2.c(r3);	 Catch:{  }
        r0 = r33;
        r2 = r0.a;	 Catch:{  }
        if (r2 == 0) goto L_0x0210;
    L_0x01ed:
        r0 = r33;
        r2 = r0.a;	 Catch:{  }
        r2 = r2.b;	 Catch:{  }
        if (r2 == 0) goto L_0x0210;
    L_0x01f5:
        r0 = r33;
        r2 = r0.a;	 Catch:{  }
        r2 = r2.b;	 Catch:{  }
        r2 = r2.a;	 Catch:{  }
        r3 = com.facebook.messaging.model.threadkey.ThreadKey.Type.ONE_TO_ONE;	 Catch:{  }
        if (r2 != r3) goto L_0x0210;
    L_0x0201:
        r0 = r33;
        r2 = r0.a;	 Catch:{  }
        r2 = r2.b;	 Catch:{  }
        r2 = r2.d;	 Catch:{  }
        r0 = r32;
        r4 = r0.f3882n;	 Catch:{  }
        r4.a(r2);	 Catch:{  }
    L_0x0210:
        r2 = -293511332; // 0xffffffffee815f5c float:-2.0019424E28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);	 Catch:{  }
        if (r28 == 0) goto L_0x0026;
    L_0x0218:
        r28.f();
        goto L_0x0026;
    L_0x021d:
        r0 = r32;
        r13 = r0.f3872d;	 Catch:{  }
        r16 = r27.m3704c();	 Catch:{  }
        r14 = r33;
        r15 = r34;
        r17 = r8;
        r18 = r10;
        r19 = r12;
        r13.a(r14, r15, r16, r17, r18, r19);	 Catch:{  }
        r2 = f3868a;	 Catch:{  }
        r3 = "Attempted to send an ineligible message over MQTT. message id: %s, reason: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{  }
        r5 = 0;
        r0 = r33;
        r6 = r0.a;	 Catch:{  }
        r6 = r6.n;	 Catch:{  }
        r4[r5] = r6;	 Catch:{  }
        r5 = 1;
        r6 = r27.m3704c();	 Catch:{  }
        r4[r5] = r6;	 Catch:{  }
        com.facebook.debug.log.BLog.a(r2, r3, r4);	 Catch:{  }
        r2 = 1810567202; // 0x6beb1022 float:5.683475E26 double:8.94539054E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);	 Catch:{  }
        if (r28 == 0) goto L_0x0026;
    L_0x0254:
        r28.f();
        goto L_0x0026;
    L_0x0259:
        r0 = r32;
        r14 = r0.f3872d;	 Catch:{  }
        r0 = r32;
        r2 = r0.f3881m;	 Catch:{  }
        r2 = r2.now();	 Catch:{  }
        r16 = r2 - r30;
        r19 = r27.m3705d();	 Catch:{  }
        r20 = r27.m3706e();	 Catch:{  }
        r21 = r27.m3707f();	 Catch:{  }
        r23 = r28.c();	 Catch:{  }
        r26 = r27.m3708g();	 Catch:{  }
        r15 = r33;
        r18 = r34;
        r22 = r10;
        r24 = r12;
        r25 = r8;
        r14.a(r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26);	 Catch:{  }
        r2 = r27.m3707f();	 Catch:{  }
        if (r2 == 0) goto L_0x0197;
    L_0x028e:
        r2 = 1488629023; // 0x58baad1f float:1.6420217E15 double:7.354804597E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2);	 Catch:{  }
        if (r28 == 0) goto L_0x0026;
    L_0x0296:
        r28.f();
        goto L_0x0026;
    L_0x029b:
        r2 = move-exception;
    L_0x029c:
        r3 = -1403884748; // 0xffffffffac526b34 float:-2.9902305E-12 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r3);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x02a3:
        r2 = move-exception;
        r22 = r10;
        r3 = r28;
        r9 = r27;
    L_0x02aa:
        r4 = f3868a;	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r5 = "Calling mqtt service failed";
        com.facebook.debug.log.BLog.a(r4, r5, r2);	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r4 = com.facebook.messaging.send.service.SendViaMqttResult.Details.MQTT_EXCEPTION;	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r4 = r4.errorCode;	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r9 = com.facebook.messaging.send.service.SendViaMqttResult.m3702a(r2, r4);	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r23 = 0;
        if (r3 == 0) goto L_0x02c1;
    L_0x02bd:
        r23 = r3.c();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
    L_0x02c1:
        r0 = r32;
        r14 = r0.f3872d;	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r0 = r32;
        r2 = r0.f3881m;	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r4 = r2.now();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r16 = r4 - r30;
        r19 = r9.m3705d();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r20 = r9.m3706e();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r21 = r9.m3707f();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r26 = r9.m3708g();	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r15 = r33;
        r18 = r34;
        r24 = r12;
        r25 = r8;
        r14.a(r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26);	 Catch:{ Exception -> 0x02f2, all -> 0x0302 }
        r2 = r9;
    L_0x02eb:
        if (r3 == 0) goto L_0x01a4;
    L_0x02ed:
        r3.f();
        goto L_0x01a4;
    L_0x02f2:
        r2 = move-exception;
        r2 = r9;
        goto L_0x02eb;
    L_0x02f5:
        r2 = move-exception;
        r3 = r28;
    L_0x02f8:
        if (r3 == 0) goto L_0x02fd;
    L_0x02fa:
        r3.f();
    L_0x02fd:
        throw r2;
    L_0x02fe:
        r27 = r9;
        goto L_0x0026;
    L_0x0302:
        r2 = move-exception;
        goto L_0x02f8;
    L_0x0304:
        r2 = move-exception;
        r22 = r10;
        goto L_0x02aa;
    L_0x0308:
        r2 = move-exception;
        r22 = r10;
        r3 = r28;
        goto L_0x02aa;
    L_0x030e:
        r2 = move-exception;
        r22 = r10;
        r3 = r28;
        goto L_0x02aa;
    L_0x0314:
        r2 = move-exception;
        r27 = r9;
        goto L_0x029c;
    L_0x0318:
        r2 = r27;
        goto L_0x01a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.service.SendApiHandler.a(com.facebook.messaging.service.model.SendMessageParams, com.facebook.messaging.model.messages.MessageAttachmentInfo):com.facebook.messaging.send.service.SendViaMqttResult");
    }

    private NewMessageResult m3635a(SendMessageParams sendMessageParams, MessageAttachmentInfo messageAttachmentInfo, String str) {
        boolean d = this.f3880l.d();
        this.f3872d.a(sendMessageParams, messageAttachmentInfo, d, NetworkChannel.GRAPH);
        Message message = sendMessageParams.a;
        this.f3873e.a(message.b, message.n);
        this.f3874f.a(NetworkChannel.GRAPH, message);
        long now = this.f3881m.now();
        MessageMediaUploadState b = ((MediaUploadManagerImpl) this.f3875g.get()).b(message);
        Preconditions.checkState(b.b != UploadState.IN_PROGRESS, "Attempted to send message with in progress media items");
        try {
            m3637a(message, b);
            NewMessageResult a = ((SendViaGraphHandler) this.f3871c.get()).m3691a(sendMessageParams);
            this.f3872d.a(sendMessageParams, this.f3881m.now() - now, messageAttachmentInfo, str, 0, false, null, null, d, NetworkChannel.GRAPH, false);
            this.f3874f.a(NetworkChannel.GRAPH, a.c().n, false);
            this.f3876h.c(QuickPromotionUserEvent.MESSAGE_SENT.toEventName());
            return a;
        } catch (Throwable th) {
            this.f3872d.a(sendMessageParams, this.f3881m.now() - now, messageAttachmentInfo, ((SendMessageExceptionHelper) this.f3877i.get()).m3653a(th, message, SendChannel.GRAPH), d, str);
        }
    }

    private FetchThreadResult m3639b(SendMessageByRecipientsParams sendMessageByRecipientsParams) {
        Throwable th;
        SendMessageException a;
        Message a2 = sendMessageByRecipientsParams.a();
        long j = Long.MAX_VALUE;
        MessageAttachmentInfo b = this.f3879k.b(a2);
        try {
            this.f3872d.a(a2, b, NetworkChannel.GRAPH);
            long now = this.f3881m.now();
            try {
                FetchThreadResult a3 = ((SendViaGraphHandler) this.f3871c.get()).m3690a(sendMessageByRecipientsParams);
                this.f3872d.a(a3.c.a, a2, this.f3881m.now() - now, b, NetworkChannel.GRAPH);
                return a3;
            } catch (Throwable th2) {
                th = th2;
                j = now;
                a = ((SendMessageExceptionHelper) this.f3877i.get()).m3653a(th, a2, SendChannel.UNKNOWN);
                this.f3872d.a(a2, this.f3881m.now() - j, b, a, NetworkChannel.GRAPH);
                throw a;
            }
        } catch (Throwable th22) {
            th = th22;
            a = ((SendMessageExceptionHelper) this.f3877i.get()).m3653a(th, a2, SendChannel.UNKNOWN);
            this.f3872d.a(a2, this.f3881m.now() - j, b, a, NetworkChannel.GRAPH);
            throw a;
        }
    }

    private NewMessageResult m3636a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams, MessageAttachmentInfo messageAttachmentInfo, String str) {
        Message a = sendMessageToPendingThreadParams.a();
        boolean d = this.f3880l.d();
        this.f3872d.a(sendMessageToPendingThreadParams, messageAttachmentInfo, d, NetworkChannel.GRAPH);
        this.f3874f.a(NetworkChannel.GRAPH, a);
        long now = this.f3881m.now();
        MessageMediaUploadState b = ((MediaUploadManagerImpl) this.f3875g.get()).b(a);
        Preconditions.checkState(b.b != UploadState.IN_PROGRESS, "Attempted to send message with in progress media items");
        try {
            m3637a(a, b);
            NewMessageResult a2 = ((SendViaGraphHandler) this.f3871c.get()).m3692a(sendMessageToPendingThreadParams);
            this.f3872d.a(sendMessageToPendingThreadParams, this.f3881m.now() - now, messageAttachmentInfo, str, 0, d, NetworkChannel.GRAPH);
            this.f3874f.a(NetworkChannel.GRAPH, a2.c().n, false);
            this.f3876h.c(QuickPromotionUserEvent.MESSAGE_SENT.toEventName());
            return a2;
        } catch (Throwable th) {
            SendMessageException a3 = ((SendMessageExceptionHelper) this.f3877i.get()).m3653a(th, a, SendChannel.GRAPH);
        }
    }

    private void m3637a(Message message, MessageMediaUploadState messageMediaUploadState) {
        if (messageMediaUploadState.b == UploadState.FAILED) {
            throw new SendMessageException("Media upload failed", messageMediaUploadState.a.f, ((SendMessageExceptionHelper) this.f3877i.get()).m3654a().m3645a(message).m3646a(SendErrorType.MEDIA_UPLOAD_FAILED).m3644a(SendChannel.GRAPH).m3643a());
        }
    }
}
