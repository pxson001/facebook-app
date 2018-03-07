package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;

/* compiled from: platform_web_view */
public class RowTypingItem implements RowItem {
    public final ParticipantInfo f4774a;
    public final Message f4775b;
    public final boolean f4776c;

    public RowTypingItem(ParticipantInfo participantInfo, Message message, boolean z) {
        this.f4774a = participantInfo;
        this.f4775b = message;
        this.f4776c = z;
    }

    public final RowType mo131b() {
        return RowType.TYPING;
    }

    public final long m4331a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowTypingItem{otherUser=" + this.f4774a.c + '}';
    }
}
