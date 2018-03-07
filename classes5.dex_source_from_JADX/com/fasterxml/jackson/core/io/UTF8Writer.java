package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* compiled from: collection */
public final class UTF8Writer extends Writer {
    private final IOContext f5957a;
    private OutputStream f5958b;
    private byte[] f5959c;
    private final int f5960d;
    private int f5961e;
    private int f5962f = 0;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this.f5957a = iOContext;
        this.f5958b = outputStream;
        this.f5959c = iOContext.f();
        this.f5960d = this.f5959c.length - 4;
        this.f5961e = 0;
    }

    public final Writer append(char c) {
        write((int) c);
        return this;
    }

    public final void close() {
        if (this.f5958b != null) {
            if (this.f5961e > 0) {
                this.f5958b.write(this.f5959c, 0, this.f5961e);
                this.f5961e = 0;
            }
            OutputStream outputStream = this.f5958b;
            this.f5958b = null;
            byte[] bArr = this.f5959c;
            if (bArr != null) {
                this.f5959c = null;
                this.f5957a.b(bArr);
            }
            outputStream.close();
            int i = this.f5962f;
            this.f5962f = 0;
            if (i > 0) {
                m10762c(i);
            }
        }
    }

    public final void flush() {
        if (this.f5958b != null) {
            if (this.f5961e > 0) {
                this.f5958b.write(this.f5959c, 0, this.f5961e);
                this.f5961e = 0;
            }
            this.f5958b.flush();
        }
    }

    public final void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    public final void write(char[] cArr, int i, int i2) {
        if (i2 >= 2) {
            int i3;
            if (this.f5962f > 0) {
                i3 = i + 1;
                i2--;
                write(m10761b(cArr[i]));
                i = i3;
            }
            i3 = this.f5961e;
            byte[] bArr = this.f5959c;
            int i4 = this.f5960d;
            int i5 = i2 + i;
            while (i < i5) {
                int i6;
                int i7;
                if (i3 >= i4) {
                    this.f5958b.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i8 = i + 1;
                int i9 = cArr[i];
                if (i9 < 128) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) i9;
                    i9 = i5 - i8;
                    i3 = i4 - i6;
                    if (i9 <= i3) {
                        i3 = i9;
                    }
                    i7 = i3 + i8;
                    i9 = i6;
                    i3 = i8;
                    while (i3 < i7) {
                        i8 = i3 + 1;
                        char c = cArr[i3];
                        if (c < '') {
                            i6 = i9 + 1;
                            bArr[i9] = (byte) c;
                            i9 = i6;
                            i3 = i8;
                        } else {
                            char c2 = c;
                            i3 = i9;
                            i9 = c2;
                        }
                    }
                    i = i3;
                    i3 = i9;
                }
                if (i9 >= 2048) {
                    if (i9 >= 55296 && i9 <= 57343) {
                        if (i9 > 56319) {
                            this.f5961e = i3;
                            m10762c(i9);
                        }
                        this.f5962f = i9;
                        if (i8 >= i5) {
                            break;
                        }
                        i = i8 + 1;
                        i9 = m10761b(cArr[i8]);
                        if (i9 > 1114111) {
                            this.f5961e = i3;
                            m10762c(i9);
                        }
                        i8 = i3 + 1;
                        bArr[i3] = (byte) ((i9 >> 18) | 240);
                        i3 = i8 + 1;
                        bArr[i8] = (byte) (((i9 >> 12) & 63) | 128);
                        i8 = i3 + 1;
                        bArr[i3] = (byte) (((i9 >> 6) & 63) | 128);
                        i3 = i8 + 1;
                        bArr[i8] = (byte) ((i9 & 63) | 128);
                    } else {
                        i6 = i3 + 1;
                        bArr[i3] = (byte) ((i9 >> 12) | 224);
                        i7 = i6 + 1;
                        bArr[i6] = (byte) (((i9 >> 6) & 63) | 128);
                        i3 = i7 + 1;
                        bArr[i7] = (byte) ((i9 & 63) | 128);
                        i = i8;
                    }
                } else {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 6) | 192);
                    i3 = i6 + 1;
                    bArr[i6] = (byte) ((i9 & 63) | 128);
                    i = i8;
                }
            }
            this.f5961e = i3;
        } else if (i2 == 1) {
            write(cArr[i]);
        }
    }

    public final void write(int i) {
        if (this.f5962f > 0) {
            i = m10761b(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                m10762c(i);
            }
            this.f5962f = i;
            return;
        }
        if (this.f5961e >= this.f5960d) {
            this.f5958b.write(this.f5959c, 0, this.f5961e);
            this.f5961e = 0;
        }
        if (i < 128) {
            byte[] bArr = this.f5959c;
            int i2 = this.f5961e;
            this.f5961e = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        int i3 = this.f5961e;
        int i4;
        if (i < 2048) {
            i4 = i3 + 1;
            this.f5959c[i3] = (byte) ((i >> 6) | 192);
            i3 = i4 + 1;
            this.f5959c[i4] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            i4 = i3 + 1;
            this.f5959c[i3] = (byte) ((i >> 12) | 224);
            i2 = i4 + 1;
            this.f5959c[i4] = (byte) (((i >> 6) & 63) | 128);
            i3 = i2 + 1;
            this.f5959c[i2] = (byte) ((i & 63) | 128);
        } else {
            if (i > 1114111) {
                m10762c(i);
            }
            i4 = i3 + 1;
            this.f5959c[i3] = (byte) ((i >> 18) | 240);
            i2 = i4 + 1;
            this.f5959c[i4] = (byte) (((i >> 12) & 63) | 128);
            i4 = i2 + 1;
            this.f5959c[i2] = (byte) (((i >> 6) & 63) | 128);
            i3 = i4 + 1;
            this.f5959c[i4] = (byte) ((i & 63) | 128);
        }
        this.f5961e = i3;
    }

    public final void write(String str) {
        write(str, 0, str.length());
    }

    public final void write(String str, int i, int i2) {
        if (i2 >= 2) {
            int i3;
            if (this.f5962f > 0) {
                i3 = i + 1;
                i2--;
                write(m10761b(str.charAt(i)));
                i = i3;
            }
            i3 = this.f5961e;
            byte[] bArr = this.f5959c;
            int i4 = this.f5960d;
            int i5 = i2 + i;
            while (i < i5) {
                int i6;
                int i7;
                if (i3 >= i4) {
                    this.f5958b.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i8 = i + 1;
                int charAt = str.charAt(i);
                if (charAt < 128) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    charAt = i5 - i8;
                    i3 = i4 - i6;
                    if (charAt <= i3) {
                        i3 = charAt;
                    }
                    i7 = i3 + i8;
                    charAt = i6;
                    i3 = i8;
                    while (i3 < i7) {
                        i8 = i3 + 1;
                        char charAt2 = str.charAt(i3);
                        if (charAt2 < '') {
                            i6 = charAt + 1;
                            bArr[charAt] = (byte) charAt2;
                            charAt = i6;
                            i3 = i8;
                        } else {
                            char c = charAt2;
                            i3 = charAt;
                            charAt = c;
                        }
                    }
                    i = i3;
                    i3 = charAt;
                }
                if (charAt >= 2048) {
                    if (charAt >= 55296 && charAt <= 57343) {
                        if (charAt > 56319) {
                            this.f5961e = i3;
                            m10762c(charAt);
                        }
                        this.f5962f = charAt;
                        if (i8 >= i5) {
                            break;
                        }
                        i = i8 + 1;
                        charAt = m10761b(str.charAt(i8));
                        if (charAt > 1114111) {
                            this.f5961e = i3;
                            m10762c(charAt);
                        }
                        i8 = i3 + 1;
                        bArr[i3] = (byte) ((charAt >> 18) | 240);
                        i3 = i8 + 1;
                        bArr[i8] = (byte) (((charAt >> 12) & 63) | 128);
                        i8 = i3 + 1;
                        bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                        i3 = i8 + 1;
                        bArr[i8] = (byte) ((charAt & 63) | 128);
                    } else {
                        i6 = i3 + 1;
                        bArr[i3] = (byte) ((charAt >> 12) | 224);
                        i7 = i6 + 1;
                        bArr[i6] = (byte) (((charAt >> 6) & 63) | 128);
                        i3 = i7 + 1;
                        bArr[i7] = (byte) ((charAt & 63) | 128);
                        i = i8;
                    }
                } else {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i6 + 1;
                    bArr[i6] = (byte) ((charAt & 63) | 128);
                    i = i8;
                }
            }
            this.f5961e = i3;
        } else if (i2 == 1) {
            write(str.charAt(i));
        }
    }

    private int m10761b(int i) {
        int i2 = this.f5962f;
        this.f5962f = 0;
        if (i >= 56320 && i <= 57343) {
            return (((i2 - 55296) << 10) + 65536) + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    private static void m10762c(int i) {
        throw new IOException(m10760a(i));
    }

    protected static String m10760a(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        }
        if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
    }
}
