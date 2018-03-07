package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* compiled from: event_location_summary_open_page */
public final class QRCodeWriter {
    public static BitMatrix m13731a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            int intValue;
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            if (map != null) {
                ErrorCorrectionLevel errorCorrectionLevel2 = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION);
                if (errorCorrectionLevel2 != null) {
                    errorCorrectionLevel = errorCorrectionLevel2;
                }
                Integer num = (Integer) map.get(EncodeHintType.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return m13730a(Encoder.m13820a(str, errorCorrectionLevel, (Map) map), i, i2, intValue);
                }
            }
            intValue = 4;
            return m13730a(Encoder.m13820a(str, errorCorrectionLevel, (Map) map), i, i2, intValue);
        }
    }

    private static BitMatrix m13730a(QRCode qRCode, int i, int i2, int i3) {
        ByteMatrix a = qRCode.m13851a();
        if (a == null) {
            throw new IllegalStateException();
        }
        int b = a.m13814b();
        int a2 = a.m13811a();
        int i4 = (i3 << 1) + b;
        int i5 = (i3 << 1) + a2;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a2 * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a2; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (a.m13810a(max, i6) == (byte) 1) {
                    bitMatrix.m13673a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return bitMatrix;
    }
}
