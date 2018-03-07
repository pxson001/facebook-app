package com.facebook.messaging.send.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.analytics.reliability.NetworkChannel;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.MessagesBroadcaster$ThreadUpdateCause;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.media.upload.MediaUploadErrorHelper;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageAttachmentInfo;
import com.facebook.messaging.model.messages.MessageAttachmentInfoFactory;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.PendingSendQueueType;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.send.client.ExponentialBackoffRetryManager.C19621;
import com.facebook.messaging.send.client.SendMessageToPendingThreadManager.SendToPendingThreadResult;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageParamsBuilder;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import com.facebook.messaging.tincan.messenger.AttachmentUploadCompleteListener;
import com.facebook.messaging.tincan.messenger.TincanSendMessageManager;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.zero.DefaultZeroMessageSendHandler;
import com.facebook.zero.ZeroMessageSendHandler;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: default_spec */
public class SendMessageManager implements IHaveUserData {
    private static final Object f16761T = new Object();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SendMessageToPendingThreadManager> f16762A = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MmsSmsPendingSendQueue> f16763B = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AggregatedReliabilityLogger> f16764C = UltralightRuntime.b();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaUploadErrorHelper> f16765D = UltralightRuntime.b();
    private final AttachmentUploadCompleteListener f16766E;
    @GuardedBy("ui_thread")
    public final LinkedHashMultimap<ThreadKey, Message> f16767F;
    @GuardedBy("ui_thread")
    public final LinkedHashMultimap<ThreadKey, Message> f16768G;
    @GuardedBy("ui_thread")
    public final PendingThreadSendMap f16769H;
    public final Cache<String, Long> f16770I;
    public final Cache<String, Throwable> f16771J;
    private final SelfRegistrableReceiverImpl f16772K;
    private final SelfRegistrableReceiverImpl f16773L;
    private final SelfRegistrableReceiverImpl f16774M;
    @GuardedBy("ui_thread")
    public final ExponentialBackoffRetryManager f16775N;
    @GuardedBy("ui_thread")
    private boolean f16776O;
    @GuardedBy("ui_thread")
    private String f16777P;
    @GuardedBy("ui_thread")
    private boolean f16778Q;
    private final AbstractFbErrorReporter f16779R;
    private Runnable f16780S;
    public final MessagesBroadcaster f16781a;
    private final DefaultBlueServiceOperationFactory f16782b;
    public final DefaultAndroidThreadUtil f16783c;
    public final ScheduledExecutorService f16784d;
    private final Executor f16785e;
    public final MonotonicClock f16786f;
    public final FbTracer f16787g;
    public final SendLifeCycleManager f16788h;
    private final MessageUtil f16789i;
    private final MessageClassifier f16790j;
    private final BaseFbBroadcastManager f16791k;
    private final MessagingAnalyticsLogger f16792l;
    public final AnalyticsLogger f16793m;
    public final Clock f16794n;
    private final Provider<Boolean> f16795o;
    public final ConnectionStatusMonitor f16796p;
    private final StartupRetryManager f16797q;
    public final MessagingPerformanceLogger f16798r;
    private final ZeroMessageSendHandler f16799s;
    private final Provider<SendFailureNotifier> f16800t;
    private final SendQueueSeparationExperimentController f16801u;
    public final MonotonicClock f16802v;
    public final MessageAttachmentInfoFactory f16803w;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaUploadManager> f16804x = UltralightRuntime.b();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagesReliabilityLogger> f16805y = UltralightRuntime.b();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<TincanSendMessageManager> f16806z = UltralightRuntime.b();

    /* compiled from: default_spec */
    public /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] f16745a = new int[Type.values().length];
        public static final /* synthetic */ int[] f16747c = new int[PushStateEvent.values().length];

        static {
            try {
                f16747c[PushStateEvent.CHANNEL_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            f16746b = new int[UploadState.values().length];
            try {
                f16746b[UploadState.NOT_ALL_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16746b[UploadState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16746b[UploadState.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16746b[UploadState.NO_MEDIA_ITEMS.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16746b[UploadState.IN_PROGRESS.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16745a[Type.ONE_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f16745a[Type.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: default_spec */
    class C19711 implements ActionReceiver {
        final /* synthetic */ SendMessageManager f16748a;

        C19711(SendMessageManager sendMessageManager) {
            this.f16748a = sendMessageManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1684019021);
            SendMessageManager sendMessageManager = this.f16748a;
            switch (AnonymousClass11.f16747c[PushStateEvent.fromValue(intent.getIntExtra("event", -1)).ordinal()]) {
                case 1:
                    sendMessageManager.f16775N.m16657b();
                    for (PendingThreadSends pendingThreadSends : sendMessageManager.f16769H.m16707a()) {
                        pendingThreadSends.f16688i = 0;
                    }
                    SendMessageManager.m16790c(sendMessageManager);
                    break;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1228741653, a);
        }
    }

    /* compiled from: default_spec */
    class C19722 implements ActionReceiver {
        final /* synthetic */ SendMessageManager f16749a;

        C19722(SendMessageManager sendMessageManager) {
            this.f16749a = sendMessageManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2122409535);
            SendMessageManager sendMessageManager = this.f16749a;
            sendMessageManager.f16783c.a();
            SendMessageManager.m16790c(sendMessageManager);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1514164639, a);
        }
    }

    /* compiled from: default_spec */
    class C19733 implements ActionReceiver {
        final /* synthetic */ SendMessageManager f16750a;

        C19733(SendMessageManager sendMessageManager) {
            this.f16750a = sendMessageManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1605157471);
            ThreadKey threadKey = (ThreadKey) intent.getParcelableExtra("thread_key");
            Collection stringArrayListExtra = intent.getStringArrayListExtra("offline_threading_ids");
            SendMessageManager sendMessageManager = this.f16750a;
            if (!stringArrayListExtra.isEmpty()) {
                Iterator it = sendMessageManager.f16768G.a(threadKey).iterator();
                Object obj = null;
                while (it.hasNext()) {
                    Object obj2;
                    Message message = (Message) it.next();
                    if (MessageUtil.O(message) && stringArrayListExtra.contains(message.n)) {
                        String str = message.n;
                        it.remove();
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj != null) {
                    sendMessageManager.f16781a.a(threadKey);
                }
            }
            this.f16750a.m16804a(threadKey, stringArrayListExtra);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1022462160, a);
        }
    }

    /* compiled from: default_spec */
    class C19744 implements Runnable {
        final /* synthetic */ SendMessageManager f16751a;

        C19744(SendMessageManager sendMessageManager) {
            this.f16751a = sendMessageManager;
        }

        public void run() {
            SendMessageManager.m16792e(this.f16751a);
        }
    }

    /* compiled from: default_spec */
    class C19755 implements Runnable {
        final /* synthetic */ SendMessageManager f16752a;

        C19755(SendMessageManager sendMessageManager) {
            this.f16752a = sendMessageManager;
        }

        public void run() {
            this.f16752a.f16775N.m16657b();
        }
    }

    /* compiled from: default_spec */
    class C19777 implements AsyncFunction<SendToPendingThreadResult, SendResult> {
        final /* synthetic */ SendMessageManager f16755a;

        C19777(SendMessageManager sendMessageManager) {
            this.f16755a = sendMessageManager;
        }

        public final ListenableFuture m16773a(Object obj) {
            SendToPendingThreadResult sendToPendingThreadResult = (SendToPendingThreadResult) obj;
            MessageBuilder a = Message.newBuilder().a(sendToPendingThreadResult.f16819a);
            a.b = sendToPendingThreadResult.f16820b;
            return this.f16755a.m16809c(a.R());
        }
    }

    /* compiled from: default_spec */
    public class C19788 implements Runnable {
        final /* synthetic */ Message f16756a;
        final /* synthetic */ SendMessageManager f16757b;

        public C19788(SendMessageManager sendMessageManager, Message message) {
            this.f16757b = sendMessageManager;
            this.f16756a = message;
        }

        public void run() {
            if (SendMessageManager.m16797j(this.f16757b, this.f16756a)) {
                PendingThreadSends a = this.f16757b.f16769H.m16706a(this.f16757b.m16810e(this.f16756a));
                boolean l = SendMessageManager.m16798l(this.f16757b, this.f16756a);
                SendMessageParamsBuilder a2 = SendMessageParams.m17181a();
                a2.f17314a = this.f16756a;
                SendMessageParamsBuilder a3 = a2.m17187a(l);
                a3.f17317d = a.f16686g;
                a3 = a3;
                a3.f17318e = a.m16716l();
                a3 = a3;
                a3.f17319f = a.m16714c();
                ((MessagesReliabilityLogger) this.f16757b.f16805y.get()).m7952a(a3.m17182a(), this.f16757b.f16802v.now() - this.f16756a.d, this.f16757b.f16803w.b(this.f16756a), "via_mqtt", 0, false, null, null, this.f16757b.f16796p.b(), NetworkChannel.MQTT, true);
                SendMessageManager.m16796i(this.f16757b, this.f16756a);
            }
        }
    }

    private static SendMessageManager m16788b(InjectorLike injectorLike) {
        SendMessageManager sendMessageManager = new SendMessageManager(MessagesBroadcaster.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FbTracer.a(injectorLike), SendLifeCycleManager.m16762a(injectorLike), MessageUtil.a(injectorLike), MessageClassifier.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) DbClock.a(injectorLike), MessagingAnalyticsLogger.m7905a(injectorLike), IdBasedProvider.a(injectorLike, 4156), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ExponentialBackoffRetryManager.m16655a(injectorLike), StartupRetryManager.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), (ZeroMessageSendHandler) DefaultZeroMessageSendHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 8345), SendQueueSeparationExperimentController.m16831a(injectorLike), (MonotonicClock) RealtimeSinceBootClockMethodAutoProvider.a(injectorLike), MessageAttachmentInfoFactory.a(injectorLike), AttachmentUploadCompleteListener.m17972a(injectorLike));
        sendMessageManager.m16781a(IdBasedLazy.a(injectorLike, 2644), IdBasedLazy.a(injectorLike, 7514), IdBasedLazy.a(injectorLike, 8582), IdBasedLazy.a(injectorLike, 8348), IdBasedLazy.a(injectorLike, 8471), IdBasedSingletonScopeProvider.b(injectorLike, 2549), IdBasedSingletonScopeProvider.b(injectorLike, 7933));
        return sendMessageManager;
    }

    private void m16781a(com.facebook.inject.Lazy<MediaUploadManager> lazy, com.facebook.inject.Lazy<MessagesReliabilityLogger> lazy2, com.facebook.inject.Lazy<TincanSendMessageManager> lazy3, com.facebook.inject.Lazy<SendMessageToPendingThreadManager> lazy4, com.facebook.inject.Lazy<MmsSmsPendingSendQueue> lazy5, com.facebook.inject.Lazy<AggregatedReliabilityLogger> lazy6, com.facebook.inject.Lazy<MediaUploadErrorHelper> lazy7) {
        this.f16804x = lazy;
        this.f16805y = lazy2;
        this.f16806z = lazy3;
        this.f16762A = lazy4;
        this.f16763B = lazy5;
        this.f16764C = lazy6;
        this.f16765D = lazy7;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.SendMessageManager m16780a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16761T;	 Catch:{ all -> 0x006c }
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
        r1 = m16788b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16761T;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendMessageManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.SendMessageManager) r0;	 Catch:{  }
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
        r0 = f16761T;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendMessageManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendMessageManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.SendMessageManager");
    }

    @Inject
    private SendMessageManager(MessagesBroadcaster messagesBroadcaster, BlueServiceOperationFactory blueServiceOperationFactory, AndroidThreadUtil androidThreadUtil, ScheduledExecutorService scheduledExecutorService, Executor executor, MonotonicClock monotonicClock, FbTracer fbTracer, SendLifeCycleManager sendLifeCycleManager, MessageUtil messageUtil, MessageClassifier messageClassifier, FbBroadcastManager fbBroadcastManager, AnalyticsLogger analyticsLogger, Clock clock, MessagingAnalyticsLogger messagingAnalyticsLogger, Provider<Boolean> provider, ConnectionStatusMonitor connectionStatusMonitor, FbErrorReporter fbErrorReporter, ExponentialBackoffRetryManager exponentialBackoffRetryManager, StartupRetryManager startupRetryManager, MessagingPerformanceLogger messagingPerformanceLogger, ZeroMessageSendHandler zeroMessageSendHandler, Provider<SendFailureNotifier> provider2, SendQueueSeparationExperimentController sendQueueSeparationExperimentController, MonotonicClock monotonicClock2, MessageAttachmentInfoFactory messageAttachmentInfoFactory, AttachmentUploadCompleteListener attachmentUploadCompleteListener) {
        this.f16781a = messagesBroadcaster;
        this.f16782b = blueServiceOperationFactory;
        this.f16783c = androidThreadUtil;
        this.f16784d = scheduledExecutorService;
        this.f16785e = executor;
        this.f16786f = monotonicClock;
        this.f16787g = fbTracer;
        this.f16788h = sendLifeCycleManager;
        this.f16789i = messageUtil;
        this.f16790j = messageClassifier;
        this.f16791k = fbBroadcastManager;
        this.f16793m = analyticsLogger;
        this.f16794n = clock;
        this.f16792l = messagingAnalyticsLogger;
        this.f16795o = provider;
        this.f16799s = zeroMessageSendHandler;
        this.f16767F = LinkedHashMultimap.u();
        this.f16768G = LinkedHashMultimap.u();
        this.f16769H = new PendingThreadSendMap(monotonicClock);
        this.f16770I = CacheBuilder.newBuilder().a(300, TimeUnit.SECONDS).q();
        this.f16771J = CacheBuilder.newBuilder().a(600, TimeUnit.SECONDS).q();
        this.f16772K = this.f16791k.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C19711(this)).a();
        this.f16773L = this.f16791k.a().a("com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED", new C19722(this)).a();
        this.f16773L.b();
        this.f16774M = this.f16791k.a().a(MessagesBroadcastIntents.h, new C19733(this)).a();
        this.f16774M.b();
        this.f16780S = new C19744(this);
        this.f16796p = connectionStatusMonitor;
        this.f16779R = fbErrorReporter;
        this.f16775N = exponentialBackoffRetryManager;
        this.f16797q = startupRetryManager;
        this.f16798r = messagingPerformanceLogger;
        this.f16800t = provider2;
        this.f16801u = sendQueueSeparationExperimentController;
        this.f16802v = monotonicClock2;
        this.f16803w = messageAttachmentInfoFactory;
        this.f16766E = attachmentUploadCompleteListener;
        this.f16766E.m17976a();
    }

    public void clearUserData() {
        if (this.f16772K.a()) {
            this.f16772K.c();
        }
        this.f16773L.c();
        this.f16774M.c();
        ExecutorDetour.a(this.f16784d, new C19755(this), 1251143380);
    }

    public final ListenableFuture<SendResult> m16803a(Message message, String str, @Nullable NavigationTrigger navigationTrigger, MessageSendTrigger messageSendTrigger) {
        if (ThreadKey.g(message.b)) {
            return ((TincanSendMessageManager) this.f16806z.get()).m18033a(message);
        }
        this.f16798r.a(message.n, navigationTrigger == null ? null : navigationTrigger.toString());
        this.f16798r.a(message.n, str);
        MessagingAnalyticsLogger messagingAnalyticsLogger = this.f16792l;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("send_message");
        honeyClientEvent.c = str;
        honeyClientEvent = honeyClientEvent;
        if (navigationTrigger != null) {
            honeyClientEvent.a("navigation_trigger", navigationTrigger);
        }
        if (messageSendTrigger != null) {
            honeyClientEvent.b("message_send_trigger", messageSendTrigger.toString());
        }
        if (message.F != null) {
            honeyClientEvent.b("platform_app_id", message.F.b);
        }
        if (MessageUtil.A(message)) {
            honeyClientEvent.a("has_text", true);
        }
        if (ThreadKey.d(message.b)) {
            honeyClientEvent.a("sms_tid", message.b.b);
        }
        MessageAttachmentInfo a = messagingAnalyticsLogger.f7630d.a(message);
        MessagingAnalyticsLogger.m7909b(honeyClientEvent, "has_like", a.f);
        MessagingAnalyticsLogger.m7909b(honeyClientEvent, "has_sticker", a.e);
        MessagingAnalyticsLogger.m7906a(honeyClientEvent, "num_photos", a.b);
        MessagingAnalyticsLogger.m7906a(honeyClientEvent, "num_videos", a.c);
        MessagingAnalyticsLogger.m7906a(honeyClientEvent, "num_audio_clips", a.d);
        MessagingAnalyticsLogger.m7906a(honeyClientEvent, "num_share_attachments", a.g);
        MessagingAnalyticsLogger.m7909b(honeyClientEvent, "has_payment", a.h);
        MessagingAnalyticsLogger.m7909b(honeyClientEvent, "has_xma", a.i);
        messagingAnalyticsLogger.f7627a.a(honeyClientEvent);
        ((MessagesReliabilityLogger) this.f16805y.get()).m7945a(message, str, navigationTrigger);
        Message a2 = m16777a(message, navigationTrigger);
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder("Sending message");
            stringBuilder.append(" thread:").append(a2.b);
            stringBuilder.append(" navigationTrigger:");
            if (navigationTrigger != null) {
                stringBuilder.append(navigationTrigger);
            }
        }
        return m16809c(a2);
    }

    private Message m16777a(Message message, NavigationTrigger navigationTrigger) {
        TracerDetour.a("SendMessageManager.prepareMessageForSend", -62924237);
        this.f16798r.a(message.n, (short) 35);
        try {
            MessageBuilder a = Message.newBuilder().a(message);
            if (navigationTrigger != null) {
                String navigationTrigger2 = navigationTrigger.toString();
                if (navigationTrigger2 != null) {
                    a.a("trigger", navigationTrigger2);
                }
            }
            a.a(m16810e(message));
            Message R = a.R();
            return R;
        } finally {
            this.f16798r.a(message.n, (short) 36);
            TracerDetour.a(-986935246);
        }
    }

    public final boolean m16808b(Message message) {
        return m16787a(m16810e(message));
    }

    public final boolean m16805a(ThreadKey threadKey) {
        if (ThreadKey.f(threadKey)) {
            return true;
        }
        if (ThreadKey.d(threadKey)) {
            boolean z;
            if (((MmsSmsPendingSendQueue) this.f16763B.get()).f17685d.a(threadKey.i()) != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        PendingSendQueueKey pendingSendQueueKey = new PendingSendQueueKey(threadKey, PendingSendQueueType.NORMAL);
        if (!((Boolean) this.f16795o.get()).booleanValue()) {
            return m16787a(pendingSendQueueKey);
        }
        PendingThreadSends a = this.f16769H.m16706a(pendingSendQueueKey);
        if (a != null && !a.m16711a()) {
            return true;
        }
        a = this.f16769H.m16706a(new PendingSendQueueKey(threadKey, PendingSendQueueType.VIDEO));
        if (a != null && !a.m16711a()) {
            return true;
        }
        a = this.f16769H.m16706a(new PendingSendQueueKey(threadKey, PendingSendQueueType.PHOTO));
        if (a != null && !a.m16711a()) {
            return true;
        }
        a = this.f16769H.m16706a(new PendingSendQueueKey(threadKey, PendingSendQueueType.LIGHT_MEDIA));
        return (a == null || a.m16711a()) ? false : true;
    }

    private boolean m16787a(PendingSendQueueKey pendingSendQueueKey) {
        this.f16783c.a();
        PendingThreadSends a = this.f16769H.m16706a(pendingSendQueueKey);
        if (a == null) {
            return false;
        }
        if (a.f16684e) {
            return true;
        }
        if (this.f16786f.now() - a.f16683d >= 30000) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public final ListenableFuture<SendResult> m16809c(final Message message) {
        boolean z = true;
        Preconditions.checkNotNull(message.b);
        Preconditions.checkArgument(message.l == MessageType.PENDING_SEND);
        if (ThreadKey.g(message.b)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        ThreadKey threadKey = message.b;
        if (threadKey.f()) {
            return m16793f(message);
        }
        boolean d = ThreadKey.d(threadKey);
        TracerDetour.a("SendMessageManager.startAsyncSend%s", d ? "Sms" : "", 108802848);
        this.f16798r.a(message.n, (short) 37);
        try {
            this.f16783c.a();
            String str = message.n;
            if (!d) {
                this.f16797q.b();
                ((SendFailureNotifier) this.f16800t.get()).m16758a(message);
                m16786a(this.f16768G.a(threadKey), message);
                this.f16767F.a(threadKey, message);
            }
            ListenableFuture<SendResult> a = this.f16788h.m16767a(message);
            this.f16788h.m16768a(message.n, 100);
            Bundle bundle = new Bundle();
            bundle.putParcelable("outgoingMessage", message);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f16782b, "insert_pending_sent_message", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(SendMessageManager.class), 320394619).a(), new OperationResultFutureCallback2(this) {
                final /* synthetic */ SendMessageManager f16754b;

                public final void m16770a(OperationResult operationResult) {
                    SendMessageManager sendMessageManager = this.f16754b;
                    Message message = message;
                    String str = message.n;
                    sendMessageManager.f16783c.a();
                    if (sendMessageManager.f16767F.c(message.b, message)) {
                        sendMessageManager.f16768G.a(message.b, message);
                    }
                    sendMessageManager.f16788h.m16768a(message.n, 101);
                    SendMessageManager.m16790c(sendMessageManager);
                    sendMessageManager.f16781a.a(message.b, MessagesBroadcaster.a(MessagesBroadcaster$ThreadUpdateCause.MESSAGE_QUEUED, message.a));
                }

                protected final void m16772a(Throwable th) {
                    SendMessageManager sendMessageManager = this.f16754b;
                    Message message = message;
                    String str = message.n;
                    sendMessageManager.f16783c.a();
                    ThreadKey threadKey = message.b;
                    sendMessageManager.f16767F.c(threadKey, message);
                    sendMessageManager.f16781a.a(threadKey);
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("queue_failure");
                    SendMessageManager.m16784a(threadKey, honeyClientEvent);
                    sendMessageManager.f16793m.a(honeyClientEvent);
                    sendMessageManager.f16788h.m16768a(message.n, 102);
                }
            });
            if (!d) {
                this.f16770I.a(message.n, Long.valueOf(this.f16786f.now()));
                this.f16769H.m16709c(m16810e(message)).m16710a(message);
            }
            this.f16798r.a(message.n, (short) 41);
            this.f16788h.m16769b(message.n, 201);
            m16790c(this);
            if (message.u != null && message.u.a == SentShareAttachment.Type.PAYMENT) {
                this.f16798r.a(message.n, "payment_transfer");
            }
            this.f16798r.a(message.n, (short) 38);
            TracerDetour.a(-1785153709);
            return a;
        } catch (Throwable th) {
            this.f16798r.a(message.n, (short) 38);
            TracerDetour.a(711587848);
        }
    }

    private ListenableFuture<SendResult> m16793f(Message message) {
        return Futures.b(((SendMessageToPendingThreadManager) this.f16762A.get()).m16829a(message), new C19777(this), this.f16785e);
    }

    public final List<Message> m16806b(ThreadKey threadKey) {
        this.f16783c.a();
        if (this.f16768G.f(threadKey)) {
            Iterator it = this.f16768G.a(threadKey).iterator();
            long now = this.f16786f.now();
            while (it.hasNext()) {
                Long l = (Long) this.f16770I.a(((Message) it.next()).n);
                if (l == null || now - l.longValue() > 30000) {
                    it.remove();
                }
            }
        }
        return Lists.a(Lists.a(Iterables.b(this.f16768G.a(threadKey), this.f16767F.a(threadKey))));
    }

    public static void m16790c(SendMessageManager sendMessageManager) {
        TracerDetour.a("SendMessageManager.maybeSendAnotherMessage", -633925058);
        try {
            sendMessageManager.f16783c.a();
            if (!sendMessageManager.f16776O) {
                final Message d = sendMessageManager.m16791d();
                if (d == null) {
                    TracerDetour.a(-1824917397);
                    return;
                }
                sendMessageManager.f16788h.m16769b(d.n, 202);
                final FbTraceNode a = sendMessageManager.f16787g.a();
                FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.a(a);
                m16782a(d, a2);
                sendMessageManager.f16787g.a(a, FbTraceEvent.REQUEST_RECEIVE, a2);
                boolean l = m16798l(sendMessageManager, d);
                String str = d.n;
                Boolean.valueOf(l);
                if (!l) {
                    sendMessageManager.m16799m(d);
                }
                Message c = ((MediaUploadManagerImpl) sendMessageManager.f16804x.get()).c(d);
                PendingThreadSends a3 = sendMessageManager.f16769H.m16706a(sendMessageManager.m16810e(d));
                Parcelable a4 = SendMessageParams.m17181a().m17186a(c).m17187a(l).m17185a(a).m17183a(a3.m16715j()).m17184a(a3.m16716l()).m17188b(a3.m16714c()).m17182a();
                Bundle bundle = new Bundle();
                bundle.putParcelable("sendMessageParams", a4);
                Futures.a(BlueServiceOperationFactoryDetour.a(sendMessageManager.f16782b, "send", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(SendMessageManager.class), -1020490004).a(), new OperationResultFutureCallback2(sendMessageManager) {
                    final /* synthetic */ SendMessageManager f16760c;

                    public final void m16774a(OperationResult operationResult) {
                        this.f16760c.f16787g.a(a, FbTraceEvent.RESPONSE_SEND, null);
                        SendMessageManager.m16796i(this.f16760c, d);
                    }

                    protected final void m16776a(Throwable th) {
                        this.f16760c.f16787g.a(a, FbTraceEvent.RESPONSE_SEND, null);
                        this.f16760c.m16785a(th, d);
                    }
                });
                sendMessageManager.f16776O = true;
                sendMessageManager.f16777P = d.n;
                TracerDetour.a(1733518689);
            }
        } finally {
            TracerDetour.a(10205500);
        }
    }

    private static void m16782a(Message message, FbTraceEventAnnotations fbTraceEventAnnotations) {
        fbTraceEventAnnotations.put("op", "message_send");
        fbTraceEventAnnotations.put("offline_threading_id", message.n);
        switch (AnonymousClass11.f16745a[message.b.a.ordinal()]) {
            case 1:
                fbTraceEventAnnotations.put("recipient_id", Long.valueOf(message.b.d));
                return;
            case 2:
                fbTraceEventAnnotations.put("thread_fbid", Long.valueOf(message.b.b));
                return;
            default:
                return;
        }
    }

    private Message m16791d() {
        Message message = null;
        while (true) {
            Message g = m16795g();
            if (g == null) {
                return null;
            }
            if (g == message) {
                throw new IllegalStateException("Message repeated");
            }
            UploadState uploadState = ((MediaUploadManagerImpl) this.f16804x.get()).b(g).f11998b;
            switch (uploadState) {
                case NOT_ALL_STARTED:
                    ((MediaUploadManagerImpl) this.f16804x.get()).a(g);
                    break;
                case FAILED:
                    m16802q(g);
                    if (m16798l(this, g) && this.f16796p.b()) {
                        ((MediaUploadManagerImpl) this.f16804x.get()).a(g);
                        m16800n(g);
                        break;
                    }
                    return g;
                    break;
                case SUCCEEDED:
                case NO_MEDIA_ITEMS:
                    m16802q(g);
                    return g;
                case IN_PROGRESS:
                    throw new IllegalStateException("Unexpected state: " + uploadState);
                default:
                    throw new IllegalStateException("Unknown state: " + uploadState);
            }
            message = g;
        }
    }

    public static void m16796i(SendMessageManager sendMessageManager, Message message) {
        String str = message.n;
        sendMessageManager.f16783c.a();
        sendMessageManager.f16776O = false;
        sendMessageManager.f16777P = null;
        sendMessageManager.f16778Q = false;
        sendMessageManager.f16788h.m16769b(message.n, 203);
        sendMessageManager.f16775N.m16657b();
        sendMessageManager.m16794f();
        PendingSendQueueKey e = sendMessageManager.m16810e(message);
        PendingThreadSends a = sendMessageManager.f16769H.m16706a(e);
        if (a != null) {
            a.f16685f = null;
            a.f16686g = 0;
            a.f16687h = -1;
            if (a.m16711a()) {
                sendMessageManager.f16769H.m16708b(e);
            }
        }
        m16790c(sendMessageManager);
    }

    private void m16785a(Throwable th, Message message) {
        if (m16797j(this, message)) {
            String str = message.n;
            this.f16783c.a();
            boolean z = this.f16778Q;
            this.f16776O = false;
            this.f16777P = null;
            this.f16778Q = false;
            Preconditions.checkNotNull(message);
            boolean a = this.f16796p.a(ConnectionType.MQTT);
            PendingThreadSends a2;
            if (z) {
                String str2 = message.n;
                PendingSendQueueKey e = m16810e(message);
                a2 = this.f16769H.m16706a(e);
                if (a2 != null) {
                    a2.f16685f = null;
                    a2.f16686g = 0;
                    a2.f16687h = -1;
                    if (a2.m16711a()) {
                        this.f16769H.m16708b(e);
                    }
                }
                this.f16798r.a(message.n, "canceled");
                this.f16788h.m16769b(message.n, 204);
            } else {
                Message a3 = m16779a(th);
                Object obj = null;
                if (!(a3 == null || a3.w.b.shouldNotBeRetried)) {
                    a2 = this.f16769H.m16706a(m16810e(a3));
                    if (!(a2 == null || a2.f16689j)) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    if (a) {
                        m16800n(message);
                    } else {
                        ((SendFailureNotifier) this.f16800t.get()).m16760b(message);
                        m16801o(message);
                    }
                    if (!this.f16772K.a()) {
                        this.f16772K.b();
                    }
                } else {
                    m16783a(message, th);
                }
            }
            m16790c(this);
            return;
        }
        m16790c(this);
    }

    public static boolean m16797j(SendMessageManager sendMessageManager, Message message) {
        PendingThreadSends a = sendMessageManager.f16769H.m16706a(sendMessageManager.m16810e(message));
        if (a != null) {
            String str = a.f16685f;
            if (str != null) {
                return str.equals(message.n);
            }
        }
        return false;
    }

    @VisibleForTesting
    final void m16804a(ThreadKey threadKey, Collection<String> collection) {
        this.f16783c.a();
        for (PendingSendQueueType pendingSendQueueKey : PendingSendQueueType.values()) {
            PendingSendQueueKey pendingSendQueueKey2 = new PendingSendQueueKey(threadKey, pendingSendQueueKey);
            PendingThreadSends a = this.f16769H.m16706a(pendingSendQueueKey2);
            if (a != null) {
                for (String str : collection) {
                    if (Objects.equal(this.f16777P, str)) {
                        this.f16778Q = true;
                    } else if (a.m16712a(str)) {
                        this.f16788h.m16769b(str, 204);
                        if (a.m16711a()) {
                            this.f16769H.m16708b(pendingSendQueueKey2);
                        }
                    }
                    MediaUploadManagerImpl mediaUploadManagerImpl = (MediaUploadManagerImpl) this.f16804x.get();
                    mediaUploadManagerImpl.m.a();
                    mediaUploadManagerImpl.j.a(str);
                }
            }
        }
    }

    public static boolean m16798l(SendMessageManager sendMessageManager, Message message) {
        MessageClassification a = sendMessageManager.f16790j.a(message);
        MessageMediaUploadState b = ((MediaUploadManagerImpl) sendMessageManager.f16804x.get()).b(message);
        if (a == MessageClassification.VIDEO_CLIP && b.f11998b == UploadState.FAILED) {
            return false;
        }
        if ((a == MessageClassification.PHOTOS || a == MessageClassification.AUDIO_CLIP) && b.f11998b == UploadState.FAILED) {
            MediaUploadErrorHelper mediaUploadErrorHelper = (MediaUploadErrorHelper) sendMessageManager.f16765D.get();
            Preconditions.checkState(b.f11998b == UploadState.FAILED, "Expected FAILED, got: %s", new Object[]{b.f11998b});
            if (!mediaUploadErrorHelper.m12483a(b.f11997a.f11851f)) {
                return false;
            }
        }
        if (a == MessageClassification.PAYMENT) {
            return false;
        }
        if (sendMessageManager.f16786f.now() - sendMessageManager.f16769H.m16706a(sendMessageManager.m16810e(message)).f16687h > 600000) {
            return false;
        }
        return true;
    }

    private void m16799m(Message message) {
        this.f16769H.m16706a(m16810e(message)).f16689j = true;
    }

    private void m16800n(Message message) {
        String str = message.n;
        this.f16798r.a(message.n, "retry_after_failure");
        this.f16798r.a(message.n, (short) 52);
        PendingThreadSends c = this.f16769H.m16709c(m16810e(message));
        c.m16713b(message);
        c.f16684e = true;
        c.f16686g++;
        c.f16688i = this.f16786f.now() + 30000;
        this.f16784d.schedule(new Runnable(this) {
            final /* synthetic */ SendMessageManager f16744a;

            {
                this.f16744a = r1;
            }

            public void run() {
                SendMessageManager.m16790c(this.f16744a);
            }
        }, 30000, TimeUnit.MILLISECONDS);
        this.f16781a.a(message.b);
    }

    private void m16801o(Message message) {
        String str = message.n;
        this.f16798r.a(message.n, "retry_after_reconnect");
        this.f16798r.a(message.n, (short) 53);
        PendingThreadSends c = this.f16769H.m16709c(m16810e(message));
        c.m16713b(message);
        c.f16684e = true;
        c.f16685f = null;
        c.f16686g = 0;
        c.f16687h = -1;
        c.f16688i = -1;
        this.f16781a.a(message.b);
        ExponentialBackoffRetryManager exponentialBackoffRetryManager = this.f16775N;
        Runnable runnable = this.f16780S;
        exponentialBackoffRetryManager.f16658b.a();
        if (exponentialBackoffRetryManager.f16659c == null) {
            if (exponentialBackoffRetryManager.f16660d == 0) {
                exponentialBackoffRetryManager.f16660d = 600000;
            } else {
                exponentialBackoffRetryManager.f16660d *= 2;
            }
            Long.valueOf(exponentialBackoffRetryManager.f16660d);
            exponentialBackoffRetryManager.f16659c = exponentialBackoffRetryManager.f16657a.schedule(new C19621(exponentialBackoffRetryManager, runnable), exponentialBackoffRetryManager.f16660d, TimeUnit.MILLISECONDS);
        }
    }

    private void m16783a(Message message, Throwable th) {
        String str = message.n;
        this.f16771J.a(message.n, th);
        ThreadKey threadKey = message.b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("send_failure");
        m16784a(threadKey, honeyClientEvent);
        if (th != null) {
            honeyClientEvent.b("error_message", th.getMessage());
        }
        this.f16793m.a(honeyClientEvent);
        ExponentialBackoffRetryManager exponentialBackoffRetryManager = this.f16775N;
        exponentialBackoffRetryManager.f16658b.a();
        if (exponentialBackoffRetryManager.f16659c == null) {
            exponentialBackoffRetryManager.f16660d = 0;
        }
        PendingThreadSends b = this.f16769H.m16708b(m16810e(message));
        if (b != null) {
            b.f16684e = true;
            b.f16685f = null;
            b.f16686g = 0;
            b.f16687h = -1;
            for (Message message2 : b.m16717o()) {
                this.f16771J.a(message2.n, th);
                this.f16788h.m16769b(message2.n, 204);
            }
        }
        this.f16781a.a(message.b);
        this.f16788h.m16769b(message.n, 204);
        ((SendFailureNotifier) this.f16800t.get()).m16759a(message, th);
    }

    public static void m16792e(SendMessageManager sendMessageManager) {
        if (sendMessageManager.f16796p.a(ConnectionType.MQTT)) {
            sendMessageManager.f16779R.a("SendMessageManager", "Backoff timer triggered retry but mqtt is connected.");
        }
        sendMessageManager.m16794f();
        m16790c(sendMessageManager);
    }

    private void m16794f() {
        for (PendingThreadSends pendingThreadSends : this.f16769H.m16707a()) {
            if (pendingThreadSends.f16688i == -1) {
                pendingThreadSends.f16688i = 0;
            }
        }
    }

    private static Message m16779a(Throwable th) {
        if (th instanceof SendMessageException) {
            return ((SendMessageException) th).failedMessage;
        }
        return null;
    }

    public static void m16784a(ThreadKey threadKey, HoneyClientEvent honeyClientEvent) {
        if (threadKey.a == Type.GROUP) {
            honeyClientEvent.a("thread_fbid", threadKey.b);
        } else {
            honeyClientEvent.a("other_user_id", threadKey.d);
        }
    }

    @VisibleForTesting
    private Message m16795g() {
        Message message = null;
        for (PendingThreadSends a : this.f16769H.m16707a()) {
            Message a2 = m16778a(a);
            if (message == null) {
                message = a2;
            } else {
                if (a2 == null || a2.d >= message.d) {
                    a2 = message;
                }
                message = a2;
            }
        }
        return message;
    }

    private void m16802q(Message message) {
        PendingThreadSends a = this.f16769H.m16706a(m16810e(message));
        a.m16712a(message.n);
        Preconditions.checkArgument(Objects.equal(message.b, a.f16680a.a));
        if (!Objects.equal(message.n, a.f16685f)) {
            a.f16685f = message.n;
            a.f16687h = a.f16681b.now();
            a.f16686g = 0;
        }
    }

    private Message m16778a(PendingThreadSends pendingThreadSends) {
        if (pendingThreadSends.m16711a()) {
            return null;
        }
        long now = this.f16786f.now();
        long j = pendingThreadSends.f16688i;
        if (j == -1) {
            if (this.f16796p.a(ConnectionType.MQTT)) {
                pendingThreadSends.f16688i = 0;
                this.f16779R.a("SendMessageManager", "Message got queued for reconnection retry even when mqtt is connected.");
            }
            return null;
        } else if (now + 1000 < j) {
            return null;
        } else {
            Iterator it = pendingThreadSends.m16717o().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Message message = (Message) it.next();
            UploadState uploadState = ((MediaUploadManagerImpl) this.f16804x.get()).b(message).f11998b;
            switch (uploadState) {
                case NOT_ALL_STARTED:
                case FAILED:
                case SUCCEEDED:
                case NO_MEDIA_ITEMS:
                    return message;
                case IN_PROGRESS:
                    return null;
                default:
                    throw new IllegalStateException("Unknown state: " + uploadState);
            }
        }
    }

    private static void m16786a(Set<Message> set, Message message) {
        TracerDetour.a("SendMessageManager.removeEquivalentMessage", 354557608);
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Message message2 = (Message) it.next();
                if (!(StringUtil.a(message2.n) || StringUtil.a(message.n) || !Objects.equal(message2.n, message.n))) {
                    it.remove();
                }
            }
        } finally {
            TracerDetour.a(-4827097);
        }
    }

    @VisibleForTesting
    public final PendingSendQueueKey m16810e(Message message) {
        TracerDetour.a("SendMessageManager.queueKeyForMessage", -1958537032);
        try {
            PendingSendQueueKey pendingSendQueueKey;
            if (message.A != null) {
                pendingSendQueueKey = message.A;
            } else {
                pendingSendQueueKey = this.f16801u.m16835a(message.b, this.f16790j.a(message), this.f16769H);
                TracerDetour.a(1692232354);
            }
            return pendingSendQueueKey;
        } finally {
            TracerDetour.a(-1788367768);
        }
    }

    @VisibleForTesting
    public final boolean m16807b() {
        int i = 0;
        for (PendingThreadSends pendingThreadSends : this.f16769H.f16679b.values()) {
            i = pendingThreadSends.f16682c.size() + i;
        }
        return (i == 0 ? 1 : null) == null;
    }
}
