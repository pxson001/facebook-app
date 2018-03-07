package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* compiled from: event_location_summary_order_ride */
public class QRCodeReader {
    private static final ResultPoint[] f13526a = new ResultPoint[0];
    private final Decoder f13527b = new Decoder();

    public final Result m13728a(BinaryBitmap binaryBitmap) {
        return m13729a(binaryBitmap, null);
    }

    public final Result m13729a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        DecoderResult a;
        ResultPoint[] resultPointArr;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult a2 = new Detector(binaryBitmap.m13649a()).m13794a((Map) map);
            a = this.f13527b.m13759a(a2.f13489a, (Map) map);
            resultPointArr = a2.f13490b;
        } else {
            a = this.f13527b.m13759a(m13727a(binaryBitmap.m13649a()), (Map) map);
            resultPointArr = f13526a;
        }
        Result result = new Result(a.f13485b, a.f13484a, resultPointArr, BarcodeFormat.QR_CODE);
        List list = a.f13486c;
        if (list != null) {
            result.m13660a(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = a.f13487d;
        if (str != null) {
            result.m13660a(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    private static BitMatrix m13727a(BitMatrix bitMatrix) {
        int[] a = bitMatrix.m13675a();
        int[] b = bitMatrix.m13677b();
        if (a == null || b == null) {
            throw NotFoundException.f13456a;
        }
        float a2 = m13726a(a, bitMatrix);
        int i = a[1];
        int i2 = b[1];
        int i3 = a[0];
        int i4 = b[0];
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a2);
        i2 = Math.round(((float) ((i2 - i) + 1)) / a2);
        if (round <= 0 || i2 <= 0) {
            throw NotFoundException.f13456a;
        } else if (i2 != round) {
            throw NotFoundException.f13456a;
        } else {
            i4 = (int) (a2 / 2.0f);
            i += i4;
            i3 += i4;
            BitMatrix bitMatrix2 = new BitMatrix(round, i2);
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i + ((int) (((float) i5) * a2));
                for (i4 = 0; i4 < round; i4++) {
                    if (bitMatrix.m13674a(((int) (((float) i4) * a2)) + i3, i6)) {
                        bitMatrix2.m13676b(i4, i5);
                    }
                }
            }
            return bitMatrix2;
        }
    }

    private static float m13726a(int[] iArr, BitMatrix bitMatrix) {
        int i = bitMatrix.f13478b;
        int i2 = bitMatrix.f13477a;
        int i3 = iArr[0];
        boolean z = true;
        int i4 = iArr[1];
        int i5 = i3;
        int i6 = 0;
        while (i5 < i2 && i4 < i) {
            boolean z2;
            if (z != bitMatrix.m13674a(i5, i4)) {
                i3 = i6 + 1;
                if (i3 == 5) {
                    break;
                }
                boolean z3;
                if (z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i7 = i3;
                z2 = z3;
                i6 = i7;
            } else {
                z2 = z;
            }
            i5++;
            i4++;
            z = z2;
        }
        if (i5 != i2 && i4 != i) {
            return ((float) (i5 - iArr[0])) / 7.0f;
        }
        throw NotFoundException.f13456a;
    }
}
