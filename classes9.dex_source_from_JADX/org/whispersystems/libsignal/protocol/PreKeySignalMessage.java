package org.whispersystems.libsignal.protocol;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.InvalidVersionException;
import org.whispersystems.libsignal.LegacyMessageException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.protocol.SignalProtos.PreKeySignalMessage.Builder;
import org.whispersystems.libsignal.util.ByteUtil;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: actn_cancel_currency_selection */
public class PreKeySignalMessage implements CiphertextMessage {
    public final int f21269a;
    public final int f21270b;
    public final Optional<Integer> f21271c;
    public final int f21272d;
    public final DjbECPublicKey f21273e;
    public final IdentityKey f21274f;
    public final SignalMessage f21275g;
    private final byte[] f21276h;

    public PreKeySignalMessage(byte[] bArr) {
        Throwable e;
        try {
            this.f21269a = ByteUtil.m22404a(bArr[0]);
            if (this.f21269a > 3) {
                throw new InvalidVersionException("Unknown version: " + this.f21269a);
            } else if (this.f21269a < 3) {
                throw new LegacyMessageException("Legacy version: " + this.f21269a);
            } else {
                org.whispersystems.libsignal.protocol.SignalProtos.PreKeySignalMessage a = org.whispersystems.libsignal.protocol.SignalProtos.PreKeySignalMessage.m21792a(ByteString.m20175a(bArr, 1, bArr.length - 1));
                if (a.m21803o() && a.m21805q() && a.m21811w() && a.m21813y()) {
                    this.f21276h = bArr;
                    this.f21270b = a.m21800l();
                    this.f21271c = a.m21801m() ? Optional.m22417a(Integer.valueOf(a.m21802n())) : Optional.m22419c();
                    this.f21272d = a.m21803o() ? a.m21804p() : -1;
                    this.f21273e = Curve.m21736a(a.m21806r().m20185d(), 0);
                    this.f21274f = new IdentityKey(Curve.m21736a(a.m21812x().m20185d(), 0));
                    this.f21275g = new SignalMessage(a.m21814z().m20185d());
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
        } catch (LegacyMessageException e4) {
            e = e4;
            throw new InvalidMessageException(e);
        }
    }

    public PreKeySignalMessage(int i, int i2, Optional<Integer> optional, int i3, ECPublicKey eCPublicKey, IdentityKey identityKey, SignalMessage signalMessage) {
        this.f21269a = i;
        this.f21270b = i2;
        this.f21271c = optional;
        this.f21272d = i3;
        this.f21273e = eCPublicKey;
        this.f21274f = identityKey;
        this.f21275g = signalMessage;
        Builder a = Builder.m21763u().m21779c(i3).m21769a(ByteString.m20174a(eCPublicKey.m21741a())).m21775b(ByteString.m20174a(identityKey.m21715b())).m21780c(ByteString.m20174a(signalMessage.mo937a())).m21768a(i2);
        if (optional.mo939a()) {
            a.m21774b(((Integer) optional.mo940b()).intValue());
        }
        byte[] bArr = new byte[]{ByteUtil.m22403a(this.f21269a, 3)};
        byte[] lP_ = a.m21788l().lP_();
        this.f21276h = ByteUtil.m22406a(bArr, lP_);
    }

    public final SignalMessage m21755h() {
        return this.f21275g;
    }

    public final byte[] mo937a() {
        return this.f21276h;
    }
}
