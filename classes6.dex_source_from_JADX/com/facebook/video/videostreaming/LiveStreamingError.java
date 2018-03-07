package com.facebook.video.videostreaming;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Arrays;

@DoNotStrip
/* compiled from: save_profile_question */
public class LiveStreamingError {
    public final Exception f5368a;
    @DoNotStrip
    public final String descripton;
    @DoNotStrip
    public final String domain;
    @DoNotStrip
    public final int errorCode;
    @DoNotStrip
    public final String fullDescription;
    @DoNotStrip
    public final String reason;

    public LiveStreamingError(Exception exception) {
        this.f5368a = exception;
        this.errorCode = -1;
        this.domain = exception.getClass().getCanonicalName();
        this.reason = exception.getMessage();
        this.descripton = exception.getMessage();
        this.fullDescription = Arrays.toString(exception.getStackTrace());
    }

    @DoNotStrip
    public LiveStreamingError(int i, String str, String str2, String str3, String str4) {
        this.errorCode = i;
        this.domain = str;
        this.reason = str2;
        this.descripton = str3;
        this.fullDescription = str4;
        this.f5368a = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error:");
        stringBuilder.append(this.errorCode);
        stringBuilder.append(", Domain:");
        stringBuilder.append(this.domain);
        stringBuilder.append(", Reason:");
        stringBuilder.append(this.reason);
        stringBuilder.append(", Description:");
        stringBuilder.append(this.descripton);
        stringBuilder.append(", Full Description:");
        stringBuilder.append(this.fullDescription);
        return stringBuilder.toString();
    }
}
