package com.facebook.proxygen.utils;

/* compiled from: sponsored_page_attachment_length */
public class LogSample {
    private final String mMessage;
    private final long mTimeStamp;

    public LogSample(long j, String str) {
        this.mTimeStamp = j;
        this.mMessage = str;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
