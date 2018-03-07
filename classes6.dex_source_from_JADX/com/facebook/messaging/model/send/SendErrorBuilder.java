package com.facebook.messaging.model.send;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: uploadPoll */
public class SendErrorBuilder {
    public SendErrorType f2174a;
    public String f2175b;
    public long f2176c;
    public String f2177d;
    public int f2178e;

    public final SendErrorBuilder m3465a(SendErrorType sendErrorType) {
        this.f2174a = sendErrorType;
        return this;
    }

    public final SendErrorBuilder m3466a(@Nullable String str) {
        this.f2175b = str;
        return this;
    }

    public final SendErrorBuilder m3464a(long j) {
        this.f2176c = j;
        return this;
    }

    public final SendError m3467f() {
        return new SendError(this);
    }
}
