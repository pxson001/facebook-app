package org.whispersystems.libsignal.ratchet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.kdf.HKDF;
import org.whispersystems.libsignal.kdf.HKDFv3;
import org.whispersystems.libsignal.state.SessionState;
import org.whispersystems.libsignal.util.ByteUtil;
import org.whispersystems.libsignal.util.Pair;

/* compiled from: action_result_payload */
public class RatchetingSession {

    /* compiled from: action_result_payload */
    class DerivedKeys {
        private final RootKey f21343a;
        private final ChainKey f21344b;

        public DerivedKeys(RootKey rootKey, ChainKey chainKey) {
            this.f21343a = rootKey;
            this.f21344b = chainKey;
        }

        public final RootKey m21892a() {
            return this.f21343a;
        }

        public final ChainKey m21893b() {
            return this.f21344b;
        }
    }

    public static void m21895a(SessionState sessionState, AliceSignalProtocolParameters aliceSignalProtocolParameters) {
        try {
            sessionState.m21919a(3);
            sessionState.m21920a(aliceSignalProtocolParameters.m21873c());
            sessionState.m21933b(aliceSignalProtocolParameters.m21871a().m21716a());
            ECKeyPair a = Curve.m21737a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(m21897a());
            byteArrayOutputStream.write(Curve.m21740a(aliceSignalProtocolParameters.m21874d(), aliceSignalProtocolParameters.m21871a().m21717b()));
            byteArrayOutputStream.write(Curve.m21740a(aliceSignalProtocolParameters.m21873c().m21714a(), aliceSignalProtocolParameters.m21872b().m21743b()));
            byteArrayOutputStream.write(Curve.m21740a(aliceSignalProtocolParameters.m21874d(), aliceSignalProtocolParameters.m21872b().m21743b()));
            if (aliceSignalProtocolParameters.m21875e().mo939a()) {
                byteArrayOutputStream.write(Curve.m21740a((DjbECPublicKey) aliceSignalProtocolParameters.m21875e().mo940b(), aliceSignalProtocolParameters.m21872b().m21743b()));
            }
            DerivedKeys a2 = m21894a(byteArrayOutputStream.toByteArray());
            Pair a3 = a2.m21892a().m21898a(aliceSignalProtocolParameters.m21876f(), a);
            sessionState.m21921a(aliceSignalProtocolParameters.m21876f(), a2.m21893b());
            sessionState.m21923a(a, (ChainKey) a3.m22416b());
            sessionState.m21925a((RootKey) a3.m22415a());
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static void m21896a(SessionState sessionState, BobSignalProtocolParameters bobSignalProtocolParameters) {
        try {
            sessionState.m21919a(3);
            sessionState.m21920a(bobSignalProtocolParameters.m21881d());
            sessionState.m21933b(bobSignalProtocolParameters.m21878a().m21716a());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(m21897a());
            byteArrayOutputStream.write(Curve.m21740a(bobSignalProtocolParameters.m21881d().m21714a(), bobSignalProtocolParameters.m21879b().m21743b()));
            byteArrayOutputStream.write(Curve.m21740a(bobSignalProtocolParameters.m21882e(), bobSignalProtocolParameters.m21878a().m21717b()));
            byteArrayOutputStream.write(Curve.m21740a(bobSignalProtocolParameters.m21882e(), bobSignalProtocolParameters.m21879b().m21743b()));
            if (bobSignalProtocolParameters.m21880c().mo939a()) {
                byteArrayOutputStream.write(Curve.m21740a(bobSignalProtocolParameters.m21882e(), ((ECKeyPair) bobSignalProtocolParameters.m21880c().mo940b()).m21743b()));
            }
            DerivedKeys a = m21894a(byteArrayOutputStream.toByteArray());
            sessionState.m21923a(bobSignalProtocolParameters.m21883f(), a.m21893b());
            sessionState.m21925a(a.m21892a());
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static byte[] m21897a() {
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) -1);
        return bArr;
    }

    private static DerivedKeys m21894a(byte[] bArr) {
        HKDF hKDFv3 = new HKDFv3();
        byte[][] a = ByteUtil.m22407a(hKDFv3.m21748a(bArr, "WhisperText".getBytes(), 64), 32, 32);
        return new DerivedKeys(new RootKey(hKDFv3, a[0]), new ChainKey(hKDFv3, a[1], 0));
    }
}
