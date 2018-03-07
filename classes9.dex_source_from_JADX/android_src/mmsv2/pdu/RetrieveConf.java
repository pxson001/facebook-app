package android_src.mmsv2.pdu;

/* compiled from: server_duration */
public class RetrieveConf extends MultimediaMessagePdu {
    public RetrieveConf() {
        m3591a(132);
    }

    RetrieveConf(PduHeaders pduHeaders, PduBody pduBody) {
        super(pduHeaders, pduBody);
    }

    public final byte[] m3729f() {
        return this.f3814a.m3658b(132);
    }

    public final EncodedStringValue mo123c() {
        return this.f3814a.m3659c(137);
    }

    public final void mo122a(EncodedStringValue encodedStringValue) {
        this.f3814a.m3654a(encodedStringValue, 137);
    }
}
