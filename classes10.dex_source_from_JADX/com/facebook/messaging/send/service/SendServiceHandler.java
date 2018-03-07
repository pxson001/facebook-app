package com.facebook.messaging.send.service;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.SmsMessages;
import com.facebook.messaging.database.handlers.DbSendHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.send.client.PostSendMessageManager;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.service.methods.SendMessageMethod;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.messaging.sms.defaultapp.send.SmsSender;
import com.facebook.messaging.sms.util.HighestTimestampUtil;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.zero.DefaultZeroMessageSendHandler;
import com.facebook.zero.ZeroMessageSendHandler;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@UserScoped
/* compiled from: recents_tab_null_state_shown */
public class SendServiceHandler implements BlueServiceHandler {
    private static final Object f3915n = new Object();
    private final Lazy<SendApiHandler> f3916a;
    private final SendMessageExceptionHelper f3917b;
    private final DbSendHandler f3918c;
    private final ApiMethodRunnerImpl f3919d;
    private final SendMessageMethod f3920e;
    private final ZeroMessageSendHandler f3921f;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<Clock> f3922g = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<SmsSender> f3923h = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    private Lazy<HighestTimestampUtil> f3924i = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    @FacebookMessages
    private Lazy<PostSendMessageManager> f3925j = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    @SmsMessages
    private Lazy<PostSendMessageManager> f3926k = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    @FacebookMessages
    private Lazy<CacheInsertThreadsHandler> f3927l = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    @SmsMessages
    private Lazy<CacheInsertThreadsHandler> f3928m = UltralightRuntime.b;

    private static SendServiceHandler m3674b(InjectorLike injectorLike) {
        SendServiceHandler sendServiceHandler = new SendServiceHandler(DbSendHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 8352), SendMessageExceptionHelper.m3648a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), SendMessageMethod.b(injectorLike), (ZeroMessageSendHandler) DefaultZeroMessageSendHandler.a(injectorLike));
        sendServiceHandler.m3671a(IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedLazy.a(injectorLike, 8474), IdBasedLazy.a(injectorLike, 8486), IdBasedLazy.a(injectorLike, 8343), IdBasedLazy.a(injectorLike, 8344), IdBasedLazy.a(injectorLike, 7693), IdBasedLazy.a(injectorLike, 7694));
        return sendServiceHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.service.SendServiceHandler m3670a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3915n;	 Catch:{ all -> 0x006c }
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
        r1 = m3674b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3915n;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.service.SendServiceHandler) r0;	 Catch:{  }
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
        r0 = f3915n;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.service.SendServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.service.SendServiceHandler");
    }

    private OperationResult m3673b(OperationParams operationParams) {
        Message message = (Message) operationParams.c.getParcelable("outgoingMessage");
        if (ThreadKey.d(message.b)) {
            long a = ((Clock) this.f3922g.get()).a();
            if (message.b.i() > 0) {
                a = Math.max(((HighestTimestampUtil) this.f3924i.get()).a(message.b.b) + 1, a);
            }
            MessageBuilder a2 = Message.newBuilder().a(message);
            a2.c = a;
            a2 = a2;
            a2.d = a;
            Message R = a2.R();
            String a3 = ((SmsSender) this.f3923h.get()).a(R, true);
            ((CacheInsertThreadsHandler) this.f3928m.get()).a(R);
        } else {
            m3672a(message, true);
        }
        return OperationResult.a;
    }

    private OperationResult m3676d(OperationParams operationParams) {
        this.f3919d.a(this.f3920e, (Message) operationParams.c.getParcelable("broadcastMessage"));
        return OperationResult.a;
    }

    private OperationResult m3677e(OperationParams operationParams) {
        this.f3919d.a(this.f3920e, (Message) operationParams.c.getParcelable("montageMessage"));
        return OperationResult.a;
    }

    @Inject
    public SendServiceHandler(DbSendHandler dbSendHandler, Lazy<SendApiHandler> lazy, SendMessageExceptionHelper sendMessageExceptionHelper, ApiMethodRunner apiMethodRunner, SendMessageMethod sendMessageMethod, ZeroMessageSendHandler zeroMessageSendHandler) {
        this.f3918c = dbSendHandler;
        this.f3916a = lazy;
        this.f3917b = sendMessageExceptionHelper;
        this.f3919d = apiMethodRunner;
        this.f3920e = sendMessageMethod;
        this.f3921f = zeroMessageSendHandler;
    }

    private void m3671a(Lazy<Clock> lazy, Lazy<SmsSender> lazy2, Lazy<HighestTimestampUtil> lazy3, Lazy<PostSendMessageManager> lazy4, Lazy<PostSendMessageManager> lazy5, Lazy<CacheInsertThreadsHandler> lazy6, Lazy<CacheInsertThreadsHandler> lazy7) {
        this.f3922g = lazy;
        this.f3923h = lazy2;
        this.f3924i = lazy3;
        this.f3925j = lazy4;
        this.f3926k = lazy5;
        this.f3927l = lazy6;
        this.f3928m = lazy7;
    }

    public final OperationResult m3680a(OperationParams operationParams) {
        TracerDetour.a("SendDataServiceHandler", -1517984830);
        try {
            OperationResult b;
            String a = operationParams.a();
            if ("insert_pending_sent_message".equals(a)) {
                b = m3673b(operationParams);
            } else if ("send".equals(a)) {
                b = m3675c(operationParams);
                TracerDetour.a(10, -333426226);
            } else if ("broadcast_message".equals(a)) {
                b = m3676d(operationParams);
                TracerDetour.a(10, -371273369);
            } else if ("send_to_montage".equals(a)) {
                b = m3677e(operationParams);
                TracerDetour.a(10, -788540583);
            } else if ("sms_mms_sent".equals(a)) {
                b = m3678f(operationParams);
                TracerDetour.a(10, 665928859);
            } else if ("send_to_pending_thread".equals(a)) {
                b = m3679g(operationParams);
                TracerDetour.a(10, -1563801731);
            } else {
                throw new IllegalArgumentException("Unknown operation type: " + a);
            }
            return b;
        } finally {
            TracerDetour.a(10, -735906357);
        }
    }

    @VisibleForTesting
    private OperationResult m3675c(OperationParams operationParams) {
        SendMessageParams sendMessageParams = (SendMessageParams) operationParams.b().getParcelable("sendMessageParams");
        Message message = sendMessageParams.a;
        Preconditions.checkState(!ThreadKey.d(message.b));
        if (!message.t.isEmpty()) {
            m3672a(message, false);
        }
        Message a = m3669a(message);
        this.f3918c.a();
        ThreadKey threadKey = a.b;
        try {
            ((PostSendMessageManager) this.f3925j.get()).a(sendMessageParams, ((SendApiHandler) this.f3916a.get()).m3641a(sendMessageParams));
            return OperationResult.a();
        } catch (Throwable th) {
            ((PostSendMessageManager) this.f3925j.get()).a(this.f3917b.m3653a(th, a, SendChannel.UNKNOWN), sendMessageParams.b);
        }
    }

    private void m3672a(Message message, boolean z) {
        if (z) {
            this.f3918c.b(message);
        } else {
            this.f3918c.a(message);
        }
        ((CacheInsertThreadsHandler) this.f3927l.get()).a(message);
    }

    private OperationResult m3678f(OperationParams operationParams) {
        Message message = (Message) operationParams.c.getParcelable("message");
        if (SendError.a.equals(message.w)) {
            ((PostSendMessageManager) this.f3926k.get()).a(message, null, null);
        } else {
            ((PostSendMessageManager) this.f3926k.get()).a(new SendMessageException(message.w.b.serializedString, message));
        }
        return OperationResult.a;
    }

    private OperationResult m3679g(OperationParams operationParams) {
        SendMessageToPendingThreadParams sendMessageToPendingThreadParams = (SendMessageToPendingThreadParams) operationParams.b().getParcelable("sendMessageToPendingThreadParams");
        Message a = sendMessageToPendingThreadParams.a();
        Preconditions.checkState(ThreadKey.f(a.b));
        Preconditions.checkState(!ThreadKey.d(a.b));
        try {
            NewMessageResult a2 = ((SendApiHandler) this.f3916a.get()).m3642a(sendMessageToPendingThreadParams);
            ((PostSendMessageManager) this.f3925j.get()).a(sendMessageToPendingThreadParams, a2);
            return OperationResult.a(a2);
        } catch (Throwable th) {
            ((PostSendMessageManager) this.f3925j.get()).b(this.f3917b.m3653a(th, a, SendChannel.UNKNOWN));
        }
    }

    private static Message m3669a(Message message) {
        if (message.t.isEmpty()) {
            return message;
        }
        int[] iArr = new int[Source.values().length];
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            int ordinal = ((MediaResource) immutableList.get(i)).e.ordinal();
            iArr[ordinal] = iArr[ordinal] + 1;
        }
        MessageBuilder a = Message.newBuilder().a(message);
        for (ordinal = 0; ordinal < iArr.length; ordinal++) {
            if (iArr[ordinal] != 0) {
                a.a(Source.values()[ordinal].toString(), Integer.toString(iArr[ordinal]));
            }
        }
        return a.R();
    }
}
