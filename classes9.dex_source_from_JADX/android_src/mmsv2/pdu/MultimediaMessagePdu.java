package android_src.mmsv2.pdu;

/* compiled from: session_address_device */
public class MultimediaMessagePdu extends GenericPdu {
    private PduBody f3827b;

    public MultimediaMessagePdu(PduHeaders pduHeaders, PduBody pduBody) {
        super(pduHeaders);
        this.f3827b = pduBody;
    }

    public final PduBody m3613d() {
        return this.f3827b;
    }

    public final void m3612a(PduBody pduBody) {
        this.f3827b = pduBody;
    }

    public final void m3611a(long j) {
        this.f3814a.m3653a(j, 133);
    }

    public long mo124e() {
        return this.f3814a.m3661e(142);
    }
}
