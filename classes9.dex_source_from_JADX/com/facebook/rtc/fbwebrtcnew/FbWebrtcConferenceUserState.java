package com.facebook.rtc.fbwebrtcnew;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: application/wml+xml */
public enum FbWebrtcConferenceUserState {
    UNKNOWN,
    DISCONNECTED,
    NO_ANSWER,
    REJECTED,
    UNREACHABLE,
    CONNECTION_DROPPED,
    CONTACTING,
    RINGING,
    CONNECTING,
    CONNECTED,
    PARTICIPANT_LIMIT_REACHED
}
