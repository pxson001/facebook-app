package com.facebook.messaging.tincan.crypto;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: close_session_fail */
public class ProcessAcceptPayloadResult {
    public final boolean f17885a;
    @Nullable
    public final byte[] f17886b;
    @Nullable
    public final String f17887c;
    @Nullable
    public final String f17888d;

    ProcessAcceptPayloadResult(boolean z, @Nullable byte[] bArr, @Nullable String str, @Nullable String str2) {
        if (z) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
        }
        this.f17885a = z;
        this.f17886b = bArr;
        this.f17887c = str;
        this.f17888d = str2;
    }

    public static ProcessAcceptPayloadResult m17896a() {
        return new ProcessAcceptPayloadResult(false, null, null, null);
    }
}
