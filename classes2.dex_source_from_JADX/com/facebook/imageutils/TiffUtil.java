package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.InputStream;

/* compiled from: last_store_visit_time */
public class TiffUtil {
    public static final Class<?> f17857a = TiffUtil.class;

    TiffUtil() {
    }

    public static int m25078a(int i) {
        switch (i) {
            case 3:
                return 180;
            case 6:
                return 90;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return 270;
            default:
                return 0;
        }
    }

    public static int m25079a(InputStream inputStream, int i) {
        TiffHeader tiffHeader = new TiffHeader();
        boolean z = false;
        if (i > 8) {
            tiffHeader.b = StreamProcessor.m25072a(inputStream, 4, false);
            int i2 = i - 4;
            if (tiffHeader.b == 1229531648 || tiffHeader.b == 1296891946) {
                tiffHeader.a = tiffHeader.b == 1229531648;
                tiffHeader.c = StreamProcessor.m25072a(inputStream, 4, tiffHeader.a);
                boolean z2 = i2 - 4;
                if (tiffHeader.c < 8 || tiffHeader.c - 8 > z2) {
                    FLog.a(f17857a, "Invalid offset");
                } else {
                    z = z2;
                }
            } else {
                FLog.a(f17857a, "Invalid TIFF header");
            }
        }
        boolean z3 = z;
        boolean z4 = tiffHeader.c - 8;
        if (!z3 || z4 > z3) {
            return 0;
        }
        inputStream.skip((long) z4);
        return m25080a(inputStream, m25081a(inputStream, z3 - z4, tiffHeader.a, 274), tiffHeader.a);
    }

    private static int m25081a(InputStream inputStream, int i, boolean z, int i2) {
        if (i < 14) {
            return 0;
        }
        int a = StreamProcessor.m25072a(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = a - 1;
            if (a <= 0 || i3 < 12) {
                return 0;
            }
            a = i3 - 2;
            if (StreamProcessor.m25072a(inputStream, 2, z) == i2) {
                return a;
            }
            inputStream.skip(10);
            i3 = a - 10;
            a = i4;
        }
    }

    private static int m25080a(InputStream inputStream, int i, boolean z) {
        if (i < 10 || StreamProcessor.m25072a(inputStream, 2, z) != 3 || StreamProcessor.m25072a(inputStream, 4, z) != 1) {
            return 0;
        }
        int a = StreamProcessor.m25072a(inputStream, 2, z);
        StreamProcessor.m25072a(inputStream, 2, z);
        return a;
    }
}
