package org.whispersystems.libsignal;

import com.google.protobuf.ByteString;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPrivateKey;
import org.whispersystems.libsignal.state.StorageProtos.IdentityKeyPairStructure;
import org.whispersystems.libsignal.state.StorageProtos.IdentityKeyPairStructure.Builder;

/* compiled from: addMembers */
public class IdentityKeyPair {
    private final IdentityKey f21245a;
    public final DjbECPrivateKey f21246b;

    public IdentityKeyPair(IdentityKey identityKey, DjbECPrivateKey djbECPrivateKey) {
        this.f21245a = identityKey;
        this.f21246b = djbECPrivateKey;
    }

    public IdentityKeyPair(byte[] bArr) {
        try {
            IdentityKeyPairStructure a = IdentityKeyPairStructure.m21980a(bArr);
            this.f21245a = new IdentityKey(a.m21989l().m20185d(), 0);
            this.f21246b = Curve.m21735a(a.m21990n().m20185d());
        } catch (Throwable e) {
            throw new InvalidKeyException(e);
        }
    }

    public final IdentityKey m21716a() {
        return this.f21245a;
    }

    public final DjbECPrivateKey m21717b() {
        return this.f21246b;
    }

    public final byte[] m21718c() {
        return Builder.m21956u().m21961a(ByteString.m20174a(this.f21245a.m21715b())).m21966b(ByteString.m20174a(this.f21246b.f21260a)).m21977l().lP_();
    }
}
