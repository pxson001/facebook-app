package com.facebook.messaging.media.upload.udp;

/* compiled from: last_action_id */
public class UDPUploadSession {
    public final long f12224a;
    public final int f12225b;

    public UDPUploadSession(int i, long j) {
        this.f12225b = i;
        this.f12224a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UDPUploadSession uDPUploadSession = (UDPUploadSession) obj;
        if (this.f12224a == uDPUploadSession.f12224a && this.f12225b == uDPUploadSession.f12225b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) (this.f12224a ^ (this.f12224a >>> 32))) * 31) + this.f12225b;
    }
}
