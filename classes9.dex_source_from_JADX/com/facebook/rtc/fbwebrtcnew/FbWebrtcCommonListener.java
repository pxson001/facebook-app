package com.facebook.rtc.fbwebrtcnew;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.webrtc.ConferenceCall;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.WebrtcManager;

@UserScoped
/* compiled from: application/x-hdmlc */
public class FbWebrtcCommonListener implements Listener, IWebrtcUiInterface {
    private static final Object f19692e = new Object();
    private final FbWebrtcEngine f19693a;
    private final QeAccessor f19694b;
    private final boolean f19695c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19696d = UltralightRuntime.b;

    private static FbWebrtcCommonListener m19506b(InjectorLike injectorLike) {
        FbWebrtcCommonListener fbWebrtcCommonListener = new FbWebrtcCommonListener(FbWebrtcEngine.m19507a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        fbWebrtcCommonListener.f19696d = IdBasedLazy.a(injectorLike, 10375);
        return fbWebrtcCommonListener;
    }

    @Inject
    private FbWebrtcCommonListener(FbWebrtcEngine fbWebrtcEngine, QeAccessor qeAccessor) {
        this.f19693a = fbWebrtcEngine;
        this.f19694b = qeAccessor;
        this.f19695c = this.f19694b.a(ExperimentsForRtcModule.C, false);
    }

    public void webRTCControlRPC_StartOutgoingCall(long j, boolean z) {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_StartOutgoingCall(j, z);
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_StartOutgoingCall(j, z);
    }

    public void webRTCControlRPC_AcceptIncomingCall(long j) {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_AcceptIncomingCall(j);
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_AcceptIncomingCall(j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener m19505a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f19692e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m19506b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19692e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f19692e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtcnew.FbWebrtcCommonListener");
    }

    public void webRTCControlRPC_EnableVideo() {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_EnableVideo();
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_EnableVideo();
    }

    public void webRTCControlRPC_DisableVideo() {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_DisableVideo();
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_DisableVideo();
    }

    public void webRTCControlRPC_ToggleSpeakerPhone() {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_ToggleSpeakerPhone();
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_ToggleSpeakerPhone();
    }

    public void webRTCControlRPC_VolumeUp() {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_VolumeUp();
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_VolumeUp();
    }

    public void webRTCControlRPC_VolumeDown() {
        if (this.f19695c) {
            this.f19693a.webRTCControlRPC_VolumeDown();
        }
        ((WebrtcUiHandler) this.f19696d.get()).webRTCControlRPC_VolumeDown();
    }

    public void forceStarRating() {
        if (this.f19695c) {
            this.f19693a.forceStarRating();
        }
        ((WebrtcUiHandler) this.f19696d.get()).forceStarRating();
    }

    public void handleError(int i) {
        if (this.f19695c) {
            this.f19693a.handleError(i);
        }
        ((WebrtcUiHandler) this.f19696d.get()).handleError(i);
    }

    public void initializeCall(long j, long j2, boolean z) {
        if (this.f19695c) {
            this.f19693a.initializeCall(j, j2, z);
        }
        ((WebrtcUiHandler) this.f19696d.get()).initializeCall(j, j2, z);
    }

    public void switchToContactingUI() {
        if (this.f19695c) {
            this.f19693a.switchToContactingUI();
        }
        ((WebrtcUiHandler) this.f19696d.get()).switchToContactingUI();
    }

    public void switchToRingingUI() {
        if (this.f19695c) {
            this.f19693a.switchToRingingUI();
        }
        ((WebrtcUiHandler) this.f19696d.get()).switchToRingingUI();
    }

    public void switchToIncomingCallUI(long j, long j2, boolean z, boolean z2, String str) {
        if (this.f19695c) {
            this.f19693a.switchToIncomingCallUI(j, j2, z, z2, str);
        }
        ((WebrtcUiHandler) this.f19696d.get()).switchToIncomingCallUI(j, j2, z, z2, str);
    }

    public void switchToStreamingUI(boolean z, String str) {
        if (this.f19695c) {
            this.f19693a.switchToStreamingUI(z, str);
        }
        ((WebrtcUiHandler) this.f19696d.get()).switchToStreamingUI(z, str);
    }

    public void showConnectionDetails(boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4) {
        if (this.f19695c) {
            this.f19693a.showConnectionDetails(z, z2, z3, i, i2, i3, z4);
        }
        ((WebrtcUiHandler) this.f19696d.get()).showConnectionDetails(z, z2, z3, i, i2, i3, z4);
    }

    public void hideCallUI(int i, long j, boolean z, String str) {
        if (this.f19695c) {
            this.f19693a.hideCallUI(i, j, z, str);
        }
        ((WebrtcUiHandler) this.f19696d.get()).hideCallUI(i, j, z, str);
    }

    public void localMediaStateChanged(boolean z, boolean z2, boolean z3) {
        if (this.f19695c) {
            this.f19693a.localMediaStateChanged(z, z2, z3);
        }
        ((WebrtcUiHandler) this.f19696d.get()).localMediaStateChanged(z, z2, z3);
    }

    public void remoteMediaStateChanged(boolean z, boolean z2, boolean z3) {
        if (this.f19695c) {
            this.f19693a.remoteMediaStateChanged(z, z2, z3);
        }
        ((WebrtcUiHandler) this.f19696d.get()).remoteMediaStateChanged(z, z2, z3);
    }

    public void updateStatesAndCallDuration() {
        if (this.f19695c) {
            this.f19693a.updateStatesAndCallDuration();
        }
        ((WebrtcUiHandler) this.f19696d.get()).updateStatesAndCallDuration();
    }

    public void onIncomingMissedCall(long j, long j2) {
        if (this.f19695c) {
            this.f19693a.onIncomingMissedCall(j, j2);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onIncomingMissedCall(j, j2);
    }

    public void onPingAckMessageReceived(long j, long j2) {
        if (this.f19695c) {
            this.f19693a.onPingAckMessageReceived(j, j2);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onPingAckMessageReceived(j, j2);
    }

    public void onDataReceived(String str) {
        if (this.f19695c) {
            this.f19693a.onDataReceived(str);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onDataReceived(str);
    }

    public void updateRemoteVideoSupport(boolean z, long j) {
        if (this.f19695c) {
            this.f19693a.updateRemoteVideoSupport(z, j);
        }
        ((WebrtcUiHandler) this.f19696d.get()).updateRemoteVideoSupport(z, j);
    }

    public void addRemoteVideoTrack(String str, String str2, long j) {
        if (this.f19695c) {
            this.f19693a.addRemoteVideoTrack(str, str2, j);
        }
        ((WebrtcUiHandler) this.f19696d.get()).addRemoteVideoTrack(str, str2, j);
    }

    public void removeRemoteVideoTrack(String str, String str2, long j) {
        if (this.f19695c) {
            this.f19693a.removeRemoteVideoTrack(str, str2, j);
        }
        ((WebrtcUiHandler) this.f19696d.get()).removeRemoteVideoTrack(str, str2, j);
    }

    public void onEscalationRequest(boolean z) {
        if (this.f19695c) {
            this.f19693a.onEscalationRequest(z);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onEscalationRequest(z);
    }

    public void onEscalationResponse(boolean z) {
        if (this.f19695c) {
            this.f19693a.onEscalationResponse(z);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onEscalationResponse(z);
    }

    public void onEscalationSuccess() {
        if (this.f19695c) {
            this.f19693a.onEscalationSuccess();
        }
        ((WebrtcUiHandler) this.f19696d.get()).onEscalationSuccess();
    }

    public void onEscalationTimeout() {
        if (this.f19695c) {
            this.f19693a.onEscalationTimeout();
        }
        ((WebrtcUiHandler) this.f19696d.get()).onEscalationTimeout();
    }

    public void onRemoteVideoSizeChanged(int i, int i2) {
        if (this.f19695c) {
            this.f19693a.onRemoteVideoSizeChanged(i, i2);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onRemoteVideoSizeChanged(i, i2);
    }

    public void onIncomingCall(ConferenceCall conferenceCall, String str, String[] strArr, int i) {
        if (this.f19695c) {
            this.f19693a.onIncomingCall(conferenceCall, str, strArr, i);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onIncomingCall(conferenceCall, str, strArr, i);
    }

    public void onCallJoined(ConferenceCall conferenceCall, String[] strArr) {
        if (this.f19695c) {
            this.f19693a.onCallJoined(conferenceCall, strArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onCallJoined(conferenceCall, strArr);
    }

    public void OnUserStateUpdate(ConferenceCall conferenceCall, String[] strArr, int[] iArr) {
        if (this.f19695c) {
            this.f19693a.OnUserStateUpdate(conferenceCall, strArr, iArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).OnUserStateUpdate(conferenceCall, strArr, iArr);
    }

    public void onMediaConnectionUpdate(ConferenceCall conferenceCall, boolean z) {
        if (this.f19695c) {
            this.f19693a.onMediaConnectionUpdate(conferenceCall, z);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onMediaConnectionUpdate(conferenceCall, z);
    }

    public void onMediaStatusUpdate(ConferenceCall conferenceCall, long[] jArr, String[] strArr, String[] strArr2, int[] iArr, boolean[] zArr) {
        if (this.f19695c) {
            this.f19693a.onMediaStatusUpdate(conferenceCall, jArr, strArr, strArr2, iArr, zArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onMediaStatusUpdate(conferenceCall, jArr, strArr, strArr2, iArr, zArr);
    }

    public void onDataMessage(ConferenceCall conferenceCall, String str, String str2, byte[] bArr) {
        if (this.f19695c) {
            this.f19693a.onDataMessage(conferenceCall, str, str2, bArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onDataMessage(conferenceCall, str, str2, bArr);
    }

    public void onDominantSpeakerUpdate(ConferenceCall conferenceCall, String str, String str2) {
        if (this.f19695c) {
            this.f19693a.onDominantSpeakerUpdate(conferenceCall, str, str2);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onDominantSpeakerUpdate(conferenceCall, str, str2);
    }

    public void onCallEnded(ConferenceCall conferenceCall, int i, String str) {
        if (this.f19695c) {
            this.f19693a.onCallEnded(conferenceCall, i, str);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onCallEnded(conferenceCall, i, str);
    }

    public void onActiveAudioLevels(String[] strArr, int[] iArr) {
        if (this.f19695c) {
            this.f19693a.onActiveAudioLevels(strArr, iArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onActiveAudioLevels(strArr, iArr);
    }

    public void onAudioLevel(int i, int i2) {
        if (this.f19695c) {
            this.f19693a.onAudioLevel(i, i2);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onAudioLevel(i, i2);
    }

    public void onSnakeGameUpdate(byte[] bArr) {
        if (this.f19695c) {
            this.f19693a.onSnakeGameUpdate(bArr);
        }
        ((WebrtcUiHandler) this.f19696d.get()).onSnakeGameUpdate(bArr);
    }

    public void setWebrtcManager(WebrtcManager webrtcManager) {
        ((WebrtcUiHandler) this.f19696d.get()).setWebrtcManager(webrtcManager);
    }
}
