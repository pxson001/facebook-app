package com.facebook.messaging.media.upload;

import com.facebook.messaging.model.messages.Message;
import java.util.concurrent.Callable;

/* compiled from: launch_mode_extra */
class TwoPhaseSendHandler$3 implements Callable<Boolean> {
    final /* synthetic */ Message f12066a;
    final /* synthetic */ String f12067b;
    final /* synthetic */ TwoPhaseSendHandler f12068c;

    TwoPhaseSendHandler$3(TwoPhaseSendHandler twoPhaseSendHandler, Message message, String str) {
        this.f12068c = twoPhaseSendHandler;
        this.f12066a = message;
        this.f12067b = str;
    }

    public Object call() {
        return (Boolean) this.f12068c.d.a(this.f12068c.c, new UpdateMessageForHiResMethod$Params(this.f12066a.b.i(), this.f12067b));
    }
}
