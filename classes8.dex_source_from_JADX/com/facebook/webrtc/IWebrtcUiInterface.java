package com.facebook.webrtc;

/* compiled from: location_opt_in_intro_not_now_tapped */
public interface IWebrtcUiInterface {

    /* compiled from: location_opt_in_intro_not_now_tapped */
    public enum AudioOutputRoute {
        AudioOutputRouteBluetooth,
        AudioOutputRouteHeadset,
        AudioOutputRouteEarpiece,
        AudioOutputRouteSpeakerphone
    }

    /* compiled from: location_opt_in_intro_not_now_tapped */
    public enum EndCallReason {
        CallEndIgnoreCall,
        CallEndHangupCall,
        CallEndInAnotherCall,
        CallEndAcceptAfterHangUp,
        CallEndNoAnswerTimeout,
        CallEndIncomingTimeout,
        CallEndOtherInstanceHandled,
        CallEndSignalingMessageFailed,
        CallEndConnectionDropped,
        CallEndClientInterrupted,
        CallEndWebRTCError,
        CallEndClientError,
        CallEndNoPermission,
        CallEndOtherNotCapable,
        CallEndNoUIError,
        CallEndUnsupportedVersion,
        CallEndCallerNotVisible,
        CallEndCarrierBlocked,
        CallEndOtherCarrierBlocked
    }

    void addRemoteVideoTrack(String str, String str2, long j);

    void forceStarRating();

    void handleError(int i);

    void hideCallUI(int i, long j, boolean z, String str);

    void initializeCall(long j, long j2, boolean z);

    void localMediaStateChanged(boolean z, boolean z2, boolean z3);

    void onActiveAudioLevels(String[] strArr, int[] iArr);

    void onAudioLevel(int i, int i2);

    void onDataReceived(String str);

    void onEscalationRequest(boolean z);

    void onEscalationResponse(boolean z);

    void onEscalationSuccess();

    void onEscalationTimeout();

    void onIncomingMissedCall(long j, long j2);

    void onPingAckMessageReceived(long j, long j2);

    void onRemoteVideoSizeChanged(int i, int i2);

    void onSnakeGameUpdate(byte[] bArr);

    void remoteMediaStateChanged(boolean z, boolean z2, boolean z3);

    void removeRemoteVideoTrack(String str, String str2, long j);

    void setWebrtcManager(WebrtcManager webrtcManager);

    void showConnectionDetails(boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4);

    void switchToContactingUI();

    void switchToIncomingCallUI(long j, long j2, boolean z, boolean z2, String str);

    void switchToRingingUI();

    void switchToStreamingUI(boolean z, String str);

    void updateRemoteVideoSupport(boolean z, long j);

    void updateStatesAndCallDuration();

    void webRTCControlRPC_AcceptIncomingCall(long j);

    void webRTCControlRPC_DisableVideo();

    void webRTCControlRPC_EnableVideo();

    void webRTCControlRPC_StartOutgoingCall(long j, boolean z);

    void webRTCControlRPC_ToggleSpeakerPhone();

    void webRTCControlRPC_VolumeDown();

    void webRTCControlRPC_VolumeUp();
}
