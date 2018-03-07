package com.facebook.videocodec.base;

/* compiled from: reviews_feed_impression */
public class CodecNotSupportedException extends VideoTranscoderException {
    public CodecNotSupportedException(String str) {
        super(str);
    }

    public static CodecNotSupportedException m8157a(String str) {
        return new CodecNotSupportedException("Unsupported codec for " + str);
    }
}
