package com.facebook.webrtc;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: location_opt_in_intro_page_impression */
public class ConferenceCall {
    @DoNotStrip
    private HybridData mHybridData;

    /* compiled from: location_opt_in_intro_page_impression */
    public interface Listener {
        void OnUserStateUpdate(ConferenceCall conferenceCall, String[] strArr, int[] iArr);

        void onCallEnded(ConferenceCall conferenceCall, int i, String str);

        void onCallJoined(ConferenceCall conferenceCall, String[] strArr);

        void onDataMessage(ConferenceCall conferenceCall, String str, String str2, byte[] bArr);

        void onDominantSpeakerUpdate(ConferenceCall conferenceCall, String str, String str2);

        void onIncomingCall(ConferenceCall conferenceCall, String str, String[] strArr, int i);

        void onMediaConnectionUpdate(ConferenceCall conferenceCall, boolean z);

        void onMediaStatusUpdate(ConferenceCall conferenceCall, long[] jArr, String[] strArr, String[] strArr2, int[] iArr, boolean[] zArr);
    }

    public native void call(String[] strArr);

    public native long callId();

    public native int callType();

    public native String conferenceName();

    public native void configureAudio(boolean z);

    public native void configureVideo(boolean z);

    public native void inviteParticipants(String[] strArr);

    public native boolean isVideoEnabled();

    public native void join();

    public native void join(String str);

    public native void leave(int i);

    public native void removeParticipants(String[] strArr);

    public native void sendDataMessage(String str, String[] strArr, byte[] bArr);

    public native void setCameraId(String str);

    public native boolean subscribeSingleRemoteVideoStream(String str, String str2, long j);

    public final boolean m11550a() {
        return callType() == 0;
    }

    @DoNotStrip
    private ConferenceCall(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
