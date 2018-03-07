package com.facebook.video.videostreaming;

/* compiled from: sample_app */
public enum LiveStreamingNetworkState {
    NORMAL,
    WEAK,
    SHOULD_STOP_STREAMING;

    public static LiveStreamingNetworkState fromInteger(int i) {
        switch (i) {
            case 0:
                return NORMAL;
            case 1:
                return WEAK;
            case 2:
                return SHOULD_STOP_STREAMING;
            default:
                return null;
        }
    }
}
