package com.facebook.messaging.deliveryreceipt;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceipt;
import com.facebook.messaging.deliveryreceipt.model.thrift.DeliveryReceiptBatch;
import com.facebook.messaging.deliveryreceipt.model.thrift.MqttThriftHeader;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: matchTopSmsContactsParams */
public class DefaultSendDeliveryReceiptManager {
    private static final Class<?> f10841a = DefaultSendDeliveryReceiptManager.class;
    private final MqttPushServiceWrapper f10842b;
    public final ReliabilityAnalyticsLogger f10843c;
    private final DeliveryReceiptSentCache f10844d;
    public final MessageUtil f10845e;
    private final FbTracer f10846f;
    public final Product f10847g;
    private final UniqueIdGenerator f10848h;
    public final Provider<SendDeliveryReceiptRetryManager> f10849i;
    private final DeliveryReceiptUtil f10850j;
    private final BaseFbBroadcastManager f10851k;
    public final ExecutorService f10852l;
    private final AbstractFbErrorReporter f10853m;
    public final GatekeeperStoreImpl f10854n;
    private SelfRegistrableReceiverImpl f10855o;

    /* compiled from: matchTopSmsContactsParams */
    class C11942 implements ActionReceiver {
        final /* synthetic */ DefaultSendDeliveryReceiptManager f10838a;

        C11942(DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager) {
            this.f10838a = defaultSendDeliveryReceiptManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1376339595);
            switch (C11964.f10840a[PushStateEvent.fromValue(intent.getIntExtra("event", -1)).ordinal()]) {
                case 1:
                    DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager = this.f10838a;
                    ExecutorDetour.a(defaultSendDeliveryReceiptManager.f10852l, new C11953(defaultSendDeliveryReceiptManager), 113283728);
                    break;
            }
            LogUtils.e(1034138840, a);
        }
    }

    /* compiled from: matchTopSmsContactsParams */
    public class C11953 implements Runnable {
        final /* synthetic */ DefaultSendDeliveryReceiptManager f10839a;

        public C11953(DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager) {
            this.f10839a = defaultSendDeliveryReceiptManager;
        }

        public void run() {
            DefaultSendDeliveryReceiptManager.m11264a(this.f10839a, null, "MQTT_CONNECTED");
        }
    }

    /* compiled from: matchTopSmsContactsParams */
    /* synthetic */ class C11964 {
        static final /* synthetic */ int[] f10840a = new int[PushStateEvent.values().length];

        static {
            try {
                f10840a[PushStateEvent.CHANNEL_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static DefaultSendDeliveryReceiptManager m11269b(InjectorLike injectorLike) {
        return new DefaultSendDeliveryReceiptManager(MqttPushServiceWrapper.a(injectorLike), ReliabilityAnalyticsLogger.a(injectorLike), DeliveryReceiptSentCache.m11278a(injectorLike), MessageUtil.a(injectorLike), FbTracer.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), UniqueIdGenerator.a(injectorLike), IdBasedProvider.a(injectorLike, 7826), DeliveryReceiptUtil.m11283a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultSendDeliveryReceiptManager(MqttPushServiceWrapper mqttPushServiceWrapper, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, DeliveryReceiptSentCache deliveryReceiptSentCache, MessageUtil messageUtil, FbTracer fbTracer, Product product, UniqueIdGenerator uniqueIdGenerator, Provider<SendDeliveryReceiptRetryManager> provider, DeliveryReceiptUtil deliveryReceiptUtil, FbBroadcastManager fbBroadcastManager, ExecutorService executorService, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore) {
        this.f10842b = mqttPushServiceWrapper;
        this.f10843c = reliabilityAnalyticsLogger;
        this.f10844d = deliveryReceiptSentCache;
        this.f10845e = messageUtil;
        this.f10846f = fbTracer;
        this.f10847g = product;
        this.f10848h = uniqueIdGenerator;
        this.f10849i = provider;
        this.f10850j = deliveryReceiptUtil;
        this.f10851k = fbBroadcastManager;
        this.f10852l = executorService;
        this.f10853m = fbErrorReporter;
        this.f10854n = gatekeeperStore;
    }

    public final void m11276a(ImmutableList<Message> immutableList) {
        if (this.f10847g == Product.MESSENGER) {
            if (immutableList.size() != 1 || !this.f10854n.a(354, false)) {
                Map c = Maps.c();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    Message message = (Message) immutableList.get(i);
                    ThreadKey threadKey = message.b;
                    List list = (List) c.get(message.b);
                    if (list == null) {
                        list = Lists.a();
                        c.put(threadKey, list);
                    }
                    list.add(message);
                }
                m11265a(c);
            }
        }
    }

    public final void m11275a(Message message, @Nullable String str) {
        if (message.e != null && this.f10847g == Product.MESSENGER) {
            UserKey a = this.f10845e.a();
            if (a == null) {
                this.f10853m.a("NullLoggedInUserKey", "Got null logged-in user key in maybeSendDeliveredReceiptForMessage");
                return;
            }
            ThreadKey threadKey = message.b;
            long j = message.c;
            if (!this.f10844d.m11281b(threadKey, j)) {
                List list;
                if ("FETCH_THREAD".equals(str)) {
                    list = RegularImmutableList.a;
                } else {
                    list = ImmutableList.of(m11261a(message.a));
                }
                m11264a(this, new DeliveryReceiptBatch(ImmutableList.of(new DeliveryReceipt(Long.valueOf(Long.parseLong(message.e.b.b())), Long.valueOf(message.c), Long.valueOf(message.b.b), list, Long.valueOf(Long.parseLong(a.b())), Boolean.valueOf(message.b.a == Type.GROUP))), Long.valueOf(this.f10848h.a())), str);
            } else if (BLog.b(3)) {
                new StringBuilder("Delivery receipt has already been sent for ").append(threadKey).append(":").append(j).append(". Ignore the one from ").append(str);
            }
        }
    }

    public final void m11277a(ImmutableList<ThreadSummary> immutableList, String str) {
        if (this.f10847g == Product.MESSENGER) {
            Builder builder = ImmutableList.builder();
            UserKey a = this.f10845e.a();
            String b = a == null ? null : a.b();
            if (b == null) {
                this.f10853m.a("NullLoggedInUserKey", "Got null logged-in user key in maybeSendDeliveredReceiptsForThread");
                return;
            }
            long parseLong = Long.parseLong(b);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
                if (threadSummary.f()) {
                    long parseLong2;
                    if (threadSummary.a.a == Type.GROUP) {
                        if (threadSummary.r != null) {
                            parseLong2 = Long.parseLong(threadSummary.r.b.b());
                        }
                    } else if (threadSummary.r == null) {
                        parseLong2 = threadSummary.a.d;
                    } else {
                        parseLong2 = Long.parseLong(threadSummary.r.b.b());
                    }
                    if (!(parseLong == parseLong2 || this.f10844d.m11281b(threadSummary.a, threadSummary.k))) {
                        builder.c(new DeliveryReceipt(Long.valueOf(parseLong2), Long.valueOf(threadSummary.k), Long.valueOf(threadSummary.a.b), ImmutableList.of(), Long.valueOf(parseLong), Boolean.valueOf(threadSummary.a.a == Type.GROUP)));
                    }
                } else {
                    ThreadKey threadKey = threadSummary.a;
                }
            }
            ImmutableList b2 = builder.b();
            if (!b2.isEmpty()) {
                m11264a(this, new DeliveryReceiptBatch(b2, Long.valueOf(this.f10848h.a())), str);
            }
        }
    }

    public static void m11264a(@Nullable DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager, @Nullable DeliveryReceiptBatch deliveryReceiptBatch, String str) {
        BatchWithFailureInfo a = ((SendDeliveryReceiptRetryManager) defaultSendDeliveryReceiptManager.f10849i.get()).m11300a(deliveryReceiptBatch);
        if (a != null) {
            DeliveryReceiptBatch deliveryReceiptBatch2 = a.f10831a;
            final ImmutableList c = m11271c(deliveryReceiptBatch2);
            FbTraceNode a2 = defaultSendDeliveryReceiptManager.f10846f.a();
            FbTraceEventAnnotations a3 = FbTraceEventAnnotationsUtil.a(a2);
            if (a2 != FbTraceNode.a) {
                a3.put("message_ids", c);
                a3.put("other_fbid", m11272d(deliveryReceiptBatch2));
                a3.put("thread_fbid", m11273e(deliveryReceiptBatch2));
                a3.put("user_id", defaultSendDeliveryReceiptManager.f10845e.a().b());
            }
            a3.put("op", "send_delivery_receipt_batch");
            defaultSendDeliveryReceiptManager.f10846f.a(a2, FbTraceEvent.REQUEST_SEND, a3);
            MqttThriftHeader mqttThriftHeader = new MqttThriftHeader(a2 == FbTraceNode.a ? "" : a2.a());
            TSerializer tSerializer = new TSerializer(new Factory());
            try {
                byte[] a4 = m11266a(tSerializer.a(mqttThriftHeader), tSerializer.a(deliveryReceiptBatch2));
                defaultSendDeliveryReceiptManager.f10843c.a(str, m11268b(deliveryReceiptBatch2), m11274f(deliveryReceiptBatch2), deliveryReceiptBatch2.batchId.longValue(), c, a.f10832b, a.f10832b.size());
                final DeliveryReceiptBatch deliveryReceiptBatch3 = deliveryReceiptBatch2;
                final String str2 = str;
                final BatchWithFailureInfo batchWithFailureInfo = a;
                defaultSendDeliveryReceiptManager.f10842b.a("/t_dr_batch", a4, MqttQOSLevel.FIRE_AND_FORGET, new MqttPublishListener(defaultSendDeliveryReceiptManager) {
                    final /* synthetic */ DefaultSendDeliveryReceiptManager f10837e;

                    public final void m11259a() {
                        DefaultSendDeliveryReceiptManager.m11263a(this.f10837e, deliveryReceiptBatch3);
                        this.f10837e.f10843c.a(str2, DefaultSendDeliveryReceiptManager.m11268b(deliveryReceiptBatch3), c, DefaultSendDeliveryReceiptManager.m11274f(deliveryReceiptBatch3), deliveryReceiptBatch3.batchId.longValue(), batchWithFailureInfo.f10832b, batchWithFailureInfo.f10832b.size());
                    }

                    public final void m11260b() {
                        DefaultSendDeliveryReceiptManager.m11262a(this.f10837e);
                        ((SendDeliveryReceiptRetryManager) this.f10837e.f10849i.get()).m11301a(batchWithFailureInfo);
                        this.f10837e.f10843c.a(str2, DefaultSendDeliveryReceiptManager.m11268b(deliveryReceiptBatch3), c, DefaultSendDeliveryReceiptManager.m11274f(deliveryReceiptBatch3), deliveryReceiptBatch3.batchId.longValue(), batchWithFailureInfo.f10832b);
                    }
                });
            } catch (TException e) {
                new Object[1][0] = e.getMessage() != null ? e.getMessage() : "NULL";
            }
        }
    }

    public static synchronized void m11262a(DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager) {
        synchronized (defaultSendDeliveryReceiptManager) {
            if (defaultSendDeliveryReceiptManager.f10855o == null) {
                defaultSendDeliveryReceiptManager.f10855o = defaultSendDeliveryReceiptManager.f10851k.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C11942(defaultSendDeliveryReceiptManager)).a();
            }
            if (!defaultSendDeliveryReceiptManager.f10855o.a()) {
                defaultSendDeliveryReceiptManager.f10855o.b();
            }
        }
    }

    public static void m11263a(DefaultSendDeliveryReceiptManager defaultSendDeliveryReceiptManager, DeliveryReceiptBatch deliveryReceiptBatch) {
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            defaultSendDeliveryReceiptManager.f10844d.m11280a(DeliveryReceiptUtil.m11285a(deliveryReceipt), deliveryReceipt.watermarkTimestamp.longValue());
        }
    }

    private static long m11268b(DeliveryReceiptBatch deliveryReceiptBatch) {
        long j = 0;
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            long longValue;
            if (deliveryReceipt.watermarkTimestamp.longValue() > j) {
                longValue = deliveryReceipt.watermarkTimestamp.longValue();
            } else {
                longValue = j;
            }
            j = longValue;
        }
        return j;
    }

    private static ImmutableList<String> m11271c(DeliveryReceiptBatch deliveryReceiptBatch) {
        Builder builder = ImmutableList.builder();
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            if (deliveryReceipt.messageIds != null) {
                builder.b(deliveryReceipt.messageIds);
            }
        }
        return builder.b();
    }

    private static ImmutableList<Long> m11272d(DeliveryReceiptBatch deliveryReceiptBatch) {
        Builder builder = ImmutableList.builder();
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            builder.c(deliveryReceipt.messageSenderFbid);
        }
        return builder.b();
    }

    private static ImmutableList<Long> m11273e(DeliveryReceiptBatch deliveryReceiptBatch) {
        Builder builder = ImmutableList.builder();
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            builder.c(deliveryReceipt.threadFbid);
        }
        return builder.b();
    }

    private static byte[] m11266a(byte[] bArr, byte[] bArr2) {
        Object copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    private void m11265a(Map<ThreadKey, List<Message>> map) {
        UserKey a = this.f10845e.a();
        if (a == null) {
            this.f10853m.a("NullLoggedInUserKey", "Got null logged-in user key in maybeSendThriftDeliveryReceiptBatchForDeltas");
            return;
        }
        Builder builder = ImmutableList.builder();
        for (Entry entry : map.entrySet()) {
            ThreadKey threadKey = (ThreadKey) entry.getKey();
            List<Message> list = (List) entry.getValue();
            Message message = (Message) list.get(list.size() - 1);
            Builder builder2 = ImmutableList.builder();
            if (message.b.a == Type.GROUP) {
                builder2.c(m11261a(message.a));
            } else {
                for (Message message2 : list) {
                    builder2.c(m11261a(message2.a));
                }
            }
            if (this.f10844d.m11281b(threadKey, message.c)) {
                Long.valueOf(message.c);
            }
            builder.c(new DeliveryReceipt(Long.valueOf(Long.parseLong(message.e.b.b())), Long.valueOf(message.c), Long.valueOf(message.b.b), builder2.b(), Long.valueOf(Long.parseLong(a.b())), Boolean.valueOf(message.b.a == Type.GROUP)));
        }
        ImmutableList b = builder.b();
        if (!b.isEmpty()) {
            m11264a(this, new DeliveryReceiptBatch(b, Long.valueOf(this.f10848h.a())), "DELTAS");
        }
    }

    private static int m11274f(DeliveryReceiptBatch deliveryReceiptBatch) {
        int i = 0;
        for (DeliveryReceipt deliveryReceipt : deliveryReceiptBatch.deliveryReceipts) {
            i = deliveryReceipt.messageIds.size() + i;
        }
        return i;
    }

    private static String m11261a(String str) {
        if (str.startsWith("m_")) {
            return str.substring(2);
        }
        return str;
    }
}
