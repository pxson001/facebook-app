package org.whispersystems.libsignal.state;

import com.google.protobuf.ByteString;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.state.StorageProtos.SignedPreKeyRecordStructure;
import org.whispersystems.libsignal.state.StorageProtos.SignedPreKeyRecordStructure.Builder;

/* compiled from: actionText */
public class SignedPreKeyRecord {
    private SignedPreKeyRecordStructure f21363a;

    public SignedPreKeyRecord(int i, long j, ECKeyPair eCKeyPair, byte[] bArr) {
        this.f21363a = Builder.m22362u().m22367a(i).m22369a(ByteString.m20174a(eCKeyPair.f21262a.m21741a())).m22374b(ByteString.m20174a(eCKeyPair.f21263b.f21260a)).m22378c(ByteString.m20174a(bArr)).m22368a(j).m22386l();
    }

    public SignedPreKeyRecord(byte[] bArr) {
        this.f21363a = (SignedPreKeyRecordStructure) SignedPreKeyRecordStructure.f21445a.m20167a(bArr);
    }

    public final ECKeyPair m21949a() {
        try {
            return new ECKeyPair(Curve.m21736a(this.f21363a.m22397n().m20185d(), 0), Curve.m21735a(this.f21363a.m22398p().m20185d()));
        } catch (InvalidKeyException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] m21950b() {
        return this.f21363a.signature_.m20185d();
    }

    public final byte[] m21951c() {
        return this.f21363a.lP_();
    }
}
