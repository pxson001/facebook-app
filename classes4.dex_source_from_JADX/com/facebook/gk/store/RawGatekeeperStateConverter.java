package com.facebook.gk.store;

import com.facebook.common.util.TriState;

/* compiled from: xｘ#＃~～ */
public final class RawGatekeeperStateConverter {

    /* compiled from: xｘ#＃~～ */
    /* synthetic */ class C00031 {
        static final /* synthetic */ int[] f72a = new int[TriState.values().length];

        static {
            try {
                f72a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f72a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f72a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static byte m71a(TriState triState) {
        switch (C00031.f72a[triState.ordinal()]) {
            case 1:
                return (byte) 2;
            case 2:
                return (byte) 1;
            case 3:
                return (byte) 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte m72b(TriState triState) {
        switch (C00031.f72a[triState.ordinal()]) {
            case 1:
                return (byte) 8;
            case 2:
                return (byte) 4;
            case 3:
                return (byte) 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    private RawGatekeeperStateConverter() {
    }
}
