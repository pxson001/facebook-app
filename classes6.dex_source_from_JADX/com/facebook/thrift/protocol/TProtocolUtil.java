package com.facebook.thrift.protocol;

import com.facebook.thrift.TException;
import java.util.Collections;

/* compiled from: selected_result_data_source */
public class TProtocolUtil {
    private static int f5053a = Integer.MAX_VALUE;

    public static void m7816a(TProtocol tProtocol, byte b) {
        m7817a(tProtocol, b, f5053a);
    }

    private static void m7817a(TProtocol tProtocol, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new TException("Maximum skip depth exceeded");
        }
        switch (b) {
            case (byte) 2:
                tProtocol.j();
                return;
            case (byte) 3:
                tProtocol.k();
                return;
            case (byte) 4:
                tProtocol.o();
                return;
            case (byte) 6:
                tProtocol.l();
                return;
            case (byte) 8:
                tProtocol.m();
                return;
            case (byte) 10:
                tProtocol.n();
                return;
            case (byte) 11:
                tProtocol.q();
                return;
            case (byte) 12:
                Collections.emptyMap();
                tProtocol.d();
                while (true) {
                    TField f = tProtocol.f();
                    if (f.b != (byte) 0) {
                        m7817a(tProtocol, f.b, i - 1);
                    } else {
                        tProtocol.e();
                        return;
                    }
                }
            case (byte) 13:
                TMap g = tProtocol.g();
                while (true) {
                    if (g.f5052c < 0) {
                        if (!TProtocol.s()) {
                            return;
                        }
                    } else if (i2 >= g.f5052c) {
                        return;
                    }
                    m7817a(tProtocol, g.f5050a, i - 1);
                    m7817a(tProtocol, g.f5051b, i - 1);
                    i2++;
                }
            case (byte) 14:
                TSet i3 = tProtocol.i();
                while (true) {
                    if (i3.f5055b < 0) {
                        if (!TProtocol.u()) {
                            return;
                        }
                    } else if (i2 >= i3.f5055b) {
                        return;
                    }
                    m7817a(tProtocol, i3.f5054a, i - 1);
                    i2++;
                }
            case (byte) 15:
                TList h = tProtocol.h();
                while (true) {
                    if (h.b < 0) {
                        if (!TProtocol.t()) {
                            return;
                        }
                    } else if (i2 >= h.b) {
                        return;
                    }
                    m7817a(tProtocol, h.a, i - 1);
                    i2++;
                }
            default:
                return;
        }
    }
}
