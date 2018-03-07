package com.facebook.video.server;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.ThrottlingConfig;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;

/* compiled from: page_swipe_end */
public class ThrottlingPolicyFactory {

    /* compiled from: page_swipe_end */
    public enum ThrottlingPolicyType {
        ZERO("zero"),
        BANDWIDTH("bandwidth"),
        VIDEO_BUFFER_MANAGER("vbm"),
        VIDEO_PLAYER_SESSION("vps");
        
        public final String value;

        private ThrottlingPolicyType(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public static ThrottlingPolicyFactory m5874a(InjectorLike injectorLike) {
        return new ThrottlingPolicyFactory();
    }

    public static ThrottlingPolicy m5873a(ThrottlingConfig throttlingConfig, MonotonicClock monotonicClock, VideoPlayerSessionManager videoPlayerSessionManager, FbDataConnectionManager fbDataConnectionManager) {
        ThrottlingPolicyType valueOf;
        try {
            valueOf = ThrottlingPolicyType.valueOf(throttlingConfig.f5507c);
        } catch (IllegalArgumentException e) {
            valueOf = ThrottlingPolicyType.ZERO;
        }
        switch (valueOf) {
            case BANDWIDTH:
                return new VideoBandwidthBasedThrottlingPolicy(throttlingConfig, monotonicClock);
            case VIDEO_PLAYER_SESSION:
                return new VideoPlayerSessionManagerBasedThrottlingPolicy(monotonicClock, videoPlayerSessionManager, throttlingConfig, fbDataConnectionManager);
            default:
                return new VideoZeroThrottlingPolicy();
        }
    }
}
