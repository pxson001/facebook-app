package org.whispersystems.libsignal.protocol;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.LegacyMessageException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.protocol.SignalProtos.SignalMessage.Builder;
import org.whispersystems.libsignal.util.ByteUtil;

/* compiled from: actn_cancel_add_product */
public class SignalMessage implements CiphertextMessage {
    public final int f21277a;
    public final DjbECPublicKey f21278b;
    public final int f21279c;
    private final int f21280d;
    public final byte[] f21281e;
    private final byte[] f21282f;

    public SignalMessage(byte[] bArr) {
        Throwable e;
        try {
            byte[][] a = ByteUtil.m22408a(bArr, 1, (bArr.length - 1) - 8, 8);
            byte b = a[0][0];
            byte[] bArr2 = a[1];
            if (ByteUtil.m22404a(b) <= 1) {
                throw new LegacyMessageException("Legacy message: " + ByteUtil.m22404a(b));
            } else if (ByteUtil.m22404a(b) > 3) {
                throw new InvalidMessageException("Unknown version: " + ByteUtil.m22404a(b));
            } else {
                org.whispersystems.libsignal.protocol.SignalProtos.SignalMessage a2 = org.whispersystems.libsignal.protocol.SignalProtos.SignalMessage.m21844a(bArr2);
                if (a2.m21858q() && a2.m21855m() && a2.m21853k()) {
                    this.f21282f = bArr;
                    this.f21278b = Curve.m21736a(a2.m21854l().m20185d(), 0);
                    this.f21277a = ByteUtil.m22404a(b);
                    this.f21279c = a2.m21856n();
                    this.f21280d = a2.m21857p();
                    this.f21281e = a2.m21859r().m20185d();
                    return;
                }
                throw new InvalidMessageException("Incomplete message.");
            }
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            throw new InvalidMessageException(e);
        } catch (InvalidKeyException e3) {
            e = e3;
            throw new InvalidMessageException(e);
        } catch (ParseException e4) {
            e = e4;
            throw new InvalidMessageException(e);
        }
    }

    public SignalMessage(int i, SecretKeySpec secretKeySpec, DjbECPublicKey djbECPublicKey, int i2, int i3, byte[] bArr, IdentityKey identityKey, IdentityKey identityKey2) {
        byte[] bArr2 = new byte[]{ByteUtil.m22403a(i, 3)};
        byte[] lP_ = Builder.m21818u().m21824a(ByteString.m20174a(djbECPublicKey.m21741a())).m21823a(i2).m21829b(i3).m21830b(ByteString.m20174a(bArr)).m21841l().lP_();
        byte[] a = m21756a(i, identityKey, identityKey2, secretKeySpec, ByteUtil.m22406a(bArr2, lP_));
        this.f21282f = ByteUtil.m22406a(bArr2, lP_, a);
        this.f21278b = djbECPublicKey;
        this.f21279c = i2;
        this.f21280d = i3;
        this.f21281e = bArr;
        this.f21277a = i;
    }

    public final void m21757a(int i, IdentityKey identityKey, IdentityKey identityKey2, SecretKeySpec secretKeySpec) {
        byte[][] a = ByteUtil.m22407a(this.f21282f, this.f21282f.length - 8, 8);
        if (!MessageDigest.isEqual(m21756a(i, identityKey, identityKey2, secretKeySpec, a[0]), a[1])) {
            throw new InvalidMessageException("Bad Mac!");
        }
    }

    private static byte[] m21756a(int i, IdentityKey identityKey, IdentityKey identityKey2, SecretKeySpec secretKeySpec, byte[] bArr) {
        Object e;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            if (i >= 3) {
                instance.update(identityKey.m21714a().m21741a());
                instance.update(identityKey2.m21714a().m21741a());
            }
            return ByteUtil.m22405a(instance.doFinal(bArr), 8);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (java.security.InvalidKeyException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public final byte[] mo937a() {
        return this.f21282f;
    }
}
