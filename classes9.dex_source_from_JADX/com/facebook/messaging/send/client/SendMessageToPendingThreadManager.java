package com.facebook.messaging.send.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.SameThreadExecutor;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.PendingThreadsManager.PendingThreadException;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserSmsIdentifier;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: default_ride_estimate_information */
public class SendMessageToPendingThreadManager implements IHaveUserData {
    private static final Object f16822r = new Object();
    private final DefaultBlueServiceOperationFactory f16823a;
    private final Lazy<ScheduledExecutorService> f16824b;
    @SameThreadExecutor
    private final Lazy<Executor> f16825c;
    public final DefaultAndroidThreadUtil f16826d;
    private final PendingThreadsManager f16827e;
    public final ConnectionStatusMonitor f16828f;
    private final AnalyticsLogger f16829g;
    private final MediaUploadManagerImpl f16830h;
    private final MessageClassifier f16831i;
    private final BaseFbBroadcastManager f16832j;
    private final Lazy<FbErrorReporter> f16833k;
    private final Lazy<SendFailureNotifier> f16834l;
    private final SelfRegistrableReceiverImpl f16835m;
    @GuardedBy("ui_thread")
    public final Map<ThreadKey, PendingThreadRequests> f16836n = new HashMap();
    @GuardedBy("ui_thread")
    private final Map<ThreadKey, PendingThreadRequests> f16837o = new HashMap();
    public final List<ScheduledFuture<?>> f16838p = new LinkedList();
    private final Map<String, SettableFuture<SendToPendingThreadResult>> f16839q = new HashMap();

    /* compiled from: default_ride_estimate_information */
    class C19801 implements ActionReceiver {
        final /* synthetic */ SendMessageToPendingThreadManager f16807a;

        C19801(SendMessageToPendingThreadManager sendMessageToPendingThreadManager) {
            this.f16807a = sendMessageToPendingThreadManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 990566546);
            if (this.f16807a.f16828f.a(ConnectionType.MQTT)) {
                SendMessageToPendingThreadManager.m16822a(this.f16807a);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 54364781, a);
        }
    }

    /* compiled from: default_ride_estimate_information */
    class C19812 implements ActionReceiver {
        final /* synthetic */ SendMessageToPendingThreadManager f16808a;

        C19812(SendMessageToPendingThreadManager sendMessageToPendingThreadManager) {
            this.f16808a = sendMessageToPendingThreadManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1031509282);
            SendMessageToPendingThreadManager.m16822a(this.f16808a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1410673743, a);
        }
    }

    /* compiled from: default_ride_estimate_information */
    class C19845 implements Runnable {
        final /* synthetic */ SendMessageToPendingThreadManager f16814a;

        C19845(SendMessageToPendingThreadManager sendMessageToPendingThreadManager) {
            this.f16814a = sendMessageToPendingThreadManager;
        }

        public void run() {
            this.f16814a.f16836n.clear();
            SendMessageToPendingThreadManager sendMessageToPendingThreadManager = this.f16814a;
            sendMessageToPendingThreadManager.f16826d.a();
            for (ScheduledFuture cancel : sendMessageToPendingThreadManager.f16838p) {
                cancel.cancel(true);
            }
            sendMessageToPendingThreadManager.f16838p.clear();
        }
    }

    /* compiled from: default_ride_estimate_information */
    public class PendingThreadRequests implements Iterable<Message> {
        public final ThreadKey f16816a;
        public final List<Message> f16817b = new LinkedList();
        public int f16818c;

        public PendingThreadRequests(ThreadKey threadKey) {
            this.f16816a = threadKey;
        }

        @Nullable
        final Message m16814a() {
            return this.f16817b.isEmpty() ? null : (Message) this.f16817b.get(0);
        }

        public Iterator<Message> iterator() {
            return this.f16817b.iterator();
        }

        final boolean m16815b() {
            return this.f16818c > 0;
        }
    }

    /* compiled from: default_ride_estimate_information */
    public class SendToPendingThreadResult {
        public final Message f16819a;
        @Nullable
        public final ThreadKey f16820b;
        public final boolean f16821c;

        public SendToPendingThreadResult(Message message, @Nullable ThreadKey threadKey, boolean z) {
            this.f16819a = message;
            this.f16820b = threadKey;
            this.f16821c = z;
        }
    }

    private static SendMessageToPendingThreadManager m16826b(InjectorLike injectorLike) {
        return new SendMessageToPendingThreadManager(DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedSingletonScopeProvider.b(injectorLike, 4494), DefaultAndroidThreadUtil.b(injectorLike), PendingThreadsManager.m16721a(injectorLike), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), MediaUploadManagerImpl.a(injectorLike), MessageClassifier.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 8345));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.SendMessageToPendingThreadManager m16816a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16822r;	 Catch:{ all -> 0x006c }
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
        r1 = m16826b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16822r;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendMessageToPendingThreadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.SendMessageToPendingThreadManager) r0;	 Catch:{  }
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
        r0 = f16822r;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendMessageToPendingThreadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendMessageToPendingThreadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.SendMessageToPendingThreadManager");
    }

    @Inject
    public SendMessageToPendingThreadManager(BlueServiceOperationFactory blueServiceOperationFactory, Lazy<ScheduledExecutorService> lazy, Lazy<Executor> lazy2, AndroidThreadUtil androidThreadUtil, PendingThreadsManager pendingThreadsManager, ConnectionStatusMonitor connectionStatusMonitor, AnalyticsLogger analyticsLogger, MediaUploadManager mediaUploadManager, MessageClassifier messageClassifier, FbBroadcastManager fbBroadcastManager, Lazy<FbErrorReporter> lazy3, Lazy<SendFailureNotifier> lazy4) {
        this.f16823a = blueServiceOperationFactory;
        this.f16824b = lazy;
        this.f16825c = lazy2;
        this.f16826d = androidThreadUtil;
        this.f16827e = pendingThreadsManager;
        this.f16828f = connectionStatusMonitor;
        this.f16829g = analyticsLogger;
        this.f16830h = mediaUploadManager;
        this.f16831i = messageClassifier;
        this.f16832j = fbBroadcastManager;
        this.f16833k = lazy3;
        this.f16834l = lazy4;
        this.f16832j.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", new C19801(this));
        this.f16835m = this.f16832j.a().a("com.facebook.orca.media.upload.MEDIA_UPLOAD_STATUS_CHANGED", new C19812(this)).a();
        this.f16835m.b();
    }

    @VisibleForTesting
    final ListenableFuture<SendToPendingThreadResult> m16829a(Message message) {
        this.f16826d.a();
        ThreadKey threadKey = message.b;
        Preconditions.checkArgument(ThreadKey.f(threadKey));
        PendingThreadRequests pendingThreadRequests = (PendingThreadRequests) this.f16836n.get(threadKey);
        if (pendingThreadRequests == null) {
            pendingThreadRequests = new PendingThreadRequests(threadKey);
            this.f16836n.put(threadKey, pendingThreadRequests);
        }
        pendingThreadRequests.f16817b.add(message);
        SettableFuture f = SettableFuture.f();
        this.f16839q.put(message.n, f);
        m16822a(this);
        return f;
    }

    private void m16818a(Message message, @Nullable ThreadKey threadKey, boolean z) {
        this.f16826d.a();
        SettableFuture settableFuture = (SettableFuture) this.f16839q.remove(message.n);
        if (settableFuture != null) {
            FutureDetour.a(settableFuture, new SendToPendingThreadResult(message, threadKey, z), 1023097339);
        }
    }

    private void m16820a(Message message, Throwable th) {
        this.f16826d.a();
        SettableFuture settableFuture = (SettableFuture) this.f16839q.remove(message.n);
        if (settableFuture != null) {
            settableFuture.a(th);
        }
    }

    private void m16827b(final Message message) {
        ImmutableList c = this.f16827e.m16727c(message.b);
        Builder builder = ImmutableList.builder();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            builder.c(m16817a(((ParticipantInfo) c.get(i)).b));
        }
        SendMessageToPendingThreadParamsBuilder sendMessageToPendingThreadParamsBuilder = new SendMessageToPendingThreadParamsBuilder();
        sendMessageToPendingThreadParamsBuilder.f17323a = message;
        sendMessageToPendingThreadParamsBuilder = sendMessageToPendingThreadParamsBuilder;
        sendMessageToPendingThreadParamsBuilder.f17324b = ImmutableList.copyOf(builder.b());
        sendMessageToPendingThreadParamsBuilder = sendMessageToPendingThreadParamsBuilder;
        Preconditions.checkNotNull(sendMessageToPendingThreadParamsBuilder.f17323a);
        Preconditions.checkArgument(sendMessageToPendingThreadParamsBuilder.f17323a.b.f());
        Preconditions.checkNotNull(sendMessageToPendingThreadParamsBuilder.f17324b);
        Preconditions.checkArgument(sendMessageToPendingThreadParamsBuilder.f17324b.size() >= 2);
        SendMessageToPendingThreadParams sendMessageToPendingThreadParams = new SendMessageToPendingThreadParams(sendMessageToPendingThreadParamsBuilder.f17323a, sendMessageToPendingThreadParamsBuilder.f17324b, sendMessageToPendingThreadParamsBuilder.f17325c);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sendMessageToPendingThreadParams", sendMessageToPendingThreadParams);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f16823a, "send_to_pending_thread", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(SendMessageToPendingThreadManager.class), -1779913313).a(), new OperationResultFutureCallback2(this) {
            final /* synthetic */ SendMessageToPendingThreadManager f16810b;

            public final void m16811a(OperationResult operationResult) {
                try {
                    SendMessageToPendingThreadManager.m16823a(this.f16810b, message, ((NewMessageResult) operationResult.h()).m17162c().b);
                } catch (Throwable e) {
                    m16813a(e);
                }
            }

            protected final void m16813a(Throwable th) {
                SendMessageToPendingThreadManager.m16824a(this.f16810b, th, message);
            }
        }, (Executor) this.f16825c.get());
    }

    public static void m16822a(SendMessageToPendingThreadManager sendMessageToPendingThreadManager) {
        sendMessageToPendingThreadManager.f16826d.a();
        boolean a = sendMessageToPendingThreadManager.f16828f.a(ConnectionType.MQTT);
        for (ThreadKey threadKey : sendMessageToPendingThreadManager.f16836n.keySet()) {
            PendingThreadRequests pendingThreadRequests = (PendingThreadRequests) sendMessageToPendingThreadManager.f16836n.get(threadKey);
            if ((a || !pendingThreadRequests.m16815b() || Math.random() <= 0.5d) && sendMessageToPendingThreadManager.m16825a(pendingThreadRequests)) {
                sendMessageToPendingThreadManager.f16836n.remove(threadKey);
                sendMessageToPendingThreadManager.f16837o.put(threadKey, pendingThreadRequests);
                Message a2 = pendingThreadRequests.m16814a();
                Preconditions.checkNotNull(a2);
                try {
                    sendMessageToPendingThreadManager.m16827b(sendMessageToPendingThreadManager.f16830h.c(a2));
                } catch (PendingThreadException e) {
                    sendMessageToPendingThreadManager.m16819a(a2, e);
                }
            }
        }
    }

    private boolean m16825a(PendingThreadRequests pendingThreadRequests) {
        Message a = pendingThreadRequests.m16814a();
        if (a == null) {
            return false;
        }
        switch (this.f16830h.b(a).f11998b) {
            case NOT_ALL_STARTED:
            case FAILED:
                this.f16830h.a(a);
                return false;
            case SUCCEEDED:
            case NO_MEDIA_ITEMS:
                return true;
            default:
                return false;
        }
    }

    private boolean m16828b(PendingThreadRequests pendingThreadRequests) {
        int i = pendingThreadRequests.f16818c + 1;
        pendingThreadRequests.f16818c = i;
        if (((long) i) >= 3) {
            return false;
        }
        Message a = pendingThreadRequests.m16814a();
        if (a != null && a.w != null && a.w.b.shouldNotBeRetried) {
            return false;
        }
        if ((this.f16831i.a(a) == MessageClassification.VIDEO_CLIP && this.f16830h.b(a).f11998b == UploadState.FAILED) || this.f16831i.a(a) == MessageClassification.PAYMENT) {
            return false;
        }
        return true;
    }

    public static void m16823a(SendMessageToPendingThreadManager sendMessageToPendingThreadManager, Message message, ThreadKey threadKey) {
        sendMessageToPendingThreadManager.f16826d.a();
        try {
            PendingThreadRequests pendingThreadRequests = (PendingThreadRequests) sendMessageToPendingThreadManager.f16837o.remove(message.b);
            sendMessageToPendingThreadManager.f16827e.m16724a(message.b, threadKey);
            Iterator it = pendingThreadRequests.iterator();
            while (it.hasNext()) {
                Message message2 = (Message) it.next();
                sendMessageToPendingThreadManager.m16818a(message2, threadKey, message2 == pendingThreadRequests.m16814a());
            }
        } catch (PendingThreadException e) {
            sendMessageToPendingThreadManager.m16819a(message, e);
        }
    }

    public static void m16824a(SendMessageToPendingThreadManager sendMessageToPendingThreadManager, Throwable th, Message message) {
        sendMessageToPendingThreadManager.f16826d.a();
        final ThreadKey threadKey = message.b;
        final PendingThreadRequests pendingThreadRequests = (PendingThreadRequests) sendMessageToPendingThreadManager.f16837o.remove(threadKey);
        if (sendMessageToPendingThreadManager.m16828b(pendingThreadRequests)) {
            sendMessageToPendingThreadManager.f16838p.add(((ScheduledExecutorService) sendMessageToPendingThreadManager.f16824b.get()).schedule(new Runnable(sendMessageToPendingThreadManager) {
                final /* synthetic */ SendMessageToPendingThreadManager f16813c;

                public void run() {
                    this.f16813c.f16836n.put(threadKey, pendingThreadRequests);
                    SendMessageToPendingThreadManager.m16822a(this.f16813c);
                }
            }, 30000, TimeUnit.MILLISECONDS));
            return;
        }
        try {
            sendMessageToPendingThreadManager.m16821a(pendingThreadRequests.f16816a, th);
            Iterator it = pendingThreadRequests.iterator();
            while (it.hasNext()) {
                sendMessageToPendingThreadManager.m16820a((Message) it.next(), th);
            }
            sendMessageToPendingThreadManager.f16827e.m16726b(pendingThreadRequests.f16816a);
            ((SendFailureNotifier) sendMessageToPendingThreadManager.f16834l.get()).m16761c(message);
        } catch (PendingThreadException e) {
            sendMessageToPendingThreadManager.m16819a(message, e);
        }
    }

    public void clearUserData() {
        this.f16835m.c();
        ExecutorDetour.a((ScheduledExecutorService) this.f16824b.get(), new C19845(this), -1552367756);
    }

    private void m16821a(ThreadKey threadKey, Throwable th) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("send_to_pending_thread_failure");
        honeyClientEvent.a("pending_thread_id", threadKey.c);
        if (th != null) {
            honeyClientEvent.b("error_message", th.getMessage());
        }
        this.f16829g.a(honeyClientEvent);
    }

    private void m16819a(Message message, PendingThreadException pendingThreadException) {
        ((AbstractFbErrorReporter) this.f16833k.get()).a("SendMessageToPendingThreadManager", "PendingThreadsManager doesn't have pending thread key: " + message.b, pendingThreadException);
    }

    private static UserIdentifier m16817a(UserKey userKey) {
        if (userKey.a() == Type.FACEBOOK) {
            return new UserFbidIdentifier(userKey.b());
        }
        if (userKey.a() == Type.PHONE_NUMBER) {
            return new UserSmsIdentifier(userKey.b(), userKey.g());
        }
        throw new IllegalArgumentException("Unsupported UserKey type.");
    }
}
