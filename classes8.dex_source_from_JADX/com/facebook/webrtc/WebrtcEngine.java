package com.facebook.webrtc;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.log.BLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface.AudioOutputRoute;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: location_opt_in_intro_get_started_tapped */
public class WebrtcEngine {
    private static final Class<?> f9830a = WebrtcEngine.class;
    private static boolean f9831b;
    public static boolean f9832c;
    @DoNotStrip
    private HybridData mHybridData;

    private static native HybridData initHybrid(IWebrtcSignalingMessageInterface iWebrtcSignalingMessageInterface, IWebrtcUiInterface iWebrtcUiInterface, IWebrtcConfigInterface iWebrtcConfigInterface, IWebrtcLoggingInterface iWebrtcLoggingInterface, IWebrtcCallMonitorInterface iWebrtcCallMonitorInterface, Context context, Listener listener, WebrtcCrashReporter webrtcCrashReporter);

    private native void setAudioOutputRoute(int i);

    public native void acceptCall(String str, boolean z, boolean z2, boolean z3);

    public native ConferenceCall createConferenceHandle(String str, String str2);

    public native void endCall(long j, int i);

    public native void handleMultiwaySignalingMessage(String str, byte[] bArr);

    public native String makeKeyPairAndCertificate();

    public native void onMessageSendError(long j, long j2, int i, String str, String str2);

    public native void onMessageSendSuccess(long j, long j2);

    public native void onMultiwayMessageSendError(String str, String str2, int i, String str3, String str4);

    public native void onMultiwayMessageSendSuccess(String str, String str2);

    public native void onThriftMessageFromPeer(String str, byte[] bArr, String str2);

    public native void sendData(String str);

    public native void sendEscalationRequest(boolean z, String str);

    public native void sendEscalationResponse(boolean z, String str);

    public native void sendEscalationSuccess();

    public native void sendSnakeGameCommand(byte[] bArr);

    public native void setAudioOn(boolean z);

    public native void setBluetoothState(boolean z);

    public native void setCameraId(String str);

    public native void setMediaState(boolean z, boolean z2, boolean z3);

    public native void setRendererWindow(long j, View view);

    public native void setSelfRendererWindow(SurfaceView surfaceView);

    public native void setSpeakerOn(boolean z);

    public native void setSupportedCallTypes(String[] strArr);

    public native void setVideoOn(boolean z);

    public native void setVideoParameters(int i, int i2, int i3, int i4, int i5, int i6);

    public native void startCall(long j, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3);

    public native void startCustomCall(long j, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4);

    public native void startCustomCallToDevice(long j, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, long j2, String str4, String str5);

    public native void startInstantVideoCall(long j, long j2, String str, String str2, String str3, String str4);

    public WebrtcEngine(Context context, AbstractFbErrorReporter abstractFbErrorReporter, IWebrtcSignalingMessageInterface iWebrtcSignalingMessageInterface, IWebrtcUiInterface iWebrtcUiInterface, IWebrtcConfigInterface iWebrtcConfigInterface, IWebrtcLoggingInterface iWebrtcLoggingInterface, IWebrtcCallMonitorInterface iWebrtcCallMonitorInterface, Listener listener, WebrtcCrashReporter webrtcCrashReporter) {
        Preconditions.checkNotNull(iWebrtcSignalingMessageInterface);
        Preconditions.checkNotNull(iWebrtcConfigInterface);
        Preconditions.checkNotNull(iWebrtcUiInterface);
        Preconditions.checkNotNull(iWebrtcLoggingInterface);
        Preconditions.checkNotNull(iWebrtcCallMonitorInterface);
        Preconditions.checkNotNull(listener);
        Preconditions.checkNotNull(webrtcCrashReporter);
        if (m11552a(abstractFbErrorReporter)) {
            this.mHybridData = initHybrid(iWebrtcSignalingMessageInterface, iWebrtcUiInterface, iWebrtcConfigInterface, iWebrtcLoggingInterface, iWebrtcCallMonitorInterface, context, listener, webrtcCrashReporter);
        }
    }

    public static boolean m11551a() {
        return f9832c;
    }

    public final void m11554b() {
        if (this.mHybridData != null) {
            this.mHybridData.resetNative();
        }
    }

    public final void m11553a(AudioOutputRoute audioOutputRoute) {
        setAudioOutputRoute(audioOutputRoute.ordinal());
    }

    @VisibleForTesting
    private static boolean m11552a(AbstractFbErrorReporter abstractFbErrorReporter) {
        if (!f9831b) {
            f9831b = true;
            try {
                SoLoader.a("gnustl_shared");
                SoLoader.a("fb");
                SoLoader.a("fb");
                SoLoader.a("sslx");
                SoLoader.a("fb_webrtc_jni");
                f9832c = true;
            } catch (Throwable th) {
                f9832c = false;
                abstractFbErrorReporter.a("webrtc", "Failed to load webrtc native library.", th);
                BLog.a(f9830a, "native library not available", th);
            }
        }
        return f9832c;
    }
}
