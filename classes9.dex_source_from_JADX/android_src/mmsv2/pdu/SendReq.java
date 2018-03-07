package android_src.mmsv2.pdu;

import com.facebook.debug.log.BLog;

/* compiled from: server value */
public class SendReq extends MultimediaMessagePdu {
    public SendReq() {
        try {
            m3591a(128);
            m3594b(18);
            m3731a("application/vnd.wap.multipart.related".getBytes());
            mo122a(new EncodedStringValue("insert-address-token".getBytes()));
            m3732b(m3733f());
        } catch (Throwable e) {
            BLog.b("SendReq", "Unexpected InvalidHeaderValueException.", e);
            throw new RuntimeException(e);
        }
    }

    private static byte[] m3733f() {
        return ("T" + Long.toHexString(System.currentTimeMillis())).getBytes();
    }

    SendReq(PduHeaders pduHeaders, PduBody pduBody) {
        super(pduHeaders, pduBody);
    }

    private void m3731a(byte[] bArr) {
        this.f3814a.m3655a(bArr, 132);
    }

    public final long mo124e() {
        return this.f3814a.m3661e(142);
    }

    public final void m3734a(EncodedStringValue[] encodedStringValueArr) {
        this.f3814a.m3656a(encodedStringValueArr, 151);
    }

    private void m3732b(byte[] bArr) {
        this.f3814a.m3655a(bArr, 152);
    }
}
