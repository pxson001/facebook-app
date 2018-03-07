package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: event_discovery_dashboard */
public final class Encoder {
    private static final int[] f13582a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int m13817a(ByteMatrix byteMatrix) {
        int a = MaskUtil.m13832a(byteMatrix, true) + MaskUtil.m13832a(byteMatrix, false);
        byte[][] bArr = byteMatrix.f13578a;
        int i = byteMatrix.f13579b;
        int i2 = byteMatrix.f13580c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2 - 1) {
            int i5 = 0;
            while (i5 < i - 1) {
                byte b = bArr[i3][i5];
                if (b == bArr[i3][i5 + 1] && b == bArr[i3 + 1][i5] && b == bArr[i3 + 1][i5 + 1]) {
                    i4++;
                }
                i5++;
            }
            i3++;
        }
        return ((a + (i4 * 3)) + MaskUtil.m13834c(byteMatrix)) + MaskUtil.m13835d(byteMatrix);
    }

    private Encoder() {
    }

    public static QRCode m13820a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) {
        String str2;
        Mode mode;
        if (map == null) {
            str2 = null;
        } else {
            str2 = (String) map.get(EncodeHintType.CHARACTER_SET);
        }
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        int i = 0;
        if ("Shift_JIS".equals(str2)) {
            mode = m13829a(str) ? Mode.KANJI : Mode.BYTE;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                int charAt = str.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    if (m13815a(charAt) == -1) {
                        mode = Mode.BYTE;
                        break;
                    }
                    i2 = 1;
                } else {
                    i3 = 1;
                }
                i++;
            }
            mode = i2 != 0 ? Mode.ALPHANUMERIC : i3 != 0 ? Mode.NUMERIC : Mode.BYTE;
        }
        Mode mode2 = mode;
        BitArray bitArray = new BitArray();
        if (mode2 == Mode.BYTE && !"ISO-8859-1".equals(str2)) {
            CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2);
            if (characterSetECIByName != null) {
                m13824a(characterSetECIByName, bitArray);
            }
        }
        m13825a(mode2, bitArray);
        BitArray bitArray2 = new BitArray();
        m13828a(str, mode2, bitArray2, str2);
        Version a = m13819a((mode2.getCharacterCountBits(m13819a((bitArray.f13476b + mode2.getCharacterCountBits(Version.m13771b(1))) + bitArray2.f13476b, errorCorrectionLevel)) + bitArray.f13476b) + bitArray2.f13476b, errorCorrectionLevel);
        BitArray bitArray3 = new BitArray();
        bitArray3.m13668a(bitArray);
        m13823a(mode2 == Mode.BYTE ? bitArray2.m13671b() : str.length(), a, mode2, bitArray3);
        bitArray3.m13668a(bitArray2);
        ECBlocks a2 = a.m13774a(errorCorrectionLevel);
        int c = a.f13553f - a2.m13768c();
        m13822a(c, bitArray3);
        BitArray a3 = m13818a(bitArray3, a.f13553f, c, a2.m13767b());
        QRCode qRCode = new QRCode();
        qRCode.f13588b = errorCorrectionLevel;
        qRCode.f13587a = mode2;
        qRCode.f13589c = a;
        int d = a.m13777d();
        ByteMatrix byteMatrix = new ByteMatrix(d, d);
        d = m13816a(a3, errorCorrectionLevel, a, byteMatrix);
        qRCode.f13590d = d;
        MatrixUtil.m13840a(a3, errorCorrectionLevel, a, d, byteMatrix);
        qRCode.f13591e = byteMatrix;
        return qRCode;
    }

    public static int m13815a(int i) {
        if (i < f13582a.length) {
            return f13582a[i];
        }
        return -1;
    }

    public static boolean m13829a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    private static int m13816a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            MatrixUtil.m13840a(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int a = m13817a(byteMatrix);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private static Version m13819a(int i, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version b = Version.m13771b(i2);
            if (b.f13553f - b.m13774a(errorCorrectionLevel).m13768c() >= (i + 7) / 8) {
                return b;
            }
        }
        throw new WriterException("Data too big");
    }

    private static void m13822a(int i, BitArray bitArray) {
        int i2 = i << 3;
        if (bitArray.f13476b > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.f13476b + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && bitArray.f13476b < i2; i3++) {
            bitArray.m13669a(false);
        }
        i3 = bitArray.f13476b & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                bitArray.m13669a(false);
                i3++;
            }
        }
        int b = i - bitArray.m13671b();
        for (i3 = 0; i3 < b; i3++) {
            bitArray.m13666a((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.f13476b != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static void m13821a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        i7 -= i9;
        i8 -= i10;
        if (i7 != i8) {
            throw new WriterException("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    private static BitArray m13818a(BitArray bitArray, int i, int i2, int i3) {
        if (bitArray.m13671b() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        Collection<BlockPair> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            m13821a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            bitArray.m13667a(i7 * 8, bArr, 0, i8);
            byte[] a = m13830a(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (max = 0; max < i6; max++) {
            for (BlockPair blockPair : arrayList) {
                byte[] bArr2 = blockPair.f13576a;
                if (max < bArr2.length) {
                    bitArray2.m13666a(bArr2[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (BlockPair blockPair2 : arrayList) {
                bArr2 = blockPair2.m13809b();
                if (max < bArr2.length) {
                    bitArray2.m13666a(bArr2[max], 8);
                }
            }
        }
        if (i == bitArray2.m13671b()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + bitArray2.m13671b() + " differ.");
    }

    private static byte[] m13830a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new ReedSolomonEncoder(GenericGF.f13510e).m13725a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    private static void m13825a(Mode mode, BitArray bitArray) {
        bitArray.m13666a(mode.getBits(), 4);
    }

    private static void m13823a(int i, Version version, Mode mode, BitArray bitArray) {
        int characterCountBits = mode.getCharacterCountBits(version);
        if (i >= (1 << characterCountBits)) {
            throw new WriterException(i + " is bigger than " + ((1 << characterCountBits) - 1));
        }
        bitArray.m13666a(i, characterCountBits);
    }

    private static void m13828a(String str, Mode mode, BitArray bitArray, String str2) {
        switch (mode) {
            case NUMERIC:
                int length = str.length();
                int i = 0;
                while (i < length) {
                    int charAt = str.charAt(i) - 48;
                    if (i + 2 < length) {
                        bitArray.m13666a(((charAt * 100) + ((str.charAt(i + 1) - 48) * 10)) + (str.charAt(i + 2) - 48), 10);
                        i += 3;
                    } else if (i + 1 < length) {
                        bitArray.m13666a((charAt * 10) + (str.charAt(i + 1) - 48), 7);
                        i += 2;
                    } else {
                        bitArray.m13666a(charAt, 4);
                        i++;
                    }
                }
                return;
            case ALPHANUMERIC:
                m13831b(str, bitArray);
                return;
            case BYTE:
                m13827a(str, bitArray, str2);
                return;
            case KANJI:
                m13826a(str, bitArray);
                return;
            default:
                throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void m13831b(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = m13815a(charSequence.charAt(i));
            if (a == -1) {
                throw new WriterException();
            } else if (i + 1 < length) {
                int a2 = m13815a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new WriterException();
                }
                bitArray.m13666a((a * 45) + a2, 11);
                i += 2;
            } else {
                bitArray.m13666a(a, 6);
                i++;
            }
        }
    }

    private static void m13827a(String str, BitArray bitArray, String str2) {
        try {
            for (byte a : str.getBytes(str2)) {
                bitArray.m13666a(a, 8);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    private static void m13826a(String str, BitArray bitArray) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                if (i2 >= 33088 && i2 <= 40956) {
                    i2 -= 33088;
                } else if (i2 < 57408 || i2 > 60351) {
                    i2 = -1;
                } else {
                    i2 -= 49472;
                }
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.m13666a((i2 & 255) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    private static void m13824a(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.m13666a(Mode.ECI.getBits(), 4);
        bitArray.m13666a(characterSetECI.getValue(), 8);
    }
}
