package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.InputStream;

/* compiled from: collection_item_type */
public class UTF32Reader extends BaseReader {
    protected final boolean f5952g;
    protected char f5953h = '\u0000';
    protected int f5954i = 0;
    protected int f5955j = 0;
    protected final boolean f5956k;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        super(iOContext, inputStream, bArr, i, i2);
        this.f5952g = z;
        if (inputStream != null) {
            z2 = true;
        }
        this.f5956k = z2;
    }

    public int read(char[] cArr, int i, int i2) {
        if (this.f5943c == null) {
            return -1;
        }
        if (i2 <= 0) {
            return i2;
        }
        int i3;
        int i4;
        if (i < 0 || i + i2 > cArr.length) {
            BaseReader.m10746a(cArr, i, i2);
        }
        int i5 = i2 + i;
        if (this.f5953h != '\u0000') {
            i3 = i + 1;
            cArr[i] = this.f5953h;
            this.f5953h = '\u0000';
        } else {
            i4 = this.f5945e - this.f5944d;
            if (i4 < 4 && !m10759a(i4)) {
                return -1;
            }
            i3 = i;
        }
        while (i3 < i5) {
            int i6 = this.f5944d;
            if (this.f5952g) {
                i6 = (this.f5943c[i6 + 3] & 255) | (((this.f5943c[i6] << 24) | ((this.f5943c[i6 + 1] & 255) << 16)) | ((this.f5943c[i6 + 2] & 255) << 8));
            } else {
                i6 = (this.f5943c[i6 + 3] << 24) | (((this.f5943c[i6] & 255) | ((this.f5943c[i6 + 1] & 255) << 8)) | ((this.f5943c[i6 + 2] & 255) << 16));
            }
            this.d = this.f5944d + 4;
            if (i6 > 65535) {
                if (i6 > 1114111) {
                    m10758a(i6, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                }
                i6 -= 65536;
                i4 = i3 + 1;
                cArr[i3] = (char) (55296 + (i6 >> 10));
                i6 = (i6 & 1023) | 56320;
                if (i4 >= i5) {
                    this.f5953h = (char) i6;
                    break;
                }
            }
            i4 = i3;
            i3 = i4 + 1;
            cArr[i4] = (char) i6;
            if (this.f5944d >= this.f5945e) {
                break;
            }
        }
        i4 = i3;
        i2 = i4 - i;
        this.f5954i += i2;
        return i2;
    }

    private void m10757a(int i, int i2) {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.f5954i + ", byte #" + (this.f5955j + i) + ")");
    }

    private void m10758a(int i, int i2, String str) {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.f5954i + i2) + ", byte #" + ((this.f5955j + this.f5944d) - 1) + ")");
    }

    private boolean m10759a(int i) {
        this.f5955j += this.f5945e - i;
        int i2;
        if (i > 0) {
            if (this.f5944d > 0) {
                for (i2 = 0; i2 < i; i2++) {
                    this.f5943c[i2] = this.f5943c[this.f5944d + i2];
                }
                this.d = 0;
            }
            this.e = i;
        } else {
            this.d = 0;
            i2 = this.f5942b == null ? -1 : this.f5942b.read(this.f5943c);
            if (i2 <= 0) {
                this.e = 0;
                if (i2 >= 0) {
                    BaseReader.m10747b();
                } else if (!this.f5956k) {
                    return false;
                } else {
                    m10748a();
                    return false;
                }
            }
            this.e = i2;
        }
        while (this.f5945e < 4) {
            int i3;
            if (this.f5942b == null) {
                i3 = -1;
            } else {
                i3 = this.f5942b.read(this.f5943c, this.f5945e, this.f5943c.length - this.f5945e);
            }
            if (i3 <= 0) {
                if (i3 < 0) {
                    if (this.f5956k) {
                        m10748a();
                    }
                    m10757a(this.f5945e, 4);
                }
                BaseReader.m10747b();
            }
            this.e = i3 + this.f5945e;
        }
        return true;
    }
}
