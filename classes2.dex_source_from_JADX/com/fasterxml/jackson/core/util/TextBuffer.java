package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.BufferRecycler.CharBufferType;
import java.math.BigDecimal;
import java.util.ArrayList;

/* compiled from: pyma_category */
public final class TextBuffer {
    static final char[] f8617a = new char[0];
    private final BufferRecycler f8618b;
    private char[] f8619c;
    private int f8620d;
    private int f8621e;
    private ArrayList<char[]> f8622f;
    private boolean f8623g = false;
    private int f8624h;
    private char[] f8625i;
    public int f8626j;
    private String f8627k;
    private char[] f8628l;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this.f8618b = bufferRecycler;
    }

    public final void m13299a() {
        if (this.f8618b == null) {
            m13305b();
        } else if (this.f8625i != null) {
            m13305b();
            char[] cArr = this.f8625i;
            this.f8625i = null;
            this.f8618b.m11854a(CharBufferType.TEXT_BUFFER, cArr);
        }
    }

    public final void m13305b() {
        this.f8620d = -1;
        this.f8626j = 0;
        this.f8621e = 0;
        this.f8619c = null;
        this.f8627k = null;
        this.f8628l = null;
        if (this.f8623g) {
            m13297p();
        }
    }

    public final void m13304a(char[] cArr, int i, int i2) {
        this.f8627k = null;
        this.f8628l = null;
        this.f8619c = cArr;
        this.f8620d = i;
        this.f8621e = i2;
        if (this.f8623g) {
            m13297p();
        }
    }

    public final void m13306b(char[] cArr, int i, int i2) {
        this.f8619c = null;
        this.f8620d = -1;
        this.f8621e = 0;
        this.f8627k = null;
        this.f8628l = null;
        if (this.f8623g) {
            m13297p();
        } else if (this.f8625i == null) {
            this.f8625i = m13293b(i2);
        }
        this.f8624h = 0;
        this.f8626j = 0;
        m13308c(cArr, i, i2);
    }

    public final void m13302a(String str) {
        this.f8619c = null;
        this.f8620d = -1;
        this.f8621e = 0;
        this.f8627k = str;
        this.f8628l = null;
        if (this.f8623g) {
            m13297p();
        }
        this.f8626j = 0;
    }

    private char[] m13293b(int i) {
        if (this.f8618b != null) {
            return this.f8618b.m11857a(CharBufferType.TEXT_BUFFER, i);
        }
        return new char[Math.max(i, 1000)];
    }

    private void m13297p() {
        this.f8623g = false;
        this.f8622f.clear();
        this.f8624h = 0;
        this.f8626j = 0;
    }

    public final int m13307c() {
        if (this.f8620d >= 0) {
            return this.f8621e;
        }
        if (this.f8628l != null) {
            return this.f8628l.length;
        }
        if (this.f8627k != null) {
            return this.f8627k.length();
        }
        return this.f8624h + this.f8626j;
    }

    public final int m13309d() {
        return this.f8620d >= 0 ? this.f8620d : 0;
    }

    public final boolean m13310e() {
        if (this.f8620d >= 0 || this.f8628l != null || this.f8627k == null) {
            return true;
        }
        return false;
    }

    public final char[] m13311f() {
        if (this.f8620d >= 0) {
            return this.f8619c;
        }
        if (this.f8628l != null) {
            return this.f8628l;
        }
        if (this.f8627k != null) {
            char[] toCharArray = this.f8627k.toCharArray();
            this.f8628l = toCharArray;
            return toCharArray;
        } else if (this.f8623g) {
            return m13313h();
        } else {
            return this.f8625i;
        }
    }

    public final String m13312g() {
        if (this.f8627k == null) {
            if (this.f8628l != null) {
                this.f8627k = new String(this.f8628l);
            } else if (this.f8620d < 0) {
                int i = this.f8624h;
                int i2 = this.f8626j;
                if (i == 0) {
                    this.f8627k = i2 == 0 ? "" : new String(this.f8625i, 0, i2);
                } else {
                    StringBuilder stringBuilder = new StringBuilder(i + i2);
                    if (this.f8622f != null) {
                        int size = this.f8622f.size();
                        for (i2 = 0; i2 < size; i2++) {
                            char[] cArr = (char[]) this.f8622f.get(i2);
                            stringBuilder.append(cArr, 0, cArr.length);
                        }
                    }
                    stringBuilder.append(this.f8625i, 0, this.f8626j);
                    this.f8627k = stringBuilder.toString();
                }
            } else if (this.f8621e <= 0) {
                String str = "";
                this.f8627k = str;
                return str;
            } else {
                this.f8627k = new String(this.f8619c, this.f8620d, this.f8621e);
            }
        }
        return this.f8627k;
    }

    public final char[] m13313h() {
        char[] cArr = this.f8628l;
        if (cArr != null) {
            return cArr;
        }
        cArr = m13298q();
        this.f8628l = cArr;
        return cArr;
    }

    public final BigDecimal m13314i() {
        if (this.f8628l != null) {
            return new BigDecimal(this.f8628l);
        }
        if (this.f8620d >= 0) {
            return new BigDecimal(this.f8619c, this.f8620d, this.f8621e);
        }
        if (this.f8624h == 0) {
            return new BigDecimal(this.f8625i, 0, this.f8626j);
        }
        return new BigDecimal(m13313h());
    }

    public final double m13315j() {
        return NumberInput.m13446c(m13312g());
    }

    public final void m13300a(char c) {
        if (this.f8620d >= 0) {
            m13294c(16);
        }
        this.f8627k = null;
        this.f8628l = null;
        char[] cArr = this.f8625i;
        if (this.f8626j >= cArr.length) {
            m13295d(1);
            cArr = this.f8625i;
        }
        int i = this.f8626j;
        this.f8626j = i + 1;
        cArr[i] = c;
    }

    public final void m13308c(char[] cArr, int i, int i2) {
        if (this.f8620d >= 0) {
            m13294c(i2);
        }
        this.f8627k = null;
        this.f8628l = null;
        Object obj = this.f8625i;
        int length = obj.length - this.f8626j;
        if (length >= i2) {
            System.arraycopy(cArr, i, obj, this.f8626j, i2);
            this.f8626j += i2;
            return;
        }
        if (length > 0) {
            System.arraycopy(cArr, i, obj, this.f8626j, length);
            i += length;
            i2 -= length;
        }
        do {
            m13295d(i2);
            int min = Math.min(this.f8625i.length, i2);
            System.arraycopy(cArr, i, this.f8625i, 0, min);
            this.f8626j += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public final void m13303a(String str, int i, int i2) {
        if (this.f8620d >= 0) {
            m13294c(i2);
        }
        this.f8627k = null;
        this.f8628l = null;
        char[] cArr = this.f8625i;
        int length = cArr.length - this.f8626j;
        if (length >= i2) {
            str.getChars(i, i + i2, cArr, this.f8626j);
            this.f8626j += i2;
            return;
        }
        if (length > 0) {
            str.getChars(i, i + length, cArr, this.f8626j);
            i2 -= length;
            i += length;
        }
        do {
            m13295d(i2);
            int min = Math.min(this.f8625i.length, i2);
            str.getChars(i, i + min, this.f8625i, 0);
            this.f8626j += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public final char[] m13316k() {
        if (this.f8620d >= 0) {
            m13294c(1);
        } else {
            char[] cArr = this.f8625i;
            if (cArr == null) {
                this.f8625i = m13293b(0);
            } else if (this.f8626j >= cArr.length) {
                m13295d(1);
            }
        }
        return this.f8625i;
    }

    public final char[] m13317l() {
        this.f8620d = -1;
        this.f8626j = 0;
        this.f8621e = 0;
        this.f8619c = null;
        this.f8627k = null;
        this.f8628l = null;
        if (this.f8623g) {
            m13297p();
        }
        char[] cArr = this.f8625i;
        if (cArr != null) {
            return cArr;
        }
        cArr = m13293b(0);
        this.f8625i = cArr;
        return cArr;
    }

    public final int m13318m() {
        return this.f8626j;
    }

    public final void m13301a(int i) {
        this.f8626j = i;
    }

    public final char[] m13319n() {
        if (this.f8622f == null) {
            this.f8622f = new ArrayList();
        }
        this.f8623g = true;
        this.f8622f.add(this.f8625i);
        int length = this.f8625i.length;
        this.f8624h += length;
        char[] cArr = new char[Math.min(length + (length >> 1), 262144)];
        this.f8626j = 0;
        this.f8625i = cArr;
        return cArr;
    }

    public final char[] m13320o() {
        int i;
        Object obj = this.f8625i;
        int length = obj.length;
        if (length == 262144) {
            i = 262145;
        } else {
            i = Math.min(262144, (length >> 1) + length);
        }
        this.f8625i = new char[i];
        System.arraycopy(obj, 0, this.f8625i, 0, length);
        return this.f8625i;
    }

    public final String toString() {
        return m13312g();
    }

    private void m13294c(int i) {
        int i2 = this.f8621e;
        this.f8621e = 0;
        Object obj = this.f8619c;
        this.f8619c = null;
        int i3 = this.f8620d;
        this.f8620d = -1;
        int i4 = i2 + i;
        if (this.f8625i == null || i4 > this.f8625i.length) {
            this.f8625i = m13293b(i4);
        }
        if (i2 > 0) {
            System.arraycopy(obj, i3, this.f8625i, 0, i2);
        }
        this.f8624h = 0;
        this.f8626j = i2;
    }

    private void m13295d(int i) {
        if (this.f8622f == null) {
            this.f8622f = new ArrayList();
        }
        Object obj = this.f8625i;
        this.f8623g = true;
        this.f8622f.add(obj);
        this.f8624h += obj.length;
        int length = obj.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        char[] cArr = new char[Math.min(262144, length + i)];
        this.f8626j = 0;
        this.f8625i = cArr;
    }

    private char[] m13298q() {
        if (this.f8627k != null) {
            return this.f8627k.toCharArray();
        }
        char[] cArr;
        if (this.f8620d < 0) {
            int c = m13307c();
            if (c <= 0) {
                return f8617a;
            }
            Object obj = new char[c];
            if (this.f8622f != null) {
                int size = this.f8622f.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    cArr = (char[]) this.f8622f.get(i2);
                    int length = cArr.length;
                    System.arraycopy(cArr, 0, obj, i, length);
                    i += length;
                }
                c = i;
            } else {
                c = 0;
            }
            System.arraycopy(this.f8625i, 0, obj, c, this.f8626j);
            return obj;
        } else if (this.f8621e <= 0) {
            return f8617a;
        } else {
            cArr = new char[this.f8621e];
            System.arraycopy(this.f8619c, this.f8620d, cArr, 0, this.f8621e);
            return cArr;
        }
    }

    private static char[] m13296e(int i) {
        return new char[i];
    }
}
