package android_src.mmsv2.pdu;

import com.facebook.debug.log.BLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: setActiveSession */
public class EncodedStringValue implements Cloneable {
    public int f3825a;
    private byte[] f3826b;

    public EncodedStringValue(int i, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        }
        this.f3825a = i;
        this.f3826b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f3826b, 0, bArr.length);
    }

    public EncodedStringValue(byte[] bArr) {
        this(106, bArr);
    }

    private EncodedStringValue(String str) {
        this(106, str);
    }

    public EncodedStringValue(int i, String str) {
        if (str == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null");
        }
        this.f3825a = i;
        try {
            this.f3826b = str.getBytes(CharacterSets.m3599a(i));
        } catch (Throwable e) {
            BLog.b("EncodedStringValue", "Input encoding " + i + " must be supported.", e);
            this.f3826b = str.getBytes();
        }
    }

    public final int m3606a() {
        return this.f3825a;
    }

    public final byte[] m3609b() {
        Object obj = new byte[this.f3826b.length];
        System.arraycopy(this.f3826b, 0, obj, 0, this.f3826b.length);
        return obj;
    }

    public final void m3607a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("EncodedStringValue: Text-string is null.");
        }
        this.f3826b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f3826b, 0, bArr.length);
    }

    public final String m3610c() {
        if (this.f3825a == 0) {
            return new String(this.f3826b);
        }
        try {
            return new String(this.f3826b, CharacterSets.m3599a(this.f3825a));
        } catch (UnsupportedEncodingException e) {
            try {
                return new String(this.f3826b, "iso-8859-1");
            } catch (UnsupportedEncodingException e2) {
                return new String(this.f3826b);
            }
        }
    }

    public final void m3608b(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Text-string is null.");
        } else if (this.f3826b == null) {
            this.f3826b = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f3826b, 0, bArr.length);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.f3826b);
                byteArrayOutputStream.write(bArr);
                this.f3826b = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                throw new NullPointerException("appendTextString: failed when write a new Text-string");
            }
        }
    }

    public Object clone() {
        super.clone();
        int length = this.f3826b.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f3826b, 0, bArr, 0, length);
        try {
            return new EncodedStringValue(this.f3825a, bArr);
        } catch (Exception e) {
            BLog.b("EncodedStringValue", "failed to clone an EncodedStringValue: " + this);
            e.printStackTrace();
            throw new CloneNotSupportedException(e.getMessage());
        }
    }

    public static EncodedStringValue m3604a(EncodedStringValue encodedStringValue) {
        if (encodedStringValue == null) {
            return null;
        }
        return new EncodedStringValue(encodedStringValue.f3825a, encodedStringValue.f3826b);
    }

    public static EncodedStringValue[] m3605a(String[] strArr) {
        int length = strArr.length;
        if (length <= 0) {
            return null;
        }
        EncodedStringValue[] encodedStringValueArr = new EncodedStringValue[length];
        for (int i = 0; i < length; i++) {
            encodedStringValueArr[i] = new EncodedStringValue(strArr[i]);
        }
        return encodedStringValueArr;
    }
}
