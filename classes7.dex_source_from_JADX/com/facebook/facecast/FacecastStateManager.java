package com.facebook.facecast;

import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.video.videostreaming.LiveStreamingError;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: c4bc4a115c0fcfec2d21c5585979fb6f */
public class FacecastStateManager {
    private final FacecastAnalyticsLogger f18047a;
    public volatile FacecastBroadcastState f18048b = FacecastBroadcastState.FACECAST_BROADCAST_STATE_UNINITIALIZED;
    public volatile FacecastBroadcastState f18049c = FacecastBroadcastState.FACECAST_BROADCAST_STATE_UNINITIALIZED;
    public List<FacecastStateChangeListener> f18050d = new ArrayList();

    /* compiled from: c4bc4a115c0fcfec2d21c5585979fb6f */
    public interface FacecastStateChangeListener {
        void mo1385a(FacecastBroadcastState facecastBroadcastState, FacecastBroadcastState facecastBroadcastState2);
    }

    /* compiled from: c4bc4a115c0fcfec2d21c5585979fb6f */
    public enum FacecastBroadcastState {
        FACECAST_BROADCAST_STATE_OFFLINE("offline"),
        FACECAST_BROADCAST_STATE_IMPORT_FROM_GALLERY("import_from_gallery"),
        FACECAST_BROADCAST_STATE_UNINITIALIZED("uninitialized"),
        FACECAST_BROADCAST_STATE_STARTING("starting"),
        FACECAST_BROADCAST_STATE_FAILED("failed"),
        FACECAST_BROADCAST_STATE_RECORDING("recording"),
        FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH("about_to_finish"),
        FACECAST_BROADCAST_STATE_FINISHED("finished"),
        FACECAST_BROADCAST_STATE_SHOW_END_SCREEN("show_end_screen"),
        FACECAST_BROADCAST_STATE_INTERRUPTED("interrupted"),
        FACECAST_BROADCAST_STATE_COPYRIGHT_VIOLATION("copyright_violation"),
        FACECAST_BROADCAST_STATE_SEAL_BROADCAST_REQUEST("seal_broadcast_request"),
        FACECAST_BROADCAST_STATE_NETWORK_FAILURE("network_failure");
        
        public final String loggerName;

        private FacecastBroadcastState(String str) {
            this.loggerName = str;
        }
    }

    public static FacecastStateManager m21879b(InjectorLike injectorLike) {
        return new FacecastStateManager(FacecastAnalyticsLogger.m21959a(injectorLike));
    }

    public static FacecastStateManager m21878a(InjectorLike injectorLike) {
        return m21879b(injectorLike);
    }

    @Inject
    public FacecastStateManager(FacecastAnalyticsLogger facecastAnalyticsLogger) {
        this.f18047a = facecastAnalyticsLogger;
    }

    public final void m21882a(FacecastStateChangeListener facecastStateChangeListener) {
        this.f18050d.add(facecastStateChangeListener);
    }

    public final void m21884b(FacecastStateChangeListener facecastStateChangeListener) {
        this.f18050d.remove(facecastStateChangeListener);
    }

    public final void m21883b(FacecastBroadcastState facecastBroadcastState) {
        m21880a(facecastBroadcastState, null);
    }

    public final void m21881a(FacecastBroadcastState facecastBroadcastState, @Nullable String str, @Nullable LiveStreamingError liveStreamingError) {
        this.f18049c = this.f18048b;
        this.f18048b = facecastBroadcastState;
        this.f18047a.m21964a(this.f18049c.loggerName, facecastBroadcastState.loggerName, str, liveStreamingError, null);
        for (FacecastStateChangeListener a : this.f18050d) {
            a.mo1385a(this.f18048b, this.f18049c);
        }
    }

    public final void m21880a(FacecastBroadcastState facecastBroadcastState, @Nullable String str) {
        m21881a(facecastBroadcastState, str, null);
    }
}
