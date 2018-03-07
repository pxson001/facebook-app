package org.whispersystems.libsignal.state;

import com.google.protobuf.ByteString;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.state.StorageProtos.PreKeyRecordStructure;
import org.whispersystems.libsignal.state.StorageProtos.PreKeyRecordStructure.Builder;

/* compiled from: action_id */
public class PreKeyRecord {
    private PreKeyRecordStructure f21355a;

    public PreKeyRecord(int i, ECKeyPair eCKeyPair) {
        this.f21355a = Builder.m21998u().m22003a(i).m22004a(ByteString.m20174a(eCKeyPair.f21262a.m21741a())).m22009b(ByteString.m20174a(eCKeyPair.f21263b.f21260a)).m22020l();
    }

    public PreKeyRecord(byte[] bArr) {
        this.f21355a = (PreKeyRecordStructure) PreKeyRecordStructure.f21373a.m20167a(bArr);
    }

    public final ECKeyPair m21906a() {
        try {
            return new ECKeyPair(Curve.m21736a(this.f21355a.m22031n().m20185d(), 0), Curve.m21735a(this.f21355a.m22032p().m20185d()));
        } catch (InvalidKeyException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] m21907b() {
        return this.f21355a.lP_();
    }
}
