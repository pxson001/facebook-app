package com.facebook.messaging.send.client;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.MessagesBroadcaster$ThreadUpdateCause;
import com.facebook.messaging.cache.ThreadsCache;
import com.facebook.messaging.database.handlers.DbSendHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: deletePaymentCardId */
public class PostSendMessageManager {
    private final DbSendHandler f16701a;
    private final ThreadsCache f16702b;
    private final MessagesBroadcaster f16703c;
    private final MessageUtil f16704d;
    private final AbstractFbErrorReporter f16705e;
    public final SendLifeCycleManager f16706f;
    private final DefaultAndroidThreadUtil f16707g;
    private final AggregatedReliabilityLogger f16708h;

    public final void m16736a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams, NewMessageResult newMessageResult) {
        m16729a(sendMessageToPendingThreadParams.f17320a, newMessageResult);
    }

    @Inject
    public PostSendMessageManager(DbSendHandler dbSendHandler, @Assisted ThreadsCache threadsCache, MessagesBroadcaster messagesBroadcaster, MessageUtil messageUtil, AbstractFbErrorReporter abstractFbErrorReporter, SendLifeCycleManager sendLifeCycleManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AggregatedReliabilityLogger aggregatedReliabilityLogger) {
        this.f16701a = dbSendHandler;
        this.f16702b = threadsCache;
        this.f16703c = messagesBroadcaster;
        this.f16704d = messageUtil;
        this.f16705e = abstractFbErrorReporter;
        this.f16706f = sendLifeCycleManager;
        this.f16707g = defaultAndroidThreadUtil;
        this.f16708h = aggregatedReliabilityLogger;
    }

    public final void m16735a(SendMessageParams sendMessageParams, NewMessageResult newMessageResult) {
        m16729a(sendMessageParams.f17308a, newMessageResult);
    }

    private void m16729a(Message message, NewMessageResult newMessageResult) {
        Throwable th;
        Message message2;
        Throwable th2;
        ThreadKey threadKey = newMessageResult.m17162c().b;
        try {
            NewMessageResult a = this.f16701a.m11032a(newMessageResult);
            if (a != null) {
                Message c = a.m17162c();
                try {
                    m16730a(threadKey, c, a.m17163d(), a.m17164e());
                } catch (Throwable e) {
                    th = e;
                    message2 = c;
                    th2 = th;
                }
            }
        } catch (Throwable e2) {
            th = e2;
            message2 = null;
            th2 = th;
            String str = "Unable to save message send to local db. message id: %s";
            Object[] objArr = new Object[1];
            objArr[0] = message2 != null ? message2.a : message.n;
            this.f16705e.a("save_send_failed", StringFormatUtil.a(str, objArr), th2);
            this.f16703c.a(threadKey);
        }
    }

    public final void m16732a(Message message, @Nullable MessagesCollection messagesCollection, @Nullable ThreadSummary threadSummary) {
        if (messagesCollection == null) {
            messagesCollection = MessagesCollection.a(message);
        }
        m16730a(message.b, message, messagesCollection, threadSummary);
        if (!Strings.isNullOrEmpty(message.n)) {
            m16731a(message.n, 203);
        }
    }

    private void m16730a(ThreadKey threadKey, @Nullable Message message, @Nullable MessagesCollection messagesCollection, @Nullable ThreadSummary threadSummary) {
        this.f16702b.a(message, messagesCollection, -1);
        if (threadSummary != null) {
            this.f16702b.a(threadSummary);
        }
        if (message != null) {
            MessagesBroadcaster$ThreadUpdateCause messagesBroadcaster$ThreadUpdateCause = MessagesBroadcaster$ThreadUpdateCause.MESSAGE_SENT;
            if (MessageUtil.Q(message)) {
                messagesBroadcaster$ThreadUpdateCause = MessagesBroadcaster$ThreadUpdateCause.STICKER_SENT;
            }
            this.f16703c.a(threadKey, MessagesBroadcaster.a(messagesBroadcaster$ThreadUpdateCause, message.a));
            this.f16703c.a(message.a, message.n);
            return;
        }
        this.f16703c.a(threadKey);
    }

    public final void m16734a(SendMessageException sendMessageException, boolean z) {
        Message message = sendMessageException.failedMessage;
        if (!z || message.w.b.shouldNotBeRetried) {
            this.f16708h.a(message.n, !message.w.b.shouldNotBeRetried);
            if (message.w.b.shouldNotBeRetried) {
                this.f16703c.b(message);
            } else {
                this.f16703c.a(message);
            }
            try {
                this.f16701a.m11038c(message);
                this.f16702b.a(sendMessageException.failedMessage);
            } catch (Throwable e) {
                this.f16705e.a("save_send_failed", StringFormatUtil.a("Unable to save message send failure to local db. message id: %s", new Object[]{message.a}), e);
            }
            this.f16703c.a(message.b);
        }
    }

    public final void m16733a(SendMessageException sendMessageException) {
        Message message = sendMessageException.failedMessage;
        this.f16703c.b(message);
        this.f16702b.a(message);
        this.f16703c.a(message.b);
        if (!Strings.isNullOrEmpty(message.n)) {
            m16731a(message.n, 204);
        }
    }

    public final void m16737b(SendMessageException sendMessageException) {
        this.f16705e.a("send_to_pending_thread_failed", StringFormatUtil.a("Unable to send message to pending thread. message offline id: %s", new Object[]{sendMessageException.failedMessage.n}), sendMessageException);
    }

    private void m16731a(final String str, final int i) {
        this.f16707g.b(new Runnable(this) {
            final /* synthetic */ PostSendMessageManager f16700c;

            public void run() {
                this.f16700c.f16706f.m16769b(str, i);
            }
        });
    }
}
