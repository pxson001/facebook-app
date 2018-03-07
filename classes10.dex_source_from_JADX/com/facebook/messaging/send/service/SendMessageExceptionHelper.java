package com.facebook.messaging.send.service;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.send.common.SendMessageException;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.HttpResponseException;

@Singleton
/* compiled from: record_audio */
public class SendMessageExceptionHelper {
    private static final Class<?> f3894a = SendMessageExceptionHelper.class;
    private static final Set<Integer> f3895b = ImmutableSet.of(Integer.valueOf(22), Integer.valueOf(23), Integer.valueOf(230), Integer.valueOf(368), Integer.valueOf(500), Integer.valueOf(501), new Integer[]{Integer.valueOf(502), Integer.valueOf(503), Integer.valueOf(504), Integer.valueOf(505), Integer.valueOf(506), Integer.valueOf(507), Integer.valueOf(508), Integer.valueOf(509)});
    private static volatile SendMessageExceptionHelper f3896g;
    private final AbstractFbErrorReporter f3897c;
    public final Clock f3898d;
    public final PaymentCurrencyUtil f3899e;
    private final Resources f3900f;

    /* compiled from: record_audio */
    public class FailedMessageBuilder {
        public final SendMessageExceptionHelper f3886a;
        public Message f3887b;
        private SendErrorType f3888c = SendErrorType.NONE;
        private SendChannel f3889d = SendChannel.UNKNOWN;
        @Nullable
        public String f3890e;
        @Nullable
        public String f3891f;
        @Nullable
        public String f3892g;
        public int f3893h;

        public FailedMessageBuilder(SendMessageExceptionHelper sendMessageExceptionHelper) {
            this.f3886a = sendMessageExceptionHelper;
        }

        public final FailedMessageBuilder m3645a(Message message) {
            this.f3887b = (Message) Preconditions.checkNotNull(message);
            return this;
        }

        public final FailedMessageBuilder m3646a(SendErrorType sendErrorType) {
            this.f3888c = (SendErrorType) Preconditions.checkNotNull(sendErrorType);
            return this;
        }

        public final FailedMessageBuilder m3644a(SendChannel sendChannel) {
            this.f3889d = (SendChannel) Preconditions.checkNotNull(sendChannel);
            return this;
        }

        public final Message m3643a() {
            MessageBuilder a = Message.newBuilder().a((Message) Preconditions.checkNotNull(this.f3887b, "original message is not set"));
            a.l = MessageType.FAILED_SEND;
            a = a.a(this.f3889d);
            SendErrorBuilder newBuilder = SendError.newBuilder();
            newBuilder.a = this.f3888c;
            newBuilder = newBuilder;
            newBuilder.b = this.f3890e;
            newBuilder = newBuilder;
            newBuilder.e = this.f3893h;
            newBuilder = newBuilder;
            newBuilder.c = this.f3886a.f3898d.a();
            newBuilder = newBuilder;
            newBuilder.d = this.f3891f;
            a.u = newBuilder.f();
            a = a;
            if (this.f3892g != null) {
                a.B = new PaymentTransactionData(this.f3892g, this.f3887b.b.e, this.f3887b.b.d, this.f3886a.f3899e.b(this.f3887b.u.c.a), this.f3887b.u.c.b);
            }
            return a.R();
        }
    }

    public static com.facebook.messaging.send.service.SendMessageExceptionHelper m3648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3896g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.send.service.SendMessageExceptionHelper.class;
        monitor-enter(r1);
        r0 = f3896g;	 Catch:{ all -> 0x003a }
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
        r0 = m3650b(r0);	 Catch:{ all -> 0x0035 }
        f3896g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3896g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.service.SendMessageExceptionHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.service.SendMessageExceptionHelper");
    }

    private static SendMessageExceptionHelper m3650b(InjectorLike injectorLike) {
        return new SendMessageExceptionHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) DbClock.a(injectorLike), PaymentCurrencyUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SendMessageExceptionHelper(AbstractFbErrorReporter abstractFbErrorReporter, Clock clock, PaymentCurrencyUtil paymentCurrencyUtil, Resources resources) {
        this.f3897c = abstractFbErrorReporter;
        this.f3898d = clock;
        this.f3899e = paymentCurrencyUtil;
        this.f3900f = resources;
    }

    public final SendMessageException m3651a(ApiException apiException, Message message, @Nullable String str, SendChannel sendChannel) {
        ApiErrorResult b = apiException.b();
        if (b == null) {
            return m3653a(apiException, message, sendChannel);
        }
        String a = ApiErrorResult.a(b.c());
        m3649a(a, b.a());
        FailedMessageBuilder a2 = m3654a();
        FailedMessageBuilder a3 = a2.m3645a(message).m3646a(SendErrorType.P2P_PAYMENT_FAILURE);
        a3.f3890e = a;
        a3 = a3;
        a3.f3892g = str;
        a3.m3644a(sendChannel);
        return new SendMessageException(apiException, a2.m3643a());
    }

    public final SendMessageException m3652a(Message message, Optional<String> optional, String str, SendChannel sendChannel) {
        String str2;
        FailedMessageBuilder a = m3654a();
        if (optional.isPresent()) {
            String string = this.f3900f.getString(2131240436);
            a.f3891f = (String) optional.get();
            str2 = string;
        } else {
            str2 = this.f3900f.getString(2131240437);
        }
        FailedMessageBuilder a2 = a.m3645a(message);
        a2.f3890e = str2;
        a2.m3646a(SendErrorType.P2P_PAYMENT_RISK_FAILURE).m3644a(sendChannel).f3892g = str;
        return new SendMessageException(str2, a.m3643a());
    }

    public final SendMessageException m3653a(Throwable th, Message message, SendChannel sendChannel) {
        if (th instanceof SendMessageException) {
            return (SendMessageException) th;
        }
        FailedMessageBuilder a = m3654a();
        a.m3645a(message).m3644a(sendChannel);
        return new SendMessageException(th, m3647a(th, a).m3643a());
    }

    private FailedMessageBuilder m3647a(Throwable th, FailedMessageBuilder failedMessageBuilder) {
        for (Throwable th2 : Throwables.getCausalChain(th)) {
            if (th2 instanceof ApiException) {
                ApiErrorResult b = ((ApiException) th2).b();
                if (b != null && f3895b.contains(Integer.valueOf(b.a()))) {
                    String c = b.c();
                    m3649a(c, b.a());
                    FailedMessageBuilder a = failedMessageBuilder.m3646a(SendErrorType.PERMANENT_FAILURE);
                    a.f3893h = b.a();
                    FailedMessageBuilder failedMessageBuilder2 = a;
                    failedMessageBuilder2.f3890e = c;
                    return failedMessageBuilder2;
                }
            } else if (th2 instanceof HttpResponseException) {
                int statusCode = ((HttpResponseException) th2).getStatusCode();
                if (statusCode >= 400 && statusCode < 500) {
                    return failedMessageBuilder.m3646a(SendErrorType.HTTP_4XX_ERROR);
                }
                if (statusCode >= 500) {
                    return failedMessageBuilder.m3646a(SendErrorType.HTTP_5XX_ERROR);
                }
            } else if (th2 instanceof IOException) {
                return failedMessageBuilder.m3646a(SendErrorType.IO_EXCEPTION);
            }
        }
        return failedMessageBuilder.m3646a(SendErrorType.OTHER);
    }

    private void m3649a(String str, int i) {
        if (StringUtil.a(str)) {
            this.f3897c.a("SendApiHandler_NULL_RETRYABLE_ERROR_MESSAGE", "Empty errStr for graph NO_RETRY error, errorNo=" + i);
        }
    }

    public final FailedMessageBuilder m3654a() {
        return new FailedMessageBuilder(this);
    }
}
