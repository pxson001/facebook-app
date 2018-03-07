package com.facebook.video.videostreaming;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: schedule_buttons */
public interface AndroidRTMPSessionCallbacks {
    @DoNotStrip
    void completedSpeedTestWithStatus(NetworkSpeedTest networkSpeedTest);

    @DoNotStrip
    void didDropPackets(String str);

    @DoNotStrip
    void didFailWithError(LiveStreamingError liveStreamingError);

    @DoNotStrip
    void didFinish();

    @DoNotStrip
    void didStartWithSpeedTestStatus(NetworkSpeedTest networkSpeedTest);

    @DoNotStrip
    void didUpdateStreamingInfo(String str);

    @DoNotStrip
    void willReconnectDueToError(LiveStreamingError liveStreamingError);

    @DoNotStrip
    void writeDidTimeout();
}
