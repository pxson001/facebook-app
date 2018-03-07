package android_src.mmsv2.pdu;

import java.util.Vector;

/* compiled from: service_provider_name */
public class PduBody {
    private Vector<PduPart> f3828a;

    public PduBody() {
        this.f3828a = null;
        this.f3828a = new Vector();
    }

    public final boolean m3623a(PduPart pduPart) {
        if (pduPart != null) {
            return this.f3828a.add(pduPart);
        }
        throw new NullPointerException();
    }

    public final void m3622a(int i, PduPart pduPart) {
        if (pduPart == null) {
            throw new NullPointerException();
        }
        this.f3828a.add(i, pduPart);
    }

    public final void m3621a() {
        this.f3828a.clear();
    }

    public final PduPart m3620a(int i) {
        return (PduPart) this.f3828a.get(i);
    }

    public final int m3624b() {
        return this.f3828a.size();
    }
}
