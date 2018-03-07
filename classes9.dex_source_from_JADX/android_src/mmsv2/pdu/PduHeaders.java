package android_src.mmsv2.pdu;

import android.util.SparseArray;
import java.util.ArrayList;

/* compiled from: service_intro_logo */
public class PduHeaders {
    private SparseArray<Object> f3848a;

    public PduHeaders() {
        this.f3848a = null;
        this.f3848a = new SparseArray();
    }

    public final int m3651a(int i) {
        Integer num = (Integer) this.f3848a.get(i);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void m3652a(int i, int i2) {
        switch (i2) {
            case 134:
            case 144:
            case 145:
            case 148:
            case 162:
            case 167:
            case 169:
            case 171:
            case 177:
            case 187:
            case 188:
                if (!(128 == i || 129 == i)) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 140:
                if (i < 128 || i > 151) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 141:
                if (i < 16 || i > 19) {
                    i = 18;
                    break;
                }
            case 143:
                if (i < 128 || i > 130) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 146:
                if (i <= 196 || i >= 224) {
                    if ((i > 235 && i <= 255) || i < 128 || ((i > 136 && i < 192) || i > 255)) {
                        i = 224;
                        break;
                    }
                }
                i = 192;
                break;
                break;
            case 149:
                if (i < 128 || i > 135) {
                    i = 132;
                    break;
                }
            case 153:
                if (i <= 194 || i >= 224) {
                    if (i <= 227 || i > 255) {
                        if (i < 128 || ((i > 128 && i < 192) || i > 255)) {
                            i = 224;
                            break;
                        }
                    }
                    i = 224;
                    break;
                }
                i = 192;
                break;
                break;
            case 155:
                if (!(128 == i || 129 == i)) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 156:
                if (i < 128 || i > 131) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 163:
                if (i < 128 || i > 132) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 165:
                if (i <= 193 || i >= 224) {
                    if (i <= 228 || i > 255) {
                        if (i < 128 || ((i > 128 && i < 192) || i > 255)) {
                            i = 224;
                            break;
                        }
                    }
                    i = 224;
                    break;
                }
                i = 192;
                break;
                break;
            case 180:
                if (128 != i) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
                break;
            case 186:
                if (i < 128 || i > 135) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            case 191:
                if (!(128 == i || 129 == i)) {
                    throw new InvalidHeaderValueException("Invalid Octet value: " + i);
                }
            default:
                throw new RuntimeException("Invalid header field!");
        }
        this.f3848a.put(i2, Integer.valueOf(i));
    }

    public final byte[] m3658b(int i) {
        return (byte[]) this.f3848a.get(i);
    }

    public final void m3655a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 131:
            case 132:
            case 138:
            case 139:
            case 147:
            case 152:
            case 158:
            case 183:
            case 184:
            case 185:
            case 189:
            case 190:
                this.f3848a.put(i, bArr);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    public final EncodedStringValue m3659c(int i) {
        return (EncodedStringValue) this.f3848a.get(i);
    }

    public final EncodedStringValue[] m3660d(int i) {
        ArrayList arrayList = (ArrayList) this.f3848a.get(i);
        if (arrayList == null) {
            return null;
        }
        return (EncodedStringValue[]) arrayList.toArray(new EncodedStringValue[arrayList.size()]);
    }

    public final void m3654a(EncodedStringValue encodedStringValue, int i) {
        if (encodedStringValue == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 137:
            case 147:
            case 150:
            case 154:
            case 160:
            case 164:
            case 166:
            case 181:
            case 182:
                this.f3848a.put(i, encodedStringValue);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    protected final void m3656a(EncodedStringValue[] encodedStringValueArr, int i) {
        if (encodedStringValueArr == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 129:
            case 130:
            case 151:
                ArrayList arrayList = new ArrayList();
                for (Object add : encodedStringValueArr) {
                    arrayList.add(add);
                }
                this.f3848a.put(i, arrayList);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    protected final void m3657b(EncodedStringValue encodedStringValue, int i) {
        if (encodedStringValue == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 129:
            case 130:
            case 151:
                ArrayList arrayList = (ArrayList) this.f3848a.get(i);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(encodedStringValue);
                this.f3848a.put(i, arrayList);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    public final long m3661e(int i) {
        Long l = (Long) this.f3848a.get(i);
        if (l == null) {
            return -1;
        }
        return l.longValue();
    }

    public final void m3653a(long j, int i) {
        switch (i) {
            case 133:
            case 135:
            case 136:
            case 142:
            case 157:
            case 159:
            case 161:
            case 173:
            case 175:
            case 179:
                this.f3848a.put(i, Long.valueOf(j));
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    public final boolean m3662f(int i) {
        return this.f3848a.get(i, null) != null;
    }
}
