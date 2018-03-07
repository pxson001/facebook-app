package android_src.mmsv2.pdu;

/* compiled from: session_ID */
public class NotificationInd extends GenericPdu {
    public NotificationInd() {
        m3591a(130);
    }

    NotificationInd(PduHeaders pduHeaders) {
        super(pduHeaders);
    }

    public final byte[] m3617d() {
        return this.f3814a.m3658b(131);
    }

    public final long m3618e() {
        return this.f3814a.m3661e(136);
    }

    public final EncodedStringValue mo123c() {
        return this.f3814a.m3659c(137);
    }

    public final void mo122a(EncodedStringValue encodedStringValue) {
        this.f3814a.m3654a(encodedStringValue, 137);
    }

    public final long m3619f() {
        return this.f3814a.m3661e(142);
    }
}
