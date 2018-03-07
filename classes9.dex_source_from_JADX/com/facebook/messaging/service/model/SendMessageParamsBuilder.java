package com.facebook.messaging.service.model;

import com.facebook.common.util.TriState;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.messaging.model.messages.Message;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: contact_batch_upload */
public class SendMessageParamsBuilder {
    public Message f17314a;
    private TriState f17315b = TriState.UNSET;
    private FbTraceNode f17316c = FbTraceNode.a;
    public int f17317d = -1;
    public long f17318e = -1;
    public long f17319f = -1;

    SendMessageParamsBuilder() {
    }

    public final SendMessageParams m17182a() {
        Preconditions.checkNotNull(this.f17314a);
        Preconditions.checkArgument(this.f17315b.isSet());
        return new SendMessageParams(this.f17314a, this.f17315b.asBoolean(), this.f17316c, this.f17317d, this.f17318e, this.f17319f);
    }

    public final SendMessageParamsBuilder m17186a(Message message) {
        this.f17314a = message;
        return this;
    }

    public final SendMessageParamsBuilder m17187a(boolean z) {
        this.f17315b = TriState.valueOf(z);
        return this;
    }

    public final SendMessageParamsBuilder m17185a(FbTraceNode fbTraceNode) {
        this.f17316c = fbTraceNode;
        return this;
    }

    public final SendMessageParamsBuilder m17183a(int i) {
        this.f17317d = i;
        return this;
    }

    public final SendMessageParamsBuilder m17184a(long j) {
        this.f17318e = j;
        return this;
    }

    public final SendMessageParamsBuilder m17188b(long j) {
        this.f17319f = j;
        return this;
    }
}
