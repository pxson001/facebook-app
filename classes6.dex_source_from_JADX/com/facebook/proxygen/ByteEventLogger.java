package com.facebook.proxygen;

/* compiled from: time_since_original_post */
public interface ByteEventLogger {
    void onBytesReceived(String str, long j);

    void onBytesSent(String str, long j);
}
