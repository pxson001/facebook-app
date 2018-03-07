package com.facebook.messaging.bugreporter.foldercounts;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: largeFaceImage */
public class MarkFolderSeenResult {
    @Nullable
    final Throwable f9629a;
    final Channel f9630b;
    final boolean f9631c;
    @Nullable
    final String f9632d;

    public MarkFolderSeenResult(Throwable th, Channel channel, String str, boolean z) {
        this.f9629a = th;
        this.f9630b = (Channel) Preconditions.checkNotNull(channel);
        this.f9632d = str;
        this.f9631c = z;
    }

    public static MarkFolderSeenResult m10071a(Channel channel) {
        return new MarkFolderSeenResult(null, channel, null, true);
    }

    public static MarkFolderSeenResult m10073a(Throwable th, Channel channel) {
        return new MarkFolderSeenResult(th, channel, null, false);
    }

    public static MarkFolderSeenResult m10072a(Channel channel, String str) {
        return new MarkFolderSeenResult(null, channel, str, true);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exception=");
        stringBuilder.append(this.f9629a != null ? this.f9629a.getMessage() : "null");
        stringBuilder.append(",errorDescription=");
        stringBuilder.append(this.f9632d);
        stringBuilder.append(",channel=");
        stringBuilder.append(this.f9630b);
        stringBuilder.append(",success=");
        stringBuilder.append(this.f9631c);
        return stringBuilder.toString();
    }
}
