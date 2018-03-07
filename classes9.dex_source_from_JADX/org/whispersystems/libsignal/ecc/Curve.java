package org.whispersystems.libsignal.ecc;

import org.whispersystems.curve25519.Curve25519;
import org.whispersystems.curve25519.Curve25519KeyPair;
import org.whispersystems.libsignal.InvalidKeyException;

/* compiled from: ad_click */
public class Curve {
    public static ECKeyPair m21737a() {
        Curve25519 a = Curve25519.m21651a("best");
        byte[] a2 = a.f21210a.mo930a();
        Curve25519KeyPair curve25519KeyPair = new Curve25519KeyPair(a.f21210a.generatePublicKey(a2), a2);
        return new ECKeyPair(new DjbECPublicKey(curve25519KeyPair.f21211a), new DjbECPrivateKey(curve25519KeyPair.f21212b));
    }

    public static byte[] m21739a(DjbECPrivateKey djbECPrivateKey, byte[] bArr) {
        if (5 == 5) {
            Curve25519 a = Curve25519.m21651a("best");
            byte[] bArr2 = djbECPrivateKey.f21260a;
            return a.f21210a.calculateSignature(a.f21210a.mo931a(64), bArr2, bArr);
        }
        throw new InvalidKeyException("Unknown type: " + 5);
    }

    public static boolean m21738a(DjbECPublicKey djbECPublicKey, byte[] bArr, byte[] bArr2) {
        if (5 == 5) {
            Curve25519 a = Curve25519.m21651a("best");
            return a.f21210a.verifySignature(djbECPublicKey.f21261a, bArr, bArr2);
        }
        throw new InvalidKeyException("Unknown type: " + 5);
    }

    public static byte[] m21740a(DjbECPublicKey djbECPublicKey, DjbECPrivateKey djbECPrivateKey) {
        if (5 != 5) {
            throw new InvalidKeyException("Public and private keys must be of the same type!");
        } else if (5 == 5) {
            Curve25519 a = Curve25519.m21651a("best");
            byte[] bArr = djbECPublicKey.f21261a;
            return a.f21210a.calculateAgreement(djbECPrivateKey.f21260a, bArr);
        } else {
            throw new InvalidKeyException("Unknown type: " + 5);
        }
    }

    public static DjbECPublicKey m21736a(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        switch (i2) {
            case 5:
                Object obj = new byte[32];
                System.arraycopy(bArr, i + 1, obj, 0, 32);
                return new DjbECPublicKey(obj);
            default:
                throw new InvalidKeyException("Bad key type: " + i2);
        }
    }

    public static DjbECPrivateKey m21735a(byte[] bArr) {
        return new DjbECPrivateKey(bArr);
    }
}
