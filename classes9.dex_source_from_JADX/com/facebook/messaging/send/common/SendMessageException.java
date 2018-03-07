package com.facebook.messaging.send.common;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.google.common.base.Preconditions;

/* compiled from: defaultPaymentAmount */
public class SendMessageException extends Exception {
    public final Message failedMessage;

    public SendMessageException(String str, Message message) {
        super(str);
        this.failedMessage = m16836a(message);
    }

    public SendMessageException(Throwable th, Message message) {
        super(th);
        this.failedMessage = m16836a(message);
    }

    public SendMessageException(String str, Throwable th, Message message) {
        super(str, th);
        this.failedMessage = m16836a(message);
    }

    private static Message m16836a(Message message) {
        Preconditions.checkNotNull(message);
        Preconditions.checkArgument(message.l == MessageType.FAILED_SEND);
        return message;
    }

    public final SendError m16837a() {
        return this.failedMessage.w;
    }

    public final SendErrorType m16838b() {
        return this.failedMessage.w.b;
    }
}
