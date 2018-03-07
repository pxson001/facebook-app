package com.facebook.http.debug;

import android.annotation.SuppressLint;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@SuppressLint({"UsingDefaultJsonDeserializer"})
/* compiled from: not a valid textual representation */
public final class ByteTransferCounter {
    @JsonProperty("recvd")
    public long recvd;
    @JsonProperty("sent")
    public long sent;

    public final String toString() {
        return StringLocaleUtil.m21640a("%s sent, %s recvd", m17903a(this.sent), m17903a(this.recvd));
    }

    @VisibleForTesting
    public static String m17903a(long j) {
        int i = 0;
        Preconditions.checkArgument(j >= 0, "can't format negative byte counts");
        String[] strArr = new String[]{"KiB", "MiB", "GiB", "TiB"};
        double d = ((double) j) / 1024.0d;
        while (d >= 1024.0d && i + 1 < 4) {
            i++;
            d /= 1024.0d;
        }
        return StringFormatUtil.formatStrLocaleSafe("%.01f %s", Double.valueOf(d), strArr[i]);
    }
}
