package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* compiled from: event_location_summary_cancel */
public final class Decoder {
    private final ReedSolomonDecoder f13535a = new ReedSolomonDecoder(GenericGF.f13510e);

    public final DecoderResult m13759a(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) {
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        Version b = bitMatrixParser.m13734b();
        ErrorCorrectionLevel a = bitMatrixParser.m13733a().m13762a();
        DataBlock[] a2 = DataBlock.m13736a(bitMatrixParser.m13735c(), b, a);
        int i = 0;
        for (DataBlock a3 : a2) {
            i += a3.m13737a();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            DataBlock dataBlock = a2[i2];
            byte[] b2 = dataBlock.m13738b();
            int a4 = dataBlock.m13737a();
            m13758a(b2, a4);
            i = i3;
            i3 = 0;
            while (i3 < a4) {
                int i4 = i + 1;
                bArr[i] = b2[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return DecodedBitStreamParser.m13752a(bArr, b, a, (Map) map);
    }

    private void m13758a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f13535a.m13723a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (ReedSolomonException e) {
            throw ChecksumException.m13650a();
        }
    }
}
