package android_src.mmsv2.pdu;

/* compiled from: service_authorization_url */
public class ReadOrigInd extends GenericPdu {
    public ReadOrigInd() {
        m3591a(136);
    }

    ReadOrigInd(PduHeaders pduHeaders) {
        super(pduHeaders);
    }

    public final EncodedStringValue mo123c() {
        return this.f3814a.m3659c(137);
    }

    public final void mo122a(EncodedStringValue encodedStringValue) {
        this.f3814a.m3654a(encodedStringValue, 137);
    }
}
