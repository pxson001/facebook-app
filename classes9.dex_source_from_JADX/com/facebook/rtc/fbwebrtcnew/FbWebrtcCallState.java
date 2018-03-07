package com.facebook.rtc.fbwebrtcnew;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: application/x-www-form-urlencoded */
public enum FbWebrtcCallState {
    FbWebRTCCallStateInit,
    FbWebRTCCallStateInitInbound,
    FbWebRTCCallStateInitInboundDirectVideo,
    FbWebRTCCallStateInitOutbound,
    FbWebRTCCallStateInitOutboundDirectVideo,
    FbWebRTCCallStateContacting,
    FbWebRTCCallStateContactingConferenceCall,
    FbWebRTCCallStateContactingDirectVideo,
    FbWebRTCCallStateRingingInbound,
    FbWebRTCCallStateRingingInboundDirectVideo,
    FbWebRTCCallStateRingingOutbound,
    FbWebRTCCallStateRingingOutboundDirectVideo,
    FbWebRTCCallStateInAudioCall,
    FbWebRTCCallStateInVideoCall,
    FbWebRTCCallStateInAudioConferenceCall,
    FbWebRTCCallStateInVideoConferenceCall,
    FbWebRTCCallStateLocalPausedVideoCall,
    FbWebRTCCallStateRemotePausedVideoCall,
    FbWebRTCCallStateLocalPausedVideoConferenceCall,
    FbWebRTCCallStateRemotePausedVideoConferenceCall,
    FbWebRTCCallStateLocalRequestingVideoCall,
    FbWebRTCCallStateRemoteRequestingVideoCall,
    FbWebRTCCallStateEnded;

    public static boolean validateStateTransition(FbWebrtcCallState fbWebrtcCallState, FbWebrtcCallState fbWebrtcCallState2) {
        if (fbWebrtcCallState == fbWebrtcCallState2) {
            return true;
        }
        switch (fbWebrtcCallState) {
            case FbWebRTCCallStateInit:
                return true;
            case FbWebRTCCallStateInitInbound:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateRingingInbound || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInitInboundDirectVideo:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInitInboundDirectVideo) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInitOutbound:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateContacting || fbWebrtcCallState2 == FbWebRTCCallStateContactingConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateRingingOutbound || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInitOutboundDirectVideo:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateContactingDirectVideo || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRingingOutboundDirectVideo) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInAudioCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalRequestingVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemoteRequestingVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInAudioConferenceCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInVideoConferenceCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateLocalPausedVideoConferenceCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateInVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRemotePausedVideoConferenceCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoConferenceCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateInVideoCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateLocalRequestingVideoCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRemoteRequestingVideoCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateLocalPausedVideoCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateRemotePausedVideoCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRemotePausedVideoCall:
                if (fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateLocalPausedVideoCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateContacting:
                if (fbWebrtcCallState2 == FbWebRTCCallStateRingingOutbound || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateContactingConferenceCall:
                if (fbWebrtcCallState2 != FbWebRTCCallStateInAudioConferenceCall) {
                    return false;
                }
                return true;
            case FbWebRTCCallStateContactingDirectVideo:
                if (fbWebrtcCallState2 == FbWebRTCCallStateRingingOutboundDirectVideo || fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRingingInbound:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateContacting || fbWebrtcCallState2 == FbWebRTCCallStateContactingConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRingingOutbound:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded || fbWebrtcCallState2 == FbWebRTCCallStateInAudioConferenceCall) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRingingInboundDirectVideo:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateRingingOutboundDirectVideo:
                if (fbWebrtcCallState2 == FbWebRTCCallStateInAudioCall || fbWebrtcCallState2 == FbWebRTCCallStateInVideoCall || fbWebrtcCallState2 == FbWebRTCCallStateEnded) {
                    return true;
                }
                return false;
            case FbWebRTCCallStateEnded:
                return false;
            default:
                return true;
        }
    }
}
