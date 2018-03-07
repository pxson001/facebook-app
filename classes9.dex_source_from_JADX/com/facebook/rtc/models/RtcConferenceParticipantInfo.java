package com.facebook.rtc.models;

/* compiled from: application/vnd.wap.locc+wbxml */
public class RtcConferenceParticipantInfo implements Comparable<RtcConferenceParticipantInfo> {
    public ParticipantCallState f19833a;
    public String f19834b;
    public String f19835c;
    public long f19836d;
    public long f19837e;
    public String f19838f;
    public long f19839g;
    public boolean f19840h;
    public boolean f19841i;

    /* compiled from: application/vnd.wap.locc+wbxml */
    public enum ParticipantCallState {
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

    public int compareTo(Object obj) {
        RtcConferenceParticipantInfo rtcConferenceParticipantInfo = (RtcConferenceParticipantInfo) obj;
        if (this.f19836d < rtcConferenceParticipantInfo.f19836d) {
            return 1;
        }
        if (this.f19836d > rtcConferenceParticipantInfo.f19836d) {
            return -1;
        }
        return 0;
    }

    private RtcConferenceParticipantInfo(String str, ParticipantCallState participantCallState, long j, long j2, String str2) {
        this.f19834b = str;
        this.f19833a = participantCallState;
        this.f19835c = str2;
        this.f19836d = j;
        this.f19837e = j2;
        this.f19841i = true;
    }

    public RtcConferenceParticipantInfo(String str, ParticipantCallState participantCallState, long j, long j2) {
        this(str, participantCallState, j, j2, "");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RtcConferenceParticipantInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RtcConferenceParticipantInfo rtcConferenceParticipantInfo = (RtcConferenceParticipantInfo) obj;
        if (this.f19834b.contentEquals(rtcConferenceParticipantInfo.f19834b) && this.f19833a == rtcConferenceParticipantInfo.f19833a && this.f19836d == rtcConferenceParticipantInfo.f19836d && this.f19837e == rtcConferenceParticipantInfo.f19837e && this.f19840h == rtcConferenceParticipantInfo.f19840h && this.f19838f.contentEquals(rtcConferenceParticipantInfo.f19838f) && this.f19839g == rtcConferenceParticipantInfo.f19839g && this.f19841i == rtcConferenceParticipantInfo.f19841i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f19833a.hashCode() + 31) * 31) + this.f19834b.hashCode()) * 31) + this.f19835c.hashCode()) * 31) + ((int) this.f19836d);
    }
}
