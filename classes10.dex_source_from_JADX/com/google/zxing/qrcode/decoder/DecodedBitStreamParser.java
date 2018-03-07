package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: event_location_summary_copy_address */
final class DecodedBitStreamParser {
    private static final char[] f13534a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    private DecodedBitStreamParser() {
    }

    static DecoderResult m13752a(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) {
        String str = null;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        boolean z = false;
        List arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        while (true) {
            Mode mode;
            boolean z2;
            if (bitSource.m13680a() < 4) {
                mode = Mode.TERMINATOR;
            } else {
                try {
                    mode = Mode.forBits(bitSource.m13681a(4));
                } catch (IllegalArgumentException e) {
                    throw FormatException.m13651a();
                }
            }
            if (mode == Mode.TERMINATOR) {
                z2 = z;
            } else if (mode == Mode.FNC1_FIRST_POSITION || mode == Mode.FNC1_SECOND_POSITION) {
                z2 = true;
            } else if (mode == Mode.STRUCTURED_APPEND) {
                if (bitSource.m13680a() < 16) {
                    throw FormatException.m13651a();
                }
                bitSource.m13681a(16);
                z2 = z;
            } else if (mode == Mode.ECI) {
                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(m13751a(bitSource));
                if (characterSetECI == null) {
                    throw FormatException.m13651a();
                }
                z2 = z;
            } else if (mode == Mode.HANZI) {
                r2 = bitSource.m13681a(4);
                int a = bitSource.m13681a(mode.getCharacterCountBits(version));
                if (r2 == 1) {
                    m13753a(bitSource, stringBuilder, a);
                }
                z2 = z;
            } else {
                r2 = bitSource.m13681a(mode.getCharacterCountBits(version));
                if (mode == Mode.NUMERIC) {
                    m13757c(bitSource, stringBuilder, r2);
                    z2 = z;
                } else if (mode == Mode.ALPHANUMERIC) {
                    m13755a(bitSource, stringBuilder, r2, z);
                    z2 = z;
                } else if (mode == Mode.BYTE) {
                    m13754a(bitSource, stringBuilder, r2, characterSetECI, arrayList, map);
                    z2 = z;
                } else if (mode == Mode.KANJI) {
                    m13756b(bitSource, stringBuilder, r2);
                    z2 = z;
                } else {
                    throw FormatException.m13651a();
                }
            }
            if (mode == Mode.TERMINATOR) {
                break;
            }
            z = z2;
        }
        String stringBuilder2 = stringBuilder.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (errorCorrectionLevel != null) {
            str = errorCorrectionLevel.toString();
        }
        return new DecoderResult(bArr, stringBuilder2, arrayList, str);
    }

    private static void m13753a(BitSource bitSource, StringBuilder stringBuilder, int i) {
        if (i * 13 > bitSource.m13680a()) {
            throw FormatException.m13651a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = bitSource.m13681a(13);
            a = (a % 96) | ((a / 96) << 8);
            if (a < 959) {
                a += 41377;
            } else {
                a += 42657;
            }
            bArr[i2] = (byte) ((a >> 8) & 255);
            bArr[i2 + 1] = (byte) (a & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m13651a();
        }
    }

    private static void m13756b(BitSource bitSource, StringBuilder stringBuilder, int i) {
        if (i * 13 > bitSource.m13680a()) {
            throw FormatException.m13651a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = bitSource.m13681a(13);
            a = (a % 192) | ((a / 192) << 8);
            if (a < 7936) {
                a += 33088;
            } else {
                a += 49472;
            }
            bArr[i2] = (byte) (a >> 8);
            bArr[i2 + 1] = (byte) a;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m13651a();
        }
    }

    private static void m13754a(BitSource bitSource, StringBuilder stringBuilder, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        if ((i << 3) > bitSource.m13680a()) {
            throw FormatException.m13651a();
        }
        String a;
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) bitSource.m13681a(8);
        }
        if (characterSetECI == null) {
            a = StringUtils.m13699a(obj, map);
        } else {
            a = characterSetECI.name();
        }
        try {
            stringBuilder.append(new String(obj, a));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m13651a();
        }
    }

    private static char m13750a(int i) {
        if (i < f13534a.length) {
            return f13534a[i];
        }
        throw FormatException.f13453a;
    }

    private static void m13755a(BitSource bitSource, StringBuilder stringBuilder, int i, boolean z) {
        int length = stringBuilder.length();
        while (i > 1) {
            if (bitSource.m13680a() < 11) {
                throw FormatException.f13453a;
            }
            int a = bitSource.m13681a(11);
            stringBuilder.append(m13750a(a / 45));
            stringBuilder.append(m13750a(a % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.m13680a() < 6) {
                throw FormatException.f13453a;
            }
            stringBuilder.append(m13750a(bitSource.m13681a(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void m13757c(BitSource bitSource, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (bitSource.m13680a() < 10) {
                throw FormatException.f13453a;
            }
            int a = bitSource.m13681a(10);
            if (a >= 1000) {
                throw FormatException.f13453a;
            }
            stringBuilder.append(m13750a(a / 100));
            stringBuilder.append(m13750a((a / 10) % 10));
            stringBuilder.append(m13750a(a % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.m13680a() < 7) {
                throw FormatException.f13453a;
            }
            a = bitSource.m13681a(7);
            if (a >= 100) {
                throw FormatException.f13453a;
            }
            stringBuilder.append(m13750a(a / 10));
            stringBuilder.append(m13750a(a % 10));
        } else if (i != 1) {
        } else {
            if (bitSource.m13680a() < 4) {
                throw FormatException.f13453a;
            }
            a = bitSource.m13681a(4);
            if (a >= 10) {
                throw FormatException.f13453a;
            }
            stringBuilder.append(m13750a(a));
        }
    }

    private static int m13751a(BitSource bitSource) {
        int a = bitSource.m13681a(8);
        if ((a & 128) == 0) {
            return a & 127;
        }
        if ((a & 192) == 128) {
            return ((a & 63) << 8) | bitSource.m13681a(8);
        } else if ((a & 224) == 192) {
            return ((a & 31) << 16) | bitSource.m13681a(16);
        } else {
            throw FormatException.f13453a;
        }
    }
}
