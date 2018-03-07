package org.whispersystems.libsignal;

/* compiled from: ad_interfaces_create_story_promotion */
public class SignalProtocolAddress {
    public final String f21258a;
    public final int f21259b;

    public SignalProtocolAddress(String str, int i) {
        this.f21258a = str;
        this.f21259b = i;
    }

    public final String m21734a() {
        return this.f21258a;
    }

    public String toString() {
        return this.f21258a + ":" + this.f21259b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SignalProtocolAddress)) {
            return false;
        }
        SignalProtocolAddress signalProtocolAddress = (SignalProtocolAddress) obj;
        if (this.f21258a.equals(signalProtocolAddress.f21258a) && this.f21259b == signalProtocolAddress.f21259b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f21258a.hashCode() ^ this.f21259b;
    }
}
