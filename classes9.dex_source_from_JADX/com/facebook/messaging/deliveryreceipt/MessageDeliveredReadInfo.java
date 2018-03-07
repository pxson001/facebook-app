package com.facebook.messaging.deliveryreceipt;

import com.facebook.messaging.model.messages.ParticipantInfo;
import java.util.List;

/* compiled from: markThreadsParams */
public class MessageDeliveredReadInfo {
    public final Type f10858a;
    public List<RowReceiptParticipant> f10859b;
    public ParticipantInfo f10860c;
    public long f10861d;

    /* compiled from: markThreadsParams */
    public enum Type {
        READER,
        SENDER,
        DELIVEREE
    }

    public MessageDeliveredReadInfo(Type type) {
        this(type, -1);
    }

    public MessageDeliveredReadInfo(Type type, long j) {
        this.f10858a = type;
        this.f10861d = j;
    }

    public final List<RowReceiptParticipant> m11287a() {
        if (this.f10858a == Type.READER) {
            return this.f10859b;
        }
        return null;
    }
}
