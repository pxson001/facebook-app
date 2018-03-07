package android_src.mmsv2.pdu;

import android.util.SparseArray;
import com.facebook.debug.log.BLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* compiled from: service_intro_image */
public class PduParser {
    static final /* synthetic */ boolean f3849a;
    private static byte[] f3850e = null;
    private static byte[] f3851f = null;
    private ByteArrayInputStream f3852b = null;
    private PduHeaders f3853c = null;
    private PduBody f3854d = null;
    private final boolean f3855g;

    static {
        boolean z;
        if (PduParser.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f3849a = z;
    }

    public PduParser(byte[] bArr, boolean z) {
        this.f3852b = new ByteArrayInputStream(bArr);
        this.f3855g = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android_src.mmsv2.pdu.GenericPdu m3679a() {
        /*
        r15 = this;
        r5 = 153; // 0x99 float:2.14E-43 double:7.56E-322;
        r6 = 0;
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = 0;
        r1 = r15.f3852b;
        if (r1 != 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r1 = r15.f3852b;
        r1 = m3664a(r1);
        r15.f3853c = r1;
        r1 = r15.f3853c;
        if (r1 == 0) goto L_0x000a;
    L_0x0017:
        r1 = r15.f3853c;
        r2 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r4 = r1.m3651a(r2);
        r1 = r15.f3853c;
        r12 = 137; // 0x89 float:1.92E-43 double:6.77E-322;
        r10 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r13 = -1;
        r11 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        r7 = 0;
        if (r1 != 0) goto L_0x00ec;
    L_0x002c:
        r1 = r7;
        if (r1 == 0) goto L_0x000a;
    L_0x002f:
        r1 = r15.f3853c;
        r1 = r1.m3662f(r5);
        if (r1 == 0) goto L_0x0060;
    L_0x0037:
        r1 = r15.f3853c;
        r1 = r1.m3651a(r5);
        r2 = r1;
    L_0x003e:
        if (r3 == r4) goto L_0x0046;
    L_0x0040:
        r1 = 132; // 0x84 float:1.85E-43 double:6.5E-322;
        if (r1 != r4) goto L_0x0052;
    L_0x0044:
        if (r2 != r3) goto L_0x0052;
    L_0x0046:
        r1 = r15.f3852b;
        r1 = r15.m3669b(r1);
        r15.f3854d = r1;
        r1 = r15.f3854d;
        if (r1 == 0) goto L_0x000a;
    L_0x0052:
        switch(r4) {
            case 128: goto L_0x0056;
            case 129: goto L_0x0062;
            case 130: goto L_0x006a;
            case 131: goto L_0x0072;
            case 132: goto L_0x007a;
            case 133: goto L_0x00d1;
            case 134: goto L_0x00c8;
            case 135: goto L_0x00e3;
            case 136: goto L_0x00da;
            default: goto L_0x0055;
        };
    L_0x0055:
        goto L_0x000a;
    L_0x0056:
        r0 = new android_src.mmsv2.pdu.SendReq;
        r1 = r15.f3853c;
        r2 = r15.f3854d;
        r0.<init>(r1, r2);
        goto L_0x000a;
    L_0x0060:
        r2 = r3;
        goto L_0x003e;
    L_0x0062:
        r0 = new android_src.mmsv2.pdu.SendConf;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x006a:
        r0 = new android_src.mmsv2.pdu.NotificationInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x0072:
        r0 = new android_src.mmsv2.pdu.NotifyRespInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x007a:
        r1 = new android_src.mmsv2.pdu.RetrieveConf;
        r4 = r15.f3853c;
        r5 = r15.f3854d;
        r1.<init>(r4, r5);
        if (r2 == r3) goto L_0x0087;
    L_0x0085:
        r0 = r1;
        goto L_0x000a;
    L_0x0087:
        r2 = r1.m3729f();
        if (r2 == 0) goto L_0x000a;
    L_0x008d:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = "application/vnd.wap.multipart.mixed";
        r2 = r3.equals(r2);
        if (r2 != 0) goto L_0x00aa;
    L_0x009a:
        r2 = "application/vnd.wap.multipart.related";
        r2 = r3.equals(r2);
        if (r2 != 0) goto L_0x00aa;
    L_0x00a2:
        r2 = "application/vnd.wap.multipart.alternative";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x00ad;
    L_0x00aa:
        r0 = r1;
        goto L_0x000a;
    L_0x00ad:
        r2 = "application/vnd.wap.multipart.alternative";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x000a;
    L_0x00b5:
        r0 = r15.f3854d;
        r0 = r0.m3620a(r6);
        r2 = r15.f3854d;
        r2.m3621a();
        r2 = r15.f3854d;
        r2.m3622a(r6, r0);
        r0 = r1;
        goto L_0x000a;
    L_0x00c8:
        r0 = new android_src.mmsv2.pdu.DeliveryInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x00d1:
        r0 = new android_src.mmsv2.pdu.AcknowledgeInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x00da:
        r0 = new android_src.mmsv2.pdu.ReadOrigInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x00e3:
        r0 = new android_src.mmsv2.pdu.ReadRecInd;
        r1 = r15.f3853c;
        r0.<init>(r1);
        goto L_0x000a;
    L_0x00ec:
        r8 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r8 = r1.m3651a(r8);
        r9 = 141; // 0x8d float:1.98E-43 double:6.97E-322;
        r9 = r1.m3651a(r9);
        if (r9 == 0) goto L_0x002c;
    L_0x00fa:
        switch(r8) {
            case 128: goto L_0x00ff;
            case 129: goto L_0x0116;
            case 130: goto L_0x0126;
            case 131: goto L_0x0152;
            case 132: goto L_0x0162;
            case 133: goto L_0x0196;
            case 134: goto L_0x0174;
            case 135: goto L_0x01c6;
            case 136: goto L_0x019e;
            default: goto L_0x00fd;
        };
    L_0x00fd:
        goto L_0x002c;
    L_0x00ff:
        r8 = 132; // 0x84 float:1.85E-43 double:6.5E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x0107:
        r8 = r1.m3659c(r12);
        if (r8 == 0) goto L_0x002c;
    L_0x010d:
        r8 = r1.m3658b(r11);
        if (r8 == 0) goto L_0x002c;
    L_0x0113:
        r7 = 1;
        goto L_0x002c;
    L_0x0116:
        r8 = 146; // 0x92 float:2.05E-43 double:7.2E-322;
        r8 = r1.m3651a(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x011e:
        r8 = r1.m3658b(r11);
        if (r8 != 0) goto L_0x0113;
    L_0x0124:
        goto L_0x002c;
    L_0x0126:
        r8 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x012e:
        r8 = 136; // 0x88 float:1.9E-43 double:6.7E-322;
        r9 = r1.m3661e(r8);
        r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r8 == 0) goto L_0x002c;
    L_0x0138:
        r8 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x0140:
        r8 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        r9 = r1.m3661e(r8);
        r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r8 == 0) goto L_0x002c;
    L_0x014a:
        r8 = r1.m3658b(r11);
        if (r8 != 0) goto L_0x0113;
    L_0x0150:
        goto L_0x002c;
    L_0x0152:
        r8 = 149; // 0x95 float:2.09E-43 double:7.36E-322;
        r8 = r1.m3651a(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x015a:
        r8 = r1.m3658b(r11);
        if (r8 != 0) goto L_0x0113;
    L_0x0160:
        goto L_0x002c;
    L_0x0162:
        r8 = 132; // 0x84 float:1.85E-43 double:6.5E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x016a:
        r9 = r1.m3661e(r10);
        r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r8 != 0) goto L_0x0113;
    L_0x0172:
        goto L_0x002c;
    L_0x0174:
        r9 = r1.m3661e(r10);
        r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r8 == 0) goto L_0x002c;
    L_0x017c:
        r8 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x0184:
        r8 = 149; // 0x95 float:2.09E-43 double:7.36E-322;
        r8 = r1.m3651a(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x018c:
        r8 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r8 = r1.m3660d(r8);
        if (r8 != 0) goto L_0x0113;
    L_0x0194:
        goto L_0x002c;
    L_0x0196:
        r8 = r1.m3658b(r11);
        if (r8 != 0) goto L_0x0113;
    L_0x019c:
        goto L_0x002c;
    L_0x019e:
        r9 = r1.m3661e(r10);
        r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r8 == 0) goto L_0x002c;
    L_0x01a6:
        r8 = r1.m3659c(r12);
        if (r8 == 0) goto L_0x002c;
    L_0x01ac:
        r8 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x01b4:
        r8 = 155; // 0x9b float:2.17E-43 double:7.66E-322;
        r8 = r1.m3651a(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x01bc:
        r8 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r8 = r1.m3660d(r8);
        if (r8 != 0) goto L_0x0113;
    L_0x01c4:
        goto L_0x002c;
    L_0x01c6:
        r8 = r1.m3659c(r12);
        if (r8 == 0) goto L_0x002c;
    L_0x01cc:
        r8 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r8 = r1.m3658b(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x01d4:
        r8 = 155; // 0x9b float:2.17E-43 double:7.66E-322;
        r8 = r1.m3651a(r8);
        if (r8 == 0) goto L_0x002c;
    L_0x01dc:
        r8 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r8 = r1.m3660d(r8);
        if (r8 != 0) goto L_0x0113;
    L_0x01e4:
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.pdu.PduParser.a():android_src.mmsv2.pdu.GenericPdu");
    }

    private static PduHeaders m3664a(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream == null) {
            return null;
        }
        PduHeaders pduHeaders = new PduHeaders();
        int i = 1;
        while (i != 0 && byteArrayInputStream.available() > 0) {
            byteArrayInputStream.mark(1);
            int f = m3675f(byteArrayInputStream);
            if (f < 32 || f > 127) {
                byte[] b;
                int indexOf;
                byte[] a;
                int f2;
                EncodedStringValue e;
                switch (f) {
                    case 129:
                    case 130:
                    case 151:
                        EncodedStringValue e2 = m3674e(byteArrayInputStream);
                        if (e2 != null) {
                            b = e2.m3609b();
                            if (b != null) {
                                String str = new String(b);
                                indexOf = str.indexOf("/");
                                if (indexOf > 0) {
                                    str = str.substring(0, indexOf);
                                }
                                try {
                                    e2.m3607a(str.getBytes());
                                } catch (NullPointerException e3) {
                                    return null;
                                }
                            }
                            try {
                                pduHeaders.m3657b(e2, f);
                                break;
                            } catch (NullPointerException e4) {
                                break;
                            } catch (RuntimeException e5) {
                                new StringBuilder().append(f).append("is not Encoded-String-Value header field!");
                                return null;
                            }
                        }
                        continue;
                    case 131:
                    case 139:
                    case 152:
                    case 158:
                    case 183:
                    case 184:
                    case 185:
                    case 189:
                    case 190:
                        a = m3667a(byteArrayInputStream, 0);
                        if (a != null) {
                            try {
                                pduHeaders.m3655a(a, f);
                                break;
                            } catch (NullPointerException e6) {
                                break;
                            } catch (RuntimeException e7) {
                                new StringBuilder().append(f).append("is not Text-String header field!");
                                return null;
                            }
                        }
                        continue;
                    case 132:
                        SparseArray sparseArray = new SparseArray();
                        byte[] a2 = m3668a(byteArrayInputStream, sparseArray);
                        if (a2 != null) {
                            try {
                                pduHeaders.m3655a(a2, 132);
                            } catch (NullPointerException e8) {
                            } catch (RuntimeException e9) {
                                new StringBuilder().append(f).append("is not Text-String header field!");
                                return null;
                            }
                        }
                        f3851f = (byte[]) sparseArray.get(153);
                        f3850e = (byte[]) sparseArray.get(131);
                        i = 0;
                        break;
                    case 133:
                    case 142:
                    case 159:
                        try {
                            pduHeaders.m3653a(m3677h(byteArrayInputStream), f);
                            break;
                        } catch (RuntimeException e10) {
                            new StringBuilder().append(f).append("is not Long-Integer header field!");
                            return null;
                        }
                    case 134:
                    case 143:
                    case 144:
                    case 145:
                    case 146:
                    case 148:
                    case 149:
                    case 153:
                    case 155:
                    case 156:
                    case 162:
                    case 163:
                    case 165:
                    case 167:
                    case 169:
                    case 171:
                    case 177:
                    case 180:
                    case 186:
                    case 187:
                    case 188:
                    case 191:
                        f2 = m3675f(byteArrayInputStream);
                        try {
                            pduHeaders.m3652a(f2, f);
                            break;
                        } catch (InvalidHeaderValueException e11) {
                            new StringBuilder("Set invalid Octet value: ").append(f2).append(" into the header filed: ").append(f);
                            return null;
                        } catch (RuntimeException e12) {
                            new StringBuilder().append(f).append("is not Octet header field!");
                            return null;
                        }
                    case 135:
                    case 136:
                    case 157:
                        m3673d(byteArrayInputStream);
                        indexOf = m3675f(byteArrayInputStream);
                        try {
                            long h = m3677h(byteArrayInputStream);
                            if (129 == indexOf) {
                                h += System.currentTimeMillis() / 1000;
                            }
                            try {
                                pduHeaders.m3653a(h, f);
                                break;
                            } catch (RuntimeException e13) {
                                new StringBuilder().append(f).append("is not Long-Integer header field!");
                                return null;
                            }
                        } catch (RuntimeException e14) {
                            new StringBuilder().append(f).append("is not Long-Integer header field!");
                            return null;
                        }
                    case 137:
                        m3673d(byteArrayInputStream);
                        if (128 == m3675f(byteArrayInputStream)) {
                            e = m3674e(byteArrayInputStream);
                            if (e != null) {
                                b = e.m3609b();
                                if (b != null) {
                                    String str2 = new String(b);
                                    indexOf = str2.indexOf("/");
                                    if (indexOf > 0) {
                                        str2 = str2.substring(0, indexOf);
                                    }
                                    try {
                                        e.m3607a(str2.getBytes());
                                    } catch (NullPointerException e15) {
                                        return null;
                                    }
                                }
                            }
                        }
                        try {
                            e = new EncodedStringValue("insert-address-token".getBytes());
                        } catch (NullPointerException e16) {
                            new StringBuilder().append(f).append("is not Encoded-String-Value header field!");
                            return null;
                        }
                        try {
                            pduHeaders.m3654a(e, 137);
                            break;
                        } catch (NullPointerException e17) {
                            break;
                        } catch (RuntimeException e18) {
                            new StringBuilder().append(f).append("is not Encoded-String-Value header field!");
                            return null;
                        }
                    case 138:
                        byteArrayInputStream.mark(1);
                        f2 = m3675f(byteArrayInputStream);
                        if (f2 >= 128) {
                            if (128 != f2) {
                                if (129 != f2) {
                                    if (130 != f2) {
                                        if (131 != f2) {
                                            break;
                                        }
                                        pduHeaders.m3655a("auto".getBytes(), 138);
                                        break;
                                    }
                                    pduHeaders.m3655a("informational".getBytes(), 138);
                                    break;
                                }
                                pduHeaders.m3655a("advertisement".getBytes(), 138);
                                break;
                            }
                            try {
                                pduHeaders.m3655a("personal".getBytes(), 138);
                                break;
                            } catch (NullPointerException e19) {
                                break;
                            } catch (RuntimeException e20) {
                                new StringBuilder().append(f).append("is not Text-String header field!");
                                return null;
                            }
                        }
                        byteArrayInputStream.reset();
                        a = m3667a(byteArrayInputStream, 0);
                        if (a != null) {
                            try {
                                pduHeaders.m3655a(a, 138);
                                break;
                            } catch (NullPointerException e21) {
                                break;
                            } catch (RuntimeException e22) {
                                new StringBuilder().append(f).append("is not Text-String header field!");
                                return null;
                            }
                        }
                        continue;
                    case 140:
                        f2 = m3675f(byteArrayInputStream);
                        switch (f2) {
                            case 137:
                            case 138:
                            case 139:
                            case 140:
                            case 141:
                            case 142:
                            case 143:
                            case 144:
                            case 145:
                            case 146:
                            case 147:
                            case 148:
                            case 149:
                            case 150:
                            case 151:
                                return null;
                            default:
                                try {
                                    pduHeaders.m3652a(f2, f);
                                    break;
                                } catch (InvalidHeaderValueException e23) {
                                    new StringBuilder("Set invalid Octet value: ").append(f2).append(" into the header filed: ").append(f);
                                    return null;
                                } catch (RuntimeException e24) {
                                    new StringBuilder().append(f).append("is not Octet header field!");
                                    return null;
                                }
                        }
                    case 141:
                        f2 = m3676g(byteArrayInputStream);
                        try {
                            pduHeaders.m3652a(f2, 141);
                            break;
                        } catch (InvalidHeaderValueException e25) {
                            new StringBuilder("Set invalid Octet value: ").append(f2).append(" into the header filed: ").append(f);
                            return null;
                        } catch (RuntimeException e26) {
                            new StringBuilder().append(f).append("is not Octet header field!");
                            return null;
                        }
                    case 147:
                    case 150:
                    case 154:
                    case 166:
                    case 181:
                    case 182:
                        e = m3674e(byteArrayInputStream);
                        if (e != null) {
                            try {
                                pduHeaders.m3654a(e, f);
                                break;
                            } catch (NullPointerException e27) {
                                break;
                            } catch (RuntimeException e28) {
                                new StringBuilder().append(f).append("is not Encoded-String-Value header field!");
                                return null;
                            }
                        }
                        continue;
                    case 160:
                        m3673d(byteArrayInputStream);
                        try {
                            m3678i(byteArrayInputStream);
                            e = m3674e(byteArrayInputStream);
                            if (e != null) {
                                try {
                                    pduHeaders.m3654a(e, 160);
                                    break;
                                } catch (NullPointerException e29) {
                                    break;
                                } catch (RuntimeException e30) {
                                    new StringBuilder().append(f).append("is not Encoded-String-Value header field!");
                                    return null;
                                }
                            }
                            continue;
                        } catch (RuntimeException e31) {
                            new StringBuilder().append(f).append(" is not Integer-Value");
                            return null;
                        }
                    case 161:
                        m3673d(byteArrayInputStream);
                        try {
                            m3678i(byteArrayInputStream);
                            try {
                                pduHeaders.m3653a(m3677h(byteArrayInputStream), 161);
                                break;
                            } catch (RuntimeException e32) {
                                new StringBuilder().append(f).append("is not Long-Integer header field!");
                                return null;
                            }
                        } catch (RuntimeException e33) {
                            new StringBuilder().append(f).append(" is not Integer-Value");
                            return null;
                        }
                    case 164:
                        m3673d(byteArrayInputStream);
                        m3675f(byteArrayInputStream);
                        m3674e(byteArrayInputStream);
                        break;
                    case 170:
                    case 172:
                        m3673d(byteArrayInputStream);
                        m3675f(byteArrayInputStream);
                        try {
                            m3678i(byteArrayInputStream);
                            break;
                        } catch (RuntimeException e34) {
                            new StringBuilder().append(f).append(" is not Integer-Value");
                            return null;
                        }
                    case 173:
                    case 175:
                    case 179:
                        try {
                            pduHeaders.m3653a(m3678i(byteArrayInputStream), f);
                            break;
                        } catch (RuntimeException e35) {
                            new StringBuilder().append(f).append("is not Long-Integer header field!");
                            return null;
                        }
                    case 178:
                        m3668a(byteArrayInputStream, null);
                        break;
                    default:
                        break;
                }
            }
            byteArrayInputStream.reset();
            m3667a(byteArrayInputStream, 0);
        }
        return pduHeaders;
    }

    private PduBody m3669b(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream == null) {
            return null;
        }
        int c = m3671c(byteArrayInputStream);
        PduBody pduBody = new PduBody();
        for (int i = 0; i < c; i++) {
            int c2 = m3671c(byteArrayInputStream);
            int c3 = m3671c(byteArrayInputStream);
            PduPart pduPart = new PduPart();
            int available = byteArrayInputStream.available();
            if (available <= 0) {
                return null;
            }
            PduPart a;
            SparseArray sparseArray = new SparseArray();
            byte[] a2 = m3668a(byteArrayInputStream, sparseArray);
            if (a2 != null) {
                pduPart.m3690e(a2);
            } else {
                pduPart.m3690e(PduContentTypes.f3847a[0].getBytes());
            }
            a2 = (byte[]) sparseArray.get(151);
            if (a2 != null) {
                pduPart.m3693g(a2);
            }
            Integer num = (Integer) sparseArray.get(129);
            if (num != null) {
                pduPart.m3680a(num.intValue());
            }
            int available2 = c2 - (available - byteArrayInputStream.available());
            if (available2 > 0) {
                if (!m3666a(byteArrayInputStream, pduPart, available2)) {
                    return null;
                }
            } else if (available2 < 0) {
                return null;
            }
            if (pduPart.m3691e() == null && pduPart.m3696i() == null && pduPart.m3697j() == null && pduPart.m3687c() == null) {
                pduPart.m3686c(Long.toOctalString(System.currentTimeMillis()).getBytes());
            }
            if (c3 > 0) {
                a2 = new byte[c3];
                String str = new String(pduPart.m3694g());
                byteArrayInputStream.read(a2, 0, c3);
                if (str.equalsIgnoreCase("application/vnd.wap.multipart.alternative")) {
                    a = m3669b(new ByteArrayInputStream(a2)).m3620a(0);
                    if (m3663a(a) != 0) {
                        pduBody.m3622a(0, a);
                    } else {
                        pduBody.m3623a(a);
                    }
                } else {
                    byte[] bArr = (byte[]) pduPart.f3859d.get(200);
                    if (bArr != null) {
                        String str2 = new String(bArr);
                        if (str2.equalsIgnoreCase("base64")) {
                            a2 = Base64.m3596a(a2);
                        } else if (str2.equalsIgnoreCase("quoted-printable")) {
                            a2 = QuotedPrintable.m3724a(a2);
                        }
                    }
                    if (a2 == null) {
                        return null;
                    }
                    pduPart.f3861f = a2;
                }
            }
            a = pduPart;
            if (m3663a(a) != 0) {
                pduBody.m3623a(a);
            } else {
                pduBody.m3622a(0, a);
            }
        }
        return pduBody;
    }

    private static int m3671c(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            int i = 0;
            int read = byteArrayInputStream.read();
            if (read == -1) {
                return read;
            }
            while ((read & 128) != 0) {
                i = (i << 7) | (read & 127);
                read = byteArrayInputStream.read();
                if (read == -1) {
                    return read;
                }
            }
            return (read & 127) | (i << 7);
        }
        throw new AssertionError();
    }

    private static int m3673d(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                read &= 255;
                if (read <= 30) {
                    return read;
                }
                if (read == 31) {
                    return m3671c(byteArrayInputStream);
                }
                throw new RuntimeException("Value length > LENGTH_QUOTE!");
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static EncodedStringValue m3674e(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            byteArrayInputStream.mark(1);
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                read &= 255;
                if (read == 0) {
                    return null;
                }
                byteArrayInputStream.reset();
                if (read < 32) {
                    m3673d(byteArrayInputStream);
                    read = m3676g(byteArrayInputStream);
                } else {
                    read = 0;
                }
                byte[] a = m3667a(byteArrayInputStream, 0);
                if (read == 0) {
                    return new EncodedStringValue(a);
                }
                try {
                    return new EncodedStringValue(read, a);
                } catch (Exception e) {
                    return null;
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static byte[] m3667a(ByteArrayInputStream byteArrayInputStream, int i) {
        if (f3849a || byteArrayInputStream != null) {
            byteArrayInputStream.mark(1);
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                if (1 == i && 34 == read) {
                    byteArrayInputStream.mark(1);
                } else if (i == 0 && 127 == read) {
                    byteArrayInputStream.mark(1);
                } else {
                    byteArrayInputStream.reset();
                }
                return m3670b(byteArrayInputStream, i);
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static byte[] m3670b(ByteArrayInputStream byteArrayInputStream, int i) {
        if (f3849a || byteArrayInputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                while (-1 != read && read != 0) {
                    Object obj;
                    if (i == 2) {
                        obj = null;
                        if (read >= 33 && read <= 126) {
                            switch (read) {
                                case 34:
                                case 40:
                                case 41:
                                case 44:
                                case 47:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 91:
                                case 92:
                                case 93:
                                case 123:
                                case 125:
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                        }
                        if (obj != null) {
                            byteArrayOutputStream.write(read);
                        }
                    } else {
                        obj = 1;
                        if ((read < 32 || read > 126) && (read < 128 || read > 255)) {
                            switch (read) {
                                case 9:
                                case 10:
                                case 13:
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                        }
                        if (obj != null) {
                            byteArrayOutputStream.write(read);
                        }
                    }
                    read = byteArrayInputStream.read();
                    if (!f3849a && -1 == read) {
                        throw new AssertionError();
                    }
                }
                if (byteArrayOutputStream.size() > 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                return null;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static int m3675f(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                return read & 255;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static int m3676g(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                return read & 127;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static long m3677h(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                int i = read & 255;
                if (i > 8) {
                    throw new RuntimeException("Octet count greater than 8 and I can't represent that!");
                }
                long j = 0;
                read = 0;
                while (read < i) {
                    int read2 = byteArrayInputStream.read();
                    if (f3849a || -1 != read2) {
                        j = (j << 8) + ((long) (read2 & 255));
                        read++;
                    } else {
                        throw new AssertionError();
                    }
                }
                return j;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static long m3678i(ByteArrayInputStream byteArrayInputStream) {
        if (f3849a || byteArrayInputStream != null) {
            byteArrayInputStream.mark(1);
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                byteArrayInputStream.reset();
                if (read > 127) {
                    return (long) m3676g(byteArrayInputStream);
                }
                return m3677h(byteArrayInputStream);
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private static int m3672c(ByteArrayInputStream byteArrayInputStream, int i) {
        if (f3849a || byteArrayInputStream != null) {
            int read = byteArrayInputStream.read(new byte[i], 0, i);
            if (read < i) {
                return -1;
            }
            return read;
        }
        throw new AssertionError();
    }

    private static void m3665a(ByteArrayInputStream byteArrayInputStream, SparseArray<Object> sparseArray, Integer num) {
        if (!f3849a && byteArrayInputStream == null) {
            throw new AssertionError();
        } else if (f3849a || num.intValue() > 0) {
            int available = byteArrayInputStream.available();
            int intValue = num.intValue();
            while (intValue > 0) {
                int read = byteArrayInputStream.read();
                if (f3849a || -1 != read) {
                    intValue--;
                    Object a;
                    switch (read) {
                        case 129:
                            byteArrayInputStream.mark(1);
                            intValue = m3675f(byteArrayInputStream);
                            byteArrayInputStream.reset();
                            if ((intValue <= 32 || intValue >= 127) && intValue != 0) {
                                intValue = (int) m3678i(byteArrayInputStream);
                                if (sparseArray != null) {
                                    sparseArray.put(129, Integer.valueOf(intValue));
                                }
                            } else {
                                byte[] a2 = m3667a(byteArrayInputStream, 0);
                                try {
                                    sparseArray.put(129, Integer.valueOf(CharacterSets.m3598a(new String(a2))));
                                } catch (Throwable e) {
                                    BLog.b("PduParser", Arrays.toString(a2), e);
                                    sparseArray.put(129, Integer.valueOf(0));
                                }
                            }
                            intValue = num.intValue() - (available - byteArrayInputStream.available());
                            break;
                        case 131:
                        case 137:
                            byteArrayInputStream.mark(1);
                            intValue = m3675f(byteArrayInputStream);
                            byteArrayInputStream.reset();
                            if (intValue > 127) {
                                intValue = m3676g(byteArrayInputStream);
                                if (intValue < PduContentTypes.f3847a.length) {
                                    sparseArray.put(131, PduContentTypes.f3847a[intValue].getBytes());
                                }
                            } else {
                                a = m3667a(byteArrayInputStream, 0);
                                if (!(a == null || sparseArray == null)) {
                                    sparseArray.put(131, a);
                                }
                            }
                            intValue = num.intValue() - (available - byteArrayInputStream.available());
                            break;
                        case 133:
                        case 151:
                            a = m3667a(byteArrayInputStream, 0);
                            if (!(a == null || sparseArray == null)) {
                                sparseArray.put(151, a);
                            }
                            intValue = num.intValue() - (available - byteArrayInputStream.available());
                            break;
                        case 138:
                        case 153:
                            a = m3667a(byteArrayInputStream, 0);
                            if (!(a == null || sparseArray == null)) {
                                sparseArray.put(153, a);
                            }
                            intValue = num.intValue() - (available - byteArrayInputStream.available());
                            break;
                        default:
                            if (-1 != m3672c(byteArrayInputStream, intValue)) {
                                intValue = 0;
                                break;
                            } else {
                                BLog.b("PduParser", "Corrupt Content-Type");
                                break;
                            }
                    }
                }
                throw new AssertionError();
            }
            if (intValue != 0) {
                BLog.b("PduParser", "Corrupt Content-Type");
            }
        } else {
            throw new AssertionError();
        }
    }

    private static byte[] m3668a(ByteArrayInputStream byteArrayInputStream, SparseArray<Object> sparseArray) {
        if (f3849a || byteArrayInputStream != null) {
            byteArrayInputStream.mark(1);
            int read = byteArrayInputStream.read();
            if (f3849a || -1 != read) {
                byteArrayInputStream.reset();
                read &= 255;
                if (read < 32) {
                    int d = m3673d(byteArrayInputStream);
                    int available = byteArrayInputStream.available();
                    byteArrayInputStream.mark(1);
                    read = byteArrayInputStream.read();
                    if (f3849a || -1 != read) {
                        byte[] a;
                        byteArrayInputStream.reset();
                        read &= 255;
                        if (read >= 32 && read <= 127) {
                            a = m3667a(byteArrayInputStream, 0);
                        } else if (read > 127) {
                            read = m3676g(byteArrayInputStream);
                            if (read < PduContentTypes.f3847a.length) {
                                a = PduContentTypes.f3847a[read].getBytes();
                            } else {
                                byteArrayInputStream.reset();
                                a = m3667a(byteArrayInputStream, 0);
                            }
                        } else {
                            BLog.b("PduParser", "Corrupt content-type");
                            return PduContentTypes.f3847a[0].getBytes();
                        }
                        d -= available - byteArrayInputStream.available();
                        if (d > 0) {
                            m3665a(byteArrayInputStream, (SparseArray) sparseArray, Integer.valueOf(d));
                        }
                        if (d >= 0) {
                            return a;
                        }
                        BLog.b("PduParser", "Corrupt MMS message");
                        return PduContentTypes.f3847a[0].getBytes();
                    }
                    throw new AssertionError();
                } else if (read <= 127) {
                    return m3667a(byteArrayInputStream, 0);
                } else {
                    return PduContentTypes.f3847a[m3676g(byteArrayInputStream)].getBytes();
                }
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private boolean m3666a(ByteArrayInputStream byteArrayInputStream, PduPart pduPart, int i) {
        if (!f3849a && byteArrayInputStream == null) {
            throw new AssertionError();
        } else if (!f3849a && pduPart == null) {
            throw new AssertionError();
        } else if (f3849a || i > 0) {
            int available = byteArrayInputStream.available();
            int i2 = i;
            while (i2 > 0) {
                int read = byteArrayInputStream.read();
                if (f3849a || -1 != read) {
                    i2--;
                    byte[] a;
                    if (read > 127) {
                        switch (read) {
                            case 142:
                                a = m3667a(byteArrayInputStream, 0);
                                if (a != null) {
                                    pduPart.m3686c(a);
                                }
                                i2 = i - (available - byteArrayInputStream.available());
                                break;
                            case 174:
                            case 197:
                                if (!this.f3855g) {
                                    break;
                                }
                                i2 = m3673d(byteArrayInputStream);
                                byteArrayInputStream.mark(1);
                                read = byteArrayInputStream.available();
                                int read2 = byteArrayInputStream.read();
                                if (read2 == 128) {
                                    pduPart.m3689d(PduPart.f3856a);
                                } else if (read2 == 129) {
                                    pduPart.m3689d(PduPart.f3857b);
                                } else if (read2 == 130) {
                                    pduPart.m3689d(PduPart.f3858c);
                                } else {
                                    byteArrayInputStream.reset();
                                    pduPart.m3689d(m3667a(byteArrayInputStream, 0));
                                }
                                if (read - byteArrayInputStream.available() < i2) {
                                    if (byteArrayInputStream.read() == 152) {
                                        pduPart.m3695h(m3667a(byteArrayInputStream, 0));
                                    }
                                    read2 = byteArrayInputStream.available();
                                    if (read - read2 < i2) {
                                        i2 -= read - read2;
                                        byteArrayInputStream.read(new byte[i2], 0, i2);
                                    }
                                }
                                i2 = i - (available - byteArrayInputStream.available());
                                break;
                            case 192:
                                a = m3667a(byteArrayInputStream, 1);
                                if (a != null) {
                                    pduPart.m3685b(a);
                                }
                                i2 = i - (available - byteArrayInputStream.available());
                                break;
                            default:
                                if (-1 != m3672c(byteArrayInputStream, i2)) {
                                    i2 = 0;
                                    break;
                                }
                                BLog.b("PduParser", "Corrupt Part headers");
                                return false;
                        }
                    } else if (read >= 32 && read <= 127) {
                        a = m3667a(byteArrayInputStream, 0);
                        byte[] a2 = m3667a(byteArrayInputStream, 0);
                        if (true == "Content-Transfer-Encoding".equalsIgnoreCase(new String(a))) {
                            pduPart.m3692f(a2);
                        }
                        i2 = i - (available - byteArrayInputStream.available());
                    } else if (-1 == m3672c(byteArrayInputStream, i2)) {
                        BLog.b("PduParser", "Corrupt Part headers");
                        return false;
                    } else {
                        i2 = 0;
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (i2 == 0) {
                return true;
            }
            BLog.b("PduParser", "Corrupt Part headers");
            return false;
        } else {
            throw new AssertionError();
        }
    }

    private static int m3663a(PduPart pduPart) {
        if (!f3849a && pduPart == null) {
            throw new AssertionError();
        } else if (f3850e == null && f3851f == null) {
            return 1;
        } else {
            byte[] c;
            if (f3851f != null) {
                c = pduPart.m3687c();
                if (c == null || true != Arrays.equals(f3851f, c)) {
                    return 1;
                }
                return 0;
            } else if (f3850e == null) {
                return 1;
            } else {
                c = pduPart.m3694g();
                if (c == null || true != Arrays.equals(f3850e, c)) {
                    return 1;
                }
                return 0;
            }
        }
    }
}
