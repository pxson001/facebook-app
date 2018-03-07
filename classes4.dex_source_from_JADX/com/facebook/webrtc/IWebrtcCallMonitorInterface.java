package com.facebook.webrtc;

/* compiled from: latency_class */
public interface IWebrtcCallMonitorInterface {
    void onCallEnded(long j, long j2, long j3);

    void onCallStarted(long j);

    void onInitializingCall(long j);
}
