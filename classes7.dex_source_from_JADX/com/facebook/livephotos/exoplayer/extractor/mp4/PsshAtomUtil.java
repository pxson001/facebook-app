package com.facebook.livephotos.exoplayer.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.UUID;

/* compiled from: page_nux_shop_cross_out */
public final class PsshAtomUtil {
    private PsshAtomUtil() {
    }

    public static UUID m9045a(byte[] bArr) {
        Pair pair = null;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.f7733c >= 32) {
            parsableByteArray.m9337b(0);
            if (parsableByteArray.m9349m() == parsableByteArray.m9336b() + 4 && parsableByteArray.m9349m() == Atom.f7124Q) {
                int a = Atom.m8976a(parsableByteArray.m9349m());
                if (a > 1) {
                    Log.w("PsshAtomUtil", "Unsupported pssh version: " + a);
                } else {
                    UUID uuid = new UUID(parsableByteArray.m9351o(), parsableByteArray.m9351o());
                    if (a == 1) {
                        parsableByteArray.m9339c(parsableByteArray.m9355s() * 16);
                    }
                    a = parsableByteArray.m9355s();
                    if (a == parsableByteArray.m9336b()) {
                        Object obj = new byte[a];
                        parsableByteArray.m9335a(obj, 0, a);
                        pair = Pair.create(uuid, obj);
                    }
                }
            }
        }
        Pair pair2 = pair;
        if (pair2 == null) {
            return null;
        }
        return (UUID) pair2.first;
    }
}
