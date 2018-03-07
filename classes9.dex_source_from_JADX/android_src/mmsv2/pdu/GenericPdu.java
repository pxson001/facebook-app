package android_src.mmsv2.pdu;

/* compiled from: setPaymentPinParams */
public class GenericPdu {
    public PduHeaders f3814a;

    public GenericPdu() {
        this.f3814a = null;
        this.f3814a = new PduHeaders();
    }

    GenericPdu(PduHeaders pduHeaders) {
        this.f3814a = null;
        this.f3814a = pduHeaders;
    }

    final PduHeaders m3590a() {
        return this.f3814a;
    }

    public final int m3593b() {
        return this.f3814a.m3651a(140);
    }

    public final void m3591a(int i) {
        this.f3814a.m3652a(i, 140);
    }

    public final void m3594b(int i) {
        this.f3814a.m3652a(i, 141);
    }

    public EncodedStringValue mo123c() {
        return this.f3814a.m3659c(137);
    }

    public void mo122a(EncodedStringValue encodedStringValue) {
        this.f3814a.m3654a(encodedStringValue, 137);
    }
}
