package com.facebook.video.videostreaming;

import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.rtmpssl.AndroidRtmpSSLFactoryHolder;
import com.facebook.video.videostreaming.LiveStreamer.C03191;
import com.facebook.video.videostreaming.LiveStreamer.C03202;
import com.facebook.video.videostreaming.LiveStreamer.C03213;
import com.facebook.video.videostreaming.LiveStreamer.C03224;
import com.facebook.video.videostreaming.NetworkSpeedTest.Status;
import com.facebook.xanalytics.XAnalyticsNative;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: scenario_first_run */
public class AndroidLiveStreamingSession {
    private static final ObjectMapper f5285a = new ObjectMapper();
    public static final String f5286b = AndroidLiveStreamingSession.class.getName();
    private final WeakReference<LiveStreamer> f5287c;
    @DoNotStrip
    private final NativeAndroidRTMPSessionCallbacks mCallbacks;
    @DoNotStrip
    private final HybridData mHybridData;
    @DoNotStrip
    private final JsonNode mJsonConfig;
    @DoNotStrip
    private final AndroidRtmpSSLFactoryHolder mRtmpSSLFactoryHolder;
    @DoNotStrip
    private final XAnalyticsNative mXAnalyticsNative;

    @DoNotStrip
    /* compiled from: scenario_first_run */
    class NativeAndroidRTMPSessionCallbacks implements AndroidRTMPSessionCallbacks {
        final /* synthetic */ AndroidLiveStreamingSession f5284a;

        public void completedSpeedTestWithStatus(NetworkSpeedTest networkSpeedTest) {
            String str = AndroidLiveStreamingSession.f5286b;
            networkSpeedTest.state.name();
            Integer.valueOf((int) networkSpeedTest.bandwidth);
            Long.valueOf(networkSpeedTest.timeTaken);
            Boolean.valueOf(networkSpeedTest.speedTestPassesThreshold);
            LiveStreamer c = AndroidLiveStreamingSession.m7996c(this.f5284a);
            if (c != null && c.f5326m != null) {
                HandlerDetour.a(c.f5336w, new C03213(c, networkSpeedTest), 1455151514);
            }
        }

        public void didFinish() {
            String str = AndroidLiveStreamingSession.f5286b;
        }

        public void didStartWithSpeedTestStatus(NetworkSpeedTest networkSpeedTest) {
            String str = AndroidLiveStreamingSession.f5286b;
            LiveStreamer c = AndroidLiveStreamingSession.m7996c(this.f5284a);
            if (c != null) {
                if (c.f5325l != null) {
                    HandlerDetour.a(c.f5336w, new C03191(c), -2096682707);
                }
                if (networkSpeedTest.state == Status.Ignored && c.f5326m != null) {
                    HandlerDetour.a(c.f5336w, new C03202(c), 753031399);
                }
            }
        }

        public void didUpdateStreamingInfo(String str) {
            String str2 = AndroidLiveStreamingSession.f5286b;
        }

        public void writeDidTimeout() {
            String str = AndroidLiveStreamingSession.f5286b;
        }

        public NativeAndroidRTMPSessionCallbacks(AndroidLiveStreamingSession androidLiveStreamingSession) {
            this.f5284a = androidLiveStreamingSession;
        }

        public void didFailWithError(LiveStreamingError liveStreamingError) {
            BLog.b(AndroidLiveStreamingSession.f5286b, "Broadcast Failed with error %s", new Object[]{liveStreamingError});
            LiveStreamer c = AndroidLiveStreamingSession.m7996c(this.f5284a);
            if (liveStreamingError.domain.equals("RTMP_SESSION_ERROR_DOMAIN") && liveStreamingError.errorCode == 4) {
                if (c != null) {
                    c.m8046b(liveStreamingError);
                }
            } else if (c != null) {
                if (c.f5325l != null) {
                    HandlerDetour.a(c.f5336w, new C03224(c, liveStreamingError), 2065563889);
                }
            }
        }

        public void willReconnectDueToError(LiveStreamingError liveStreamingError) {
            BLog.b(AndroidLiveStreamingSession.f5286b, "Broadcast Failed with error %s", new Object[]{liveStreamingError});
            LiveStreamer c = AndroidLiveStreamingSession.m7996c(this.f5284a);
            if (c != null) {
                c.m8046b(liveStreamingError);
            }
        }

        public void didDropPackets(String str) {
            LiveStreamer c = AndroidLiveStreamingSession.m7996c(this.f5284a);
            if (c != null) {
                c.m8046b(new LiveStreamingError(new Exception(str)));
            }
            String str2 = AndroidLiveStreamingSession.f5286b;
        }
    }

    private native HybridData initHybrid(String str, AndroidRTMPSessionCallbacks androidRTMPSessionCallbacks, XAnalyticsNative xAnalyticsNative, AndroidRtmpSSLFactoryHolder androidRtmpSSLFactoryHolder);

    public native void close();

    public native double computeNewBitrate(double d, Map<String, String> map);

    public native int getABRComputeInterval();

    public native int getCurrentNetworkState();

    public native boolean hasNetworkRecoveredFromWeak();

    public native boolean isNetworkWeak();

    public native void sendAudioData(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5);

    public native void sendStreamInterrupted();

    public native void sendVideoData(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5);

    private static AndroidLiveStreamingSession m7997d() {
        return new AndroidLiveStreamingSession();
    }

    static {
        SoLoader.a("android-live-streaming");
        f5285a.a(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    }

    public static AndroidLiveStreamingSession m7992a(InjectorLike injectorLike) {
        return m7997d();
    }

    @Inject
    public AndroidLiveStreamingSession() {
        this.mHybridData = null;
        this.mJsonConfig = null;
        this.mCallbacks = null;
        this.f5287c = null;
        this.mXAnalyticsNative = null;
        this.mRtmpSSLFactoryHolder = null;
    }

    public AndroidLiveStreamingSession(LiveStreamer liveStreamer, JsonNode jsonNode, DefaultXAnalyticsProvider defaultXAnalyticsProvider, AndroidRtmpSSLFactoryHolder androidRtmpSSLFactoryHolder) {
        this.f5287c = new WeakReference(liveStreamer);
        this.mCallbacks = new NativeAndroidRTMPSessionCallbacks(this);
        this.mJsonConfig = jsonNode;
        this.mXAnalyticsNative = defaultXAnalyticsProvider.r_();
        String str = "";
        this.mRtmpSSLFactoryHolder = androidRtmpSSLFactoryHolder;
        try {
            str = m7994a(this.mJsonConfig);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.mHybridData = initHybrid(str, this.mCallbacks, this.mXAnalyticsNative, this.mRtmpSSLFactoryHolder);
    }

    public final void m7998a() {
        this.mXAnalyticsNative.flush();
    }

    private static String m7994a(JsonNode jsonNode) {
        return f5285a.a(f5285a.a(jsonNode, Object.class));
    }

    @Nullable
    public static LiveStreamer m7996c(AndroidLiveStreamingSession androidLiveStreamingSession) {
        if (androidLiveStreamingSession.f5287c != null) {
            return (LiveStreamer) androidLiveStreamingSession.f5287c.get();
        }
        return null;
    }
}
