package com.facebook.media.upload.video;

/* compiled from: keywordMode */
public class InvalidOffsetException extends Exception {
    private final long mNewEndOffset;
    private final long mNewStartOffset;

    public InvalidOffsetException(Throwable th, long j, long j2) {
        super(th);
        this.mNewStartOffset = j;
        this.mNewEndOffset = j2;
    }

    public final long m18860a() {
        return this.mNewStartOffset;
    }

    public final long m18861b() {
        return this.mNewEndOffset;
    }
}
