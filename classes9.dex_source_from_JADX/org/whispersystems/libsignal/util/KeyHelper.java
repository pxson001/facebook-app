package org.whispersystems.libsignal.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;

/* compiled from: act_%s/brazil_tax */
public class KeyHelper {
    private KeyHelper() {
    }

    public static IdentityKeyPair m22412a() {
        ECKeyPair a = Curve.m21737a();
        return new IdentityKeyPair(new IdentityKey(a.f21262a), a.f21263b);
    }

    public static int m22410a(boolean z) {
        try {
            SecureRandom instance = SecureRandom.getInstance("SHA1PRNG");
            if (z) {
                return instance.nextInt(2147483646) + 1;
            }
            return instance.nextInt(16380) + 1;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static List<PreKeyRecord> m22411a(int i, int i2) {
        List<PreKeyRecord> linkedList = new LinkedList();
        int i3 = i - 1;
        for (int i4 = 0; i4 < i2; i4++) {
            linkedList.add(new PreKeyRecord(((i3 + i4) % (Medium.f21479a - 1)) + 1, Curve.m21737a()));
        }
        return linkedList;
    }

    public static SignedPreKeyRecord m22413a(IdentityKeyPair identityKeyPair, int i) {
        ECKeyPair a = Curve.m21737a();
        return new SignedPreKeyRecord(i, System.currentTimeMillis(), a, Curve.m21739a(identityKeyPair.f21246b, a.f21262a.m21741a()));
    }
}
